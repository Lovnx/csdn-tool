package com.lovnx.csdn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread {
	
	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
		for (int i = 0; i < 10; i++) {
		    cachedThreadPool.execute(new Runnable() {  
		        public void run() {  
		            RandomFlush.run();
		        }  
		    });  
		}  
	}
}
