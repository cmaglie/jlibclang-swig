/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXToken {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXToken(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXToken obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXToken(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInt_data(SWIGTYPE_p_unsigned_int value) {
    clangjavaJNI.CXToken_int_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_int.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_int getInt_data() {
    long cPtr = clangjavaJNI.CXToken_int_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_int(cPtr, false);
  }

  public void setPtr_data(SWIGTYPE_p_void value) {
    clangjavaJNI.CXToken_ptr_data_set(swigCPtr, this, SWIGTYPE_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_void getPtr_data() {
    long cPtr = clangjavaJNI.CXToken_ptr_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
  }

  public CXToken() {
    this(clangjavaJNI.new_CXToken(), true);
  }

}
