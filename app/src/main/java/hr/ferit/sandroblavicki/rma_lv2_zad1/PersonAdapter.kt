package hr.ferit.sandroblavicki.rma_lv2_zad1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter(people: MutableList<InspiringPerson>,
inspiringPersonListener: InspiringPersonInteractionListener): RecyclerView.Adapter<InspiringPersonHolder>() {
    private val people: MutableList<InspiringPerson>
    private val inspiringPersonListener: InspiringPersonInteractionListener
    init {
        this.people = mutableListOf()
        this.people.addAll(people)
        this.inspiringPersonListener = inspiringPersonListener
    }

    fun refreshData(people: MutableList<InspiringPerson>){
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspiringPersonHolder {
        val personView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        val personHolder = InspiringPersonHolder(personView)
        return personHolder
    }

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: InspiringPersonHolder, position: Int) {
        val person = people[position]
        holder.bind(person, inspiringPersonListener)
    }


}