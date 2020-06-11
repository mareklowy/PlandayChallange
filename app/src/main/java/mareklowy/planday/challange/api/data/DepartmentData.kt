package mareklowy.planday.challange.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class DepartmentData(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("number")
    @Expose
    var number: String? = null

)