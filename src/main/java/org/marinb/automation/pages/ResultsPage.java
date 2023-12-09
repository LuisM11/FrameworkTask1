package org.marinb.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends AbstractPage{
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='___gcse_0']//a[@href='https://cloud.google.com/products/calculator']") // @FindBy( linkText = "Google Cloud Pricing Calculator")
    private WebElement calculatorLink;

    @FindBy(css="#___gcse_0 div.gsc-expansionArea")
    private WebElement searchResultsContainer;
    @Override
    protected AbstractPage openPage() {
        return null;
    }


    public CalculatorFormPage openCalculatorPage() {
        click(calculatorLink);
        return new CalculatorFormPage(driver);
    }

    public int getNumberOfResults() {
        waitElementToBeVisible(searchResultsContainer);
        return searchResultsContainer.findElements(By.xpath("./*")).size();
    }
}
