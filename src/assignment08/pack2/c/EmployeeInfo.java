package assignment08.pack2.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};


	public void sort(List<Employee> emps, final SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				int compareName = e1.name.compareTo(e2.name);
				if (compareName == 0) {
					return Double.compare(e1.salary, e2.salary);
				}
				return compareName;
			}
		}
		Collections.sort(emps, (e1, e2) -> {
			if(method == SortMethod.BYSALARY) {
				return Double.compare(e1.salary, e2.salary);
			}
			else{
				int compareName = e1.name.compareTo(e2.name);
				if (compareName == 0) {
					return Double.compare(e1.salary, e2.salary);
				}
				return compareName;
			}
		});
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		System.out.println(emps);
		//same instance
		ei.sort(emps, SortMethod.BYNAME);
		System.out.println(emps);
	}
}
