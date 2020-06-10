package mareklowy.planday.challange.api

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataProvider {
    private val routerService = RouterInterface.create()

   /* fun getArticles(completion: (response: ApiResponse, List<Article>?) -> Unit) {
        val call = routerService.getArticles()

        call.enqueue(object : Callback<List<Article>> {
            override fun onResponse(
                call: Call<List<Article>>?,
                response: Response<List<Article>>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            response.body()?.also {
                                completion(ApiResponse(statusCode), it)
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode), null)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("getArticles", t.toString())
                completion(ApiResponse(500), null)
            }
        })
    }*/
}