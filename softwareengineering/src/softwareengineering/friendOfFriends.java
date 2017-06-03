/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package softwareengineering;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static softwareengineering.Softwareengineering.copyToExcel;

/**
 *
 * @author paulos
 */
public class friendOfFriends {
    public static void main(String[] args) throws Exception{
        
        //findFriend();
        
    }
    public static void findFriend() throws Exception{
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    WebDriver WDname = new ChromeDriver();
    WDname.navigate().to("https://www.facebook.com");
    WDname.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    WDname.findElement(By.xpath(".//*[@id = 'email']")).sendKeys("paulosta9@gmial.com");
    WDname.findElement(By.xpath(".//*[@id = 'pass']")).sendKeys("0911250725");
    WDname.findElement(By.xpath(".//*[@type='submit']")).click();
    WDname.findElement(By.xpath(".//*[@name = 'q']")).sendKeys("Binyam fantaye");
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
          int i =0;
          for(WebElement name: friendListBeforeScrolling){
              
            System.out.println(i +"."+name.getText());
              copyToExcel(name.getText(),i,"a");
              i++;
            }
           break;
           
       }
   }

    try {          
       }catch(Exception e){
           }
    }
    
}
