package cn.gaomh._1000;

import java.util.Scanner;

public class Main {

	public static int add(int a, int b){
		int res = -1;
		if(a >=0 && b <= 10){
			res = a+b;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		Scanner  sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int add = Main.add(a, b);
		System.out.println(add);
		
	}

}
