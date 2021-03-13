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
        System.out.println("Avito opened");

        WebElement category = driver.findElement(Element.SELECT_CATEGORY.by);
        category.click();
        System.out.println("Select category clicked");


        Select selectCategory = new Select(category);
        selectCategory.selectByValue("99");
        System.out.println("Orgtech chosen");

        WebElement search = driver.findElement(Element.FIND_TEXT_FIELD.by);
        search.sendKeys("принтер");
        System.out.println("Print \"принтер\" in search field");

        driver.findElement(Element.CHOOSE_LOCATION.by).click();
        System.out.println("Choose location clicked");

        WebElement printCity = driver.findElement(Element.LOCATION_TEXT_FIELD.by);
        printCity.sendKeys("Владивосток" + Keys.ENTER);
        System.out.println("\"Вдадивосток\" printed");

        WebElement chooser = driver.findElement(Element.FIRST_LOCATION_OPTION.by);
        chooser.click();
        System.out.println("First option chosen");

        driver.findElement(Element.SHOW_RESULT_BUTTON.by).click();
        System.out.println("Result shown");

        WebElement checkBox = driver.findElement(Element.CHECKBOX.by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        System.out.println("Checkbox clicked");

        driver.findElement(Element.SEARCH_BUTTON.by).click();
        System.out.println("Search button clicked");

        WebElement filterByValue = driver.findElement(Element.MONEY_FILTER.by);
        filterByValue.click();
        System.out.println("Money filter clicked");

        Select selectValue = new Select(filterByValue);
        selectValue.selectByVisibleText("Дороже");
        System.out.println("The most expensive chosen\n");

        WebElement list = driver.findElement(Element.FIELD_WITH_PRODUCTS.by);
        List<WebElement> printersList = list.findElements(Element.PRODUCT_LIST.by);
        List<WebElement> priceList = list.findElements(Element.PRICE_LIST.by);
        System.out.printf("%-65s %-10s\n", "Printer", "Price");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-65s %-10s\n", printersList.get(i).getText(), priceList.get(i).getText());
        }
        System.out.println("\nThe most expensive printers shown");

        driver.close();
        System.out.println("Driver closed");
    }
}
