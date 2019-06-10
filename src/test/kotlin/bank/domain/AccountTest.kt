package bank.domain

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * <p>AccountTest</p>
 */
class AccountTest {

    @RelaxedMockK
    lateinit var transactionRegistry: TransactionRegistry

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun should_deposit_amount() {
        val account = Account(transactionRegistry)
        val now = LocalDate.now()
        account.deposit(Amount(1000), now)
        verify { transactionRegistry.recordDeposit(Transaction(Amount(1000),now)) }
    }
}
