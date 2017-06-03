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
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Softwareengineering {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException, Exception {
        
        // TODO code application logic here
        facebook();
    }
    public static void Caller(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
       WebDriver WDname = new ChromeDriver(); 
       WDname.get("http://localhost/musicstore-system-beta/");
       System.out.println(WDname.getTitle());
       System.out.println(WDname.getCurrentUrl());
//       System.out.println(WDname.getPageSource());
       
//       WDname.navigate().to("http://localhost/musicstore-system-beta/login.php");
//       WDname.navigate().back();
//       WDname.navigate().forward();
       WebElement f = WDname.findElement(By.id("featured-description"));
       f.findElement(By.tagName("p"));
       System.out.println(f.toString());
       
    }
    public static void method2(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
       WebDriver WDname = new ChromeDriver(); 
       WDname.navigate().to("https://www.yahoo.com");
       try {
           Thread.sleep(2000);
       }catch(Exception e){
           
       }
       WDname.navigate().to("https://www.google.com");
       WDname.navigate().refresh();
       WDname.navigate().back();
       WDname.navigate().forward();
       WDname.close();
    }
    public static void method3(){
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    WebDriver WDname = new ChromeDriver();
    WDname.navigate().to("https://www.google.com");
    WebElement search = WDname.findElement(By.name("q"));
    search.sendKeys("addis ababa university");
    search.click();
    try {
           Thread.sleep(5000);
       }catch(Exception e){
           
       }
    search.clear();
    WDname.close();
    }
    
    //-------------------Assignment-----------------------------------
    
    public static void findFriend( String friendName, WebDriver WDname) throws Exception{
//    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
//    WebDriver WDname = new ChromeDriver();
    WDname.navigate().to("https://www.facebook.com");
    WDname.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    WDname.findElement(By.xpath(".//*[@id = 'email']")).sendKeys("user_name");
//    WDname.findElement(By.xpath(".//*[@id = 'pass']")).sendKeys("password");
//    WDname.findElement(By.xpath(".//*[@type='submit']")).click();
    WDname.findElement(By.xpath(".//*[@name = 'q']")).sendKeys(friendName);
    WDname.findElement(By.xpath(".//*[@data-testid='facebar_search_button']")).click();
    WDname.findElement(By.cssSelector("#xt_uniq_2 > div > div._2xjf > a > div")).click();
    WDname.findElement(By.xpath("//*[@data-tab-key='friends']")).click();

   while(true){
       
          List<WebElement> friendListBeforeScrolling = WDname.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
          System.out.println("Total Friends" + friendListBeforeScrolling.size());
          
          //scroll to y-coordinate
          WebElement lastFriend = friendListBeforeScrolling.get(friendListBeforeScrolling.size()-1);
          int y = lastFriend.getLocation().y;
          JavascriptExecutor js = (JavascriptExecutor)WDname;
          js.executeScript("window.scrollTo(0,"+y+")");
          Thread.sleep(4000);
          List<WebElement> friendListAfterScrolling = WDname.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
      if (friendListBeforeScrolling.size() == friendListAfterScrolling.size()) {
          System.out.println("--------------------------->> Friends of " + friendName);
          int i =0;
          String[] allF = new String[friendListBeforeScrolling.size()];
          
          for(WebElement name: friendListBeforeScrolling){
             allF[i] =  name.getText();
            System.out.println(i +"."+name.getText());
              copyToExcel(name.getText(),i,"a");
              i++;
            }
          System.out.println(allF.length);
           break;
           }
   }
   try {          
       }catch(Exception e){
           }
    }
    public static void copyToExcel(String name, int index, String fileName) throws Exception{
        File src = new File("C:\\TestD\\"+fileName+".xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);  
        XSSFSheet sheet1 = wb.getSheetAt(0);
        sheet1.getRow(index).createCell(0).setCellValue(name);
        FileOutputStream fout = new FileOutputStream(src);
        wb.write(fout);
        wb.close();
    
    }
    public static void facebook() throws Exception{
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    WebDriver WDname = new ChromeDriver();
    WDname.navigate().to("https://www.facebook.com");
    WDname.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WDname.findElement(By.xpath(".//*[@id = 'email']")).sendKeys("user_name");
    WDname.findElement(By.xpath(".//*[@id = 'pass']")).sendKeys("password");
    WDname.findElement(By.xpath(".//*[@type='submit']")).click();
    WDname.findElement(By.xpath("//*[@title='Profile']")).click();
//    WDname.findElement(By.xpath("//*[@data-tab-key='friends']")).click();
    String frinedsCount = WDname.findElement(By.xpath("//*[@data-tab-key ='friends']")).getText().substring(7);
    WDname.findElement(By.xpath("//*[@data-tab-key='friends']")).click();


   int count = Integer.parseInt(frinedsCount); 

   while(true){
       
          List<WebElement> friendListBeforeScrolling = WDname.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
          System.out.println("Total Friends" + friendListBeforeScrolling.size());
          
          //scroll to y-coordinate
          WebElement lastFriend = friendListBeforeScrolling.get(friendListBeforeScrolling.size()-1);
          int y = lastFriend.getLocation().y;
          JavascriptExecutor js = (JavascriptExecutor)WDname;
          js.executeScript("window.scrollTo(0,"+y+")");
          Thread.sleep(4000);
          List<WebElement> friendListAfterScrolling = WDname.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
      if (friendListBeforeScrolling.size() == friendListAfterScrolling.size()) {
          int i =0;
          String[] allF = new String[friendListBeforeScrolling.size()];
          for(WebElement name: friendListBeforeScrolling){
             allF[i] =  name.getText();
//            System.out.println(i +"."+name.getText());
              copyToExcel(name.getText(),i,"p");
//              findFriend(name.getText(),WDname);
              i++;
            }
          System.out.println( "IN THE ARRAY: "+ allF.length);
          for (int j = 0; j < allF.length; j++) {
              findFriend(allF[j],WDname);
          }
           break;
           }
   }

    try {
//           Thread.sleep(5000);
       }catch(Exception e){
           
       }

    }
    
}
