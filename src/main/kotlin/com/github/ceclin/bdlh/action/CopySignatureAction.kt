package com.github.ceclin.bdlh.action

import com.github.ceclin.bdlh.jvmCanonicalText
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import com.intellij.psi.*
import com.intellij.psi.util.PsiTypesUtil
import java.awt.datatransfer.StringSelection

class CopySignatureAction : AnAction("BDLH: Copy Signature") {
    override fun update(e: AnActionEvent) {
        val psiElement = e.getData(CommonDataKeys.PSI_ELEMENT)
        e.presentation.isEnabledAndVisible = psiElement.hasBDLSignature()
    }

    private fun PsiElement?.hasBDLSignature(): Boolean {
        if (this is PsiMethod || this is PsiField || this is PsiClass)
            return true
        if (this is PsiReference)
            return resolve().hasBDLSignature()
        return false
    }

    override fun actionPerformed(e: AnActionEvent) {
        val psiElement = e.getData(CommonDataKeys.PSI_ELEMENT)
        CopyPasteManager.getInstance().setContents(StringSelection(psiElement.getBDLSignature()))
    }

    private fun PsiElement?.getBDLSignature(): String = when (this) {
        is PsiMethod -> {
            val clazz = containingClass?.let { PsiTypesUtil.getClassType(it).jvmCanonicalText }
            val params = parameterList.parameters.joinToString(",") { it.type.jvmCanonicalText.toString() }
            "<$clazz: ${returnType?.jvmCanonicalText} $name($params)>"
        }
        is PsiField -> {
            val clazz = containingClass?.let { PsiTypesUtil.getClassType(it).jvmCanonicalText }
            "<$clazz: ${type.jvmCanonicalText} $name>"
        }
        is PsiClass -> "<${PsiTypesUtil.getClassType(this).jvmCanonicalText}>"
        is PsiReference -> resolve().getBDLSignature()
        else -> "<no signature>"
    }
}