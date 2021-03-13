import org.openqa.selenium.By;

public enum Element {
    SELECT_CATEGORY(By.id("category")),
    FIND_TEXT_FIELD(By.id("search")),
    CHOOSE_LOCATION(By.cssSelector(".main-location-3j9by")),
    LOCATION_TEXT_FIELD(By.className("suggest-input-3p8yi")),
    FIRST_LOCATION_OPTION(By.xpath("//div[contains(@class,'popup-container')]//li[contains(@class,'suggest-suggest')]")),
    SHOW_RESULT_BUTTON(By.xpath("//div[contains(@class,'popup-container')]//button[contains(@class,'button')]")),
    CHECKBOX(By.xpath("//div[contains(@data-marker,'delivery')]//label[contains(@class,'checkbox')]")),
    SEARCH_BUTTON(By.xpath("//div[contains(@class,'applyButton-root')]//button[contains(@class,'button')]")),
    MONEY_FILTER(By.xpath("//div[contains(@class,'index-content')]//select[contains(@class,'select')]")),
    FIELD_WITH_PRODUCTS(By.xpath("//div[contains(@class,'items-items')]")),
    PRODUCT_LIST(By.xpath("//h3[@itemprop='name']")),
    PRICE_LIST(By.xpath("//span[contains(@class,'price-price')]"))
    ;

    public final By by;

    Element(By by) {
        this.by = by;
    }
}
//div[contains(@class,'applyButton-root')]//button[contains(@class,'button')]