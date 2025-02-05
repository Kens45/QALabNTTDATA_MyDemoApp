package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ShoppingCartScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement shoppingCartTittle ;
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup")
    private WebElement productsCartContainer;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement productsCartListRV;

    public boolean validateProductOnShoppingCart() {
        waitFor(ExpectedConditions.visibilityOf(shoppingCartTittle));
        waitFor(ExpectedConditions.visibilityOf(productsCartContainer));
        waitFor(ExpectedConditions.visibilityOf(productsCartListRV));
        return productsCartListRV.isDisplayed();
    }
}
