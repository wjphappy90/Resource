package com.itheima.thought;

/**
 * 算法思想：回溯
 *  8皇后问题
 */
public class Queens8 {

    /** 皇后数组，数组的下标表示第几个皇后，也表示皇后在哪一行，元素的值表示皇后对应的列位置 */
    private int[] queen;

    /**
     * 计算并输出n皇后问题的位置
     * @param n 有几个皇后
     */
    public void backtrackMethod(int n) {
        // 初始化数组
        queen = new int[n];
        for (int i = 0; i < queen.length; i++) {
            queen[i] = -1;// 初始化皇后的起点
        }
        // 从第1个皇后开始
        int k = 0;
        while (true) {
            queen[k] += 1;// 第k个皇后移动一个
			/* 判断是否应该回溯到上一行开始搜索 */
            if (queen[k] >= n) {// 第k个皇后移动后溢出，即跑出边界，则确定这一行的皇后没有任何位置可选
                if (k > 0) {// 如果不是第一个皇后，则目标皇后更新为地k-1个皇后
                    queen[k] = -1;// 该皇后的起点回归到原始
                    k--;// 目标更新为第k-1个皇后
                    continue;// 跳过下面的判断，从方法体开始处开始
                } else {// 如果该皇后是第一个，则已经遍历所有位置，跳出循环
                    break;
                }
            }
            /**
             * 判断皇后在该位置是否不冲突，更改目标为下一行进行搜索
             */
            if (!willBeEaten(k)) {// 如果不冲突
                k++;// 目标还后更新为下一个
                if (k >= n) {// 如果下标k溢出，即超过了皇后数量则已经确定一个组合，输出
                    for (int i = 0; i < n; i++) {
                        System.out.print(queen[i] + " ");
                    }
                    System.out.println();
                    k--;// k溢出，将k回溯到最后一行继续搜索其他可能性
                }
            }
        }
    }

    /**
     * 判断放置第k个皇后之后是否与之前的皇后冲突，判定冲突的条件是，第k个皇后的于前面的第i个皇后在横轴坐标相等，
     * 或者横坐标和纵坐标之差相等（两者连线于横轴夹角为45度）如果冲突返回true，否则返回false
     * @param k 第k个皇后
     * @return 放置地k个皇后之后是否与之前的皇后冲突
     */
    public boolean willBeEaten(int k) {
        for (int i = k - 1; i > -1; i--) {// i的起点为k-1，即k个皇后的上一行
            if (queen[k] == queen[i]
                    || Math.abs(queen[k] - queen[i]) == Math.abs(k - i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Queens8().backtrackMethod(8);
    }
}
