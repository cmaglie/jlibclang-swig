#!/bin/bash -ex

if [[ ! -f llvm-3.4.src.tar.gz ]] ;
then
	wget --continue http://llvm.org/releases/3.4/llvm-3.4.src.tar.gz
fi

tar xfzv llvm-3.4.src.tar.gz

if [[ ! -f clang-3.4.src.tar.gz ]] ;
then
	wget --continue http://llvm.org/releases/3.4/clang-3.4.src.tar.gz
fi

tar xfzv clang-3.4.src.tar.gz

mv clang-3.4 llvm-3.4/tools/clang

mkdir -p objdir
cd objdir
PREFIX=`pwd`
cd -

mkdir -p llvm-build
cd llvm-build

CONFARGS=" \
	--prefix=$PREFIX \
	--enable-optimized \
	--enable-assertions"

CFLAGS="-w -O2 -g0 $CFLAGS" CXXFLAGS="-w -O2 -g0 $CXXFLAGS" LDFLAGS="-s $LDFLAGS" ../llvm-3.4/configure $CONFARGS

if [ -z "$MAKE_JOBS" ]; then
	MAKE_JOBS="2"
fi

nice -n 10 make -j $MAKE_JOBS

make install

