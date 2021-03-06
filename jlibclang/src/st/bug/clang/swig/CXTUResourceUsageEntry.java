/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXTUResourceUsageEntry {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXTUResourceUsageEntry(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXTUResourceUsageEntry obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXTUResourceUsageEntry(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setKind(CXTUResourceUsageKind value) {
    clangjavaJNI.CXTUResourceUsageEntry_kind_set(swigCPtr, this, value.swigValue());
  }

  public CXTUResourceUsageKind getKind() {
    return CXTUResourceUsageKind.swigToEnum(clangjavaJNI.CXTUResourceUsageEntry_kind_get(swigCPtr, this));
  }

  public void setAmount(long value) {
    clangjavaJNI.CXTUResourceUsageEntry_amount_set(swigCPtr, this, value);
  }

  public long getAmount() {
    return clangjavaJNI.CXTUResourceUsageEntry_amount_get(swigCPtr, this);
  }

  public CXTUResourceUsageEntry() {
    this(clangjavaJNI.new_CXTUResourceUsageEntry(), true);
  }

}
