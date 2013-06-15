package st.bug.clang;

import st.bug.clang.swig.CXCursor;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class OverriddenCursors implements Disposable {

	private CXCursor cursors;
	private long size;

	public OverriddenCursors(CXCursor cxCursor_p_p_value, long num_overridden) {
		cursors = cxCursor_p_p_value;
		size = num_overridden;
	}

	public Cursor get(int index) {
		return new Cursor(Clang.CXCursorArray_getitem(cursors, index));
	}

	public long size() {
		return size;
	}

	@Override
	public void dispose() {
		Clang.disposeOverriddenCursors(cursors);
	}

}
