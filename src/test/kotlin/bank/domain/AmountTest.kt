package bank.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
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

    @Test
    fun should_add_amount(){
        val amount = Amount(1000)
        assertThat(amount.add(Amount(500))).isEqualTo(Amount(1500))
    }

    @Test
    fun should_indicate_negative_value(){
        val amount = Amount(-1000)
        assertThat(amount.isNegative()).isTrue()
    }

    @Test
    fun should_indicate_positive_value(){
        val amount = Amount(500)
        assertThat(amount.isPositive()).isTrue()
    }

    @Test
    fun should_format_value(){
        val amount = Amount(3456)
        assertThat(amount.formattedValue()).isEqualTo("3456.00")
    }

    @Test
    fun should_return_absolute_value(){
        val amount = Amount(-1000)
        assertThat(amount.absoluteValue()).isEqualTo(Amount(1000))
    }
}
