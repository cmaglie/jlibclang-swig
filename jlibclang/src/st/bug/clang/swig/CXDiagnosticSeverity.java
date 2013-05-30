/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXDiagnosticSeverity {
  CXDiagnostic_Ignored(0),
  CXDiagnostic_Note(1),
  CXDiagnostic_Warning(2),
  CXDiagnostic_Error(3),
  CXDiagnostic_Fatal(4);

  public final int swigValue() {
    return swigValue;
  }

  public static CXDiagnosticSeverity swigToEnum(int swigValue) {
    CXDiagnosticSeverity[] swigValues = CXDiagnosticSeverity.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXDiagnosticSeverity swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXDiagnosticSeverity.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXDiagnosticSeverity() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXDiagnosticSeverity(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXDiagnosticSeverity(CXDiagnosticSeverity swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

