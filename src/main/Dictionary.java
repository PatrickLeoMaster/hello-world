package main;

import java.io.*;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Scanner;


public class Dictionary {
	public void dic() throws Exception {
		/*
		 	What we want to do is:
		 		1. Load dictionary data from file.
		 		2Put data into HashMap.
		 		3 provide dictionary checking feature.
		 
		 */
		//	Create HashMap Object
		//	HashMap<KeyDataType,ValueDataType>
		HashMap<String, String> dic=new HashMap<>();
		//	Load data from
		FileReader in =new FileReader("data.txt");
		BufferedReader reader =new BufferedReader(in);
		String line,chinese,english;
		
		int cutIndex;
		while ((line=reader.readLine())!=null) {
			System.out.println(line);
			cutIndex=line.indexOf(",");
			english=line.substring(0, cutIndex);
			chinese=line.substring(cutIndex+1,line.length());
			//	Put data into HashMap
			dic.put(english, chinese);
			dic.put(chinese, english);
			
		}
		Boolean s=true;
		while (s){
			
			System.out.println("块稱琩高ゅ Enter keyword to check");
			String keyword=new Scanner(System.in).nextLine();
			long startTime=System.currentTimeMillis();
			long endTime;
			if (keyword.equals("exit")) {
				s=false;
				System.out.println("挡ㄥ琩高");
				break;
			}
			if (keyword.equals("0")) {
				break;
			}
			else {
				String result=dic.get(keyword);
				
				if (result==null) {
					System.out.println("琩ぃ戈 No Data");
					endTime=System.currentTimeMillis();
				}else {
					System.out.printf("琩高Θ   Success: %s ",result);
					endTime=System.currentTimeMillis();
				}
				
			}
			
			System.out.println("琩高丁:"+(endTime-startTime)+"ms");
		}
		//	Provide dictionary checking feature, enter 0 to exit program
		
	}
}
