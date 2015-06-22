package org.thread.work;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallableAndFuture {
	
	public static void main(String[] args) {  
        ExecutorService threadPool = Executors.newSingleThreadExecutor();  
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {  
            public Integer call() throws Exception {  
            	Thread.sleep(5000);// 任务线程可能做一些比较耗时的事情  
                return new Random().nextInt(100);  
            }  
        });  
        
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();  
        Future<Integer> future2 = threadPool2.submit(new Runnable() {  
            public void run() {  
            	System.out.println("Runnable is running"); 
            	try {
					Thread.sleep(5000);// 任务线程可能做一些比较耗时的事情  
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }  
        }, 108); //108 is the returned value after Runnable task is finished
        
        try {  
        	
        	System.out.println("before future.get(),time is:"+new Date()); 
        	Thread.sleep(3000);// 主线程可以继续做自己的事情  
            System.out.println(future.get());  //如果future还没有得到返回值，此方法等待，主线程阻塞
            System.out.println("after future.get(),time is:"+new Date()); 
            
            System.out.println("Runnable ExecutorService return is:"+future2.get());
            
            
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        } finally {
        	threadPool.shutdown();
        	threadPool2.shutdown();
        }
    }  

}
