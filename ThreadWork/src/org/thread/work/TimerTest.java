package org.thread.work;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {  
    static class MyTimerTask extends TimerTask {  
        public void run() {  
            System.out.println("爆炸！！！");  
        }  
    }     
    public static void main(String[] args) {  
        final Timer timer = new Timer();  
        timer.schedule(new TimerTask(){
        	private int count=0;
            public void run() { 
            	count++;
                System.out.println("爆炸！！！"+count);  
                if (count == 10) {
                	System.out.println("停止定时器");
                    timer.cancel();// 停止定时器
                }
            } 
        }, 20, 1000 );// 两秒后启动任务  
    }  
}  
