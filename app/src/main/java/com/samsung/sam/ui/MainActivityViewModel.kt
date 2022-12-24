package com.samsung.sam.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samsung.sam.data.model.User
import com.samsung.sam.data.remote.RetrofitApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel:ViewModel() {

    private var counter=0

    var userData=MutableLiveData<List<User>?>()
    var message=MutableLiveData<String?>()
    var selectedUser=MutableLiveData<User?>()


    fun increment(){
        counter++
    }

    fun getCounter():Int{

        return counter
    }


    fun getData(){

        RetrofitApi.userService.getAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {


                val users=response.body()
                userData.value=users
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                message.value=t.message

            }

        })
    }


    fun getUserByID(id:String){


    }
}