package com.srn.dkbcodechallenge.app.presentation.screen.list

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srn.dkbcodechallenge.data.ServerResponse.ResponseStatus.*
import com.srn.dkbcodechallenge.domain.usecase.PhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by SoheilR .
 */

@HiltViewModel
class ListViewModel @Inject constructor(
    private val photoUseCase: PhotoUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(PhotoListState())
    val state: State<PhotoListState> = _state

    fun getData() {
        viewModelScope.launch {
            photoUseCase.resultFlow
                .onEach { response ->
                    when (response.status) {
                        SUCCESS -> {
                            if (response.data != null) {
                                _state.value = state.value.copy(
                                    items = response.data,
                                    isLoading = false)
                            }
                        }
                        LOADING -> {
                            Log.e("SSS", "... response loading ")
                        }
                        ERROR -> {
                            Log.e("SSS", "... response Error ")
                        }
                        FAIL -> {
                            Log.e("SSS", "... response fail ")
                        }
                        //TODO we should handle this Loading, Fail, Error in the UI
                    }
                }.launchIn(this)
        }
    }
}