// This is a generated file. Not intended for manual editing.
package com.github.ceclin.bdlh.lang;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface BDLMethod extends PsiElement {

  @NotNull
  BDLMethodName getMethodName();

  @Nullable
  BDLParameter getParameter();

  @NotNull
  BDLReturnType getReturnType();

}