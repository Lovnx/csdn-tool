package com.lovnx.csdn;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class RandomFlush {
	
	private static List<String> IP = null;
	
	private static List<String> BLOG = null;
	
	private static Integer ipLength = 0;
	
	private static Integer blogLength = 0;
	
	private static int count = 0;
	
	static {
		IP = ReadExcelIntoMemory.readIP();
		BLOG = ReadExcelIntoMemory.readBlog();
		ipLength = IP.size();
		blogLength = BLOG.size();
	}

	public static void run() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("请输入轮番刷新的倍数(x1000):");
//		int time = sc.nextInt();
		int time = 100000;
		
		for (int i = 0; i < time * 1000; i++) {
			//每次取随机的IP和BLOG地址
			String ip = getIP(IP);
			String blog = getBLOG(BLOG);
			String[] str = ip.split(":");
			// 2.设置ip代理
			System.setProperty("http.maxRedirects", "50");
			System.getProperties().setProperty("proxySet", "true");
			System.getProperties().setProperty("http.proxyHost", str[0]);
			System.getProperties().setProperty("http.proxyPort", str[1]);
			//开始访问
			try {
				Document doc = Jsoup
							.connect("" + blog)
							.userAgent("Mozilla")
							.cookie("auth", "token")
							.timeout(new Random().nextInt(3000))
							.get();
				if (doc != null) {
					count++;
					System.out.println("成功刷新次数: " + count);
					System.out.println(ip + " -->>访问-->> " + "" + blog);
				}
			} catch (IOException e) {
				System.out.println(ip + "报错");
			}
		}
	}
	
	public static String getIP(List<String> ip) {
		return ip.get(new Random().nextInt(ipLength));
	}
	
	public static String getBLOG(List<String> blog) {
		return blog.get(new Random().nextInt(blogLength));
	}
	
	public static void main(String[] args) {
		run();
	}
}
