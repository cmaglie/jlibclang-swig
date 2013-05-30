package st.bug.clang.wrappers;

public interface Disposable {

	/**
	 * Deallocate resources used by the underlying native object
	 */
	public void dispose();

}
