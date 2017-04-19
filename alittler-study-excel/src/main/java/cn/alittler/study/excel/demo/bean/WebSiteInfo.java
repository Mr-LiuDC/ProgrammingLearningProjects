package cn.alittler.study.excel.demo.bean;

public class WebSiteInfo {

	String reportID;
	String fieldName;
	String projectName;

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

	@Override
	public String toString() {
		return "WebSiteInfo [reportID=" + reportID + ", fieldName=" + fieldName
				+ ", projectName=" + projectName + "]";
	}

}
