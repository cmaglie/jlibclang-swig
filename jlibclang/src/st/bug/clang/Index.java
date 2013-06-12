package st.bug.clang;

import java.io.File;

import st.bug.clang.swig.CXUnsavedFile;
import st.bug.clang.swig.SWIGTYPE_p_CXTranslationUnitImpl;
import st.bug.clang.swig.SWIGTYPE_p_void;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class Index implements Disposable {

	SWIGTYPE_p_void me;

	public Index(SWIGTYPE_p_void index) {
		me = index;
	}

	public static Index create() {
		return create(false, false);
	}

	public static Index create(boolean excludeDeclarationsFromPCH,
			boolean displayDiagnostics) {
		SWIGTYPE_p_void index = Clang.createIndex(
				excludeDeclarationsFromPCH ? 1 : 0, displayDiagnostics ? 1 : 0);
		return new Index(index);
	}

	@Override
	public void dispose() {
		Clang.disposeIndex(me);
	}

	public TranslationUnit parseTranslationUnit(File source, String[] args,
			long options) {
		CXUnsavedFile unsaved_files = null;
		long num_unsaved_files = 0;
		SWIGTYPE_p_CXTranslationUnitImpl tu = Clang.parseTranslationUnit(me,
				source == null ? null : source.getAbsolutePath(), args,
				args.length, unsaved_files, num_unsaved_files, options);
		return new TranslationUnit(tu);
	}

	public TranslationUnit parseTranslationUnit(String[] args) {
		return parseTranslationUnit(null, args, 0);
	}

	public TranslationUnit createTranslationUnitFromSourceFile(File source,
			String[] args) {
		CXUnsavedFile unsavedFiles = null;
		long numUnsavedFiles = 0;
		return new TranslationUnit(Clang.createTranslationUnitFromSourceFile(
				me, source.getAbsolutePath(), args.length, args,
				numUnsavedFiles, unsavedFiles));
	}

}
