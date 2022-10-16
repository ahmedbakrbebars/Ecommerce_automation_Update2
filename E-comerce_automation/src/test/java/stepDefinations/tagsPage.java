package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import pages.tags;

public class tagsPage {
    tags Tags = new tags();

    @Given("user navigate to computer category page")
    public void navigate_to_home() {
        String url = "https://demo.nopcommerce.com/computers";
        browser.driver.navigate().to(url);
    }

    @When("user select cool from popular tags")
    public void Cool_Tags() {
        Tags.Cool_Tags();
    }

    @And("user select digital from popular tags")

    public void Digital_Tags() {
        Tags.Digital_Tags();
    }

    @And("user select game from popular tags")

    public void Game_Tags() {
        Tags.Game_Tags();
    }

    @And("user select computer from popular tags")
    public void Computer_Tags() {
        Tags.Computer_Tags();
    }
    @Then("tag confirm message")
    public void confirmMessage(){
        String ExpectedResult = "Products tagged with 'computer'";
        String ActualResult = browser.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div.center-2 > div > div.page-title > h1")).getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
}
