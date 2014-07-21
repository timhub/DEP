package com.demo.supervisor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csvreader.CsvWriter;
import com.test.entity.SupervisorItem;



public class FileDownLoadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.processRequest(req, resp);
	}

	
	
	private void buildFile(){
		CSVUtils cu = new CSVUtils();
		cu.level5CSVCreater();
	}
	
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		buildFile();
		String filepath = "form.csv";
		String fileName = "export.csv";
        long totalsize = 0;
        File f = new File(filepath);
        long filelength = f.length();
        byte[] b = new byte[1024];
        DataInputStream dis = new DataInputStream(new FileInputStream(f));
        response.setContentType("application/x-msdownload");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        ServletOutputStream servletOut = response.getOutputStream();
        while(totalsize < filelength){
        	
             totalsize += 1024;
             if(totalsize > filelength){
                  byte[] leftpart = new byte[1024 - (int)(totalsize - filelength)];
                  dis.readFully(leftpart);
                  servletOut.write(leftpart);
             }
             else{
                  dis.readFully(b);
                  servletOut.write(b);
             }
        }
        servletOut.close();
	}
}
