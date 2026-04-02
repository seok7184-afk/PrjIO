package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JinguFile {

	public static void main(String[] args) throws IOException {
		// 7. 부산 부산진구 우편번호를 파일( .csv )로 출력
		String   path   =  JinguFile.class.getResource("").getPath();
		String   fname  =  "zipcode_20130201(1).csv";
		File     file   =  new  File(path + fname);
		
		// 출력파일
		String  path2     =  "D:/dev/java/PrjIO/src/ex04/";
		String  fname2    =  "BusanJingu.txt";
		FileWriter fw     =  new FileWriter(path2 + fname2);
		BufferedWriter bw =  new BufferedWriter(fw);
		
		if(!file.exists()) {
			System.out.println(file + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader       fr   =  new  FileReader(file); 
		BufferedReader   br   =  new  BufferedReader(fr);
		
		br.readLine();
		String  title =  "부산 진구 우편번호\n";
		String  line  =  "";
		bw.write(title);
		
		while((line = br.readLine()) != null) {
			String [] li  =  line.trim().split(",");
			String    zipcode  =  li[0].trim();
			String    sido     =  li[1].trim();
			String    gugun    =  li[2].trim();
			String    dong     =  li[3].trim();
			String    bunji    =  li[4].trim();
			int       seq      =  Integer.parseInt(li[5].trim());
			
			if(gugun.contains("진구") && sido.contains("부산")) {
				System.out.println(zipcode);
				bw.write(zipcode + "\n");
			}
		}
		
		br.close();
	    bw.close();
		
		
		fr.close();
		br.close();

	}

}
