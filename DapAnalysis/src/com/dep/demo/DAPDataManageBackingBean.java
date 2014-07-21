package com.dep.demo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.dep.demo.common.BaseBackingBean;
import com.dep.demo.hibernate.pojo.BugInfo;
import com.dep.demo.hibernate.pojo.BugType;
import com.dep.demo.misc.RemoteDataService;

public class DAPDataManageBackingBean extends BaseBackingBean {
	RemoteDataService service = new RemoteDataService();
	LinkedList<CSVDataBean> dataList = new LinkedList<CSVDataBean>();
	
	private String baseUrl;

	@SuppressWarnings("unchecked")
	public DAPDataManageBackingBean(){
		ExternalContext ext = ctx.getExternalContext();	
		HttpSession session = (HttpSession) ext.getSession(true);
		dataList = (LinkedList<CSVDataBean>) session.getAttribute("dataList");
	}
	
	public void getComponentData(){
		for(int i=0;i<dataList.size();i++){
			@SuppressWarnings("static-access")
			List<String> result = service.getRemoteData(Integer.parseInt(dataList.get(i).getBug_id()),baseUrl);
			if(!result.isEmpty()){
				dataList.get(i).setComponent(result.get(0));
				dataList.get(i).setComponentFlag(true);
			}
		}
	}

	public void viewAnalysisPage(){
		FacesContext ctx =  FacesContext.getCurrentInstance();
		try {
			saveAllBugs();
			ctx.getExternalContext().redirect("dapAnaysis.jsf");
			ctx.responseComplete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveAllBugs(){
		for(CSVDataBean bean : dataList){
			BugInfo newBean = new BugInfo();
			newBean.setBugInfId(Integer.parseInt(bean.getBug_id()));
			newBean.setSeverty(bean.getBug_severity());
			newBean.setAssignee(bean.getAssigned_to());
			newBean.setPriority(bean.getPriority());
			newBean.setStatus(bean.getBug_status());
			newBean.setComponent(bean.getComponent());
			newBean.setAttach3(bean.getClassification());
			newBean.setShotDesc(bean.getShort_desc());
			
			bugTypeService.saveAllBugInfo(newBean);
		}
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
