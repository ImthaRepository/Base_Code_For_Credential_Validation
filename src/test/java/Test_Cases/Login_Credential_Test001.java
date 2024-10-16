package Test_Cases;

import java.io.IOException;


import org.testng.annotations.Test;

import Utilities.Data_Provider;
// Login Test Using Username and Password

public class Login_Credential_Test001 extends Base_Class {
	
//@BeforeMethod
	   public void URL_Call() throws IOException {
		getUrl("https://www.worldvision.in/index.aspx");
		info("URL Entered");
	    }
	
@Test (dataProvider = "Login_Data_Manual",dataProviderClass = Data_Provider.class)
	   public void Login_Test(String username,String password,String Validation)  {
		 
	// username Entry		 
		
		 print(username);
		 info("Entered username is :"+username);

	// password Entry
		 print(password);
		 info("Entered passowrd is :"+password);

	//loginBtn CLick
		 
		 info("login button clicked");
		 
	//login validation
		 print(Validation);

		 if (Validation.equalsIgnoreCase("valid")) {
			 
			 if ("webelemt text for succesful login message".equals("webelemt text for succesful login message")) {
				info("Login Success");
				//Logout click
				info("Validation success");
				Assertpass();
			} else {
				info("Login Failed");
				info("Validation Fail");
				AssertFail();
			}
  
		 } else if (Validation.equalsIgnoreCase("invalid")) {
			 if ("webelemt text for succesful login message".equals("webelemt text for succesful ogin message")) {
					info("Login Success");
					//Logout Click
					info("Validation Fail");
					AssertFail();
				} else {
					info("Login Failed");
					info("Validation success");
					Assertpass();
				}
		} 
		 

	}

}
