package mareklowy.planday.challange.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class EmployeeData(
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("dateTimeCreated")
    @Expose
    var dateTimeCreated: String? = null,

    @SerializedName("dateTimeModified")
    @Expose
    var dateTimeModified: String? = null,

    @SerializedName("employeeTypeId")
    @Expose
    var employeeTypeId: Int? = null,

    @SerializedName("salaryIdentifier")
    @Expose
    var salaryIdentifier: String? = null,

    @SerializedName("firstName")
    @Expose
    var firstName: String? = null,

    @SerializedName("lastName")
    @Expose
    var lastName: String? = null,

    @SerializedName("userName")
    @Expose
    var userName: String? = null,

    @SerializedName("cellPhone")
    @Expose
    var cellPhone: String? = null,

    @SerializedName("street1")
    @Expose
    var street1: String? = null,

    @SerializedName("zip")
    @Expose
    var zip: String? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null,

    @SerializedName("city")
    @Expose
    var city: String? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null,

    @SerializedName("departments")
    @Expose
    var departments: List<Int>? = null,

    @SerializedName("employeeGroups")
    @Expose
    var employeeGroups: List<Int>? = null

)