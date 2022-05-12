package alex.mets.feature_one.presentation.fragments.second

import alex.mets.feature_one.domain.BackgroundFunc
import alex.mets.feature_one.domain.OneInteractor
import alex.mets.feature_one.presentation.interfaces.BaseViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    //TODO add DI
    private val interactor = OneInteractor()
    private val func = BackgroundFunc()

    override fun createInitialState(): MainContract.State {
        return MainContract.State(
            MainContract.RandomNumberState.Idle
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        backgroundWrapperExample()
        when (event) {
            is MainContract.Event.OnRandomNumberClicked -> {
                generateRandomNumber()
            }
            is MainContract.Event.OnShowToastClicked -> {
                setEffect { MainContract.Effect.ShowToast }
            }
        }
    }

    private fun generateRandomNumber() {
        viewModelScope.launch {
            // Set Loading
            setState { copy(randomNumberState = MainContract.RandomNumberState.Loading) }
            try {
                val random = interactor.doWork(Unit)
                if (random % 2 == 0) {
                    setState { copy(randomNumberState = MainContract.RandomNumberState.Idle) }
                    throw RuntimeException("Number is even")
                }
                setState { copy(randomNumberState = MainContract.RandomNumberState.Success(number = random)) }
            } catch (exception: Exception) {
                setEffect { MainContract.Effect.ShowToast }
            }
        }
    }

    //TODO rewrite interactors with this function
    private fun backgroundWrapperExample() {
        val response = { it: Int ->
            Log.e("tst", it.toString())
        }

        val funcTwo = {
            simple()
        }

        //in MainThread
        func.doInBackground(funcTwo, response)

    }

    fun simple(): Flow<Int> = flow {
        for (i in 1..3) {
            //NOT Main Thread
            delay(1000)
            emit(i)
        }
    }
}