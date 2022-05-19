package com.koxudaxi.pyscript


internal val PY_SCRIPT_TAG_ATTRIBUTES: LinkedHashMap<String, List<String>> = linkedMapOf(
        "py-script" to listOf("output", "std-out", "std-err", "output-mode", "src"),
        "py-repl" to listOf("auto-generate", "std-out", "std-err", "output-mode"),
        "py-env" to emptyList(),
        "py-box" to listOf("widths"),
        "py-button" to listOf("label", "styling"),
        "py-title" to emptyList(),
        "py-inputbox" to listOf("label"),
        "py-register-widget" to listOf("src", "name", "klass"),
        "py-loader" to emptyList(),
        "py-config" to emptyList()
)
internal val PY_SCRIPT_TAG_NAMES: List<String> = PY_SCRIPT_TAG_ATTRIBUTES.keys.toList()