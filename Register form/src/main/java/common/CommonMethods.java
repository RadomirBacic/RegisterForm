package common;

import model.Department;
import model.UserDetails;

public class CommonMethods {
	
	public void printParameters(String firstName, String lastName, String email, String phoneNumber, String password, String repeatedPassword, String department) {
		
		System.out.println("First name: " + firstName);
		System.out.println("last name: " + lastName);
		System.out.println("Email: " + email);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Password: " + password);
		System.out.println("Repeated password: " + repeatedPassword);
		System.out.println("Department: " + department);
	}

	public UserDetails setUserDetails(String firstName, String lastName, String email, String phoneNumber,
			String password, String repeatedPassword, String department) {
		
		UserDetails userDetails = new UserDetails();
		
		userDetails.setFirstName(firstName);
		userDetails.setLastName(lastName);
		userDetails.setEmail(email);
		userDetails.setPhoneNumber(phoneNumber);
		userDetails.setPassword(password);
		userDetails.setRepeatedPassword(repeatedPassword);
		
		if (department.equals("developer")) {
			userDetails.setDepartment(Department.DEVELOPER);
		}else if (department.equals("sales")) {
			userDetails.setDepartment(Department.SALES);
		}else {
			userDetails.setDepartment(Department.ACCOUNTING);
		}
		return userDetails;
	}
	
	
}
