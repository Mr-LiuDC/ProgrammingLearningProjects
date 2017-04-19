package cn.alittler.study.excel.demo.bean;

public class ExcelInfo {

	String reportID;
	String fieldName;
	String projectName;
	String compare_x;
	String compare_width;
	String compare_height;
	String compare_formatmask;
	String old_x;
	String old_width;
	String old_formatmask;
	String new_x;
	String new_width;
	String new_formatmask;

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompare_x() {
		return compare_x;
	}

	public void setCompare_x(String compare_x) {
		this.compare_x = compare_x;
	}

	public String getCompare_width() {
		return compare_width;
	}

	public void setCompare_width(String compare_width) {
		this.compare_width = compare_width;
	}

	public String getCompare_height() {
		return compare_height;
	}

	public void setCompare_height(String compare_height) {
		this.compare_height = compare_height;
	}

	public String getCompare_formatmask() {
		return compare_formatmask;
	}

	public void setCompare_formatmask(String compare_formatmask) {
		this.compare_formatmask = compare_formatmask;
	}

	public String getOld_x() {
		return old_x;
	}

	public void setOld_x(String old_x) {
		this.old_x = old_x;
	}

	public String getOld_width() {
		return old_width;
	}

	public void setOld_width(String old_width) {
		this.old_width = old_width;
	}

	public String getOld_formatmask() {
		return old_formatmask;
	}

	public void setOld_formatmask(String old_formatmask) {
		this.old_formatmask = old_formatmask;
	}

	public String getNew_x() {
		return new_x;
	}

	public void setNew_x(String new_x) {
		this.new_x = new_x;
	}

	public String getNew_width() {
		return new_width;
	}

	public void setNew_width(String new_width) {
		this.new_width = new_width;
	}

	public String getNew_formatmask() {
		return new_formatmask;
	}

	public void setNew_formatmask(String new_formatmask) {
		this.new_formatmask = new_formatmask;
	}

	@Override
	public String toString() {
		return "ExcelInfo [reportID=" + reportID + ", fieldName=" + fieldName
				+ ", projectName=" + projectName + ", compare_x=" + compare_x
				+ ", compare_width=" + compare_width + ", compare_height="
				+ compare_height + ", compare_formatmask=" + compare_formatmask
				+ ", old_x=" + old_x + ", old_width=" + old_width
				+ ", old_formatmask=" + old_formatmask + ", new_x=" + new_x
				+ ", new_width=" + new_width + ", new_formatmask="
				+ new_formatmask + "]";
	}

}
