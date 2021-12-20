package com.sahar.marvel.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sahar.marvel.data.local.daos.MarvelCharactersDao
import com.sahar.marvel.data.local.daos.SearchDao
import com.sahar.marvel.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun marvelCharacterDao(): MarvelCharactersDao
    abstract val searchDao: SearchDao


    companion object{

        private const val DATABASE_NAME = "MarvelDatabase"
        private var instance: MarvelDatabase? = null

        fun init(context: Context): MarvelDatabase{
            return instance ?: synchronized(this){ buildDatabase(context).also{ database -> instance = database }}
        }
        fun getInstance() = instance!!

        private fun buildDatabase(context: Context) : MarvelDatabase {
            return Room.databaseBuilder(context, MarvelDatabase::class.java, DATABASE_NAME).build()
        }

    }
}