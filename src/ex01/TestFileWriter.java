package ex01;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) throws IOException {
		String [] names = {"RM","진","슈가","제이홉","지민","뷔","정국"};
		
		//String filename = "bts.txt"; // D:\\mm\\dev\\Java\\PrjIO\\src\\ex01\\bts.txt
		String filename = "D:\\dev\\Java\\PrjIO\\src\\ex01\\bts.txt";
		FileWriter fw = new FileWriter(filename);
		
		for (int i = 0; i < names.length; i++) {
			fw.write((i + 1) +"."+names[i] + "\n");		
		}//for 문 - 출력
		fw.close();
		
		System.out.println(filename + " 이 "+names.length+" 줄 저장되었습니다");
	}//main
}//class