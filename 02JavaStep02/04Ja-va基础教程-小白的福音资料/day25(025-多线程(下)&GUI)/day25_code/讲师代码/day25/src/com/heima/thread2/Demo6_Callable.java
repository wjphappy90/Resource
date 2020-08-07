package com.heima.thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo6_Callable {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);//创建线程池
		Future<Integer> f1 = pool.submit(new MyCallable(100));				//将线程放进池子里并执行
		Future<Integer> f2 = pool.submit(new MyCallable(50));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		
		pool.shutdown();							//关闭线程池
	}

}

class MyCallable implements Callable<Integer> {
	private int num;
	public MyCallable(int num) {
		this.num = num;
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}