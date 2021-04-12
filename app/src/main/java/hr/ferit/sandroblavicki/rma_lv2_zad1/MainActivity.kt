package hr.ferit.sandroblavicki.rma_lv2_zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var peopleDisplay: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        peopleDisplay = findViewById(R.id.peopleDisplay)
        setUpUi()
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
        }
        peopleDisplay.adapter = PersonAdapter(PeopleRepository.people, personListener)
    }
}