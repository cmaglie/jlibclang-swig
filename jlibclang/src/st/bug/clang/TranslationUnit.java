package st.bug.clang;

import java.io.File;

import st.bug.clang.swig.CXCodeCompleteResults;
import st.bug.clang.swig.CXFile_p;
import st.bug.clang.swig.CXUnsavedFile;
import st.bug.clang.swig.SWIGTYPE_p_CXTranslationUnitImpl;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class TranslationUnit implements Disposable {

	private SWIGTYPE_p_CXTranslationUnitImpl me;

	protected TranslationUnit(SWIGTYPE_p_CXTranslationUnitImpl unit) {
		me = unit;
	}

	public TranslationUnit(Index index, File source, String[] args) {
		long numUnsavedFiles = 0;
		CXUnsavedFile unsavedFiles = null;
		me = Clang.createTranslationUnitFromSourceFile(index.me,
				source.getAbsolutePath(), args.length, args, numUnsavedFiles,
				unsavedFiles);
	}

	@Override
	public void dispose() {
		Clang.disposeTranslationUnit(me);
	}

	public long getNumDiagnostics() {
		return Clang.getNumDiagnostics(me);
	}

	public Diagnostic getDiagnostic(int i) {
		return new Diagnostic(Clang.getDiagnostic(me, i));
	}

	public DiagnosticSet getDiagnosticSet() {
		return new DiagnosticSet(Clang.getDiagnosticSetFromTU(me));
	}

	public boolean isFileMultipleIncludeGuarded(SourceFile file) {
		return Clang.isFileMultipleIncludeGuarded(me, file.me) != 0;
	}

	public CodeCompleteResults codeCompleteAt(String filename, long line,
			long column) {
		CXUnsavedFile unsaved_files = null;
		long options = getDefaultCodeCompleteOptions();
		CXCodeCompleteResults results = Clang.codeCompleteAt(me, filename,
				line, column, unsaved_files, 0, options);
		if (results == null)
			return null;
		return new CodeCompleteResults(results);
	}

	public static long getDefaultCodeCompleteOptions() {
		return Clang.defaultCodeCompleteOptions();
	}

	public SourceLocation getLocation(SourceFile sourceFile, long line,
			long column) {
		return new SourceLocation(Clang.getLocation(me, sourceFile.me, line,
				column));
	}

	public SourceLocation getLocationForOffset(SourceFile sourceFile,
			long offset) {
		return new SourceLocation(Clang.getLocationForOffset(me, sourceFile.me,
				offset));
	}

	public SourceFile getFile(String filename) {
		CXFile_p fp = new CXFile_p();
		fp.assign(Clang.getFile(me, filename));
		return new SourceFile(fp);
	}

	public String getSpelling() {
		return Clang.getStringAndDispose(Clang.getTranslationUnitSpelling(me));
	}
}
