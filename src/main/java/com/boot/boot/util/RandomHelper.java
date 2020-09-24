package com.boot.boot.util;

import java.util.Random;
import java.util.UUID;

public class RandomHelper {

	public static int getRandomNumber() {
		Random random = new Random();
		return random.nextInt();
	}

	public static int getRandomNumber(int seed) {
		Random random = new Random();
		return random.nextInt(seed);
	}

	//
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	//生成随机数字和字母,  
	public static String getRandomString(int length) {
		String val = "";
		Random random = new Random();
		//参数length，表示生成几位随机数  
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			//输出字母还是数字  
			if ("char".equalsIgnoreCase(charOrNum)) {
				//输出是大写字母还是小写字母  
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 生成随机小写字母
	 * @param length
	 * @return
	 */
	public static String getRandomLowerChar(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str = str + (char) (Math.random() * 26 + 'a');
		}
		return str;
	}

	/**
	 * 生成随机大写字母
	 * @param length
	 * @return
	 */
	public static String getRandomtUpperChar(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str = str + (char) (Math.random() * 26 + 'A');
		}
		return str;
	}

	public static void main(String[] params) {
		//		System.out.println(RandomUtil.getRandomNumber());
		//		System.out.println(RandomUtil.getRandomNumber(999999));
				System.out.println(RandomHelper.uuid());
	}
}