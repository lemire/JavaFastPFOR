JavaFastPFOR: A simple integer compression library in Java [![Build Status](https://travis-ci.org/lemire/JavaFastPFOR.png)](https://travis-ci.org/lemire/JavaFastPFOR)
==========================================================

License
-------

This code is released under the
Apache License Version 2.0 http://www.apache.org/licenses/.


What does this do?
------------------

It is a library to compress and uncompress arrays of integers 
very fast. The assumption is that most (but not all) values in
your array use less than 32 bits. These sort of arrays often come up
when using differential coding in databases and information
retrieval (e.g., in inverted indexes or column stores).

This libary is used by ClueWeb Tools (https://github.com/lintool/clueweb).

It is a java port of the fastpfor C++ library (https://github.com/lemire/FastPFor). 
There is also a Go port (https://github.com/reducedb/encoding). The C++
library is used by the zsearch engine (http://victorparmar.github.com/zsearch/)
as well as in GMAP and GSNAP (http://research-pub.gene.com/gmap/).


Some CODECs ("integrated codecs") assume that the integers are
in sorted orders. Most others do not.


Maven central repository
------------------------

Using this code in your own project is easy with maven, just add
the following code in your pom.xml file:


    <dependencies>
         <dependency>
	     <groupId>me.lemire.integercompression</groupId>
	     <artifactId>JavaFastPFOR</artifactId>
	     <version>0.0.8</version>
         </dependency>
     </dependencies>

Naturally, you should replace "version" by the version
you desire.



You can also download JavaFastPFOR from the Maven central repository:
http://repo1.maven.org/maven2/me/lemire/integercompression/JavaFastPFOR/


Why?
----

We found no library that implemented state-of-the-art integer coding techniques
such as Binary Packing, NewPFD, OptPFD, Variable Byte, Simple 9 and so on in Java.
We wrote one. 


Authors
-------

Main contributors
* Daniel Lemire, http://lemire.me/en/
* Muraoka Taro, https://github.com/koron

with contributions by 
* Di Wu, http://www.facebook.com/diwu1989


How does it compare to the Kamikaze PForDelta library?
------------------------------------------------------

In our tests, Kamikaze PForDelta does not fare well. See
the benchmarkresults directory for some results. 

https://github.com/lemire/JavaFastPFOR/blob/master/benchmarkresults/benchmarkresults_icore7_10may2013.txt

Requirements
------------

A recent Java compiler. Java 7 or better is recommended.

Good instructions on installing Java 7 on Linux:

http://forums.linuxmint.com/viewtopic.php?f=42&t=93052

Usage 
-----

See example.java for a simple demonstration.


How fast is it?
---------------

Compile the code and execute me.lemire.integercompression.Benchmark.

I recommend running all the benchmarks with the "-server" flag on a desktop machine.

Speed is always reported in millions of integers per second.


For Maven users
---------------

mvn compile

mvn exec:java

For ant users
-------------

If you use Apache ant, please try this:

    $ ant Benchmark

or:

    $ ant Benchmark -Dbenchmark.target=BenchmarkBitPacking


Want to read more?
------------------

We wrote a research paper which documents many of the CODECs implemented here:

Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second through vectorization, Software Pratice & Experience (to appear)
http://arxiv.org/abs/1209.2137



