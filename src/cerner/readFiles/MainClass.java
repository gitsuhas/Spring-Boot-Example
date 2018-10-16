package cerner.readFiles;

import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MainClass {
	static JSONArray array = new JSONArray();
	public static void main(String[] args) {
		File folder = new File("C:\\www");
		JSONArray obj=getReport(folder);
		System.out.println(obj);
		String s1="C:\\Users\\SH051551\\Downloads\\sts-bundle\\pivotal-tc-server-developer-3.2.4.SR1\\base-instance\\webapps\\ApplicationReports\\www\\index.html";
		System.out.println(s1.substring(s1.lastIndexOf("\\ApplicationReports"),s1.length()));

	}
	
	@SuppressWarnings("unchecked")
	public static JSONArray getReport(File folder){		
		
		
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {	        	      
	        	getReport(fileEntry);
	        } else {
	        	
	        	if(fileEntry.getAbsolutePath().contains(".html")){
	        		JSONObject fileObject= new JSONObject();
	        	fileObject.put("name",	fileEntry.getName());
	        	fileObject.put("path", fileEntry.getPath());	
	        	if(!fileObject.isEmpty()){
	    			array.add(fileObject);
	    		}	
	        	}
	        }
	    }
			
				
		return array;
		
	}

}
