package mvc.service;

import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

public interface ElectronicsService {

    /**
     * 전자제품 등록
     *
     * @param electronics
     * 
     * : 최대 List에 저장된 객체의 개수가 MAX_SIZE를 벗어나면 
     *    ElectronicsArrayBoundsException 예외발생
     *      - 예외메시지 : 배열의 길이를 벗어나 더이상 등록 할수 없습니다.
     * 
     */
    public void insert(Electronics electronics) throws ElectronicsArrayBoundsException;

    /**
     * 등록된 전체 전자제품 검색 
     * @return
     */
    public List<Electronics> selectAll() ;
    
    /**
     * 등록된 전체 전자제품을 검색 후 모델번호 순으로 정렬
     * @return
     */
    public List<Electronics> selectSortByModelNo();
    
    
    /**
     * 모델번호에 해당하는 전자제품 검색 
     * @param modelNo
     * @return
     *   : 만약 찾는 정보가 없으면 
     *      SearchNotFoundException 예외발생
     *       -예외메시지 : modelNo+"는 없는 모델번호로 검색할수 없습니다."
     */
    public Electronics searchByModelNo(int modelNo)throws SearchNotFoundException ;


    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * (설명만 수정한다)
     * @param electronics
     *  : 수정전에 모델번호에 해당하는 정보가 있는지를 찾고 없으면
     *     SearchNotFoundException 예외발생
     *     있으면 전자제품 모델번호에 해당하는 설명을 수정한다.
     */
    public void update(Electronics electronics) throws SearchNotFoundException;
    
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기
     * 
     * @param 모델번호
     *  :삭제전에 모델번호에 해당하는 정보가 있는지를 찾고 없으면
     *     SearchNotFoundException 예외발생
     *     있으면 전자제품 모델번호에 해당하는 정보를 삭제한다.
     */
    public void delete(int modelNo) throws SearchNotFoundException;
    
    /**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public List<Electronics> selectSortByPrice() ;

    /**
     * 오름차순 / 내림차순 여부를 변경
     * @param isDesc (boolean) 내림차순 여부
     * @return !isDesc
     */
    public boolean sortToggle();
    
    /**
     * 현재 정렬 상태를 리턴
     */
    public boolean sortStateReturn();
    
}



