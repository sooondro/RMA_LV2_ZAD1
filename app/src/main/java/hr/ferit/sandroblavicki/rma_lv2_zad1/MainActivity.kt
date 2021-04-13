package hr.ferit.sandroblavicki.rma_lv2_zad1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.rma_lv2_zad1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var peopleDisplay: RecyclerView
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddPerson.setOnClickListener { createNewPerson() }

        peopleDisplay = mainBinding.peopleDisplay
        setContentView(mainBinding.root)
        setUpUi()
    }

    private fun createNewPerson() {
        val newPersonIntent = Intent(this, NewPersonActivity::class.java)
        startActivity(newPersonIntent)
    }

    private fun setUpUi() {
        peopleDisplay.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        peopleDisplay.itemAnimator = DefaultItemAnimator()
        peopleDisplay.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        displayData()
    }

    private fun displayData() {
        val personListener = object: InspiringPersonInteractionListener{
            override fun onRemove(id: Int) {
                PeopleRepository.remove(id)
                (peopleDisplay.adapter as PersonAdapter).refreshData(PeopleRepository.people)
            }

            override fun onShowDetails(id: Int) {
                val person = PeopleRepository.get(id)
                Toast.makeText(applicationContext, person?.description.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onShowRandomQuote(id: Int) {
                val person = PeopleRepository.get(id)
                Toast.makeText(applicationContext, person?.quotes?.random().toString(), Toast.LENGTH_SHORT).show()
            }
        }
        peopleDisplay.adapter = PersonAdapter(PeopleRepository.people, personListener)
    }
}