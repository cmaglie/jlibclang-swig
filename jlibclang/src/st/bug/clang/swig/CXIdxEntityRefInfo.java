/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXIdxEntityRefInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXIdxEntityRefInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXIdxEntityRefInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXIdxEntityRefInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setKind(CXIdxEntityRefKind value) {
    clangjavaJNI.CXIdxEntityRefInfo_kind_set(swigCPtr, this, value.swigValue());
  }

  public CXIdxEntityRefKind getKind() {
    return CXIdxEntityRefKind.swigToEnum(clangjavaJNI.CXIdxEntityRefInfo_kind_get(swigCPtr, this));
  }

  public void setCursor(CXCursor value) {
    clangjavaJNI.CXIdxEntityRefInfo_cursor_set(swigCPtr, this, CXCursor.getCPtr(value), value);
  }

  public CXCursor getCursor() {
    long cPtr = clangjavaJNI.CXIdxEntityRefInfo_cursor_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXCursor(cPtr, false);
  }

  public void setLoc(CXIdxLoc value) {
    clangjavaJNI.CXIdxEntityRefInfo_loc_set(swigCPtr, this, CXIdxLoc.getCPtr(value), value);
  }

  public CXIdxLoc getLoc() {
    long cPtr = clangjavaJNI.CXIdxEntityRefInfo_loc_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxLoc(cPtr, false);
  }

  public void setReferencedEntity(CXIdxEntityInfo value) {
    clangjavaJNI.CXIdxEntityRefInfo_referencedEntity_set(swigCPtr, this, CXIdxEntityInfo.getCPtr(value), value);
  }

  public CXIdxEntityInfo getReferencedEntity() {
    long cPtr = clangjavaJNI.CXIdxEntityRefInfo_referencedEntity_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxEntityInfo(cPtr, false);
  }

  public void setParentEntity(CXIdxEntityInfo value) {
    clangjavaJNI.CXIdxEntityRefInfo_parentEntity_set(swigCPtr, this, CXIdxEntityInfo.getCPtr(value), value);
  }

  public CXIdxEntityInfo getParentEntity() {
    long cPtr = clangjavaJNI.CXIdxEntityRefInfo_parentEntity_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxEntityInfo(cPtr, false);
  }

  public void setContainer(CXIdxContainerInfo value) {
    clangjavaJNI.CXIdxEntityRefInfo_container_set(swigCPtr, this, CXIdxContainerInfo.getCPtr(value), value);
  }

  public CXIdxContainerInfo getContainer() {
    long cPtr = clangjavaJNI.CXIdxEntityRefInfo_container_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxContainerInfo(cPtr, false);
  }

  public CXIdxEntityRefInfo() {
    this(clangjavaJNI.new_CXIdxEntityRefInfo(), true);
  }

}
