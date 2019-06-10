package bank.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isLessThan
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.PrintStream
import java.time.LocalDate

/**
 * <p>TransactionTest</p>
 */
class TransactionTest {

    @RelaxedMockK
    lateinit var output: PrintStream

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun should_sort_transaction_by_date() {
        val transaction1 = Transaction(Amount(1000), LocalDate.now())
        val transaction2 = Transaction(Amount(2000), LocalDate.now().plusDays(7))
        assertThat(transaction1).isLessThan(transaction2)
    }

    @Test
    fun should_print_positive_transaction() {
        val date = LocalDate.of(2019, 6, 13)
        val transaction = Transaction(Amount(6789), date)
        transaction.print(output,Amount(0))
        verify { output.println("13/06/2019 || 6789.00  ||          || 6789.00") }
    }

    @Test
    fun should_print_negative_transaction() {
        val date = LocalDate.of(2019, 6, 13)
        val transaction = Transaction(Amount(-1234), date)
        transaction.print(output, Amount(0))
        verify { output.println("13/06/2019 ||          || 1234.00  || -1234.00") }
    }

    @Test
    fun should_return_balance_after_transaction(){
        val transaction = Transaction(Amount(500), LocalDate.now())
        assertThat(transaction.balanceAfterTransaction(Amount(700))).isEqualTo(Amount(1200))
    }

}
