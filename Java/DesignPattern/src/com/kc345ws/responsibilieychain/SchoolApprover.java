package com.kc345ws.responsibilieychain;

public class SchoolApprover extends Approver {

    public SchoolApprover(String name) {
        super(name);
    }

    @Override
    public void processReusuest(PurchassRequest purchassRequest) {
        if(purchassRequest.getPrice() > 10000){
            System.out.println("请求编号 id = "+purchassRequest.getId() +"被 "+this.name +"处理");
        }
        else{
            this.approver.processReusuest(purchassRequest);//处理不了 则交给下一个人处理
        }
    }
}
