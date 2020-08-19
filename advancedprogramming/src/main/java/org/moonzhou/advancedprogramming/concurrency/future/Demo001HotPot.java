package org.moonzhou.advancedprogramming.concurrency.future;// DaHuoGuo.java

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Demo001HotPot {
	public static void main(String[] args) throws Exception {
		FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println(Thread.currentThread().getName() + ":" + "开始烧开水...");
				// 模拟烧开水耗时
				Thread.sleep(4000);
				System.out.println(Thread.currentThread().getName() + ":"  + "开水已经烧好了...");
				return "开水";
			}
		});

		Thread thread = new Thread(futureTask);
		thread.start();

		// do other thing， 可以在当前线程处理，也可以另外开启线程
		System.out.println(Thread.currentThread().getName() + ":"  + " 此时开启了一个独立线程执行future的逻辑（烧开水），我们可以干点别的事情（比如准备火锅食材）...");
		// 模拟准备火锅食材耗时，此处的耗时>烧开水的耗时，后面获取结果看不出阻塞的效果；如果小于，则可以看出获取烧水结果的get方法是有阻塞的
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName() + ":"  + "火锅食材准备好了");
		String food = "火锅食材";

		// 获取独立烧开水线程的结果：该方法有阻塞的特性，如果future没有执行完成返回结果，则阻塞在此直到获取到结果返回；如果已经执行完成，则直接获取到结果
		String boilWater = futureTask.get();

		System.out.println(Thread.currentThread().getName() + ":"  + boilWater + "和" + food + "已经准备好，我们可以开始打火锅啦");
	}
}
