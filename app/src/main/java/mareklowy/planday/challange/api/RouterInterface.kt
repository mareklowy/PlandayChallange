package mareklowy.planday.challange.api

//import mareklowy.planday.challange.BuildConfig
import mareklowy.planday.challange.BuildConfig
import mareklowy.planday.challange.api.responses.AuthResponse
import mareklowy.planday.challange.api.responses.GetEmployeesResponse
import mareklowy.planday.challange.helpers.Constants
import mareklowy.planday.challange.helpers.Variables
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

        fun createAuth(): RouterInterface {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://id.planday.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RouterInterface::class.java)
        }
    }

    @FormUrlEncoded
    @Headers("Content-type: application/x-www-form-urlencoded")
    @POST("connect/token")
    fun authenticate(
        @Field("client_id") client_id: String = Constants.CLIENT_ID,
        @Field("grant_type") grant_type: String = Constants.GRANT_TYPE,
        @Field("refresh_token") refresh_token: String = Constants.REFRESH_TOKEN
    ): Call<AuthResponse>

    @GET("hr/v1.0/employees")
    fun getEmployees(
        @Header("X-ClientId") client_id: String = Constants.CLIENT_ID,
        @Header("Authorization") auth: String = "Bearer ${Variables.ACCESS_TOKEN}"
    ): Call<GetEmployeesResponse>

    /*  @Headers("Content-type: application/json")
      @POST("/path/{userId}")
      fun postExample(
          @Body body: ExampleRequest,
          @Header("x-api-key") apiKey: String = "User.currentlyLoggedInUser()?.apiKey",
          @Path("userId") userId: String = "ID-666"
      ): Call<Unit>*/


}