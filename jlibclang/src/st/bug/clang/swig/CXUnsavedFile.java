/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package st.bug.clang.swig;

public class CXUnsavedFile {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CXUnsavedFile(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CXUnsavedFile obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        clangjavaJNI.delete_CXUnsavedFile(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setFilename(String value) {
    clangjavaJNI.CXUnsavedFile_Filename_set(swigCPtr, this, value);
  }

  public String getFilename() {
    return clangjavaJNI.CXUnsavedFile_Filename_get(swigCPtr, this);
  }

  public void setContents(String value) {
    clangjavaJNI.CXUnsavedFile_Contents_set(swigCPtr, this, value);
  }

  public String getContents() {
    return clangjavaJNI.CXUnsavedFile_Contents_get(swigCPtr, this);
  }

  public void setLength(long value) {
    clangjavaJNI.CXUnsavedFile_Length_set(swigCPtr, this, value);
  }

  public long getLength() {
    return clangjavaJNI.CXUnsavedFile_Length_get(swigCPtr, this);
  }

  public CXUnsavedFile() {
    this(clangjavaJNI.new_CXUnsavedFile(), true);
  }

}
