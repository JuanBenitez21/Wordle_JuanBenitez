package com.unisabana.wordle.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant
import androidx.room.TypeConverters


@Database(
    entities = [Score::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(Converters::class) // Le decimos a Room que use nuestro convertidor
abstract class WordleDatabase : RoomDatabase(){
    abstract fun ScoreDao(): ScoreDao
    //singleton
    companion object{
        @Volatile
        private var INSTANCE: WordleDatabase? =null

        fun getDatabase(context: Context): WordleDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordleDatabase::class.java,
                    "wordle-database"
                ).build()
                INSTANCE = instance
                instance
            }

        }


    }

}