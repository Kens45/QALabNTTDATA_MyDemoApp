package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement lblProductName;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement lblQuantityProduct;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement addQuantityButton;
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement addToCartButton;

    public boolean isCorrectProduct(String productName) {
        waitFor(ExpectedConditions.visibilityOf(lblProductName));
        return lblProductName.getText().equals(productName);
    }

    public void selectQuantity(int quantity){
        int q = Integer.parseInt(lblQuantityProduct.getText());
        while ( q != quantity){
            addQuantityButton.click();
            q++;
        }
    }

    public void addProductToShoppingCart(){
        addToCartButton.click();
    }
}
