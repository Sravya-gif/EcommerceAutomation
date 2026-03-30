package com.srm.tests;

import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.ProductsPage;
import com.srm.pages.CartPage;

public class ProductsTest extends BaseTest {

    @Test
    public void productsPageTest() throws Exception {

        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        System.out.println("Opening Products Page");
        products.clickProducts();

        Thread.sleep(2000);

        int count = products.getProductsCount();
        System.out.println("Total Products: " + count);

        products.searchProduct("Tshirt");

        Thread.sleep(2000);

        products.addFirstProductToCart();

        Thread.sleep(2000);

        products.clickViewCart();

        Thread.sleep(2000);

        cart.clickProceedToCheckout();

        Thread.sleep(3000);
    }
}