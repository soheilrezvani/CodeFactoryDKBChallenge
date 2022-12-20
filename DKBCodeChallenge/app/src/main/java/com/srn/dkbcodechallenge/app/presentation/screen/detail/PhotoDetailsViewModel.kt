package com.srn.dkbcodechallenge.app.presentation.screen.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srn.dkbcodechallenge.data.ServerResponse.ResponseStatus.*
import com.srn.dkbcodechallenge.domain.model.Photo
import com.srn.dkbcodechallenge.domain.usecase.GetPhotoByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by SoheilR .
 */
@HiltViewModel
class PhotoDetailsViewModel @Inject constructor(
    private val selectedPhotoUseCases: GetPhotoByIdUseCase,
) : ViewModel() {
    private val _selectedPhoto: MutableStateFlow<Photo?> = MutableStateFlow(null)
    val selectedPhoto: StateFlow<Photo?> = _selectedPhoto


    fun getPhotoDetails(photoId: Int) {
        viewModelScope.launch {
            selectedPhotoUseCases.invoke(photoId = photoId).collect {
                when (it.status) {
                    SUCCESS -> {
                        _selectedPhoto.value = it.data
                    }
                    LOADING -> {
                        Log.d("SSS", ".. LOADING ... ")
                    }
                    ERROR -> {
                        Log.e("SSS", ".. ERROR ... ")
                    }
                    FAIL -> {
                        Log.e("SSS", ".. FAIL ... ")
                    }
                }
                // TODO
            }
        }
    }
}