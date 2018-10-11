package main;



public class Test {
	public static int count=0;//一個公開的靜態屬性 An public static attribute
	public static void main(String[] Args) throws Exception{
		// 計算程式執行的時間 trace running time
		new Gui();
		
		long startTime=System.currentTimeMillis();
		
		/*
			Test an easy method to increase count 2 billions times.
		 */
		/*
		for (int i = 0; i < 2000000000; i++) {
			
			Test.count++;
		}
		*/
		
		/*
		 	compute in parallel by Thread.
		 	使用執行緒,讓工作同時分散進行
		 	we have to design a class implementing Runnable interface and instantiate it.
		 	Create thread by object instance implementing Runnable interface
		 	利用實作 Runnable 介面的物件,建立執行緒
		 
		 */
		Thread t1=new Thread(new Worker(1000000000));
		Thread t2=new Thread(new Worker(1000000000));
		t1.start();// 啟動執行緒的工作  start thread
		t2.start();
		t1.join();// 等待執行緒工作完成  Wait thread to finish
		t2.join();
		
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		new Dictionary().dic();;
		
		
		System.out.println("程序已關閉");
		System.exit(0);
	}
}
