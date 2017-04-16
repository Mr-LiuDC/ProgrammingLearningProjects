package cn.alittler.study.excel.util;

import java.io.FileNotFoundException;
import java.io.IOException;

//import org.springframework.web.multipart.MultipartFile;

/**
* <p>Title: 机坪违章处置系统 - ExcelReaderInterface</p>
*
* <p>Description:读取Excel文件的接口</p>
*
*/
public interface ExcelReaderInterface {
	
	/**
	 * 读取excel文件获得Workbook对象
	 * @param excelFile        表示excel文件对象
	 * @throws IOException
	 */
//	void open(MultipartFile excelFile) throws IOException;
	
	/**
	 * 设置开始列和结束列
	 * @param startColumn
	 * @param endColumn
	 */
	void configCol(int startColumn, int endColumn);
	
	/**
	 * 返回sheet表数目
	 * @return int
	 */
	int getSheetCount();
	
	 /**
	  * 返回指定sheetNum的sheet下的记录行数
	  * @return int
	  */
	 public int getRowCount (int sheetNum );
	 
	 /**
	  * 返回指定sheetNum,rowNum的的列数或单元格数
	  * @return int
	  */
	 public int getCellCount (int sheetNum,int rowNum );
	 
	 /**
	  * 返回某个单元格的数据类型
	  * @param sheetNum
	  * @param rowNum
	  * @param colNum
	  * @return int
	  */
	 public int getCellType (int sheetNum,int rowNum,int colNum );
	
	/**
	 * 得到某个工作表下的某一行的内容
	 * @param sheetNum
	 * @param lineNum
	 * @return String[]
	 */
	String[] readExcelLine(int sheetNum, int lineNum);
	
	/**
	 * 得到指定工作表、行、列下的内容，即得到某个单元格的内容
	 * @param sheetNum
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	String readStringExcelCell(int sheetNum, int rowNum, int cellNum);
	
	/**
	 * 给单元格添加批注和背景色
	 * @param sheetNum       sheet的序号
	 * @param rowIndex       行号
	 * @param commentNum     批注里的错误信息个数
	 * @param colNum         列号
	 * @param commentValue   批注内容
	 */
	void addComment(int sheetNum,int rowIndex,int commentNum,int colNum,String commentValue);
	
	/**
	 * 生成回执的excel文件
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void generateReturnExcel(String fileName) throws FileNotFoundException,IOException;

}
