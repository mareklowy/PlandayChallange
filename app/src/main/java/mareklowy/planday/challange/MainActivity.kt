package mareklowy.planday.challange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mareklowy.planday.challange.fragments.EmployeeListFragment
import mareklowy.planday.challange.helpers.ScreenManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load EmployeeListFragment
        ScreenManager.replaceFrame(this, EmployeeListFragment().apply {
            //Data
        }, false)
    }
}