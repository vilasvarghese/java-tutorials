package com.barsha;

import java.io.IOException;

public class Automation extends TestBaseSetup {

	public static void main(String[] args) throws IOException {
		String csvFileName = (args==null||args.length==0) ? "TMS.csv" : args[0];
		String testcaseName = (args==null||args.length<2) ? "Logout" : args[1];
		
		Automation automation = new Automation();
		Automation.loadCsv(csvFileName);
		automation.initializeTestBaseSetup();
		
		automation.automate(testcaseName);
		automation.close();
	}
	
	public void automate(String testcaseName) {
		recordsMap.get(testcaseName).forEach(rec -> handleRecord(rec));
	}
	
	public void close() {
		waitTimer(1000);
		getDriver().close();
	}

}
