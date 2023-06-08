package untitled.template

import java.time.format.DateTimeFormatter

object Constants {
    val LOCAL_DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    val LOCAL_DATE_TIME_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")

    object Env {
        const val LOCAL = "local"
        const val PROD = "prod"
    }
}