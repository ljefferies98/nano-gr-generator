package uk.co.lewisjefferies.nanoqr.objects

data class QRProperties(
        val address: String,
        val amount: String?,
        val label: String?
) {

    private fun getData() : Map<String, String?> {
        val data: MutableMap<String, String?> = mapOf("amount" to amount, "label" to label) as MutableMap<String, String?>
        data.values.removeIf { it.isNullOrEmpty() }
        return data;
    }

    fun toUrlString(): String {
        val builder = StringBuilder("nano:");
        builder.append(address)
        builder.append("?")

        val data = getData()
        var count = 0
        for (pair in data) {
            builder.append(pair.key)
            builder.append("=")
            builder.append(pair.value?.replace(" ", "s%20"))
            if((data.size - count) > 1) {
                builder.append("&")
                count++
            }
        }
        return builder.toString();
    }

}
