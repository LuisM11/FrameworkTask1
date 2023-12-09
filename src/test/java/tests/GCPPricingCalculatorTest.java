package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.marinb.automation.model.ComputeEngine;
import org.marinb.automation.pages.CalculatorFormPage;
import org.marinb.automation.pages.HomePage;
import org.marinb.automation.pages.YopMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GCPPricingCalculatorTest extends CommonTestsConditions{
    private static final Logger logger = LogManager.getLogger(GCPPricingCalculatorTest.class);

    @Test(priority = 1)
    public void selectProduct(){
        CalculatorFormPage calculatorFormPage = new CalculatorFormPage(driver);
        String productName = "AlloyDB Omni";
        calculatorFormPage.openPage().selectProductTab(productName);
        Assert.assertTrue(calculatorFormPage.getFormTitle(productName).contains(productName));
    }

    @Test(priority = 2)
    public void verifyEstimatedCostViaEmailAndPage() {
        HomePage homePage = new HomePage(driver);

        //Completing form with specified parameters
        CalculatorFormPage calculatorFormPage = homePage.openPage().search("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage();
        //Abstraction of product: Compute Engine
        ComputeEngine computeEngine = new ComputeEngine.Builder()
                .setInstancesNumber(4)
                .setOperatingSystem("free")
                .setProvisioningModel("regular")
                .setMachineFamily("gp")
                .setSeries("n1")
                .setMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .setGPU(true)
                .setGpuType("NVIDIA_TESLA_V100")
                .setGPUsNumber(1)
                .setLocalSSD(2)
                .setLocation("europe-west3")
                .setUsageTime(1)
                .build();

        //Getting estimated cost from page
        String estimatedCostInPage = computeEngine.fillForm(calculatorFormPage).getEstimatedCost();
        computeEngine.setEstimatedCost(estimatedCostInPage);

        //Generating random email and copying it to clipboard
        YopMailPage yopMailPage = new YopMailPage(driver).openPage();
        String email = yopMailPage.getCopiedEmail();

        //Filling email field to get estimated cost via email
        ((CalculatorFormPage) calculatorFormPage.switchTab())
                .switchToFormIframe()
                .clickEmailEstimateButton()
                .fillEmailAndSubmit(email);

        //Checking inbox and getting estimated cost from email
        String estimatedCostInEmail = ((YopMailPage) yopMailPage.switchTab())
                .checkInbox()
                .getEstimatedCost();

        Assert.assertEquals(estimatedCostInPage.split(" ")[4], estimatedCostInEmail.split(" ")[4]);

    }




}
