package com.kc345ws.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        //业务代码
        ModelAndView mv = new ModelAndView();
        String result = "HelloSpringMVC";
        mv.addObject("msg",result);//将数据添加到ModelAndView中
        //跳转视图
        mv.setViewName("test");//跳转到test.jsp页面
        return mv;
    }
}
