package com.GuangGuangLi.controller;


import com.GuangGuangLi.controller.validation.ValidGroup1;
import com.GuangGuangLi.entity.*;
import com.GuangGuangLi.exception.CustomException;
import com.GuangGuangLi.service.IorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/orders")
@Controller
public class OrdersMapperController {


    @Autowired
    private IorderService iorderService;


    /**
     * 确定查询的主表：订单表
     * 确定查询的关联表：用户表
     * 	关联查询使用内链接？还是外链接？
     * 	由于orders表中有一个外键（user_id），通过外键关联查询用户表只能查询出一条记录，可以使用内链接。
     *
     * SELECT
     *   orders.*,
     *   USER.username,
     *   USER.sex,
     *   USER.address
     * FROM
     *   orders,
     *   USER
     * WHERE orders.user_id = user.id
     *
     * 使用resultType为OrdersCustom 显示的信息只有orders表的信息
     * Orders{id=3, userId=0, number='1000010', createtime=Wed Feb 04 13:22:35 CST 2015, note='null'}
     * Orders{id=4, userId=0, number='1000011', createtime=Tue Feb 03 13:22:41 CST 2015, note='null'}
     * Orders{id=5, userId=0, number='1000012', createtime=Thu Feb 12 16:13:23 CST 2015, note='null'}
     */
    @RequestMapping(value = "/findOrdersUser",method = RequestMethod.GET)
    public void findOrdersUser(){

        List<OrdersCustom> ordersUser = iorderService.findOrdersUser();
        Orders orders = new OrdersCustom();

        for (OrdersCustom ordersCustom:ordersUser){
            System.out.println( ordersCustom.getId() + "-" + ordersCustom.getUserId() + ordersCustom.getNumber() + "-" + ordersCustom.getCreatetime() + "-" + ordersCustom.getNote() + "||" + ordersCustom.toString());
        }


    }

    /**
     *  使用resultMap映射的思路
     *  使用resultMap将查询结果中的订单信息映射到Orders对象中，在orders类中添加User属性，将关联查询出来的用户信息映射到orders对象中的user属性中
     *
     *  1:在Orders类中添加UserInfo的属性
     */

    @RequestMapping(value = "/findOrdersUserResultMap",method = RequestMethod.GET)
    public void findOrdersUserResultMap(){

        List<Orders> userResultMap = iorderService.findOrdersUserResultMap();
        for (Orders orders:userResultMap){
            System.out.println(orders.getId() + "-" + orders.getUserId() + "-" + orders.getNumber() + "- " + orders.getCreatetime()
            + "-" + orders.getNote() + "| |" + orders.getUserInfo().toString());
        }

    }

    /**
     *  一对多查询
     * 查询订单及订单明细的信息。
     *
     * 确定主查询表：订单表
     * 确定关联查询表：订单明细表
     * 在一对一查询基础上添加订单明细表关联即可。
     *
     * SELECT
     *   orders.*,
     *   USER.username,
     *   USER.sex,
     *   USER.address,
     *   orderdetail.id orderdetail_id,
     *   orderdetail.items_id,
     *   orderdetail.items_num,
     *   orderdetail.orders_id
     * FROM
     *   orders,
     *   USER,
     *   orderdetail
     * WHERE orders.user_id = user.id AND orderdetail.orders_id=orders.id
     *
     *
     * 要求：
     * 对orders映射不能出现重复记录。
     *
     * 在orders.java类中添加List<orderDetail> orderDetails属性。
     * 最终会将订单信息映射到orders中，订单所对应的订单明细映射到orders中的orderDetails属性中。
     *
     *
     */

    @RequestMapping(value = "/findOrdersAndOrderDetailResultMap",method = RequestMethod.GET)
    public void findOrdersAndOrderDetailResultMap(){

        List<Orders> resultMap = iorderService.findOrdersAndOrderDetailResultMap();
        for (Orders orders:resultMap){
            System.out.println(orders.getId() + "-" + orders.getUserId() + "-" + orders.getNumber() + "- " + orders.getCreatetime()
                    + "-" + orders.getNote() + "| |" + orders.getUserInfo().toString() + ">>" + orders.getOrderdetails().toString());
        }

    }

    /**
     * 多对多查询
     *
     *
     * 查询用户 及用户 购买 商品 信息。
     *
     * 查询主表是：用户表
     * 关联表：由于用户和商品没有直接关联，通过订单和订单明细进行关联，所以关联表：
     * orders、orderdetail、items
     *
     * 思路
     * 将用户信息映射到user中。
     * 在user类中添加订单列表属性List<Orders> orderslist，将用户创建的订单映射到orderslist
     * 在Orders中添加订单明细列表属性List<OrderDetail>orderdetials，将订单的明细映射到orderdetials
     * 在OrderDetail中添加Items属性，将订单明细所对应的商品映射到Items
     *
     * SELECT
     *   orders.*,
     *   USER.username,
     *   USER.sex,
     *   USER.address,
     *   orderdetail.id orderdetail_id,
     *   orderdetail.items_id,
     *   orderdetail.items_num,
     *   orderdetail.orders_id,
     *   items.name items_name,
     *   items.detail items_detail,
     *   items.price items_price
     * FROM
     *   orders,
     *   USER,
     *   orderdetail,
     *   items
     * WHERE orders.user_id = user.id AND orderdetail.orders_id=orders.id AND orderdetail.items_id = items.id
     */


