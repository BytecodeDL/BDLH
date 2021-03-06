package com.github.ceclin.bdlh.lang

import com.github.ceclin.bdlh.jvmCanonicalText
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.ClassUtil

fun getReference(bdlSignature: BDLSignature): PsiReference = RefToJava(bdlSignature)

class RefToJava(element: BDLSignature) : PsiReferenceBase<BDLSignature>(element, computeRange(element), true) {
    companion object {
        private fun computeRange(element: BDLSignature): TextRange = TextRange(0, element.textLength)

        private fun resolveField(clazz: PsiClass, field: BDLField): PsiField? {
            return clazz.findFieldByName(field.fieldName.text, false)
        }

        private fun resolveMethod(clazz: PsiClass, method: BDLMethod): PsiMethod? {
            val methodName = method.methodName.text.takeUnless { it == "<init>" } ?: clazz.name
            return clazz.findMethodsByName(methodName, false).firstOrNull {
                val parameter = method.parameter
                if (parameter == null)
                    !it.hasParameters()
                else {
                    it.parameterList.parameters.joinToString(",") { p ->
                        p.type.jvmCanonicalText.toString()
                    } == parameter.text
                }
            }
        }
    }

    override fun resolve(): PsiElement? {
        val project = element.project
        val className = element.className.text
        val clazz = ClassUtil.findPsiClassByJVMName(PsiManager.getInstance(project), className)
            ?: return null
        element.field?.let { return resolveField(clazz, it) }
        element.method?.let { return resolveMethod(clazz, it) }
        return clazz
    }
}

