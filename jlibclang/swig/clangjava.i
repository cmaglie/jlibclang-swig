
%module clangjava
%{
/* Includes headers in the wrapper code */
#include "clang-c/Index.h"
#include "clang-c/CXCompilationDatabase.h"
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

/* Parse the headers file to generate wrappers */
%include "clang-c/Platform.h"
%include "clang-c/CXString.h"
%include "clang-c/Index.h"
%include "clang-c/CXCompilationDatabase.h"
