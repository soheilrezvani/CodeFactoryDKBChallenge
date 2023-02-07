package com.srn.shortlyappchallenge.application.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srn.shortlyappchallenge.application.util.event.SingleLiveEvent
import com.srn.shortlyappchallenge.data.ServerResponse.ResponseStatus.*
import com.srn.shortlyappchallenge.domain.model.Api
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.usecase.DeleteApiUseCase
import com.srn.shortlyappchallenge.domain.usecase.GetApiListFromDBUseCase
import com.srn.shortlyappchallenge.domain.usecase.InsertApiInDBUseCase
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
    private val insertApiUseCase: InsertApiInDBUseCase,
    private val deleteApiUseCase: DeleteApiUseCase,
    private val apiListDBUseCase: GetApiListFromDBUseCase,
) : ViewModel() {

    private val _shortenedUrl: MutableLiveData<Api> = MutableLiveData()
    val shortenedUrl: LiveData<Api> = _shortenedUrl

    private val loadingSingleEvent = SingleLiveEvent<Boolean>()
    private val errorSingleEvent = SingleLiveEvent<String>()

    private val _deleteApiEvent = MutableLiveData<SingleLiveEvent<Unit>>()
    val deleteApiEvent: LiveData<SingleLiveEvent<Unit>> = _deleteApiEvent

    private val _savedApiList =  MutableLiveData<List<ApiResult>>()
    val savedApiList: LiveData<List<ApiResult>> = _savedApiList

    private val _copyClipBoardLiveEvent = MutableLiveData<String>()
    val copyClipBoardLiveEvent: LiveData<String> = _copyClipBoardLiveEvent

    private val _saveApiEvent = MutableLiveData<SingleLiveEvent<Unit>>()
    val saveApiEvent: LiveData<SingleLiveEvent<Unit>> = _saveApiEvent

    fun getLoadingToastEvent(): SingleLiveEvent<Boolean> {
        return loadingSingleEvent
    }

    fun getErrorToastEvent(): SingleLiveEvent<String> {
        return errorSingleEvent
    }

    fun getApiListFromDB() {
        viewModelScope.launch {
            apiListDBUseCase.invoke().collect {
                _savedApiList.value = it
            }
        }
    }

    fun getShortenApi(url: String) {
        viewModelScope.launch {
            shortenApiUseCase.invoke(url).collect { serverResponse ->
                when (serverResponse.status) {

                    LOADING -> loadingSingleEvent.value = true
                    SUCCESS -> {
                        _shortenedUrl.value = serverResponse.data
                        serverResponse.data?.let { saveShortenedApiInDB(it.result) }
                        getApiListFromDB()
                    }
                    FAIL -> errorSingleEvent.value = serverResponse.error
                    ERROR -> errorSingleEvent.value = serverResponse.error
                }
            }
        }
    }

    fun delete(apiCode: String) {
        deleteApi(apiCode)
    }

    private fun deleteApi(apiCode: String) {
        viewModelScope.launch {
            deleteApiUseCase.invoke(apiCode)
            _deleteApiEvent.value = SingleLiveEvent()
        }
        getApiListFromDB()
    }

    fun saveShortenedApiInDB(item: ApiResult) {
        viewModelScope.launch {
            insertApiUseCase.invoke(item)
            _saveApiEvent.value = SingleLiveEvent()
        }
    }

    fun isCopiedIntoClipboard(url: String) : Boolean {
        return url == _copyClipBoardLiveEvent.value
    }

    fun copyIntoClipBoard(url: String) {
        _copyClipBoardLiveEvent.value = url
    }
}