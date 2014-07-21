package com.dep.demo.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.dep.demo.utils.constant.CommonConstants;

public class RemoteDataService {

	public static synchronized List<String> getRemoteData(final int bugId,String baseUrl){
		StringBuffer document = new StringBuffer();
		URLConnection conn = null;
		BufferedReader reader = null;
		try {
//			URL url = new URL(CommonConstants.TARGET_REACH_URL + bugId);
			URL url = new URL(baseUrl+bugId);
			conn = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null){
				document.append(line + CommonConstants.BLANK);
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
		return getFieldValue(document.toString(), new String[]{
				CommonConstants.FIELD_CONTAINER_COMPONENT, 
				CommonConstants.STATIC_BUG_STATUS});
	}
	
	private static List<String> getFieldValue(final String doc, final String[] types){
		List<String> values = new ArrayList<String>();
		for (String type : types) {
			int num = doc.indexOf(type);
			int start = num + type.length();
			String temStr = doc.substring(start, start + 60);
			values.add(temStr.substring(temStr.indexOf(
					CommonConstants.RIGHT_ANGLE_BRACKETS) + CommonConstants.CONSTANTS_ONE, 
					temStr.indexOf(CommonConstants.LEFT_ANGLE_BRACKETS)).trim());
		}
		return values;
	}
}
