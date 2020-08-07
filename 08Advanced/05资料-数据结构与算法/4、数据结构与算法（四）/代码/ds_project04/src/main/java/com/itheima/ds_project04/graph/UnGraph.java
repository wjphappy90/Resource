package com.itheima.ds_project04.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 采用邻接表方式存储无向图
 */
public class UnGraph {
    /**
     * 标识途中顶点个数
     */
    private int points;
    /**
     * 邻接表
     */
    private LinkedList<Integer>[] adjacencyList;

    /**
     * 构造
     *
     * @param points
     */
    public UnGraph(int points) {
        this.points = points;
        // 初始化数组
        adjacencyList = new LinkedList[this.points];
        //  初始化数组种每一个槽位上链表
        for (int i = 0; i < this.points; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    /**
     * 向图中添加顶点(边)
     */
    public void addPoint(int s, int t) {
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }


    /**
     *    bfs 广度优先搜索
     * @param s   起始顶点
     * @param t   目标顶点
     */
    public  void  bfs (int s, int t){
        if (s==t){
            return;
        }
        /**
         * 定义一个boolean数组，用来记录我们的顶点是否被访问过
         */
        boolean []  visied= new boolean[this.points];
        // 起始顶点已经被访问
        visied[s] = true;
        /**
         * 定义一个队列，存储已经被访问的，但是还有相邻顶点顶点
         */
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        /**
         * 定义一个数组用来存储我们 s-t线路
         */
        int [] prev = new int[this.points];
        // 初始化线路为-1；
        for (int i=0;i<prev.length;i++){
            prev[i] = -1;
        }
        /**
         * 循环访问队列中没有被访问的顶点
         */
        while (!queue.isEmpty()){
            // 取出访问过的但是有相邻顶点的顶点
            Integer p = queue.poll();
            // 遍历这个顶点的相邻顶点
            for (int j=0;j<adjacencyList[p].size();j++) {
                // 取出相邻顶点
                Integer p_edge = adjacencyList[p].get(j);
                // 相邻顶点没有被访问过
                if (!visied[p_edge]){
                      // 记录访问路线
                    prev[p_edge] =p;
                    // 如过该顶点与t相等这个时候打印访问路线
                    if (p_edge==t){
                        print(prev,s,t);
                        return;
                    }
                    //  否则标记p为已经访问过的顶点
                    visied[p] =true;
                    // 相邻顶点存入队列
                    queue.add(p_edge);
                }
            }
        }

    }

    /**
     * 打印 从s-t线路的方法
     *
     */

    public  void  print( int [] prev , int s, int t){

        if (prev[t]!=-1&&s!=t){
            print(prev,s,prev[t]);
        }
        System.out.print(t+">>");
    }

    /**
     *   标记我们是否找到t
     */
    private  boolean  found = false;

    /**
     *   DFS  算法
     * @param s
     * @param t
     */
     public  void  dfs(int s, int t){
            if (s==t){
                return;
            }
            //  标记某元素是否被访问
            boolean [] visited = new  boolean[this.points];
            //
          visited[s] =true;
          //  定义一个数组 记录我们从原顶点到 我们目标顶点之间线路

         int [ ] prv = new int[this.points];
         for ( int i=0; i<prv.length;i++){
             prv[i]=-1;
         }
         //  递归调用
         returnDFS(s,t,visited,prv);
         // 打印线路
         print(prv,s,t);

     }

    /**
     *   查找定点 point 到我们目标顶点线路
     * @param point   顶点point
     * @param target   目标顶点
     * @param visited   已经被访问过的顶点的数组
     * @param prev   顶点线路数组
     */
     private  void  returnDFS(int point, int target , boolean [] visited , int[] prev){

         if(found){
             return;
         }
         // 标记当前顶点已经被访问过
         visited[point] =true;
         // 若果当前顶点就是目标顶点
         if (point==target){
             found=true;
             return;
         }
         //   获取与当前顶点相连接的所以顶点
         for (int j=0;j<adjacencyList[point].size();j++){
              //  获取与顶点point 相连的顶点
             Integer  p_conect =adjacencyList[point].get(j);
             if (!visited[p_conect]){
                    // 记录p_conect 之前的顶点是p
                   prev[p_conect] =point;
                   //  递归
                 returnDFS(p_conect,target,visited,prev);
             }

         }


     }













    public static void main(String[] args) {
        UnGraph unGraph = new UnGraph(8);
        unGraph.addPoint(0,1);
        unGraph.addPoint(0,3);
        unGraph.addPoint(1,2);
        unGraph.addPoint(1,4);
        unGraph.addPoint(2,5);
        unGraph.addPoint(3,4);
        unGraph.addPoint(4,5);
        unGraph.addPoint(4,6);
        unGraph.addPoint(6,7);
        unGraph.addPoint(7,5);

        unGraph.bfs(0,6);
    }

}
