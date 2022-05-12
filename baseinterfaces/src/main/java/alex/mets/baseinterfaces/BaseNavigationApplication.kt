package alex.mets.baseinterfaces

interface BaseNavigationApplication {

    fun navigate(destinationFrom: Any)

    //TODO fix save/restore backstack in module

//    fun saveNavState(state: Bundle?)
//
//    fun getNavState(): Bundle?

}