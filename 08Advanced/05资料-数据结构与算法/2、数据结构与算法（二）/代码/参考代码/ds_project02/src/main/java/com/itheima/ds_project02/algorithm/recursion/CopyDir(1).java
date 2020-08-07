package com.itheima.ds_project02.algorithm.recursion;

import org.junit.Test;

import java.io.*;

/**
 * 递归
 * 高效拷贝目录
 */
public class CopyDir {

    /**
     * 实现目录拷贝
     * @param source
     * @param target
     */
    public void copyDir(File source,File target){
        if(source.isFile()|| !source.exists()){
            return;
        }
        //在目标目录下创建原目录
        File newDir = new File(target,source.getName());
        newDir.mkdir();
        
        //获取原目录下的所有文件和目录
        File[] listFiles = source.listFiles();
        //遍历判断是文件还是目录，是文件则直接进行拷贝工作,是目录则递归调用自己实现拷贝
        for (File listFile : listFiles) {
            
            if(listFile.isFile()){
             //如果是文件则直接拷贝
                try {
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(listFile));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir,listFile.getName())));
                    int len = 0;
                    byte[] bytes = new byte[1024*8];
                    while ((len= bis.read(bytes))!=-1){
                        bos.write(bytes,0,len);
                    }
                    bos.close();
                    bis.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                //如果是目录就递归拷贝
                copyDir(listFile,newDir);
            }
            
        }
    }
    
    @Test
    public void testCopyDir(){
        //创建原目录
        File source = new File("D:\\io\\source");
        //创建目标目录
        File target = new File("D:\\io\\target");
        //实现拷贝
        copyDir(source,target);
    }
    
}
