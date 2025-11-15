package com.example.measuretracker.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.database.AppDatabase
import com.example.data.local.database.MeasurementDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "measuretracker.db"
        ).build()

    @Singleton
    @Provides
    fun provideMeasurementDao(db: AppDatabase): MeasurementDao =
        db.measurementDao()
}