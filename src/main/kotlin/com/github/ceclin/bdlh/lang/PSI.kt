package com.github.ceclin.bdlh.lang

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.jetbrains.annotations.NonNls

class BDLTokenType(debugName: @NonNls String) : IElementType(debugName, BDLLanguage) {
    override fun toString(): String = "BDLToken(${super.toString()})"
}

class BDLElementType(debugName: @NonNls String) : IElementType(debugName, BDLLanguage)

class BDLFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, BDLLanguage) {
    override fun getFileType(): FileType = BDLFileType
    override fun toString(): String = "BDL File"
}

class BDLLexerAdapter : FlexAdapter(BDLLexer())

class BDLParserDefinition : ParserDefinition {
    companion object {
        val FILE: IFileElementType = IFileElementType(BDLLanguage)
    }

    override fun createLexer(project: Project?): Lexer = BDLLexerAdapter()

    override fun createParser(project: Project?): PsiParser = BDLParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getWhitespaceTokens(): TokenSet = TokenSet.EMPTY

    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = BDLTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = BDLFile(viewProvider)
}