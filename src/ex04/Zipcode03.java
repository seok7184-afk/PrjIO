package ex04;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode03 {

	public static void main(String[] args) throws IOException {
		// 3. 부산, 울산, 대구 우편번호
		//		부산:3605
		//		울산:820
		//		대구:2782
		
		String  path   =  Zipcode03.class.getResource("").getPath();
		String  fname  =  "zipcode_20130201(1).csv";
		File    file   =  new File(path + fname);
		if(!file.exists()) {
			System.out.println(file + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader     fr  =  new FileReader(file);
		BufferedReader br  =  new BufferedReader(fr);
		
		String         title   =  br.readLine(); // 제목줄 skip
		String         line    =  "";
		int            cnt1    = 0;
		int            cnt2    = 0;
		int            cnt3    = 0;
		

		while((line = br.readLine()) != null) {
			//zipcode,sido,gugun,dong,bunji,seq
			String [] li       =  line.trim().split(",");
			String    zipcode  =  li[0].trim();
			String    sido     =  li[1].trim();
			String    gugun    =  li[2].trim();
			String    dong     =  li[3].trim();
			String    bunji    =  li[4].trim();
			int       seq      =  Integer.parseInt(li[5].trim());
			
			switch (sido) {
			case "부산" :  cnt1++;  break;
			case "대구" :  cnt2++;  break;
			case "울산" :  cnt3++;  break;
			}
			
		}
		System.out.print("부산: " + cnt1 + "건\n");
		System.out.print("대구: " + cnt2 + "건\n");
		System.out.print("울산: " + cnt3 + "건\n");
		
		br.close();
		fr.close();
		
	}

}
