package com.jxau.data.test;

public class Josepfu {
    public static void main(String[] args) {

    }
}
class CircleSingleLinkedList{
    private Boy first=null;

    public void addBoy(int num){
        if (num<=0){
            System.out.println("nums的值不正确");
            return;
        }
        Boy curBoy = null;
        for (int i=1;i<=num;i++){
            Boy boy = new Boy(i);
            if (num==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }

    }
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        boolean flag=false;
        Boy curBoy=first;
        while (true){
            if (curBoy.getNext()==first){
                break;
            }
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            curBoy=curBoy.getNext();
        }
    }
}
class Boy{
    private int no;// 编号
    private Boy next; // 指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}