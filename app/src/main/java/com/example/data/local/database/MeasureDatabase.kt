package com.example.data.local.database


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

@Database(
    entities = [MeasurementEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MeasureDatabase : RoomDatabase() {

    abstract fun measurementDao(): MeasurementDao

    companion object {
        private const val DATABASE_NAME = "measure_database"

        @Volatile
        private var INSTANCE: MeasureDatabase? = null

        fun getInstance(context: Context): MeasureDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MeasureDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}