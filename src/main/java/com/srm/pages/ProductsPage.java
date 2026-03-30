package com.srm.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    By productsBtn = By.xpath("//a[@href='/products']");
    By allProducts = By.className("product-image-wrapper");
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By addToCartBtn = By.xpath("(//a[contains(text(),'Add to cart')])[1]");
    By continueShoppingBtn = By.xpath("//button[text()='Continue Shopping']");
    By viewCartBtn = By.xpath("//u[text()='View Cart']");
    

    public void clickProducts() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(productsBtn));

        driver.findElement(productsBtn).click();
    }
    public int getProductsCount() {
        List<WebElement> products = driver.findElements(allProducts);
        return products.size();
    }

    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchBtn).click();
    }

    public void addFirstProductToCart() {

        WebElement addBtn = driver.findElement(addToCartBtn);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", addBtn);

       
        js.executeScript("arguments[0].click();", addBtn);
    }

    public void clickContinueShopping() {
        driver.findElement(continueShoppingBtn).click();
    }

    public void clickViewCart() {
        WebElement viewCart = driver.findElement(viewCartBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCart);
    }
}