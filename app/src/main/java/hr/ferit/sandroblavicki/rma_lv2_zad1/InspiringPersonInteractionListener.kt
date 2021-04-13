package hr.ferit.sandroblavicki.rma_lv2_zad1

interface InspiringPersonInteractionListener {
    fun onRemove(id: Int)
    fun onShowDetails(id: Int)
    fun onShowRandomQuote(id: Int)
}