package untitled.template.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class BaseController {

    @Autowired
    lateinit var request: HttpServletRequest

    @Autowired
    lateinit var response: HttpServletResponse

    fun validate(bindingResult: BindingResult, block: BindingResult.() -> Unit) {
        if (bindingResult.hasErrors()) throw BindException(bindingResult)
        block(bindingResult)
        if (bindingResult.hasErrors()) throw BindException(bindingResult)
    }

    fun <T> validateResult(bindingResult: BindingResult, block: BindingResult.() -> T): T {
        if (bindingResult.hasErrors()) throw BindException(bindingResult)
        val t = block(bindingResult)
        if (bindingResult.hasErrors()) throw BindException(bindingResult)
        return t
    }
}