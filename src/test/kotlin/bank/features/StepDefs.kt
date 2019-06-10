package bank.features

import bank.domain.Account
import bank.domain.Amount
import bank.domain.TransactionRegistry
import cucumber.api.PendingException
import cucumber.api.java8.En
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import java.io.PrintStream
import java.time.LocalDate

/**
 *
 * StepDefs
 */
class StepDefs : En {

    @RelaxedMockK
    lateinit var output:PrintStream

    lateinit var account: Account

    val transactionRegistry = TransactionRegistry()

    init {
        Before { _ ->
            run {
                MockKAnnotations.init(this)
                account = Account(transactionRegistry)
            }
        }
        Given("a client makes a deposit of {amount} on {localdate}"
        ) { amount: Amount, date: LocalDate ->
            run {
                account.deposit(amount, date)
            }
        }
        And("a deposit of {amount} on {localdate}"
        ) { amount: Amount, date: LocalDate ->
            run {
                account.deposit(amount, date)
            }
        }
        And("a withdrawal of {amount} on {localdate}"
        ) { amount: Amount, date: LocalDate -> run {
            account.withdraw(amount,date)
        } }
        When("she prints her bank statement") {
            account.printStatement(output)
        }
        Then("she would see") { statement: String -> run {
            val lines = statement.split("\n")
            lines.forEach { verify { output.println(it) } }
        } }
    }
}
