package com.jxau.data.test;

import java.util.Scanner;

public class ArrayQueueDemo {
    //测试一把
    //创建一个队列
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.listQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.showHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }

}


// 使用数组模拟队列-编写一个ArrayQueue类

/***
 * @fjw
 * 队列先进先出，队列头与队列尾
 * 从尾入，从头出
 */
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    public ArrayQueue(int arrmaxSize) {//创建队列的构造器
        maxSize = arrmaxSize;
        front = -1;//指向队列头前一节点位置
        rear = -1;//指向队列尾
        arr = new int[maxSize];
    }

    //判断队列是否空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear ==  maxSize-1;
    }

    //向队列存入数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能存入数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //从队列取数据
    public int getQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空，不能取数据");
        int a = arr[front + 1];
        front++;
        return a;
    }

    //显示队列的所有数据
    public void listQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int a = 0; a < arr.length; a++)
            System.out.printf("arr[%d]=%d\n", a, arr[a]);
    }

    //显示头数据
    public int showHead() {
        if (isEmpty())
            throw new RuntimeException("队列空，没有数据");
        return arr[front + 1];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }
}