package hr.ferit.sandroblavicki.rma_lv2_zad1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(people: MutableList<InspiringPerson>,
private val inspiringPersonListener: InspiringPersonInteractionListener): RecyclerView.Adapter<InspiringPersonHolder>() {

    private val people: MutableList<InspiringPerson> = mutableListOf()

    init {
        refreshData(people)
    }

    fun refreshData(people: MutableList<InspiringPerson>){
        this.people.clear()
        this.people.addAll(people)
        notifyItemInserted(itemCount-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspiringPersonHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return InspiringPersonHolder(personView)
    }

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: InspiringPersonHolder, position: Int) {
        val person = people[position]
        holder.bind(person, inspiringPersonListener)
    }
}