package mareklowy.planday.challange.api.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import mareklowy.planday.challange.api.data.EmployeeData
import mareklowy.planday.challange.api.data.PagingData


data class GetEmployeesResponse(

    @SerializedName("paging")
    @Expose
    var paging: PagingData? = null,

    @SerializedName("data")
    @Expose
    var data: List<EmployeeData>? = null

)