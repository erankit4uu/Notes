package com.ankit.demoworkingwithroom.uiController.notes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.ankit.demoworkingwithroom.uiController.BaseAppActivity
import kotlinx.android.synthetic.main.activity_notes.*
import android.view.LayoutInflater
import android.view.ViewGroup
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import com.ankit.demoworkingwithroom.databinding.ActivityNotesBinding
import com.ankit.demoworkingwithroom.uiController.addNewNote.AddNewNotesActivity
import android.support.v7.widget.helper.ItemTouchHelper
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.support.annotation.NonNull
import android.view.View
import com.ankit.demoworkingwithroom.R
import com.ankit.demoworkingwithroom.util.SwipeToDelete


class NotesActivity: BaseAppActivity() {

    lateinit var viewModel: NotesViewModel
    lateinit var adapter: NotesAdapter


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        val binding = binding(R.layout.activity_notes) as ActivityNotesBinding

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnFab.setOnClickListener {
            val intent = Intent(this, AddNewNotesActivity::class.java)
            intent.putExtra("isEdit", false)
            startActivity(intent)
        }

        viewModel.viewNotes.observe(this, Observer { notesModel ->
            val notes = notesModel?.notesList

            adapter = NotesAdapter(
                this,
                notes!!
            )
            recyclerView.adapter = adapter
            swipeToDelete()
        })

    }

    private fun swipeToDelete() {
        val swipeToDeleteCallback = object : SwipeToDelete(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {


                val position = viewHolder.adapterPosition
                adapter.removeItem(position)


//                val snackbar = Snackbar
//                    .make(coordinatorLayout, "Item was removed from the list.", Snackbar.LENGTH_LONG)
//                snackbar.setAction("UNDO", object : View.OnClickListener() {
//                    fun onClick(view: View) {
//
//                        mAdapter.restoreItem(item, position)
//                        recyclerView.scrollToPosition(position)
//                    }
//                })
//
//                snackbar.setActionTextColor(Color.YELLOW)
//                snackbar.show()

            }
        }

        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(recyclerView)

    }



}