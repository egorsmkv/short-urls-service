package com.egorsmkv.short_urls_service.view

import com.egorsmkv.short_urls_service.utils.Hashids
import com.mitchellbosecke.pebble.extension.Filter
import com.mitchellbosecke.pebble.template.EvaluationContext
import com.mitchellbosecke.pebble.template.PebbleTemplate

class ToShortFilter : Filter {
    private val hashids = Hashids("service")

    override fun getArgumentNames(): List<String>? {
        return null
    }

    override fun apply(
        input: Any?,
        args: Map<String, Any>?,
        self: PebbleTemplate,
        context: EvaluationContext?,
        line: Int
    ): Any? {
        return when (input) {
            is Long -> hashids.encode(input)
            else -> {
                val name = self.name
                val message = "toShort needs a Long. Called from $name#$line."
                throw Exception(message)
            }
        }
    }
}
