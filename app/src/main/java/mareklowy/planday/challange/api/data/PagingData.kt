package mareklowy.planday.challange.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class PagingData(

    @SerializedName("limit")
    @Expose
    var limit: Int? = null,

    @SerializedName("total")
    @Expose
    var total: Int? = null

)