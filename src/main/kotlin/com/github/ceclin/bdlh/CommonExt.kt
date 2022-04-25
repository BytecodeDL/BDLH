package com.github.ceclin.bdlh

import com.intellij.psi.*
import com.intellij.psi.util.ClassUtil
import com.intellij.psi.util.TypeConversionUtil

internal val PsiType.jvmCanonicalText: String?
    get() = TypeConversionUtil.erasure(this).accept(object : PsiTypeVisitor<String?>() {
        override fun visitPrimitiveType(primitiveType: PsiPrimitiveType): String {
            return primitiveType.canonicalText
        }

        override fun visitClassType(classType: PsiClassType): String? {
            val psiClass = classType.resolve()
            return psiClass?.let { ClassUtil.getJVMClassName(it) }
        }

        override fun visitArrayType(arrayType: PsiArrayType): String? {
            return arrayType.deepComponentType.accept(this)?.let {
                it + "[]".repeat(arrayType.arrayDimensions)
            }
        }
    })