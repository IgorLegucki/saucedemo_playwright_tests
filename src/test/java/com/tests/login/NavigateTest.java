package com.tests.login;


import com.tests.base.BaseTest;
import com.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigateTest extends BaseTest {

    @Test
    void shouldLoginAsStandardUser() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate();
        assertEquals("Swag Labs", loginPage.getTitle(), "Incorrect page title");
    }
}
