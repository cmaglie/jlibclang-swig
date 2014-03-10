
%module clangjava
%{
/* Includes headers in the wrapper code */
#include <clang-c/Index.h>
#include <clang-c/CXCompilationDatabase.h>
%}

%include typemaps.i
%include various.i

/* Convert some arguments array into String[] */
%apply char **STRING_ARRAY { const char * const * };

/* Some output parameters are signed as "unsigned *" */
%apply unsigned int *OUTPUT { unsigned * };
/* Assign specific output parameters */
%apply unsigned int *OUTPUT { int *always_deprecated };
%apply unsigned int *OUTPUT { int *always_unavailable };

/* CXFile is an opaque type */
%include cpointer.i
%pointer_class(CXFile, CXFile_p);

/* Some functions needs unbounded array */
%include "carrays.i"
%array_functions(CXCompletionResult, CXCompletionResultArray)
%array_functions(CXPlatformAvailability, CXPlatformAvailabilityArray)
%array_functions(CXCursor, CXCursorArray)
%pointer_functions(CXCursor *, CXCursor_p_p);

/* time_t java mapping */
%apply long long { time_t }

/* Strip all "clang_" prefix from libclang functions */
%rename("%(strip:[clang_])s") "";

/* Create real Java enums */
%include "enums.swg"

/* Force the generated Java code to use the C enum values directly rather than making a JNI call */
%javaconst(1);
%javaconst(0) CXGlobalOpt_ThreadBackgroundPriorityForAll;

/* Callback for clang_visitCursor(..) */
/* see: http://stackoverflow.com/questions/12210129/how-should-i-write-the-i-file-to-wrap-callbacks-in-java-or-c-sharp */
%{
struct CXCursorVisitor_cb_data {
  JNIEnv *env;
  jobject obj;
};
enum CXChildVisitResult CXCursorVisitor_cb(CXCursor cursor, CXCursor parent, CXClientData ptr) {
  struct CXCursorVisitor_cb_data *data = ptr;
  JNIEnv *env = data->env;

  // Create cursor objects
  const jclass cursorClass = (*env)->FindClass(env, "st/bug/clang/swig/CXCursor");
  const jmethodID constructor = (*env)->GetMethodID(env, cursorClass, "<init>", "(JZ)V");
  jlong cursorArg;
  jlong parentArg;
  *(CXCursor **)&cursorArg = &cursor;
  *(CXCursor **)&parentArg = &parent;
  jboolean falseArg = (jboolean)0;
  jobject cursorCursor = (*env)->NewObject(env, cursorClass, constructor, cursorArg, falseArg);
  jobject parentCursor = (*env)->NewObject(env, cursorClass, constructor, parentArg, falseArg);

  // Run visit callback
  jclass visitorClass = (*env)->FindClass(env, "st/bug/clang/wrappers/CursorVisitorWrapper");
  jmethodID meth = (*env)->GetMethodID(env, visitorClass, "visit", "(Lst/bug/clang/swig/CXCursor;Lst/bug/clang/swig/CXCursor;)I");
  jint res = (*env)->CallIntMethod(env, data->obj, meth, cursorCursor, parentCursor);
  return res;
}
%}
%typemap(jstype) CXCursorVisitor "st.bug.clang.wrappers.CursorVisitorWrapper"
%typemap(jtype) CXCursorVisitor "st.bug.clang.wrappers.CursorVisitorWrapper"
%typemap(jni) CXCursorVisitor "jobject"
%typemap(javain) CXCursorVisitor "$javainput"
%typemap(in, numinputs=1) (CXCursorVisitor visitor, CXClientData client_data) {
  struct CXCursorVisitor_cb_data *data = malloc(sizeof *data);
  data->env = jenv;
  data->obj = $input;
  $1 = CXCursorVisitor_cb;
  $2 = data;
}

/* Parse the headers file to generate wrappers */
%include <clang-c/Platform.h>
%include <clang-c/CXString.h>
%include <clang-c/Index.h>
%include <clang-c/CXCompilationDatabase.h>

