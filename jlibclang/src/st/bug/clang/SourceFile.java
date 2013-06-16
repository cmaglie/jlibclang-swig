package st.bug.clang;

import java.io.File;
import java.util.Date;

import st.bug.clang.swig.CXFileUniqueID;
import st.bug.clang.swig.CXFile_p;
import st.bug.clang.swig.SWIGTYPE_p_void;
import st.bug.clang.wrappers.Clang;

public class SourceFile {

	SWIGTYPE_p_void me;

	public SourceFile(CXFile_p file) {
		me = file.value();
	}

	public SourceFile(SWIGTYPE_p_void file) {
		CXFile_p fp = new CXFile_p();
		fp.assign(file);
		me = fp.value();
	}

	public String getName() {
		return Clang.getStringAndDispose(Clang.getFileName(me));
	}

	public Date getFileTime() {
		long t = Clang.getFileTime(me);
		return new Date(t * 1000);
	}

	public File getFile() {
		if (getName() == null)
			return null;
		return new File(getName());
	}

	public boolean isMultipleIncludeGuarded(TranslationUnit unit) {
		return unit.isFileMultipleIncludeGuarded(this);
	}

	public SourceFileUniqueID getUniqueID() {
		CXFileUniqueID outID = new CXFileUniqueID();
		Clang.getFileUniqueID(me, outID);
		return new SourceFileUniqueID(outID);
	}

	@Override
	public String toString() {
		return getName();
	}
}
