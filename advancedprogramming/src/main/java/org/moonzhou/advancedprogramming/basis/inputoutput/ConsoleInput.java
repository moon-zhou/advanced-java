package org.moonzhou.advancedprogramming.basis.inputoutput;

import java.util.Scanner;

/**
 * 控制台输入
 */
public class ConsoleInput {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);

		//double类型的数据
		System.out.print("请输入一个double类型的数:");
		double d = input.nextDouble();
		System.out.println(d);

		//int类型的数据
		System.out.print("请输入一个int类型的数:");
		int i = input.nextInt();
		System.out.println(i);

		//字符串类型的数据
		System.out.print("请输入一个string类型的数:");
		String s = input.next();
		System.out.println(s);
	}

}