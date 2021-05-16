package m11.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainClass {
	public static void main(String[] args) {
		MainClass obj = new MainClass();
		//obj.streamMethod();
		obj.maxMethod();
	}
	public void streamMethod() {
		Employee e1 = new Employee(101,"Vaishnavi",50000,"Manager");
		Employee e2 = new Employee(102,"Sushanth",40000,"Analyst");
		Employee e3 = new Employee(103,"Ram",30000,"Assistant Manager");
		Employee e4 = new Employee(104,"VRamya",80000,"Senior Manager");
		Stream<Employee> str = Stream.of(e1,e2,e3,e4);
		str.forEach(s -> System.out.println(s));
	}
	public void maxMethod() {
		List<Integer> list = Arrays.asList(50,60,12,4,13,125,148,120);
		
		
		int x = list.stream().min((i,j)->i.compareTo(j)).get();
		System.out.println(x);
		
		int x1 = list.stream().max((i,j)->i.compareTo(j)).get();
		System.out.println(x1);
	}

}
