package alex.mets.navigation

import alex.mets.feature_one.metainfo.DestinationsOneMeta
import alex.mets.feature_two.metainfo.DestinationsTwoMeta

class Navigator {

    private lateinit var navFragment: BaseNavigationFragment

    fun bind(fragment: BaseNavigationFragment) {
        this.navFragment = fragment
    }

    fun navigate(destinationFrom: Any) {
        when (destinationFrom) {
            is DestinationsOneMeta.FromOne -> navFragment.navigateToTwoFragment()
            is DestinationsTwoMeta.fromTwo -> navFragment.navigateToOneFragment()
        }
    }

}