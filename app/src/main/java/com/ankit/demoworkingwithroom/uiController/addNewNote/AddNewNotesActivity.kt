package com.ankit.demoworkingwithroom.uiController.addNewNote

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.R
import com.ankit.demoworkingwithroom.databinding.CustomAlertBinding
import com.ankit.demoworkingwithroom.uiController.BaseAppActivity
import com.ankit.demoworkingwithroom.uiController.notes.NotesViewModel

class AddNewNotesActivity:BaseAppActivity() {

    lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = binding(R.layout.custom_alert) as CustomAlertBinding
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        binding.btnOk.setOnClickListener {
            if (binding.title.text.isBlank()){
                showToast("Please enter title")
            }else {
                val note = NotesModel(
                    title = binding.title.text.toString(),
                    desc = binding.desc.text.toString(),
                    date = "10 june 2019"

                )
                viewModel.saveNote(note)
                finish()
            }
        }
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }
}