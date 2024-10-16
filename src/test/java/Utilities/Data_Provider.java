package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;



public class Data_Provider extends XLUtils {
	@DataProvider (name="Login_Data_Auto")
	public String [][] getData() throws IOException{
		String path="C:\\Users\\Ram prathees\\eclipse-workspace\\Credential_Form_Validation\\src\\test\\resources\\Sample Registration.xlsx";
		int sheetNum=0;
		int totalrows=getRowCount(path, "Sheet1");
		int totalcols=getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcols];
		for (int i = 1; i <=totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
			loginData[i-1][j]=getCellData(path, sheetNum, i, j);
			}
		}
		return loginData;
	}
	
	 @DataProvider (name="Login_Data_Manual")
     public String [][] getDataManual() throws IOException{
  		String path ="C:\\Users\\Ram prathees\\eclipse-workspace\\Credential_Form_Validation\\src\\test\\resources\\Sample Registration.xlsx";
  		int sheetNum=0;
  		int startRows=1;
  		int Endrows=4;
  		int startCols=0;
  		int Endcols=9;
  		
  	
  		String loginData[][]=new String[Endrows][Endcols];
  		for (int i = startRows; i <=Endrows; i++) {	
  			for (int j = startCols; j < Endcols; j++) {		
  			loginData[i-1][j]=getCellData(path, sheetNum, i, j);
  			}
  		}
  		return loginData;
  		}
}
