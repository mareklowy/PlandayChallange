package mareklowy.planday.challange.api

enum class ApiResponseType {
    SUCCESS, ERROR, TOKEN_EXPIRED, UNAUTHORIZED_ACCESS
}

class ApiResponse(var code: Int) {
    var type: ApiResponseType = ApiResponseType.SUCCESS
    var message: String = ""

    init {
        when (code) {
            in 200..299 -> type = ApiResponseType.SUCCESS

            401 -> {
                type = ApiResponseType.TOKEN_EXPIRED
                message = this.getTokenExpiredMessage()
            }

            403 -> {
                type = ApiResponseType.UNAUTHORIZED_ACCESS
                message = this.getUnauthorizedMessage()
            }

            in 500..599 -> {
                type = ApiResponseType.ERROR
                message = this.getServerProblemMessage()
            }

            else -> {
                type = ApiResponseType.ERROR
                message = this.getDefaultErrorMessage()
            }
        }
    }

    //MARK: - Helpers -
    private fun getTokenExpiredMessage(): String {
        return "Your session has expired. Please close and open the app"
    }

    private fun getUnauthorizedMessage(): String {
        return "Your user credentials are incorrect"
    }

    private fun getServerProblemMessage(): String {
        return "We are experiencing some server problems"
    }

    private fun getDefaultErrorMessage(): String {
        return "We are experiencing some issues. Try again later"
    }
}