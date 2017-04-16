package cn.alittler.study.excel.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.web.multipart.MultipartFile;

/**
* <p>Title: 机坪违章处置系统 - ExcelReader2007</p>
*
* <p>Description:只支持excel2007版本</p>
*
*/
public class ExcelReader2007 implements ExcelReaderInterface {

	/**
	 * 工作薄，也就是一个excel文件
	 */
	private XSSFWorkbook wb = null;

	/**
	 * 一个excel文件可以有多个sheet
	 */
	private XSSFSheet sheet = null;

	/**
	 * 代表了表的第一行，也就是列名
	 */
	private XSSFRow row = null;

	/**
	 * 文件输入流
	 */
	private InputStream is = null;
	
	/**
	 * 开始列
	 */
	private int startColumn = 0;

	/**
	 * 结束列
	 */
	private int endColumn = 0;
	
	/**
	 * 用于设置单元格颜色
	 */
	private XSSFCellStyle style;
	
	/**
	 * 绘图对象
	 */
	private XSSFDrawing p;

	/**
	 * 读取excel文件，得到XSSFWorkbook对象
	 * @param file        表示excel文件对象
	 * @throws IOException
	 */
//	public void open(MultipartFile excelFile) throws IOException {
//		is = excelFile.getInputStream();
//		wb = new XSSFWorkbook(is);
//		is.close();
//		style = wb.createCellStyle();
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		style.setFillForegroundColor(HSSFColor.YELLOW.index);
//	}
    
	/**
	 * 设置开始列和结束列
	 * @param startColumn
	 * @param endColumn
	 */
	public void configCol(int startColumn, int endColumn){
		this.startColumn = startColumn;
		this.endColumn = endColumn;
	}
	
	/**
	 * 返回sheet表数目
	 * 
	 * @return int
	 */
	public int getSheetCount() {
		int sheetCount = -1;
		sheetCount = wb.getNumberOfSheets();
		return sheetCount;
	}
	
	 /**
	  * sheetNum下的记录行数
	  * 
	  * @return int
	  */
	 public int getRowCount (int sheetNum ) {
	  XSSFSheet sheet = wb.getSheetAt(sheetNum);
	  int rowCount = -1;
	  rowCount = sheet.getLastRowNum();
	  out:for(int j = rowCount;j > -1;j-- ){
		  row = sheet.getRow(j);
		  int colNums = row.getLastCellNum();
		  for(int i=0; i <=colNums; i++){
			  XSSFCell cell = row.getCell(i);
			  if(cell != null){
				  String cellValue = cell.toString();
				  if(cellValue != null && cellValue.replaceAll("\\s|　", "").length() > 1){
					  break out;
				  }
			  }
		  }
		  rowCount--;
	  }
	  return rowCount;
	 }
	 
	 /**
	  * 返回指定sheetNum、rowNum的列数或单元格数
	  * @return int
	  */
	 public int getCellCount (int sheetNum,int rowNum ){
		 XSSFSheet sheet = wb.getSheetAt(sheetNum);
		 int cellCount = -1;
		 row = sheet.getRow(rowNum);
		 cellCount = row.getLastCellNum();
		 return cellCount;
	 }
	 
	 /**
	  * 返回某个单元格的数据类型
	  * @param sheetNum
	  * @param rowNum
	  * @param colNum
	  * @return int
	  */
	 public int getCellType (int sheetNum,int rowNum,int colNum ) {
		 colNum += startColumn;
		 //单元格数据类型，0表示字符，1表示数字，2表示空，9表示其他
		 int cellType = 0;
	     sheet = wb.getSheetAt(sheetNum);
	     row = sheet.getRow(rowNum);
	     if(row.getCell(colNum) !=null){
	    	 switch(row.getCell(colNum).getCellType()){
	    	 case XSSFCell.CELL_TYPE_STRING:
	    		 cellType = 0;
	    		 break;
	    	 case XSSFCell.CELL_TYPE_NUMERIC:
	    		 cellType = 1;
	    		 break;
	    	 case XSSFCell.CELL_TYPE_BLANK:
	    		 cellType = 2;
	    		 break;
	    	 default:
	    		 cellType = 9;
	    	 }
		  
	     }else{
	    	 cellType = 2;
	     }
	     return cellType;
	 }

	/**
	 * 得到指定工作表和行数的内容
	 * 
	 * @param sheetNum
	 * @param lineNum
	 * @return String[]
	 */
	public String[] readExcelLine(int sheetNum, int lineNum) {
		if (sheetNum < 0 || lineNum < 0) {
			return null;
		}
		String[] strExcelLine = null;
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(lineNum);
			int cellCount = endColumn - startColumn + 1;
			if (cellCount > 0) {
				strExcelLine = new String[cellCount];
			} else {
				return null;
			}
			for (int i = 0; i < cellCount; i++) {
				strExcelLine[i] = readStringExcelCell(sheetNum,lineNum,startColumn+i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelLine;
	}

	/**
	 * 读取指定工作表、行、列下的内容
	 * 
	 * @param sheetNum
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int sheetNum, int rowNum, int cellNum) {
		if (sheetNum < 0 || rowNum < 0) {
			return "";
		}
		String strExcelCell = "";
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(rowNum);
			if (row != null && row.getCell(cellNum) != null) {
				switch (row.getCell(cellNum).getCellType()) {
				case XSSFCell.CELL_TYPE_FORMULA:
					strExcelCell = "FORMULA";
					break;
				case XSSFCell.CELL_TYPE_NUMERIC: {
					strExcelCell = String.valueOf(row.getCell(cellNum).getNumericCellValue());
					Pattern p =Pattern.compile("[0-9]+.[0]+");
					Matcher match = p.matcher(strExcelCell);
					if(match.matches()){
						strExcelCell = strExcelCell.substring(0,strExcelCell.indexOf("."));
					}
				}
					break;
				case XSSFCell.CELL_TYPE_STRING:
					strExcelCell = row.getCell(cellNum).getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					strExcelCell = "";
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					strExcelCell = String.valueOf(row.getCell(cellNum).getBooleanCellValue());
				default:
					strExcelCell = "";
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelCell;
	}
	
	/**
	 * 给单元格添加批注和背景色
	 * @param sheetNum       sheet的序号
	 * @param rowIndex       行号
	 * @param commentNum     批注里的错误信息个数
	 * @param colNum         列号
	 * @param commentValue   批注内容
	 */
	public void addComment(int sheetNum,int rowIndex,int commentNum,int colNum,String commentValue){
		 sheet = wb.getSheetAt(sheetNum);
	     //创建绘图对象 
		 if(p == null){
			 p=sheet.createDrawingPatriarch(); 
		 }
	     XSSFComment comment = p.createCellComment(new XSSFClientAnchor(0,0,0,0,(short)colNum,rowIndex,(short)(colNum+2),rowIndex+2*commentNum)); 
	     //输入批注信息 
	     comment.setString(new HSSFRichTextString(commentValue));
	     comment.setRow(rowIndex);
	     comment.setColumn(colNum);
	     sheet.getRow(rowIndex).getCell(colNum).setCellStyle(style);
	}
	
	/**
	 * 生成回执的excel文件
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void generateReturnExcel(String fileName) throws FileNotFoundException,IOException{
		OutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		fos.close();
		
	}
}
