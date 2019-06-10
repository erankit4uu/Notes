package com.ankit.demoworkingwithroom

import android.app.Application
import com.ankit.demoworkingwithroom.Data.reprository.NotesReprository
import com.ankit.demoworkingwithroom.Data.source.local.NotesDatabase
import java.util.concurrent.Executors

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        NotesDatabase.getInstance(this)
        REPOSITORY= NotesReprository(
            notesDao = NotesDatabase.getInstance(this).notesDao(),
            executor = Executors.newSingleThreadExecutor())
    }
    companion object{
        lateinit var REPOSITORY:NotesReprository

    }
}