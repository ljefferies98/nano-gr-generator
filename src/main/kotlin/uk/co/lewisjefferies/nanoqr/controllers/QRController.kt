package uk.co.lewisjefferies.nanoqr.controllers

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import uk.co.lewisjefferies.nanoqr.objects.QRProperties
import uk.co.lewisjefferies.nanoqr.services.QRService
import java.awt.image.BufferedImage

@RestController
class QRController(
        private val qrService: QRService
) {

    @PostMapping(path = ["/"], produces = [MediaType.IMAGE_PNG_VALUE])
    fun getQR(@RequestBody qrProperties: QRProperties): ResponseEntity<BufferedImage> {
        return ResponseEntity.ok(qrService.createQR(qrProperties))
    }

}