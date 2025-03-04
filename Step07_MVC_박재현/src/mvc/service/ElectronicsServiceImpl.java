package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    
    //TODO : 리팩토링 필요함 너무 날로 만들었음
    private boolean isDesc =false; //정렬 출력에 사용될 오름차순-내림차순 여부. 서비스가 돌고 있는 중에 서비스 내에서만 임시로 사용되는 상태이므로 서비스 내에 static 선언했다...     
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//dbInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key);
     	   String data[] = value.split(",");
     	   //System.out.println(key +" = " + value);
     	  
     	     list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    		 Integer.parseInt( data[2]), data[3]) );
        }
        //System.out.println(list);
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) throws ElectronicsArrayBoundsException {
		if(list.size()>MAX_SIZE)
			throw new ElectronicsArrayBoundsException("배열의 길이를 벗어나 더이상 등록 할수 없습니다.");
		else
			list.add(electronics);
	}
	
	@Override
	public List<Electronics> selectAll() {
		return list;//현재 리스트를 그대로 반환
	}
	
	@Override
	public List<Electronics> selectSortByModelNo() {
		// TODO Auto-generated method stub
		List <Electronics> returnList = new ArrayList<Electronics>(list);
		Collections.sort(returnList,(o1,o2)-> o1.getModelNo()-o2.getModelNo()); //모델번호 기준으로 오름차순 정렬
		if(isDesc) { //내림차순일 경우 리스트를 뒤집어서 리턴
			Collections.reverse(returnList);
			return returnList;
		}else return returnList;
	}	

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {		
		for(Electronics e : list) {
			if(e.getModelNo()==modelNo) {
				return e; //찾으면 찾은 객체를 그대로 리턴하고 루프 탈출
			}
		}
		throw new SearchNotFoundException(modelNo+"는 없는 모델번호로 검색할수 없습니다.");//루프를 다 돌고 나왔는데 못 찾으면 예외 throw
	}

	@Override

	public void update(Electronics electronics) throws SearchNotFoundException {
		int index=0;
		for(Electronics e : list) {
			if(e.getModelNo() == electronics.getModelNo()) {//모델넘버 비교
				list.set(index, electronics); //현재 인덱스에 해당하는 Electronics를 받아온 값으로 교체
				return; // 동작을 완료했으므로 메소드를 끝내고 돌아감
			}
			index++;
		}throw new SearchNotFoundException(electronics.getModelNo()+"는 없는 모델번호로 검색할수 없습니다.");//루프를 다 돌고 나왔는데 못 찾으면 예외 throw
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		int index=0;
		for(Electronics e : list) {
			if(e.getModelNo() == modelNo) {//모델넘버 비교
				list.remove(index);//index 위치의 항목을 제거
				return; // 동작을 완료했으므로 메소드를 끝내고 돌아감
			}
			index++;	
		}throw new SearchNotFoundException(index+"는 없는 모델번호로 검색할수 없습니다.");//루프를 다 돌고 나왔는데 못 찾으면 예외 throw		
	}

	@Override
	public List<Electronics> selectSortByPrice() {		
		//다중조건정렬 thenComparing 안배웠으니까 바디를 만들어서 구현하자		
		List <Electronics> returnList = new ArrayList<Electronics>(list);
		Collections.sort(returnList,(o1,o2)->{ //lambda 이용한 구현
			//이중정렬이라 최종결과를 그냥 뒤집으면 결과가 이상해질수 있다 처음부터 각각 오름차순 내림차순 설정에 따라 돌도록 만들자...
			if(o1.getModelPrice()==o2.getModelPrice())
				if(isDesc) return o2.getModelNo()-o1.getModelNo();// 내림차순 설정되어있을때 가격이 같으면 ModelNo순으로 내림차순 정렬
				else return o1.getModelNo()-o2.getModelNo();// 가격이 같으면 ModelNo순으로 오름차순 정렬
			else
				if(isDesc) return o2.getModelPrice()-o1.getModelPrice();//내림차순 설정되어 있을때 가격순으로 내림차순 정렬
				else return o1.getModelPrice()-o2.getModelPrice();//기본적으로 가격순으로 오름차순 정렬
		});		
		return returnList; 
	}

	@Override
	public boolean sortToggle() {
		this.isDesc = !isDesc;
		return isDesc;
	}

	@Override
	public boolean sortStateReturn() {
		return this.isDesc;
	}

    
} // 클래스 끝 