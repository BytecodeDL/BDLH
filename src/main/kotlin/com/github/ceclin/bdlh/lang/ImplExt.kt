package com.github.ceclin.bdlh.lang

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.search.GlobalSearchScope

fun getReference(bdlSignature: BDLSignature): PsiReference = RefToJava(bdlSignature)

class RefToJava(element: BDLSignature) : PsiReferenceBase<BDLSignature>(element, computeRange(element), true) {
    companion object {
        private fun computeRange(element: BDLSignature): TextRange = TextRange(0, element.textLength)

        private fun resolveClass(facade: JavaPsiFacade, scope: GlobalSearchScope, className: String): PsiClass? {
            if ('$' !in className)
                return facade.findClass(className, scope)
            return className.split('$').foldIndexed<String, PsiClass?>(null) { i, c, s ->
                if (i == 0)
                    facade.findClass(s, scope)
                else
                    c?.findInnerClassByName(s, false)
            }
        }

        private fun resolveField(clazz: PsiClass, field: BDLField): PsiField? {
            return clazz.findFieldByName(field.fieldName.text, false)
        }

        private fun resolveMethod(clazz: PsiClass, method: BDLMethod): PsiMethod? {
            clazz.findMethodsByName(method.methodName.text, false).firstOrNull {
                val parameter = method.parameter
                if (parameter == null)
                    it.hasParameters()
                else {
                    it.parameterList.parameters.joinToString(",") { p ->
                        val type = p.type
                        type.deepComponentType.canonicalText + "[]".repeat(type.arrayDimensions)
                    } == parameter.text
                }
            }
            return clazz.findMethodsByName(method.methodName.text, false).firstOrNull()
        }
    }

    override fun resolve(): PsiElement? {
        val project = element.project
        val facade = JavaPsiFacade.getInstance(project)
        val scope = GlobalSearchScope.allScope(project)
        val className = element.className.text
        val clazz = resolveClass(facade, scope, className) ?: return null
        return element.field?.let { resolveField(clazz, it) }
            ?: element.method?.let { resolveMethod(clazz, it) }
    }
}

