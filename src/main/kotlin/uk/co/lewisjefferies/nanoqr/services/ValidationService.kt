package uk.co.lewisjefferies.nanoqr.services

import org.springframework.stereotype.Service
import uk.co.lewisjefferies.nanoqr.exceptions.BadInputException
import uk.co.lewisjefferies.nanoqr.objects.QRProperties

@Service
class ValidationService {

    fun validateInput(qrProperties: QRProperties) {
        if(qrProperties.address.isEmpty()) throw BadInputException("Missing Address")
    }

}