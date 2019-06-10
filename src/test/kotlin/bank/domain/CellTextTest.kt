package bank.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

/**
 * <p>CellTextTest</p>
 */
class CellTextTest {

    @Test
    fun should_format_empty_text() {
        val cellText = CellText("")
        assertThat(cellText.formattedValue()).isEqualTo("          ")
    }

    @Test
    fun should_format_non_empty_text() {
        val cellText = CellText("test")
        assertThat(cellText.formattedValue()).isEqualTo(" test     ")
    }

}
