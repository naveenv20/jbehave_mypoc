package com.learnjbehave;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;




public class Util {
		
	
	
	public static boolean checkstoryrunmode(String stroryname,String suitename){
		Xls_Reader xls_suite_testcase=new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\learnjbehave\\testdata\\"+suitename+".xlsx");
		for(int i=1;i<=xls_suite_testcase.getRowCount("StoryNames");i++){
			System.out.println("ENTEREDDDDDDDDDDDDDDDDDDDDDDDDD");
			if(xls_suite_testcase.getCellData("StoryNames", "StoryName", i).equalsIgnoreCase(stroryname)){
			System.out.println("^&*^&*^^&*^*&^&*^&*^^&*^^^ENTERED");
				if(xls_suite_testcase.getCellData("StoryNames", "RunMode", i).equalsIgnoreCase("Yes")){
					return true;
				}
				else
					return false;
				
			}
			
			
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
			
		

		
		
	
	public static Hashtable<String, String> getobjectdata(String testcasename, String suitename){
		
		Xls_Reader xls_suite_testcase=new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\learnjbehave\\testdata\\"+suitename+".xlsx");
		
		int rownum;
		TestUtil.APPLICATION_LOG.debug(("*****"+xls_suite_testcase.getRowCount("ObjectData")));
		
		for(rownum=0;rownum<xls_suite_testcase.getRowCount("ObjectData");rownum++){
			
			if(xls_suite_testcase.getCellData("ObjectData", 0, rownum).equalsIgnoreCase(testcasename)){
				System.out.println("Test case found   :"+testcasename);
				break;
			}
		}
		
		int objectstartrownum=rownum+2;
		int objectendrownum=objectstartrownum;
		int objectscount=0;
		
		while(!(xls_suite_testcase.getCellData("ObjectData", 0, objectendrownum).equalsIgnoreCase(""))){
			objectscount++;objectendrownum++;
		}
		
		Hashtable<String, String> objecthash=new Hashtable<String, String>();
		for(int rnum=objectstartrownum;rnum<objectendrownum;rnum++){
			objecthash.put(xls_suite_testcase.getCellData("ObjectData", 0, rnum), xls_suite_testcase.getCellData("ObjectData", 1, rnum));
		}
		
		
	System.out.println(objecthash);	
		return objecthash;
		
		
	}


}
