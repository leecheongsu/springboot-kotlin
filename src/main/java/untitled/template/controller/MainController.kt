package untitled.template.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class MainController {

    @GetMapping("/")
    fun main(request: HttpServletRequest): Map<Int, String> {
        return mapOf(1 to "home")
    }
}