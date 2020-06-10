package mareklowy.planday.challange

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import mareklowy.planday.challange.api.DataProvider
import mareklowy.planday.challange.fragments.EmployeeListFragment
import mareklowy.planday.challange.helpers.ScreenManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //The logic for waiting for the access token could be placed into a splash screen where
        //it would make more sense
        DataProvider.authenticate {
            Log.d("AUTH", "Autheticate: code:${it.code}")
            //Load EmployeeListFragment
            ScreenManager.replaceFrame(this, EmployeeListFragment().apply {
                //Data
            }, false)
        }
    }
}