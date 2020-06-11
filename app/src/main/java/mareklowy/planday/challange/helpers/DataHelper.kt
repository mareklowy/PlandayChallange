package mareklowy.planday.challange.helpers

import mareklowy.planday.challange.api.ApiResponseType
import mareklowy.planday.challange.api.DataProvider
import mareklowy.planday.challange.api.data.DepartmentData
import mareklowy.planday.challange.api.data.EmployeeData

object DataHelper {

    private var employees: List<EmployeeData>? = null
    private var departments: List<DepartmentData>? = null

    //This data could be refreshed on regular time interval

    fun getEmployees(completion: (employees: List<EmployeeData>) -> Unit) {
        if (employees != null) return completion(employees ?: listOf())
        else {
            DataProvider.getEmployees { response, employees ->
                if (response.type == ApiResponseType.SUCCESS) {
                    this.employees = employees
                    completion(employees ?: listOf())
                } else {
                    completion(listOf())
                }
            }
        }
    }

    fun getDepartments(completion: (departments: List<DepartmentData>) -> Unit) {
        if (departments != null) return completion(departments ?: listOf())
        else {
            DataProvider.getDepartments { response, departments ->
                if (response.type == ApiResponseType.SUCCESS) {
                    this.departments = departments
                    completion(departments ?: listOf())
                } else {
                    completion(listOf())
                }
            }
        }
    }
}