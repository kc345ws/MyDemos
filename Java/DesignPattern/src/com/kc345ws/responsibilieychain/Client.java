package com.kc345ws.responsibilieychain;

public class Client {
    public static void main(String[]args){
        //创建请求对象
        final PurchassRequest purchassRequest = new PurchassRequest(1, 6000, 1);

        //创建处理者
        final DeparetmentApprover deparetmentApprover = new DeparetmentApprover("系主任");
        final CollegeApprover collegeApprover = new CollegeApprover("院长");
        final SchoolApprover schoolApprover = new SchoolApprover("校长");

        //设置下一个处理者
        deparetmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(schoolApprover);

        deparetmentApprover.processReusuest(purchassRequest);

    }
}
