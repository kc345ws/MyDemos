package com.kc345ws.flyweight;

public class Client {
    public static void main(String[]args){
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        //新闻形式
        WebSite webSite  = webSiteFactory.getWebsiteCatrgory("新闻");
        webSite.use(new User("倪司令"));

        //博客信息
        WebSite webSite1 = webSiteFactory.getWebsiteCatrgory("博客");
        webSite1.use(new User("陈主席"));

        WebSite webSite2 = webSiteFactory.getWebsiteCatrgory("博客");
        webSite2.use(new User("付刍仑"));

        WebSite webSite3 = webSiteFactory.getWebsiteCatrgory("博客");
        webSite3.use(new User("阿斯顿马丁"));

        //网站的分类总共有几种
        System.out.println("网站形式:"+ webSiteFactory.getWebSiteCount());
    }
}
