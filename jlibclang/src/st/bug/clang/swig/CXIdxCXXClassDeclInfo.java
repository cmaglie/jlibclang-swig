/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXIdxCXXClassDeclInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXIdxCXXClassDeclInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXIdxCXXClassDeclInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXIdxCXXClassDeclInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setDeclInfo(CXIdxDeclInfo value) {
    clangjavaJNI.CXIdxCXXClassDeclInfo_declInfo_set(swigCPtr, this, CXIdxDeclInfo.getCPtr(value), value);
  }

  public CXIdxDeclInfo getDeclInfo() {
    long cPtr = clangjavaJNI.CXIdxCXXClassDeclInfo_declInfo_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxDeclInfo(cPtr, false);
  }

  public void setBases(SWIGTYPE_p_p_CXIdxBaseClassInfo value) {
    clangjavaJNI.CXIdxCXXClassDeclInfo_bases_set(swigCPtr, this, SWIGTYPE_p_p_CXIdxBaseClassInfo.getCPtr(value));
  }

  public SWIGTYPE_p_p_CXIdxBaseClassInfo getBases() {
    long cPtr = clangjavaJNI.CXIdxCXXClassDeclInfo_bases_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_p_CXIdxBaseClassInfo(cPtr, false);
  }

  public void setNumBases(long value) {
    clangjavaJNI.CXIdxCXXClassDeclInfo_numBases_set(swigCPtr, this, value);
  }

  public long getNumBases() {
    return clangjavaJNI.CXIdxCXXClassDeclInfo_numBases_get(swigCPtr, this);
  }

  public CXIdxCXXClassDeclInfo() {
    this(clangjavaJNI.new_CXIdxCXXClassDeclInfo(), true);
  }

}
