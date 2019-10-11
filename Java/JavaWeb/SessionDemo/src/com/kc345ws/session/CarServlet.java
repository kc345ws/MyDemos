package com.kc345ws.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//购物车
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        String[] products = {"商品0","商品1","商品2","商品3","商品4","商品5",};
        String name = products[Integer.parseInt(id)];

        Map<String,Integer> cartMap = (Map<String, Integer>) req.getSession().getAttribute("cart");

        //如果第一次访问
        if(cartMap == null){
            cartMap = new HashMap<>();
            req.getSession().setAttribute("cart",cartMap);
        }



        if(cartMap.containsKey(name)){
            //如果已经购买了
            int count = cartMap.get(name);
            cartMap.put(name,++count);
        }else{
            cartMap.put(name,1);
        }
        req.getSession().setAttribute("cart",cartMap);

        resp.getWriter().write("<a href='product_list.jsp'><h2>继续购物</h2></a>");
        resp.getWriter().write("<a href='cart.jsp'><h2>取购物车结算</h2></a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
