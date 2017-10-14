package com.lovnx.csdn;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel {
	// 将生成好的Excel文件，放到硬盘上
	public static void writeToDisk(List<MyIp> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 生成一个sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 为sheet1生成第一行，用于放表头信息
		HSSFRow row = sheet.createRow(0);

		// 第一行的第一个单元格的值为 ‘序号’
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ip");

		cell = row.createCell((short) 1);
		cell.setCellValue("port");

		// 获得List中的数据，并将数据放到Excel中
		for (int i = 0; i < list.size(); i++) {
			MyIp myIp = list.get(i);
			// 数据每增加一行，表格就再生成一行
			row = sheet.createRow(i + 1);
			// 第一个单元格，放序号随着i的增加而增加
			cell = row.createCell((short) 0);
			cell.setCellValue(myIp.getAddress());
			// 第二个单元格放firstname
			cell = row.createCell((short) 1);
			cell.setCellValue(myIp.getPort());

		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();

		File file = new File("c:/ip.xls");// Excel文件生成后存储的位置。

		OutputStream fos = null;

		try {
			fos = new FileOutputStream(file);

			fos.write(content);
			os.close();
			fos.close();
			System.out.println("Excel生成成功！************");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}