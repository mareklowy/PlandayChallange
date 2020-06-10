package mareklowy.planday.challange.support

import android.app.Application
import android.util.Log
import mareklowy.planday.challange.api.DataProvider

class PlandayChallangeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Authenticate
        DataProvider.authenticate {
            Log.d("AUTH", "Autheticate: code:${it.code}")
        }
    }
}