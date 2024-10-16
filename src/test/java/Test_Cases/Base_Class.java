package Test_Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Base_Class {
	public static WebDriver driver;

	


	public String projectPath() {
		//for get project path we can also use ./ notation
		String path = System.getProperty("user.dir");
		return path;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(projectPath()+"\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}

	
	
//<------------------------------------------------------- Browser Events-------------------------------------------------------->	
	
    // Browser Choose
	   public void browser(String browser) {
		   switch (browser) {
		      case "chrome":
			    driver = new ChromeDriver();
			    break;

		      case "firefox":
			    driver = new FirefoxDriver();
			    break;

		      case "edge":
			    driver = new EdgeDriver();
			    break;

		      default:
			    break;
		    }
	   }
	   
	// Launch Chrome Browser
	    public  WebDriver launchchromeBrowser() {
		     WebDriver driver = new ChromeDriver();
		     return driver;
	    }
	    
	// Enter url
	   public static void getUrl(String url) {
				driver.get(url);
	    }
	   
	// Navigate to url
	   public static void navigateToUrl(String url) {
		   driver.navigate().to(url);
	   }
	   
	//  Refresh page
		public void refresh() {
			driver.navigate().refresh();
		}
		
	//	Navigate Backward
		public void navigateBack() {
			driver.navigate().back();
		}
		
	// Navigate Forward	
	   public void navigateForward() {
			driver.navigate().forward();
		}
		
    // Minimize Window
		public static void minmizeWindow() {
			driver.manage().window().minimize();
		}
		
	// Set the Size of the Window
	   public static void windowSize(int width, int height) {
			Dimension d= new Dimension(width , height);
			driver.manage().window().setSize(d);
			return;
		}

	 // Maximize Window
		public static void maximizeWindow() {
			driver.manage().window().maximize();
		}
		
	//  Delete All the Cookies
		public static void DeleteCookies() {
			driver.manage().deleteAllCookies();
		}
		
	//  Close all windows
		public static void closeAllWindows() {
			driver.quit();
		}

	//  Close all current window
		public void closeCurrentwindow() {
			driver.close();
		}
		
		
//<------------------------------------------------     Locators --------------------------------------------------------------->

	//  Find locator by id :
		public static WebElement locatorId(String id) {
			WebElement findElement = driver.findElement(By.id(id));
			return findElement;
		}

	//  Find locator by name :
		public static WebElement locatorName(String name) {
			WebElement findElement = driver.findElement(By.name(name));
			return findElement;
		}

	//  Find locator by ClassName :
		public static WebElement locatorClassName(String value) {
			WebElement findElement = driver.findElement(By.className(value));
			return findElement;
		}

    //  Find locator by xpath :
		public static WebElement locatorXpath(String xpathExpression) {
			WebElement findElement = driver.findElement(By.xpath(xpathExpression));
			return findElement;
		}
		
	//  Find number of elements using xpath for loop Action
	    public static List<WebElement> multipleelements(String xpathExpression) {
			List<WebElement> listElement = driver.findElements(By.xpath(xpathExpression));
			return listElement;
	    }
	    
	 // Find locator by CSS selector
	    public static WebElement locatoreCSS(String CSSexpresion) {
	    	WebElement findElement = driver.findElement(By.cssSelector(CSSexpresion));
	    	return findElement;
	    }
			
		
		
//<------------------------------------------Waits And Sleep Events------------------------------------------------------------->
		
		
	 //  Sleep
		 public void sleep(int time ) throws InterruptedException {
			Thread .sleep(time);
			return;
		 }
		
	 //  Implicit Wait
		 public static void implicitwait() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 }

     //  Explicit wait Until Visible using Web element
		 public WebDriverWait WaitUntilVisibleElement(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			return wait;
		 }
		 
	 //  Explicit wait Until Visible using locator
		 public WebDriverWait WaitUntilVisibleLocator(String locator) {
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
				return wait;
		 }
		 
	 //  Explicit wait Until Clickable
		 public WebDriverWait WaitUntilClcikable(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return wait;
		 } 
		 
	//   Explicit wait Until Title Visible using locator
		 public WebDriverWait WaitUntilVisibleTitle(String Title) {
			 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			 wait.until(ExpectedConditions.titleIs(Title));
			 return wait;
		  }
						
	   
//<---------------------------------------------------------Basic Operation in Web pages------------------------------------------->
	
		 
		 		 
	//  Print the Value	 
		public void print(String text) {
		    System.out.println(text);
	    }
		
	//  print the Boolean
		public void printBoolean(Boolean b) {
			System.out.println(b);
		}
	
	//  Get the text from the webelement
	    public String getText(WebElement element) {
		   String text = element.getText();
		   return text;
	    }
	
	//  Insert Value In textBox
	    public static void sendKeys(WebElement element, String Data) {
		   element.sendKeys(Data);
	    }
	    
	//  Insert Value In textBox
	  /*  public static void sendKey(WebElement element, int Data) {
		   element.sendKeys(Data);
	    }*/
	    
	//  Clear Textbox
		public void clear(WebElement element) {
			element.clear();
		}

	//  Click Button
	    public static void click(WebElement element) {
		   element.click(); 
	    }

	//  Click OK In Alert
	    public void acceptAlert(Alert alert) {
		   alert.accept();
	    }

	//  Click Cancel On Alert
	    public void declineAlert(Alert alert) {
		   alert.dismiss();
	    }

	//  Get the Inserted value in textbox
	    public String getInsertedValue(WebElement element, String Data) {
		   String attribute = element.getAttribute(Data);
		   return attribute;
	    }
	    
	 // Insert values and enter
		public void insertValueAndEnter(WebElement element, String value) {
			element.sendKeys(value, Keys.ENTER);
		}	

	//  Get the title
	    public String getTitle() {
		   String title = driver.getTitle();
		   return title;
	    }

	//  Get the Current URL
	    public String fetchUrl() {
		  String currentUrl = driver.getCurrentUrl();
		  return currentUrl;
	    }
	    
	//  Assert for Actual and Expected
		public void Assert(String Actual,String Expect) {
		   org.testng.Assert.assertEquals(Actual, Expect);
		   return;
		}
		   
	//  Assert for Test Pass
	    public void Assertpass() {
		   org.testng.Assert.assertTrue(true);
		}
		   
	//  Assert for Test Fail
		public void AssertFail() {
		   org.testng.Assert.assertTrue(false);
		}
		       
		   
	//  For Loop Print Expression
		public void forLoopPrint(List<WebElement> elements,String element ,int startCount,int loopInterval) throws InterruptedException {
			 for (int k = startCount; k <= elements.size(); k++) {
				 WebElement interest = driver.findElement(By.xpath(("("+element+")["+k+"]")));
				 print(interest.getAttribute("href")+" : "+interest.getAttribute("innerText") );//+" :: "+interest.getAttribute("textContent")
				 sleep(loopInterval);
				 }
		 }
	   
	 // For Loop click Expression
		public void forLoopclick(List<WebElement> elements,String element ,int startCount,int loopInterval) throws InterruptedException {
			for (int k = startCount; k <= elements.size(); k++) {
				 WebElement interest = driver.findElement(By.xpath(("("+element+")["+k+"]")));
				 interest.click();
				 sleep(loopInterval);
				 }
		}
//<----------------------------------------JavaScript Functions like Scroll the web page-------------------------------------->
	
	 //  Get Title using JS
		public String GetTitleJS() {
			 JavascriptExecutor executor = (JavascriptExecutor) driver;
		     String Title = executor.executeScript("return document.Title;").toString();
		     return Title;     
		}

	 //  Insert value using JS
	     public void SendKeysJS(WebElement element, String data) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("[arguments[0].setAttribute('value',' " + data + " ')", element);
         }
	     
	 //  Fetch Attribute value using JS
	     public void SendKeysJS(WebElement element) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("[arguments[0].getAttribute('value')", element);
         }
		    
	 //  Click button using JS
	     public void clickJS(WebElement element) {
	        JavascriptExecutor executor=(JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].click()",element );
	     }
	 
	 //  Scroll the Web Page JS
	     public void ScrollJS(int horizontal,int vertical) {
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy("+horizontal+","+vertical+")");
	     }
	     
	
	 // Scroll into view JS
	    public void MoveToElementJS(WebElement element) {
	    	JavascriptExecutor executor=(JavascriptExecutor) driver;
	        executor.executeScript("arguments[0].scrollIntoView(true);",element);
	    }
	    
	 // Color the textbox background using JS
		public void setbackgroundColorJS(WebElement element ,String color) {
		    JavascriptExecutor executor=(JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].style.background ='"+ color+"'",element);
		}
		
	 // Color the textbox background using JS
		public void setBorderColorJS(WebElement element ,String color) {
			JavascriptExecutor executor=(JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].style.border ='"+ color+"'",element);
		}
		
	 // Generate Alert using JS
		public void SetAlert(String message) {
			JavascriptExecutor executor=(JavascriptExecutor) driver;
		    executor.executeScript("alert('"+ message+"')");
		}
		
	 // Refresh page using JS
		public void RefreshJS() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("history.go(0)");
		}
		
	 // Scroll to Bottom page using JS
		public void ScrollToBottomJS() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	    
	

