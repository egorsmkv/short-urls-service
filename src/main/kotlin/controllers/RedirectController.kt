package com.egorsmkv.short_urls_service.controllers

import com.egorsmkv.short_urls_service.entities.Links
import com.egorsmkv.short_urls_service.utils.Hashids
import dev.alpas.http.HttpCall
import dev.alpas.orAbort
import dev.alpas.routing.Controller
import me.liuwj.ktorm.entity.findById

class RedirectController : Controller() {
    private val hashids = Hashids("service")

    fun go(call: HttpCall) {
        // Get the "code" parameter
        val code = call.paramAsString("code").orAbort()
        val numbers = hashids.decode(code)

        // There are no integers
        if (numbers.count() == 0) {
            call.redirect(route("index"))
            return
        }

        // Get ID
        val id: Long = numbers.first()

        // Looking for a link that is associated with the code
        val link = Links.findById(id)
        if (link != null) {
            // Redirect to the link
            call.redirect(link.url)
            return
        }

        call.redirect(route("index"))
    }
}
