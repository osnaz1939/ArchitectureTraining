package alex.mets.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class NavigationFragment : Fragment(), BaseNavigationFragment {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity().application as NavigatorFabric).getNavigator().bind(this)
        startNavigation()
    }

    private fun startNavigation() {
        findNavController().navigate(R.id.action_navigationFragment_to_one_navigation)
    }

    override fun navigateToTwoFragment() {
        findNavController().navigate(findNavController().graph.startDestinationId)
        findNavController().navigate(R.id.action_navigationFragment_to_two_navigation)
    }

    override fun navigateToOneFragment() {
        findNavController().navigate(findNavController().graph.startDestinationId)
        findNavController().navigate(R.id.action_navigationFragment_to_one_navigation)
    }

}