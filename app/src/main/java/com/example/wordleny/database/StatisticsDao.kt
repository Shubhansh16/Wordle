package com.example.wordleny.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Dao
interface StatisticsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stat: StatisticEntity)

    @Query("SELECT * FROM Statisticentity WHERE uid IS 1")
    fun getStat() : StatisticEntity?

    @Update
    fun update(newStat:StatisticEntity)
}

@Database(entities = [StatisticEntity::class], version = 1)
abstract class StatisticsDatabase : RoomDatabase() {
    abstract fun statisticsDao() : StatisticsDao

    companion object {
        @Volatile
        private var INSTANCE:StatisticsDatabase?= null



        @InternalCoroutinesApi
        fun getDatabase(context: Context):StatisticsDatabase {
             return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StatisticsDatabase::class.java,
                    "statistics_database"
                ).build()
                 INSTANCE = instance
                 instance
             }
        }
    }
}