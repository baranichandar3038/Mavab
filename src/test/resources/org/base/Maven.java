package org.base;

public class Maven {
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import java.util.List;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.ui.Select;


	import io.github.bonigarcia.wdm.WebDriverManager;

	public class HelperClass {

		public static WebDriver driver;

		public static Actions a;

		public static Robot r;

		public static JavascriptExecutor js;

		public static TakesScreenshot ts;

		public static Alert ar;

		public static Select s;

		public static void launchBrowser() {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		public static void loadUrl(String url) {
			driver.get(url);

		}

		public static void maxBrowser() {
			driver.manage().window().maximize();

		}

		public static void pageUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);

		}

		public static void pageTitle() {
			String title = driver.getTitle();

		}

		public static void toText(WebElement element, String text) {
			element.sendKeys(text);

		}

		public static void btnClick(WebElement element) {
			element.click();

		}

		public static void printGetText(WebElement element) {
			String attribute = element.getAttribute("value");
			System.out.println(attribute);

		}

		public static void perfomMoverToElement(WebElement element) {
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
		}

		public static void performDragandDrop(WebElement src, WebElement desc) {
			a.dragAndDrop(src, desc).perform();

		}

		public static void performDoubleClick(WebElement element) {
			a.doubleClick(element).perform();

		}

		public static void rightClick(WebElement element) throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		public static void toTakeScreenshot() throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File f1 = ts.getScreenshotAs(OutputType.FILE);
			File f2 = new File("C:\\Users\\kalyanasundaram\\eclipse-workspace\\Framwork\\ScreenShot\\img.png");
			FileHandler.copy(f1, f2);

		}

		public static void toScroll(WebElement element1, WebElement element2) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element1);
			js.executeScript("arguments[0].scrollIntoView(false)", element2);

		}
		
		public void toScrolldown(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)",element);

		}

		public static void toDismissAlert() {
			Alert ar = driver.switchTo().alert();
			String string2 = ar.toString();
			System.out.println(string2);

		}

		public static void toGetAllOptionsInDropDown(WebElement element) {
			Select s = new Select(element);

			List<WebElement> options = s.getOptions();
			for (WebElement WebElement1 : options) {
				System.out.println();

			}

		}
		public void toGetOptionInDropDownSelect(WebElement element) {
			Select s1=new Select(element);
			s1.selectByIndex(0);
			

		}

		public static void getAllSelectedOptions(WebElement element) {
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			for (WebElement WebElement2 : allSelectedOptions) {
				System.out.println(WebElement2.getText());

			}
		}

		public static void selectedByIndex(int index) {
			s.selectByIndex(index);

		}

		public static void selectedByVisibleText(String text3) {
			s.selectByVisibleText(text3);

		}

		public static void selectedByValue(String value) {
			s.selectByValue(value);

		}

		public static void switchWindow() {
			String parWin = driver.getWindowHandle();
			Set<String> allWin = driver.getWindowHandles();
			for (String eachWindow : allWin) {
				if (!(eachWindow).equals(parWin)) {
					driver.switchTo().window(eachWindow);

				}

			}
		}
		
		 public static String excelRead(int row, int column) throws Exception {
			 File file = new File("C:\\Users\\kalyanasundaram\\eclipse-workspace\\Framwork\\exclesheet\\txt.xlsx");
			 FileInputStream fin=new FileInputStream(file);
			 Workbook book = new XSSFWorkbook(fin);
			 Sheet sheet = book.getSheet("login");
			 Row allRows = sheet.getRow(row);
			 Cell cell = allRows.getCell(column);
			 int cellType = cell.getCellType();
			 String string = "";
			 if (cellType == 1) {
				 string = cell.getStringCellValue();
				 } else if (DateUtil.isCellDateFormatted(cell)) {
					 Date date = cell.getDateCellValue();
					 SimpleDateFormat sim = new SimpleDateFormat("dd-MMM-yyyy");
					 string = sim.format(date);
					 } else {
						 double num = cell.getNumericCellValue();
						 long l = (long) num;
						 string = String.valueOf(l);
						 
					 }
			 return string;
		}
		 
		 public static void impiWait() {
			 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		}
		 
		 public static void dateAndTime() {
			Date d = new Date();
			System.out.println(d);

		}
		 
			
		
		

	}

}
