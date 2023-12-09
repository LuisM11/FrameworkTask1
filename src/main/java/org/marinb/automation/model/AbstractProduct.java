package org.marinb.automation.model;

import org.marinb.automation.pages.CalculatorFormPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractProduct {
    private String name;
    private String estimatedCost;

    public AbstractProduct(String name, String estimatedCost) {
        this.name = name;
        this.estimatedCost = estimatedCost;
    }

    public abstract CalculatorFormPage fillForm(CalculatorFormPage calculatorFormPage);

    public String getName() {
        return name;
    }

    public String getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(String estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

}
