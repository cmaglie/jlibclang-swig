/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXIdxEntityLanguage {
  CXIdxEntityLang_None(0),
  CXIdxEntityLang_C(1),
  CXIdxEntityLang_ObjC(2),
  CXIdxEntityLang_CXX(3);

  public final int swigValue() {
    return swigValue;
  }

  public static CXIdxEntityLanguage swigToEnum(int swigValue) {
    CXIdxEntityLanguage[] swigValues = CXIdxEntityLanguage.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXIdxEntityLanguage swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXIdxEntityLanguage.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXIdxEntityLanguage() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXIdxEntityLanguage(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXIdxEntityLanguage(CXIdxEntityLanguage swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}
