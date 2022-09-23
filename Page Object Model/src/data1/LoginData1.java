package data1;

import Utilities1.Xls_Reader;

public class LoginData1 {
	
	Xls_Reader d = new Xls_Reader("C:\\Selenium\\Testing\\NikulTest.xlsx");
	
	
	//Login
	public String emailwithSpecialChar = d.getCellData("Data4", "UserName", 4);
	public String wrongEmail = d.getCellData("Data4", "UserName", 3);
	public String wrongPassword = d.getCellData("Data4", "Password", 2);
	public String specialCharErr = d.getCellData("Data4", "Email Error", 5);
	public String emptyEmailErr = d.getCellData("Data4", "Email Error", 4);
	public String emptyPassword = d.getCellData("Data4", "Password Error", 3);
	public String globalErr = d.getCellData("Data4", "Global Error", 2);
			
	//HomeTest
	
	//FooterTest
	
	//UserProfileTest
	
	
}
