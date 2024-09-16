#if ($PACKAGE_NAME && $PACKAGE_NAME != "" && $ROOT_PACKAGE && $ROOT_PACKAGE != "")
    #set($OUT_PACKAGE = "$PACKAGE_NAME.$ROOT_PACKAGE")
#elseif ($PACKAGE_NAME && $PACKAGE_NAME != "")
    #set($OUT_PACKAGE = $PACKAGE_NAME)
#elseif ($ROOT_PACKAGE && $ROOT_PACKAGE != "")
    #set($OUT_PACKAGE = $ROOT_PACKAGE)
#else
    #set($OUT_PACKAGE = "")
#end
#if ($OUT_PACKAGE != "" && $PACKAGE_SUFFIX && $PACKAGE_SUFFIX != "")
package ${OUT_PACKAGE}.${PACKAGE_SUFFIX}
#elseif ($OUT_PACKAGE != "")
package ${OUT_PACKAGE}
#elseif ($PACKAGE_SUFFIX && $PACKAGE_SUFFIX != "")
package $PACKAGE_SUFFIX
#end