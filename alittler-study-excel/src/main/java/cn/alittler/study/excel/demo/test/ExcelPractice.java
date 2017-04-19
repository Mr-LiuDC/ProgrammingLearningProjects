package cn.alittler.study.excel.demo.test;

import java.io.File;
import java.util.List;

import org.junit.Test;

import cn.alittler.study.excel.demo.bean.ExcelInfo;
import cn.alittler.study.excel.demo.util.ExcelHelper;
import cn.alittler.study.excel.demo.util.XssfExcelHelper;

public class ExcelPractice {

	@Test
	public void test_readExcel() throws Exception {
		File file = new File("excel/field_diff_result_single0.xlsx");
		ExcelHelper excelHelper = XssfExcelHelper.getInstance(file);
		List<ExcelInfo> infos = excelHelper.readExcel(ExcelInfo.class, 0, true);
		for (ExcelInfo excelInfo : infos) {
			System.out.println(excelInfo);
		}
		System.out.println(infos.size());

		file = new File("excel/field_diff_result_single-1.xlsx");
		excelHelper = XssfExcelHelper.getInstance(file);
		excelHelper.writeExcel(ExcelInfo.class, infos);
	}
}
