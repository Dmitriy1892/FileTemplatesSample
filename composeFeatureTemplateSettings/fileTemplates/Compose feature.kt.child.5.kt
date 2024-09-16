#set($PACKAGE_SUFFIX = "ui")
#parse("CalculatePackage.kt")

#parse("CalculateImportPrefix.kt")
#set($IMPORT_ROOT_PREFIX = $IMPORT_PREFIX.replaceFirst("(?s)\\.ui(?!.*?\\.ui)", ""))
#if ($IMPORT_ROOT_PREFIX != "")
    #set($IMPORT_ROOT_PREFIX = "${IMPORT_ROOT_PREFIX}${NAME}")
#else
    #set($IMPORT_ROOT_PREFIX = $NAME)
#end
#set($IMPORT_MODEL_PREFIX = "${IMPORT_PREFIX}model.${NAME}")
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
${IMPORT_ROOT_PREFIX}Router
${IMPORT_ROOT_PREFIX}ViewModel
${IMPORT_MODEL_PREFIX}SideEffect
${IMPORT_MODEL_PREFIX}State
${IMPORT_MODEL_PREFIX}UiEvent

@Composable
fun ${NAME}Screen(
    viewModel: ${NAME}ViewModel,
    router: ${NAME}Router,
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    LaunchedEffect(viewModel) {
        viewModel.sideEffectFlow
            .flowWithLifecycle(lifecycle)
            .onEach { sideEffect: ${NAME}SideEffect ->
                handleSideEffect(sideEffect, router)
            }
            .launchIn(this)
    }

    val state: ${NAME}State by viewModel.stateFlow.collectAsStateWithLifecycle()

    ${NAME}StateContent(
        state = state,
        onEvent = { uiEvent: ${NAME}UiEvent -> viewModel.dispatch(uiEvent) }
    )
}

private fun handleSideEffect(sideEffect: ${NAME}SideEffect, router: ${NAME}Router) {
    // TODO("Not yet implemented")
}

@Composable
private fun ${NAME}StateContent(
    state: ${NAME}State,
    onEvent: (${NAME}UiEvent) -> Unit
) {
    // TODO("Not yet implemented")
}
