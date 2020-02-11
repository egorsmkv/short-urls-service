package com.egorsmkv.short_urls_service.database.migrations

import com.egorsmkv.short_urls_service.entities.Links
import dev.alpas.ozone.migration.Migration

class CreateLinksTable : Migration() {
    override fun up() {
        createTable(Links)
    }
    
    override fun down() {
        dropTable(Links)
    }
}