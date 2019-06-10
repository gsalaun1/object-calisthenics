package bank.domain

import java.io.PrintStream

/**
 * <p>TransactionRegistry</p>
 */
data class TransactionRegistry(private val transactions: MutableSet<Transaction> = sortedSetOf()) {

    companion object {
        const val header = "date       || credit   || debit    || balance"
    }

    fun recordTransaction(transaction: Transaction) = transactions.add(transaction)

    fun size() = transactions.size

    fun contains(transaction: Transaction) = transactions.contains(transaction)

    fun printStatement(output: PrintStream) {
        output.println(header)
        transactions.reversed().forEach { transaction -> transaction.print(output, findPreviousBalance(transaction)) }
    }

    private fun findPreviousBalance(transaction: Transaction): Amount {
        var balance = Amount(0)
        transactions.filter { it < transaction }
                .forEach { balance = it.balanceAfterTransaction(balance) }
        return balance
    }

}
