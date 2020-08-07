package com.itheima.stringmatch;

import org.junit.Test;

/**
 * BM算法实现
 */
public class BM {
    // 存储字符和对应下标的数组的全局变量
    private static final int SIZE = 256; // 全局变量或成员变量

    /**
     * 记录模式串每个字符与其对应下标，存储在bc数组中,字符的ASCII码作为数组下标,对应位置存储该字符在模式串中的下标
     * @param p   模式串
     * @return  
     */
    private int[] initBC(char[] p) {
        // 定义存储模式串每个字符最后出现的位置的bucket数组
        int[] bc = new int[SIZE];
        // 初始化
        for(int i=0;i<bc.length;i++){
            bc[i] = -1;
        }
        //计算字符的ASCII码作为数组下标,对应位置存储该字符在模式串中的下标
        for(int i=0;i<p.length;i++){
            int acsii = (int)p[i];
            bc[acsii] = i;
        }
        return bc;
    }

    /**
     * 初始化surfix和prefix数组
     * @param p         模式串
     * @param surfix    surfix数组,suffix 数组的下标k表示后缀子串的长度，下标对应的数组值存储的是，在模式串中跟好后缀{u}相匹配的子串{u*}的起始下标值
     * @param prefix    记录模式串的后缀子串是否能匹配模式串的前缀子串
     * @param m         模式串的长度
     */
    private void initSurfixAndPrefix(char[] p,int m,int[] surfix,boolean[] prefix){
        // 模式串的长度
        // 初始化
        for(int i=0;i< m;i++ ){
            surfix[i] = -1;
            prefix[i] = false;
        }
        //计算公共后缀子串
        for(int i=0;i< m-1;i++){
            int j = i;
            int k = 0;//初始化公共后缀字串的长度
            while ( j>=0 && p[j] == p[m-1 - k] ){ // 与p[0,i]求公共后缀子串
                surfix[k++] = j--; // j表示公共后缀子串在p[0,i]中的起始下标
            }
            if(j < 0){ // 公共后缀子串也是模式串的前缀子串
                prefix[k]  = true;
            }
        }
    }
    /**
     * 使用BM算法在主串t中查找模式串p，返回其位置
     * @param t  目标字符串/主串
     * @param p  模式串
     * @return
     */
    public int bm(String t,String p){
        if(t==null|| t.length()==0|| p==null|| p.length()==0|| p.length()> t.length()){
            return -1;
        }
        char[] t_array = t.toCharArray();
        char[] p_array = p.toCharArray();
        int[] bc = initBC(p_array); //模式串中每个字符与对应位置的bucket数组即构建坏字符哈希表
        int n = t_array.length; // 主串长度
        int m = p_array.length;//  模式串长度
        // 初始化surfix数组和prefix数组
        int[] surfix = new int[m];
        boolean[] prefix = new boolean[m];
        initSurfixAndPrefix(p_array,m,surfix,prefix);
        
        // 开始进行匹配
        int i=0;
        while (i<=n-m){
            // 开始坏字符规则
            int si=0;
            int xi=-1;
            // 模式串从后向前匹配
            int j;
            for(j=m-1;j>=0;j--){
                if(t_array[i+j] != p_array[j]){
                    si = j; // 记录坏字符位置在模式串中的位置si
                    xi = bc[t_array[i+j]]; // 查找坏字符在模式串中最后出现的位置xi
                    break;
                }
            }
            if(j<0){
                return i;
            }
            int x = si - xi; // 坏字符规则下将模式串向后移动si-xi位

            // 开始好后缀规则
            int y = 0; //好后缀规则下需要向后移动的位数
            if(j < m-1){ //证明有好后缀
                y = moveBySurfixAndPrefix(j,m,surfix,prefix);
            }

            // 最终模式串需要向后移动的位数
            i += Math.max(x,y);
        }
        return -1;
    }

    /**
     * 好后缀规则下计算模式串应该移动的位数
     * @param j         坏字符在模式串中的下标
     * @param m         模式串的长度
     * @param surfix    存储公共后缀子串在模式串中下标的surfix数组
     * @param prefix    存储公共后缀子串是否是模式串的前缀子串的prefix数组
     * @return
     */
    private int moveBySurfixAndPrefix(int j,int m,int[] surfix,boolean[] prefix){
        // 计算好后缀的长度
        int k = m-1 -j;
        // 如果在模式串中存在好后缀
        int x = surfix[k];//k长度的好后缀在模式串中的下标
        if( x !=-1){
            return j-x +1;//后移
        }
        //如果模式串中不存在好后缀,则判断模式串中是否存在跟好后缀的后缀子串相匹配的前缀子串
        for(int r = j+2;r <= m-1;r++){ //r是模式串需要向后移动的位数
            if(prefix[m-r]){
                return r;
            }
        }
        return m; // 在模式串中找不到跟好后缀匹配的子串，也找不到跟好后缀的后缀子串匹配的前缀子串,则直接移动m,m是模式串的长度
    }
    
    
    @Test
    public void test(){
        String a = "abcedfg";
        String b = "edf";
        System.out.println("匹配下标为:"+bm(a,b));
    }
    
}
