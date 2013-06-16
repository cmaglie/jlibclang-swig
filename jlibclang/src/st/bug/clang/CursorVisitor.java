package st.bug.clang;

import st.bug.clang.swig.CXChildVisitResult;

public interface CursorVisitor {

	public abstract CXChildVisitResult visit(Cursor cursor, Cursor parent);

}
