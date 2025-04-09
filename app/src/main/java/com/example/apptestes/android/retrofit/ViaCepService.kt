package com.example.apptestes.android.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {
    @GET("ws/{cep}/json/")
    suspend fun getAddress(
        @Path("cep") cep: String
    ): Response<com.example.apptestes.android.retrofit.AddressModel>
}