//<--------------------------------------------------Boolean Operations--------------------------------------------------------->	
	  
	
	// Verify drop down is multi selected?
	   public boolean multiSelected(WebElement element) {
		  Select select = new Select(element);
		  boolean multiple = select.isMultiple();
		  return multiple;
	   }

	
	// Verify element is displayed
	   public boolean isDisplayed(WebElement element) {
	   boolean displayed = element.isDisplayed();
	   return displayed;
	   }

	// Verify element Is enabled
	   public boolean isEnabled(WebElement element) {
	      boolean enabled = element.isEnabled();
		  return enabled;
	   }
	   
	   
	   
//<-------------------------------------------------------Select Class For DropDown Menus---------------------------------------->
	// verify is selected
	   public boolean isSelected(WebElement element) {
	 	   boolean selected = element.isSelected();
		   return selected;
	   }

	 // Desselect by index
	    public void deselectByIndex(WebElement element, int index) {
		    Select select = new Select(element);
		    select.deselectByIndex(index);
	    }

	 // Desselect by attributevalue
	    public void deselectByValue(WebElement element, String value) {
		    Select select = new Select(element);
		    select.deselectByValue(value);
	    }

	 // Desselect by text
	    public void deselectBytext(WebElement element, String text) {
		   Select select = new Select(element);
		   select.deselectByVisibleText(text);
	    }
	    
	 // Deselect all
	    public void deSelectAll(WebElement element) {
		      Select select = new Select(element);
		      select.deselectAll();
	    }

	 // Select by index
	    public void selectByIndex(WebElement element, int index) {
		   Select select = new Select(element);
		   select.selectByIndex(index);
	     }

	 // Select by attribute value
	    public void selectByValue(WebElement element, String value) {
		    Select select = new Select(element);
		    select.selectByValue(value);
	     }

	 // Select by text
	    public void selectBytext(WebElement element, String text) {
		     Select select = new Select(element);
		     select.selectByVisibleText(text);
	     }
	    
	 // Get all options Drop down as text
		public List<WebElement> getAlloptionsText(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}


	 // Get First Selected option in Drop down
		public WebElement firstSelectedoption(WebElement element) {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			return firstSelectedOption;
		}



	    
