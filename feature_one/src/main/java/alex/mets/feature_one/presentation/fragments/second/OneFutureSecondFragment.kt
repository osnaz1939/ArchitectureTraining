package alex.mets.feature_one.presentation.fragments.second

import alex.mets.baseinterfaces.BaseNavigationApplication
import alex.mets.feature_one.R
import alex.mets.feature_one.metainfo.DestinationsOneMeta
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect


class OneFutureSecondFragment : Fragment() {

    //TODO add DI
    private val viewModel = MainViewModel()

    private lateinit var progressBar: ProgressBar

    private lateinit var number: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_future_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.buttonGotoTwoMod)
        val generateNumber = view.findViewById<Button>(R.id.generateNumber)
        val showToast = view.findViewById<Button>(R.id.showToast)
        progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        number = view.findViewById<TextView>(R.id.number)


        button.setOnClickListener {
            (requireActivity().application as BaseNavigationApplication).navigate(
                DestinationsOneMeta.FromOne()
            )
        }

        initObservers()
        generateNumber.setOnClickListener {
            viewModel.setEvent(MainContract.Event.OnRandomNumberClicked)
        }

        showToast.setOnClickListener {
            viewModel.setEvent(MainContract.Event.OnShowToastClicked)
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {
                when (it.randomNumberState) {
                    is MainContract.RandomNumberState.Idle -> {
                        progressBar.isVisible = false
                    }
                    is MainContract.RandomNumberState.Loading -> {
                        progressBar.isVisible = true
                    }
                    is MainContract.RandomNumberState.Success -> {
                        progressBar.isVisible = false
                        number.text = it.randomNumberState.number.toString()
                    }
                }
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.effect.collect {
                when (it) {
                    is MainContract.Effect.ShowToast -> {
                        progressBar.isVisible = false
                        showToast("Error, number is even")
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

}