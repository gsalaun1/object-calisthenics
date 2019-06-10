package bank.domain

import java.io.PrintStream
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

    fun printStatement(output: PrintStream) {
        transactionRegistry.printStatement(output)
    }
}
