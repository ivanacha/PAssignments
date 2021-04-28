package PAssign;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PAssign11 {
	

	public static void main(String[] args) {
		try (
				FileOutputStream output = new FileOutputStream(new File("output.dat"));
				RandomAccessFile raf = new RandomAccessFile(new File("employeeData.dat"), "rw");
		) {
			
			ArrayList<Employee> employees = new ArrayList<>();
			employees.addAll(Arrays.asList(new Employee("Steve", 27000, 3), new Employee("Floyd", 34050, 6)));
			
			for (int i =  0; i < employees.size(); i++) {
				System.out.println(employees.get(i).getInfo());
			}
			System.out.printf("Total Salary Before: $%,.2f\n", Employee.companySalaries);
			System.out.println("raising salaries...");
			for (int i =  0; i < employees.size(); i++) {
				employees.get(i).processRaise();
				System.out.println(employees.get(i).getInfo());
			}
			System.out.printf("Total Salary after: $%,.2f", Employee.companySalaries);

			
			
			
		} catch (IOException ex) {
			
		}

	}
	
	/** Read a record at the specified position */
	
	public static String readString(int size, DataInput in) throws IOException {
		char[] chars = new char[size];

		// Read fixed number of characters to the array
		for (int i = 0; i < size; i++)
			chars[i] = in.readChar();

		return new String(chars);
	}

	public static void writeString(String s, int size, DataOutput out) throws IOException {
		char[] chars = new char[size];

		// Fill in string with characters
		s.getChars(0, Math.min(s.length(), size), chars, 0);

		// Fill in blank characters in the rest of the array
		for (int i = Math.min(s.length(), size); i < chars.length; i++)
			chars[i] = ' ';

		// Create and write a new string padded with blank characters
		out.writeChars(new String(chars));
	}
	
	public static void processRaise() {
		
	}
}

