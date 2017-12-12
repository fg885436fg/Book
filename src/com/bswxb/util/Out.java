package com.bswxb.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
public class Out {

	/*
	 * @param name  书的地址
	 * @param value  反馈内容
	 * @param IP     请求者的真实IP
	 * */
	public void outText(String value,String txtName) {
		
		
		Date date= new Date(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		FileOutputStream fs = null;
		try {
			

			fs = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\"+txtName+".txt"),true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			
			
		}
		PrintStream pw = new PrintStream(fs);

		
		pw.println(value);
		pw.flush();
		pw.close();
		
		
	}
	
	
	
	
	
}
