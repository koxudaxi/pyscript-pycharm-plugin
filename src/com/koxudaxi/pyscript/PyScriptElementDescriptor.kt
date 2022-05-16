package com.koxudaxi.pyscript

import com.intellij.psi.PsiElement
import com.intellij.psi.xml.XmlAttribute
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.XmlAttributeDescriptor
import com.intellij.xml.XmlElementDescriptor
import com.intellij.xml.XmlElementDescriptor.CONTENT_TYPE_ANY
import com.intellij.xml.XmlElementsGroup
import com.intellij.xml.XmlNSDescriptor


class PyScriptElementDescriptor(private val tagName: String, private val declaration: PsiElement) : XmlElementDescriptor {

    override fun getDeclaration(): PsiElement {
        return declaration
    }

    override fun getName(context: PsiElement?): String {
        return name
    }

    override fun getName(): String {
        return tagName
    }

    override fun init(element: PsiElement?) {

    }

    override fun getQualifiedName(): String {
        return name
    }

    override fun getDefaultName(): String {
        return name
    }

    override fun getElementsDescriptors(context: XmlTag?): Array<XmlElementDescriptor> {
        return getPyScriptElementDescriptor(context)?.let {
            arrayOf(it)
        } ?: emptyArray()
    }

    override fun getElementDescriptor(childTag: XmlTag?, contextTag: XmlTag?): XmlElementDescriptor? {
        if (childTag !is XmlTag) return null
        val parentTag = contextTag?.parentTag ?: return null
        val descriptor = parentTag.getNSDescriptor(childTag.namespace, true)
        return descriptor?.getElementDescriptor(childTag)
    }

    override fun getAttributesDescriptors(context: XmlTag?): Array<XmlAttributeDescriptor> {
        if (context == null) return emptyArray()
        val tagName = context.name
        PY_SCRIPT_TAG_ATTRIBUTES[tagName]?.let { attributes ->
            return attributes.map {
                PyScriptAttributeDescriptor(it)
            }.toTypedArray()
        }
        return emptyArray()
    }

    override fun getAttributeDescriptor(attributeName: String?, context: XmlTag?): XmlAttributeDescriptor? {
        return getAttributesDescriptors(context).find { it.name == attributeName }
    }

    override fun getAttributeDescriptor(attribute: XmlAttribute?): XmlAttributeDescriptor? {
        return attribute?.let {
            getAttributeDescriptor(it.name, it.parent);
        }
    }

    override fun getNSDescriptor(): XmlNSDescriptor? {
        return null
    }

    override fun getTopGroup(): XmlElementsGroup? {
        return null
    }

    override fun getContentType(): Int {
        return CONTENT_TYPE_ANY;
    }

    override fun getDefaultValue(): String? {
        return null
    }

    companion object {
        fun getPyScriptElementDescriptor(xmlTag: XmlTag?): PyScriptElementDescriptor? {
            val name = xmlTag?.name ?: return null
            if (PY_SCRIPT_TAG_ATTRIBUTES.containsKey(name)) {
                return PyScriptElementDescriptor(name, xmlTag)
            }
            return null
        }
    }
}