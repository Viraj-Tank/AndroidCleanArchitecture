package com.novuspax.androidcleanarchitecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.novuspax.androidcleanarchitecture.remote.MainRepository
import com.novuspax.androidcleanarchitecture.remote.model.ApiResponse
import com.novuspax.androidcleanarchitecture.utils.Resource
import com.novuspax.androidcleanarchitecture.utils.RetrofitResponse
import com.novuspax.androidcleanarchitecture.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import com.novuspax.androidcleanarchitecture.remote.model.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: MainRepository
) : ViewModel() {

    private val _characters = MutableLiveData<Resource<ApiResponse>>()
    val characters: LiveData<Resource<ApiResponse>> get() = _characters

    fun getCharactersWithCustomClass(page: String) {
        _characters.postValue(Resource(Status.LOADING))
        viewModelScope.launch {
            repo.getCharacterData(page).let {
                when (it) {
                    is RetrofitResponse.Success -> {
                        _characters.postValue(Resource(Status.SUCCESS, it.data))
                    }
                    is RetrofitResponse.Error -> {
                        _characters.postValue(Resource(Status.FAIL))
                    }
                }
            }
        }
    }

    val pagingCharactersList = Pager(PagingConfig(pageSize = 10)) {
        CharactersPagingSource()
    }.flow

    inner class CharactersPagingSource : PagingSource<Int, Result>() {
        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
            val currentPageKey = params.key ?: 1
            return try {
                repo.getCharacterData(currentPageKey.toString()).let {
                    when (it) {
                        is RetrofitResponse.Success -> {
                            val results = it.data?.results
                            LoadResult.Page(
                                data = results.orEmpty(),
                                prevKey = if (currentPageKey == 1) null else currentPageKey.minus(1),
                                nextKey = if (results.isNullOrEmpty()) null else currentPageKey.plus(1)
                            )
                        }
                        is RetrofitResponse.Error -> {
                            val e = Exception()
                            LoadResult.Error(e)
                        }
                    }
                }
            } catch (e: Exception) {
                LoadResult.Error(e)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, Result>): Int? = null
    }
}