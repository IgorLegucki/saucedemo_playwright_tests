package com.tests.pages;

import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InventoryPage {
    private final Page page;

    public void addThreeProductsToCart() {
        page.click("#add-to-cart-sauce-labs-backpack");
        page.click("#add-to-cart-sauce-labs-bike-light");
        page.click("#add-to-cart-sauce-labs-bolt-t-shirt");
    }

    public String getCartItemCount() {
        return page.locator(".shopping_cart_badge").innerText();
    }
}