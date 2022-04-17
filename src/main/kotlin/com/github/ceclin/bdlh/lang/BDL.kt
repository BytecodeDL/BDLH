package com.github.ceclin.bdlh.lang

import com.intellij.icons.AllIcons
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object BDLLanguage : Language("bdl")

object BDLFileType : LanguageFileType(BDLLanguage) {
    override fun getName(): String = "BDL"

    override fun getDescription(): String = "BytecodeDL output"

    override fun getDefaultExtension(): String = "bdl"

    override fun getIcon(): Icon = AllIcons.FileTypes.Custom
}