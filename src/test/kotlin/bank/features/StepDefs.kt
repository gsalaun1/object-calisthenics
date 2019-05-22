package bank.features

import cucumber.api.PendingException
import cucumber.api.java8.En

/**
 *
 * StepDefs
 */
class StepDefs : En {
    init {
        Given("^a client makes a deposit of (\\d+) on (\\d+)-(\\d+)-(\\d+)$"
        ) { arg0: Int, arg1: Int, arg2: Int, arg3: Int -> throw PendingException() }
        And("^a deposit of (\\d+) on (\\d+)-(\\d+)-(\\d+)$"
        ) { arg0: Int, arg1: Int, arg2: Int, arg3: Int -> throw PendingException()}
        And("^a withdrawal of (\\d+) on (\\d+)-(\\d+)-(\\d+)$"
        ) { arg0: Int, arg1: Int, arg2: Int, arg3: Int -> throw PendingException()}
        When("^she prints her bank statement$") { throw PendingException()}
        Then("^she would see$") {arg0 : String -> throw PendingException()}
    }
}
