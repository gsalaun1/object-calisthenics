package bank.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

/**
 * <p>AmountTest</p>
 */
class AmountTest {

    @Test
    fun should_reverse_amount() {
        val amount = Amount(1234)
        assertThat(amount.reverse()).isEqualTo(Amount(-1234))
    }
}
