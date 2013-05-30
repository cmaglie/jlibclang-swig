package st.bug.clang;

import st.bug.clang.swig.CXCursor;
import st.bug.clang.swig.CXCursorKind;
import st.bug.clang.wrappers.Clang;

public class Cursor {

	private CXCursor me;

	public Cursor(CXCursor cursor) {
		me = cursor;
	}

	public CompletionString getCompletionString() {
		return new CompletionString(Clang.getCursorCompletionString(me));
	}

	public boolean CXXMethod_isPureVirtual() {
		return Clang.CXXMethod_isPureVirtual(me) != 0;
	}

	public boolean CXXMethod_isStatic() {
		return Clang.CXXMethod_isStatic(me) != 0;
	}

	public boolean CXXMethod_isVirtual() {
		return Clang.CXXMethod_isVirtual(me) != 0;
	}
	
	public CXCursorKind getTemplateCursorKind() {
		return Clang.getTemplateCursorKind(me);
	}
	
	public Cursor getSpecializedCursorTemplate() {
		return new Cursor(Clang.getSpecializedCursorTemplate(me));
	}
	
	public SourceRange getCursorReferenceNameRange(long nameFlags, long pieceIndex) {
		return new SourceRange(Clang.getCursorReferenceNameRange(me, nameFlags, pieceIndex));
	}
}
