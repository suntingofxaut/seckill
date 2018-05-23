package org.seckill.web;

import org.seckill.dao.cache.RedisDao;
import org.seckill.entity.Seckill;
import org.seckill.enums.RedisOptionResult;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cache")
public class cacheController {

    @Autowired
    private SeckillService seckillService;
    @Autowired
    private RedisDao redisDao;

    //批量将mysql数据库数据放入Redis缓存
    @RequestMapping(value = "/puts", method = RequestMethod.GET)
    public String puts() {
        List<Seckill> seckills = seckillService.getSeckillList();
        for (Seckill seckill : seckills) {
            redisDao.putSeckill(seckill);
        }
        return RedisOptionResult.PTUS_SUCCESS.getStateInfo();
    }

    //批量将Redis缓存数据放入mysql数据库
    @RequestMapping(value = "/gets", method = RequestMethod.GET)
    public String gets() {
        List<Seckill> seckills = new ArrayList<Seckill>();
        for (int i = 0; i < 100; i++) {
            Seckill seckill = redisDao.getSeckill(1000 + i);
            if (seckill != null) {
                seckills.add(seckill);
            }
        }
        for (Seckill seckill : seckills) {
            Seckill seckillTem = seckillService.getById(seckill.getSeckillId());
            if (seckillTem == null) {
                seckillService.updateSeckillGood(seckill);
            } else {
                if (compare(seckill, seckillTem)) {
                    seckillService.addSeckillGood(seckill);
                }
            }
        }
        return RedisOptionResult.GETS_SUCCESS.getStateInfo();
    }

    private boolean compare(Seckill seckill1, Seckill seckill2) {
        if (seckill1.getNumber() == seckill2.getNumber()) {
            if (seckill1.getSeckillId() == seckill2.getSeckillId()) {
                if (seckill1.getName().equals(seckill2.getName())) {
                    if (seckill1.getStartTime() == seckill2.getStartTime()) {
                        if (seckill1.getEndTime() == seckill2.getEndTime()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
