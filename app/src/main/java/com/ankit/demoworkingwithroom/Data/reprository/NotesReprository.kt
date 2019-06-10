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
    val dataModel = MutableLiveData<NotesModel>()
    lateinit var notes : List<NotesModel>

    fun getSavedNotes() : LiveData<Notes>{
        executor.execute{
             notes = notesDao.getAllNotes()

            if(!notes.isNullOrEmpty()){
                val noteList = Notes(notes)
                data.postValue(noteList)
            }
        }
        return data
    }

    fun saveSingleNote(notesModel: NotesModel): LiveData<Notes>{
        executor.execute {
            notesDao.saveNote(notesModel)
            notes = notesDao.getAllNotes()
            val newList = Notes(notes)
            data.postValue(newList)
        }
        return data
    } fun deleteSingleNote(position: Long): LiveData<Notes>{
        executor.execute {
            notesDao.deleteNote(position)
            notes = notesDao.getAllNotes()
            val newList = Notes(notes)
            data.postValue(newList)
        }
        return data
    }


}