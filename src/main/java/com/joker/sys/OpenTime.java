package com.joker.sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wanggang
 * @date 2018年5月3日 下午5:12:58
 * 
 */
public class OpenTime {
	  
	/** 
	 * @param args 
	 */  
	public static void main(String[] args) throws Exception {
		System.out.println(OpenTime.readSystemStartTime());
	}
	
	public static String readSystemStartTime() throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec("cmd /c net statistics workstation");
		String startUpTime = "";
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		int i = 0;
		String timeWith = "";
		while ((timeWith = bufferedReader.readLine()) != null) {
			if (i == 3) {
				System.out.println(timeWith);
				startUpTime = timeWith;
			}
			i++;
		}
		process.waitFor();
		return startUpTime;
	}
	
}
