package Test_Cases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Data_Provider;

public class Login_Credential_Test002 extends Base_Class {
//@BeforeMethod
	public void URL_Call() throws IOException {
		getUrl("https://www.worldvision.in/index.aspx");
		info("URL Entered");
	    }

@Test (dataProvider = "Login_Data_Manual",dataProviderClass = Data_Provider.class)
	   public void Login_Test(String username,String OTP, String Validation) {
		
	
	        
	// Email or Mobile number Entry		 
	
		 print(username);
		 info("Entered Login ID is : "+username);

	// OTP Entry
		 print(OTP);
		 info("Entered OTP is : "+OTP);

	//loginBtn CLick
		
		 info("login button clicked");
		 
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
