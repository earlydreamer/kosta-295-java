package ex0221.goods.EnumConstructor;
/**
  상품으로 속성을 관리하는 개체
*/
public class Goods{
	private String code; //상품코드 null
	private String name;//상품이름  null
	private int price;//가격 0 
	private String explain;//설명 null
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
	Goods(){
		
	}
	
	/**
	 * 
	 * @param param1 = String code
	 * @param param2 = String name
	 * @param param3 = String price
	 * @param param4 = String explain
	 */
	Goods(String param1, String param2, String param3, String param4){
		this.code=param1;
		this.name=param2;
		this.price=Integer.parseInt(param3);
		this.explain=param4;
	}

	/**
	 * 
	 * @param param1 = String code
	 * @param param2 = String name
	 * @param param3 = int price
	 * @param param4 = String explain
	 */
	Goods(String param1, String param2, int param3, String param4){
		this.code=param1;
		this.name=param2;
		this.price=param3;
		this.explain=param4;
	}


	/**
	 * 
	 * @param param1 param1 = name
	 * @param param2 param2 = price
	 * @param param3 param3 = explain
	 */
	Goods (String param1, int param2, String param3){
		this.name=param1;
		this.price=param2;
		this.explain=param3;
	}
	
	
}