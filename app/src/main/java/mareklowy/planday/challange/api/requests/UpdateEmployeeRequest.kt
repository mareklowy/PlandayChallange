package mareklowy.planday.challange.api.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateEmployeeRequest(

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null,

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null,

    @SerializedName("gender")
    @Expose
    var gender: String? = null

)