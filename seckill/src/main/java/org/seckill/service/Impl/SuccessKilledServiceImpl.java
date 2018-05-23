package org.seckill.service.Impl;

import org.seckill.dao.SuccessKilledDao;
import org.seckill.entity.SuccessKilled;
import org.seckill.service.SuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuccessKilledServiceImpl implements SuccessKilledService {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Override
    public List<SuccessKilled> queryByUserPhone(long userPhone) {
        return successKilledDao.queryByUserPhone(userPhone);
    }
}
