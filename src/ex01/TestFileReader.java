package ex01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestFileReader {

	public static void main(String[] args) throws IOException {
		
		String path = "D:/dev/Java/PrjIO/src/ex01/";
		String filename = "bts.txt";
		
		FileReader fr = new FileReader(path + filename);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
//		for (int i = 0; i < 10; i++) {
//			line = br.readLine();		//한 줄씩 읽을 수 있음
//			System.out.println(line);
//		}
		int n = 0; 
		while ( (line = br.readLine()) != null) {
				System.out.println(line);
				n++;
	}
		System.out.println(n + "라인을 출력하였습니다");
		fr.close();
		br.close();
	}
}