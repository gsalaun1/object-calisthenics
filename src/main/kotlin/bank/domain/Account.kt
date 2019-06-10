package bank.domain

import java.time.LocalDate

/**
 * <p>Account</p>
 */

class Account(private val transactionRegistry: TransactionRegistry) {
    fun deposit(amount: Amount, date: LocalDate) {
        transactionRegistry.recordTransaction(Transaction(amount, date))
    }

    fun withdraw(amount: Amount, date: LocalDate) {
        transactionRegistry.recordTransaction(Transaction(amount.reverse(), date))
    }
}
