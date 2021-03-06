/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXCommentKind {
  CXComment_Null(0),
  CXComment_Text(1),
  CXComment_InlineCommand(2),
  CXComment_HTMLStartTag(3),
  CXComment_HTMLEndTag(4),
  CXComment_Paragraph(5),
  CXComment_BlockCommand(6),
  CXComment_ParamCommand(7),
  CXComment_TParamCommand(8),
  CXComment_VerbatimBlockCommand(9),
  CXComment_VerbatimBlockLine(10),
  CXComment_VerbatimLine(11),
  CXComment_FullComment(12);

  public final int swigValue() {
    return swigValue;
  }

  public static CXCommentKind swigToEnum(int swigValue) {
    CXCommentKind[] swigValues = CXCommentKind.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXCommentKind swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXCommentKind.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXCommentKind() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXCommentKind(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXCommentKind(CXCommentKind swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

