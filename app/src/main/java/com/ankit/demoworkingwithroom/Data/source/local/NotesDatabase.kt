package com.ankit.demoworkingwithroom.Data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.ankit.demoworkingwithroom.Data.NotesModel

@Database(entities = [NotesModel::class], version = 1, exportSchema = false)
abstract class NotesDatabase:RoomDatabase() {

    abstract fun notesDao() : NotesDao
}