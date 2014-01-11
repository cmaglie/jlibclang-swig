
JAVA6_INCLUDE=/usr/lib/jvm/java-6-sun/include
CLANG_LIB_FOLDER=../lib/

clean:
	rm -f ../src/st/bug/clang/swig/*

swig:
	swig -java -outdir ../src/st/bug/clang/swig/ -package st.bug.clang.swig clangjava.i

compile_mac:
	gcc -g -fpic -c clangjava_wrap.c -I/Developer/SDKs/MacOSX10.6.sdk/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers -I. -pthread
	gcc -g -shared clangjava_wrap.o ../lib/libclang.dylib -o libclangjava.dylib -pthread

install_mac:
	cp libclangjava.dylib ../lib/

compile_linux:
	gcc -g -fpic -c clangjava_wrap.c -I${JAVA6_INCLUDE} -I${JAVA6_INCLUDE}/linux -I. -pthread
	gcc -g -shared clangjava_wrap.o ${CLANG_LIB_FOLDER}/libclang.so -o libclangjava.so -pthread

install_linux:
	cp libclangjava.so ../lib/

mac: clean swig compile_mac install_mac

linux: clean swig compile_linux install_linux
