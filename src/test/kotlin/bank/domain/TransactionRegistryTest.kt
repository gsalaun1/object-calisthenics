package bank.domain

import assertk.assertAll
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import io.mockk.verifyOrder
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.time.LocalDate

/**
 * <p>TransactionRegistryTest</p>
 */

class TransactionRegistryTest {

    @RelaxedMockK
    lateinit var output: PrintStream

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun should_record_transaction() {
        val transaction = Transaction(Amount(500), LocalDate.now())
        val transactionRegistry = TransactionRegistry()
        transactionRegistry.recordTransaction(transaction)
        assertAll {
            assertThat(transactionRegistry.size()).isEqualTo(1)
            assertThat(transactionRegistry.contains(transaction)).isTrue()
        }
    }

    @Test
    fun should_print_header_if_no_transactions() {
        val transaction = TransactionRegistry()
        transaction.printStatement(output)
        verify {
            output.println("date       || credit   || debit    || balance")
        }
    }

    @Test
    fun should_print_one_positive_transaction() {
        val transaction = TransactionRegistry()
        val date = LocalDate.of(2019, 6, 13)
        transaction.recordTransaction(Transaction(Amount(1000), date))
        transaction.printStatement(output)
        verifyOrder {
            output.println("date       || credit   || debit    || balance")
            output.println("13/06/2019 || 1000.00  ||          || 1000.00")
        }
    }

    @Test
    fun should_print_multiple_transactions() {
        val transactionRegistry = TransactionRegistry()
        val date = LocalDate.of(2019, 6, 13)
        transactionRegistry.recordTransaction(Transaction(Amount(1000), date))
        transactionRegistry.recordTransaction(Transaction(Amount(-300), date.plusDays(7)))
        transactionRegistry.printStatement(output)
        verifyOrder {
            output.println("date       || credit   || debit    || balance")
            output.println("20/06/2019 ||          || 300.00   || 700.00")
            output.println("13/06/2019 || 1000.00  ||          || 1000.00")
        }
    }
}
