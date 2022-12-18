package service;

import common.CommonMethods;
import dao.RegisterDao;
import model.UserDetails;
import validation.Validation;

public class RegisterService {
	
	Validation validation = new Validation();
	CommonMethods common = new CommonMethods();
	RegisterDao dao = new RegisterDao();
	
	
	public void printParameters(String firstName, String lastName, String email, String phoneNumber, String password, String repeatedPassword, String department) {
		common.printParameters(firstName, lastName, email, phoneNumber, password, repeatedPassword, department);
	}

	public boolean isPasswordOk(String password) {
		
		return validation.isPasswordOk(password);
	}

	public boolean isFieldsEmpty(String firstName, String lastName, String email, String phoneNumber, String password,
			String repeatedPassword, String department) {
		return validation.isFieldsEmpty(firstName, lastName, email, phoneNumber, password, repeatedPassword, department);
		
	}

	public boolean isEmailOk(String email) {
		
		return validation.isEmailOk(email);
	}

	public UserDetails setUserDetails(String firstName, String lastName, String email, String phoneNumber,
			String password, String repeatedPassword, String department) {
		
		return common.setUserDetails(firstName, lastName, email, phoneNumber,password, repeatedPassword, department);
	}

	public boolean saveUserDetailsInDataBase(UserDetails userDetails) {
		
		return dao.saveUserDetailsInDataBase(userDetails);
	}
}

