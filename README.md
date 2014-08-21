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

It can decompress integers at a rate of over 1.2 billions per second
(4.5 GB/s). It is significantly faster than generic codecs (such
as Snappy, LZ4 and so on) when compressing arrays of integers.

Part of this library has been integrated in Parquet (http://parquet.io/).
This libary is used by ClueWeb Tools (https://github.com/lintool/clueweb).
This library inspired a compression scheme used by Apache Lucene (e.g., see
http://lucene.apache.org/core/4_6_1/core/org/apache/lucene/util/PForDeltaDocIdSet.html ).

It is a java port of the fastpfor C++ library (https://github.com/lemire/FastPFor). 
There is also a Go port (https://github.com/reducedb/encoding). The C++
library is used by the zsearch engine (http://victorparmar.github.com/zsearch/)
as well as in GMAP and GSNAP (http://research-pub.gene.com/gmap/).


Usage
------

See example.java.

Some CODECs ("integrated codecs") assume that the integers are
in sorted orders and use differential coding (they compress deltas). 
They can be found in the package me.lemire.integercopression.differential.
Most others do not.


Maven central repository
------------------------

Using this code in your own project is easy with maven, just add
the following code in your pom.xml file:


    <dependencies>
         <dependency>
	     <groupId>me.lemire.integercompression</groupId>
	     <artifactId>JavaFastPFOR</artifactId>
	     <version>0.0.14</version>
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
* Stefan Ackermann, https://github.com/Stivo
* Samit Roy, https://github.com/roysamit

How does it compare to the Kamikaze PForDelta library?
------------------------------------------------------

In our tests, Kamikaze PForDelta is slower than our implementations. See
the benchmarkresults directory for some results. 

https://github.com/lemire/JavaFastPFOR/blob/master/benchmarkresults/benchmarkresults_icore7_10may2013.txt


Reference:
 http://sna-projects.com/kamikaze/


Requirements
------------

A recent Java compiler. Java 7 or better is recommended.

Good instructions on installing Java 7 on Linux:

http://forums.linuxmint.com/viewtopic.php?f=42&t=93052


How fast is it?
---------------

Compile the code and execute me.lemire.integercompression.benchmarktools.Benchmark.

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


API Documentation
-----------------

http://lemire.me/docs/javafastpfor/

Want to read more?
------------------

This library was a key ingredient in the best paper at ECIR 2014 :

Matteo Catena, Craig Macdonald, Iadh Ounis, On Inverted Index Compression for Search Engine Efficiency,  Lecture Notes in Computer Science 8416 (ECIR 2014), 2014.
http://dx.doi.org/10.1007/978-3-319-06028-6_30


We wrote a research paper which documents many of the CODECs implemented here:

Daniel Lemire and Leonid Boytsov, Decoding billions of integers per second through vectorization, Software Pratice & Experience (to appear)
http://arxiv.org/abs/1209.2137

Daniel Lemire, Leonid Boytsov, Nathan Kurz, SIMD Compression and the Intersection of Sorted Integers, arXiv:1401.6399, 2014
http://arxiv.org/abs/1401.6399

Ikhtear Sharif wrote his M.Sc. thesis on this library:

Ikhtear Sharif, Performance Evaluation of Fast Integer Compression Techniques Over Tables, M.Sc. thesis, UNB 2013.
http://lemire.me/fr/documents/thesis/IkhtearThesis.pdf

He also posted his slides online: http://www.slideshare.net/ikhtearSharif/ikhtear-defense


Funding
-----------

This work was supported by NSERC grant number 26143.
