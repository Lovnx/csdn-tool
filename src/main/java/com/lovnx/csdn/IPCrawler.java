package com.lovnx.csdn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class IPCrawler {
	
	public static void main(String[] args) {
		String url = "http://www.kuaidaili.com/free/inha/";
		List<MyIp> ipList = new ArrayList<MyIp>();
//        try {
            //1.向ip代理地址发起get请求，拿到代理的ip
        	for (int i = 1; i <= 500; i++) {
				String URL = url + i + "/";
				System.out.println(URL);
				Document doc = null;
				try {
					doc = Jsoup.connect(URL)
							.userAgent("Mozilla")
							.cookie("auth", "token")
							.timeout(10000)
							.get();
				} catch (IOException e) {
//					e.printStackTrace();
					System.out.println(URL+"出错了！！！！！！");
				}
				if (doc == null) {
					continue;
				}
				Elements elements1 = doc.select("table").select("tr");
				for (int j = 1; j < elements1.size(); j++) {
					//获取每一行的列
					String tds = elements1.get(j).text();
					System.out.println(tds);
					System.out.println("--------------------");
					
					String[] cut = tds.split(" ");
					String ip = cut[0];
					String port = cut[1];
					
					System.out.println(ip + ":" + port);
					MyIp myIp = new MyIp(ip, port);
					ipList.add(myIp);
				}
			}
        	Excel.writeToDisk(ipList);
//        } catch (IOException e) {
//            System.out.println("加载文档出错");
//        }
        
	}
}
