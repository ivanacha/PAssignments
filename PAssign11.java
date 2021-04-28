
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;


public class PAssign11 {
	
	// Specify the size of data fields in the record.
	private final static int EMPLOYEE_NUMBER = 10;
	private final static int SALARY_SIZE = 8;
	private final static int YEARS_OF_SERVICE = 4;
	private final static int RECORD_SIZE = EMPLOYEE_NUMBER + SALARY_SIZE + YEARS_OF_SERVICE;

	


	public static void main(String[] args) {
		try (
				RandomAccessFile raf = new RandomAccessFile(new File("employeeData.dat"), "rw");
				) {
			
			ArrayList<Employee> employees = new ArrayList<>();
			employees.addAll(Arrays.asList(new Employee("Steve", 27000, 3), new Employee("Floyd", 34050, 6)));
			
			for (int i =  0; i < employees.size(); i++) {
				System.out.println(employees.get(i).getInfo());
			}
			System.out.printf("Total Salary Before: $%,.2f", Employee.companySalaries);
			System.out.println("raising salaries...");
			for (int i =  0; i < employees.size(); i++) {
				employees.get(i).processRaise();
				System.out.println(employees.get(i).getInfo());
			}
			System.out.printf("Total Salary after: $%,.2f", Employee.companySalaries);

			double value;
			raf.seek(0);;
			while ((value = raf.read()) != -1) {

			}
				
			
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	/** Read and write a record at the specified position */
	
	public static void readEmployeeInfo(int size, DataInput in, Employee em) throws IOException {


	}

	public static void writeString(String s, int size, DataOutput out) throws IOException {
		
	}
	

}
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
