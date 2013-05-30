
clean:
	rm -f ../src/st/bug/clang/swig/*

swig:
	swig -java -outdir ../src/st/bug/clang/swig/ -package st.bug.clang.swig clangjava.i

compile_mac:
	gcc -g -fpic -c clangjava_wrap.c -I/Developer/SDKs/MacOSX10.6.sdk/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers -I. -pthread
	gcc -g -shared clangjava_wrap.o ../lib/libclang.dylib -o libclangjava.dylib -pthread

compile_linux:
	gcc -g -fpic -c clangjava_wrap.c -I/usr/lib/jvm/java-6-sun/include/ -I/usr/lib/jvm/java-6-sun/include/linux -I. -pthread
	gcc -g -shared clangjava_wrap.o ../../eclipse-workspace/clang2/lib/libclang.so -o libclangjava.so -pthread

install:
	cp libclangjava.dylib ../lib/

mac: clean swig compile_mac install

linux: clean swig compile_linux install
