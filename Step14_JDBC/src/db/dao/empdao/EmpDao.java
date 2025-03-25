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
	 * ��������� �̴�
	 */
	
	public void getEmpInfo() {
		// �ε� ���� ���� �ݱ�
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

			while (res.next()) { // Ŀ���� ������ ���̵��Ѵ�
				int empno = res.getInt("EMPNO");// ���� ��ȸ
				String ename = res.getString("ENAME"); // 2��° �÷�
				String hiredate = res.getString("HIREDATE");// 3��° �÷�

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
		String sql = "DELETE FROM EMP WHERE EMPNO = " + empNo; // Statement ����� ������ �����ϰ� SQLInjection�� ����� �ִ�
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);
			st = con.createStatement();
			int res = st.executeUpdate(sql);
			if (res == 0) {
				System.out.println("�����ȵ�");
			} else
				System.out.println("������");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st);
		}

	}


	public void insertIntoEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL, HIREDATE) VALUES(?,?,?,?,NOW())";// ������ ���ε��� �ڸ��� ?�� ����	
		
		
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);//			st = con.createStatement();
			ps = con.prepareStatement(sql);
			
			//sql�� ?�� �ִٸ� ?�� ������ŭ ������� ~.setXXX(index, ��);
			ps.setInt(1, emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			
			int res = ps.executeUpdate();
			if (res == 0) {
				System.out.println("��Ͼȵ�");
			} else
				System.out.println("��ϵ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps);
		}

	}

	/**
	 * �����ȣ�� �ش��ϴ� ������� �����ϱ�
	 * 
	 */
	
	public void updateEmp(Emp emp) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE EMP SET ENAME=?, JOB=?, SAL=? WHERE EMPNO=? ";// ������ ���ε��� �ڸ��� ?�� ����	
		
		
		try {
			if(this.isDefaultConnection)
				con = DbManager.getConnection();
			else
				con = DbManager.getConnection(url,id,password);
			
//			st = con.createStatement();
			ps = con.prepareStatement(sql);
			
			//sql�� ?�� �ִٸ� ?�� ������ŭ ������� ~.setXXX(index, ��);
			ps.setString(1,emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getSal());
			ps.setInt(4, emp.getEmpno());
			
			int res = ps.executeUpdate();
			if (res == 0) {
				System.out.println("��Ͼȵ�");
			} else
				System.out.println("��ϵ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, ps);
		}


		
	}
	
	
}
