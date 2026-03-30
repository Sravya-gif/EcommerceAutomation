package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;
import com.srm.pages.CartPage;
import com.srm.pages.LoginPage;
import com.srm.pages.CheckoutPage;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void fullCheckoutFlow() throws Exception {

        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);
        LoginPage login = new LoginPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        products.clickProducts();
        Thread.sleep(2000);

       
        products.addFirstProductToCart();
        Thread.sleep(2000);

        
        products.clickViewCart();
        Thread.sleep(2000);

        
        cart.clickProceedToCheckout();
        Thread.sleep(2000);

      
        cart.clickRegisterLogin();
        Thread.sleep(2000);

        login.login("sravya11@gmail.com", "123456");
        Thread.sleep(3000);

        
        cart.openCart();
        Thread.sleep(2000);

        cart.clickProceedToCheckout();
        Thread.sleep(3000);

       
        checkout.enterComment("Please deliver fast");
        checkout.clickPlaceOrder();
        Thread.sleep(2000);

       
        checkout.enterPaymentDetails("Sravya", "1234123412341234",
                "123", "12", "2028");

        checkout.clickPayConfirm();
        Thread.sleep(4000);

        System.out.println("Order placed successfully");
    }
}