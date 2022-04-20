package com.github.ceclin.bdlh.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.ceclin.bdlh.lang.BDLTypes.*;

%%

%{
  public BDLLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class BDLLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

ID=[a-zA-Z_0-9]+
ANY=.|\R

%%
<YYINITIAL> {
  "<"                { return LA; }
  ">"                { return RA; }
  "["                { return LS; }
  "]"                { return RS; }
  "("                { return LP; }
  ")"                { return RP; }
  "."                { return DOT; }
  " "                { return SPACE; }
  "$"                { return DOLLAR; }
  ":"                { return COLON; }
  ","                { return COMMA; }

  {ID}               { return ID; }
  {ANY}              { return ANY; }
}

[^] { return BAD_CHARACTER; }
