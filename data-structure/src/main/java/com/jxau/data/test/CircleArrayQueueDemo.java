package com.jxau.data.test;

import java.util.Scanner;

/**
 *
 * @author fjw
 * 用数组模拟环形队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
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

class CircleArray {
    private int maxSize;//定义数组最大长度
    private int front;//指向队列头，初始值为0
    private int rear;//指向队列尾后一位置，初始值为0
    private int[] arr;//用以存放数据

    public CircleArray(int maxsize) {
       maxSize = maxsize;
        arr = new int[maxsize];
    }

    //判断队列是否空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //向队列存入数据
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能存入数据");
            return;
        }

        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //从队列取数据
    public int getQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空，不能取数据");
        int a = arr[front];
        front = (front + 1) % maxSize;
        return a;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //显示头数据
    public int headQueue() {
        if (isEmpty())
            throw new RuntimeException("队列空，没有数据");
        return arr[front % maxSize];
    }
}