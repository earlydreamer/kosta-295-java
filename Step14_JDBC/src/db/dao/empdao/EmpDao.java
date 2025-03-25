package db.dao.empdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.dto.Emp;
import db.util.DbManager;

public class EmpDao {

	public EmpDao(){
		isDefaultConnection = true;
	}
	
	public EmpDao(String url, String id, String password){
		isDefaultConnection = false;
		this.url=url;
		this.id=id;
		this.password=password;
		
	}
	
	private boolean isDefaultConnection;
	public String url;
	public String id;
	public String password;
	
	
	
	/**
	 * 사원정보를 뽑는
	 */
	
	public void getEmpInfo() {
		// 로드 연결 실행 닫기
		Connection con = null;
		Statement st = null;
		ResultSet res = null;
		String sql = "SELECT EMPNO, ENAME, HIREDATE FROM EMP";
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);
			st = con.createStatement();
			res = st.executeQuery(sql);

			while (res.next()) { // 커서가 앞으로 행이동한다
				int empno = res.getInt("EMPNO");// 열을 조회
				String ename = res.getString("ENAME"); // 2번째 컬럼
				String hiredate = res.getString("HIREDATE");// 3번째 컬럼

				System.out.println(empno + " | "+ ename +  " | "+ hiredate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, res);

		}

	}

	public void deleteByEmpNo(int empNo) {
		Connection con = null;
		Statement st = null;
		String sql = "DELETE FROM EMP WHERE EMPNO = " + empNo; // Statement 방식의 쿼리는 불편하고 SQLInjection의 우려가 있다
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);
			st = con.createStatement();
			int res = st.executeUpdate(sql);
			if (res == 0) {
				System.out.println("삭제안됨");
			} else
				System.out.println("삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st);
		}

	}


	public void insertIntoEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL, HIREDATE) VALUES(?,?,?,?,NOW())";// 변수가 바인딩될 자리를 ?로 선언	
		
		
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);//			st = con.createStatement();
			ps = con.prepareStatement(sql);
			
			//sql에 ?가 있다면 ?의 개수만큼 순서대로 ~.setXXX(index, 값);
			ps.setInt(1, emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			
			int res = ps.executeUpdate();
			if (res == 0) {
				System.out.println("등록안됨");
			} else
				System.out.println("등록됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps);
		}

	}

	/**
	 * 사원번호에 해당하는 사원정보 수정하기
	 * 
	 */
	
	public void updateEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE EMP SET ENAME=?, JOB=?, SAL=? WHERE EMPNO=? ";// 변수가 바인딩될 자리를 ?로 선언	
		
		
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);
			
//			st = con.createStatement();
			ps = con.prepareStatement(sql);
			
			//sql에 ?가 있다면 ?의 개수만큼 순서대로 ~.setXXX(index, 값);
			ps.setString(1,emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getSal());
			ps.setInt(4, emp.getEmpno());
			
			int res = ps.executeUpdate();
			if (res == 0) {
				System.out.println("등록안됨");
			} else
				System.out.println("등록됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps);
		}


		
	}
	
	
}
