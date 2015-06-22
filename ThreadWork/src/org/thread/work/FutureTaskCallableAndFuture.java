package org.thread.work;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskCallableAndFuture {
	
	public static void main(String[] args) {  
        Callable<Integer> callable = new Callable<Integer>() {  
            public Integer call() throws Exception {  
            	Thread.sleep(5000);// 任务线程可能做一些比较耗时的事情  
                return new Random().nextInt(100);  
            }  
        };  
        
        Runnable runnable = new Runnable() {  
            public void run() {  
            	System.out.println("Runnable is running"); 
            	try {
					Thread.sleep(5000);// 任务线程可能做一些比较耗时的事情  
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }  
        };
        
        FutureTask<Integer> callableFuture = new FutureTask<Integer>(callable);  
        new Thread(callableFuture).start();  
        
        //108 is the returned value after Runnable task is finished
        FutureTask<Integer> runnableFuture = new FutureTask<Integer>(runnable, 108);  
        new Thread(runnableFuture).start(); 
        
        try {  
        	System.out.println("before callableFuture.get(),time is:"+new Date()); 
            Thread.sleep(3000);// 主线程可以继续做自己的事情  
            System.out.println(callableFuture.get());  
            System.out.println("after callableFuture.get(),time is:"+new Date()); 
            
            System.out.println("Runnable runnableFuture return is:"+runnableFuture.get());
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (ExecutionException e) {  
            e.printStackTrace();  
        }  
    }  

}
