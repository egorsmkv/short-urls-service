package com.egorsmkv.short_urls_service

import com.egorsmkv.short_urls_service.controllers.RedirectController
import com.egorsmkv.short_urls_service.controllers.IndexController
import com.egorsmkv.short_urls_service.controllers.api.ShortController
import dev.alpas.routing.RouteGroup
import dev.alpas.routing.Router

fun Router.addRoutes() = apply {
    group {
        webRoutesGroup()
    }.middlewareGroup("web")

    apiRoutes()
}

private fun RouteGroup.webRoutesGroup() {
    get("/", IndexController::class).name("index")
    get("/help", IndexController::help).name("help")

    get("/<code>", RedirectController::go).name("redirect")
}

private fun Router.apiRoutes() {
    group("api") {
        group("v1") {
            post("/short", ShortController::store)
        }
    }
}
