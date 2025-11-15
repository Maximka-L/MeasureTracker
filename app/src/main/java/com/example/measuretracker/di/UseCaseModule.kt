package com.example.measuretracker.di

import com.example.domain.repository.MeasurementRepository
import com.example.measuretracker.domain.use_case.AddMeasurementUseCase
import com.example.measuretracker.domain.use_case.DeleteMeasurementUseCase
import com.example.measuretracker.domain.use_case.GetMeasurementByIdUseCase
import com.example.measuretracker.domain.use_case.GetMeasurementsUseCase
import com.example.measuretracker.domain.use_case.UpdateMeasurementUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetMeasurementsUseCase(
        repo: MeasurementRepository
    ): GetMeasurementsUseCase = GetMeasurementsUseCase(repo)

    @Provides
    fun provideAddMeasurementUseCase(
        repo: MeasurementRepository
    ): AddMeasurementUseCase = AddMeasurementUseCase(repo)

    @Provides
    fun provideGetMeasurementByIdUseCase(
        repo: MeasurementRepository
    ): GetMeasurementByIdUseCase = GetMeasurementByIdUseCase(repo)

    @Provides
    fun provideDeleteMeasurementUseCase(
        repo: MeasurementRepository
    ): DeleteMeasurementUseCase = DeleteMeasurementUseCase(repo)

    @Provides
    fun provideUpdateMeasurementUseCase(
        repo: MeasurementRepository
    ): UpdateMeasurementUseCase = UpdateMeasurementUseCase(repo)
}