//<----------------------------------------------Window And Frame Handle----------------------------------------------------->
	 
	//  Get the parent window
	    public String getTheParentWindow() {
		   String windowHandle = driver.getWindowHandle();
		   return windowHandle;
	    }

	//  Get all the windows
		public Set<String> getAllWindows() {
			Set<String> allwindows = driver.getWindowHandles();
			return allwindows;
		}
	
	//  Switch to Switch window
		public void switchWindow() {
		   String parentid = driver.getWindowHandle();
		   Set<String> allid = driver.getWindowHandles();
			for (String eachid : allid) {
				if (!parentid.equals(eachid)) {
					driver.switchTo().window(eachid);
				}
			}
		}
		
		

	//  Switch to frame by index
		public void switchToFrameIndex(int index) {
		   driver.switchTo().frame(index);
		}

	//  Switch to frame by frame id
		public void switchToframeId(String Id) {
			driver.switchTo().frame(Id);
		}
		
	//  Switch to frame by frame Element locator
		public void switchToframeElement(WebElement element) {
			driver.switchTo().frame(element);
		}
		
	//  Switch to frame to default frame
		public void switchToDefaultFrame() {
		   driver.switchTo().defaultContent();
		}

	

	

//<--------------------------------------------------------Action Function------------------------------------------------------->
	
	// Click Using Action
	   public void clickAction(WebElement element) {
		   Actions actions = new Actions(driver);
		   actions.click(element).perform();
	   }

	// Mouse over action for single option
	   public void mouseOver(WebElement target) {
		  Actions actions = new Actions(driver);
		  actions.moveToElement(target).perform();;
	   }

	// Drag and drop
	   public void drogAndDrop(WebElement source, WebElement target) {
		  Actions actions = new Actions(driver);
		  actions.dragAndDrop(source, target).perform();
       }

	// Right click
	   public void rightClick(WebElement element) {
		  Actions actions = new Actions(driver);
		  actions.contextClick(element).perform();
	   }

	// Double click
	   public void doubleClick(WebElement element) {
		  Actions actions = new Actions(driver);
		  actions.doubleClick(element).perform();
	   }
	   
	

