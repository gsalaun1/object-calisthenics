package bank.domain

import java.io.PrintStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * <p>Transaction</p>
 */
data class Transaction(private val amount: Amount, private val date: LocalDate) : Comparable<Transaction> {

    override fun compareTo(other: Transaction) = this.date.compareTo(other.date)

    fun print(output: PrintStream, previousBalance: Amount) {
        val newBalance = previousBalance.add(amount)
        val line = StringBuilder()
                .append(formattedDateValue())
                .append(" ||")
                .append(formattedCreditValue())
                .append("||")
                .append(formattedDebitValue())
                .append("|| ")
                .append(newBalance.formattedValue())
        output.println(line.toString())
    }

    private fun formattedDateValue() = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date)

    private fun formattedDebitValue(): String {
        if (amount.isPositive()) {
            return CellText("").formattedValue()
        }
        val absoluteAmount = amount.absoluteValue()
        val amountFormattedValue = absoluteAmount.formattedValue()
        return CellText(amountFormattedValue).formattedValue()
    }

    private fun formattedCreditValue(): String {
        if (amount.isNegative()) {
            return CellText("").formattedValue()
        }
        val amountFormattedValue = amount.formattedValue()
        return CellText(amountFormattedValue).formattedValue()
    }

    fun balanceAfterTransaction(balance: Amount) = balance.add(amount)

}
