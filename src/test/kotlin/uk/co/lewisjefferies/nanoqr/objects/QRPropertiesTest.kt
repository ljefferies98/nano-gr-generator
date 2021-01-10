package uk.co.lewisjefferies.nanoqr.objects

import org.junit.jupiter.api.Test

class QRPropertiesTest {

    @Test
    fun allPropertiesProduceValidOutput() {
        // Given
        val qrProperties = allProperties()

        // When
        val data = qrProperties.toUrlString()

        //Then
        assert(data.equals("nano:nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw?amount=1000000000000000000000000000000&label=tests%20label"))
    }

    @Test
    fun addressAndAmountProduceValidOutput() {
        // Given
        val qrProperties = addressAndAmountProperties()

        // When
        val data = qrProperties.toUrlString()

        //Then
        assert(data.equals("nano:nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw?amount=1000000000000000000000000000000"))
    }

    @Test
    fun addressAndLabelProduceValidOutput() {
        // Given
        val qrProperties = addressAndLabelProperties()

        // When
        val data = qrProperties.toUrlString()

        //Then
        assert(data.equals("nano:nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw?label=tests%20label"))
    }

    @Test
    fun addressOnlyProduceValidOutput() {
        // Given
        val qrProperties = addressOnlyProperties()

        // When
        val data = qrProperties.toUrlString()

        //Then
        println(data)
        assert(data.equals("nano:nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw"))
    }

    private fun allProperties(): QRProperties {
        return QRProperties(
                "nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw",
                "1000000000000000000000000000000",
                "test label")
    }

    private fun addressAndAmountProperties(): QRProperties {
        return QRProperties(
                "nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw",
                "1000000000000000000000000000000")
    }

    private fun addressAndLabelProperties(): QRProperties {
        return QRProperties(
                "nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw",
                label = "test label")
    }

    private fun addressOnlyProperties(): QRProperties {
        return QRProperties(
                "nano_1mxg5p4k5esfig5fp8wnraqcn4b4q5jigwzusk8myqysqkq6upq9i8zzk5jw")
    }

}