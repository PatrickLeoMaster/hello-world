package main;



public class Worker implements Runnable{
	private int times;
	public Worker(int times) {
		this.times=times;
	}
	
	//��@ Runnable ����  implement Runnable interface
	public void run() {
		for (int i = 0; i < this.times; i++) {
			Test.count++;
		}
		
	}
}
