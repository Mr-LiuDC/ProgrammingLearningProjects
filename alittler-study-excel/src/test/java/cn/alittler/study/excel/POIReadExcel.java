package cn.alittler.study.excel;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class POIReadExcel {

	public static void main(String[] args) {
		// 需要解析的Excel文件
		File file = new File("./excel/poi_test.xls");

		try {
			// 读取文件
			HSSFWorkbook workbook = new HSSFWorkbook(
					FileUtils.openInputStream(file));
			// 根据名称获取工作表
			// HSSFSheet sheet =workbook.getSheet("sheet-1");
			// 根据编号获取工作表
			HSSFSheet sheet = workbook.getSheetAt(0);
			int firstRowNum = 0;
			int lastRowNum = sheet.getLastRowNum(); // 获取最后一行行号
			for (int i = firstRowNum; i <= lastRowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				// 获取当前行最后单元格列号
				int lastCellNum = row.getLastCellNum();
				for (int j = 0; j < lastCellNum; j++) {
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + "  ");
				}
				System.out.println();
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
