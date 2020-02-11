package com.egorsmkv.short_urls_service.controllers

import com.egorsmkv.short_urls_service.entities.Links
import dev.alpas.http.HttpCall
import dev.alpas.routing.Controller
import me.liuwj.ktorm.dsl.count

class IndexController : Controller() {
    fun index(call: HttpCall) {
        val links = Links.latestLinks()
        val total = Links.count()

        call.render("index", mapOf("links" to links, "total" to total))
    }

    fun help(call: HttpCall) {
        call.render("help")
    }
}
