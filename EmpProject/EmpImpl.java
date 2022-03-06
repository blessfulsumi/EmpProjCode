package EmpProject;

public class EmpImpl {

EmpImpl(){
	
}

EmpImpl(EmpData emp1)
{    
	System.out.println(emp1.ename);
	System.out.println(emp1.eid);
}
	public void display(EmpData emp1)
	{
	
		System.out.println("i'm display inside EmpImpl");
		System.out.println("\nEmployee id is:"+emp1.eid+"\nEmployee Nameid is:"+emp1.ename+"\nEmployee Salary is:"+emp1.salary+"\nEmployee dept is:"+emp1.dept);		
		//empobj.show();
	}
	
		
}
