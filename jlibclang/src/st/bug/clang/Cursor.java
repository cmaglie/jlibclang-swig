package st.bug.clang;

import java.math.BigInteger;

import st.bug.clang.swig.CXAvailabilityKind;
import st.bug.clang.swig.CXCursor;
import st.bug.clang.swig.CXCursorKind;
import st.bug.clang.swig.CXLanguageKind;
import st.bug.clang.swig.CXLinkageKind;
import st.bug.clang.swig.CXPlatformAvailability;
import st.bug.clang.swig.CXString;
import st.bug.clang.swig.CXTypeKind;
import st.bug.clang.swig.CX_CXXAccessSpecifier;
import st.bug.clang.swig.SWIGTYPE_p_p_CXCursor;
import st.bug.clang.wrappers.Clang;

public class Cursor {

	CXCursor me;

	public Cursor() {
		me = Clang.getNullCursor();
	}

	public Cursor(CXCursor cursor) {
		me = cursor;
	}

	public CompletionString getCompletionString() {
		return new CompletionString(Clang.getCursorCompletionString(me));
	}

	public boolean CXXMethodIsPureVirtual() {
		return Clang.CXXMethod_isPureVirtual(me) != 0;
	}

	public boolean CXXMethodIsStatic() {
		return Clang.CXXMethod_isStatic(me) != 0;
	}

	public boolean CXXMethodIsVirtual() {
		return Clang.CXXMethod_isVirtual(me) != 0;
	}

	public CXCursorKind getKind() {
		return Clang.getCursorKind(me);
	}

	public CXCursorKind getTemplateCursorKind() {
		return Clang.getTemplateCursorKind(me);
	}

	public Cursor getSpecializedCursorTemplate() {
		return new Cursor(Clang.getSpecializedCursorTemplate(me));
	}

	public SourceRange getReferenceNameRange(long nameFlags, long pieceIndex) {
		return new SourceRange(Clang.getCursorReferenceNameRange(me, nameFlags,
				pieceIndex));
	}

	public boolean equals(Cursor y) {
		return equals(this, y);
	}

	public static boolean equals(Cursor x, Cursor y) {
		return Clang.equalCursors(x.me, y.me) != 0;
	}

	public boolean isNull() {
		return Clang.Cursor_isNull(me) != 0;
	}

	public long hash() {
		return Clang.hashCursor(me);
	}

	public boolean isDeclaration() {
		return isDeclaration(getKind());
	}

	public static boolean isDeclaration(CXCursorKind kind) {
		return Clang.isDeclaration(kind) != 0;
	}

	public boolean isReference() {
		return isReference(getKind());
	}

	public static boolean isReference(CXCursorKind kind) {
		return Clang.isReference(kind) != 0;
	}

	public boolean isExpression() {
		return isExpression(getKind());
	}

	public static boolean isExpression(CXCursorKind kind) {
		return Clang.isExpression(kind) != 0;
	}

	public boolean isStatement() {
		return isStatement(getKind());
	}

	public static boolean isStatement(CXCursorKind kind) {
		return Clang.isStatement(kind) != 0;
	}

	public boolean isAttribute() {
		return isAttribute(getKind());
	}

	public static boolean isAttribute(CXCursorKind kind) {
		return Clang.isAttribute(kind) != 0;
	}

	public boolean isInvalid() {
		return isInvalid(getKind());
	}

	public static boolean isInvalid(CXCursorKind kind) {
		return Clang.isInvalid(kind) != 0;
	}

	public boolean isTranslationUnit() {
		return isTranslationUnit(getKind());
	}

	public static boolean isTranslationUnit(CXCursorKind kind) {
		return Clang.isTranslationUnit(kind) != 0;
	}

	public boolean isPreprocessing() {
		return isPreprocessing(getKind());
	}

	public static boolean isPreprocessing(CXCursorKind kind) {
		return Clang.isPreprocessing(kind) != 0;
	}

	public boolean isUnexposed() {
		return isUnexposed(getKind());
	}

	public static boolean isUnexposed(CXCursorKind kind) {
		return Clang.isUnexposed(kind) != 0;
	}

	public CXLinkageKind getLinkage() {
		return Clang.getCursorLinkage(me);
	}

