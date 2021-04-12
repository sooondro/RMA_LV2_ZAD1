package hr.ferit.sandroblavicki.rma_lv2_zad1

data class InspiringPerson(
    val id: Int = 0,
    val name: String,
    val dateOfBirth: String,
    val quotes: List<String>,
    val description: String,
    val imageUrl: String
) {
}