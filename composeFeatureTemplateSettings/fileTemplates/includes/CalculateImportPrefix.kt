#if ($OUT_PACKAGE && $OUT_PACKAGE != "")
    #set($IMPORT_PREFIX = "import ${OUT_PACKAGE}.")
#else
    #set($IMPORT_PREFIX = "import ")
#end