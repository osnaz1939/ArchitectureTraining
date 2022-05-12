package alex.mets.feature_two.fragments

import alex.mets.baseinterfaces.BaseNavigationApplication
import alex.mets.feature_two.R
import alex.mets.feature_two.metainfo.DestinationsTwoMeta
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TwoFirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button_goto_one)
        button.setOnClickListener {
            (requireActivity().application as BaseNavigationApplication).navigate(
                DestinationsTwoMeta.fromTwo()
            )
        }
    }
}