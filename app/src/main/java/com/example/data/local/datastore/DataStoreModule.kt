package com.example.data.local.datastore

import android.content.Context
import com.example.data.local.datastore.UserProfileDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideUserProfileDataStore(
        @ApplicationContext context: Context
    ): UserProfileDataStore {
        return UserProfileDataStore(context)
    }
}