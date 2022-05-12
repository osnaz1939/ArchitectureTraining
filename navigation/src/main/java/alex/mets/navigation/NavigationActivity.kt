package alex.mets.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class NavigationActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }


    //TODO fix save/restore backstack in module, see https://developer.android.com/reference/kotlin/androidx/navigation/NavController#restorestate
    //TODO rewrite to StartActivity on top level navigation

//    fun saveNavState() {
//        (application as BaseNavigationApplication).saveNavState(navController.saveState())
//    }
//
//    fun restoreNavState() {
//        val state = (application as BaseNavigationApplication).getNavState()
//        Log.e("RESTORE STATE", " " + state.toString())
//        if (state != null) {
//            navController.restoreState(state)
//        }
//
//        val graphInflater = navController.navInflater
//
//        val graph = graphInflater.inflate(alex.mets.feature_one.R.navigation.one_navigation)
//
//        navController.graph = graph
//    }
}