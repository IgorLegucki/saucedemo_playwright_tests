package com.tests.login;


import com.tests.base.BaseTest;
import com.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    void shouldLoginAsStandardUser() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();

        loginPage.login("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", page.url(), "You were not logged in correctly");
    }


}
