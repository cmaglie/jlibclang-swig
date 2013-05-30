package st.bug.clang;

public class FilePosition {

	public SourceFile file;
	public long line;
	public long column;
	public long offset;

	@Override
	public String toString() {
		return file + ": " + line + ":" + column + " (offset " + offset + ")";
	}
}
