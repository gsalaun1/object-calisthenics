package bank.domain

import java.lang.StringBuilder

class CellText(private val text: String) {

    fun formattedValue(): String {
        val formattedValue = StringBuilder()
        formattedValue.append(" ")
        formattedValue.append(text)
        (text.length+1..9).forEach { _ -> formattedValue.append(" ") }
        return formattedValue.toString()
    }

}
