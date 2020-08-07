package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 *
 * 顺序访问:
 *          通过迭代器一个个的取出元素
 * 随机访问:
 *          通过索引随机获取元素
 *
 *
 *  此循环：
    for (int i=0, n=list.size(); i < n; i++)
        list.get(i);
    比这个循环运行得更快：
    for (Iterator i=list.iterator(); i.hasNext(); )
        i.next();
 */
@SuppressWarnings("all")
public class Test01 {
    public static void main(String[] args) {
        //创建ArrayList
        ArrayList<String> list = new ArrayList<String>();
        //添加10W条数据
        for (int i = 0; i < 100000; i++) {
            list.add("黑马程序员"+i);
        }

        //随机访问
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            //取出集合的元素
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ArrayList随机访问用时: "+(endTime - startTime));

        //顺序访问
        startTime = System.currentTimeMillis();
        //获取迭代器
        Iterator<String> it = list.iterator();
        //循环遍历
        while (it.hasNext()){
            it.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList顺序访问用时: "+(endTime - startTime));
    }
}
