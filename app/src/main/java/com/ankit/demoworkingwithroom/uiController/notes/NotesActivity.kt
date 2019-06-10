package com.ankit.demoworkingwithroom.uiController.notes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.EditText
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.R
import com.ankit.demoworkingwithroom.uiController.BaseAppActivity
import kotlinx.android.synthetic.main.activity_notes.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import com.ankit.demoworkingwithroom.databinding.ActivityNotesBinding
import com.ankit.demoworkingwithroom.uiController.addNewNote.AddNewNotesActivity


class NotesActivity: BaseAppActivity(){

    lateinit var viewModel: NotesViewModel
    lateinit var adapter: NotesAdapter


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        val binding = binding(R.layout.activity_notes) as ActivityNotesBinding

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnFab.setOnClickListener {
//            val viewGroup = findViewById<ViewGroup>(android.R.id.content)
//            val dialog = AlertDialog.Builder(this)
//            val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_alert,
//                viewGroup, false)
//            dialog.setView(R.layout.custom_alert)
//            val okButton = dialogView.findViewById(R.id.btn_ok) as Button
//            val title = dialogView.findViewById(R.id.title) as EditText
//            val desc = dialogView.findViewById(R.id.desc) as EditText
//            val alertDialog = dialog.create()
//
//            alertDialog.show()
//            okButton.setOnClickListener {
//
//                val note = NotesModel(
//                    title = title.text.toString(),
//                    desc = desc.text.toString(),
//                    date = "10 june 2019"
//
//                )
//                viewModel.saveNote(note)
//                finish()
//            }I
            val intent = Intent(this, AddNewNotesActivity::class.java)
            startActivity(intent)
        }

        viewModel.viewNotes.observe(this, Observer {notesModel ->
            val notes = notesModel?.notesList

            adapter = NotesAdapter(
                this,
                notes!!
            )
            recyclerView.adapter = adapter
        })

    }



}