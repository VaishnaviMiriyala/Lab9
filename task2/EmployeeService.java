package m11.task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {
	public static void main(String[] args) {
		EmployeeService es = new EmployeeService();
		EmployeeRepository er = new EmployeeRepository();
		List<Employee1> list = er.getEmployees();
		List<Department> dp = er.getDepartments(); 
		//es.sumOfSalaries(list);
		//es.deptNamesCount(list, dp);
		//es.empDepNull(list);
		//es.seniorEmp(list);
		//es.depEmpNull(dp, list);
		//es.dispDetailsMonDay(list);
		//es.increaseSalary(list);
		//es.empNoManager(list);
		//es.empWithDayOfWeek(list);
		//es.empJoiningFriday(list);
		es.sortByEmpId(list);
		//es.sortByDepartmentId(list);
		//es.sortByFirstName(list);
	}
     void sumOfSalaries(List<Employee1> list) {
    	 double sum = list.stream().map(e->e.getSalary()).reduce(0.0,(a,b)->a+b);
    	 System.out.println(sum);
     }
     void deptNamesCount(List<Employee1> list,List<Department> dp) {
    	 for(Department d : dp) {
    		 long c = list.stream().filter((employee)->employee.getDepartment().getDepartmentName().equals(d.getDepartmentName())).count();
    		 System.out.println("Department Name: "+d.getDepartmentName()+"Count:"+c);
    	 }
     }
     void empDepNull(List<Employee1> emp) {
    	Stream<Employee1> emp1 = emp.stream().filter((employee)->employee.getDepartment() == null);
    	emp1.forEach((i)->System.out.println(i));
     }
     void seniorEmp(List<Employee1> emp) {
    	 //Comparator<Employee1> exerience = (emp1,emp2)->(LocalDate.now()) - emp1.getHireDate()) - (LocalDate.now() - emp2.getHireDate());
    	 
    	 //Employee1 res = emp.stream().max(experience).get();
     }
     void dispDetailsMonDay(List<Employee1> emp) {
    	 for(Employee1 e:emp) {
    		 System.out.println("Employee First Name: "+e.getFirstName()+"Employee Last Name: "+e.getLastName());
    		 long p1 = ChronoUnit.MONTHS.between(e.getHireDate(),LocalDate.now());
    		 long p2 = ChronoUnit.DAYS.between(e.getHireDate(),LocalDate.now());
    		 System.out.println("Employee Service in Months: "+p1);
    		 System.out.println("Employee Service in Days: "+p2);
    		 System.out.println("-----------------");
    	 }
     }
     void depEmpNull(List<Department> dp,List<Employee1> emp) {
    	 Stream<Employee1> emp1 = emp.stream();
     }
     void increaseSalary(List<Employee1> emp) {
    	 List<Employee1> res = emp.stream().map((employee)->{
 			double oldSalary = employee.getSalary();
 			double newSalary = oldSalary+(oldSalary*0.15);
 			employee.setSalary(newSalary);
 			return employee;
 		}).collect(Collectors.toList());
    	for(Employee1 e:res) {
    		System.out.println("The Emplyee First Name: "+e.getFirstName()+"Employee Last Name: "+e.getLastName());
    		System.out.println("The Salary increased: "+e.getSalary());
    		System.out.println("------------");
    	}
     }
     void empNoManager(List<Employee1> emp) {
    	 Stream<Employee1> res = emp.stream().filter((employee)->employee.getManagerId() == null);
    	 res.forEach((i)->System.out.println(i));
     }
     void empWithDayOfWeek(List<Employee1> emp) {
    	 for(Employee1 e:emp) {
    	 System.out.println(e.getFirstName()+e.getLastName());
    	 System.out.println(e.getHireDate());
    	 System.out.println(e.getHireDate().getDayOfWeek());
    	 System.out.println("-----------------");
    	 }
     }
     void empJoiningFriday(List<Employee1> emp) {
    	 Stream<Employee1> str = emp.stream().filter((employee)->employee.getHireDate().getDayOfWeek().toString().equals("FRIDAY"));
    	 str.forEach((i)->System.out.println(i));
     }
     void sortByEmpId(List<Employee1> emp) {
    	 Comparator<Employee1> byIdComparator = (emp1,emp2)->emp1.getEmployeeId()-emp2.getEmployeeId();
    	 Stream<Employee1> res = emp.stream().sorted(byIdComparator);
    	 res.forEach((i)->System.out.println(i));
     }
     /*void sortByDepartmentId(List<Employee1> emp) {
    	 Comparator<Employee1> byIdComparator = (emp1,emp2)->emp1.getDepartment().getDepartmentId()-emp2.getDepartment().getDepartmentId();
    	 Stream<Employee1> res = emp.stream().sorted(byIdComparator);
    	 res.forEach((i)->System.out.println(i));
     }
     void sortByFirstName(List<Employee1> emp) {
    	 Comparator<Employee1> byIdComparator = (emp1,emp2)->emp1.getEmployeeId()-emp2.getEmployeeId();
    	 Stream<Employee1> res = emp.stream().sorted(byIdComparator);
    	 res.forEach((i)->System.out.println(i));
     }*/
}
