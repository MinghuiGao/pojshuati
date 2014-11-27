package cn.gaomh._1002;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// The remaining lines list the telephone numbers in the directory, with
		// each number alone on a line. Each telephone number consists of a
		// string composed of decimal digits, uppercase letters (excluding Q and
		// Z) and hyphens. Exactly seven of the characters in the string will be
		// digits or letters.
		int len = sc.nextInt();
		String[] dials = new String[len];
		for (int i = 0; i < len; i++) {
			String str = sc.next();
			if (isDialValidate(str)) {
				dials[i] = str;
			} else {
				System.out.println("wrong format.");
				return;
			}
		}
		
		
		
	}

	private static boolean isDialValidate(String str) {
		char[] charArray = str.toCharArray();
		boolean res = true;
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if((c >='A' && c<= 'Y') || (c>= '0' && c <='9') ){
				if(c == 'Q' )
					res = false;
			}else{
				if(c == '-')
					continue;
				res = false;
//				break;
			}
		}
		return res;
	}
}
