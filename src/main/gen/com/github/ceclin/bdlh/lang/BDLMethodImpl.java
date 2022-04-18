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

public class BDLMethodImpl extends ASTWrapperPsiElement implements BDLMethod {

  public BDLMethodImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BDLVisitor visitor) {
    visitor.visitMethod(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BDLVisitor) accept((BDLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BDLMethodName getMethodName() {
    return findNotNullChildByClass(BDLMethodName.class);
  }

  @Override
  @Nullable
  public BDLParameter getParameter() {
    return findChildByClass(BDLParameter.class);
  }

  @Override
  @NotNull
  public BDLReturnType getReturnType() {
    return findNotNullChildByClass(BDLReturnType.class);
  }

}
