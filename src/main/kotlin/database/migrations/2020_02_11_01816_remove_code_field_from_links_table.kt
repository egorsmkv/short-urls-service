package com.egorsmkv.short_urls_service.database.migrations

import dev.alpas.ozone.migration.Migration

class RemoveCodeFieldFromLinksTable : Migration() {
    override fun up() {
        val createQuery = """
            ALTER TABLE links DROP COLUMN code;
        """.trimIndent()

        execute(createQuery)
    }

    override fun down() {
    }
}