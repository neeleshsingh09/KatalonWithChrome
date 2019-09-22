import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil

import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

Mobile.comment('Story: Verify correct alarm message')

Mobile.comment('Given that user has started an application')

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())

String USERNAME = "neeleshsingh1";
String AUTOMATE_KEY = "gzF5sz1StGzVCX6DYseQ";
String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

String userName = "neeleshsingh1";
String accessKey = "gzF5sz1StGzVCX6DYseQ";
	
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("device", "Samsung Galaxy S8 Plus");
	caps.setCapability("app", "bs://2ffbfa4db23b2ecea43287ccfc1a77dbb7e2fccb");

	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

	AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
		ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
	searchElement.click();
	AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
		ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
	insertTextElement.sendKeys("TestDemoNes");
	Thread.sleep(5000);

	List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
	assert(allProductsName.size() > 0);

	driver.quit();
Mobile.closeApplication()


