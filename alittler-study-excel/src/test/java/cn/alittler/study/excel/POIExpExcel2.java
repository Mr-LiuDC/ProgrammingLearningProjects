package cn.alittler.study.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// 对于高版本Excel，不确定用户的Excel版本，为了兼容性推荐使用HSSF
public class POIExpExcel2 {

	public static void main(String[] args) {
		String title[] = { "id", "name", "sex" };
		// 创建Excel工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 创建一个工作表sheet
		XSSFSheet sheet = workbook.createSheet("sheet-1");
		// 创建第一行
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = null;
		// 插入第一行表头数据
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
		}
		// 追加数据
		for (int i = 1; i <= 10; i++) {
			XSSFRow row2 = sheet.createRow(i);
			XSSFCell cell2 = row2.createCell(0);
			cell2.setCellValue("id_" + i);
			cell2 = row2.createCell(1);
			cell2.setCellValue("someone" + i);
			cell2 = row2.createCell(2);
			cell2.setCellValue("女");
		}

		// 创建一个Excel文件
		File file = new File("./excel/poi_test.xlsx");
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
