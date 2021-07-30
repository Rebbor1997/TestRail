package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasePage extends BasePage {
    private final static By run_Test_Case = By.xpath("//a[.= 'NewProjectBor']");
    private final static By run_Test_Case_Button = By.id("sidebar-cases-add");
    private final static By test_Case_Tittle = By.id("title");
    private final static By test_Case_Preconds = By.id("custom_preconds_display");
    private final static By test_Case_Steps = By.id("custom_steps_display");
    private final static By test_Case_Result = By.id("custom_expected_display");
    private final static By test_Case_Add = By.id("accept");


    public TestCasePage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() { driver.get(properties.getURL());

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddTestCase().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getAddTestCase() {return driver.findElement(run_Test_Case);}
    public WebElement getAddTestCaseButton() {return driver.findElement(run_Test_Case_Button);}
    public WebElement getTestCaseTittle() {return driver.findElement(test_Case_Tittle);}
    public WebElement getTestCasePreconds() {return driver.findElement(test_Case_Preconds);}
    public WebElement getTestCaseSteps() {return driver.findElement(test_Case_Steps);}
    public WebElement getTestCaseResult() {return driver.findElement(test_Case_Result);}
    public WebElement getTestCaseAdd() {return driver.findElement(test_Case_Add);}


    public void clickRunTestCase(){ getAddTestCase().click() ;}
    public void clickTestCaseButton(){ getAddTestCaseButton().click() ;}
    public void setTittle(String text) { getTestCaseTittle().sendKeys(text); }
    public void setPreconds(String text) { getTestCasePreconds().sendKeys(text);}
    public void setSteps(String text) { getTestCaseSteps().sendKeys(text);}
    public void setResult(String text) { getTestCaseResult().sendKeys(text);}
    public void clickAddTestCase() { getTestCaseAdd().click();}







}
