package template.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun name(): String