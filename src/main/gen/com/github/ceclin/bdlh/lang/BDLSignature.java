// This is a generated file. Not intended for manual editing.
package com.github.ceclin.bdlh.lang;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface BDLSignature extends PsiElement {

  @NotNull
  BDLClassName getClassName();

  @Nullable
  BDLField getField();

  @Nullable
  BDLMethod getMethod();

  @NotNull
  PsiReference getReference();

}
