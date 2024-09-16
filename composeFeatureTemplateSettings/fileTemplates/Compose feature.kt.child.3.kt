#set($PACKAGE_SUFFIX = "model")
#parse("CalculatePackage.kt")

import androidx.compose.runtime.Immutable

@Immutable
sealed interface ${NAME}SideEffect {

    data class ShowUnknownError(val error: Throwable) : ${NAME}SideEffect

}
