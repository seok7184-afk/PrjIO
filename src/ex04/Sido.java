package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sido {

	public static void main(String[] args) throws IOException {
		// 5. 한국의 시도명 출력 - 17건 
		//		   서울    8080
		//		   부산    3605 
		//		   ... 
		//		   충북
		String  path  =  Sido.class.getResource("").getPath();
		String  fname =  "zipcode_20130201(1).csv";
		File    file  =  new File(path + fname);
		if(!file.exists()) {
			System.out.println(file + "이 없습니다");
			System.exit(-1);
		}
		
		FileReader      fr  =  new FileReader(file);
		BufferedReader  br  =  new BufferedReader(fr);
		
		br.readLine();
		String  line  =  "";
		int     cnt   =  0;
		
		Map<String, Integer>  map  =  new  LinkedHashMap<>();
		while((line = br.readLine()) != null) {
			String  []  li   =  line.trim().split(",");
			String      sido =  li[1].trim();
			
			if(map.containsKey(sido)) {
				map.put(sido, map.get(sido) + 1);
			} else {
				map.put(sido, 1);
			}
		}
		
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key) + "개");
		}
		
		
		
		
		
		
		
		fr.close();
		br.close();
		
		
		
		

	}

}
