package cn.alittler.study.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIExpExcel {

	public static void main(String[] args) {
		String title[] = { "id", "name", "sex" };
		// 创建Excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表sheet
		HSSFSheet sheet = workbook.createSheet("sheet-1");
		// 创建第一行
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		// 插入第一行表头数据
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		// 追加数据
		for (int i = 1; i <= 10; i++) {
			HSSFRow row2 = sheet.createRow(i);
			HSSFCell cell2 = row2.createCell(0);
			cell2.setCellValue("id_" + i);
			cell2 = row2.createCell(1);
			cell2.setCellValue("someone" + i);
			cell2 = row2.createCell(2);
			cell2.setCellValue("女");
		}

		// 创建一个Excel文件
		File file = new File("./excel/poi_test.xls");
		try {
			file.createNewFile();
			// 写入数据
			FileOutputStream outputStream = FileUtils.openOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
