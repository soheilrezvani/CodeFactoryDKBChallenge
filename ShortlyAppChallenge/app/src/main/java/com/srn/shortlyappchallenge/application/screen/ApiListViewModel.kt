package com.srn.shortlyappchallenge.application.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srn.shortlyappchallenge.application.util.event.SingleLiveEvent
import com.srn.shortlyappchallenge.data.ServerResponse.ResponseStatus.*
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.usecase.ShortenApiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by SoheilR .
 */
@HiltViewModel
class ApiListViewModel @Inject constructor(
    private val shortenApiUseCase: ShortenApiUseCase,
) : ViewModel() {

    val resultListLiveData: MutableLiveData<List<Api>> = MutableLiveData()
    private val resultList: MutableList<Api> = emptyList<Api>().toMutableList()

    private val _shortenedUrl: MutableLiveData<Api> = MutableLiveData()
    val shortenedUrl: LiveData<Api> = _shortenedUrl

    private val loadingSingleEvent = SingleLiveEvent<Boolean>()
    private val errorSingleEvent = SingleLiveEvent<String>()

    fun getLoadingToastEvent(): SingleLiveEvent<Boolean> {
        return loadingSingleEvent
    }

    fun getErrorToastEvent(): SingleLiveEvent<String> {
        return errorSingleEvent
    }

    fun getShortenApi(url: String) {
        viewModelScope.launch {
            shortenApiUseCase.invoke(url).collect { serverResponse ->
                when (serverResponse.status) {

                    LOADING -> loadingSingleEvent.value = true
                    SUCCESS -> {
                        _shortenedUrl.value = serverResponse.result
                        serverResponse.result?.let { resultList.add(it) }
                        resultListLiveData.value = resultList
                    }
                    FAIL -> errorSingleEvent.value = serverResponse.error
                    ERROR -> errorSingleEvent.value = serverResponse.error
                }
            }
        }
    }
}