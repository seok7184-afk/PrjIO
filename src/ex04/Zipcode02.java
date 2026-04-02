package ex04;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode02 {

	public static void main(String[] args) throws IOException {
		//2. (읍면동 건물명:) 입력받아 출력
		Scanner  in    =  new Scanner(System.in);
		
		
		String  path   =  Zipcode02.class.getResource("").getPath();
		String  fname  =  "zipcode_20130201(1).csv";
		File    file   =  new File(path + fname);
		
		FileReader     fr  =  new FileReader(file);
		BufferedReader br  =  new BufferedReader(fr);
		
		String         title   =  br.readLine(); // 제목줄 skip
		String         line    =  "";
		int            cnt     = 0;
		
		System.out.println("읍면동 건물명: ");
		String  search   =   in.nextLine();
		while((line = br.readLine()) != null) {
			//zipcode,sido,gugun,dong,bunji,seq
			String [] li       =  line.trim().split(",");
			String    zipcode  =  li[0].trim();
			String    sido     =  li[1].trim();
			String    gugun    =  li[2].trim();
			String    dong     =  li[3].trim();
			String    bunji    =  li[4].trim();
			int       seq      =  Integer.parseInt(li[5].trim());
			
			if(dong.contains(search)) {
				String fmt   =  "[%s] %s %s %s %s %d\n";
				String addr  =  String.format(fmt,  zipcode, sido, gugun, dong, bunji, seq);
				System.out.print(addr);
				cnt++;
			}
		}
		System.out.print(cnt + "건");
		
		br.close();
		fr.close();
		
	}

}
