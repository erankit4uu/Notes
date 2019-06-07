package com.ankit.demoworkingwithroom.Data.source.local

import android.arch.persistence.room.*
import com.ankit.demoworkingwithroom.Data.NotesModel


interface NotesDao{

    @Query("Select * From NotesModel")
    fun getAllNotes() : List<NotesModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveNote(notesModel: NotesModel)

    @Query("Delete From NotesModel where _id")
    fun deleteNote(noteId: Long)
}