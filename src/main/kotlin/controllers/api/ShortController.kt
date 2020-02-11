package com.egorsmkv.short_urls_service.controllers.api

import com.egorsmkv.short_urls_service.entities.Links
import com.egorsmkv.short_urls_service.utils.Hashids
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.insertAndGenerateKey
import org.apache.commons.validator.routines.UrlValidator
import java.time.ZonedDateTime

class ShortController : Controller() {
    private val hashids = Hashids("service")
    private val urlValidator: UrlValidator = UrlValidator()

    fun store(call: HttpCall) {
        // Get the link from the request
        val url = call.paramAsString("url").orAbort()

        // Validate the url
        if (!urlValidator.isValid(url)) {
            call.replyAsJson(mapOf("ok" to false, "message" to "Your link is not valid"))
            return
        }

        // Create a row
        val now = ZonedDateTime.now().toInstant()
        val id = Links.insertAndGenerateKey {
            it.url to url
            it.createdAt to now
            it.updatedAt to now
        }.toString().toLong()

        val hash = hashids.encode(id)
        val generatedURL = call.env("APP_URL") + "/" + hash

        call.replyAsJson(mapOf("ok" to true, "hash" to hash, "url" to generatedURL))
    }
}
