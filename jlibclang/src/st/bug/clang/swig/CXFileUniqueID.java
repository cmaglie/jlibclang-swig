/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXFileUniqueID {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXFileUniqueID(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXFileUniqueID obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXFileUniqueID(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setData(SWIGTYPE_p_unsigned_long_long value) {
    clangjavaJNI.CXFileUniqueID_data_set(swigCPtr, this, SWIGTYPE_p_unsigned_long_long.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_long_long getData() {
    long cPtr = clangjavaJNI.CXFileUniqueID_data_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_long_long(cPtr, false);
  }

  public CXFileUniqueID() {
    this(clangjavaJNI.new_CXFileUniqueID(), true);
  }

}
