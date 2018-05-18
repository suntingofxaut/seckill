package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;

/**
 *
 */
public interface SuccessKilledDao {
    /**
     * 插入购买明细，可过滤重复购买
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId , @Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled并携带产品抢购对象
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("secKillId")long seckillId,@Param("userPhone")long userPhone);
}
