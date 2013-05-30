package st.bug.clang;

import st.bug.clang.swig.CXFile_p;
import st.bug.clang.swig.CXSourceLocation;
import st.bug.clang.swig.CXSourceRange;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class SourceLocation implements Disposable {

	private CXSourceLocation me;

	public SourceLocation() {
		me = Clang.getNullLocation();
	}

	public SourceLocation(CXSourceLocation location) {
		me = location;
	}

	@Override
	public void dispose() {
		me.delete();
	}

	public FilePosition getExpansionLocation() {
		long[] line = new long[1];
		long[] column = new long[1];
		long[] offset = new long[1];
		CXFile_p file = new CXFile_p();

		Clang.getExpansionLocation(me, file, line, column, offset);

		FilePosition res = new FilePosition();
		res.file = new SourceFile(file);
		res.line = line[0];
		res.column = column[0];
		res.offset = offset[0];
		return res;
	}

	public FilePosition getInstantiationLocation() {
		long[] line = new long[1];
		long[] column = new long[1];
		long[] offset = new long[1];
		CXFile_p file = new CXFile_p();

		Clang.getInstantiationLocation(me, file, line, column, offset);

		FilePosition res = new FilePosition();
		res.file = new SourceFile(file);
		res.line = line[0];
		res.column = column[0];
		res.offset = offset[0];
		return res;
	}

	public FilePosition getSpellingLocation() {
		long[] line = new long[1];
		long[] column = new long[1];
		long[] offset = new long[1];
		CXFile_p file = new CXFile_p();

		Clang.getSpellingLocation(me, file, line, column, offset);

		FilePosition res = new FilePosition();
		res.file = new SourceFile(file);
		res.line = line[0];
		res.column = column[0];
		res.offset = offset[0];
		return res;
	}

	public FilePosition getFileLocation() {
		long[] line = new long[1];
		long[] column = new long[1];
		long[] offset = new long[1];
		CXFile_p file = new CXFile_p();

		Clang.getFileLocation(me, file, line, column, offset);

		FilePosition res = new FilePosition();
		res.file = new SourceFile(file);
		res.line = line[0];
		res.column = column[0];
		res.offset = offset[0];
		return res;
	}

	public FilePosition getPresumedLocation() {
		throw new RuntimeException("Uninmplemented method getPresumedLocation!");
	}

	public boolean isInSystemHeader() {
		return Clang.Location_isInSystemHeader(me) != 0;
	}

	public boolean equals(SourceLocation y) {
		return equals(this, y);
	}

	public static boolean equals(SourceLocation x, SourceLocation y) {
		return Clang.equalLocations(x.me, y.me) != 0;
	}

	public SourceRange rangeTo(SourceLocation y) {
		return range(this, y);
	}

	public static SourceRange range(SourceLocation x, SourceLocation y) {
		CXSourceRange range = Clang.getRange(x.me, y.me);
		return new SourceRange(range);
	}

}