    @RequestMapping(value = "/findUserAndItemsResultMap",method = RequestMethod.GET)
    public void findUserAndItemsResultMap(){

        List<UserInfo> userItemsResultMap = iorderService.findUserAndItemsResultMap();
        for (UserInfo info:userItemsResultMap){
            for (Orders order: info.getOrdersList()){
                for ( Orderdetail orderdetail:order.getOrderdetails()){
                    System.out.println("userInfo" + info.getId() + ">>" + info.getUsername() + "order>>" + order.getId() + "ordetail>>" + orderdetail.getItems().toString());
                }

            }

        }


    }

    @RequestMapping(value = "/findItems",method = RequestMethod.GET)
    public ModelAndView findItems(@RequestParam (value ="items_id") int items_id){

        ItemsCustom itemsCustom = iorderService.findItems(items_id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustom",itemsCustom);
        modelAndView.setViewName("/orders/findItems");
        return modelAndView;


    }

    /**
     * 添加商品分类
     *
     * itemsType表示最终将方法返回值放在request中的key
     */
    @ModelAttribute(value = "itemsType")
    public Map<String,String> getItemsType(){
        Map<String,String> itemsType = new HashMap<>();
        itemsType.put("101","数码");
        itemsType.put("102","母婴");
        return itemsType;

    }


    /**
     * 商品查询controller方法中实现商品查询条件传入。
     * 请求接口 包装类型的pojo参数类型绑定
     *
     *
     * @param itemsQueryVo
     * @return
     */
    @RequestMapping(value = "/queryItems")
    public ModelAndView queryItems(ItemsQueryVo itemsQueryVo){
        List<ItemsCustom> itemsCustomList = iorderService.queryItems(itemsQueryVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsCustomList",itemsCustomList);
        modelAndView.setViewName("orders/findItems");
        return modelAndView;

    }

    /**
     *  数组绑定
     *  商品批量删除，用户在页面选择多个商品，批量删除
     */

    @RequestMapping(value = "/deleteItems")
    public String deleteItems(Integer[] items_id){
        //方法层暂不实现
        return "items/success";
    }

    //使用RESTful形式查询商品信息 输出json格式数据

    /**
     *
     * @param id
     * @return
     * /jsonItemsView/{id}中的id表示占位符，通过@PathVariable获取占位符中的参数，如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
     */

//    @RequestMapping("/jsonItemsView/{id}")
//    public @ResponseBody ItemsCustom jsonItemsView(@PathVariable("id") int id){
//        ItemsCustom itemsCustom = iorderService.findItems(id);
//        return itemsCustom;
//
//    }

    /**
     * 商品信息修改页面
     */
    @RequestMapping(value = "/editItems")
    public String editItems(Model model,@RequestParam(value="id" ,required = true) Integer items_id) throws CustomException {
        //调用service根据商品id查询商品信息
        ItemsCustom itemsCustom = iorderService.findItems(items_id);

        //判断商品是否为空，根据id没有差选到商品，抛出异常，提示用户商品信息不存在
        if(itemsCustom == null){
            throw new CustomException("修改的商品信息不存在");
        }

        //商品信息插入到形参
        model.addAttribute("itemsCustom",itemsCustom);

        //返回逻辑试图名称
        return "/orders/editItems";


    }

    /**
     * 商品信息修改批量提交
     *
     *
     *
     * itemsCustom包装类中的参数是由页面editItems.jsp传递过来的，其中形式参数的绑定 jsp中的name要和pojo中参数的对应关系对应正确
     *
     * 数据回显
     * ModelAttribute可以指定pojo回显到页面在request中的key
     */
    @RequestMapping(value = "/editItemsSubmit",method = RequestMethod.POST)
    public String editItemsSubmit(Model model, Integer id,
                                  @ModelAttribute("itemsCustom")
                                  @Validated(value = {ValidGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult){
//    public String editItemsSubmit(Model model, Integer id,HttpServletRequest request, ItemsCustom itemsCustom){

        //获取校验错误信息
        if(bindingResult.hasErrors()){
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError:allErrors){
                System.out.println(objectError.getDefaultMessage());
            }

            //将错误信息传到页面
          model.addAttribute("allErrors",allErrors);
          //可以直接使用model将提交pojo回显到页面  页面上pojo的类型是itemsCustom
          model.addAttribute("itemsCustom",itemsCustom);

          //出错重回到商品修改页面
          return "/orders/editItems";



        }


        iorderService.updateItems(id,itemsCustom);

        //重定向到商品查询列表页面
        //return "redirect:queryItems.action";

        //页面转发
        //return "forward:queryItems.action";

        return "/items/success";




    }








}
