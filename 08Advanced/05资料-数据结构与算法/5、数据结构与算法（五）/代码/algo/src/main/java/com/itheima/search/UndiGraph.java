package com.itheima.search;

import jdk.jfr.events.SocketReadEvent;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基于邻接表实现的无向图
 *      该类中还实现了基于图的BFS和DFS
 */
public class UndiGraph {
    // 图中顶点的个数
    private int points;
    
    // 邻接表: 有点类似散列表,数组每个槽位链表头节点存储的是图中的顶点,链表其他节点存储的是与该顶点相连的顶点
    private LinkedList<Integer> adjacencyList[];
    
    public UndiGraph(int points){
        this.points = points;
        //初始化数组
        adjacencyList = new LinkedList[this.points];
        // 初始化数组每个槽位上的链表
        for(int i=0;i < this.points;i++){
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * 向图中添加顶点(边)
     * @param s
     * @param t
     */
    public void addEdge(int s,int t){
        // 无向图,一条边存储两回;注意：在该案例中,无向图中存储的顶点的值和数组的下标值保持对应
        adjacencyList[s].add(t);
        adjacencyList[t].add(s);
    }

    /**
     * 从源顶点到目标顶点的广度优先搜索BFS
     * @param source
     * @param target
     */
    public void bfs(int source,int target){
        if(source == target){
            return;
        }
        // 定义一个boolean数组记录顶点是否被访问过
        boolean[] visited = new boolean[this.points];
        visited[source] = true;
        // 定义一个队列,BFS算法借助了一个队列
        Queue<Integer> queue = new LinkedList();
        // 将源顶点加入队列
        queue.add(source);
        // 定义一个数组，记录从源顶点到目标顶点之间的线路
        int[] prev = new int[this.points];
        for (int i = 0; i < prev.length; ++i) {
            prev[i] = -1;
        }
        //
        while (!queue.isEmpty()){
            // 取出队列中顶点元素
            Integer p = queue.poll();
            // 从邻接表中取出跟该顶点相连的顶点链表
            for(int j=0;j< adjacencyList[p].size();j++){
                // 依次取出跟顶点p相连的顶点p
                Integer p_connect = adjacencyList[p].get(j);
                if(!visited[p_connect]){
                    //记录p_connect之前的顶点是p
                    prev[p_connect] = p;
                    // 判断跟顶点p相连的顶点p_connect是否是目标顶点
                    if(p_connect == target){
                        //打印从源顶点到目标顶点之间的线路
                        print(prev,source,target);
                        return;
                    }
                    // 标识顶点p已被访问
                    visited[p] = true;
                    // 将顶点p相连的顶点p_connect加入队列
                    queue.add(p_connect);
                }
            }
        }
    }

    /**
     * 递归打印从s到t之间的线路
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev,int s,int t){
        if(prev[t]!=-1 && s != t){
            print(prev,s,prev[t]);
        }
        System.out.println(t+"->");
    }

    /**
     * 从源顶点到目标顶点的深度优先搜索DFS
     *      需要借助一个全局的变量来记录是否找到目标顶点
     * @param source
     * @param target
     */
    private boolean found = false;
    
    public void dfs(int source,int target){
        if(source == target){
            return;
        }
        // 定义一个boolean数组记录顶点是否被访问过
        boolean[] visited = new boolean[this.points];
        visited[source] = true;
        // 定义一个数组，记录从源顶点到目标顶点之间的线路
        int[] prev = new int[this.points];
        for (int i = 0; i < prev.length; ++i) {
            prev[i] = -1;
        }
        
        //递归调用
        recurDFS(source,target,visited,prev);
        //打印线路
        print(prev,source,target);
    }

    /**
     * 递归的查找顶点p到目标顶点之间的线路图
     * @param point
     * @param target
     * @param visited
     * @param prev
     */
    private void recurDFS(int point,int target,boolean[] visited,int[] prev){
        if(found){
            return;
        }
        // 标记当前顶点已被访问
        visited[point] = true;
        // 如果当前顶点就是目标顶点
        if(point == target){
            found = true;
            return;
        }
        //获取与当前顶点相连接的所有顶点
        for(int j=0;j<adjacencyList[point].size();j++){
            // 获取与顶点P相连的顶点
            Integer p_connect = adjacencyList[point].get(j);
            if(!visited[p_connect]){
                //记录p_connect之前的顶点是p
                prev[p_connect] = point;
                //递归的去找与p_connect相连的顶点
                recurDFS(p_connect,target,visited,prev);
            }
        }
    }
}
