package com.example.motivationlist.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

class QuotesSteps {
    @Given("Bob is in the app")
    public void bobIsInTheApp() {
    }

    @When("Bob is in the <view>")
    public void bobIsInTheView() {
    }

    @Then("He should see <quotes> at the bottom of the screen")
    public void heShouldSeeQuotesAtTheBottomOfTheScreen() {
    }
}
