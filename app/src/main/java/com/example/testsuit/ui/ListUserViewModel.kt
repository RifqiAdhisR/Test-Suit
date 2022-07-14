package com.example.testsuit.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.example.testsuit.DataItem
import com.example.testsuit.UsersRemoteMediator
import com.example.testsuit.data.ApiService
import com.example.testsuit.entity.Users
import com.example.testsuit.room.UsersDatabase


class ListUserViewModel (private val apiService: ApiService, private val usersDatabase: UsersDatabase): ViewModel() {

    private val _countUser = MutableLiveData<List<DataItem>>()
    val countUser: LiveData<List<DataItem>> = _countUser

    private val _responseUser = MutableLiveData<Int?>()
    val responseUser: LiveData<Int?> = _responseUser


//    fun listUser() {
////        _isLoading.value = true
//        val client = ApiConfig.getApiService().getUsers()
//        client.enqueue(object : Callback<UserResponse> {
//            override fun onResponse(
//                call: Call<UserResponse>,
//                response: Response<UserResponse>
//            ) {
////                _isLoading.value = false
//                if (response.isSuccessful) {
//                    _countUser.value = response.body()?.data as List<DataItem>
//                    _responseUser.value = response.body()?.total
////                    _snackBarText.value = Event("Success")
//                } else {
//                    Log.e(TAG,
//                        StringBuilder().append("On Failure :").append(response.message()).toString()
//                    )
//                }
//            }
//
//            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
////                _isLoading.value = false
//                Log.e(TAG, StringBuilder().append("On Failure :").append(t.message).toString())
//            }
//        })
//    }

    fun getUsers(): LiveData<PagingData<Users>>{
        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = UsersRemoteMediator(usersDatabase, apiService),
            pagingSourceFactory = {
                usersDatabase.userDao().getAllUsers()
            }
        ).liveData
    }

    companion object {
        private const val TAG = "ListUserViewModel"
    }
}