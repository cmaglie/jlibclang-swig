package st.bug.clang;

import st.bug.clang.swig.CXCompletionResult;
import st.bug.clang.swig.CXCursorKind;

public class CodeCompletionResult {

	private CXCompletionResult me;

	public CodeCompletionResult(CXCompletionResult result) {
		me = result;
	}

	public CXCursorKind getCursorKind() {
		return me.getCursorKind();
	}

	public CompletionString getCompletionString() {
		return new CompletionString(me.getCompletionString());
	}
}
