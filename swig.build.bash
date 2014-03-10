#!/bin/bash -ex

if [[ ! -f swig-2.0.12.tar.gz ]] ;
then
	wget --continue http://skylink.dl.sourceforge.net/project/swig/swig/swig-2.0.12/swig-2.0.12.tar.gz
fi

tar xfzv swig-2.0.12.tar.gz

mkdir -p objdir
cd objdir
PREFIX=`pwd`
cd -

mkdir -p swig-build
cd swig-build

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

CONFARGS=" \
	--prefix=$PREFIX \
	--without-alllang \
	--with-java=$JAVA \
	--with-javaincl=$JAVA_INCLUDE"

CFLAGS="-w -O2 -g0 $CFLAGS" CXXFLAGS="-w -O2 -g0 $CXXFLAGS" LDFLAGS="-s $LDFLAGS" ../swig-2.0.12/configure $CONFARGS

if [ -z "$MAKE_JOBS" ]; then
	MAKE_JOBS="2"
fi

nice -n 10 make -j $MAKE_JOBS

make install

