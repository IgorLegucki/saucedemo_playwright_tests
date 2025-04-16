# Saucedemo Playwright Java Tests

This project contains a set of end-to-end (E2E) automated tests for the https://www.saucedemo.com web application, written in **Java** using **Playwright** and **JUnit 5**.

---

## Technologies used

- [Java 17+]
- [Maven]
- [Playwright for Java]
- [JUnit 5]

---

## Test scenario

The test suite simulates a complete purchasing flow:

1. Verifying the page title.
2. Logging in as the `standard_user`.
3. Adding three selected products to the cart.
4. Validating the cart contents.
5. Proceeding to the checkout page.
6. Filling in user information.
7. Asserting that the product subtotal is calculated correctly.

Each step is validated using assertions to ensure expected outcomes.

---

## Running the tests

Install the Playwright browsers:
   ```bash
   mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

### Test classes and covered scenarios

| Class Name   | Method                                      | Description                                                                |
|--------------|---------------------------------------------|--------------------------------------------------------------------------  |
| `LoginTest`  | `shouldLoginAsStandardUser()`               | Logs in with valid `standard_user` credentials and checks successful login |
| `TitleTest`  | `shouldDisplayCorrectPageTitle()`           | Verifies that the page title is `"Swag Labs"`                              |
| `CartTest`   | `shouldAddThreeProductsToCart()`            | Adds three products and checks cart content                                |
| `CartTest`   | `shouldMatchCalculatedAndDisplayedTotal()`  | Proceeds to checkout and verifies product total cost                       |
| `CartTest`   | `shouldFillOutCheckoutForm()`               | Fills out first name, last name, and postal code fields                    |

