package com.github.wbars.phpstormentrypointtest

import com.intellij.codeInspection.reference.EntryPoint
import com.intellij.codeInspection.reference.RefElement
import com.intellij.openapi.util.InvalidDataException
import com.intellij.openapi.util.WriteExternalException
import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.documentation.phpdoc.psi.PhpDocComment
import com.jetbrains.php.lang.psi.elements.PhpNamedElement
import org.jdom.Element
import org.jetbrains.annotations.Nls

class DoctrineEntryPoint: EntryPoint() {
    override fun getDisplayName(): @Nls String {
        return "Properties with id annotation"
    }

    override fun isEntryPoint(refElement: RefElement, psiElement: PsiElement): Boolean {
        return isEntryPoint(psiElement)
    }

    override fun isEntryPoint(psiElement: PsiElement): Boolean {
        if (psiElement is PhpNamedElement) {
            val comment: PhpDocComment? = psiElement.docComment
            return comment != null && comment.getTagElementsByName("@ORM\\Id").isNotEmpty()
        }
        return false
    }

    override fun isSelected(): Boolean {
        return true
    }

    override fun setSelected(selected: Boolean) {}

    @Throws(InvalidDataException::class)
    override fun readExternal(element: Element?) {
    }

    @Throws(WriteExternalException::class)
    override fun writeExternal(element: Element?) {
    }
}