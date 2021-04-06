package org.honorcloud.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Description: excel表格工具类
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
public class ExcelUtils {
	
	public static void writeExcel(File file, String sheetName, String[] titleArray, List<List<String>> valueList) {
		try { 
		      OutputStream outputStream = new FileOutputStream(file); 
		      // 创建excel文件，注意这里的hssf是excel2007及以前版本可用，2007版以后的不可用，要用xssf 
		      @SuppressWarnings("resource")
			  XSSFWorkbook workbook = new XSSFWorkbook(); 
		      // 创建excel工作表 
		      XSSFSheet sheet = workbook.createSheet(sheetName);
		      // 为工作表增加标题
		      setTitle(sheet, titleArray);
		      //为工作表填写内容
		      setContent(sheet, valueList);
		      // 调用输出流把excel文件写入到磁盘 
		      workbook.write(outputStream); 
		      // 关闭输出流 
		      outputStream.close(); 
		    } catch (Exception e) { 
		      e.printStackTrace(); 
		    } 
	}

	private static void setContent(XSSFSheet sheet, List<List<String>> list) {
		int rownum = 1;
		for (List<String> valueList : list) {
			 XSSFRow row = sheet.createRow(rownum); 
			  int i= 0;
			  // 在指定的行上增加两个单元格
				for(String value : valueList){
					row.createCell(i++).setCellValue(value);
				}
			  rownum++;
		}
	}

	private static void setTitle(XSSFSheet sheet, String[] titleArray) {
		XSSFRow row = sheet.createRow(0);
		int i = 0;
		// 在指定的行上增加两个单元格
		for(String obj : titleArray){
			row.createCell(i++).setCellValue(obj);
		}
	}
}
