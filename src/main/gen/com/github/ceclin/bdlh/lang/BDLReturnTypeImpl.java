// This is a generated file. Not intended for manual editing.
package com.github.ceclin.bdlh.lang;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.ceclin.bdlh.lang.BDLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class BDLReturnTypeImpl extends ASTWrapperPsiElement implements BDLReturnType {

  public BDLReturnTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BDLVisitor visitor) {
    visitor.visitReturnType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BDLVisitor) accept((BDLVisitor)visitor);
    else super.accept(visitor);
  }

}
