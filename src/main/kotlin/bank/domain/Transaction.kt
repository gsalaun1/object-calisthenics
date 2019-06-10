package bank.domain

import java.time.LocalDate

/**
 * <p>Transaction</p>
 */
data class Transaction(private val amount: Amount, private val date: LocalDate) : Comparable<Transaction> {
    override fun compareTo(other: Transaction) = this.date.compareTo(other.date)
}
