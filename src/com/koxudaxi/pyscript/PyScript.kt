package com.koxudaxi.pyscript


internal val PY_SCRIPT_TAG_ATTRIBUTES: LinkedHashMap<String, List<String>> = linkedMapOf(
        "py-script" to listOf("output"),
        "py-env" to emptyList()
)
internal val PY_SCRIPT_TAG_NAMES: List<String> = PY_SCRIPT_TAG_ATTRIBUTES.keys.toList()