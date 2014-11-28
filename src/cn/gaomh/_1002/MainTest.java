package cn.gaomh._1002;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainTest {

	private static String pool = "ABCDEFGHIJKLMNOPRSTUVWXY";

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);

		int len = sc.nextInt();
		String[] dials = new String[len];
		for (int i = 0; i < len; i++) {
			String str = sc.next();
			if (isDialValidate(str)) {
				str = str.replace("-", "");
				String preStr = str.substring(0, 3);
				String tailStr = str.substring(3);
				dials[i] = preStr.concat("-").concat(tailStr);
			} else {
				System.out.println("wrong format.");
				return;
			}
		}

		// translate
		for (int i = 0; i < len; i++) {
			dials[i] = trasnlate(dials[i]);
		}
		// count
		HashMap<String, Integer> countRes = new HashMap<String, Integer>();
		for (String dial : dials) {
			Integer integer = countRes.get(dial);
			if (integer == null) {
				countRes.put(dial, 1);
			} else {
				countRes.put(dial, ++integer);
			}
		}

		// output result
		Set<String> keySet = countRes.keySet();
		Object[] array = keySet.toArray();
		Arrays.sort(array);
		boolean isDuplicate = false;
		for (Object key : array) {
			if (countRes.get(key) > 1){
				System.out.println(key + " " + countRes.get(key));
				if(!isDuplicate){
					isDuplicate = true;
				}
			}
		}
		if(!isDuplicate){
			System.out.println("No duplicates. ");
		}
	}

	// 2
	private static String trasnlate(String dial) {
		String story = null;
		char[] chars = null;
		if (dial != null && dial.length() > 0) {
			chars = dial.toCharArray();
		} else {
			return story;
		}
		int num = -1;
		for (int i = 0; i < chars.length; i++) {
			// find the index of the chars[i] in the dial.
			if ((chars[i] >= 'A' && chars[i] <= 'Y')) {
				int index = pool.indexOf(chars[i]);
				num = (index + 1) % 3 == 0 ? (index + 1) / 3 + 1
						: (index + 1) / 3 + 2;
				chars[i] = (char) (num + '0');
			} else {
				continue;
			}
		}
		story = new String(chars);
		return story;
	}

	// 1 see if the input string is validate.
	private static boolean isDialValidate(String str) {
		char[] charArray = str.toCharArray();
		boolean res = true;
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if ((c >= 'A' && c <= 'Y') || (c >= '0' && c <= '9')) {
				if (c == 'Q')
					res = false;
			} else {
				if (c == '-')
					continue;
				res = false;
			}
		}
		return res;
	}
}
