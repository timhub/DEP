package com.dep.demo;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.faces.context.FacesContext;

public class DAPAnylisisBackingBean {
	private LinkedList<DAPAnylisisItem> issueList = new LinkedList<DAPAnylisisItem>();
	private String depInfoJSONData;
	private int depListSize;
	private int flag;
	private int list_flag = 0;
	private String currentIdx;
	private int current_empty_flag = 0;
	private int total;
	
	
	public DAPAnylisisBackingBean(){
		super();
	}
	
	public void initList(){
		createList(depListSize);
	}
	
	public void emptyCheck(){
		for(int i=0;i<issueList.size();i++){
			if(!("".equals(issueList.get(i).getIssueName()))&&(!("".equals(issueList.get(i).getIssueAmount())))){
				issueList.get(i).setFlag(0);
			}else{
				issueList.get(i).setFlag(1);
			}
		}
	}
	
	public void currentInputCheck(){
		for(int i=0;i<issueList.size();i++){
			if(!("".equals(issueList.get(i).getIssueName()))&&(!("".equals(issueList.get(i).getIssueAmount())))){
				list_flag = 0;
//				flag = 0;
			}else{
				list_flag = 1;
				flag = 1;
				break;
			}
		}
	}
	
	public void addItem(){
		flag = 1;
		currentInputCheck();
		emptyCheck();
		if(list_flag == 0){
			DAPAnylisisItem dep = new DAPAnylisisItem();
			Integer a = issueList.size()+1;
			dep.setNum(a.toString());
			issueList.add(dep);
		}else{}
	}
	
	public void delItem(){
		flag = 1;
		if(issueList.size()==1){
			issueList.remove();
			list_flag = 1;
		}else{
			issueList.remove(Integer.parseInt(currentIdx)-1);
			total = caculateTotal();
			for(int i=0;i<issueList.size();i++){
				Integer a = i+1;
				issueList.get(i).setNum(a.toString());
				total = caculateTotal();
			}
		}
	}
	
	public void createList(int amount){
		list_flag = 1;
		if(issueList.isEmpty()){
			while(issueList.size()<amount){
				DAPAnylisisItem item = new DAPAnylisisItem();
				issueList.add(item);
			}
			for(int j=0;j<issueList.size();j++){
				Integer a = j+1;
				issueList.get(j).setNum(a.toString());
			}
			}else if(!(issueList.isEmpty()) && issueList.size()<amount){
				while(issueList.size()<amount){
					Integer b = issueList.size()+1;
					DAPAnylisisItem item = new DAPAnylisisItem();
					item.setNum(b.toString());
					issueList.add(item);
				}
				for(int l=issueList.size();l<amount;l++){
					Integer b = l+1;
					issueList.get(l).setNum(b.toString());
				}
			}else if(!(issueList.isEmpty()) && issueList.size()>amount){
				for(int i=issueList.size()-1;i>=amount;i--){
					issueList.remove(i);
			}
		}	
		flag = 1;
	}
	
	public String getJSONData(){
		emptyCheck();
		currentInputCheck();
		if(list_flag == 0){
			flag = 1;
			depInfoJSONData = null;
			depInfoJSONData = generatJSONData(issueList);
			flag = 0;
			issueList = caculatePersentage(issueList);
//			issueList = caculatePersentageInteger(issueList);
		}else{
			depInfoJSONData = "";
		}		
		return "";
	}
	
	public int caculateTotal(){
		total = 0;
		if(!(issueList.isEmpty())){
			for(int i=0;i<issueList.size();i++){
				if("".equals(issueList.get(i).getIssueAmount())){
					total = total+0;
				}else{
					total = total + Integer.parseInt(issueList.get(i).getIssueAmount());
				}
			}
		}else{}
		return total;
	}
	
	public String generatJSONData(LinkedList<DAPAnylisisItem> list){
		total = 0;
		StringBuffer JsonData= new StringBuffer("[");
		for(int i=0;i<list.size();i++){
			JsonData.append("{issueName:\'")
					.append(list.get(i).getIssueName())
					.append("\',issueAmount:\'")
					.append(list.get(i).getIssueAmount())
					.append("\'},");
		}
		JsonData.deleteCharAt(JsonData.length()-1);  
		JsonData.append("]");
		flag = 0;
		caculateTotal();
		return JsonData.toString();
	}

	public LinkedList<DAPAnylisisItem> caculatePersentage(LinkedList<DAPAnylisisItem> list){
		double totalAmount = 0;
		DecimalFormat df = new DecimalFormat("0.00");
			for(int i=0;i<list.size();i++){
				totalAmount = totalAmount + Double.parseDouble(list.get(i).getIssueAmount());
			}
		for(int j=0;j<list.size();j++){
			double persentage = 100*Double.parseDouble(list.get(j).getIssueAmount())/totalAmount;
			String persentageResult = "";
			persentageResult = df.format(persentage).toString() + "%";
			list.get(j).setPersentage(persentageResult);
		}
		
		return list;
	}
	
	protected void redirect(String url){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(url);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("redirect to :"+url);
		}
	}
	
	protected void redirectInternal(String url){
		//add session token
		redirect("/jobApplication/" + url);
	}
	
	public void ViewLoginPageAction(){
		redirectInternal("login.jsf");
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	public LinkedList<DAPAnylisisItem> getIssueList() {
		return issueList;
	}

	public void setIssueList(LinkedList<DAPAnylisisItem> issueList) {
		this.issueList = issueList;
	}

	public String getDepInfoJSONData() {
		return depInfoJSONData;
	}

	public void setDepInfoJSONData(String depInfoJSONData) {
		this.depInfoJSONData = depInfoJSONData;
	}

	public int getDepListSize() {
		return depListSize;
	}

	public void setDepListSize(int depListSize) {
		this.depListSize = depListSize;
	}

	public String getCurrentIdx() {
		return currentIdx;
	}

	public void setCurrentIdx(String currentIdx) {
		this.currentIdx = currentIdx;
	}

	public int getCurrent_empty_flag() {
		return current_empty_flag;
	}

	public void setCurrent_empty_flag(int current_empty_flag) {
		this.current_empty_flag = current_empty_flag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getList_flag() {
		return list_flag;
	}

	public void setList_flag(int list_flag) {
		this.list_flag = list_flag;
	}
}
