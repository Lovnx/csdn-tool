package com.lovnx.csdn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelIntoMemory {

	public static void main(String[] args) {
		readIP();
	}
	
	public static List<String> readIP() {
		List<String> list = new ArrayList<String>();
		  try {
	            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(
	                    "./ip.xls"));//excel文件位置
	            HSSFSheet sheet = wb.getSheetAt(0);
	            HSSFRow row;
	            int rowNum = sheet.getLastRowNum();
	            Integer flag = 1;
	            String temp = null;
	            for (int i = 0; i <= rowNum ; i++) {
	                row = sheet.getRow(i);
	                int columnNum = 0;
	                if (row != null) {
	                    columnNum = row.getPhysicalNumberOfCells();
	                }
	                for (int j = 0; j < columnNum; j++) {
	                    HSSFCell cell = sheet.getRow(i).getCell(j);
	                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
	                    if (cell == null) {
	                        break;
	                    } else {
	                        String cellValue = cell.getStringCellValue();
	                        if (StringUtils.isNotBlank(cellValue)) {
	                        	if (flag % 2 != 0) {//单数存值
									temp = cellValue;
								} else {//偶数拼装
		                        	System.out.println(temp + ":" + cellValue);
									list.add(temp + ":" + cellValue);
									temp = null;
								}
	                        	flag++;
							}
	                    }
	                }
	            }
//	            OutputStreamWriter osw = null;
//	            osw = new OutputStreamWriter(new FileOutputStream(
//	                    "C:/Users/zhph/Desktop/xx.txt"), "GBK");
//	            osw.write(sqlString);
//	            osw.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		  return list;
	}
	
	public static List<String> readBlog() {
		List<String> list = new ArrayList<String>();
		  try {
	            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(
	                    "./blog.xls"));//excel文件位置
	            HSSFSheet sheet = wb.getSheetAt(0);
	            HSSFRow row;
	            int rowNum = sheet.getLastRowNum();
	            for (int i = 0; i <= rowNum ; i++) {
	                row = sheet.getRow(i);
	                int columnNum = 0;
	                if (row != null) {
	                    columnNum = row.getPhysicalNumberOfCells();
	                }
	                for (int j = 0; j < columnNum; j++) {
	                    HSSFCell cell = sheet.getRow(i).getCell(j);
	                    cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
	                    if (cell == null) {
	                        break;
	                    } else {
	                        String cellValue = cell.getStringCellValue();
	                        if (StringUtils.isNotBlank(cellValue)) {
	                        	System.out.println(cellValue);
	                        	list.add(cellValue);
							}
	                    }
	                }
	            }
//	            OutputStreamWriter osw = null;
//	            osw = new OutputStreamWriter(new FileOutputStream(
//	                    "C:/Users/zhph/Desktop/xx.txt"), "GBK");
//	            osw.write(sqlString);
//	            osw.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		  return list;
	}
	
}
