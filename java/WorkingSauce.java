import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import static org.junit.Assert.assertEquals;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkingSauce {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

	/**
	* Task I: Update the test code so when it runs, the test clicks the "I am a link" link.
	*
	* Task II - Comment out the code from Task I. Update the test code so when it runs, 
	* the test is able to write "Sauce" in the text box that currently says "I has no focus".
	*
	* Task III - Update the test code so when it runs, it adds an email to the email field, 
	* adds text to the comments field, and clicks the "Send" button.
	* Note that email will not actually be sent!
	*
	* Task IV - Add a capability that adds a tag to each test that is run.
        * See this page for instructions: https://wiki.saucelabs.com/display/DOCS/Test+Configuration+Options
	*/

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "Windows 7");
    caps.setCapability("browserName", "chrome");
    caps.setCapability("version", "48");
    caps.setCapability("name", "Guinea-Pig Sauce");
    caps.setCapability("tags","Test1");

   
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

  /**
  * Goes to Sauce Lab's guinea-pig page and verifies the title
  */

    driver.get("https://saucelabs.com/test/guinea-pig");
    assertEquals("I am a page title - Sauce Labs", driver.getTitle());

// Task I
   //driver.findElement(By.linkText("i am a link")).click();
	

// Task II
   /* WebElement input = driver.findElement(By.id("i_am_a_textbox"));

    input.sendKeys("Sauce");
   */
	

// Task III
	/*
        driver.findElement(By.id("fbemail")).clear();
	driver.findElement(By.id("comments")).clear();

       WebElement email = driver.findElement(By.id("fbemail"));
       WebElement comments = driver.findElement(By.id("comments"));
       email.sendKeys("daugereaux@gmail.com");
       comments.sendKeys("this is a comment.");
       driver.findElement(By.id("submit")).click();
      */

    

    driver.quit();
  }
}
