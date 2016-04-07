# Bitset compression example

A bitset can be considered as an array of integers.
Suppose you want to compress it quickly (at a rate of
  millions of integers per second or better).

  The ``CompressBitmap.java`` file shows how it can be done.

## Usage

```bash
./run.sh

loading file example_bitmap.bin as a bitmap
Compressing 1784073 integers
compressed from 6969KB to 1348KB
ratio: 5
decoding speed:199 millions of integers per second
encoding speed:124 millions of integers per second
note: with a bit of effort, speed can be much higher.

I will try to compress the original bitmap using zip.
zip encoding speed:0.4458317816544745 million of bytes per second
zip compression ratio at best level : 2.255323798747234
```
