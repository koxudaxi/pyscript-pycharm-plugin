package com.koxudaxi.pyscript

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.psi.html.HtmlTag
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.XmlTagNameProvider

class PyScriptTagNameProvider : XmlTagNameProvider {
    override fun addTagNameVariants(elements: MutableList<LookupElement>, tag: XmlTag, prefix: String) {
        if (tag !is HtmlTag) return
        for (tagName in PY_SCRIPT_TAG_NAMES) {
            elements.add(LookupElementBuilder.create(tagName))
        }
    }
}