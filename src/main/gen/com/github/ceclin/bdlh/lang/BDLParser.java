// This is a generated file. Not intended for manual editing.
package com.github.ceclin.bdlh.lang;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.ceclin.bdlh.lang.BDLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class BDLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // LS RS
  static boolean array_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_suffix")) return false;
    if (!nextTokenIs(b, LS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LS, RS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_name
  public static boolean class_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "class_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // LA | RA | LS | RS | LP | RP | DOT | SPACE | DOLLAR | COLON | COMMA | id | any
  static boolean fallback(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fallback")) return false;
    boolean r;
    r = consumeToken(b, LA);
    if (!r) r = consumeToken(b, RA);
    if (!r) r = consumeToken(b, LS);
    if (!r) r = consumeToken(b, RS);
    if (!r) r = consumeToken(b, LP);
    if (!r) r = consumeToken(b, RP);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, SPACE);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, ANY);
    return r;
  }

  /* ********************************************************** */
  // field_type SPACE field_name
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_type(b, l + 1);
    r = r && consumeToken(b, SPACE);
    r = r && field_name(b, l + 1);
    exit_section_(b, m, FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // identifier
  public static boolean field_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifier(b, l + 1);
    exit_section_(b, m, FIELD_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // type_name
  public static boolean field_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    exit_section_(b, m, FIELD_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // id
  static boolean identifier(PsiBuilder b, int l) {
    return consumeToken(b, ID);
  }

  /* ********************************************************** */
  // return_type SPACE method_name LP parameter? RP
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = return_type(b, l + 1);
    r = r && consumeToken(b, SPACE);
    r = r && method_name(b, l + 1);
    r = r && consumeToken(b, LP);
    r = r && method_4(b, l + 1);
    r = r && consumeToken(b, RP);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  // parameter?
  private static boolean method_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_4")) return false;
    parameter(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // identifier | LA identifier RA
  public static boolean method_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_name")) return false;
    if (!nextTokenIs(b, "<method name>", ID, LA)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_NAME, "<method name>");
    r = identifier(b, l + 1);
    if (!r) r = method_name_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LA identifier RA
  private static boolean method_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_name_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LA);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, RA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // parameter_type (COMMA parameter_type)*
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_type(b, l + 1);
    r = r && parameter_1(b, l + 1);
    exit_section_(b, m, PARAMETER, r);
    return r;
  }

  // (COMMA parameter_type)*
  private static boolean parameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!parameter_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parameter_1", c)) break;
    }
    return true;
  }

  // COMMA parameter_type
  private static boolean parameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && parameter_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // type_name
  public static boolean parameter_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    exit_section_(b, m, PARAMETER_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // type_name
  public static boolean return_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_type")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    exit_section_(b, m, RETURN_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // (signature|fallback)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    while (true) {
      int c = current_position_(b);
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
    }
    return true;
  }

  // signature|fallback
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    r = signature(b, l + 1);
    if (!r) r = fallback(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LA class_name COLON SPACE (method|field) RA
  public static boolean signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature")) return false;
    if (!nextTokenIs(b, LA)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LA);
    r = r && class_name(b, l + 1);
    r = r && consumeTokens(b, 0, COLON, SPACE);
    r = r && signature_4(b, l + 1);
    r = r && consumeToken(b, RA);
    exit_section_(b, m, SIGNATURE, r);
    return r;
  }

  // method|field
  private static boolean signature_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_4")) return false;
    boolean r;
    r = method(b, l + 1);
    if (!r) r = field(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // id (DOT id)* (DOLLAR id)* array_suffix*
  static boolean type_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && type_name_1(b, l + 1);
    r = r && type_name_2(b, l + 1);
    r = r && type_name_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT id)*
  private static boolean type_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_name_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_name_1", c)) break;
    }
    return true;
  }

  // DOT id
  private static boolean type_name_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOLLAR id)*
  private static boolean type_name_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_name_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_name_2", c)) break;
    }
    return true;
  }

  // DOLLAR id
  private static boolean type_name_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOLLAR, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  // array_suffix*
  private static boolean type_name_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_name_3", c)) break;
    }
    return true;
  }

}
