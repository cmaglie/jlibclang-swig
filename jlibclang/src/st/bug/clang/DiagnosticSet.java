package st.bug.clang;

import java.util.Iterator;

import st.bug.clang.swig.SWIGTYPE_p_void;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class DiagnosticSet implements Disposable, Iterable<Diagnostic> {

	private SWIGTYPE_p_void me;

	public DiagnosticSet(SWIGTYPE_p_void set) {
		me = set;
	}

	@Override
	public void dispose() {
		Clang.disposeDiagnosticSet(me);
	}

	public long size() {
		return getNumDiagnostics();
	}

	public long getNumDiagnostics() {
		return Clang.getNumDiagnosticsInSet(me);
	}

	public Diagnostic get(long index) {
		return getDiagnostic(index);
	}

	public Diagnostic getDiagnostic(long index) {
		return new Diagnostic(Clang.getDiagnosticInSet(me, index));
	}

	@Override
	public Iterator<Diagnostic> iterator() {
		return new Iterator<Diagnostic>() {
			int index = 0;

			@Override
			public void remove() {
				throw new RuntimeException("Method not implemented");
			}

			@Override
			public Diagnostic next() {
				return getDiagnostic(index++);
			}

			@Override
			public boolean hasNext() {
				return getNumDiagnostics() > index;
			}
		};
	}
	
	public DiagnosticSet getChildDiagnostics() {
		return new DiagnosticSet(Clang.getChildDiagnostics(me));
	}
}
