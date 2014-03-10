#!/bin/bash -ex

if [ -z "$JAVA" ]; then
	JAVA=`which java`
	JAVA=`readlink -e $JAVA`
fi
if [ -z "$JAVAC" ]; then
	JAVAC=`which javac`
	JAVAC=`readlink -e $JAVAC`
fi
if [ -z "$JAVA_INCLUDE" ]; then
	JAVA_INCLUDE=`dirname $JAVAC`
	JAVA_INCLUDE=`readlink -e $JAVA_INCLUDE/../include`
fi

SWIG=`readlink -e objdir/bin/swig`
CLANG_LIB_FOLDER=`readlink -e objdir/lib`
CLANG_INCLUDE_FOLDER=`readlink -e objdir/include`

cd jlibclang/swig

make clean

JAVA_INCLUDE="$JAVA_INCLUDE" SWIG="$SWIG" CLANG_LIB_FOLDER="$CLANG_LIB_FOLDER" CLANG_INCLUDE_FOLDER="$CLANG_INCLUDE_FOLDER" nice -n 10 make -j 1 linux

