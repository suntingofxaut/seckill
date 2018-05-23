package org.seckill.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillServiceImplTest {

    private SeckillServiceImpl seckillService;

    @Test
    public void getSeckillList() throws Exception {
    }

    @Test
    public void getById() throws Exception {
    }

    @Test
    public void exportSeckillUrl() throws Exception {
    }

    @Test
    public void executeSeckil() throws Exception {
    }

    @Test
    public void addSeckillGood() throws Exception {
        Seckill seckill = new Seckill();
        seckill.setName("nihaoh");
        seckill.setNumber(123);
        seckill.setStartTime(new Date(0));
        seckill.setEndTime(new Date(0));

        System.out.println(seckillService.addSeckillGood(seckill));
    }

    @Test
    public void updateSeckillGood() throws Exception {
    }

    @Test
    public void deleteSeckillGoodById() throws Exception {
    }

}