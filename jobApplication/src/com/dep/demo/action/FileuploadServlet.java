package com.dep.demo.action;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dep.demo.CSVDataBean;
import com.dep.demo.ClassificationDataBean;
import com.dep.demo.bo.CSVAnaysisBO;
import com.dep.demo.utils.CMessageLog;
import com.dep.demo.utils.GeneralUtils;

/**
 * Servlet implementation class FileuploadServlet
 */
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected CMessageLog messageLog = CMessageLog.getInstance();

	private String fullPath;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileuploadServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		messageLog.debug("FileuploadServlet.doPost inited.");
		req.setCharacterEncoding("UTF-8");
		copyFile(req, resp);
		String temStr = fullPath.replace("\\", "/");
		messageLog.debug("The new full path is: " + fullPath);
		
		CSVAnaysisBO backingBean = new CSVAnaysisBO(temStr);
		String chartJson = backingBean.ganerateSeverityClassJsonData();
		LinkedList<CSVDataBean> dataList = backingBean.getDataList();
		LinkedList<ClassificationDataBean> classList = backingBean.getClassList();
				
		req.getSession().setAttribute("chartJson", chartJson);
		req.getSession().setAttribute("dataList", dataList);
		req.getSession().setAttribute("classList", classList);
		
		messageLog.debug("FileuploadServlet.doPost finished.");
		resp.sendRedirect("dataManage.jsf");
	}

	private void copyFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		FileItemFactory factory = new DiskFileItemFactory();

		// create temp file dir
		File tempFile = new File(this.getServletContext().getRealPath("/temp"));
		((DiskFileItemFactory) factory).setSizeThreshold(1024 * 1024);
		((DiskFileItemFactory) factory).setRepository(tempFile);

		ServletFileUpload upload = new ServletFileUpload(factory);
		// max size of data 50M
		upload.setSizeMax(1024 * 1024 * 50);
		// sigle file mas size 6M
		upload.setFileSizeMax(1024 * 1024 * 12);

		List items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			messageLog.error(e, "An error occured!");
		}

		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			// if simple data type
			if (item.isFormField()) {
				String fieldName = item.getFieldName();
				String value = item.getString();
				messageLog.debug("Is simple data, ignore it. name: " + fieldName + "value：" + value);

				req.setAttribute(fieldName, value);
			} else {
				// file type logic
				long d = item.getSize();
				messageLog.debug("file size is: " + d);
				if (d > upload.getSizeMax()) {
					try {
						resp.sendRedirect("/index");
						messageLog.debug("file size is bigger then 6M, redirect to /index");
					} catch (IOException e) {
						messageLog.error(e, "An IOException occured!");
					}
				}
				String fileName = item.getName();
				int index = fileName.lastIndexOf("\\");
				fileName = fileName.substring(index + 1);
				messageLog.debug("file name is: " + fileName);
				req.setAttribute("realFileName", fileName);

				// copy file
				String basePath = this.getServletContext().getRealPath(
						"/uploadFile");
				messageLog.debug("copy file path is: " + basePath);
				GeneralUtils.mkDir(basePath);
				File file = new File(basePath, fileName);
				fullPath = basePath + "/" + fileName;
				try {
					item.write(file);
					messageLog.debug("copy file successful: " + basePath + "\\" + fileName);
				} catch (Exception e) {
					messageLog.error(e, "Copy file error: " + basePath + "\\" + fileName);
				}
			}
		}
	}

}
