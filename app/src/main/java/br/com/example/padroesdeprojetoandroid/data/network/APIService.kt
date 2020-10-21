package br.com.example.padroesdeprojetoandroid.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object APIService {

    private var INSTANCE: EnderecoService? = null

    val instance: EnderecoService?
        get() {
            if(INSTANCE == null){
                val client = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()

                val retrofit = Retrofit.Builder().baseUrl("https://viacep.com.br")
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(client)
                    .build()

                INSTANCE = retrofit.create(EnderecoService::class.java)
            }
            return INSTANCE
        }
}