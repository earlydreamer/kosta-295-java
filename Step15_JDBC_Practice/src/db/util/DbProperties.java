package db.util;

/**
 * DB 설정정보에 해당하는 상수 필드
 */
public interface DbProperties {
	
	//테스트용 localhost db 기본값
	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/myTest?serverTimezone=Asia/Seoul";
	public static final String USER_ID ="root"; 
	public static final String USER_PASS ="admin";
	public static final String DEFAULT_DB = "myTest";
	
	
}
