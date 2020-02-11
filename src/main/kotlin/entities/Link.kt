package com.egorsmkv.short_urls_service.entities

import dev.alpas.ozone.MigratingTable
import dev.alpas.ozone.bigIncrements
import khronos.toString
import me.liuwj.ktorm.dsl.*
import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.schema.text
import me.liuwj.ktorm.schema.timestamp
import java.time.Instant
import java.util.*

interface Link : Entity<Link> {
    companion object : Entity.Factory<Link>()

    var id: Long
    var url: String
    var code: String
    var createdAt: Instant?
    var updatedAt: Instant?

    fun formattedCreatedAt(): String = Date.from(createdAt).toString("yyyy-MM-dd HH:mm")
}

object Links : MigratingTable<Link>("links") {
    val id by bigIncrements("id").bindTo { it.id }
    val url by text("url").bindTo { it.url }.size(300)
    val createdAt by timestamp("created_at").bindTo { it.createdAt }.useCurrent()
    val updatedAt by timestamp("updated_at").bindTo { it.updatedAt }.useCurrent()

    fun latestLinks(): List<Link> {
        return select()
            .orderBy(createdAt.desc())
            .limit(0, 10)
            .map { row -> createEntity(row) }
    }
}
