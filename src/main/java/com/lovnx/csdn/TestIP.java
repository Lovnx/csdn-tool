package com.lovnx.csdn;

import java.util.List;

public class TestIP {

	private static List<String> IP = null;
	
	static {
		IP = ReadExcelIntoMemory.readIP();
	}
	
	

}
