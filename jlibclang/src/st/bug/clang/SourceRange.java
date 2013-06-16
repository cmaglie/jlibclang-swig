package st.bug.clang;

import st.bug.clang.swig.CXSourceRange;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class SourceRange implements Disposable {

	private CXSourceRange me;

	public SourceRange() {
		me = Clang.getNullRange();
	}

	public SourceRange(CXSourceRange range) {
		me = range;
	}

	@Override
	public void dispose() {
		me.delete();
	}

	public SourceLocation getStart() {
		return new SourceLocation(Clang.getRangeStart(me));
	}

	public SourceLocation getEnd() {
		return new SourceLocation(Clang.getRangeEnd(me));
	}

	public boolean equals(SourceRange y) {
		return equals(this, y);
	}

	public boolean isNull() {
		return isNull(this);
	}

	public static boolean isNull(SourceRange x) {
		return Clang.Range_isNull(x.me) != 0;
	}

	public static boolean equals(SourceRange x, SourceRange y) {
		return Clang.equalRanges(x.me, y.me) != 0;
	}

	@Override
	public String toString() {
		return "SourceRange: [" + getStart() + " - " + getEnd() + "]";
	}
}
