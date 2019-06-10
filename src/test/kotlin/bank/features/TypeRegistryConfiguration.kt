package bank.features

import bank.domain.Amount
import cucumber.api.TypeRegistry
import cucumber.api.TypeRegistryConfigurer
import io.cucumber.cucumberexpressions.ParameterType
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * <p>TypeRegistryConfiguration</p>
 */
class TypeRegistryConfiguration : TypeRegistryConfigurer {

    override fun locale(): Locale {
        return Locale.ENGLISH
    }

    override fun configureTypeRegistry(typeRegistry: TypeRegistry) {
        typeRegistry.defineParameterType(ParameterType(
                "localdate",
                "[0-9]{2}-[0-9]{2}-[0-9]{4}",
                LocalDate::class.java
        ) { s:String ->
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            LocalDate.parse(s, formatter)
        })
        typeRegistry.defineParameterType(ParameterType(
                "amount",
                "[0-9]{3,4}",
                Amount::class.java
        ) { s:String ->
            Amount(s.toInt())
        })
    }
}
