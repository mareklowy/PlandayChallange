package mareklowy.planday.challange.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_employee_list.*
import mareklowy.planday.challange.R
import mareklowy.planday.challange.adapters.EmployeeListAdapter
import mareklowy.planday.challange.api.ApiResponseType
import mareklowy.planday.challange.api.DataProvider
import mareklowy.planday.challange.api.data.EmployeeData

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
        setupRecycler()
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun updateUI() {
        DataProvider.getEmployees { response, employees ->
            Log.d("EMP", "Employees: ${employees?.size ?: "NULL"}")
            if (response.type == ApiResponseType.SUCCESS) {
                employees_list_recyclerview?.apply {
                    (adapter as EmployeeListAdapter).employees = employees ?: listOf()
                    (adapter as EmployeeListAdapter).notifyDataSetChanged()
                }
            }
        }
    }

    private fun setupRecycler() {
        employees_list_recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = EmployeeListAdapter(context, listOf()) {
                loadEmployee(it)
            }
        }
    }

    private fun loadEmployee(employee: EmployeeData) {
        //
    }
}