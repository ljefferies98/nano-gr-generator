package uk.co.lewisjefferies.nanoqr.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import uk.co.lewisjefferies.nanoqr.objects.ErrorResponse
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerAdvisor {

    @ExceptionHandler(BadInputException::class)
    fun badInputHandler(req: HttpServletRequest, ex: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(ex.message))
    }

}