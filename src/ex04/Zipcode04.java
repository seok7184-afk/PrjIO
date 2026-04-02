package ex04;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Zipcode04 {

	public static void main(String[] args) throws IOException {
		// 4. 한국의 시도명 출력 - 17건 
		//		   서울
		//		   부산
		//		   ... 
		//		   충북

		String  path   =  Zipcode04.class.getResource("").getPath();
		String  fname  =  "zipcode_20130201(1).csv";
		File    file   =  new File(path + fname);
		
		FileReader     fr  =  new FileReader(file);
		BufferedReader br  =  new BufferedReader(fr);
		
		String         title   =  br.readLine(); // 제목줄 skip
		String         line    =  "";
		int            cnt     =  0;
		
		Set<String> sidoSet    =  new LinkedHashSet<>();

		while((line = br.readLine()) != null) {
			//zipcode,sido,gugun,dong,bunji,seq
			String [] li       =  line.trim().split(",");
			String    zipcode  =  li[0].trim();
			String    sido     =  li[1].trim();
			String    gugun    =  li[2].trim();
			String    dong     =  li[3].trim();
			String    bunji    =  li[4].trim();
			int       seq      =  Integer.parseInt(li[5].trim());
			
			sidoSet.add(sido);	
		}
		for (String sido : sidoSet) {
			System.out.println(sido);
			cnt++;
		}
		System.out.print(cnt + "건");
		
		br.close();
		fr.close();
		
	}

}
