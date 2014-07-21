package com.dep.demo.hibernate.service;

import java.util.List;

import com.dep.demo.common.BaseBackingBean;
import com.dep.demo.hibernate.dao.impl.BugInfoDAOExt;
import com.dep.demo.hibernate.dao.impl.BugTypeDAOExt;
import com.dep.demo.hibernate.dao.impl.BugTypeSubDAOExt;
import com.dep.demo.hibernate.pojo.BugInfo;
import com.dep.demo.hibernate.pojo.BugType;
import com.dep.demo.hibernate.pojo.BugTypeSub;
import com.dep.demo.utils.constant.CommonConstants;

public class BugTypeService {
	BugTypeDAOExt bugBackingFunction = new BugTypeDAOExt();
	BugTypeSubDAOExt subBackingFunction = new BugTypeSubDAOExt();
	BugInfoDAOExt bugInfoBackingFunction = new BugInfoDAOExt();
	
	public void updateAllTypes(List<BugType> targetList){
		for(BugType bean:  targetList){
			bugBackingFunction.save(bean);
		}
	}
	
	public void updataSubTypes(BugTypeSub bean){
		subBackingFunction.save(bean);
	}
	
	@SuppressWarnings({"unchecked", "null"})
	public List<BugType> getAllTypes(){
		List<BugType> resultList = null;
		resultList = (List<BugType>)bugBackingFunction.findAll();
		if(resultList.size() == 0){
			BugType newBean = new BugType();
			resultList.add(newBean);
		}
		return resultList;
	}
	
	public BugTypeSub getSubTypesById(int id){
		BugTypeSub subType = new BugTypeSub();
		subType = subBackingFunction.findById(id);
		if(subType == null){
			BugTypeSub newBean = new BugTypeSub();
			return newBean;
		} else {
			return subType;
		}
		
		
	}
	
	@SuppressWarnings("null")
	public List<String> generateSubTypeList(BugTypeSub bugType){
		List<String> result = null;
		String bugList = bugType.getBugTypeSubCategory();
		StringBuffer buffer = new StringBuffer(bugList);
		int index = 0;
		if(bugList != null){
			while(index<buffer.length()){
				int match = buffer.indexOf(CommonConstants.DEFAULT_SUB_TYPE_SEPERATE_SIMBOL, index);
				String singleItem = bugList.substring(index, match);
				result.add(singleItem);
				index = match;
			}
		}
		return result;
	}
	
	public String mergeBugSubList(List<String> bugSubList){
		StringBuffer list = new StringBuffer();
		for(String str : bugSubList){
			list.append(str);
			list.append(CommonConstants.DEFAULT_SUB_TYPE_SEPERATE_SIMBOL);
		}
		String result = list.toString();
		return result;
	}
	
	public void saveAllBugInfo(BugInfo info){
		bugInfoBackingFunction.save(info);
	}
}
