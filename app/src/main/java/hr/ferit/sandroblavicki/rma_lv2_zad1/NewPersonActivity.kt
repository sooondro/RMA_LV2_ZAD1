package hr.ferit.sandroblavicki.rma_lv2_zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import hr.ferit.sandroblavicki.rma_lv2_zad1.databinding.ActivityNewPersonBinding

class NewPersonActivity : AppCompatActivity() {

    private lateinit var newPersonBinding: ActivityNewPersonBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newPersonBinding = ActivityNewPersonBinding.inflate(layoutInflater)
        newPersonBinding.btnNewPersonSave.setOnClickListener { savePerson() }
        setContentView(newPersonBinding.root)
    }

    private fun savePerson() {
        val name = newPersonBinding.etNewPersonNameInput.text.toString()
        val description = newPersonBinding.etNewPersonDescriptionInput.text.toString()
        val dateOfBirth = newPersonBinding.etNewPersonDateOfBirthInput.text.toString()
        val quotes = newPersonBinding.etNewPersonQuotesInput.text?.split('.')
        val imageUrl = newPersonBinding.etNewPersonImageUrlInput.text.toString()

        val id = PeopleRepository.generateId()
        val newPerson = quotes?.let { InspiringPerson(id, name, dateOfBirth, it, description, imageUrl) }
        newPerson?.let { PeopleRepository.add(it) }
        Log.d("SANDRO", newPerson.toString())

        finish()
    }
}