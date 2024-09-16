#set($PACKAGE_SUFFIX = "")
#parse("CalculatePackage.kt")

#parse("CalculateImportPrefix.kt")
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.flowOn
${IMPORT_PREFIX}model.${NAME}State
${IMPORT_PREFIX}model.${NAME}SideEffect
${IMPORT_PREFIX}model.${NAME}UiEvent


class ${NAME}ViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow<${NAME}State>(${NAME}State())
    val stateFlow: StateFlow<${NAME}State>
        get() = _stateFlow.asStateFlow()

    private val sideEffectChannel = Channel<${NAME}SideEffect>()
    val sideEffectFlow: Flow<${NAME}SideEffect>
        get() = sideEffectChannel.receiveAsFlow().flowOn(Dispatchers.Main.immediate)

    fun dispatch(uiEvent: ${NAME}UiEvent) {
        // some feature-specific logic
    }

    private fun reduceState(reducer: (${NAME}State) -> ${NAME}State) {
        _stateFlow.update(reducer)
    }

    private fun sendSideEffect(sideEffect: ${NAME}SideEffect) {
        viewModelScope.launch {
            sideEffectChannel.send(sideEffect)
        }
    }
    
}
