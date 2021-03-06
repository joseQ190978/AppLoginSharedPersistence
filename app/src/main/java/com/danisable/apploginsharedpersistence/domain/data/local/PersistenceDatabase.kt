package com.danisable.apploginsharedpersistence.domain.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danisable.apploginsharedpersistence.domain.data.local.dao.NoteDao
import com.danisable.apploginsharedpersistence.domain.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version=1, exportSchema = false)
abstract class PersistenceDatabase: RoomDatabase() {

    abstract fun notesDao(): NoteDao

    companion object{
        @Volatile
        private var instance: PersistenceDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,PersistenceDatabase::class.java,"MyDatabase").build()
    }
}