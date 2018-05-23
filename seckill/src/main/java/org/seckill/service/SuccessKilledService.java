package org.seckill.service;

import org.seckill.entity.SuccessKilled;

import java.util.List;

public interface SuccessKilledService {
    List<SuccessKilled> queryByUserPhone(long userPhone);
}
