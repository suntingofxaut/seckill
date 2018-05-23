package org.seckill.service.Impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seller;
import org.seckill.entity.User;
import org.seckill.service.SellerService;
import org.seckill.service.UserService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Resource
    private SellerService sellerService;

    @Test
    public void getCount() throws Exception {
        User user = new User();
        user.setName("1");
        user.setPassword("1");
        System.out.println(userService.getCount(user));
    }

    @Test
    public void getCount1() throws Exception {
        Seller seller = new Seller();
        seller.setName("1");
        seller.setPassword("1");
        System.out.println(sellerService.getCount(seller));
    }
}