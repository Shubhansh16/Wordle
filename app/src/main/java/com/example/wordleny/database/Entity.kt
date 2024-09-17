package com.example.wordleny.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StatisticEntity(
    @PrimaryKey(autoGenerate = false) var uid:Int = 1,
    @ColumnInfo(name = "played") var played :Int = 0,
    @ColumnInfo(name = "streak") var streak :Int = 0,
    @ColumnInfo(name = "max_streak") var maxStreak :Int = 0,
    @ColumnInfo(name = "one") var first : Int =0,
    @ColumnInfo(name = "two") var second : Int =0,
    @ColumnInfo(name = "three") var third : Int =0,
    @ColumnInfo(name = "four") var four : Int =0,
    @ColumnInfo(name = "five") var five : Int =0,
    @ColumnInfo(name = "six") var six : Int =0,
){
    fun won(stage: Int){
        played++
        streak++
        if (streak > maxStreak) maxStreak==streak
        when(stage){
           0 -> first++
           1 -> second++
           2 -> third++
           3 -> four++
           4 -> five++
           5 -> six++
        }
    }

    fun lost(){
        played++
        streak=0
    }
}

