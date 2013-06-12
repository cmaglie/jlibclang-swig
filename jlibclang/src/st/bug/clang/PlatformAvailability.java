package st.bug.clang;

import st.bug.clang.swig.CXPlatformAvailability;
import st.bug.clang.wrappers.Clang;
import st.bug.clang.wrappers.Disposable;

public class PlatformAvailability implements Disposable {

	private CXPlatformAvailability me;

	public PlatformAvailability(CXPlatformAvailability platformAvailability) {
		me = platformAvailability;
	}

	@Override
	public void dispose() {
		Clang.disposeCXPlatformAvailability(me);
	}

}
