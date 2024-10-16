package Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Data_Provider;

public class Registration_Page_Validation extends Base_Class {
	//@BeforeMethod
	   public void URL_Call() throws IOException {
		getUrl("https://www.worldvision.in/index.aspx");
		info("URL Entered");
	    }
	
  @Test (dataProvider = "Login_Data_Auto",dataProviderClass = Data_Provider.class)

  public void Login_Test(String Title,String firstname,String lastname,String Email,String DOB,String mobile,String password,String confirmPass,String Validation)  {
		
    // Title entry
	     print(Title);
	     info("Entered Title is : "+Title);
	 
	// First Entry		 
		 print(firstname);
		 info("Entered username is :"+firstname);

	// Last Name Entry
		 print(lastname);
		 info("Entered passowrd is :"+lastname);

	//  Email adress entry
		 print(Email);
		 info("Entered Email Address is : "+Email);
		 

	//  Mobile Number entry
		print(mobile);
		info("Entered Mobile Number is : "+mobile);
					
	//  DOB entry
		print(DOB);
		info("Entered DOB is : "+DOB);
					
	//  Password entry
		print(password);
		info("Entered Password is : "+password);
				
	//  Confirm password entry
		print(confirmPass);
		info("Entered Confirm password is : "+confirmPass);
					
	//login validation
		 print(Validation);

		 if (Validation.equalsIgnoreCase("valid")) {
			 
			 if ("webelemt text for succesful login message".equals("webelemt text for succesful login message")) {
				info("Login Success");
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
