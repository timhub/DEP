package com.dep.demo.common;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.dep.demo.utils.CMessageLog;

public class BaseBackingBean {

	protected HttpSession httpSession;
	protected CMessageLog messageLog = CMessageLog.getInstance();
	
	protected FacesContext ctx;

	public BaseBackingBean() {
		httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		setCtx(FacesContext.getCurrentInstance());
	}

	public FacesContext getCtx() {
		return ctx;
	}

	public void setCtx(FacesContext ctx) {
		this.ctx = ctx;
	}
	
}
