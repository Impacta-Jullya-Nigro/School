package com.example.school.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepApi {
    @GET("ws/{cep}/json/")
    fun getEndereco(@Path("cep") cep: String): Call<Endereco>
}