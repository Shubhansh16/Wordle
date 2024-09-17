package com.example.wordleny

import android.app.Application
import com.example.wordleny.database.StatisticsDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class WordleApplication :Application() {

    val database by lazy { StatisticsDatabase.getDatabase(this) }
}