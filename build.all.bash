#!/bin/bash -ex

rm -rf objdir

./clean.bash
./llvm.build.bash
./clean.bash
./swig.build.bash
./clean.bash
./jlibclang.build.bash
./clean.bash

