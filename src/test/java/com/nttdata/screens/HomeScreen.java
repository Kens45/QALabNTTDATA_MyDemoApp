package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomeScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"App logo and name\"]")
    private WebElement appLogo ;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]")
    private WebElement productsContainer;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement productsListRV;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement shoppingCartIcon;
    
    public boolean logoVisible() {
        waitFor(ExpectedConditions.visibilityOf(appLogo));
        return appLogo.isDisplayed();
    }

    public boolean productsVisible() {
        waitFor(ExpectedConditions.visibilityOf(productsContainer));
        waitFor(ExpectedConditions.visibilityOf(productsListRV));
        return productsListRV.isDisplayed();
    }

    public void selectProduct(String productName) {
        List<WebElement> lblProducts = productsListRV.findElements(By.xpath("//android.widget.TextView"));
        List<WebElement> productsVG = productsListRV.findElements(By.xpath("//android.view.ViewGroup"));
        int index = 0;
        for (WebElement lblProduct : lblProducts) {
            if (lblProduct.getText().equals(productName)) {
                productsVG.get(index).click();
                break;
            }
            index++;
        }
    }

    public void goToShoppingCart(){
        shoppingCartIcon.click();
    }
}
