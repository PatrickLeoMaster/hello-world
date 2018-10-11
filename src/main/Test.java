package main;



public class Test {
	public static int count=0;//�@�Ӥ��}���R�A�ݩ� An public static attribute
	public static void main(String[] Args) throws Exception{
		// �p��{�����檺�ɶ� trace running time
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
		 	�ϥΰ����,���u�@�P�ɤ����i��
		 	we have to design a class implementing Runnable interface and instantiate it.
		 	Create thread by object instance implementing Runnable interface
		 	�Q�ι�@ Runnable ����������,�إ߰����
		 
		 */
		Thread t1=new Thread(new Worker(1000000000));
		Thread t2=new Thread(new Worker(1000000000));
		t1.start();// �Ұʰ�������u�@  start thread
		t2.start();
		t1.join();// ���ݰ�����u�@����  Wait thread to finish
		t2.join();
		
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		new Dictionary().dic();;
		
		
		System.out.println("�{�Ǥw����");
		System.exit(0);
	}
}
