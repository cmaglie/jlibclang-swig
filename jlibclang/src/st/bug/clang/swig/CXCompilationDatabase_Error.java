/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXCompilationDatabase_Error {
  CXCompilationDatabase_NoError(0),
  CXCompilationDatabase_CanNotLoadDatabase(1);

  public final int swigValue() {
    return swigValue;
  }

  public static CXCompilationDatabase_Error swigToEnum(int swigValue) {
    CXCompilationDatabase_Error[] swigValues = CXCompilationDatabase_Error.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXCompilationDatabase_Error swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXCompilationDatabase_Error.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXCompilationDatabase_Error() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXCompilationDatabase_Error(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXCompilationDatabase_Error(CXCompilationDatabase_Error swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

