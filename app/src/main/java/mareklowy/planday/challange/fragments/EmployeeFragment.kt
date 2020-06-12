package mareklowy.planday.challange.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_employee.*
import mareklowy.planday.challange.R
import mareklowy.planday.challange.api.ApiResponseType
import mareklowy.planday.challange.api.DataProvider
import mareklowy.planday.challange.api.data.EmployeeData
import mareklowy.planday.challange.api.requests.UpdateEmployeeRequest
import org.jetbrains.anko.sdk25.coroutines.onClick

class EmployeeFragment : Fragment() {

    var employee: EmployeeData? = null

    private var editing = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee, container, false)
    }

    override fun onStart() {
        super.onStart()
        setupUI()
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun setupUI() {
        setupButtons()
    }

    private fun updateUI() {
        employee_first_name_edittext.setText(employee?.firstName ?: "")
        employee_second_name_edittext.setText(employee?.lastName ?: "")
        employee_gender_edittext.setText("Gender")
        Glide.with(this)
            .load(R.drawable.dw_profile_placeholder)
            .apply(RequestOptions.circleCropTransform())
            .into(employee_picture_imageview)
    }

    private fun toggleEditable() {
        if (editing) {
            employee_edit_button.visibility = View.VISIBLE
            employee_save_button.visibility = View.GONE
            employee_cancel_button.visibility = View.GONE
            employee_first_name_edittext.isEnabled = false
            employee_second_name_edittext.isEnabled = false
            employee_gender_edittext.isEnabled = false
        } else {
            employee_edit_button.visibility = View.GONE
            employee_save_button.visibility = View.VISIBLE
            employee_cancel_button.visibility = View.VISIBLE
            employee_first_name_edittext.isEnabled = true
            employee_second_name_edittext.isEnabled = true
            employee_gender_edittext.isEnabled = true

        }
        editing = !editing
    }

    private fun setupButtons() {
        employee_edit_button.onClick { toggleEditable() }
        employee_save_button.onClick { save() }
        employee_cancel_button.onClick { cancelEditing() }
    }


    private fun save() {
        val first = employee_first_name_edittext.text.toString()
        val last = employee_second_name_edittext.text.toString()
        val gender = employee_gender_edittext.text.toString()
        val request = UpdateEmployeeRequest(
            firstName = first,
            lastName = last,
            gender = gender
        )
        DataProvider.updateEmployee(employee?.id, request) {
            if (it.type == ApiResponseType.SUCCESS) {
                toggleEditable()
            } else {
                Log.d("UPDATE_EMPLOYEE", "ERROR: ${it.code} - ${it.message}")
                Toast.makeText(activity, "An error occured", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cancelEditing() {
        employee_first_name_edittext.setText(employee?.firstName ?: "")
        employee_second_name_edittext.setText(employee?.lastName ?: "")
        employee_gender_edittext.setText("Gender")
        toggleEditable()
    }

}