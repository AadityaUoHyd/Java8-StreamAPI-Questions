package com.package1;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class EmployeeStreamDemo {

	static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {

		employeeList.add(new Employee(108, "Katreena Kapoor", 33, "FEMALE", "Marketing & Sales", 2014, 45000.0));
		employeeList.add(new Employee(109, "Lara Advani", 33, "FEMALE", "Tester", 2014, 40000.0));
		employeeList.add(new Employee(110, "Sachin Jha", 33, "MALE", "Office Administration", 2012, 50000.0));
		employeeList.add(new Employee(111, "Aaditya Raj", 30, "MALE", "Java Developer", 2014, 80000.0));
		employeeList.add(new Employee(112, "Virat Patel", 25, "MALE", "Tester", 2019, 30000.0));
		employeeList.add(new Employee(113, "Prashant Kishore", 28, "MALE", "Front end Developer", 2018, 40000.0));
		employeeList.add(new Employee(114, "Shreya Kiki", 32, "FEMALE", "Java Developer", 2014, 60000.0));
		employeeList.add(new Employee(115, "Julie Sharma", 30, "FEMALE", "HR", 2015, 60000.0));
		employeeList.add(new Employee(116, "Aryan Bhandari", 29, "MALE", "Java Developer", 2015, 90000.0));
		employeeList.add(new Employee(117, "Arvind Singh", 30, "MALE", "Tester", 2013, 70000.0));
		employeeList.add(new Employee(118, "Omprakash Saha", 31, "MALE", "Front end Developer", 2012, 70000.0));
		employeeList.add(new Employee(119, "Chandu Das", 30, "MALE", "Java Developer", 2016, 50000.0));
		employeeList.add(new Employee(120, "Ananya Goel", 31, "FEMALE", "Functional Analyst", 2014, 120000.0));
		employeeList.add(new Employee(121, "Venket Bhosle", 42, "MALE", "Marketing & Sales", 2015, 60000.0));
		employeeList.add(new Employee(122, "Rajeev Ranjan", 32, "MALE", "Java Developer", 2015, 90000.0));
		employeeList.add(new Employee(123, "Prasanna Reddy", 32, "FEMALE", "Functional Analyst", 2015, 80000.0));
		employeeList.add(new Employee(124, "Anuj Mukherjee", 31, "MALE", "HR", 2014, 70000.0));
		employeeList.add(new Employee(125, "Bittoo Chakrawarty", 25, "MALE", "DevOps Engineer", 2017, 70000.0));
		employeeList.add(new Employee(126, "Monal Dewle", 32, "FEMALE", "Management", 2011, 150000.0));
		employeeList.add(new Employee(127, "Jessy Marie", 29, "FEMALE", "DevOps Engineer", 2017, 50000.0));
		employeeList.add(new Employee(128, "Charu Poonia", 26, "FEMALE", "Marketing & Sales", 2020, 50000.0));
		employeeList.add(new Employee(129, "Sahil Yadav", 29, "MALE", "Auditing", 2015, 90000.0));
		employeeList.add(new Employee(130, "Venugopal Rao", 29, "MALE", "Office Administration", 2015, 40000.0));
		employeeList.add(new Employee(130, "Rashika Khanna", 30, "FEMALE", "Marketing & Sales", 2017, 60000.0));
		employeeList.add(new Employee(110, "John Miller", 33, "MALE", "Front end Developer", 2014, 45000.0));

		//Q1. How many males and females employee are there in the organization?
		method1();
		System.out.println("\n");

		//Q2. Print the name of all dept in the organization?
		method2();
		System.out.println("\n");

		//Q3. What is the average age of male and female employees? 
		method3();
		System.out.println("\n");

		//Q4. Get the details of highest paid employee in the organization?
		method4();
		System.out.println("\n");

		//Q5. Get the name of all employee who joined after 2016?
		method5();
		System.out.println("\n");

		//Q6. Count the number of employee from each dept?
		method6();
		System.out.println("\n");

		//Q7. What is the average salary of each dept?
		method7();
		System.out.println("\n");		

		//Q8. Get the details of youngest 'MALE' employee from dept of 'Java Developer'?
		method8();
		System.out.println("\n");	

		//Q9. Who has the most working experiences in the organization?
		method9();
		System.out.println("\n");

		//Q10. How many MALE and FEMALE workers are there in the 'Marketing & Sales' and 'Tester' team?
		method10();
		System.out.println("\n");

		//Q11. What is the average salary of male & female employees?
		method11();
		System.out.println("\n");

		//Q12. List down the name of all employees in each dept.
		method12();
		System.out.println("\n");

		//Q13. What is the average salary and total salary of the whole organization?
		method13();
		System.out.println("\n");

		//Q14. Separate the employees who are younger or equal to 30 years vis-a-vis older than 25 years.
		method14();
		System.out.println("\n");

		//Q15. Who is the oldest employee in the organization by age? What is his age & from which dept he belongs to?
		method15();

	}

	public static void method1() {
		System.out.println("Q1. How many males and females employee are there in the organization?");

		Map<String, Long> no_Of_Male_Female_Employees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(no_Of_Male_Female_Employees);
	}

	public static void method2() {
		System.out.println("Q2. Print the name of all dept in the organization.");

		employeeList.stream()
		.map(Employee::getDept)
		.distinct().forEach(System.out::println);
	}

	public static void method3() {
		System.out.println("Q3. What is the average age of male and female employees?");

		Map<String, Double > avg_age_Of_Male_Female_Employees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println(avg_age_Of_Male_Female_Employees);
	}

	public static void method4() {
		System.out.println("Q4. Get the details of highest paid employee in the organization?");

		Optional<Employee> highest_paid_employee = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

		System.out.println(highest_paid_employee.get());	
		System.out.println(" -->> Interested to know Only Name : " + highest_paid_employee.get().getName());
	}

	public static void method5() {
		System.out.println("Q5. Get the name of all employee who joined after 2016?");
		employeeList.stream()
		.filter( e -> e.getYear_of_joining() > 2016 )
		.map(Employee::getName)
		.forEach(System.out::println);
	}

	public static void method6() {
		System.out.println("Q6. Count the number of employee from each dept?");

		Map<String, Long> countingEmployeeByDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

		Set<Entry<String, Long>> entrySet = countingEmployeeByDept.entrySet();

		for(Entry<String, Long> entry : entrySet) {
			System.out.println("Dept : "+entry.getKey()+" => Total number of employee(s) : "+entry.getValue());
		}
	}

	public static void method7() {
		System.out.println("Q7. What is the average salary of each dept?");

		Map<String, Double> avgSalaryByEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.averagingDouble(Employee::getSalary)));

		Set<Entry<String, Double>> entrySet = avgSalaryByEachDept.entrySet();

		for(Entry<String, Double> entry : entrySet) {
			System.out.println("Dept : "+entry.getKey()+" => Total number of employee(s) : "+entry.getValue());
		}
	}

	public static void method8() {
		System.out.println("Q8. Get the details of youngest 'MALE' employee from dept of 'Java Developer'?");

		Optional<Employee> yougest_male_employee = employeeList.stream()
				.filter(e -> e.getGender()=="MALE" && e.getDept()=="Java Developer")
				.min(Comparator.comparingInt(Employee::getAge));

		System.out.println(yougest_male_employee.get());
		System.out.println(" -->> To find only employee name : " + yougest_male_employee.get().getName());
	}

	public static void method9() {
		System.out.println("Q9. Who has the most working experiences in the organization?");

		Optional<Employee> most_senior_employee_of_org = employeeList.stream()
				.min(Comparator.comparingInt(Employee::getYear_of_joining));

		/* This code will also work => 

		   Optional<Employee> most_senior_employee_of_org = employeeList.stream()
		        .sorted(Comparator.comparingInt(Employee::getYear_of_joining)).findFirst(); 

		 */

		System.out.println("Most experinced worker of the organization is : " + most_senior_employee_of_org.get().getName());
	} 

	public static void method10() {
		System.out.println("Q10. How many MALE and FEMALE workers are there in the 'Marketing & Sales' and 'Tester' team?");

		Map<String, Long> male_female_in_sales_and_testing_team = employeeList.stream()
				.filter(e -> e.getDept()=="Marketing & Sales" || e.getDept()=="Tester")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(male_female_in_sales_and_testing_team);	
	}

	public static void method11() {
		System.out.println("Q11. What is average salary of male & female employees?");

		Map<String, Double> avg_salary_Male_and_Female = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println(avg_salary_Male_and_Female);
	}

	public static void method12() {
		System.out.println("Q12. List down the name of all employees in each dept.");

		Map<String, List<Employee>> employees_with_their_dept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDept));

		Set<Entry<String, List<Employee>>> entrySet = employees_with_their_dept.entrySet();

		for(Entry<String, List<Employee>> entry : entrySet) {
			List<Employee> val = entry.getValue();
			System.out.print("Dept : "+entry.getKey()+" => Name of all working employee(s) : "); 
			for(Employee value : val){
				System.out.print(value.getName()+ ", ");
			}
			System.out.println();

		}
	}

	public static void method13() {
		System.out.println("Q13. What is the average salary and total salary of the whole organization?");

		Double x = employeeList.stream()
				.mapToDouble(Employee::getSalary)
				.average().getAsDouble();
		System.out.println("Average Salary of whole organization : "+x);

		Double y = employeeList.stream()
				.mapToDouble(Employee::getSalary)
				.sum();
		System.out.println("Total Salary of whole organization : "+y);
		
		/* Another way to solve the same question =>
		DoubleSummaryStatistics empSalStat = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary of whole organization : "+ empSalStat.getAverage());
		System.out.println("Total Salary of whole organization : "+ empSalStat.getSum());
		*/
	}

	public static void method14() {
		System.out.println("Q14. Separate the employees who are younger or equal to 30 years vis-a-vis older than 25 years.");
		
		Map<Boolean, List<Employee>> partitionEmployeeByAge = employeeList.stream()
		.collect(Collectors.partitioningBy(e->e.getAge() >= 30));
		
		Set<Entry<Boolean, List<Employee>>> entrySet = partitionEmployeeByAge.entrySet();
		
		for(Entry<Boolean, List<Employee>> entry : entrySet) {
			System.out.println("------------------------------------------");
			
			if(entry.getKey()) {
				System.out.println("Employees who are older than 30 years : ");
			}
			else {
				System.out.println("Employees who are younger than 30 years : ");
			}
	
			System.out.println("------------------------------------------");
			
			List<Employee> list = entry.getValue();
			for(Employee e : list) {
				System.out.println(e.getName());
			}
			
		}
	}
	
	public static void method15() {
		System.out.println("Q15. Who is the oldest employee in the organization by age? What is his age & from which dept he belongs to?");

		Optional<Employee> oldestEmployee = employeeList.stream()
				.max(Comparator.comparingInt(Employee::getAge));

		System.out.println("Oldest employee's name is : " + oldestEmployee.get().getName());
		System.out.println("Age : " + oldestEmployee.get().getAge());
		System.out.print("Department : " +oldestEmployee.get().getDept());
	}
	
}