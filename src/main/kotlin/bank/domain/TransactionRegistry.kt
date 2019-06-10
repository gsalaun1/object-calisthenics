package bank.domain

/**
 * <p>TransactionRegistry</p>
 */
data class TransactionRegistry(private val transactions: MutableSet<Transaction> = sortedSetOf()) {

    fun recordTransaction(transaction: Transaction) = transactions.add(transaction)

    fun size() = transactions.size

    fun contains(transaction: Transaction) = transactions.contains(transaction)

}
