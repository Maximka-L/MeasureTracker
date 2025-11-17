package com.example.measuretracker.di

import com.example.data.local.database.MeasurementDao
import com.example.data.repository.impl.MeasurementRepositoryImpl
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