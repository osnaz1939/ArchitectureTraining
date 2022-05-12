package alex.mets.architecturetraining

import alex.mets.baseinterfaces.BaseNavigationApplication
import alex.mets.navigation.Navigator
import alex.mets.navigation.NavigatorFabric
import android.app.Application
import android.os.Bundle
import android.util.Log

class App : Application(), BaseNavigationApplication, NavigatorFabric {

    private lateinit var baseNavigator: Navigator
    private var localNavState: Bundle? = null

    //TODO research new kodein signatures
//    override val di by DI.lazy {
//        import(androidXModule(this@App))
//
//        bind() from instance(RepositoryOne())
//        bind() from instance(OneInteractor())
//        bind() from instance(MainViewModel())
//        bind() from instance(BackgroundFunc())
//
//    }

    override fun onCreate() {
        super.onCreate()
        Log.e("APP ", "START")
        baseNavigator = Navigator()
    }

    override fun navigate(destinationFrom: Any) {
        baseNavigator.navigate(destinationFrom)
    }

    override fun getNavigator(): Navigator {
        return baseNavigator
    }


    //TODO fix save/restore backstack in module

//    override fun saveNavState(state: Bundle?) {
//        localNavState = state
//    }
//
//    override fun getNavState(): Bundle? {
//        return localNavState
//    }

}