/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXChildVisitResult {
  CXChildVisit_Break,
  CXChildVisit_Continue,
  CXChildVisit_Recurse;

  public final int swigValue() {
    return swigValue;
  }

  public static CXChildVisitResult swigToEnum(int swigValue) {
    CXChildVisitResult[] swigValues = CXChildVisitResult.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXChildVisitResult swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXChildVisitResult.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXChildVisitResult() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXChildVisitResult(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXChildVisitResult(CXChildVisitResult swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
