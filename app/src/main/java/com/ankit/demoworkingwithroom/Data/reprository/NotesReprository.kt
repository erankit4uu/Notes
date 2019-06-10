package com.ankit.demoworkingwithroom.Data.reprository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.ankit.demoworkingwithroom.Data.Notes
import com.ankit.demoworkingwithroom.Data.NotesModel
import com.ankit.demoworkingwithroom.Data.source.local.NotesDao
import java.util.concurrent.Executor

class NotesReprository constructor(private val notesDao: NotesDao,
                                   private val executor: Executor) {


    val data = MutableLiveData<Notes>()
    lateinit var notes : List<NotesModel>

    fun getSavedNotes() : LiveData<Notes>{
        executor.execute{
            val notesList = notesDao.getAllNotes()

            if(!notesList.isNullOrEmpty()){
                val notes = Notes(notes)
                data.postValue(notes)
            }
        }
        return data
    }

    fun saveSingleNote(notes: NotesModel): LiveData<Notes>{
        executor.execute {
            notesDao.saveNote(notes)
        }
        return data
    }


}