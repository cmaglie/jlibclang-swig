package st.bug.clang.wrappers;

import st.bug.clang.Cursor;
import st.bug.clang.CursorVisitor;
import st.bug.clang.swig.CXChildVisitResult;
import st.bug.clang.swig.CXCursor;

public class CursorVisitorWrapper {

	private CursorVisitor me;

	public CursorVisitorWrapper(CursorVisitor visitor) {
		me = visitor;
	}

	public int visit(CXCursor cursor, CXCursor parent) {
		CXChildVisitResult res = me.visit(new Cursor(cursor),
				new Cursor(parent));
		return res.swigValue();
	}

}
