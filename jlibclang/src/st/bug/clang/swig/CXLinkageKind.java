/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXLinkageKind {
  CXLinkage_Invalid,
  CXLinkage_NoLinkage,
  CXLinkage_Internal,
  CXLinkage_UniqueExternal,
  CXLinkage_External;

  public final int swigValue() {
    return swigValue;
  }

  public static CXLinkageKind swigToEnum(int swigValue) {
    CXLinkageKind[] swigValues = CXLinkageKind.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXLinkageKind swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXLinkageKind.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXLinkageKind() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXLinkageKind(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXLinkageKind(CXLinkageKind swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

