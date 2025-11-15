package com.example.measuretracker.di

import MeasurementRepositoryImpl
import com.example.data.local.database.MeasurementDao
import com.example.domain.repository.MeasurementRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMeasurementRepository(
        dao: MeasurementDao
    ): MeasurementRepository {
        return MeasurementRepositoryImpl(dao)
    }
}