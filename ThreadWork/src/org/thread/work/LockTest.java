package org.thread.work;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//����ͬ�������Ķ��̵߳��ã��Ͳ��ᷢ������
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
    private Lock lock = new ReentrantLock();// ������  
    public void output(String name) {  
        lock.lock();// �õ���  
        try {  
            for(int i = 0; i < name.length(); i++) {  
                System.out.print(name.charAt(i));  
            }  
            System.out.println();
        } finally {  
            lock.unlock();// �ͷ���  
        }  
    }  
}  


//�����û��ͬ������Ķ��̵߳��ã��ᷢ������
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
