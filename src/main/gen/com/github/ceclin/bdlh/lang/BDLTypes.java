// This is a generated file. Not intended for manual editing.
package com.github.ceclin.bdlh.lang;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface BDLTypes {

  IElementType CLASS_NAME = new BDLElementType("CLASS_NAME");
  IElementType FIELD = new BDLElementType("FIELD");
  IElementType FIELD_NAME = new BDLElementType("FIELD_NAME");
  IElementType FIELD_TYPE = new BDLElementType("FIELD_TYPE");
  IElementType METHOD = new BDLElementType("METHOD");
  IElementType METHOD_NAME = new BDLElementType("METHOD_NAME");
  IElementType PARAMETER = new BDLElementType("PARAMETER");
  IElementType PARAMETER_TYPE = new BDLElementType("PARAMETER_TYPE");
  IElementType RETURN_TYPE = new BDLElementType("RETURN_TYPE");
  IElementType SIGNATURE = new BDLElementType("SIGNATURE");

  IElementType ANY = new BDLTokenType("any");
  IElementType COLON = new BDLTokenType(":");
  IElementType COMMA = new BDLTokenType(",");
  IElementType DOLLAR = new BDLTokenType("$");
  IElementType DOT = new BDLTokenType(".");
  IElementType ID = new BDLTokenType("id");
  IElementType LA = new BDLTokenType("<");
  IElementType LP = new BDLTokenType("(");
  IElementType LS = new BDLTokenType("[");
  IElementType RA = new BDLTokenType(">");
  IElementType RP = new BDLTokenType(")");
  IElementType RS = new BDLTokenType("]");
  IElementType SPACE = new BDLTokenType(" ");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == CLASS_NAME) {
        return new BDLClassNameImpl(node);
      }
      else if (type == FIELD) {
        return new BDLFieldImpl(node);
      }
      else if (type == FIELD_NAME) {
        return new BDLFieldNameImpl(node);
      }
      else if (type == FIELD_TYPE) {
        return new BDLFieldTypeImpl(node);
      }
      else if (type == METHOD) {
        return new BDLMethodImpl(node);
      }
      else if (type == METHOD_NAME) {
        return new BDLMethodNameImpl(node);
      }
      else if (type == PARAMETER) {
        return new BDLParameterImpl(node);
      }
      else if (type == PARAMETER_TYPE) {
        return new BDLParameterTypeImpl(node);
      }
      else if (type == RETURN_TYPE) {
        return new BDLReturnTypeImpl(node);
      }
      else if (type == SIGNATURE) {
        return new BDLSignatureImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