	public CXAvailabilityKind getAvailablity() {
		return Clang.getCursorAvailability(me);
	}

	public PlatformAvailability[] getPlatformAvailability() {
		long[] alwaysDeprecated = new long[1];
		CXString deprecatedMessage = new CXString();
		long[] alwaysUnavailable = new long[1];
		CXString unavailableMessage = new CXString();
		int num = Clang.getCursorPlatformAvailability(me, alwaysDeprecated,
				deprecatedMessage, alwaysUnavailable, unavailableMessage, null,
				0);
		// alwaysDeprecated[0];
		Clang.getStringAndDispose(deprecatedMessage);
		// alwaysUnavailable[0];
		Clang.getStringAndDispose(unavailableMessage);

		CXPlatformAvailability availability = Clang
				.new_CXPlatformAvailabilityArray(num);
		Clang.getCursorPlatformAvailability(me, null, null, null, null,
				availability, num);
		PlatformAvailability res[] = new PlatformAvailability[num];
		for (int i = 0; i < num; i++)
			res[i] = new PlatformAvailability(
					Clang.CXPlatformAvailabilityArray_getitem(availability, i));
		Clang.delete_CXPlatformAvailabilityArray(availability);
		return res;
	}

	public CXLanguageKind getLanguage() {
		return Clang.getCursorLanguage(me);
	}

	public TranslationUnit getTranslationUnit() {
		return new TranslationUnit(Clang.Cursor_getTranslationUnit(me));
	}

	public Cursor getSemanticParent() {
		return new Cursor(Clang.getCursorSemanticParent(me));
	}

	public Cursor getLexicalParent() {
		return new Cursor(Clang.getCursorLexicalParent(me));
	}

	public OverriddenCursors getOverriddenCursors() {
		long[] num_overridden = new long[1];

		SWIGTYPE_p_p_CXCursor pointer = Clang.new_CXCursor_p_p();
		Clang.getOverriddenCursors(me, pointer, num_overridden);

		return new OverriddenCursors(Clang.CXCursor_p_p_value(pointer),
				num_overridden[0]);
	}

	public SourceFile getIncludedFile() {
		return new SourceFile(Clang.getIncludedFile(me));
	}

	public SourceLocation getLocation() {
		return new SourceLocation(Clang.getCursorLocation(me));
	}

	public SourceRange getExtent() {
		return new SourceRange(Clang.getCursorExtent(me));
	}

	public Type getType() {
		return new Type(Clang.getCursorType(me));
	}

	public Type getTypedefDeclUnderlyingType() {
		return new Type(Clang.getTypedefDeclUnderlyingType(me));
	}

	public Type getEnumDeclIntegerType() {
		return new Type(Clang.getEnumDeclIntegerType(me));
	}

	public long getEnumConstantDeclValue() {
		return Clang.getEnumConstantDeclValue(me);
	}

	public BigInteger getEnumConstantDeclUnsignedValue() {
		return Clang.getEnumConstantDeclUnsignedValue(me);
	}

	public int getFieldDeclBitWidth() {
		return Clang.getFieldDeclBitWidth(me);
	}

	public int getNumArguments() {
		return Clang.Cursor_getNumArguments(me);
	}

	public Cursor getArgument(int index) {
		return new Cursor(Clang.Cursor_getArgument(me, index));
	}

	public String getDeclObjCTypeEncoding() {
		return Clang.getStringAndDispose(Clang.getDeclObjCTypeEncoding(me));
	}

	public Type getResultType() {
		return new Type(Clang.getCursorResultType(me));
	}

	public boolean isBitField() {
		return Clang.Cursor_isBitField(me) != 0;
	}

	public boolean isVirtualBase() {
		return Clang.isVirtualBase(me) != 0;
	}

	public CX_CXXAccessSpecifier getCXXAccessSpecifier() {
		return Clang.getCXXAccessSpecifier(me);
	}

	public long getNumOverloadedDecls() {
		return Clang.getNumOverloadedDecls(me);
	}

	public Cursor getOverloadedDecl(int index) {
		return new Cursor(Clang.getOverloadedDecl(me, index));
	}

	public Type getIBOutletCollectionType() {
		return new Type(Clang.getIBOutletCollectionType(me));
	}
}
