package org.seckill.web;

import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.*;
import org.seckill.enums.GoodState;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillExeception;
import org.seckill.exception.SeckillCloseExeception;
import org.seckill.service.SeckillService;
import org.seckill.service.SellerService;
import org.seckill.service.SuccessKilledService;
import org.seckill.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;
    @Autowired
    private UserService userService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private SuccessKilledService successKilledService;

    private Long seckillIdtmp;

    Long userPhone1 =18309299185L;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        List<SuccessKilled> successKilleds = successKilledService.queryByUserPhone(userPhone1);
        System.out.println(successKilleds);
        for (Seckill seckill : list) {
            if (seckill.getStartTime().getTime() > new Date().getTime()){
                seckill.setState(GoodState.NOTSTART.getStateInfo());
            }else if (seckill.getEndTime().getTime() < new Date().getTime()){
                seckill.setState(GoodState.END.getStateInfo());
            }else {
                for (SuccessKilled successKilled : successKilleds) {
                    if(seckill.getSeckillId() == successKilled.getSeckillId()){
                        seckill.setState(GoodState.SECKILLED.getStateInfo());
                    }
                }
                if (seckill.getState() == null){
                    seckill.setState(GoodState.DOING.getStateInfo());
                }
            }
        }
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/listSeller", method = RequestMethod.GET)
    public String listSeller(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        for (Seckill seckill : list) {
            if (seckill.getStartTime().getTime() > new Date().getTime()) {
                seckill.setState(GoodState.NOTSTART.getStateInfo());
            } else if (seckill.getEndTime().getTime() < new Date().getTime()) {
                seckill.setState(GoodState.END.getStateInfo());
            }else{
                seckill.setState(GoodState.DOING.getStateInfo());
            }
        }
        model.addAttribute("list", list);
        return "listSeller";
    }

    @RequestMapping(value = "/personalCenter", method = RequestMethod.GET )
    public String personalCenter(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        List<SuccessKilled> successKilleds = successKilledService.queryByUserPhone(userPhone1);
        List<PersonalGood> personalGoods = new ArrayList<PersonalGood>();
        for(SuccessKilled successKilled :successKilleds){
            for (Seckill seckill : list){
                if (successKilled.getSeckillId() == seckill.getSeckillId()) {
                    PersonalGood personalGood = new PersonalGood();
                    personalGood.setSeckillId(seckill.getSeckillId());
                    personalGood.setName(seckill.getName());
                    personalGood.setNumber(1);
                    personalGood.setCreateTime(successKilled.getCreateTime());
                    personalGood.setState("成功");
                    personalGoods.add(personalGood);
                }
            }
        }
        model.addAttribute("list", personalGoods);
        return "personalCenter";
    }

    @RequestMapping(value = "/{seckillId}/modify", method = {RequestMethod.GET , RequestMethod.POST })
    public String modify(@PathVariable("seckillId") Long seckillId){
        seckillIdtmp = seckillId;
        return "modifyGood";
    }

    @RequestMapping(value = "/{seckillId}/modifyGoodH" ,method = RequestMethod.POST)
    public String modifyGoodH(@RequestBody Seckill seckill ){
        seckill.setSeckillId(seckillIdtmp);
        System.out.println("修改商品："+seckill.toString());
        seckillService.updateSeckillGood(seckill);
        return "redirect:/seckill/listSeller";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET , RequestMethod.POST })
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/userlogin", method =  {RequestMethod.GET , RequestMethod.POST } )
    public String userlogin(@RequestBody User user ){
        System.out.println("前端传来的买家账号信息："+user.toString());
        Integer count = userService.getCount(user);
        System.out.println("买家用户名密码匹配条数查询结果："+count.toString());
        return count.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/sellerlogin", method = {RequestMethod.GET , RequestMethod.POST } )
    public String sellerlogin(@RequestBody Seller seller ){
        System.out.println("前端传来的卖家账号信息："+seller.toString());
        Integer count = sellerService.getCount(seller);
        System.out.println("管理员用户名密码匹配条数查询结果："+count.toString());
        return count.toString();
    }

    @RequestMapping(value = "/{seckillId}/delete" ,method = RequestMethod.GET)
    public String delete(@PathVariable("seckillId") Long seckillId){
        seckillService.deleteSeckillGoodById(seckillId.intValue());
        return "redirect:/seckill/listSeller";
    }

    @RequestMapping(value = "/add" ,method = {RequestMethod.GET , RequestMethod.POST })
    public String add(){
        return "addGood";
    }

    @RequestMapping(value = "/addGoodH" ,method = RequestMethod.POST)
    public String addGoodH(@RequestBody Seckill seckill ){
        System.out.println("添加商品："+seckill.toString());
        seckillService.addSeckillGood(seckill);
        return "redirect:/seckill/listSeller";
    }

    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    public String detail(Model model,
                         @PathVariable("seckillId") Long seckillId) {
        if (seckillId == null) {
            return "redirect:/seckill/list";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }
    //ajax  json
    @ResponseBody
    @RequestMapping(value = "/{seckillId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {

        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "userPhone",required = false) Long userPhone) {

        if(userPhone==null){
            return new SeckillResult<SeckillExecution>(false ,"未注册");
        }
        userPhone1 = userPhone;
        try {
            SeckillExecution execution = seckillService.executeSeckil(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        }
        catch (RepeatKillExeception e){
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true,execution);
        }catch(SeckillCloseExeception e){
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true,execution);
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true,execution);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    public SeckillResult<Long > time(){
        Date date = new Date();
        return new SeckillResult(true,date);
    }
}
