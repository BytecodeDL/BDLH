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
import com.intellij.psi.PsiReference;

public class BDLSignatureImpl extends ASTWrapperPsiElement implements BDLSignature {

  public BDLSignatureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull BDLVisitor visitor) {
    visitor.visitSignature(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof BDLVisitor) accept((BDLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public BDLClassName getClassName() {
    return findNotNullChildByClass(BDLClassName.class);
  }

  @Override
  @Nullable
  public BDLField getField() {
    return findChildByClass(BDLField.class);
  }

  @Override
  @Nullable
  public BDLMethod getMethod() {
    return findChildByClass(BDLMethod.class);
  }

  @Override
  @NotNull
  public PsiReference getReference() {
    return ImplExtKt.getReference(this);
  }

}
