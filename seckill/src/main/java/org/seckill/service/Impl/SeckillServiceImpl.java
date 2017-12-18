package org.seckill.service.Impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillExeception;
import org.seckill.exception.SeckillCloseExeception;
import org.seckill.exception.SeckillExecption;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;
    //加入混淆盐值,随机
    public final String salt = "asdaksjdn2342#$%%#$^wqwe@#!@#$#@%$^%6!@#SAFSG^#$%";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 10);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(),
                    endTime.getTime());
        }
        //特定字符串转化过程，不可逆。
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }
    @Transactional
    public SeckillExecution executeSeckil(long seckillId, long userphone, String md5)
            throws SeckillExecption, RepeatKillExeception, SeckillCloseExeception {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillExecption("SecKill data was rewrited！");
        }
        try {
            //执行秒杀逻辑
            Date nowTime = new Date();
            //减库存
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新操作，秒杀结束
                throw new SeckillCloseExeception("Seckill is closed!");
            } else {
                //减库存成功，记录购买行为
                int insertCount = successKilledDao.insertSuccessKilled(seckillId, userphone);
                //唯一:seckillId和userphone
                if (insertCount <= 0) {
                    //重复秒杀
                    throw new RepeatKillExeception("seckill repeat!");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userphone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseExeception e1) {
            throw e1;
        } catch (RepeatKillExeception e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            //所有编译期异常转化为运行起异常
            throw new SeckillExecption("seckill inner error!" + e.getMessage());
        }
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
