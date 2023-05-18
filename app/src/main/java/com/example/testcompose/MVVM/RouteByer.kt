package com.example.testcompose.MVVM

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



fun postDataRegisterUser(

    name: MutableState<TextFieldValue>,
    surname: MutableState<TextFieldValue>,
    login: MutableState<TextFieldValue>,
    email: MutableState<TextFieldValue>,
    phone: MutableState<TextFieldValue>,
    password: MutableState<TextFieldValue>

) {

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
    val dataModel = RegisterUserItem(name.toString(),
        surname.toString(), login.toString(), email.toString(),
        phone.toString(), password.toString())

    val call: Call<RegisterUserItem?>? = retrofitAPI.postBuyer(dataModel)
    call!!.enqueue(object : Callback<RegisterUserItem?> {
        override fun onResponse(
            call: Call<RegisterUserItem?>,
            response: Response<RegisterUserItem?>
        ) {
            response.body()?.let {
            }
        }
        override fun onFailure(call: Call<RegisterUserItem?>, t: Throwable) {

        }
    })

}


fun DeleteDataRegisterUser() {

    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .build()

    // Create Service
    val service = retrofit.create(RetrofitAPI::class.java)

    CoroutineScope(Dispatchers.IO).launch {

        // Do the DELETE request and get response

        val response = service.deleteBuyer()
        withContext(Dispatchers.Main) {

        }
    }
}