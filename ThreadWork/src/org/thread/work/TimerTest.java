package org.thread.work;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {  
    static class MyTimerTask extends TimerTask {  
        public void run() {  
            System.out.println("��ը������");  
        }  
    }     
    public static void main(String[] args) {  
        final Timer timer = new Timer();  
        timer.schedule(new TimerTask(){
        	private int count=0;
            public void run() { 
            	count++;
                System.out.println("��ը������"+count);  
                if (count == 10) {
                	System.out.println("ֹͣ��ʱ��");
                    timer.cancel();// ֹͣ��ʱ��
                }
            } 
        }, 20, 1000 );// �������������  
    }  
}  
