package com.jxau.data.test;


import java.util.Stack;

public class SimpleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//
//        // 测试一下单链表的反转功能
//        System.out.println("原来链表的情况~~");
//        singleLinkedList.list();
        singleLinkedList.addByNO(hero1);
        singleLinkedList.addByNO(hero4);
        singleLinkedList.addByNO(hero2);
        singleLinkedList.addByNO(hero3);
        singleLinkedList.addByNO(hero3);
        System.out.println("排序后链表的情况~~");
        singleLinkedList.list();
        System.out.println("更新后链表的情况~~");
        singleLinkedList.update(new HeroNode(3, "白起", "杀神"));
        singleLinkedList.list();
        System.out.println("删除后链表的情况~~");
        singleLinkedList.del(3);
        singleLinkedList.list();
        System.out.println("获取链表长度的情况~~");
        System.out.println(getLength(hero1));
        System.out.println(getLength1(hero1));
        System.out.println("倒数第一个节点~~");
        System.out.println(findLastIndexNode(hero1, 0));
        System.out.println("反转后的节点~~");
        reversetList(hero1);
        singleLinkedList.list();
    }

    public static int getLength(HeroNode heroNode) {
        if (heroNode.next == null) {
            return 0;
        }
        int count = 1;
        //定义一个辅助的变量, 这里我们统计了头节点
        HeroNode cur = heroNode;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public static int getLength1(HeroNode head) {
        if (head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量, 这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next; //遍历
        }
        return length;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }
        int size = getLength1(head);
        boolean b = false;
        if (index <= 0 || index > size) {
            System.out.println("角标过界");
            return null;
        }
        int lastIndex = size - index + 1;
        int a = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            a++;
            if (a == lastIndex) {
                b = true;
                break;
            }
            temp = temp.next;

        }

        return temp;

    }

    public static void reversetList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode rever = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        while (temp != null) {
            HeroNode next = temp.next;
            temp.next = rever.next;
            rever.next = temp;
            temp = next;
        }
        head.next = rever.next;
    }
    public static void reversePrint(HeroNode head) {
        if (head.next == null ) {
            System.out.println("链表为空,无法打印");
            return;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode temp=head.next;
        while (temp!=null){
           stack.push(temp);
           temp=temp.next;
        }
        while (stack.size()>0){
            System.out.print(stack.pop());
        }
    }
}

class SingleLinkedList {


    private HeroNode headNode = new HeroNode(0, "", "");

    public HeroNode getHeadNode() {
        return headNode;
    }


    public void add(HeroNode heroNode) {
        HeroNode temp = headNode;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByNO(HeroNode heroNode) {
//        HeroNode temp = headNode;
//        boolean b = false;
//        while (true) {
//            if (temp.next==null){
//                b = true;
//                break;
//            }
//            int a = temp.next.no;
//            if (a > heroNode.no) {
//                if (temp.no != heroNode.no) {
//                    b = true;
//                    break;
//                }else {
//                    break;
//                }
//
//            }
//            temp = temp.next;
//
//        }
//        if (b){
//            heroNode.next = temp.next;
//            temp.next = heroNode;
//        }else{ //不能添加，说明编号存在
//            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
//        }
//因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = headNode;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break; //
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在

                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }


    public void list() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = headNode;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.toString());
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = headNode;
        boolean b = false;
        if (temp.next == null) {
            System.out.println("链表为空，无法更新");
            return;
        }
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                b = true;
                break;
            }
            temp = temp.next;
        }
        if (b) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    public void del(int index) {
        HeroNode temp = headNode;
        if (temp.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == index) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能删除\n", index);
        }
    }
}

class HeroNode {
    public int no;
    public String nickName;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String nickName, String name) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}