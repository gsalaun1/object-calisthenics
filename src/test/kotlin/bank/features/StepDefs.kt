package bank.features

import cucumber.api.PendingException
import cucumber.api.java8.En
import java.time.LocalDate

/**
 *
 * StepDefs
 */
class StepDefs : En {
    init {
        Given("a client makes a deposit of {int} on {localdate}"
        ) { arg0: Int, arg1: LocalDate -> throw PendingException() }
        And("a deposit of {int} on {localdate}"
        ) { arg0: Int, arg1: LocalDate -> throw PendingException() }
        And("a withdrawal of {int} on {localdate}"
        ) { arg0: Int, arg1: LocalDate -> throw PendingException() }
        When("she prints her bank statement") { throw PendingException() }
        Then("she would see") { arg0: String -> throw PendingException() }
    }
}
