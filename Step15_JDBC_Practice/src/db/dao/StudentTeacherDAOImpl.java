package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.util.DbManager;
import db.vo.Student;
import db.vo.Teacher;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

	boolean isDefaultConnection;
	String url;
	String id;
	String password;

	public StudentTeacherDAOImpl() {
		defaultInit();
	}

	public StudentTeacherDAOImpl(String url, String id, String password) {
		this.isDefaultConnection = false;
		this.url = url;
		this.id = id;
		this.password = password;

	}

	public void defaultInit() {
		this.isDefaultConnection = true;
	}

	
	/**
	 * 1번 : 성별이 여자인 학생의 정보 검색 select * from student where 수_주민등록번호 like '%-2%'
	 */

	public List<Student> getGenderByWomen() {
		// 로드 연결 실행 닫기
		Connection con = null;
		Statement st = null;
		ResultSet res = null;
		List<Student> returnStudentList = new ArrayList<Student>();
		String sql = "select * from student where student_personal_no like '%-2%'";

		// DB상의 컬럼명이 뭔지 모른다....... 저장되어있는 순서도 모른다... 스펙을 받고나서 갈아끼운다.
		final String STUDENT_NO = "student_number";
		final String STUDENT_JUMIN = "student_personal_no";
		final String STUDENT_NAME = "student_name";
		final String STUDENT_ADDR = "student_addr";
		final String STUDENT_EMAIL = "student_email";
		final String STUDENT_PHONE = "student_phone";

		try {
			if (this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url, id, password);
			st = con.createStatement();
			res = st.executeQuery(sql);

			while (res.next()) { // 커서가 앞으로 행이동한다
				Student student = new Student();
				student.setStudentNo(res.getInt(STUDENT_NO));
				student.setStudentJumin(res.getString(STUDENT_JUMIN));
				student.setStudentName(res.getString(STUDENT_NAME));
				student.setStudentAddr(res.getString(STUDENT_ADDR));
				student.setStudentEmail(STUDENT_EMAIL);
				student.setStudentPhone(STUDENT_PHONE);
				//System.out.println(student);
				returnStudentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, res);

		}
		return returnStudentList;
	}

	/**
	 * 3. "구"를 인수로 전달받아 구에 거주하는 강사의 정보 검색 select * from teacher where 주소 like ?
	 */
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		// 로드 연결 실행 닫기
		Connection con = null;
		PreparedStatement ps = null;
//		Statement st = null;
		ResultSet res = null;
		List<Teacher> returnTeacherList = new ArrayList<Teacher>();
		String sql = "select * from teacher where teacher_addr like ?";

		// DB상의 컬럼명이 뭔지 모른다....... 저장되어있는 순서도 모른다... 스펙을 받고나서 갈아끼운다. 코드 안바꾸기 위한 일종의 안전장치
		final String TEACHER_NO = "teacher_number";
		final String TEACHER_NAME = "teacher_name";
		final String TEACHER_JUMIN = "teacher_personal_no";
		final String TEACHER_PHONE = "teacher_phone";
		final String TEACHER_ADDR = "teacher_addr";
		final String TEACHER_EMAIL = "teacher_email";
		final String TEACHER_SUGANG_CODE = "sugagn_code";				

		try {
			if (this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url, id, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+gu+"%");
			
			res = ps.executeQuery();

			while (res.next()) { // 커서가 앞으로 행이동한다
				Teacher teacher = new Teacher();
				//add logic
				teacher.setTeacherNo(res.getInt(TEACHER_NO));
				teacher.setTeacherName(res.getString(TEACHER_NAME));
				teacher.setTeacherJumin(res.getString(TEACHER_JUMIN));
				teacher.setTeacherPhone(res.getString(TEACHER_PHONE));
				teacher.setTeacherAddr(res.getString(TEACHER_ADDR));
				teacher.setTeacherEmail(res.getString(TEACHER_EMAIL));
				teacher.setSugangCode(res.getString(TEACHER_SUGANG_CODE));
				//System.out.println(teacher);
				returnTeacherList.add(teacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps, res);

		}
		return returnTeacherList;
	}

	/**
	 * 5. 과목을 인수로 전달받아 그 과목을 강의하는 강사의 정보 (서브쿼리) select * from teacher where 수강코드 =
	 * (select 수강코드 from subject where upper(과목)=upper( ? ))
	 */

	//문제 풀어야 함...
	
	public Teacher getTeacherInfoBySubject(String subject) {
		return null;
	}

	/**
	 * 8강사의 번호를 인수로 전달받아 뷰에서 그 강사번호에 해당하는 정보를 출력한다 select * from v_teacherInfo where
	 * 강사번호=?
	 * 
	 */
	public Teacher getTeacherInfoByNo(int teacherNo) {//teacherno는 pk다 (대응하는 강사정보는 하나임)
		
		//문제 풀어야 함
		//뷰를 만들어놓고 뷰를 콜하는 방식으로
		String sql = "select * from v_teacherInfo where 강사번호=?"; //view를 통해 쿼리
		
		
		//하나의 객체에 안 담긴다. 
		//메소드의 리턴타입은 한개인데 전달할 VO는 여러개
		//teacher, subject, room의 정보가 섞여있음
		//return타입은 teacher //teacher에 묶어서 나가야 함
		//DTO클래스를 새로만들어서 그걸로 묶어나가는거도 되기는 함...
		//건별로 클래스를 매번 만들수는 없지않나 조인할떄마다 하면 클래스가 수백개 될것 (중복발생)
		//DTO를 만들어야 하는 경우는 집계함수 같은 entity가 없는 케이스에서 만들어줘야함
		//VO클래스에 직접 필드를 넣으면 안된다 그러면 죽은필드 생김
		// 조인될 테이블에 해당하는 객체를 vo클래스 안에 박아준다 (???) 뭔가 세련된 방법 없나 이거 좀 안 아름다운데
		

		return null;

	}
}
