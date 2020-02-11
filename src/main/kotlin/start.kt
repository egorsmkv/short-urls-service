package com.egorsmkv.short_urls_service

import dev.alpas.Alpas

fun main(args: Array<String>) = Alpas(args).routes { addRoutes() }.ignite()
