package com.ankit.demoworkingwithroom.uiController.addNewNote

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.R
import com.ankit.demoworkingwithroom.databinding.CustomAlertBinding
import com.ankit.demoworkingwithroom.uiController.BaseAppActivity
import com.ankit.demoworkingwithroom.uiController.notes.NotesViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddNewNotesActivity: BaseAppActivity() {

    lateinit var viewModel: NotesViewModel
    lateinit var date : String
    var id: Long = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = binding(R.layout.custom_alert) as CustomAlertBinding
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        getCurrentDateAndTime()

        val intent = intent
        val isEdit = intent.getBooleanExtra("isEdit",false)
        if (isEdit) {
            date = intent.getStringExtra("date")
            binding.title.setText(intent.getStringExtra("title"))
            binding.desc.setText(intent.getStringExtra("desc"))
            id = intent.getLongExtra("id",0L)
            binding.btnOk.text = "Edit"
        }

        binding.btnOk.setOnClickListener {
            if (binding.title.text.isBlank()){
                showToast("Please enter title")
            }else {
                if (isEdit){
                    val note = NotesModel(
                        _id = id,
                        title = binding.title.text.toString(),
                        desc = binding.desc.text.toString(),
                        date = date
                    )
                    viewModel.saveNote(note)
                }else {
                    val note = NotesModel(
                        title = binding.title.text.toString(),
                        desc = binding.desc.text.toString(),
                        date = date
                    )
                    viewModel.saveNote(note)
                }

                finish()
            }
        }
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun getCurrentDateAndTime(){
        val c = Calendar.getInstance()
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
        val sdf = SimpleDateFormat("dd-MMM-yyyy EEE HH:mm")
        date = (sdf.format(c.time))
    }

}