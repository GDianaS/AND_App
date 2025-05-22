package com.study.andancas

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform