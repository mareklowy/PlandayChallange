package mareklowy.planday.challange.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mareklowy.planday.challange.R

class EmployeeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("GGG", "Here")
        return inflater.inflate(R.layout.fragment_employee_list, container, false)
    }

}