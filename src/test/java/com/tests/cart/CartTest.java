package com.tests.cart;

import com.tests.base.BaseTest;
import com.tests.pages.InventoryPage;
import com.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CartTest extends BaseTest {

    @Test
    void shouldAddThreeItemsToCart() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addThreeProductsToCart();

        String itemCount = inventoryPage.getCartItemCount();
        assertEquals("3", itemCount, "3 products not added to cart");
    }
}