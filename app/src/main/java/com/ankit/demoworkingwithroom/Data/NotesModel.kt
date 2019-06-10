package com.ankit.demoworkingwithroom.Data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


data class Notes(
    var notesList : List<NotesModel>
)

@Entity
data class NotesModel(

    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var desc: String = "",

    @ColumnInfo(name = "time")
    var date: String = ""

)