package mareklowy.planday.challange.api.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import mareklowy.planday.challange.helpers.Constants

data class AuthRequest(

    @SerializedName("client_id")
    @Expose
    var client_id: String = Constants.CLIENT_ID,

    @SerializedName("grant_type")
    @Expose
    var grant_type: String = Constants.GRANT_TYPE,

    @SerializedName("refresh_token")
    @Expose
    var refresh_toke: String = Constants.REFRESH_TOKEN
)