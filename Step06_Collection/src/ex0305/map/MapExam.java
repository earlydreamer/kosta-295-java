package ex0305.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExam {
	
	public MapExam() {
		Map<Integer,String> map = new HashMap();
		
		//Put은 Key 가 없으면 추가이고 있으면 value를 수정한다.
		
		map.put(40, "ㅇㅇ");
		String s1=map.put(33, "ㅇㅇ");
		map.put(25, "ㅇㅇ");
		map.put(33, "ㅇㅈ");
		String s2= map.put(33, "ㅇㅅ"); //Map은 Key가 중복일 시 데이터를 교체한다.
		
		
		System.out.println("Map="+map);
		System.out.println("Size="+map.size());
		System.out.println(s1);
		System.out.println(s2);//put의 리턴은 중복이 없으면 null을, 중복이 있으면 수정 전의 값을 리턴한다. 직전 1번까지만
		
		//-- key와 value 조회--
		
		System.out.println("---");

		map.keySet();	//map에 있는 모든 key들의 정보를 조회 / 
		Set<Integer> keySet = map.keySet();
		Iterator <Integer> iterator = keySet.iterator(); //Iterator 사용
		while(iterator.hasNext()) { //요소가 남아있는 동안
			int key = iterator.next(); //다음칸에 있는것 꺼내기
			String value = map.get(key);
			System.out.println(key+"="+value);
		}
		
		System.out.println("---");
		
		//Enhanced For로 변경 
		
		for(Integer i : keySet) {
			String value = map.get(i);
			System.out.println(i+"="+value);
		}
	
		System.out.println("---");
		
		//Map.Entry<K,V> 반환...
		Set<Entry<Integer,String>> set = map.entrySet();
		for(Entry<Integer,String> entry : set) {
			int k = entry.getKey();
			String v = entry.getValue();
			System.out.println("key="+k);
			System.out.println("value="+v);
			
		//	System.out.println(entry);
		}
		
		
		
	
	}
	
	
	
	
	
	public static void main (String args[]) {
			new MapExam();
	}

}
