package uk.co.lewisjefferies.nanoqr.services

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.stereotype.Service
import uk.co.lewisjefferies.nanoqr.objects.QRProperties
import java.awt.image.BufferedImage

@Service
class QRService(private val validationService: ValidationService) {

    private val qrCodeWriter = QRCodeWriter();

    fun createQR(qrProperties: QRProperties): BufferedImage {
        validationService.validateInput(qrProperties)
        val qrBody = constructQRBody(qrProperties);
        return generateQR(qrBody);
    }

    private fun generateQR(data: String): BufferedImage {
        val bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    private fun constructQRBody(qrProperties: QRProperties): String {
        return qrProperties.toUrlString();
    }

}