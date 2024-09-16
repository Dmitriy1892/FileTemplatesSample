#set($PACKAGE_SUFFIX = "model")
#parse("CalculatePackage.kt")

import androidx.compose.runtime.Immutable

@Immutable
sealed interface ${NAME}UiEvent {

    data object NavigateBack : ${NAME}UiEvent

}
