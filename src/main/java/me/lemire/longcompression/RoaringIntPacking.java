/*
 * (c) the authors Licensed under the Apache License, Version 2.0.
 */
package me.lemire.longcompression;

/**
 * Used to hold the logic packing 2 integers in a long, and separating a long in two integers. It is
 * useful in {@link Roaring64NavigableMap} as the implementation split the input long in two
 * integers, one used as key of a NavigableMap while the other is added in a Bitmap
 * 
 * @author Benoit Lacelle
 *
 */
// Duplicated from RoaringBitmap
class RoaringIntPacking {

  /**
   * 
   * @param id any long, positive or negative
   * @return an int holding the 32 highest order bits of information of the input long
   */
  public static int high(long id) {
    return (int) (id >> 32);
  }

  /**
   * 
   * @param id any long, positive or negative
   * @return an int holding the 32 lowest order bits of information of the input long
   */
  public static int low(long id) {
    return (int) id;
  }

  /**
   * 
   * @param high an integer representing the highest order bits of the output long
   * @param low an integer representing the lowest order bits of the output long
   * @return a long packing together the integers as computed by
   *         {@link RoaringIntPacking#high(long)} and {@link RoaringIntPacking#low(long)}
   */
  // https://stackoverflow.com/questions/12772939/java-storing-two-ints-in-a-long
  public static long pack(int high, int low) {
    return (((long) high) << 32) | (low & 0xffffffffL);
  }
}
