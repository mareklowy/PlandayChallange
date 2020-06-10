package mareklowy.planday.challange.api

//import mareklowy.planday.challange.BuildConfig
import mareklowy.planday.challange.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface RouterInterface {

    companion object Factory {

        val okHttpClient =
            OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        fun create(): RouterInterface {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RouterInterface::class.java)
        }
    }

   /* @GET("articles/all")
    fun getArticles(
    ): Call<List<Article>>*/

  /*  @Headers("Content-type: application/json")
    @POST("/path/{userId}")
    fun postExample(
        @Body body: ExampleRequest,
        @Header("x-api-key") apiKey: String = "User.currentlyLoggedInUser()?.apiKey",
        @Path("userId") userId: String = "ID-666"
    ): Call<Unit>*/


}