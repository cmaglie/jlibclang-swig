package st.bug.clang;

import java.io.File;

import st.bug.clang.swig.CXCodeCompleteResults;
import st.bug.clang.swig.CXCursor;
import st.bug.clang.swig.CXFile_p;
import st.bug.clang.swig.CXSaveError;
import st.bug.clang.swig.CXUnsavedFile;
import st.bug.clang.swig.SWIGTYPE_p_CXTranslationUnitImpl;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class TranslationUnit implements Disposable {

	private SWIGTYPE_p_CXTranslationUnitImpl me;

	protected TranslationUnit(SWIGTYPE_p_CXTranslationUnitImpl unit) {
		me = unit;
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
		return new SourceFile(Clang.getFile(me, filename));
	}

	public String getSpelling() {
		return Clang.getStringAndDispose(Clang.getTranslationUnitSpelling(me));
	}

	public long defaultEditingTranslationUnitOptions() {
		return Clang.defaultEditingTranslationUnitOptions();
	}

	public long defaultSaveOptions() {
		return Clang.defaultSaveOptions(me);
	}

	public CXSaveError save(File file, long options) {
		int res = Clang
				.saveTranslationUnit(me, file.getAbsolutePath(), options);
		return CXSaveError.swigToEnum(res);
	}

	public long defaultReparseOptions() {
		return Clang.defaultReparseOptions(me);
	}

	public boolean reparse(long options) {
		long numUnsavedFiles = 0;
		CXUnsavedFile unsavedFiles = null;
		return Clang.reparseTranslationUnit(me, numUnsavedFiles, unsavedFiles,
				options) == 0;
	}

	public Cursor getCursor() {
		return new Cursor(Clang.getTranslationUnitCursor(me));
	}
	
	public Cursor getCursor(SourceLocation location) {
		return new Cursor(Clang.getCursor(me, location.me));
	}
}
