package com.ankit.demoworkingwithroom.Data.source.local

import android.arch.persistence.room.*
import com.ankit.demoworkingwithroom.Data.Notes
import com.ankit.demoworkingwithroom.Data.NotesModel

@Dao
interface NotesDao{

    @Query("Select * From NotesModel")
    fun getAllNotes() : List<NotesModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(notesModel: NotesModel)

    @Query("Delete From NotesModel where _id Like :noteId")
    fun deleteNote(noteId: Long)

    @Delete
    fun deleteAllNotes(list : List<NotesModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun editNote(notesModel: NotesModel)
}