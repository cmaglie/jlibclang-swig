package st.bug.clang.wrappers;

import st.bug.clang.swig.CXFile_p;
import st.bug.clang.swig.CXSourceLocation;
import st.bug.clang.swig.CXString;
import st.bug.clang.swig.clangjava;

public class Clang extends clangjava {

	// CXFile helper methods
	public static CXString getFileName(CXFile_p file) {
		return getFileName(file.value());
	}

	// CXSourceLocation helper methods
	public static void getExpansionLocation(CXSourceLocation location,
			CXFile_p file, long[] line, long[] column, long[] offset) {
		getExpansionLocation(location, file.cast(), line, column, offset);
	}

	public static void getInstantiationLocation(CXSourceLocation location,
			CXFile_p file, long[] line, long[] column, long[] offset) {
		getInstantiationLocation(location, file.cast(), line, column, offset);
	}

	public static void getSpellingLocation(CXSourceLocation location,
			CXFile_p file, long[] line, long[] column, long[] offset) {
		getSpellingLocation(location, file.cast(), line, column, offset);
	}

	public static void getFileLocation(CXSourceLocation location,
			CXFile_p file, long[] line, long[] column, long[] offset) {
		getFileLocation(location, file.cast(), line, column, offset);
	}

	public static String getStringAndDispose(CXString cxstring) {
		String res = Clang.getCString(cxstring);
		Clang.disposeString(cxstring);
		return res;
	}
}
