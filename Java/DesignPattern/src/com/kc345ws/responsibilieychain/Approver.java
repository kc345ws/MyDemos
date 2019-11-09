package com.kc345ws.responsibilieychain;

public abstract class Approver {
    Approver approver;//下一个处理者
    String name;

    public Approver(String name){
        this.name = name;
    }

    public Approver getApprover() {
        return approver;
    }

    //下一个处理着
    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //处理审批请求方法，处理子类完成
    public abstract  void processReusuest(PurchassRequest purchassRequest);
}
