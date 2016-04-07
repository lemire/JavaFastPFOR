#!/usr/bin/env bash
echo "please be patient as I build the library and the example"
 mvn -Dmaven.test.skip=true -Dmaven.javadoc.skip=true -f ../../pom.xml package > /dev/null && javac -cp "../../target/*" CompressBitmap.java && java -cp "../../target/*":. CompressBitmap example_bitmap.bin
