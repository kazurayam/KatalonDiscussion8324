import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

def url = 'http://demoaut.katalon.com'
WebUI.navigateToUrl(url)
WebUI.delay(GlobalVariable.medium_wait)

WebUIDriverType executedBrowser = DriverFactory.getExecutedBrowser()
switch(executedBrowser) {
	case WebUIDriverType.CHROME_DRIVER:
		WebDriver driver = DriverFactory.getWebDriver()
		LogEntries logs = driver.manage().logs().get("browser")
		for (LogEntry entry: logs) {
			println(">>> ${entry.getMessage()}")
		}
}

WebUI.closeBrowser()
