package com.edu.test;

public class Main {
	public static void main(String[] args) {
		InitParamServlet ips = new InitParamServlet();
		ips.id = "user";

		// System.out.println(ips.showInfo());
		// System.out.println(ips.name); showInfo() 가 실행되면서 메모리에서 ips.name 이 사라져서 안됨
		System.out.println(ips.id);
		System.out.println(ips.password);
	}
}
