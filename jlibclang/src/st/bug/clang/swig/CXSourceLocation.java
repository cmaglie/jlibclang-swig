/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXSourceLocation {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXSourceLocation(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXSourceLocation obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXSourceLocation(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPtr_data(SWIGTYPE_p_p_void value) {
    clangjavaJNI.CXSourceLocation_ptr_data_set(swigCPtr, this, SWIGTYPE_p_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_p_void getPtr_data() {
    long cPtr = clangjavaJNI.CXSourceLocation_ptr_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_void(cPtr, false);
  }

  public void setInt_data(long value) {
    clangjavaJNI.CXSourceLocation_int_data_set(swigCPtr, this, value);
  }

  public long getInt_data() {
    return clangjavaJNI.CXSourceLocation_int_data_get(swigCPtr, this);
  }

  public CXSourceLocation() {
    this(clangjavaJNI.new_CXSourceLocation(), true);
  }

}
