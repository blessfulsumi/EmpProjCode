package EmpProject;
import java.util.Scanner;
public class Employee{
		public static void main(String[] args) {
	      
			Scanner scanner=new Scanner(System.in);
			EmpData emp1=new EmpData();
			emp1.eid=1231;
			emp1.dept="QC";
			emp1.ename="Abraham";
			emp1.salary=25000f;
			
			EmpData emp2=new EmpData("Isaac","N/W",20000f,2);
			EmpData emp3=new EmpData(3,"Jennie",30000f);
			emp3.dept="Analyst";
			
			System.out.println("Enter Emp4 eid:");
			int eid=scanner.nextInt();
			System.out.println("Enter Emp4 ename:");
			String ename =scanner.next();
			System.out.println("Enter Salary");
			float salary=scanner.nextFloat();
				
			EmpData emp4=new EmpData(eid,ename,salary);
			
			
			EmpImpl obj=new EmpImpl(emp1);	
			obj.display(emp1);
			obj.display(emp2);
			obj.display(emp3);
			obj.display(emp4);
			
			scanner.close();
		}	
		public void show() {
			System.out.println("Im show inside employee");
		}
		
	}