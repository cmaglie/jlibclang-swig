/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXType {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXType(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXType obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXType(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setKind(CXTypeKind value) {
    clangjavaJNI.CXType_kind_set(swigCPtr, this, value.swigValue());
  }

  public CXTypeKind getKind() {
    return CXTypeKind.swigToEnum(clangjavaJNI.CXType_kind_get(swigCPtr, this));
  }

  public void setData(SWIGTYPE_p_p_void value) {
    clangjavaJNI.CXType_data_set(swigCPtr, this, SWIGTYPE_p_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_p_void getData() {
    long cPtr = clangjavaJNI.CXType_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_void(cPtr, false);
  }

  public CXType() {
    this(clangjavaJNI.new_CXType(), true);
  }

}
