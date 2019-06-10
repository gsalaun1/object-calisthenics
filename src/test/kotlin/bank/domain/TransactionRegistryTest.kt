package bank.domain

import assertk.all
import assertk.assertAll
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate

/**
 * <p>TransactionRegistryTest</p>
 */

class TransactionRegistryTest {

    @Test
    fun should_record_deposit() {
        val transaction = Transaction(Amount(500),LocalDate.now())
        val transactionRegistry = TransactionRegistry()
        transactionRegistry.recordDeposit(transaction)
        assertAll {
            assertThat(transactionRegistry.size()).isEqualTo(1)
            assertThat(transactionRegistry.contains(transaction)).isTrue()
        }


    }
}
