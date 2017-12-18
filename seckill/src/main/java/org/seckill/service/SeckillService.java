package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillExeception;
import org.seckill.exception.SeckillCloseExeception;
import org.seckill.exception.SeckillExecption;

import java.util.List;

/**
 * 业务接口：站在“使用者”的角度设计接口
 * 方面：方法定义粒度、参数、返回值
 *
 * @author 孙挺
 * @version 0.0.1
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId id
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口的地址，否则输出系统时间和开启时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckil(long seckillId, long userphone, String md5)
            throws SeckillExecption,RepeatKillExeception,SeckillCloseExeception;


}
