package bank.domain

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.absoluteValue

/**
 * <p>Amount</p>
 */
data class Amount(private val value: Int) {

    fun reverse() = Amount(-value)

    fun add(amount: Amount) = Amount(this.value + amount.value)

    fun formattedValue(): String {
        val symbols = DecimalFormatSymbols(Locale.FRENCH)
        symbols.decimalSeparator = '.'
        val decimalFormat = DecimalFormat("###.00", symbols)
        return decimalFormat.format(value)
    }

    fun isNegative() = value < 0

    fun isPositive() = value > 0

    fun absoluteValue() = Amount(value.absoluteValue)

}
