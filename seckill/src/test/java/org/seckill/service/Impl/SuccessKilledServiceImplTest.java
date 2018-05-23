package org.seckill.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.service.SuccessKilledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledServiceImplTest {

    @Autowired
    private SuccessKilledService successKilledService;

    @Test
    public void queryByUserPhone() throws Exception {
        System.out.println(successKilledService.queryByUserPhone(12312312312L));
    }

}