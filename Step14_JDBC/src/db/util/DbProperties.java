package db.util;

/**
 * DB ���������� �ش��ϴ� ��� �ʵ�
 */
public interface DbProperties {
	
	//�׽�Ʈ�� localhost db �⺻��
	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/myTest?serverTimezone=Asia/Seoul";
	public static final String USER_ID ="root"; 
	public static final String USER_PASS ="admin";
	public static final String DEFAULT_DB = "myTest";
	
	
}