//<-------------------------------------------------------Log Insert------------------------------------------------------------->
	
	// Logger configuration 
       public Logger info(String message) {
	      Logger logger=Logger.getLogger("Login Validation");
		  PropertyConfigurator.configure(projectPath()+"\\log4j.properties");
		  logger.info(message);
		  return logger;
	   }
    
//<-------------------------------------------------ScreenShots Calls-------------------------------------------------------------->  
    

        
	//  Take screenshot for visible part of page
	    public void screenShortWebPage(String name) throws IOException {
		   TakesScreenshot screenshot = (TakesScreenshot) driver;
		   File s = screenshot.getScreenshotAs(OutputType.FILE);
		   File d = new File(projectPath()+"\\Screenshots\\" + name + ".png");
		   FileUtils.copyFile(s, d);
	     }
    //  Take screenshot for element
        public void ScreenShotElement(WebElement element, String name) throws IOException {
		  // TakesScreenshot screenshot = (TakesScreenshot) driver;
		   File s = element.getScreenshotAs(OutputType.FILE);
		   File d = new File(projectPath()+"\\Screenshots\\" + name + ".png");
		   FileUtils.copyFile(s, d);
         }


    //  Ashot  fullScreenshot
        public void FullPageScreenShot(String name) throws IOException {
    	   Screenshot scrshot =new AShot().shootingStrategy(ShootingStrategies.viewportPasting(0)).takeScreenshot(driver);
    	   ImageIO.write(scrshot.getImage(), "png", new File(projectPath()+"\\Screenshots\\" + name + ".png"));
        }
    
    //  Ashot capture Image
        public void captureImage(WebElement element ,String Imagename) throws IOException {
    	   Screenshot imageshot = new AShot().takeScreenshot(driver, element);
    	   ImageIO.write(imageshot.getImage(), "png",new File(projectPath()+"\\Screenshots\\" + Imagename + ".png"));
    	   File f=new File("./screenshot/\"+Imagename+\".png");    	 
    	   if (f.exists()) {
    		  System.out.println("image file captured");
    	   } else {
    		  System.out.println("image file not exixts");
    	   }
        }
    
    //  Ashot Compare Image and print difference
        public void compareImage(String expectedImageName, WebElement element) throws IOException {
    	   BufferedImage expectedimage = ImageIO.read(new File(projectPath()+"\\screenshot\\"+expectedImageName+".png"));
    	   Screenshot imageshot = new AShot().takeScreenshot(driver, element);
    	   BufferedImage actualimage = imageshot.getImage();
    	   ImageDiffer imgdiff=new ImageDiffer();
    	   ImageDiff diff=imgdiff.makeDiff(expectedimage, actualimage);
    	   if (diff.hasDiff()==true) {
    		   System.out.println("Image are not Same");
    		   BufferedImage showdiff=diff.getMarkedImage();
    		   ImageIO.write(showdiff, "png", new File(projectPath()+"\\Screenshots\\markedimage1.png"));
    	   } else {
    		    System.out.println("Images are same");
    	   }
        }
    
  //<------------------------------------------------ Robot Class Functions---------------------------------------------------->
	
	
	
	
    // press Enter
 	   public void pressEnter() throws AWTException {
 		  Robot robot = new Robot();
 		  robot.keyPress(KeyEvent.VK_ENTER); 
 	   }
 	
 	// Release Enter
 	   public void releaseEnter() throws AWTException {
 		  Robot robot = new Robot();
 		  robot.keyRelease(KeyEvent.VK_ENTER);
 	   }
 	   
 	// Upload the File by Robot class
 	   public void uploadFile( WebElement element,String path) throws AWTException {
 		  JavascriptExecutor executor=(JavascriptExecutor) driver;
	      executor.executeScript("arguments[0].click()",element );
 		  Robot robot = new Robot();
 		  robot.delay(2000);
 		  StringSelection ss=new StringSelection(path);
 		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
 		  robot.keyPress(KeyEvent.VK_CONTROL);
 		  robot.keyPress(KeyEvent.VK_V);
 		  robot.keyRelease(KeyEvent.VK_CONTROL);
 		  robot.keyRelease(KeyEvent.VK_V);
 		  robot.keyPress(KeyEvent.VK_ENTER);
 		  robot.keyRelease(KeyEvent.VK_ENTER);
 	   }
 	
 	
    
