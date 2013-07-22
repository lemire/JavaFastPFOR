JavaFastPFOR: A simple integer compression library in Java
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

This library is used by the Columnar file format for Hadoop "Parquet" 
(http://parquet.io/). It is also used by Jimmy Lin's 
Hadoop tools for manipulating ClueWeb collections
(https://github.com/lintool/clueweb).

Some CODECs ("integrated codecs") assume that the integers are
in sorted orders. Most others do not.

Maven
-----

    <dependencies>
     <dependency>
     <groupId>me.lemire.integercompression</groupId>
     <artifactId>JavaFastPFOR</artifactId>
     <version>0.0.4</version>
     </dependency>
    </dependencies>

Why?
----

I found a few libraries that implemented Binary Packing, NewPFD, OptPFD,
Variable Byte, Simple 9 and so on in Java. However, I could not find
one that I liked.

I threw in a cool little benchmark program.


Authors
-------

Main contributor
Daniel Lemire, http://lemire.me/en/

Minor contribution by 
Di Wu, http://www.facebook.com/diwu1989


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

Maven central repository
------------------------

Using this code in your own project is easy with maven, just add
the following code in your pom.xml file:


    <dependencies>
         <dependency>
	     <groupId>me.lemire.integercompression</groupId>
	     <artifactId>JavaFastPFOR</artifactId>
	     <version>0.0.3</version>
         </dependency>
     </dependencies>

Naturally, you should replace "version" by the version
you desire.



You can also download JavaFastPFOR from the Maven central repository:
http://repo1.maven.org/maven2/me/lemire/integercompression/JavaFastPFOR/



What can I do?
--------------

Compile the code and execute me.lemire.integercompression.Benchmark.

I recommend running all the benchmarks with the "-server" flag.

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


Usage 
-----

See example.java for a simple demonstration.

Want to read more?
------------------

We wrote a research paper which documents many of the CODECs implemented here:

Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second through vectorization, Software Pratice & Experience (to appear)
http://arxiv.org/abs/1209.2137



