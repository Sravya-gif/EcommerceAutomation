package com.srm.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.srm.driver.DriverFactory;
import com.srm.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ScreenshotUtil.takeScreenshot(DriverFactory.driver, result.getName() + "_SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.takeScreenshot(DriverFactory.driver, result.getName() + "_FAIL");
    }
}