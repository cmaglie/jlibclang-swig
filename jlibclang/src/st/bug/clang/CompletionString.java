package st.bug.clang;

import st.bug.clang.swig.CXAvailabilityKind;
import st.bug.clang.swig.CXCompletionChunkKind;
import st.bug.clang.swig.SWIGTYPE_p_void;
import st.bug.clang.wrappers.Clang;

public class CompletionString {

	private SWIGTYPE_p_void me;

	public CompletionString(SWIGTYPE_p_void completionString) {
		me = completionString;
	}

	public String getAnnotation(long index) {
		return Clang.getStringAndDispose(Clang.getCompletionAnnotation(me,
				index));
	}

	public long getNumAnnotations() {
		return Clang.getCompletionNumAnnotations(me);
	}

	public CXAvailabilityKind getAvailablity() {
		return Clang.getCompletionAvailability(me);
	}

	public String getBriefComment() {
		return Clang.getStringAndDispose(Clang.getCompletionBriefComment(me));
	}

	public long getNumChunks() {
		return Clang.getNumCompletionChunks(me);
	}

	public CompletionString getChunkCompletionString(long index) {
		SWIGTYPE_p_void completionString = Clang
				.getCompletionChunkCompletionString(me, index);
		return new CompletionString(completionString);
	}

	public CXCompletionChunkKind getChunkKind(long index) {
		return Clang.getCompletionChunkKind(me, index);
	}

	public String getChunkText(long index) {
		return Clang.getStringAndDispose(Clang
				.getCompletionChunkText(me, index));
	}

	public String getParent() {
		return Clang.getStringAndDispose(Clang.getCompletionParent(me, null));
	}

	public long getPriority() {
		return Clang.getCompletionPriority(me);
	}

}