//<----------------------------------------------Color of the webelement Calls ---------------------------------------------------->
    
    
    //  Get background Color
        public String backgroundColor_Hex_Or_RGBA_Or_RGB(WebElement element ,String type) {
    	   String backcolor=element.getCssValue("background-color");
    	   if (type.equalsIgnoreCase("Hex")) {
    		   String HEXcolor=Color.fromString(backcolor).asHex();
    	       return HEXcolor;
		    } else if (type.equalsIgnoreCase("RGB")) {
			    String RGBcolor=Color.fromString(backcolor).asRgb();
			    return RGBcolor;
		    }else {
			     return backcolor;
		    }	    	
         }
   
   //  Get Text Color
       public String textColor_Hex_Or_RGBA_Or_RGB(WebElement element, String type) {
    	  String TxtColor=element.getCssValue("color");
    	  if (type.equalsIgnoreCase("Hex")) {
    		  String HEXcolor=Color.fromString(TxtColor).asHex();
    	      return HEXcolor;
		  } else if (type.equalsIgnoreCase("RGB")) {
			  String RGBcolor=Color.fromString(TxtColor).asRgb();
			  return RGBcolor;
		  }else {
		      return TxtColor;
		  }	
       }
    
   //  Get border Color
       public String borderColor_Hex_Or_RGBA_Or_RGB(WebElement element, String type) {
           String TxtColor=element.getCssValue("border-color");
           if (type.equalsIgnoreCase("Hex")) {
        	   String HEXcolor=Color.fromString(TxtColor).asHex();
        	   return HEXcolor;
    		} else if (type.equalsIgnoreCase("RGB")) {
    			String RGBcolor=Color.fromString(TxtColor).asRgb();
    			return RGBcolor;
    		}else {
    			return TxtColor;
            }
        }


//<------------------------------------------------------------Excel Data--------------------------------------------------------->
       
     // Read Cell Data
        public static String readCellDatum(String path,int sheetnum, int rownum, int cellnum) throws IOException {
    	    String res="";
			File file = new File(path);
			FileInputStream fileinputstream = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fileinputstream);
		    XSSFSheet sheet = workbook.getSheetAt(sheetnum);
			XSSFRow row = sheet.getRow(rownum);
			XSSFCell cell = row.getCell(cellnum);
			CellType type = cell.getCellType();
			switch (type) {
			case STRING:
				res = cell.getStringCellValue();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat dateformat = new SimpleDateFormat("dd-mmm-yyyy");
					res = dateformat.format(dateCellValue);
				 } else {
					double numericCellValue = cell.getNumericCellValue();
					long check = Math.round(numericCellValue);
					if (check == numericCellValue) {
						res = String.valueOf(check);
					} else {
						res = String.valueOf(numericCellValue);
					    }
					break;
				    }
			   default:
			   break;
			 }
			 return res;
		}

   
    
//<---------------------------------------------------Encoder and Decoder------------------------------------------------------------->
    
      //Encode the String Data  
      public String Encoding(String data ) {		
    	  byte[] Encode = Base64.encodeBase64(data.getBytes());
    	  String EncodedData=new String(Encode);
    	  return EncodedData;		
      }
      
      //Decode the String Data   may get failure if happens string format of encoded data is problem change and try
      public String Decoding(String data ) {		
    	  byte[] Decode = Base64.decodeBase64(data.getBytes());
    	  String DecodedData=new String(Decode);
    	  return DecodedData;		
      }
}
