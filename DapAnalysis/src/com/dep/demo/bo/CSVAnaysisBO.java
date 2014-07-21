package com.dep.demo.bo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.csvreader.CsvReader;
import com.dep.demo.CSVDataBean;
import com.dep.demo.ClassificationDataBean;

public class CSVAnaysisBO {
	
	private CsvReader cr = null;
	
	private LinkedList<CSVDataBean> dataList = new LinkedList<CSVDataBean>();
	List<String[]> listFile = new ArrayList<String[]>();
	private LinkedList<ClassificationDataBean> classList = new LinkedList<ClassificationDataBean>();
	private String json;
	
	public CSVAnaysisBO(String f) throws IOException {  
		cr = new CsvReader(f,',',Charset.forName("utf-8"));
		readCsv();
    }  
	
	public void readCsv() throws IOException{
		try {
			cr.readHeaders();
			while(cr.readRecord()){
				listFile.add(cr.getValues());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public LinkedList<CSVDataBean> ganerateDataList(){
		if(!listFile.isEmpty()){
			for(int i=0;i<listFile.size();i++){
				CSVDataBean data = new CSVDataBean();
				data.setBug_id(listFile.get(i)[0]);
				data.setBug_severity(listFile.get(i)[1]);
				data.setPriority(listFile.get(i)[2]);
				data.setOp_sys(listFile.get(i)[3]);
				data.setAssigned_to(listFile.get(i)[4]);
				data.setBug_status(listFile.get(i)[5]);
				data.setResolution(listFile.get(i)[6]);
				data.setShort_desc(listFile.get(i)[7]);
				
				dataList.add(data);
			}
		}
		return dataList;
	}
	
	public int hasNode(LinkedList<ClassificationDataBean> classList, String colData){
		int hasNode = -1;
		if(classList.size()<1 || classList.isEmpty()){
			hasNode = -1;
		} else {
			for(int i=0;i<classList.size();i++){
				if(colData.equals(classList.get(i).getColData())){
					hasNode = i;
				}
			}
		}
		
		return hasNode;
	}

	public LinkedList<ClassificationDataBean> ganerateClassListBySeverity(){
		if(!dataList.isEmpty()){
			for(int i=0;i<dataList.size();i++){
				int hasFlag = hasNode(classList,dataList.get(i).getBug_severity().substring(0, 2));
				if(hasFlag != -1){
					int count = classList.get(hasFlag).getCount()+1;
					String coldata = classList.get(hasFlag).getColData();
					ClassificationDataBean update = new ClassificationDataBean();
					update.setColData(coldata);
					update.setCount(count);
					classList.set(hasFlag, update);
				} else {
					ClassificationDataBean newClass = new ClassificationDataBean();
					newClass.setColData(dataList.get(i).getBug_severity().substring(0, 2));
					newClass.setCount(1);
					classList.add(newClass);
				}
			}
			caculateSeverityPersentage();
			sortClassList(classList);
		}
		
		return classList;
	}
	
	public String ganerateSeverityClassJsonData(){
		StringBuffer result = new StringBuffer("[");
		ganerateDataList();
		LinkedList<ClassificationDataBean> classList = this.ganerateClassListBySeverity();
		boolean biuldstate = false;
		for(int i=0;i<classList.size();i++){
			if(classList.size()>1 && biuldstate){
				result.append(",");
			}
			biuldstate = true;
			result.append("{");
			result.append("colName : '").append(classList.get(i).getColData()).append("',");
			result.append("amount : '").append(classList.get(i).getCount()).append("'");
			result.append("}");
		}
		
		result.append("]");
		String resultStr = result.toString();
		return resultStr;
	}
	
	public void sortClassList(LinkedList<ClassificationDataBean> classList){
		if(!classList.isEmpty()){
			ClassificationDataBean temp = new ClassificationDataBean();
			for(int i=0;i<classList.size()-1;i++){
				for(int j=0;j<classList.size()-1-i;j++){
					temp = classList.get(j);
					int mark_1 = Integer.parseInt(temp.getColData().toString().substring(1, 2));
					int mark_2 = Integer.parseInt(classList.get(j+1).getColData().toString().substring(1, 2));
					if(mark_1>mark_2){
						classList.set(j, classList.get(j+1));
						classList.set(j+1, temp);
					} else {
						temp = classList.get(j);
					}
				}
			}
		}
	}
	
	public void caculateSeverityPersentage(){
		double totalAmount = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		for(int i=0;i<classList.size();i++){
			totalAmount = totalAmount + classList.get(i).getCount();
		}
		for(int j=0;j<classList.size();j++){
			double percentage = 100*((classList.get(j).getCount())/totalAmount);
			String percentageResult = "";
			percentageResult = df.format(percentage).toString() + "%";
			classList.get(j).setPercentage(percentageResult);
		}
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public CsvReader getCr() {
		return cr;
	}

	public void setCr(CsvReader cr) {
		this.cr = cr;
	}

	public List<String[]> getListFile() {
		return listFile;
	}

	public void setListFile(List<String[]> listFile) {
		this.listFile = listFile;
	}
}
