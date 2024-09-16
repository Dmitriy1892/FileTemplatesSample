#set($PACKAGE_SUFFIX = "model")
#parse("CalculatePackage.kt")

import androidx.compose.runtime.Immutable

@Immutable
data class ${NAME}State(
    val isLoading: Boolean = false,
)
