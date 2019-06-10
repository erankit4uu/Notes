package com.ankit.demoworkingwithroom.uiController.notes

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.R
import com.ankit.demoworkingwithroom.databinding.ItemNotesBinding

class NotesAdapter(
    private var mcontext: Context,
    var notesModelList: List<NotesModel>
) : RecyclerView.Adapter<NotesAdapter.ItemViewHolder>() {

    lateinit var binding : ItemNotesBinding

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_notes, parent, false)
        return ItemViewHolder(binding, mcontext)
    }

    override fun getItemCount(): Int = notesModelList.size


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItems(notesModelList[position])
    }


    inner class ItemViewHolder(val binding: ItemNotesBinding, val c: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(notesModel: NotesModel) {
            binding.title.text = notesModel.title
            binding.desc.text = notesModel.desc
            binding.date.text = notesModel.date
        }

    }
}