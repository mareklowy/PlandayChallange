package mareklowy.planday.challange.api

import android.util.Log
import mareklowy.planday.challange.api.data.DepartmentData
import mareklowy.planday.challange.api.data.EmployeeData
import mareklowy.planday.challange.api.requests.UpdateEmployeeRequest
import mareklowy.planday.challange.api.responses.AuthResponse
import mareklowy.planday.challange.api.responses.GetDepartmentsResponse
import mareklowy.planday.challange.api.responses.GetEmployeesResponse
import mareklowy.planday.challange.helpers.Variables
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataProvider {
    private val routerService = RouterInterface.create()
    private val authRouterService = RouterInterface.createAuth()

    fun authenticate(completion: (response: ApiResponse) -> Unit) {
        val call = authRouterService.authenticate()

        call.enqueue(object : Callback<AuthResponse> {
            override fun onResponse(
                call: Call<AuthResponse>?,
                response: Response<AuthResponse>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            response.body()?.also {
                                val accessToken = it.accessToken ?: ""
                                Variables.ACCESS_TOKEN = accessToken
                                completion(ApiResponse(statusCode))
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                Log.d("authenticate", t.toString())
                completion(ApiResponse(500))
            }
        })
    }

    fun getEmployees(completion: (response: ApiResponse, employees: List<EmployeeData>?) -> Unit) {
        val call = routerService.getEmployees()

        call.enqueue(object : Callback<GetEmployeesResponse> {
            override fun onResponse(
                call: Call<GetEmployeesResponse>?,
                response: Response<GetEmployeesResponse>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            response.body()?.also {
                                completion(ApiResponse(statusCode), it.data)
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode), null)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<GetEmployeesResponse>, t: Throwable) {
                Log.d("getEmployees", t.toString())
                completion(ApiResponse(500), null)
            }
        })
    }

    fun getDepartments(completion: (response: ApiResponse, departments: List<DepartmentData>?) -> Unit) {
        val call = routerService.getDepartments()

        call.enqueue(object : Callback<GetDepartmentsResponse> {
            override fun onResponse(
                call: Call<GetDepartmentsResponse>?,
                response: Response<GetDepartmentsResponse>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            response.body()?.also {
                                completion(ApiResponse(statusCode), it.data)
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode), null)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<GetDepartmentsResponse>, t: Throwable) {
                Log.d("getDepartments", t.toString())
                completion(ApiResponse(500), null)
            }
        })
    }

    fun updateEmployee(
        employeeId: Int?,
        request: UpdateEmployeeRequest,
        completion: (response: ApiResponse) -> Unit
    ) {
        val call = routerService.updateEmployee(employeeId ?: 0, request)

        call.enqueue(object : Callback<Unit> {
            override fun onResponse(
                call: Call<Unit>?,
                response: Response<Unit>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        204 -> {
                            response.body()?.also {
                                completion(ApiResponse(statusCode))
                            }
                        }

                        else -> {
                            completion(ApiResponse(statusCode))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("updateEmployee", t.toString())
                completion(ApiResponse(500))
            }
        })
    }
}