package bank.domain

import assertk.assertThat
import assertk.assertions.isLessThan
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * <p>TransactionTest</p>
 */
class TransactionTest {

    @Test
    fun should_sort_transaction_by_date () {
        val transaction1 = Transaction(Amount(1000), LocalDate.now())
        val transaction2 = Transaction(Amount(2000), LocalDate.now().plusDays(7))
        assertThat(transaction1).isLessThan(transaction2)
    }
}
