package org.thread.work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//经过同步处理后的多线程调用，就不会发生串扰
public class LockTest {  
    public static void main(String[] args) {  
        final Outputter output = new Outputter();  
        new Thread() {  
            public void run() {  
            	try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
                output.output("zhangsan");  
            };  
        }.start();        
        new Thread() {  
            public void run() {  
                output.output("lisi");  
            };  
        }.start();  
    }  
}  
class Outputter {  
    private Lock lock = new ReentrantLock();// 锁对象  
    public void output(String name) {  
        lock.lock();// 得到锁  
        try {  
            for(int i = 0; i < name.length(); i++) {  
                System.out.print(name.charAt(i));  
            }  
            System.out.println();
        } finally {  
            lock.unlock();// 释放锁  
        }  
    }  
}  


//下面的没有同步处理的多线程调用，会发生串扰
//public class LockTest {  
//    public static void main(String[] args) {  
//        final Outputter output = new Outputter();  
//        new Thread() {  
//            public void run() {  
//                output.output("zhangsan");  
//            };  
//        }.start();        
//        new Thread() {  
//            public void run() {  
//                output.output("lisi");  
//            };  
//        }.start();  
//    }  
//}  
//class Outputter {  
//    public void output(String name) {  
//        for(int i = 0; i < name.length(); i++) {  
//            System.out.print(name.charAt(i));  
//            try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//        }  
//        System.out.println();  
//    }  
//}  
