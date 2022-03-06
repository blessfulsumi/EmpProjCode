package EmpProject;

public class EmpData {
	int eid;
	String ename;
	String dept;
	float salary;
	
	//Constructor overloading
	public EmpData() {		
		
	}	// constructor without any arguments
	
	public EmpData(int eid, String ename, String dept, float sal) { // constructor with 4 arguments 		
		this.eid=eid;
		this.ename=ename;
		this.dept=dept;
		this.salary=sal;
	}
	
	public EmpData(String ename, String dept, float sal,int eid) { // constructor with 4 arguments 		
		this.eid=eid;
		this.ename=ename;
		this.dept=dept;
		this.salary=sal;
	}
	
	public EmpData(int eid,String ename, float sal)// constructor with 3 arguments
	{
		this.eid=eid;
		this.ename=ename;
		this.salary=sal;
	}
	
	
}
