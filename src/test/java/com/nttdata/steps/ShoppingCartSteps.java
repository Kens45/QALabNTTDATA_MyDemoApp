package com.nttdata.steps;

import com.nttdata.screens.HomeScreen;
import com.nttdata.screens.ProductsScreen;
import com.nttdata.screens.ShoppingCartScreen;
import org.junit.Assert;

public class ShoppingCartSteps {

    HomeScreen homeScreen;
    ProductsScreen productsScreen;
    ShoppingCartScreen shoppingCartScreen;

    public void validateAppLoad(){
        Assert.assertTrue("La aplicación no ha cargado correctamente",homeScreen.logoVisible());
    }

    public void validateProductsLoad(){
        Assert.assertTrue("Los productos no se han cargado correctamente",homeScreen.productsVisible());
    }

    public void selectProducts(String productName){
        homeScreen.selectProduct(productName);
    }

    public void addProductQuantity(String productName, int quantity){
        Assert.assertTrue("Producto no encontrado",productsScreen.isCorrectProduct(productName));
        productsScreen.selectQuantity(quantity);
        productsScreen.addProductToShoppingCart();
    }

    public void validateShoppingCart(){
        homeScreen.goToShoppingCart();
        Assert.assertTrue("No se agrego el producto correctamente",shoppingCartScreen.validateProductOnShoppingCart());
    }
}
