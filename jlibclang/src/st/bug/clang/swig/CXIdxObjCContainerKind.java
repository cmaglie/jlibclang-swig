/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXIdxObjCContainerKind {
  CXIdxObjCContainer_ForwardRef(0),
  CXIdxObjCContainer_Interface(1),
  CXIdxObjCContainer_Implementation(2);

  public final int swigValue() {
    return swigValue;
  }

  public static CXIdxObjCContainerKind swigToEnum(int swigValue) {
    CXIdxObjCContainerKind[] swigValues = CXIdxObjCContainerKind.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXIdxObjCContainerKind swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXIdxObjCContainerKind.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXIdxObjCContainerKind() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXIdxObjCContainerKind(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXIdxObjCContainerKind(CXIdxObjCContainerKind swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
