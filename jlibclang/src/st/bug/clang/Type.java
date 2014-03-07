package st.bug.clang;

import st.bug.clang.swig.CXCallingConv;
import st.bug.clang.swig.CXType;
import st.bug.clang.swig.CXTypeKind;
import st.bug.clang.swig.CXTypeLayoutError;
import st.bug.clang.wrappers.Clang;

public class Type {

	private CXType me;

	public Type(CXType cursorType) {
		me = cursorType;
	}

	public String getSpelling() {
		return Clang.getStringAndDispose(Clang.getTypeSpelling(me));
	}

	public boolean equals(Type x) {
		return Clang.equalTypes(me, x.me) != 0;
	}

	public static boolean equals(Type x, Type y) {
		return x.equals(y);
	}

	public Type getCanonicalType() {
		return new Type(Clang.getCanonicalType(me));
	}

	public boolean isConstQualified() {
		return Clang.isConstQualifiedType(me) != 0;
	}

	public boolean isVolatileQualified() {
		return Clang.isVolatileQualifiedType(me) != 0;
	}

	public boolean isRestrictQualifiedType() {
		return Clang.isRestrictQualifiedType(me) != 0;
	}

	public Type getPointeeType() {
		return new Type(Clang.getPointeeType(me));
	}

	public Cursor getTypeDeclaration() {
		return new Cursor(Clang.getTypeDeclaration(me));
	}

	public String getTypeKindSpelling(CXTypeKind kind) {
		return Clang.getStringAndDispose(Clang.getTypeKindSpelling(kind));
	}

	public CXCallingConv getFunctionTypeCallingConv() {
		return Clang.getFunctionTypeCallingConv(me);
	}

	public Type getResultType() {
		return new Type(Clang.getResultType(me));
	}

	public int getNumArgTypes() {
		return Clang.getNumArgTypes(me);
	}

	public Type getArgType(int index) {
		return new Type(Clang.getArgType(me, index));
	}

	public boolean isFunctionTypeVariadic() {
		return Clang.isFunctionTypeVariadic(me) != 0;
	}

	public boolean isPODType() {
		return Clang.isPODType(me) != 0;
	}

	public Type getElementType() {
		return new Type(Clang.getElementType(me));
	}

	public long getNumElements() {
		return Clang.getNumElements(me);
	}

	public Type getArrayElementType() {
		return new Type(Clang.getArrayElementType(me));
	}

	public long getArraySize() {
		return Clang.getArraySize(me);
	}

	public CXTypeLayoutError getAlignOf() {
		long v = Clang.Type_getAlignOf(me);
		return CXTypeLayoutError.swigToEnum((int) v);
	}

	public CXTypeLayoutError getSizeOf() {
		long v = Clang.Type_getSizeOf(me);
		return CXTypeLayoutError.swigToEnum((int) v);
	}

	public CXTypeLayoutError getOffsetOf(String field) {
		long v = Clang.Type_getOffsetOf(me, field);
		return CXTypeLayoutError.swigToEnum((int) v);
	}

	@Override
	public String toString() {
		return getSpelling();
	}
}
