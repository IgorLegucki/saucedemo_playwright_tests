package com.tests.cart;

import com.tests.base.BaseTest;
import com.tests.pages.CartPage;
import com.tests.pages.InventoryPage;
import com.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPriceCalculationTest extends BaseTest {

    @Test
    void shouldCalculateTotalPriceCorrectly() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addThreeProductsToCart();

        CartPage cartPage = new CartPage(page);
        cartPage.goToPriceCalculation();

        double totalCalculated = cartPage.getTotalCalculatedPrice();
        double subtotal = cartPage.getItemTotalPrice();

        assertEquals(subtotal, totalCalculated, 0.01, "The total price in the basket is incorrect");
    }
}
