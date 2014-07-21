package com.dep.demo.action;

import java.util.LinkedList;

import javax.annotation.PostConstruct;

import com.dep.demo.CSVDataBean;
import com.dep.demo.ClassificationDataBean;
import com.dep.demo.common.BaseBackingBean;

public class ClassificationAnaysisBackingBean extends BaseBackingBean{
	
	private String chartJson;
	private LinkedList<CSVDataBean> dataList = new LinkedList<CSVDataBean>();
	private LinkedList<ClassificationDataBean> classList = new LinkedList<ClassificationDataBean>();
	private LinkedList<ClassificationDataBean> classifyList = new LinkedList<ClassificationDataBean>();
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	private void init(){
		chartJson = (String) httpSession.getAttribute("chartJson");
		dataList = (LinkedList<CSVDataBean>)httpSession.getAttribute("dataList");
		classList = (LinkedList<ClassificationDataBean>)httpSession.getAttribute("classList");
	}
	
	public void ganerateClassifyList(){
		if(!dataList.isEmpty()){
			for(int i=0;i<dataList.size();i++){
				ClassificationDataBean data = new ClassificationDataBean();
				if(!"".equals(dataList.get(i).getClassification())){
					data.setColData(dataList.get(i).getClassification());
					data.setDisplayClassFlag(true);
				} else {
					data.setDisplayClassFlag(false);
				}
			}
		}
	}

	public String getChartJson() {
		return chartJson;
	}

	public void setChartJson(String chartJson) {
		this.chartJson = chartJson;
	}

	public LinkedList<CSVDataBean> getDataList() {
		return dataList;
	}

	public void setDataList(LinkedList<CSVDataBean> dataList) {
		this.dataList = dataList;
	}

	public LinkedList<ClassificationDataBean> getClassList() {
		return classList;
	}

	public void setClassList(LinkedList<ClassificationDataBean> classList) {
		this.classList = classList;
	}
	

}
