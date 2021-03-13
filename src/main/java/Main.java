import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement category = driver.findElement(By.id("category"));
        category.click();

        Select selectCategory = new Select(category);
        selectCategory.selectByValue("99");

        WebElement search = driver.findElement(By.id("search"));
        search.sendKeys("принтер");

        driver.findElement(By.cssSelector(".main-location-3j9by")).click();

        WebElement printCity = driver.findElement(By.className("suggest-input-3p8yi"));
        printCity.sendKeys("Владивосток" + Keys.ENTER);

        WebElement chooser = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[6]/div/div/span/div/div[1]/div[2]/div/ul/li[1]"));
        chooser.click();

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[6]/div/div/span/div/div[3]/div[2]/div\n")).click();

        WebElement checkBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div/div[2]/div[1]/form/div[8]/div/div/div/div/div/div/label/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div/div[2]/div[2]/button")).click();

        WebElement filterByValue = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[3]/div[3]/div[1]/div[2]/select"));
        filterByValue.click();

        Select selectValue = new Select(filterByValue);
        selectValue.selectByVisibleText("Дороже");

        WebElement list = driver.findElement(By.className("items-items-38oUm"));
        List<WebElement> printersList = list.findElements(By.xpath("*/div[1]/div[2]/div[2]/a/h3"));
        List<WebElement> priceList = list.findElements(By.xpath("*/div[1]/div[2]/div[3]/span/span/span"));
        System.out.printf("%-65s %-10s\n", "Printer", "Price");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-65s %-10s\n", printersList.get(i).getText(), priceList.get(i).getText());
        }

        driver.close();
    }
}
