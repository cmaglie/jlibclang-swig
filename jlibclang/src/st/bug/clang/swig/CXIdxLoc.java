/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXIdxLoc {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXIdxLoc(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXIdxLoc obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXIdxLoc(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPtr_data(SWIGTYPE_p_p_void value) {
    clangjavaJNI.CXIdxLoc_ptr_data_set(swigCPtr, this, SWIGTYPE_p_p_void.getCPtr(value));
  }

  public SWIGTYPE_p_p_void getPtr_data() {
    long cPtr = clangjavaJNI.CXIdxLoc_ptr_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_void(cPtr, false);
  }

  public void setInt_data(long value) {
    clangjavaJNI.CXIdxLoc_int_data_set(swigCPtr, this, value);
  }

  public long getInt_data() {
    return clangjavaJNI.CXIdxLoc_int_data_get(swigCPtr, this);
  }

  public CXIdxLoc() {
    this(clangjavaJNI.new_CXIdxLoc(), true);
  }

}