package com.koxudaxi.pyscript

import com.intellij.psi.impl.source.xml.XmlElementDescriptorProvider
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.XmlElementDescriptor

class PyScriptElementDescriptorProvider: XmlElementDescriptorProvider {
    override fun getDescriptor(tag: XmlTag?): XmlElementDescriptor? {
        return  PyScriptElementDescriptor.getPyScriptElementDescriptor(tag)
    }
}