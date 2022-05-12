package alex.mets.feature_one.presentation.fragments.second

import alex.mets.feature_one.presentation.interfaces.UiEffect
import alex.mets.feature_one.presentation.interfaces.UiEvent
import alex.mets.feature_one.presentation.interfaces.UiState

class MainContract {

    sealed class Event : UiEvent {
        object OnRandomNumberClicked : Event()
        object OnShowToastClicked : Event()
    }

    data class State(
        val randomNumberState: RandomNumberState
    ) : UiState

    sealed class RandomNumberState {
        object Idle : RandomNumberState()
        object Loading : RandomNumberState()
        data class Success(val number: Int) : RandomNumberState()
    }

    sealed class Effect : UiEffect {

        object ShowToast : Effect()

    }

}