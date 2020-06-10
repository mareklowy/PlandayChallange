package mareklowy.planday.challange.api

import android.util.Log
import mareklowy.planday.challange.api.responses.AuthResponse
import mareklowy.planday.challange.helpers.Variables
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataProvider {
    private val routerService = RouterInterface.create()
    private val authRouterService = RouterInterface.createAuth()

    fun authenticate(completion: (response: ApiResponse) -> Unit) {
        val call = authRouterService.authenticate()

        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(
                call: Call<AuthResponse>?,
                response: Response<AuthResponse>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            response.body()?.also {
                                val accessToken = it.accessToken ?: ""
                                Variables.ACCESS_TOKEN = accessToken
                                completion(ApiResponse(statusCode))
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("authenticate", t.toString())
                completion(ApiResponse(500))
            }
        })
    }
}