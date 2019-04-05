import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class slapKirk {

    public static void moveLeft(Actions actions, WebElement webElement){
        actions.moveToElement(webElement).moveByOffset(-75,  0).build().perform();
    }
    public static void moveRight(Actions actions, WebElement webElement){
        actions.moveToElement(webElement).moveByOffset(75,  0).build().perform();
    }

    public static void main(String[] args) {
        String TARGET_URL ="http://www.slapKirk.com/";

        WebDriver driver = new ChromeDriver();
        driver.navigate().to(TARGET_URL);

        WebElement playButton = driver.findElement(By.id("playButton"));
        playButton.click();

        Actions mouseCursor = new Actions(driver);

        WebElement kirkImage = driver.findElement(By.id("animationImage"));

        for(int i = 0; i < 1000; i++ ){
            if (i % 2 == 0) moveLeft(mouseCursor, kirkImage);
            else moveRight(mouseCursor, kirkImage);
        }
        WebElement fastest = driver.findElement(By.id("highScoreLink"));

        System.out.println(fastest.getText());
        driver.quit();
    }
}
