/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXVisitorResult {
  CXVisit_Break,
  CXVisit_Continue;

  public final int swigValue() {
    return swigValue;
  }

  public static CXVisitorResult swigToEnum(int swigValue) {
    CXVisitorResult[] swigValues = CXVisitorResult.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXVisitorResult swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXVisitorResult.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXVisitorResult() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXVisitorResult(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXVisitorResult(CXVisitorResult swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

