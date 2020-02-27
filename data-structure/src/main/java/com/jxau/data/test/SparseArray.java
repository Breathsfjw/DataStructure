package com.jxau.data.test;

public class SparseArray {
    /***
     * @author fjw
     *以数组模拟棋盘问题，
     * 并对数据存储使用稀疏数组进行优化
     */
    public static void main(String[] args) {

        //创建一个原始的二维数组12*12
        // 0:表示没有棋子，1表示黑子 2表白子
        int chessArr[][] = new int[12][12];
        chessArr[1][1] = 1;
        chessArr[5][6] = 2;
        chessArr[7][9] = 1;
        chessArr[5][9] = 2;
        /*** for循环遍历输出 */
        getChessArr1(chessArr);
        getChessArr2(chessArr);
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int[][] spareArr = getSpareArr(chessArr);
//        spareToArrs(spareArr);
//        getChessArr1(spareToArr);
    }
    //将稀疏数组 --》 恢复成 原始的二维数组
		/*思路：
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

    //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
    public static void spareToArrs(int[][] spareArr) {
        int a = spareArr[0][0];
        int b = spareArr[0][1];
        int spareToArr[][] = new int[a][b];
        for (int c = 1; c < spareArr.length; c++) {
            spareToArr[spareArr[c][0]][spareArr[c][1]] = spareArr[c][2];
        }
        //输出转化后的二维数组
        for (int[] brr : spareToArr) {
            for (int data : brr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    //二维数组转稀疏数组
    public static int[][] getSpareArr(int[][] chessArr) {

        //sum 二维数组中非零值个数
        int sum = 0;
        for (int a = 0; a < chessArr.length; a++) {
            for (int b = 0; b < chessArr[a].length; b++) {
                if (chessArr[a][b] != 0)
                    sum += 1;
            }
        }
        //遍历二维数组中有效值将其坐标与值存入稀疏数组
        int spareArr[][] = new int[sum + 1][3];
        spareArr[0][0] = chessArr[0].length;
        spareArr[0][1] = chessArr.length;
        int index = 0;
        for (int a = 0; a < chessArr.length; a++) {
            for (int b = 0; b < chessArr[a].length; b++) {
                if (chessArr[a][b] != 0) {
                    index++;
                    spareArr[index][0] = a;
                    spareArr[index][1] = b;
                    spareArr[index][2] = chessArr[a][b];
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int[] brr : spareArr) {
            for (int data : brr) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        return spareArr;
    }

    public static void getChessArr2(int[][] chessArr) {
        /** Foreach循环遍历输出 */
        System.out.println("以第二种方式输出原始数组");
        for (int[] brr : chessArr) {
            for (int i : brr) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

    public static void getChessArr1(int[][] chessArr) {
        /** For双层循环遍历输出 */
        System.out.println("输出原始数组");
        for (int b = 0; b < chessArr.length; b++) {
            for (int c = 0; c < chessArr[b].length; c++)
                System.out.printf("%d\t", chessArr[b][c]);
            System.out.println();
            /** Foreach循环遍历输出 */

        }
    }

}


