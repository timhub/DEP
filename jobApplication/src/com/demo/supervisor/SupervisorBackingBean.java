package com.demo.supervisor;

import java.util.LinkedList;


import com.csvreader.CsvWriter;
import com.test.entity.SupervisorItem;
import com.test.mockups.SupervisorService;

public class SupervisorBackingBean {
	private LinkedList<SupervisorItem> list;
	private LinkedList<SupervisorItem> userList;
	
	public LinkedList<SupervisorItem> initList(){
		SupervisorService service = new SupervisorService();
		list = service.getSupervisorService();
		return list;
	}
	
	public LinkedList<SupervisorItem> getUserlistById(String id){
		
		return userList;
	}
	
	private static void fixClassLoaderIssue(){
	    ClassLoader myClassLoader = CsvWriter.class.getClassLoader();
	    Thread.currentThread().setContextClassLoader(myClassLoader);
	}
	
	public LinkedList<SupervisorItem> getList() {
		return initList();
	}

	public void setList(LinkedList<SupervisorItem> list) {
		this.list = list;
	}
}
