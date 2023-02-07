package com.srn.shortlyappchallenge.datasource

import com.srn.shortlyappchallenge.data.ServerResponse
import com.srn.shortlyappchallenge.data.repository.ApiRepositoryImpl
import com.srn.shortlyappchallenge.domain.model.ApiResult
import com.srn.shortlyappchallenge.domain.repository.ApiRepository
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

/**
 * Created by SoheilR .
 */

class ApiRepositoryTest {

    private val shortenedApi1 = ApiResult(0, "code1", "short1",
        "fullShort1", "short1.2", "fullShort1.2",
        "share1", "fullShare1", "original1")

    private val shortenedApi2 = ApiResult(0, "code2", "short2",
        "fullShort2", "short2.2", "fullShort2.2",
        "share2", "fullShare2", "original2")

    private val shortenedApi3 = ApiResult(0, "code3", "short3",
        "fullShort3", "short3.2", "fullShort3.2",
        "share3", "fullShare3", "original3")

    private val remoteApis = listOf(shortenedApi1, shortenedApi2)
    private val localApis = listOf(shortenedApi3)

    lateinit var localDataSource: FakeLocalDataSource
    lateinit var remoteDataSource: FakeRemoteDataSource

    lateinit var repository: ApiRepository

    @Before
    fun createRepository() {
        localDataSource = FakeLocalDataSource(localApis.toMutableList())
        remoteDataSource = FakeRemoteDataSource(remoteApis.toMutableList())

        repository = ApiRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Test
    fun getApis_getAllApisFromLocalDataSource() = runBlocking {
        val result = repository.getApiList()
        assertThat(result , IsEqual(remoteApis))
    }
}