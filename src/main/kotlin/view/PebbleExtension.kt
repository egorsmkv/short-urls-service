package com.egorsmkv.short_urls_service.view

import com.mitchellbosecke.pebble.extension.Filter
import dev.alpas.Application
import dev.alpas.view.ConditionalTags
import dev.alpas.view.extensions.PebbleExtension

class PebbleExtension : PebbleExtension {
    override fun register(app: Application, conditionalTags: ConditionalTags) {
        conditionalTags.add("isProduction") { call.env.isProduction }
    }

    override fun filters(app: Application): Map<String, Filter> {
        return mapOf("toShort" to ToShortFilter())
    }
}
