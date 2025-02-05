package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ShoppingCartSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ShoppingCartStepsDefs {

    @Steps
    ShoppingCartSteps shoppingCartSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        shoppingCartSteps.validateAppLoad();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        shoppingCartSteps.validateProductsLoad();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoUnidadesDelSiguienteProducto(int quantity, String productName) {
        shoppingCartSteps.selectProducts(productName);
        shoppingCartSteps.addProductQuantity(productName, quantity);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        shoppingCartSteps.validateShoppingCart();
    }
}
