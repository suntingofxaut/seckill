package org.seckill.service.Impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SellerDao;
import org.seckill.entity.Seller;
import org.seckill.service.SellerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerDao sellerDao;

    @Override
    public int getCount(Seller seller) {
        return sellerDao.getCount(seller);
    }
}
