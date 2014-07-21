package com.dep.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dep.demo.utils.constant.CommonConstants;

public class TestURL {
	public static void main(String[] args) {
		String str = test();
	}
	
	private static String test() {
		StringBuffer document = new StringBuffer();
		URLConnection conn = null;
		BufferedReader reader = null;
		try {
			// URL url = new URL("http://www.baidu.com");
			URL url = new URL("https://bugzilla.mozilla.org/show_bug.cgi?id=544467");
			conn = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null){
				document.append(line + "");
			}
			if(null != reader){
				reader.close();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(document.toString());
		String doc = document.toString();
		int num = doc.indexOf(CommonConstants.STATIC_BUG_STATUS);
		int start = num + CommonConstants.STATIC_BUG_STATUS.length();
		String temStr = doc.substring(start, start + 60);
		System.out.println(temStr.substring(temStr.indexOf('>') + 1, temStr.indexOf('<')));
		return temStr;
	}
}
