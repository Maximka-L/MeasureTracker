package com.example.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.datastore.UserProfileDataStore
import com.example.domain.model.UserProfile
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val dataStore: UserProfileDataStore
) : ViewModel() {

    val profile = dataStore.userProfileFlow
        .stateIn(viewModelScope, SharingStarted.Eagerly, UserProfile())

    fun saveProfile(profile: UserProfile) {
        viewModelScope.launch {
            dataStore.updateProfile(profile)
        }
    }
}