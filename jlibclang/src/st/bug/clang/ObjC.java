package st.bug.clang;

import st.bug.clang.swig.CXString;
import st.bug.clang.wrappers.Clang;

public class ObjC {

	public static String constructUSR_ObjCClass(String className) {
		return Clang.getStringAndDispose(Clang
				.constructUSR_ObjCClass(className));
	}

	public static String constructUSR_ObjCCategory(String className,
			String categoryName) {
		return Clang.getStringAndDispose(Clang.constructUSR_ObjCCategory(
				className, categoryName));
	}

	public static String constructUSR_ObjCProtocol(String protocolName) {
		return Clang.getStringAndDispose(Clang
				.constructUSR_ObjCProtocol(protocolName));
	}

	public static String constructUSR_ObjCIvar(String name, CXString classUSR) {
		return Clang.getStringAndDispose(Clang.constructUSR_ObjCIvar(name,
				classUSR));
	}

	public static String constructUSR_ObjCMethod(String name,
			boolean isInstanceMethod, CXString classUSR) {
		return Clang.getStringAndDispose(Clang.constructUSR_ObjCMethod(name,
				isInstanceMethod ? 1 : 0, classUSR));
	}

	public static String constructUSR_ObjCProperty(String property,
			CXString classUSR) {
		return Clang.getStringAndDispose(Clang.constructUSR_ObjCProperty(
				property, classUSR));
	}
}
