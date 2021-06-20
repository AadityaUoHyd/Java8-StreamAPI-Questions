package com.package1;

public class Employee {
	
	int id;
	String name;
	int age;
	String gender;
	String dept;
	int year_of_joining;
	double salary;

	public Employee(int id, String name, int age, String gender, String dept, int year_of_joining, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.year_of_joining = year_of_joining;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getYear_of_joining() {
		return year_of_joining;
	}
	public void setYear_of_joining(int year_of_joining) {
		this.year_of_joining = year_of_joining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dept=" + dept
				+ ", year_of_joining=" + year_of_joining + ", salary=" + salary + "]";
	}
	
}