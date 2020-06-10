package mareklowy.planday.challange.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mareklowy.planday.challange.R
import mareklowy.planday.challange.api.DataProvider

class EmployeeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        DataProvider.getEmployees { response, employees ->
            Log.d("EMP", "Employees: ${employees?.size ?: "NULL"}")
        }
    }

}