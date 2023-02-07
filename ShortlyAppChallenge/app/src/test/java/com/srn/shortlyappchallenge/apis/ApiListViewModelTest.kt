package com.srn.shortlyappchallenge.apis

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.srn.shortlyappchallenge.application.screen.ApiListViewModel
import com.srn.shortlyappchallenge.datasource.FakeTestRepository
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.usecase.DeleteApiUseCase
import com.srn.shortlyappchallenge.domain.usecase.GetApiListFromDBUseCase
import com.srn.shortlyappchallenge.domain.usecase.InsertApiInDBUseCase
import com.srn.shortlyappchallenge.domain.usecase.ShortenApiUseCase
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by SoheilR .
 */
@RunWith(AndroidJUnit4::class)
class ApiListViewModelTest {

    lateinit var viewModel: ApiListViewModel
    lateinit var repository: FakeTestRepository

    private val shortenedApi1 = ApiResult(0, "code1", "short1",
        "fullShort1", "short1.2", "fullShort1.2",
        "share1", "fullShare1", "original1")

    private val shortenedApi2 = ApiResult(0, "code2", "short2",
        "fullShort2", "short2.2", "fullShort2.2",
        "share2", "fullShare2", "original2")


    @get:Rule
    var instantTasksExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {

        repository = FakeTestRepository()
        repository.addApis(shortenedApi1, shortenedApi2)


        val shortenUseCase = ShortenApiUseCase(repository)
        val insertApiInDBUseCase = InsertApiInDBUseCase(repository)
        val deleteApiUseCase = DeleteApiUseCase(repository)
        val getApiListFromDBUseCase = GetApiListFromDBUseCase(repository)

        viewModel = ApiListViewModel(shortenUseCase, insertApiInDBUseCase,
            deleteApiUseCase, getApiListFromDBUseCase)

    }

    @Test
    fun addApi_saveShortenedApiInDB() {
        viewModel.saveShortenedApiInDB(shortenedApi1)
        val value = viewModel.saveApiEvent.getOrAwaitValue()

        assertThat(value , `is`(true))
    }

}