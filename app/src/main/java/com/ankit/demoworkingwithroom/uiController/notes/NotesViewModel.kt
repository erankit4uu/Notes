package com.ankit.demoworkingwithroom.uiController.notes

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.ankit.demoworkingwithroom.App
import com.ankit.demoworkingwithroom.Data.Notes
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.Data.reprository.NotesReprository

class NotesViewModel internal constructor(): ViewModel(){

    val notesReprository : NotesReprository = App.REPOSITORY

    val viewNotes : LiveData<Notes> = notesReprository.getSavedNotes()

    fun saveNote(notes: NotesModel){
        notesReprository.saveSingleNote(notes)
    }
    fun deleteNote(position: Long){
        notesReprository.deleteSingleNote(position = position )
    }
}