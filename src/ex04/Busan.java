package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Busan {

	public static void main(String[] args) throws IOException {
		// 6. 부산의 부전2동 우편번호만 출력
		String   path   =  Busan.class.getResource("").getPath();
		String   fname  =  "zipcode_20130201(1).csv";
		File     file   =  new  File(path + fname);
		
		if(!file.exists()) {
			System.out.println(file + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader       fr   =  new  FileReader(file); 
		BufferedReader   br   =  new  BufferedReader(fr);
		
		br.readLine();
		String  line  =  "";
		while((line = br.readLine()) != null) {
			String [] li  =  line.trim().split(",");
			String    zipcode  =  li[0].trim();
			String    sido     =  li[1].trim();
			String    gugun    =  li[2].trim();
			String    dong     =  li[3].trim();
			String    bunji    =  li[4].trim();
			int       seq      =  Integer.parseInt(li[5].trim());
			
			if(dong.contains("부전2동")) {
				System.out.println(zipcode);
			}
		}
		
		fr.close();
		br.close();

	}

}
