/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public enum CXIdxEntityCXXTemplateKind {
  CXIdxEntity_NonTemplate(0),
  CXIdxEntity_Template(1),
  CXIdxEntity_TemplatePartialSpecialization(2),
  CXIdxEntity_TemplateSpecialization(3);

  public final int swigValue() {
    return swigValue;
  }

  public static CXIdxEntityCXXTemplateKind swigToEnum(int swigValue) {
    CXIdxEntityCXXTemplateKind[] swigValues = CXIdxEntityCXXTemplateKind.class.getEnumConstants();
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (CXIdxEntityCXXTemplateKind swigEnum : swigValues)
      if (swigEnum.swigValue == swigValue)
        return swigEnum;
    throw new IllegalArgumentException("No enum " + CXIdxEntityCXXTemplateKind.class + " with value " + swigValue);
  }

  @SuppressWarnings("unused")
  private CXIdxEntityCXXTemplateKind() {
    this.swigValue = SwigNext.next++;
  }

  @SuppressWarnings("unused")
  private CXIdxEntityCXXTemplateKind(int swigValue) {
    this.swigValue = swigValue;
    SwigNext.next = swigValue+1;
  }

  @SuppressWarnings("unused")
  private CXIdxEntityCXXTemplateKind(CXIdxEntityCXXTemplateKind swigEnum) {
    this.swigValue = swigEnum.swigValue;
    SwigNext.next = this.swigValue+1;
  }

  private final int swigValue;

  private static class SwigNext {
    private static int next = 0;
  }
}

