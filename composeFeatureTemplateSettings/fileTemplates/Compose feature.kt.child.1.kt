#set($PACKAGE_SUFFIX = "")
#parse("CalculatePackage.kt")

interface ${NAME}Router {

    fun navigateBack()
    
}
