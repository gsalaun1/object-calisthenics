package bank.domain

/**
 * <p>Amount</p>
 */
data class Amount(private val amount: Int) {
    fun reverse() = Amount(-amount)
}
