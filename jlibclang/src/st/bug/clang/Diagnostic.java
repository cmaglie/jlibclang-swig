package st.bug.clang;

import st.bug.clang.swig.CXDiagnosticSeverity;
import st.bug.clang.swig.CXSourceLocation;
import st.bug.clang.swig.CXSourceRange;
import st.bug.clang.swig.CXString;
import st.bug.clang.swig.SWIGTYPE_p_void;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class Diagnostic implements Disposable {

	SWIGTYPE_p_void me;

	public Diagnostic(SWIGTYPE_p_void me) {
		this.me = me;
	}

	@Override
	public void dispose() {
		Clang.disposeDiagnostic(me);
	}

	public SourceLocation getLocation() {
		CXSourceLocation dl = Clang.getDiagnosticLocation(me);
		return new SourceLocation(dl);
	}

	public CXDiagnosticSeverity getSeverity() {
		return Clang.getDiagnosticSeverity(me);
	}

	public DiagnosticSet getChildDiagnostics() {
		SWIGTYPE_p_void set = Clang.getChildDiagnostics(me);
		return new DiagnosticSet(set);
	}

	public String format() {
		return format(0);
	}

	public String format(long options) {
		return Clang.getStringAndDispose(Clang.formatDiagnostic(me, options));
	}

	public long getDefaultDisplayOptions() {
		return Clang.defaultDiagnosticDisplayOptions();
	}

	public String getSpelling() {
		return Clang.getStringAndDispose(Clang.getDiagnosticSpelling(me));
	}

	public String getOption() {
		return Clang.getStringAndDispose(Clang.getDiagnosticOption(me, null));
	}

	public String getOptionToDisable() {
		CXString disable = new CXString();
		CXString option = Clang.getDiagnosticOption(me, disable);
		Clang.disposeString(option);
		return Clang.getStringAndDispose(disable);
	}

	public long getCategory() {
		return Clang.getDiagnosticCategory(me);
	}

	public String getCategoryText() {
		return Clang.getStringAndDispose(Clang.getDiagnosticCategoryText(me));
	}

	public long getNumRanges() {
		return Clang.getDiagnosticNumRanges(me);
	}

	public SourceRange getRange(long index) {
		return new SourceRange(Clang.getDiagnosticRange(me, index));
	}

	public long getNumFixIts() {
		return Clang.getDiagnosticNumFixIts(me);
	}

	public DiagnosticFixIt getFixIt(long index) {
		CXSourceRange range = new CXSourceRange();
		CXString replacement = Clang.getDiagnosticFixIt(me, index, range);
		DiagnosticFixIt res = new DiagnosticFixIt();
		res.range = new SourceRange(range);
		res.replacement = Clang.getStringAndDispose(replacement);
		return res;
	}
	
}
