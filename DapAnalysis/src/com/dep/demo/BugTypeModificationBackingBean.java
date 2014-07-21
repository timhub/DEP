package com.dep.demo;

import java.util.List;
import java.util.Map;

import com.dep.demo.common.BaseBackingBean;
import com.dep.demo.hibernate.pojo.BugType;
import com.dep.demo.hibernate.pojo.BugTypeSub;

public class BugTypeModificationBackingBean extends BaseBackingBean{
	private List<BugType> bugTypeList;
	private Map<String,List<String>> bugTypeMap;
	
	private BugTypeSub currentBugSubType;
	private BugType currentBugType;
	
	private boolean addNewTypeFlag = true; // for displaying error message for bug types
	
	public BugTypeModificationBackingBean(){
		bugTypeList = bugTypeService.getAllTypes();
		currentBugType = bugTypeList.get(0);
//		int currentSubTypeId = Integer.parseInt(bugTypeList.get(0).getBugTypeSubNumber()) ;
//		currentBugSubType = (BugTypeSub) bugTypeService.getSubTypesById(currentSubTypeId);
		
	}
	
	//====================about to fix
	public BugTypeSub getCurrentSubType(){
		currentBugSubType = bugTypeService.getSubTypesById(Integer.parseInt(currentBugType.getBugTypeSubNumber()));
		return currentBugSubType;
	}
	
	public void addNewBugType(){
		BugType newType = new BugType();
		for(BugType bean : bugTypeList){
			if(bean.getBugTypeCategory() == null){
				addNewTypeFlag = false;
				break;
			}
			if(addNewTypeFlag == true){
				bugTypeList.add(newType);
			}
		}
	}
	
//	public Map<String,List<String>> mappingBugTypes(){
//		if(bugTypeList != null){
//			for(BugType bean : bugTypeList){
//				String subList = bugTypeService.getSubTypesById(bean.getBugTypeId()).getBugTypeSubCategory();
//			}
//		}
//		return bugTypeMap;
//	}
	
	public void updateBugTypes(){
		bugTypeService.updateAllTypes(bugTypeList);
	}

	public Map<String,List<String>> getBugTypeMap() {
		return bugTypeMap;
	}

	public void setBugTypeMap(Map<String,List<String>> bugTypeMap) {
		this.bugTypeMap = bugTypeMap;
	}

	public List<BugType> getBugTypeList() {
		return bugTypeList;
	}

	public void setBugTypeList(List<BugType> bugTypeList) {
		this.bugTypeList = bugTypeList;
	}
	
	public static void main(String[] args) {
		BugTypeModificationBackingBean bean = new BugTypeModificationBackingBean();
		System.out.println(bean.bugTypeList.toString());
	}

	public BugType getCurrentBugType() {
		return currentBugType;
	}

	public void setCurrentBugType(BugType currentBugType) {
		this.currentBugType = currentBugType;
	}

	public BugTypeSub getCurrentBugSubType() {
		return currentBugSubType;
	}

	public void setCurrentBugSubType(BugTypeSub currentBugSubType) {
		this.currentBugSubType = currentBugSubType;
	}
}
