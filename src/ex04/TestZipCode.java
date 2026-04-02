package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestZipCode {
	public static void main(String[] args) throws IOException {
		// 입력파일
		String  path      =  "D:\\dev\\java\\PrjIO\\src\\ex04\\";
		String  filename  =  "zipcode_20130201(1).csv";
		FileReader  fr    =  new FileReader(path + filename);
		BufferedReader br =  new BufferedReader(fr);
		
		Scanner  in  =  new Scanner(System.in);
		
		// 검색어 입력
		System.out.print("검색할 동 또는 건물명을 입력하세요.\n");
		String  search  =  in.nextLine().trim();
		
		// 한 줄 저장 변수
		String  line  =  "";
		
		// 첫 줄 버리기
		br.readLine();
		
		int  totcount = 0;
		int  findcount = 0;
		
		String title  =  "집코드  시도  구군  동  번지           SEQ";
		System.out.println(title);
		while((line = br.readLine()) != null) {
			totcount += 1;
			String arr []  =  line.split(",");
			
			String  zcode  =  arr[0].trim();
			String  sido   =  arr[1].trim();
			String  gugun  =  arr[2].trim();
			String  dong   =  arr[3].trim();
			String  bunji  =  arr[4].trim();
			int     seq    =  Integer.parseInt(arr[5].trim());
			
			if(dong.indexOf(search) != -1 || bunji.indexOf(search) != -1) {
				findcount += 1;
				String  fmt  =  "%s %s %s %s %s %d";
				String  msg  =  String.format(fmt, zcode, sido, gugun, dong, bunji, seq);
				System.out.println(msg);
			}
		}
		System.out.println("검색된 자료수 : " + findcount);
		System.out.println("전체 자료수 : " + totcount);
		
		br.close();
		fr.close();
	}
}
