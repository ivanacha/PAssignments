package PAssign;

public class Employee {
	
	private String name;
	private double salary;
	private int yearsOfService;
	private static int numEmployees = 0;
	public static double companySalaries = 0;
	
	// Getters and setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name.length() > 0) {
			this.name = name;
		} else {
			this.name = " ";
		}
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		if (salary > 0) {
			this.salary = salary;
		} else {
			this.salary = 0;
		}
	}
	public int getYearsOfService() {
		return yearsOfService;
	}
	public void setYearsOfService(int years) {
		if (years > 0) {
			this.yearsOfService = years;
		} else {
			this.yearsOfService = 0;
		}
	}
	
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	public static void setNumEmployees(int numEmployees) {
		Employee.numEmployees = numEmployees;
	}
	// Constructors
	public Employee(String name, double salary, int years) {
		setName(name);
		setSalary(salary);
		setYearsOfService(years);
		numEmployees++;
		companySalaries += salary;
	}
	
	// Class methods.
	
	
	public void processRaise() {
		
		companySalaries -= getSalary();
		
		 // Raise for employees in respective earning brackets.
		if (getSalary() > 80000.00) {
			
			if (getYearsOfService() > 2) {
				setSalary(getSalary() * 1.025);
			} else {
				setSalary(getSalary() * 1.03);
			}
	
		} else if (getSalary() > 60000.00) {

			if (getYearsOfService() > 5) {
				setSalary(getSalary() * 1.015);
			} else {
				setSalary(getSalary() * 1.0175);
			}
			
		} else if (getSalary() > 30000.00) {

			if (getYearsOfService() > 5) {
				setSalary(getSalary() * 1.02);
			} else {
				setSalary(getSalary() * 1.0225);
			}
			
		} else if (getYearsOfService() > 5) {
			
			setSalary(getSalary() * 1.0101);
		} else {
			
			setSalary(getSalary() * 1.0125);
		}
		
		companySalaries += getSalary();
		
	}
	
	public String getInfo() {
		return String.format("Employee: %s, making $%,.2f has been working for %d.", getName(),
				getSalary(), getYearsOfService());
	}
	

}
