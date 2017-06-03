/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareengineering;

/**
 *
 * @author paulos
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Print_Names {

 public static void main(String[] args) throws Exception {
  // TODO Auto-generated method stub

  WebDriver d = new ChromeDriver();
  EventFiringWebDriver driver = new EventFiringWebDriver(d);
  
  driver.get("http://www.facebook.com");
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("paulosta9@gmail.com");
  driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("0911250725");
  driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(Keys.ENTER);
  driver.findElement(By.xpath("//*[@id='pagelet_welcome_box']/div/a/img")).click();
  Thread.sleep(5000);
  driver.get("URL for Friends page");
  Thread.sleep(5000);
  
  //Command to display a message through Javascript
  //driver.executeScript("alert('Hello friend list has been loaded)");
  
  //Command to scroll down through the Window
  //driver.executeScript("scroll (0,50000)");
  
  //Logic to expand the Friend List
  while(true){
   try {
    driver.executeScript("scroll (0,1000000)");
    Thread.sleep(9000);
    System.out.println("Expanded Everything ");
    break;
   }catch(Throwable T){
   System.out.println("Could not Expand ");
   }
 }
   
  //Logic to Print the Names and total number of friends in friends list 
  
  WebElement Box = driver.findElement(By.xpath(".//*[@id='pagelet_timeline_medley_friends']/div[2]"));
  
  List<WebElement> names= Box.findElements(By.tagName("a"));
  System.out.println("Total Friends in PrintNameFunction -- " + names.size());
//        File src = new File("C:\\TestD\\testing.xlsx");
//        FileInputStream fis = new FileInputStream(src);
//        XSSFWorkbook wb = new XSSFWorkbook(fis);  
//        XSSFSheet sheet1 = wb.getSheetAt(0);
//  for(int j=0;j<names.size();j++){
//    String frnd = names.get(j).getText();
  //  if(!frnd.trim().equals(""))
//    sheet1.getRow(j).createCell(0).setCellValue(frnd);
//    FileOutputStream fout = new FileOutputStream(src);
//        wb.write(fout);
//        wb.close();
//    System.out.println(j + ". " + frnd);
  
//  }
  
  String[] friend = new String[names.size()];
        
//     for (int i = 0; i < names.size(); i++) {
//         friend[i] = names.get(i).getText();
////         System.out.println(i + ". " + friend[i]);
//      
//     } 
//     for (int i = 0; i < friend.length; i++) {
////           System.out.println(i + ". " + friend[i]); 
//           copyToExcel(friend[i], i);
//     }
    

        
  
}
  public static void copyToExcel(String name, int index) throws Exception{
        File src = new File("C:\\TestD\\testing.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);  
        XSSFSheet sheet1 = wb.getSheetAt(0);
        sheet1.getRow(index).createCell(0).setCellValue(name);
        FileOutputStream fout = new FileOutputStream(src);
        wb.write(fout);
        wb.close();
    
    }
 
 
}
