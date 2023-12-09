package tests;

import org.marinb.automation.pages.HomePage;
import org.marinb.automation.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GCPHomeTest extends CommonTestsConditions{

    @Test()
    public void searchContent(){
        String stringToSearch = "Kubernetes";
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.openPage().search(stringToSearch);
        String title = resultsPage.getExpectedTitle(stringToSearch).split(" ")[3].replace("\"", "");
        Assert.assertEquals(title, stringToSearch);
        Assert.assertTrue(resultsPage.getNumberOfResults() > 0);
    }

}
