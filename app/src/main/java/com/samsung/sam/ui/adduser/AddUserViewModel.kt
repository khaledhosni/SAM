package com.samsung.sam.ui.adduser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samsung.sam.data.model.User
import com.samsung.sam.data.remote.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUserViewModel:ViewModel() {


    var userAdded=MutableLiveData<User>()
    var erroMessage=MutableLiveData<String>()




    fun addUser(user:User){

        RetrofitApi.userService.addUser(user)
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                   if(response.code()==201)
                    userAdded.value=response.body()
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    erroMessage.value=t.message
                }

            })
    }
}