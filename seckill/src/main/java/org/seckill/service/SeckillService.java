package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExeception;
import org.seckill.exception.SeckillCloseExeception;
import org.seckill.exception.SeckillExecption;

import java.util.List;

/**
 * @author 孙挺
 * @version 0.0.1
 */
public interface SeckillService {
    /**
     * 查询所有抢购记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个抢购记录
     *
     * @param seckillId id
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 抢购开启时输出抢购接口的地址，否则输出系统时间和开启时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckil(long seckillId, long userphone, String md5)
            throws SeckillExecption,RepeatKillExeception,SeckillCloseExeception;

    int addSeckillGood (Seckill seckill);

    int updateSeckillGood (Seckill seckill);

    void deleteSeckillGoodById (Integer id);
}
