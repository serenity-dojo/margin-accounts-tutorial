package starter.stepdefinitions;

import com.serenitydojo.serenitybank.domain.BuySell;
import com.serenitydojo.serenitybank.domain.MarginPosition;
import com.serenitydojo.serenitybank.domain.MarginTransaction;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MarginTradingStepDefinitions {
    @Given("{} has a margin account with ${int} in cash")
    public void has_a_margin_account_with_in_cash(String customerName, Integer initialCash) {
    }
    @Given("{word} is trading at a market price of ${float}")
    public void facebook_is_trading_at_a_market_price_of_$(String share, float price ) {
    }

    @DataTableType
    public MarginTransaction marginTransaction(Map<String, String> transactionDetails) {
        // | Security | Buy/Sell | Number of shares | Cash   | Margin Loan |
        return new MarginTransaction(
                transactionDetails.get("Security"),
                BuySell.valueOf(transactionDetails.get("Buy/Sell")),
                moneyValue(transactionDetails.get("Number of shares")),
                moneyValue(transactionDetails.get("Cash")),
                moneyValue(transactionDetails.get("Margin Loan"))
        );
    }

    @DataTableType
    public MarginPosition marginPosition(Map<String, String> marginPosition) {
        return new MarginPosition(
                marginPosition.get("Security"),
                BuySell.valueOf(marginPosition.get("Buy/Sell")),
                moneyValue(marginPosition.get("Number of shares")),
                moneyValue(marginPosition.get("Initial Price")),
                moneyValue(marginPosition.get("Cash")),
                moneyValue(marginPosition.get("Margin Loan")),
                moneyValue(marginPosition.get("Value")),
                percentageValue(marginPosition.get("Initial Margin"))
        );

    }

    private Double percentageValue(String value) {
        return (value == null) ? 0.0 : Double.parseDouble(value.replace("%","")) / 100;
    }

    private Double moneyValue(String value) {
        return (value == null) ? 0.0 : Double.parseDouble(value.replace("$",""));
    }

    @When("(s)he makes the following transaction(s):")
    public void heMakesTheFollowingTransaction(List<MarginTransaction> transactions) {

    }

    @Then("(s)he should have the following position(s):")
    public void heShouldHaveTheFollowingPosition(List<MarginPosition> positions) {

    }

    @When("(s)he attempts to make the following transaction(s):")
    public void heAttemptsToMakeTheFollowingTransaction(List<MarginTransaction> transactions) {
    }

    @Then("the transaction should be rejected")
    public void theTransactionShouldBeRejected() {
    }

    @Then("his/her initial equity on this position is:")
    public void hisInitialEquityOnThisPositionIs(List<Map<String,String>> initialEquity) {
    }

    @Given("{} has the following initial position(s):")
    public void hasTheFollowingInitialPosition(String customerName, List<MarginPosition> initialPositions) {
    }

    @When("the current market price of {word} is ${}")
    public void theCurrentMarketPrice(String share, float currentMarketPrice) {
    }

    @Then("the equity on his/her position is:")
    public void theEquityOnHisPositionIs(List<Map<String,String>> initialPositions) {
    }

    @When("the current market price of {word} drops to ${float}")
    public void theCurrentMarketPriceOf(String share, float currentMarketPrice) {
    }

    @And("he should get a margin call for ${float}")
    public void heShouldGetAMarginCallFor(float marginCallAmount) {
    }
}
