package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface Ipo {
   void input(String fname) throws IOException;
   void process();
   void output();
}//interface

class ZipcodeMap implements Ipo{
	
	FileReader  fr;
	BufferedReader br;
	
	Map<String, Integer>  sidoMap  =  new HashMap<>();
	int  totCnt = 0;
	
   @Override
   public void input(String fname) throws IOException { // Vo 배열에 담는작업 
      fr  =  new FileReader(fname);
      br  =  new BufferedReader(fr);
      br.readLine();
      String line = "";
      while((line = br.readLine()) != null) {
    	  PostVo  vo  =  new  PostVo(line);
    	  String  sido  =  vo.getSido();
    	  // int     sidoCnt = sidoMap.get(0);
    	  sidoMap.put(sido,  sidoMap.getOrDefault(sido, 0) + 1);
    	  totCnt++;
      }
   }

   @Override
   public void process() {
      
   }

   @Override
   public void output() {
      for (Map.Entry<String, Integer> sidoList : sidoMap.entrySet()) {
		String key = sidoList.getKey();
		Integer val = sidoList.getValue();
		
		System.out.println(key + "=" + val);
		
	}
      System.out.println("총" + totCnt + " 건");
   }
   
}//ZipcodeMap class




public class ZipCode05_4 {
//Map 사용
   public static void main(String[] args) throws IOException {
      ZipcodeMap zMap = new ZipcodeMap();
      
      String  path  =  ZipcodeMap.class.getResource("").getPath();
  	  String  fname = "zipcode_20130201(1).csv";
      
      zMap.input(path + fname);
      zMap.process();
      zMap.output();
   }//main
}//class
