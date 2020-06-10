package mareklowy.planday.challange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mareklowy.planday.challange.fragments.EmployeeListFragment
import mareklowy.planday.challange.helpers.ScreenManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ScreenManager.replaceFrame(this, EmployeeListFragment().apply {
            //Data
        }, false)
    }
}