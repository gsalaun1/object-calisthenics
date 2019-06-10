package bank.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.time.LocalDate

/**
 * <p>AccountTest</p>
 */
class AccountTest {

    @RelaxedMockK
    lateinit var transactionRegistry: TransactionRegistry

    lateinit var account: Account

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
        account = Account(transactionRegistry)
    }

    @Test
    fun should_deposit_amount() {
        val now = LocalDate.now()
        account.deposit(Amount(1000), now)
        verify { transactionRegistry.recordTransaction(Transaction(Amount(1000), now)) }
    }

    @Test
    fun should_withdraw_amount() {
        val now = LocalDate.now()
        account.withdraw(Amount(1000), now)
        verify { transactionRegistry.recordTransaction(Transaction(Amount(-1000), now)) }
    }

    @Test
    fun should_print_statement() {
        val output = System.out
        account.printStatement(output)
        verify { transactionRegistry.printStatement(output) }
    }
}
