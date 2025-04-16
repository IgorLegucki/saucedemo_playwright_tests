package com.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CartPage {
    private final Page page;

    public void goToPriceCalculation() {
        page.click("[data-test=shopping-cart-link]");
        page.click("[data-test=checkout]");
        page.fill("[data-test=firstName]", "aaa");
        page.fill("[data-test=lastName]", "bbb");
        page.fill("[data-test=postalCode]", "ccc");
        page.click("[data-test=continue]");
    }

    public List<Double> getItemPrices() {
        Locator prices = page.locator(".inventory_item_price");
        return prices.allTextContents().stream()
                .map(text -> text.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public double getTotalCalculatedPrice() {
        return getItemPrices().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getItemTotalPrice() {
        String subtotalText = page.locator(".summary_subtotal_label").textContent();
        String cleanedText = subtotalText.replace("Item total: $", ""); // "55.97"
        return Double.parseDouble(cleanedText);
    }
}
