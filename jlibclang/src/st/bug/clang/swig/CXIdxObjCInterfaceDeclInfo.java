/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXIdxObjCInterfaceDeclInfo {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXIdxObjCInterfaceDeclInfo(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXIdxObjCInterfaceDeclInfo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXIdxObjCInterfaceDeclInfo(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setContainerInfo(CXIdxObjCContainerDeclInfo value) {
    clangjavaJNI.CXIdxObjCInterfaceDeclInfo_containerInfo_set(swigCPtr, this, CXIdxObjCContainerDeclInfo.getCPtr(value), value);
  }

  public CXIdxObjCContainerDeclInfo getContainerInfo() {
    long cPtr = clangjavaJNI.CXIdxObjCInterfaceDeclInfo_containerInfo_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxObjCContainerDeclInfo(cPtr, false);
  }

  public void setSuperInfo(CXIdxBaseClassInfo value) {
    clangjavaJNI.CXIdxObjCInterfaceDeclInfo_superInfo_set(swigCPtr, this, CXIdxBaseClassInfo.getCPtr(value), value);
  }

  public CXIdxBaseClassInfo getSuperInfo() {
    long cPtr = clangjavaJNI.CXIdxObjCInterfaceDeclInfo_superInfo_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxBaseClassInfo(cPtr, false);
  }

  public void setProtocols(CXIdxObjCProtocolRefListInfo value) {
    clangjavaJNI.CXIdxObjCInterfaceDeclInfo_protocols_set(swigCPtr, this, CXIdxObjCProtocolRefListInfo.getCPtr(value), value);
  }

  public CXIdxObjCProtocolRefListInfo getProtocols() {
    long cPtr = clangjavaJNI.CXIdxObjCInterfaceDeclInfo_protocols_get(swigCPtr, this);
    return (cPtr == 0) ? null : new CXIdxObjCProtocolRefListInfo(cPtr, false);
  }

  public CXIdxObjCInterfaceDeclInfo() {
    this(clangjavaJNI.new_CXIdxObjCInterfaceDeclInfo(), true);
  }

}
