package com.samsung.sam.data.remote

import com.samsung.sam.data.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

public interface UserService {
    @GET("Users")
    fun getAllUsers(): Call<List<User>>

    @GET("Users/{id}")
    fun getUserByID(@Path("id") id:String):Call<User?>

    @Headers("accesstoken:1837837683","Cache-Control: max-age=640000")
    @GET("Users")
    fun getUsersByCountry(@Query("country") country:String):Call<List<User>>


    @POST("Users")
    fun addUser(@Body user:User): Call<User>


}