package validation;

public class Validation {

	//validation password method
	public boolean isPasswordOk(String password) {
		
		int passwordLength = password.length();
		int countNumbers = 0;
		int countBigLetters = 0; 
		
		if (passwordLength < 8) {
			System.out.println("The password must contain at minimum 8 characters");
			return false;
		}
		
		for (int i = 0; i < passwordLength; i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch)) {
				countNumbers++;
			}
			if (Character.isUpperCase(ch)) {
				countBigLetters++;
			}
		}
		if (countNumbers >= 2 && countBigLetters >= 1) {
			System.out.println("Password is ok!");
			return true;
		} else {
			System.out.println("The password must contain at least 2 numbers and 1 capital letter ");
			return false;
		}

	}

	public boolean isFieldsEmpty(String firstName, String lastName, String email, String phoneNumber, String password,
			String repeatedPassword, String department) {
		if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty() || department.isEmpty()) {
			System.out.println("Some of fields not filled!");
			return false;
		}
		return true;
	}

	public boolean isEmailOk(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}	
	
	
	
	
}
