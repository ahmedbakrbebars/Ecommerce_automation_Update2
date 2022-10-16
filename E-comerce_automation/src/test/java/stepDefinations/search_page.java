package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import junit.framework.Assert;
import org.openqa.selenium.By;
import pages.search;

import java.util.ArrayList;

public class search_page {
    search search = new search();

    @When("user clicks on search field")
    public void search()
    {
        search.search().click();
    }

    @And("user search with name of product")
    public void search_product()
    {
        search.search_product().sendKeys("Apple MacBook");
        search.search_product1().click();
    }

    @Then("user could find relative results")
    public void relative_result()
    {
        int count = browser.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(count);
        Assert.assertTrue(count>0);
        ArrayList<String> products = null;
        products = new ArrayList<String>();
        for (int x = 0 ; x < count ; x++ ){
            System.out.println(browser.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(x).getText());
            products.add(browser.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(x).getText());
        }
        System.out.println(products);


    }
    @And("user search with sku code of product")
    public void search_product_skucode()
    {
        search.search_product().sendKeys("AP_MBP_13");
        search.search_product1().click();
    }
    @And("user go to result details page")
    public void moveToDetailsPage (){
        search.Search_product_details().click();
    }
    @Then("user check result sku code to confirm")
    public void Sku_code_confirm(){
        String ExpectedResult = "AP_MBP_13";
        String ActualResult = browser.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div/form/div[2]/div[1]/div[2]/div[6]/div/span[2]")).getText();
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
}
