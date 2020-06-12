package mareklowy.planday.challange.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.cell_employee.view.*
import mareklowy.planday.challange.R
import mareklowy.planday.challange.api.data.DepartmentData
import mareklowy.planday.challange.api.data.EmployeeData
import org.jetbrains.anko.sdk25.coroutines.onClick

class EmployeeListAdapter(
    private val context: Context?,
    var employees: List<EmployeeData>,
    var departments: List<DepartmentData>,
    var onClick: (employee: EmployeeData) -> Unit
) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

    override fun getItemCount() = employees.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        employees[position].let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.cell_employee, parent, false)

        return EmployeeViewHolder(view)
    }

    //MARK: ViewHolder
    inner class EmployeeViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(employee: EmployeeData) {
            view.apply {
                employee_cell_name_textview.text = "${employee.firstName} ${employee.lastName}"

                Glide.with(context)
                    .load(R.drawable.dw_profile_placeholder)
                    .apply(RequestOptions.circleCropTransform())
                    .into(employee_cell_image_imageview)

                val employeeDepartments: MutableList<String> = mutableListOf()
                employee.departments?.forEach { departmentId ->
                    val name = departments.find { it.id == departmentId }?.name ?: ""
                    employeeDepartments.add(name)
                }
                val departmentsText = employeeDepartments.joinToString(", ")
                employee_cell_departments_textview.text = "Departments: $departmentsText"

                view.onClick {
                    this@EmployeeListAdapter.onClick(employee)
                }
            }
        }
    }
}