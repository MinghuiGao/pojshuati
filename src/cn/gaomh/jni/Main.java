package cn.gaomh.jni;

public class Main {

	static{
		System.load("test");
	}
	
	public static void main(String[] args) {
		
	}
	
	public native static String hello(String name);
	
	public native static int getVersion( char c,int n,boolean isTrue);
}
