package com.egorsmkv.short_urls_service.database.migrations

import dev.alpas.ozone.migration.Migration

class RemoveCodeFieldFromLinksTable : Migration() {
    override fun up() {
        val query = """
            ALTER TABLE links DROP COLUMN code;
        """.trimIndent()

        execute(query)
    }

    override fun down() {
    }
}