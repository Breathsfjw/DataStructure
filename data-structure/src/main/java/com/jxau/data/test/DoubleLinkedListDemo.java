package com.jxau.data.test;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByNO(hero1);
        doubleLinkedList.addByNO(hero4);
        doubleLinkedList.addByNO(hero3);
        doubleLinkedList.addByNO(hero2);
        doubleLinkedList.addByNO(hero2);
        doubleLinkedList.list();
        System.out.println("双向链表的删除节点测试");
        doubleLinkedList.del(4);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public void add(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode2;
        heroNode2.pre = temp;
    }

    public void addByNO(HeroNode2 heroNode2) {
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
        HeroNode2 temp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break; //
            }
            if (temp.next.no > heroNode2.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode2.no) {//说明希望添加的heroNode的编号已然存在

                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
        //判断flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode2.no);
        } else {
            //插入到链表中, temp的后面
            if (temp.next != null) {
                temp.next.pre = heroNode2;
            }
            heroNode2.next = temp.next;
            temp.next = heroNode2;
            heroNode2.pre = temp;

        }
    }

    public void del(int index) {
        HeroNode2 temp = head;
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
            if (temp.next.next == null) {
                temp.next = null;

            } else {
                temp.next.next.pre = temp;
                temp.next = temp.next.next;
            }


        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能删除\n", index);
        }
    }

    public void update(HeroNode2 heroNode2) {
        HeroNode2 temp = head;

        if (temp.next == null) {
            System.out.println("链表为空");
        }

        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name=heroNode2.name;
            temp.next.nickName=heroNode2.nickName;
        }else {
            System.out.printf("链表中无编号为 %d 的节点,无法修改\n",heroNode2.no);
        }
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.toString());
        }
    }
}

class HeroNode2 {
    public int no;
    public String nickName;
    public String name;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String nickName, String name) {
        this.no = no;
        this.nickName = nickName;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}