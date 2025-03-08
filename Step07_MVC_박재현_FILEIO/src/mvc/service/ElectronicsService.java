package mvc.service;

import java.io.IOException;
import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.DuplicatedIdFoundException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.FileIoFailException;
import mvc.exception.SearchNotFoundException;

public interface ElectronicsService {

    /**
     * 전자제품 등록
     * @param electronics
     * @throws DuplicatedIdFoundException 
     * @throws FileIoFailException 
     */
    public void insert(Electronics electronics) throws ElectronicsArrayBoundsException, DuplicatedIdFoundException, FileIoFailException;

    /**
     * 등록된 전체 전자제품 검색 
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileIoFailException 
     */
    public List<Electronics> selectAll() throws FileIoFailException ;
    
    /**
     * 등록된 전체 전자제품을 검색 후 모델번호 순으로 정렬
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     * @throws FileIoFailException 
     */
    public List<Electronics> selectSortByModelNo() throws FileIoFailException;
    
    
    /**
     * 모델번호에 해당하는 전자제품 검색 <br>
     * 만약 찾는 정보가 없으면 SearchNotFoundException 예외발생 <br>
     * @param modelNo (int) 모델번호
     * @return (Electronics) Id가 일치하는 전자제품 객체 
     * @throws FileIoFailException 
     */
    public Electronics searchByModelNo(int modelNo)throws SearchNotFoundException, FileIoFailException ;


    /**
     * 모델번호에 해당하는 전자제품 수정하기  <br>
     * 수정전에 모델번호에 해당하는 정보가 있는지를 찾고 없으면 SearchNotFoundException 예외발생 <br>
     * 있으면 전자제품 모델번호에 해당하는 설명을 수정한다.
     * @param electronics
     * @throws FileIoFailException 
     */
    public void update(Electronics electronics) throws SearchNotFoundException, FileIoFailException;
    
    
    
    /**
     * 모델번호에 해당하는 전자제품 삭제하기
     * @param ModelNo (int) 모델번호
     * @throws FileIoFailException 
     */
    public void delete(int modelNo) throws SearchNotFoundException, FileIoFailException;
    
    /**
     *  가격을 기준으로 정렬하기 <br>
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return (List) 정렬된 Electronics 리스트
     * @throws FileIoFailException 
     */
    public List<Electronics> selectSortByPrice() throws FileIoFailException ;

    /**
     * 오름차순 / 내림차순 여부를 변경
     * @param isDesc (boolean) 내림차순 여부
     * @return !isDesc
     */
    public boolean sortToggle();
    

    /**
     * 현재 정렬 상태를 리턴
     * @return (boolean) 현재 정렬 상태
     */
    public boolean getSortState();
 
    
}



