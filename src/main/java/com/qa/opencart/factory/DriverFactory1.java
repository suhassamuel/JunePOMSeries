package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory1 {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager1 optionsManager1;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name:" + browserName);
		optionsManager1 = new OptionsManager1(prop);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsManager1.getChromeOptions());

			tldriver.set(new ChromeDriver(optionsManager1.getChromeOptions()));

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManager1.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager1.getFirefoxOptions()));

		} else if (browserName.equals("safari")) {
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());
		} else {
			System.out.println("Please enter correct browser");
		}

//		driver.get(prop.getProperty("url"));
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();

		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		// return driver;
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;

		String envName = System.getProperty("env");

		if (envName == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Running on environement" + envName);
			try {
				switch (envName) {
				case "qa":

					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");

					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				default:
					break;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

}
