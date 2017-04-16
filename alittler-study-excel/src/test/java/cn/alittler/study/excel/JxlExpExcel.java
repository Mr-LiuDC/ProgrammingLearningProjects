package cn.alittler.study.excel;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JxlExpExcel {

	public static void main(String[] args) {
		// 表头数组
		String title[] = { "id", "name", "sex" };
		// 创建Excel文件
		File file = new File("./excel/jxl_test.xls");
		try {
			file.createNewFile();
			// 创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			// 创建sheet
			WritableSheet sheet = workbook.createSheet("sheet1", 0);
			Label label = null;
			// 第一行设置列名
			for (int i = 0; i < title.length; i++) {
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			// 追加数据 i=1 表示从第二行开始添加，如果从第一行开始会把表头覆盖
			for (int i = 1; i < 10; i++) {
				label = new Label(0, i, "id_" + i);
				sheet.addCell(label);
				label = new Label(1, i, "someone" + i);
				sheet.addCell(label);
				label = new Label(2, i, "男");
				sheet.addCell(label);
			}
			// 写入数据
			workbook.write();
			// 关闭
			workbook.close();
		} catch (Exception e) {

		}
	}

}
