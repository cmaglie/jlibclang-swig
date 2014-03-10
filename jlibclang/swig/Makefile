clean:
	rm -f ../src/st/bug/clang/swig/*

swig:
	$(SWIG) -I${CLANG_INCLUDE_FOLDER} -java -outdir ../src/st/bug/clang/swig/ -package st.bug.clang.swig clangjava.i

compile_mac:
	gcc -g -fpic -c clangjava_wrap.c -I/Developer/SDKs/MacOSX10.6.sdk/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers -I. -pthread
	gcc -g -shared clangjava_wrap.o ../lib/libclang.dylib -o libclangjava.dylib -pthread

install_mac:
	cp libclangjava.dylib ../lib/

compile_linux:
	gcc -g -fpic -c clangjava_wrap.c -I${JAVA_INCLUDE} -I${JAVA_INCLUDE}/linux -I${CLANG_INCLUDE_FOLDER} -I. -pthread
	gcc -g -shared clangjava_wrap.o ${CLANG_LIB_FOLDER}/libclang.so -o libclangjava.so -pthread

install_linux:
	cp libclangjava.so ../lib/

mac: clean swig compile_mac install_mac

linux: clean swig compile_linux install_linux

