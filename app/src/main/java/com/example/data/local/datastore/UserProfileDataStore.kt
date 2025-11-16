package com.example.data.local.datastore

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.example.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


private val Context.userProfileDataStore by preferencesDataStore("user_profile")

@Singleton
class UserProfileDataStore @Inject constructor(
    private val context: Context
) {

    companion object {
        val NAME = stringPreferencesKey("name")
        val AGE = intPreferencesKey("age")
        val HEIGHT = intPreferencesKey("height")
        val TARGET_WEIGHT = floatPreferencesKey("target_weight")
        val GENDER = stringPreferencesKey("gender")
    }

    val userProfileFlow: Flow<UserProfile> =
        context.userProfileDataStore.data.map { prefs ->
            UserProfile(
                name = prefs[NAME] ?: "",
                age = prefs[AGE] ?: 0,
                height = prefs[HEIGHT] ?: 0,
                targetWeight = prefs[TARGET_WEIGHT] ?: 0f,
                gender = prefs[GENDER] ?: "male"
            )
        }

    suspend fun updateProfile(profile: UserProfile) {
        context.userProfileDataStore.edit { prefs ->
            prefs[NAME] = profile.name
            prefs[AGE] = profile.age
            prefs[HEIGHT] = profile.height
            prefs[TARGET_WEIGHT] = profile.targetWeight
            prefs[GENDER] = profile.gender
        }
    }
}