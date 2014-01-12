package st.bug.clang;

import java.math.BigInteger;

import st.bug.clang.swig.CXCodeCompleteResults;
import st.bug.clang.swig.CXCompletionResult;
import st.bug.clang.swig.CXCursorKind;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class CodeCompleteResults implements Disposable {

	private CXCodeCompleteResults me;

	protected CodeCompleteResults(CXCodeCompleteResults results) {
		me = results;
	}

	@Override
	public void dispose() {
		Clang.disposeCodeCompleteResults(me);
	}

	public CXCursorKind getContainerKind() {
		long[] incomplete = new long[1];
		return Clang.codeCompleteGetContainerKind(me, incomplete);
	}

	public boolean isContainerKindIncomplete() {
		long[] incomplete = new long[1];
		Clang.codeCompleteGetContainerKind(me, incomplete);
		return incomplete[0] != 0;
	}

	public String getContainerUSR() {
		return Clang.getStringAndDispose(Clang.codeCompleteGetContainerUSR(me));
	}

	public BigInteger getContexts() {
		return Clang.codeCompleteGetContexts(me);
	}

	public Diagnostic getDiagnostic(long index) {
		return new Diagnostic(Clang.codeCompleteGetDiagnostic(me, index));
	}

	public long getNumDiagnostics() {
		return Clang.codeCompleteGetNumDiagnostics(me);
	}

	public String getObjCSelector() {
		return Clang.getStringAndDispose(Clang.codeCompleteGetObjCSelector(me));
	}

	public long getNumResults() {
		return me.getNumResults();
	}

	public CodeCompletionResult getResult(int index) {
		CXCompletionResult result = Clang.CXCompletionResultArray_getitem(
				me.getResults(), index);
		return new CodeCompletionResult(result);
	}

	public void sort() {
		Clang.sortCodeCompletionResults(me.getResults(), getNumResults());
	}
}
