package st.bug.clang;

import st.bug.clang.swig.SWIGTYPE_p_CXCursorSetImpl;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class CursorSet implements Disposable {

	private SWIGTYPE_p_CXCursorSetImpl me;

	public CursorSet() {
		me = Clang.createCXCursorSet();
	}

	@Override
	public void dispose() {
		Clang.disposeCXCursorSet(me);
	}

	public boolean contains(Cursor x) {
		return Clang.CXCursorSet_contains(me, x.me) != 0;
	}

	public boolean insert(Cursor x) {
		return Clang.CXCursorSet_insert(me, x.me) != 0;
	}
}
