package mareklowy.planday.challange.api.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import mareklowy.planday.challange.api.data.DepartmentData
import mareklowy.planday.challange.api.data.PagingData


data class GetDepartmentsResponse(
    @SerializedName("paging")
    @Expose
    var paging: PagingData? = null,

    @SerializedName("data")
    @Expose
    var data: List<DepartmentData>? = null

)