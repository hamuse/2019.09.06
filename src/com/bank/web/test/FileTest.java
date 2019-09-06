package com.bank.web.test;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
public class FileTest {
	public static final String FILE_PATH= String.format("C:%sUsers%suser%seclipse-jee%sjee.bitcamp%sbuild%sWebContent%sresources%stxt%s",
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator,
											File.separator);  
																	//저장할 파일 주소 복사해와서 \추가해 주고 뒤에 test.txt 붙으면 파일이 된다. 
																				//.txt가 없어야  디렉토리가 된다

	public static void main(String[] args) {
		try {
			File file = new File(FILE_PATH+"List.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			BufferedReader reader = new BufferedReader(new FileReader (file));
			StringBuffer buff = null;
			List<String> list = new ArrayList<>();
			 while(true) {
				 switch(JOptionPane.showInputDialog("0.종료 1.저장2.읽기")) {
				 case "0" : JOptionPane.showMessageDialog(null, "종료");
				    	  return;
				 case "1" : 
					 String msg = JOptionPane.showInputDialog("메세지를 입력해주세요. 데이터사이에 , 입력");
				writer.write(msg); //입력받은걸 씌우는거 set느낌
				writer.newLine();//줄바꿈
				writer.flush();//한꺼번에 보내줌
				 break;
				 case "2" : 
					while((msg=reader.readLine()) != null) {
						list.add(msg+"/");
					 }
					 JOptionPane.showMessageDialog(null, list);
					 reader.close();
					 break;
				 }
			 }
		}catch(Exception e) {
		 e.printStackTrace();
		}
		
		 }
	}

