package fr.flaforge.photographart.domain.model

data class Art(
        val art: String,
        val title: String,
        val description: String
) {
    fun validate(): Boolean {
        //  (business rule)
        return title.length < 10
    }
}