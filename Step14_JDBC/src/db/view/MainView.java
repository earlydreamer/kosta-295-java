package db.view;

import db.dao.empdao.EmpDao;
import db.dto.Emp;

public class MainView {

	public static void main (String args[]) {
		EmpDao dao = new EmpDao(args[0],args[1],args[2]);
		
		dao.getEmpInfo();
		dao.deleteByEmpNo(9000);
		dao.getEmpInfo();
		
//		dao.insertIntoEmp(new Emp (1235,"저시기","그",200,null));

		dao.updateEmp(new Emp (1235,"그뭐냐","그",200,null));

		dao.getEmpInfo();		
		
	}
	
}
