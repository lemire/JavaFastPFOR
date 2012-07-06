/**
 * This is code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */
package integercompression;

import java.util.Arrays;

public final class BitPacking {
	
	


public static void fastpackwithoutmask1(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  1 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  2 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  3 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  4 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  5 ;
    out[ 0  + outpos] |= ( in[ 6  + inpos]  ) <<  6 ;
    out[ 0  + outpos] |= ( in[ 7  + inpos]  ) <<  7 ;
    out[ 0  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 0  + outpos] |= ( in[ 9  + inpos]  ) <<  9 ;
    out[ 0  + outpos] |= ( in[ 10  + inpos]  ) <<  10 ;
    out[ 0  + outpos] |= ( in[ 11  + inpos]  ) <<  11 ;
    out[ 0  + outpos] |= ( in[ 12  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 13  + inpos]  ) <<  13 ;
    out[ 0  + outpos] |= ( in[ 14  + inpos]  ) <<  14 ;
    out[ 0  + outpos] |= ( in[ 15  + inpos]  ) <<  15 ;
    out[ 0  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 0  + outpos] |= ( in[ 17  + inpos]  ) <<  17 ;
    out[ 0  + outpos] |= ( in[ 18  + inpos]  ) <<  18 ;
    out[ 0  + outpos] |= ( in[ 19  + inpos]  ) <<  19 ;
    out[ 0  + outpos] |= ( in[ 20  + inpos]  ) <<  20 ;
    out[ 0  + outpos] |= ( in[ 21  + inpos]  ) <<  21 ;
    out[ 0  + outpos] |= ( in[ 22  + inpos]  ) <<  22 ;
    out[ 0  + outpos] |= ( in[ 23  + inpos]  ) <<  23 ;
    out[ 0  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 0  + outpos] |= ( in[ 25  + inpos]  ) <<  25 ;
    out[ 0  + outpos] |= ( in[ 26  + inpos]  ) <<  26 ;
    out[ 0  + outpos] |= ( in[ 27  + inpos]  ) <<  27 ;
    out[ 0  + outpos] |= ( in[ 28  + inpos]  ) <<  28 ;
    out[ 0  + outpos] |= ( in[ 29  + inpos]  ) <<  29 ;
    out[ 0  + outpos] |= ( in[ 30  + inpos]  ) <<  30 ;
    out[ 0  + outpos] |= ( in[ 31  + inpos]  ) <<  31 ;
}




public static void fastpackwithoutmask2(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  2 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  4 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  6 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  8 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  10 ;
    out[ 0  + outpos] |= ( in[ 6  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 7  + inpos]  ) <<  14 ;
    out[ 0  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 0  + outpos] |= ( in[ 9  + inpos]  ) <<  18 ;
    out[ 0  + outpos] |= ( in[ 10  + inpos]  ) <<  20 ;
    out[ 0  + outpos] |= ( in[ 11  + inpos]  ) <<  22 ;
    out[ 0  + outpos] |= ( in[ 12  + inpos]  ) <<  24 ;
    out[ 0  + outpos] |= ( in[ 13  + inpos]  ) <<  26 ;
    out[ 0  + outpos] |= ( in[ 14  + inpos]  ) <<  28 ;
    out[ 0  + outpos] |= ( in[ 15  + inpos]  ) <<  30 ;
    out[ 1  + outpos] = in[ 16  + inpos] ;
    out[ 1  + outpos] |= ( in[ 17  + inpos]  ) <<  2 ;
    out[ 1  + outpos] |= ( in[ 18  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 19  + inpos]  ) <<  6 ;
    out[ 1  + outpos] |= ( in[ 20  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 21  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 22  + inpos]  ) <<  12 ;
    out[ 1  + outpos] |= ( in[ 23  + inpos]  ) <<  14 ;
    out[ 1  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 25  + inpos]  ) <<  18 ;
    out[ 1  + outpos] |= ( in[ 26  + inpos]  ) <<  20 ;
    out[ 1  + outpos] |= ( in[ 27  + inpos]  ) <<  22 ;
    out[ 1  + outpos] |= ( in[ 28  + inpos]  ) <<  24 ;
    out[ 1  + outpos] |= ( in[ 29  + inpos]  ) <<  26 ;
    out[ 1  + outpos] |= ( in[ 30  + inpos]  ) <<  28 ;
    out[ 1  + outpos] |= ( in[ 31  + inpos]  ) <<  30 ;
}




public static void fastpackwithoutmask3(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  3 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  6 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  9 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  15 ;
    out[ 0  + outpos] |= ( in[ 6  + inpos]  ) <<  18 ;
    out[ 0  + outpos] |= ( in[ 7  + inpos]  ) <<  21 ;
    out[ 0  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 0  + outpos] |= ( in[ 9  + inpos]  ) <<  27 ;
    out[ 0  + outpos] |= ( in[ 10  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 10  + inpos] ) >>> ( 3  -  1 );
    out[ 1  + outpos] |= ( in[ 11  + inpos]  ) <<  1 ;
    out[ 1  + outpos] |= ( in[ 12  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 13  + inpos]  ) <<  7 ;
    out[ 1  + outpos] |= ( in[ 14  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 15  + inpos]  ) <<  13 ;
    out[ 1  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 17  + inpos]  ) <<  19 ;
    out[ 1  + outpos] |= ( in[ 18  + inpos]  ) <<  22 ;
    out[ 1  + outpos] |= ( in[ 19  + inpos]  ) <<  25 ;
    out[ 1  + outpos] |= ( in[ 20  + inpos]  ) <<  28 ;
    out[ 1  + outpos] |= ( in[ 21  + inpos]  ) <<  31 ;
    out[ 2  + outpos] =  ( in[ 21  + inpos] ) >>> ( 3  -  2 );
    out[ 2  + outpos] |= ( in[ 22  + inpos]  ) <<  2 ;
    out[ 2  + outpos] |= ( in[ 23  + inpos]  ) <<  5 ;
    out[ 2  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 25  + inpos]  ) <<  11 ;
    out[ 2  + outpos] |= ( in[ 26  + inpos]  ) <<  14 ;
    out[ 2  + outpos] |= ( in[ 27  + inpos]  ) <<  17 ;
    out[ 2  + outpos] |= ( in[ 28  + inpos]  ) <<  20 ;
    out[ 2  + outpos] |= ( in[ 29  + inpos]  ) <<  23 ;
    out[ 2  + outpos] |= ( in[ 30  + inpos]  ) <<  26 ;
    out[ 2  + outpos] |= ( in[ 31  + inpos]  ) <<  29 ;
}




public static void fastpackwithoutmask4(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  4 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  8 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  16 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  20 ;
    out[ 0  + outpos] |= ( in[ 6  + inpos]  ) <<  24 ;
    out[ 0  + outpos] |= ( in[ 7  + inpos]  ) <<  28 ;
    out[ 1  + outpos] = in[ 8  + inpos] ;
    out[ 1  + outpos] |= ( in[ 9  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 10  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 11  + inpos]  ) <<  12 ;
    out[ 1  + outpos] |= ( in[ 12  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 13  + inpos]  ) <<  20 ;
    out[ 1  + outpos] |= ( in[ 14  + inpos]  ) <<  24 ;
    out[ 1  + outpos] |= ( in[ 15  + inpos]  ) <<  28 ;
    out[ 2  + outpos] = in[ 16  + inpos] ;
    out[ 2  + outpos] |= ( in[ 17  + inpos]  ) <<  4 ;
    out[ 2  + outpos] |= ( in[ 18  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 19  + inpos]  ) <<  12 ;
    out[ 2  + outpos] |= ( in[ 20  + inpos]  ) <<  16 ;
    out[ 2  + outpos] |= ( in[ 21  + inpos]  ) <<  20 ;
    out[ 2  + outpos] |= ( in[ 22  + inpos]  ) <<  24 ;
    out[ 2  + outpos] |= ( in[ 23  + inpos]  ) <<  28 ;
    out[ 3  + outpos] = in[ 24  + inpos] ;
    out[ 3  + outpos] |= ( in[ 25  + inpos]  ) <<  4 ;
    out[ 3  + outpos] |= ( in[ 26  + inpos]  ) <<  8 ;
    out[ 3  + outpos] |= ( in[ 27  + inpos]  ) <<  12 ;
    out[ 3  + outpos] |= ( in[ 28  + inpos]  ) <<  16 ;
    out[ 3  + outpos] |= ( in[ 29  + inpos]  ) <<  20 ;
    out[ 3  + outpos] |= ( in[ 30  + inpos]  ) <<  24 ;
    out[ 3  + outpos] |= ( in[ 31  + inpos]  ) <<  28 ;
}




public static void fastpackwithoutmask5(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  5 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  10 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  15 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  20 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  25 ;
    out[ 0  + outpos] |= ( in[ 6  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 6  + inpos] ) >>> ( 5  -  3 );
    out[ 1  + outpos] |= ( in[ 7  + inpos]  ) <<  3 ;
    out[ 1  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 9  + inpos]  ) <<  13 ;
    out[ 1  + outpos] |= ( in[ 10  + inpos]  ) <<  18 ;
    out[ 1  + outpos] |= ( in[ 11  + inpos]  ) <<  23 ;
    out[ 1  + outpos] |= ( in[ 12  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 12  + inpos] ) >>> ( 5  -  1 );
    out[ 2  + outpos] |= ( in[ 13  + inpos]  ) <<  1 ;
    out[ 2  + outpos] |= ( in[ 14  + inpos]  ) <<  6 ;
    out[ 2  + outpos] |= ( in[ 15  + inpos]  ) <<  11 ;
    out[ 2  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 2  + outpos] |= ( in[ 17  + inpos]  ) <<  21 ;
    out[ 2  + outpos] |= ( in[ 18  + inpos]  ) <<  26 ;
    out[ 2  + outpos] |= ( in[ 19  + inpos]  ) <<  31 ;
    out[ 3  + outpos] =  ( in[ 19  + inpos] ) >>> ( 5  -  4 );
    out[ 3  + outpos] |= ( in[ 20  + inpos]  ) <<  4 ;
    out[ 3  + outpos] |= ( in[ 21  + inpos]  ) <<  9 ;
    out[ 3  + outpos] |= ( in[ 22  + inpos]  ) <<  14 ;
    out[ 3  + outpos] |= ( in[ 23  + inpos]  ) <<  19 ;
    out[ 3  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 3  + outpos] |= ( in[ 25  + inpos]  ) <<  29 ;
    out[ 4  + outpos] =  ( in[ 25  + inpos] ) >>> ( 5  -  2 );
    out[ 4  + outpos] |= ( in[ 26  + inpos]  ) <<  2 ;
    out[ 4  + outpos] |= ( in[ 27  + inpos]  ) <<  7 ;
    out[ 4  + outpos] |= ( in[ 28  + inpos]  ) <<  12 ;
    out[ 4  + outpos] |= ( in[ 29  + inpos]  ) <<  17 ;
    out[ 4  + outpos] |= ( in[ 30  + inpos]  ) <<  22 ;
    out[ 4  + outpos] |= ( in[ 31  + inpos]  ) <<  27 ;
}




public static void fastpackwithoutmask6(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  6 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  18 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  24 ;
    out[ 0  + outpos] |= ( in[ 5  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 5  + inpos] ) >>> ( 6  -  4 );
    out[ 1  + outpos] |= ( in[ 6  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 7  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 9  + inpos]  ) <<  22 ;
    out[ 1  + outpos] |= ( in[ 10  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 10  + inpos] ) >>> ( 6  -  2 );
    out[ 2  + outpos] |= ( in[ 11  + inpos]  ) <<  2 ;
    out[ 2  + outpos] |= ( in[ 12  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 13  + inpos]  ) <<  14 ;
    out[ 2  + outpos] |= ( in[ 14  + inpos]  ) <<  20 ;
    out[ 2  + outpos] |= ( in[ 15  + inpos]  ) <<  26 ;
    out[ 3  + outpos] = in[ 16  + inpos] ;
    out[ 3  + outpos] |= ( in[ 17  + inpos]  ) <<  6 ;
    out[ 3  + outpos] |= ( in[ 18  + inpos]  ) <<  12 ;
    out[ 3  + outpos] |= ( in[ 19  + inpos]  ) <<  18 ;
    out[ 3  + outpos] |= ( in[ 20  + inpos]  ) <<  24 ;
    out[ 3  + outpos] |= ( in[ 21  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 21  + inpos] ) >>> ( 6  -  4 );
    out[ 4  + outpos] |= ( in[ 22  + inpos]  ) <<  4 ;
    out[ 4  + outpos] |= ( in[ 23  + inpos]  ) <<  10 ;
    out[ 4  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 4  + outpos] |= ( in[ 25  + inpos]  ) <<  22 ;
    out[ 4  + outpos] |= ( in[ 26  + inpos]  ) <<  28 ;
    out[ 5  + outpos] =  ( in[ 26  + inpos] ) >>> ( 6  -  2 );
    out[ 5  + outpos] |= ( in[ 27  + inpos]  ) <<  2 ;
    out[ 5  + outpos] |= ( in[ 28  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 29  + inpos]  ) <<  14 ;
    out[ 5  + outpos] |= ( in[ 30  + inpos]  ) <<  20 ;
    out[ 5  + outpos] |= ( in[ 31  + inpos]  ) <<  26 ;
}




public static void fastpackwithoutmask7(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  7 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  14 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  21 ;
    out[ 0  + outpos] |= ( in[ 4  + inpos]  ) <<  28 ;
    out[ 1  + outpos] =  ( in[ 4  + inpos] ) >>> ( 7  -  3 );
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  3 ;
    out[ 1  + outpos] |= ( in[ 6  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 7  + inpos]  ) <<  17 ;
    out[ 1  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 1  + outpos] |= ( in[ 9  + inpos]  ) <<  31 ;
    out[ 2  + outpos] =  ( in[ 9  + inpos] ) >>> ( 7  -  6 );
    out[ 2  + outpos] |= ( in[ 10  + inpos]  ) <<  6 ;
    out[ 2  + outpos] |= ( in[ 11  + inpos]  ) <<  13 ;
    out[ 2  + outpos] |= ( in[ 12  + inpos]  ) <<  20 ;
    out[ 2  + outpos] |= ( in[ 13  + inpos]  ) <<  27 ;
    out[ 3  + outpos] =  ( in[ 13  + inpos] ) >>> ( 7  -  2 );
    out[ 3  + outpos] |= ( in[ 14  + inpos]  ) <<  2 ;
    out[ 3  + outpos] |= ( in[ 15  + inpos]  ) <<  9 ;
    out[ 3  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 3  + outpos] |= ( in[ 17  + inpos]  ) <<  23 ;
    out[ 3  + outpos] |= ( in[ 18  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 18  + inpos] ) >>> ( 7  -  5 );
    out[ 4  + outpos] |= ( in[ 19  + inpos]  ) <<  5 ;
    out[ 4  + outpos] |= ( in[ 20  + inpos]  ) <<  12 ;
    out[ 4  + outpos] |= ( in[ 21  + inpos]  ) <<  19 ;
    out[ 4  + outpos] |= ( in[ 22  + inpos]  ) <<  26 ;
    out[ 5  + outpos] =  ( in[ 22  + inpos] ) >>> ( 7  -  1 );
    out[ 5  + outpos] |= ( in[ 23  + inpos]  ) <<  1 ;
    out[ 5  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 25  + inpos]  ) <<  15 ;
    out[ 5  + outpos] |= ( in[ 26  + inpos]  ) <<  22 ;
    out[ 5  + outpos] |= ( in[ 27  + inpos]  ) <<  29 ;
    out[ 6  + outpos] =  ( in[ 27  + inpos] ) >>> ( 7  -  4 );
    out[ 6  + outpos] |= ( in[ 28  + inpos]  ) <<  4 ;
    out[ 6  + outpos] |= ( in[ 29  + inpos]  ) <<  11 ;
    out[ 6  + outpos] |= ( in[ 30  + inpos]  ) <<  18 ;
    out[ 6  + outpos] |= ( in[ 31  + inpos]  ) <<  25 ;
}




public static void fastpackwithoutmask8(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  8 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  16 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  24 ;
    out[ 1  + outpos] = in[ 4  + inpos] ;
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 6  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 7  + inpos]  ) <<  24 ;
    out[ 2  + outpos] = in[ 8  + inpos] ;
    out[ 2  + outpos] |= ( in[ 9  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 10  + inpos]  ) <<  16 ;
    out[ 2  + outpos] |= ( in[ 11  + inpos]  ) <<  24 ;
    out[ 3  + outpos] = in[ 12  + inpos] ;
    out[ 3  + outpos] |= ( in[ 13  + inpos]  ) <<  8 ;
    out[ 3  + outpos] |= ( in[ 14  + inpos]  ) <<  16 ;
    out[ 3  + outpos] |= ( in[ 15  + inpos]  ) <<  24 ;
    out[ 4  + outpos] = in[ 16  + inpos] ;
    out[ 4  + outpos] |= ( in[ 17  + inpos]  ) <<  8 ;
    out[ 4  + outpos] |= ( in[ 18  + inpos]  ) <<  16 ;
    out[ 4  + outpos] |= ( in[ 19  + inpos]  ) <<  24 ;
    out[ 5  + outpos] = in[ 20  + inpos] ;
    out[ 5  + outpos] |= ( in[ 21  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 22  + inpos]  ) <<  16 ;
    out[ 5  + outpos] |= ( in[ 23  + inpos]  ) <<  24 ;
    out[ 6  + outpos] = in[ 24  + inpos] ;
    out[ 6  + outpos] |= ( in[ 25  + inpos]  ) <<  8 ;
    out[ 6  + outpos] |= ( in[ 26  + inpos]  ) <<  16 ;
    out[ 6  + outpos] |= ( in[ 27  + inpos]  ) <<  24 ;
    out[ 7  + outpos] = in[ 28  + inpos] ;
    out[ 7  + outpos] |= ( in[ 29  + inpos]  ) <<  8 ;
    out[ 7  + outpos] |= ( in[ 30  + inpos]  ) <<  16 ;
    out[ 7  + outpos] |= ( in[ 31  + inpos]  ) <<  24 ;
}




public static void fastpackwithoutmask9(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  9 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  18 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  27 ;
    out[ 1  + outpos] =  ( in[ 3  + inpos] ) >>> ( 9  -  4 );
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  13 ;
    out[ 1  + outpos] |= ( in[ 6  + inpos]  ) <<  22 ;
    out[ 1  + outpos] |= ( in[ 7  + inpos]  ) <<  31 ;
    out[ 2  + outpos] =  ( in[ 7  + inpos] ) >>> ( 9  -  8 );
    out[ 2  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 9  + inpos]  ) <<  17 ;
    out[ 2  + outpos] |= ( in[ 10  + inpos]  ) <<  26 ;
    out[ 3  + outpos] =  ( in[ 10  + inpos] ) >>> ( 9  -  3 );
    out[ 3  + outpos] |= ( in[ 11  + inpos]  ) <<  3 ;
    out[ 3  + outpos] |= ( in[ 12  + inpos]  ) <<  12 ;
    out[ 3  + outpos] |= ( in[ 13  + inpos]  ) <<  21 ;
    out[ 3  + outpos] |= ( in[ 14  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 14  + inpos] ) >>> ( 9  -  7 );
    out[ 4  + outpos] |= ( in[ 15  + inpos]  ) <<  7 ;
    out[ 4  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 4  + outpos] |= ( in[ 17  + inpos]  ) <<  25 ;
    out[ 5  + outpos] =  ( in[ 17  + inpos] ) >>> ( 9  -  2 );
    out[ 5  + outpos] |= ( in[ 18  + inpos]  ) <<  2 ;
    out[ 5  + outpos] |= ( in[ 19  + inpos]  ) <<  11 ;
    out[ 5  + outpos] |= ( in[ 20  + inpos]  ) <<  20 ;
    out[ 5  + outpos] |= ( in[ 21  + inpos]  ) <<  29 ;
    out[ 6  + outpos] =  ( in[ 21  + inpos] ) >>> ( 9  -  6 );
    out[ 6  + outpos] |= ( in[ 22  + inpos]  ) <<  6 ;
    out[ 6  + outpos] |= ( in[ 23  + inpos]  ) <<  15 ;
    out[ 6  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 7  + outpos] =  ( in[ 24  + inpos] ) >>> ( 9  -  1 );
    out[ 7  + outpos] |= ( in[ 25  + inpos]  ) <<  1 ;
    out[ 7  + outpos] |= ( in[ 26  + inpos]  ) <<  10 ;
    out[ 7  + outpos] |= ( in[ 27  + inpos]  ) <<  19 ;
    out[ 7  + outpos] |= ( in[ 28  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 28  + inpos] ) >>> ( 9  -  5 );
    out[ 8  + outpos] |= ( in[ 29  + inpos]  ) <<  5 ;
    out[ 8  + outpos] |= ( in[ 30  + inpos]  ) <<  14 ;
    out[ 8  + outpos] |= ( in[ 31  + inpos]  ) <<  23 ;
}




public static void fastpackwithoutmask10(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  10 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  20 ;
    out[ 0  + outpos] |= ( in[ 3  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 3  + inpos] ) >>> ( 10  -  8 );
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  18 ;
    out[ 1  + outpos] |= ( in[ 6  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 6  + inpos] ) >>> ( 10  -  6 );
    out[ 2  + outpos] |= ( in[ 7  + inpos]  ) <<  6 ;
    out[ 2  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 2  + outpos] |= ( in[ 9  + inpos]  ) <<  26 ;
    out[ 3  + outpos] =  ( in[ 9  + inpos] ) >>> ( 10  -  4 );
    out[ 3  + outpos] |= ( in[ 10  + inpos]  ) <<  4 ;
    out[ 3  + outpos] |= ( in[ 11  + inpos]  ) <<  14 ;
    out[ 3  + outpos] |= ( in[ 12  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 12  + inpos] ) >>> ( 10  -  2 );
    out[ 4  + outpos] |= ( in[ 13  + inpos]  ) <<  2 ;
    out[ 4  + outpos] |= ( in[ 14  + inpos]  ) <<  12 ;
    out[ 4  + outpos] |= ( in[ 15  + inpos]  ) <<  22 ;
    out[ 5  + outpos] = in[ 16  + inpos] ;
    out[ 5  + outpos] |= ( in[ 17  + inpos]  ) <<  10 ;
    out[ 5  + outpos] |= ( in[ 18  + inpos]  ) <<  20 ;
    out[ 5  + outpos] |= ( in[ 19  + inpos]  ) <<  30 ;
    out[ 6  + outpos] =  ( in[ 19  + inpos] ) >>> ( 10  -  8 );
    out[ 6  + outpos] |= ( in[ 20  + inpos]  ) <<  8 ;
    out[ 6  + outpos] |= ( in[ 21  + inpos]  ) <<  18 ;
    out[ 6  + outpos] |= ( in[ 22  + inpos]  ) <<  28 ;
    out[ 7  + outpos] =  ( in[ 22  + inpos] ) >>> ( 10  -  6 );
    out[ 7  + outpos] |= ( in[ 23  + inpos]  ) <<  6 ;
    out[ 7  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 7  + outpos] |= ( in[ 25  + inpos]  ) <<  26 ;
    out[ 8  + outpos] =  ( in[ 25  + inpos] ) >>> ( 10  -  4 );
    out[ 8  + outpos] |= ( in[ 26  + inpos]  ) <<  4 ;
    out[ 8  + outpos] |= ( in[ 27  + inpos]  ) <<  14 ;
    out[ 8  + outpos] |= ( in[ 28  + inpos]  ) <<  24 ;
    out[ 9  + outpos] =  ( in[ 28  + inpos] ) >>> ( 10  -  2 );
    out[ 9  + outpos] |= ( in[ 29  + inpos]  ) <<  2 ;
    out[ 9  + outpos] |= ( in[ 30  + inpos]  ) <<  12 ;
    out[ 9  + outpos] |= ( in[ 31  + inpos]  ) <<  22 ;
}




public static void fastpackwithoutmask11(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  11 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  22 ;
    out[ 1  + outpos] =  ( in[ 2  + inpos] ) >>> ( 11  -  1 );
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  1 ;
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  12 ;
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  23 ;
    out[ 2  + outpos] =  ( in[ 5  + inpos] ) >>> ( 11  -  2 );
    out[ 2  + outpos] |= ( in[ 6  + inpos]  ) <<  2 ;
    out[ 2  + outpos] |= ( in[ 7  + inpos]  ) <<  13 ;
    out[ 2  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 3  + outpos] =  ( in[ 8  + inpos] ) >>> ( 11  -  3 );
    out[ 3  + outpos] |= ( in[ 9  + inpos]  ) <<  3 ;
    out[ 3  + outpos] |= ( in[ 10  + inpos]  ) <<  14 ;
    out[ 3  + outpos] |= ( in[ 11  + inpos]  ) <<  25 ;
    out[ 4  + outpos] =  ( in[ 11  + inpos] ) >>> ( 11  -  4 );
    out[ 4  + outpos] |= ( in[ 12  + inpos]  ) <<  4 ;
    out[ 4  + outpos] |= ( in[ 13  + inpos]  ) <<  15 ;
    out[ 4  + outpos] |= ( in[ 14  + inpos]  ) <<  26 ;
    out[ 5  + outpos] =  ( in[ 14  + inpos] ) >>> ( 11  -  5 );
    out[ 5  + outpos] |= ( in[ 15  + inpos]  ) <<  5 ;
    out[ 5  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 5  + outpos] |= ( in[ 17  + inpos]  ) <<  27 ;
    out[ 6  + outpos] =  ( in[ 17  + inpos] ) >>> ( 11  -  6 );
    out[ 6  + outpos] |= ( in[ 18  + inpos]  ) <<  6 ;
    out[ 6  + outpos] |= ( in[ 19  + inpos]  ) <<  17 ;
    out[ 6  + outpos] |= ( in[ 20  + inpos]  ) <<  28 ;
    out[ 7  + outpos] =  ( in[ 20  + inpos] ) >>> ( 11  -  7 );
    out[ 7  + outpos] |= ( in[ 21  + inpos]  ) <<  7 ;
    out[ 7  + outpos] |= ( in[ 22  + inpos]  ) <<  18 ;
    out[ 7  + outpos] |= ( in[ 23  + inpos]  ) <<  29 ;
    out[ 8  + outpos] =  ( in[ 23  + inpos] ) >>> ( 11  -  8 );
    out[ 8  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 8  + outpos] |= ( in[ 25  + inpos]  ) <<  19 ;
    out[ 8  + outpos] |= ( in[ 26  + inpos]  ) <<  30 ;
    out[ 9  + outpos] =  ( in[ 26  + inpos] ) >>> ( 11  -  9 );
    out[ 9  + outpos] |= ( in[ 27  + inpos]  ) <<  9 ;
    out[ 9  + outpos] |= ( in[ 28  + inpos]  ) <<  20 ;
    out[ 9  + outpos] |= ( in[ 29  + inpos]  ) <<  31 ;
    out[ 10  + outpos] =  ( in[ 29  + inpos] ) >>> ( 11  -  10 );
    out[ 10  + outpos] |= ( in[ 30  + inpos]  ) <<  10 ;
    out[ 10  + outpos] |= ( in[ 31  + inpos]  ) <<  21 ;
}




public static void fastpackwithoutmask12(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  12 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  24 ;
    out[ 1  + outpos] =  ( in[ 2  + inpos] ) >>> ( 12  -  4 );
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  16 ;
    out[ 1  + outpos] |= ( in[ 5  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 5  + inpos] ) >>> ( 12  -  8 );
    out[ 2  + outpos] |= ( in[ 6  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 7  + inpos]  ) <<  20 ;
    out[ 3  + outpos] = in[ 8  + inpos] ;
    out[ 3  + outpos] |= ( in[ 9  + inpos]  ) <<  12 ;
    out[ 3  + outpos] |= ( in[ 10  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 10  + inpos] ) >>> ( 12  -  4 );
    out[ 4  + outpos] |= ( in[ 11  + inpos]  ) <<  4 ;
    out[ 4  + outpos] |= ( in[ 12  + inpos]  ) <<  16 ;
    out[ 4  + outpos] |= ( in[ 13  + inpos]  ) <<  28 ;
    out[ 5  + outpos] =  ( in[ 13  + inpos] ) >>> ( 12  -  8 );
    out[ 5  + outpos] |= ( in[ 14  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 15  + inpos]  ) <<  20 ;
    out[ 6  + outpos] = in[ 16  + inpos] ;
    out[ 6  + outpos] |= ( in[ 17  + inpos]  ) <<  12 ;
    out[ 6  + outpos] |= ( in[ 18  + inpos]  ) <<  24 ;
    out[ 7  + outpos] =  ( in[ 18  + inpos] ) >>> ( 12  -  4 );
    out[ 7  + outpos] |= ( in[ 19  + inpos]  ) <<  4 ;
    out[ 7  + outpos] |= ( in[ 20  + inpos]  ) <<  16 ;
    out[ 7  + outpos] |= ( in[ 21  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 21  + inpos] ) >>> ( 12  -  8 );
    out[ 8  + outpos] |= ( in[ 22  + inpos]  ) <<  8 ;
    out[ 8  + outpos] |= ( in[ 23  + inpos]  ) <<  20 ;
    out[ 9  + outpos] = in[ 24  + inpos] ;
    out[ 9  + outpos] |= ( in[ 25  + inpos]  ) <<  12 ;
    out[ 9  + outpos] |= ( in[ 26  + inpos]  ) <<  24 ;
    out[ 10  + outpos] =  ( in[ 26  + inpos] ) >>> ( 12  -  4 );
    out[ 10  + outpos] |= ( in[ 27  + inpos]  ) <<  4 ;
    out[ 10  + outpos] |= ( in[ 28  + inpos]  ) <<  16 ;
    out[ 10  + outpos] |= ( in[ 29  + inpos]  ) <<  28 ;
    out[ 11  + outpos] =  ( in[ 29  + inpos] ) >>> ( 12  -  8 );
    out[ 11  + outpos] |= ( in[ 30  + inpos]  ) <<  8 ;
    out[ 11  + outpos] |= ( in[ 31  + inpos]  ) <<  20 ;
}




public static void fastpackwithoutmask13(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  13 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  26 ;
    out[ 1  + outpos] =  ( in[ 2  + inpos] ) >>> ( 13  -  7 );
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  7 ;
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  20 ;
    out[ 2  + outpos] =  ( in[ 4  + inpos] ) >>> ( 13  -  1 );
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  1 ;
    out[ 2  + outpos] |= ( in[ 6  + inpos]  ) <<  14 ;
    out[ 2  + outpos] |= ( in[ 7  + inpos]  ) <<  27 ;
    out[ 3  + outpos] =  ( in[ 7  + inpos] ) >>> ( 13  -  8 );
    out[ 3  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 3  + outpos] |= ( in[ 9  + inpos]  ) <<  21 ;
    out[ 4  + outpos] =  ( in[ 9  + inpos] ) >>> ( 13  -  2 );
    out[ 4  + outpos] |= ( in[ 10  + inpos]  ) <<  2 ;
    out[ 4  + outpos] |= ( in[ 11  + inpos]  ) <<  15 ;
    out[ 4  + outpos] |= ( in[ 12  + inpos]  ) <<  28 ;
    out[ 5  + outpos] =  ( in[ 12  + inpos] ) >>> ( 13  -  9 );
    out[ 5  + outpos] |= ( in[ 13  + inpos]  ) <<  9 ;
    out[ 5  + outpos] |= ( in[ 14  + inpos]  ) <<  22 ;
    out[ 6  + outpos] =  ( in[ 14  + inpos] ) >>> ( 13  -  3 );
    out[ 6  + outpos] |= ( in[ 15  + inpos]  ) <<  3 ;
    out[ 6  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 6  + outpos] |= ( in[ 17  + inpos]  ) <<  29 ;
    out[ 7  + outpos] =  ( in[ 17  + inpos] ) >>> ( 13  -  10 );
    out[ 7  + outpos] |= ( in[ 18  + inpos]  ) <<  10 ;
    out[ 7  + outpos] |= ( in[ 19  + inpos]  ) <<  23 ;
    out[ 8  + outpos] =  ( in[ 19  + inpos] ) >>> ( 13  -  4 );
    out[ 8  + outpos] |= ( in[ 20  + inpos]  ) <<  4 ;
    out[ 8  + outpos] |= ( in[ 21  + inpos]  ) <<  17 ;
    out[ 8  + outpos] |= ( in[ 22  + inpos]  ) <<  30 ;
    out[ 9  + outpos] =  ( in[ 22  + inpos] ) >>> ( 13  -  11 );
    out[ 9  + outpos] |= ( in[ 23  + inpos]  ) <<  11 ;
    out[ 9  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 10  + outpos] =  ( in[ 24  + inpos] ) >>> ( 13  -  5 );
    out[ 10  + outpos] |= ( in[ 25  + inpos]  ) <<  5 ;
    out[ 10  + outpos] |= ( in[ 26  + inpos]  ) <<  18 ;
    out[ 10  + outpos] |= ( in[ 27  + inpos]  ) <<  31 ;
    out[ 11  + outpos] =  ( in[ 27  + inpos] ) >>> ( 13  -  12 );
    out[ 11  + outpos] |= ( in[ 28  + inpos]  ) <<  12 ;
    out[ 11  + outpos] |= ( in[ 29  + inpos]  ) <<  25 ;
    out[ 12  + outpos] =  ( in[ 29  + inpos] ) >>> ( 13  -  6 );
    out[ 12  + outpos] |= ( in[ 30  + inpos]  ) <<  6 ;
    out[ 12  + outpos] |= ( in[ 31  + inpos]  ) <<  19 ;
}




public static void fastpackwithoutmask14(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  14 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  28 ;
    out[ 1  + outpos] =  ( in[ 2  + inpos] ) >>> ( 14  -  10 );
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  24 ;
    out[ 2  + outpos] =  ( in[ 4  + inpos] ) >>> ( 14  -  6 );
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  6 ;
    out[ 2  + outpos] |= ( in[ 6  + inpos]  ) <<  20 ;
    out[ 3  + outpos] =  ( in[ 6  + inpos] ) >>> ( 14  -  2 );
    out[ 3  + outpos] |= ( in[ 7  + inpos]  ) <<  2 ;
    out[ 3  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 3  + outpos] |= ( in[ 9  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 9  + inpos] ) >>> ( 14  -  12 );
    out[ 4  + outpos] |= ( in[ 10  + inpos]  ) <<  12 ;
    out[ 4  + outpos] |= ( in[ 11  + inpos]  ) <<  26 ;
    out[ 5  + outpos] =  ( in[ 11  + inpos] ) >>> ( 14  -  8 );
    out[ 5  + outpos] |= ( in[ 12  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 13  + inpos]  ) <<  22 ;
    out[ 6  + outpos] =  ( in[ 13  + inpos] ) >>> ( 14  -  4 );
    out[ 6  + outpos] |= ( in[ 14  + inpos]  ) <<  4 ;
    out[ 6  + outpos] |= ( in[ 15  + inpos]  ) <<  18 ;
    out[ 7  + outpos] = in[ 16  + inpos] ;
    out[ 7  + outpos] |= ( in[ 17  + inpos]  ) <<  14 ;
    out[ 7  + outpos] |= ( in[ 18  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 18  + inpos] ) >>> ( 14  -  10 );
    out[ 8  + outpos] |= ( in[ 19  + inpos]  ) <<  10 ;
    out[ 8  + outpos] |= ( in[ 20  + inpos]  ) <<  24 ;
    out[ 9  + outpos] =  ( in[ 20  + inpos] ) >>> ( 14  -  6 );
    out[ 9  + outpos] |= ( in[ 21  + inpos]  ) <<  6 ;
    out[ 9  + outpos] |= ( in[ 22  + inpos]  ) <<  20 ;
    out[ 10  + outpos] =  ( in[ 22  + inpos] ) >>> ( 14  -  2 );
    out[ 10  + outpos] |= ( in[ 23  + inpos]  ) <<  2 ;
    out[ 10  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 10  + outpos] |= ( in[ 25  + inpos]  ) <<  30 ;
    out[ 11  + outpos] =  ( in[ 25  + inpos] ) >>> ( 14  -  12 );
    out[ 11  + outpos] |= ( in[ 26  + inpos]  ) <<  12 ;
    out[ 11  + outpos] |= ( in[ 27  + inpos]  ) <<  26 ;
    out[ 12  + outpos] =  ( in[ 27  + inpos] ) >>> ( 14  -  8 );
    out[ 12  + outpos] |= ( in[ 28  + inpos]  ) <<  8 ;
    out[ 12  + outpos] |= ( in[ 29  + inpos]  ) <<  22 ;
    out[ 13  + outpos] =  ( in[ 29  + inpos] ) >>> ( 14  -  4 );
    out[ 13  + outpos] |= ( in[ 30  + inpos]  ) <<  4 ;
    out[ 13  + outpos] |= ( in[ 31  + inpos]  ) <<  18 ;
}




public static void fastpackwithoutmask15(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  15 ;
    out[ 0  + outpos] |= ( in[ 2  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 2  + inpos] ) >>> ( 15  -  13 );
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  13 ;
    out[ 1  + outpos] |= ( in[ 4  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 4  + inpos] ) >>> ( 15  -  11 );
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  11 ;
    out[ 2  + outpos] |= ( in[ 6  + inpos]  ) <<  26 ;
    out[ 3  + outpos] =  ( in[ 6  + inpos] ) >>> ( 15  -  9 );
    out[ 3  + outpos] |= ( in[ 7  + inpos]  ) <<  9 ;
    out[ 3  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 8  + inpos] ) >>> ( 15  -  7 );
    out[ 4  + outpos] |= ( in[ 9  + inpos]  ) <<  7 ;
    out[ 4  + outpos] |= ( in[ 10  + inpos]  ) <<  22 ;
    out[ 5  + outpos] =  ( in[ 10  + inpos] ) >>> ( 15  -  5 );
    out[ 5  + outpos] |= ( in[ 11  + inpos]  ) <<  5 ;
    out[ 5  + outpos] |= ( in[ 12  + inpos]  ) <<  20 ;
    out[ 6  + outpos] =  ( in[ 12  + inpos] ) >>> ( 15  -  3 );
    out[ 6  + outpos] |= ( in[ 13  + inpos]  ) <<  3 ;
    out[ 6  + outpos] |= ( in[ 14  + inpos]  ) <<  18 ;
    out[ 7  + outpos] =  ( in[ 14  + inpos] ) >>> ( 15  -  1 );
    out[ 7  + outpos] |= ( in[ 15  + inpos]  ) <<  1 ;
    out[ 7  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 7  + outpos] |= ( in[ 17  + inpos]  ) <<  31 ;
    out[ 8  + outpos] =  ( in[ 17  + inpos] ) >>> ( 15  -  14 );
    out[ 8  + outpos] |= ( in[ 18  + inpos]  ) <<  14 ;
    out[ 8  + outpos] |= ( in[ 19  + inpos]  ) <<  29 ;
    out[ 9  + outpos] =  ( in[ 19  + inpos] ) >>> ( 15  -  12 );
    out[ 9  + outpos] |= ( in[ 20  + inpos]  ) <<  12 ;
    out[ 9  + outpos] |= ( in[ 21  + inpos]  ) <<  27 ;
    out[ 10  + outpos] =  ( in[ 21  + inpos] ) >>> ( 15  -  10 );
    out[ 10  + outpos] |= ( in[ 22  + inpos]  ) <<  10 ;
    out[ 10  + outpos] |= ( in[ 23  + inpos]  ) <<  25 ;
    out[ 11  + outpos] =  ( in[ 23  + inpos] ) >>> ( 15  -  8 );
    out[ 11  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 11  + outpos] |= ( in[ 25  + inpos]  ) <<  23 ;
    out[ 12  + outpos] =  ( in[ 25  + inpos] ) >>> ( 15  -  6 );
    out[ 12  + outpos] |= ( in[ 26  + inpos]  ) <<  6 ;
    out[ 12  + outpos] |= ( in[ 27  + inpos]  ) <<  21 ;
    out[ 13  + outpos] =  ( in[ 27  + inpos] ) >>> ( 15  -  4 );
    out[ 13  + outpos] |= ( in[ 28  + inpos]  ) <<  4 ;
    out[ 13  + outpos] |= ( in[ 29  + inpos]  ) <<  19 ;
    out[ 14  + outpos] =  ( in[ 29  + inpos] ) >>> ( 15  -  2 );
    out[ 14  + outpos] |= ( in[ 30  + inpos]  ) <<  2 ;
    out[ 14  + outpos] |= ( in[ 31  + inpos]  ) <<  17 ;
}




public static void fastpackwithoutmask16(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  16 ;
    out[ 1  + outpos] = in[ 2  + inpos] ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  16 ;
    out[ 2  + outpos] = in[ 4  + inpos] ;
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  16 ;
    out[ 3  + outpos] = in[ 6  + inpos] ;
    out[ 3  + outpos] |= ( in[ 7  + inpos]  ) <<  16 ;
    out[ 4  + outpos] = in[ 8  + inpos] ;
    out[ 4  + outpos] |= ( in[ 9  + inpos]  ) <<  16 ;
    out[ 5  + outpos] = in[ 10  + inpos] ;
    out[ 5  + outpos] |= ( in[ 11  + inpos]  ) <<  16 ;
    out[ 6  + outpos] = in[ 12  + inpos] ;
    out[ 6  + outpos] |= ( in[ 13  + inpos]  ) <<  16 ;
    out[ 7  + outpos] = in[ 14  + inpos] ;
    out[ 7  + outpos] |= ( in[ 15  + inpos]  ) <<  16 ;
    out[ 8  + outpos] = in[ 16  + inpos] ;
    out[ 8  + outpos] |= ( in[ 17  + inpos]  ) <<  16 ;
    out[ 9  + outpos] = in[ 18  + inpos] ;
    out[ 9  + outpos] |= ( in[ 19  + inpos]  ) <<  16 ;
    out[ 10  + outpos] = in[ 20  + inpos] ;
    out[ 10  + outpos] |= ( in[ 21  + inpos]  ) <<  16 ;
    out[ 11  + outpos] = in[ 22  + inpos] ;
    out[ 11  + outpos] |= ( in[ 23  + inpos]  ) <<  16 ;
    out[ 12  + outpos] = in[ 24  + inpos] ;
    out[ 12  + outpos] |= ( in[ 25  + inpos]  ) <<  16 ;
    out[ 13  + outpos] = in[ 26  + inpos] ;
    out[ 13  + outpos] |= ( in[ 27  + inpos]  ) <<  16 ;
    out[ 14  + outpos] = in[ 28  + inpos] ;
    out[ 14  + outpos] |= ( in[ 29  + inpos]  ) <<  16 ;
    out[ 15  + outpos] = in[ 30  + inpos] ;
    out[ 15  + outpos] |= ( in[ 31  + inpos]  ) <<  16 ;
}




public static void fastpackwithoutmask17(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  17 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 17  -  2 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  2 ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  19 ;
    out[ 2  + outpos] =  ( in[ 3  + inpos] ) >>> ( 17  -  4 );
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  4 ;
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  21 ;
    out[ 3  + outpos] =  ( in[ 5  + inpos] ) >>> ( 17  -  6 );
    out[ 3  + outpos] |= ( in[ 6  + inpos]  ) <<  6 ;
    out[ 3  + outpos] |= ( in[ 7  + inpos]  ) <<  23 ;
    out[ 4  + outpos] =  ( in[ 7  + inpos] ) >>> ( 17  -  8 );
    out[ 4  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 4  + outpos] |= ( in[ 9  + inpos]  ) <<  25 ;
    out[ 5  + outpos] =  ( in[ 9  + inpos] ) >>> ( 17  -  10 );
    out[ 5  + outpos] |= ( in[ 10  + inpos]  ) <<  10 ;
    out[ 5  + outpos] |= ( in[ 11  + inpos]  ) <<  27 ;
    out[ 6  + outpos] =  ( in[ 11  + inpos] ) >>> ( 17  -  12 );
    out[ 6  + outpos] |= ( in[ 12  + inpos]  ) <<  12 ;
    out[ 6  + outpos] |= ( in[ 13  + inpos]  ) <<  29 ;
    out[ 7  + outpos] =  ( in[ 13  + inpos] ) >>> ( 17  -  14 );
    out[ 7  + outpos] |= ( in[ 14  + inpos]  ) <<  14 ;
    out[ 7  + outpos] |= ( in[ 15  + inpos]  ) <<  31 ;
    out[ 8  + outpos] =  ( in[ 15  + inpos] ) >>> ( 17  -  16 );
    out[ 8  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 9  + outpos] =  ( in[ 16  + inpos] ) >>> ( 17  -  1 );
    out[ 9  + outpos] |= ( in[ 17  + inpos]  ) <<  1 ;
    out[ 9  + outpos] |= ( in[ 18  + inpos]  ) <<  18 ;
    out[ 10  + outpos] =  ( in[ 18  + inpos] ) >>> ( 17  -  3 );
    out[ 10  + outpos] |= ( in[ 19  + inpos]  ) <<  3 ;
    out[ 10  + outpos] |= ( in[ 20  + inpos]  ) <<  20 ;
    out[ 11  + outpos] =  ( in[ 20  + inpos] ) >>> ( 17  -  5 );
    out[ 11  + outpos] |= ( in[ 21  + inpos]  ) <<  5 ;
    out[ 11  + outpos] |= ( in[ 22  + inpos]  ) <<  22 ;
    out[ 12  + outpos] =  ( in[ 22  + inpos] ) >>> ( 17  -  7 );
    out[ 12  + outpos] |= ( in[ 23  + inpos]  ) <<  7 ;
    out[ 12  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 13  + outpos] =  ( in[ 24  + inpos] ) >>> ( 17  -  9 );
    out[ 13  + outpos] |= ( in[ 25  + inpos]  ) <<  9 ;
    out[ 13  + outpos] |= ( in[ 26  + inpos]  ) <<  26 ;
    out[ 14  + outpos] =  ( in[ 26  + inpos] ) >>> ( 17  -  11 );
    out[ 14  + outpos] |= ( in[ 27  + inpos]  ) <<  11 ;
    out[ 14  + outpos] |= ( in[ 28  + inpos]  ) <<  28 ;
    out[ 15  + outpos] =  ( in[ 28  + inpos] ) >>> ( 17  -  13 );
    out[ 15  + outpos] |= ( in[ 29  + inpos]  ) <<  13 ;
    out[ 15  + outpos] |= ( in[ 30  + inpos]  ) <<  30 ;
    out[ 16  + outpos] =  ( in[ 30  + inpos] ) >>> ( 17  -  15 );
    out[ 16  + outpos] |= ( in[ 31  + inpos]  ) <<  15 ;
}




public static void fastpackwithoutmask18(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  18 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 18  -  4 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  4 ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  22 ;
    out[ 2  + outpos] =  ( in[ 3  + inpos] ) >>> ( 18  -  8 );
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  8 ;
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  26 ;
    out[ 3  + outpos] =  ( in[ 5  + inpos] ) >>> ( 18  -  12 );
    out[ 3  + outpos] |= ( in[ 6  + inpos]  ) <<  12 ;
    out[ 3  + outpos] |= ( in[ 7  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 7  + inpos] ) >>> ( 18  -  16 );
    out[ 4  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 5  + outpos] =  ( in[ 8  + inpos] ) >>> ( 18  -  2 );
    out[ 5  + outpos] |= ( in[ 9  + inpos]  ) <<  2 ;
    out[ 5  + outpos] |= ( in[ 10  + inpos]  ) <<  20 ;
    out[ 6  + outpos] =  ( in[ 10  + inpos] ) >>> ( 18  -  6 );
    out[ 6  + outpos] |= ( in[ 11  + inpos]  ) <<  6 ;
    out[ 6  + outpos] |= ( in[ 12  + inpos]  ) <<  24 ;
    out[ 7  + outpos] =  ( in[ 12  + inpos] ) >>> ( 18  -  10 );
    out[ 7  + outpos] |= ( in[ 13  + inpos]  ) <<  10 ;
    out[ 7  + outpos] |= ( in[ 14  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 14  + inpos] ) >>> ( 18  -  14 );
    out[ 8  + outpos] |= ( in[ 15  + inpos]  ) <<  14 ;
    out[ 9  + outpos] = in[ 16  + inpos] ;
    out[ 9  + outpos] |= ( in[ 17  + inpos]  ) <<  18 ;
    out[ 10  + outpos] =  ( in[ 17  + inpos] ) >>> ( 18  -  4 );
    out[ 10  + outpos] |= ( in[ 18  + inpos]  ) <<  4 ;
    out[ 10  + outpos] |= ( in[ 19  + inpos]  ) <<  22 ;
    out[ 11  + outpos] =  ( in[ 19  + inpos] ) >>> ( 18  -  8 );
    out[ 11  + outpos] |= ( in[ 20  + inpos]  ) <<  8 ;
    out[ 11  + outpos] |= ( in[ 21  + inpos]  ) <<  26 ;
    out[ 12  + outpos] =  ( in[ 21  + inpos] ) >>> ( 18  -  12 );
    out[ 12  + outpos] |= ( in[ 22  + inpos]  ) <<  12 ;
    out[ 12  + outpos] |= ( in[ 23  + inpos]  ) <<  30 ;
    out[ 13  + outpos] =  ( in[ 23  + inpos] ) >>> ( 18  -  16 );
    out[ 13  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 14  + outpos] =  ( in[ 24  + inpos] ) >>> ( 18  -  2 );
    out[ 14  + outpos] |= ( in[ 25  + inpos]  ) <<  2 ;
    out[ 14  + outpos] |= ( in[ 26  + inpos]  ) <<  20 ;
    out[ 15  + outpos] =  ( in[ 26  + inpos] ) >>> ( 18  -  6 );
    out[ 15  + outpos] |= ( in[ 27  + inpos]  ) <<  6 ;
    out[ 15  + outpos] |= ( in[ 28  + inpos]  ) <<  24 ;
    out[ 16  + outpos] =  ( in[ 28  + inpos] ) >>> ( 18  -  10 );
    out[ 16  + outpos] |= ( in[ 29  + inpos]  ) <<  10 ;
    out[ 16  + outpos] |= ( in[ 30  + inpos]  ) <<  28 ;
    out[ 17  + outpos] =  ( in[ 30  + inpos] ) >>> ( 18  -  14 );
    out[ 17  + outpos] |= ( in[ 31  + inpos]  ) <<  14 ;
}




public static void fastpackwithoutmask19(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  19 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 19  -  6 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  6 ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  25 ;
    out[ 2  + outpos] =  ( in[ 3  + inpos] ) >>> ( 19  -  12 );
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  12 ;
    out[ 2  + outpos] |= ( in[ 5  + inpos]  ) <<  31 ;
    out[ 3  + outpos] =  ( in[ 5  + inpos] ) >>> ( 19  -  18 );
    out[ 3  + outpos] |= ( in[ 6  + inpos]  ) <<  18 ;
    out[ 4  + outpos] =  ( in[ 6  + inpos] ) >>> ( 19  -  5 );
    out[ 4  + outpos] |= ( in[ 7  + inpos]  ) <<  5 ;
    out[ 4  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 5  + outpos] =  ( in[ 8  + inpos] ) >>> ( 19  -  11 );
    out[ 5  + outpos] |= ( in[ 9  + inpos]  ) <<  11 ;
    out[ 5  + outpos] |= ( in[ 10  + inpos]  ) <<  30 ;
    out[ 6  + outpos] =  ( in[ 10  + inpos] ) >>> ( 19  -  17 );
    out[ 6  + outpos] |= ( in[ 11  + inpos]  ) <<  17 ;
    out[ 7  + outpos] =  ( in[ 11  + inpos] ) >>> ( 19  -  4 );
    out[ 7  + outpos] |= ( in[ 12  + inpos]  ) <<  4 ;
    out[ 7  + outpos] |= ( in[ 13  + inpos]  ) <<  23 ;
    out[ 8  + outpos] =  ( in[ 13  + inpos] ) >>> ( 19  -  10 );
    out[ 8  + outpos] |= ( in[ 14  + inpos]  ) <<  10 ;
    out[ 8  + outpos] |= ( in[ 15  + inpos]  ) <<  29 ;
    out[ 9  + outpos] =  ( in[ 15  + inpos] ) >>> ( 19  -  16 );
    out[ 9  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 10  + outpos] =  ( in[ 16  + inpos] ) >>> ( 19  -  3 );
    out[ 10  + outpos] |= ( in[ 17  + inpos]  ) <<  3 ;
    out[ 10  + outpos] |= ( in[ 18  + inpos]  ) <<  22 ;
    out[ 11  + outpos] =  ( in[ 18  + inpos] ) >>> ( 19  -  9 );
    out[ 11  + outpos] |= ( in[ 19  + inpos]  ) <<  9 ;
    out[ 11  + outpos] |= ( in[ 20  + inpos]  ) <<  28 ;
    out[ 12  + outpos] =  ( in[ 20  + inpos] ) >>> ( 19  -  15 );
    out[ 12  + outpos] |= ( in[ 21  + inpos]  ) <<  15 ;
    out[ 13  + outpos] =  ( in[ 21  + inpos] ) >>> ( 19  -  2 );
    out[ 13  + outpos] |= ( in[ 22  + inpos]  ) <<  2 ;
    out[ 13  + outpos] |= ( in[ 23  + inpos]  ) <<  21 ;
    out[ 14  + outpos] =  ( in[ 23  + inpos] ) >>> ( 19  -  8 );
    out[ 14  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 14  + outpos] |= ( in[ 25  + inpos]  ) <<  27 ;
    out[ 15  + outpos] =  ( in[ 25  + inpos] ) >>> ( 19  -  14 );
    out[ 15  + outpos] |= ( in[ 26  + inpos]  ) <<  14 ;
    out[ 16  + outpos] =  ( in[ 26  + inpos] ) >>> ( 19  -  1 );
    out[ 16  + outpos] |= ( in[ 27  + inpos]  ) <<  1 ;
    out[ 16  + outpos] |= ( in[ 28  + inpos]  ) <<  20 ;
    out[ 17  + outpos] =  ( in[ 28  + inpos] ) >>> ( 19  -  7 );
    out[ 17  + outpos] |= ( in[ 29  + inpos]  ) <<  7 ;
    out[ 17  + outpos] |= ( in[ 30  + inpos]  ) <<  26 ;
    out[ 18  + outpos] =  ( in[ 30  + inpos] ) >>> ( 19  -  13 );
    out[ 18  + outpos] |= ( in[ 31  + inpos]  ) <<  13 ;
}




public static void fastpackwithoutmask20(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  20 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 20  -  8 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  8 ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 3  + inpos] ) >>> ( 20  -  16 );
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  16 ;
    out[ 3  + outpos] =  ( in[ 4  + inpos] ) >>> ( 20  -  4 );
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  4 ;
    out[ 3  + outpos] |= ( in[ 6  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 6  + inpos] ) >>> ( 20  -  12 );
    out[ 4  + outpos] |= ( in[ 7  + inpos]  ) <<  12 ;
    out[ 5  + outpos] = in[ 8  + inpos] ;
    out[ 5  + outpos] |= ( in[ 9  + inpos]  ) <<  20 ;
    out[ 6  + outpos] =  ( in[ 9  + inpos] ) >>> ( 20  -  8 );
    out[ 6  + outpos] |= ( in[ 10  + inpos]  ) <<  8 ;
    out[ 6  + outpos] |= ( in[ 11  + inpos]  ) <<  28 ;
    out[ 7  + outpos] =  ( in[ 11  + inpos] ) >>> ( 20  -  16 );
    out[ 7  + outpos] |= ( in[ 12  + inpos]  ) <<  16 ;
    out[ 8  + outpos] =  ( in[ 12  + inpos] ) >>> ( 20  -  4 );
    out[ 8  + outpos] |= ( in[ 13  + inpos]  ) <<  4 ;
    out[ 8  + outpos] |= ( in[ 14  + inpos]  ) <<  24 ;
    out[ 9  + outpos] =  ( in[ 14  + inpos] ) >>> ( 20  -  12 );
    out[ 9  + outpos] |= ( in[ 15  + inpos]  ) <<  12 ;
    out[ 10  + outpos] = in[ 16  + inpos] ;
    out[ 10  + outpos] |= ( in[ 17  + inpos]  ) <<  20 ;
    out[ 11  + outpos] =  ( in[ 17  + inpos] ) >>> ( 20  -  8 );
    out[ 11  + outpos] |= ( in[ 18  + inpos]  ) <<  8 ;
    out[ 11  + outpos] |= ( in[ 19  + inpos]  ) <<  28 ;
    out[ 12  + outpos] =  ( in[ 19  + inpos] ) >>> ( 20  -  16 );
    out[ 12  + outpos] |= ( in[ 20  + inpos]  ) <<  16 ;
    out[ 13  + outpos] =  ( in[ 20  + inpos] ) >>> ( 20  -  4 );
    out[ 13  + outpos] |= ( in[ 21  + inpos]  ) <<  4 ;
    out[ 13  + outpos] |= ( in[ 22  + inpos]  ) <<  24 ;
    out[ 14  + outpos] =  ( in[ 22  + inpos] ) >>> ( 20  -  12 );
    out[ 14  + outpos] |= ( in[ 23  + inpos]  ) <<  12 ;
    out[ 15  + outpos] = in[ 24  + inpos] ;
    out[ 15  + outpos] |= ( in[ 25  + inpos]  ) <<  20 ;
    out[ 16  + outpos] =  ( in[ 25  + inpos] ) >>> ( 20  -  8 );
    out[ 16  + outpos] |= ( in[ 26  + inpos]  ) <<  8 ;
    out[ 16  + outpos] |= ( in[ 27  + inpos]  ) <<  28 ;
    out[ 17  + outpos] =  ( in[ 27  + inpos] ) >>> ( 20  -  16 );
    out[ 17  + outpos] |= ( in[ 28  + inpos]  ) <<  16 ;
    out[ 18  + outpos] =  ( in[ 28  + inpos] ) >>> ( 20  -  4 );
    out[ 18  + outpos] |= ( in[ 29  + inpos]  ) <<  4 ;
    out[ 18  + outpos] |= ( in[ 30  + inpos]  ) <<  24 ;
    out[ 19  + outpos] =  ( in[ 30  + inpos] ) >>> ( 20  -  12 );
    out[ 19  + outpos] |= ( in[ 31  + inpos]  ) <<  12 ;
}




public static void fastpackwithoutmask21(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  21 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 21  -  10 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  10 ;
    out[ 1  + outpos] |= ( in[ 3  + inpos]  ) <<  31 ;
    out[ 2  + outpos] =  ( in[ 3  + inpos] ) >>> ( 21  -  20 );
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  20 ;
    out[ 3  + outpos] =  ( in[ 4  + inpos] ) >>> ( 21  -  9 );
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  9 ;
    out[ 3  + outpos] |= ( in[ 6  + inpos]  ) <<  30 ;
    out[ 4  + outpos] =  ( in[ 6  + inpos] ) >>> ( 21  -  19 );
    out[ 4  + outpos] |= ( in[ 7  + inpos]  ) <<  19 ;
    out[ 5  + outpos] =  ( in[ 7  + inpos] ) >>> ( 21  -  8 );
    out[ 5  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 5  + outpos] |= ( in[ 9  + inpos]  ) <<  29 ;
    out[ 6  + outpos] =  ( in[ 9  + inpos] ) >>> ( 21  -  18 );
    out[ 6  + outpos] |= ( in[ 10  + inpos]  ) <<  18 ;
    out[ 7  + outpos] =  ( in[ 10  + inpos] ) >>> ( 21  -  7 );
    out[ 7  + outpos] |= ( in[ 11  + inpos]  ) <<  7 ;
    out[ 7  + outpos] |= ( in[ 12  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 12  + inpos] ) >>> ( 21  -  17 );
    out[ 8  + outpos] |= ( in[ 13  + inpos]  ) <<  17 ;
    out[ 9  + outpos] =  ( in[ 13  + inpos] ) >>> ( 21  -  6 );
    out[ 9  + outpos] |= ( in[ 14  + inpos]  ) <<  6 ;
    out[ 9  + outpos] |= ( in[ 15  + inpos]  ) <<  27 ;
    out[ 10  + outpos] =  ( in[ 15  + inpos] ) >>> ( 21  -  16 );
    out[ 10  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 11  + outpos] =  ( in[ 16  + inpos] ) >>> ( 21  -  5 );
    out[ 11  + outpos] |= ( in[ 17  + inpos]  ) <<  5 ;
    out[ 11  + outpos] |= ( in[ 18  + inpos]  ) <<  26 ;
    out[ 12  + outpos] =  ( in[ 18  + inpos] ) >>> ( 21  -  15 );
    out[ 12  + outpos] |= ( in[ 19  + inpos]  ) <<  15 ;
    out[ 13  + outpos] =  ( in[ 19  + inpos] ) >>> ( 21  -  4 );
    out[ 13  + outpos] |= ( in[ 20  + inpos]  ) <<  4 ;
    out[ 13  + outpos] |= ( in[ 21  + inpos]  ) <<  25 ;
    out[ 14  + outpos] =  ( in[ 21  + inpos] ) >>> ( 21  -  14 );
    out[ 14  + outpos] |= ( in[ 22  + inpos]  ) <<  14 ;
    out[ 15  + outpos] =  ( in[ 22  + inpos] ) >>> ( 21  -  3 );
    out[ 15  + outpos] |= ( in[ 23  + inpos]  ) <<  3 ;
    out[ 15  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 16  + outpos] =  ( in[ 24  + inpos] ) >>> ( 21  -  13 );
    out[ 16  + outpos] |= ( in[ 25  + inpos]  ) <<  13 ;
    out[ 17  + outpos] =  ( in[ 25  + inpos] ) >>> ( 21  -  2 );
    out[ 17  + outpos] |= ( in[ 26  + inpos]  ) <<  2 ;
    out[ 17  + outpos] |= ( in[ 27  + inpos]  ) <<  23 ;
    out[ 18  + outpos] =  ( in[ 27  + inpos] ) >>> ( 21  -  12 );
    out[ 18  + outpos] |= ( in[ 28  + inpos]  ) <<  12 ;
    out[ 19  + outpos] =  ( in[ 28  + inpos] ) >>> ( 21  -  1 );
    out[ 19  + outpos] |= ( in[ 29  + inpos]  ) <<  1 ;
    out[ 19  + outpos] |= ( in[ 30  + inpos]  ) <<  22 ;
    out[ 20  + outpos] =  ( in[ 30  + inpos] ) >>> ( 21  -  11 );
    out[ 20  + outpos] |= ( in[ 31  + inpos]  ) <<  11 ;
}




public static void fastpackwithoutmask22(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  22 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 22  -  12 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  12 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 22  -  2 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  2 ;
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  24 ;
    out[ 3  + outpos] =  ( in[ 4  + inpos] ) >>> ( 22  -  14 );
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  14 ;
    out[ 4  + outpos] =  ( in[ 5  + inpos] ) >>> ( 22  -  4 );
    out[ 4  + outpos] |= ( in[ 6  + inpos]  ) <<  4 ;
    out[ 4  + outpos] |= ( in[ 7  + inpos]  ) <<  26 ;
    out[ 5  + outpos] =  ( in[ 7  + inpos] ) >>> ( 22  -  16 );
    out[ 5  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 6  + outpos] =  ( in[ 8  + inpos] ) >>> ( 22  -  6 );
    out[ 6  + outpos] |= ( in[ 9  + inpos]  ) <<  6 ;
    out[ 6  + outpos] |= ( in[ 10  + inpos]  ) <<  28 ;
    out[ 7  + outpos] =  ( in[ 10  + inpos] ) >>> ( 22  -  18 );
    out[ 7  + outpos] |= ( in[ 11  + inpos]  ) <<  18 ;
    out[ 8  + outpos] =  ( in[ 11  + inpos] ) >>> ( 22  -  8 );
    out[ 8  + outpos] |= ( in[ 12  + inpos]  ) <<  8 ;
    out[ 8  + outpos] |= ( in[ 13  + inpos]  ) <<  30 ;
    out[ 9  + outpos] =  ( in[ 13  + inpos] ) >>> ( 22  -  20 );
    out[ 9  + outpos] |= ( in[ 14  + inpos]  ) <<  20 ;
    out[ 10  + outpos] =  ( in[ 14  + inpos] ) >>> ( 22  -  10 );
    out[ 10  + outpos] |= ( in[ 15  + inpos]  ) <<  10 ;
    out[ 11  + outpos] = in[ 16  + inpos] ;
    out[ 11  + outpos] |= ( in[ 17  + inpos]  ) <<  22 ;
    out[ 12  + outpos] =  ( in[ 17  + inpos] ) >>> ( 22  -  12 );
    out[ 12  + outpos] |= ( in[ 18  + inpos]  ) <<  12 ;
    out[ 13  + outpos] =  ( in[ 18  + inpos] ) >>> ( 22  -  2 );
    out[ 13  + outpos] |= ( in[ 19  + inpos]  ) <<  2 ;
    out[ 13  + outpos] |= ( in[ 20  + inpos]  ) <<  24 ;
    out[ 14  + outpos] =  ( in[ 20  + inpos] ) >>> ( 22  -  14 );
    out[ 14  + outpos] |= ( in[ 21  + inpos]  ) <<  14 ;
    out[ 15  + outpos] =  ( in[ 21  + inpos] ) >>> ( 22  -  4 );
    out[ 15  + outpos] |= ( in[ 22  + inpos]  ) <<  4 ;
    out[ 15  + outpos] |= ( in[ 23  + inpos]  ) <<  26 ;
    out[ 16  + outpos] =  ( in[ 23  + inpos] ) >>> ( 22  -  16 );
    out[ 16  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 17  + outpos] =  ( in[ 24  + inpos] ) >>> ( 22  -  6 );
    out[ 17  + outpos] |= ( in[ 25  + inpos]  ) <<  6 ;
    out[ 17  + outpos] |= ( in[ 26  + inpos]  ) <<  28 ;
    out[ 18  + outpos] =  ( in[ 26  + inpos] ) >>> ( 22  -  18 );
    out[ 18  + outpos] |= ( in[ 27  + inpos]  ) <<  18 ;
    out[ 19  + outpos] =  ( in[ 27  + inpos] ) >>> ( 22  -  8 );
    out[ 19  + outpos] |= ( in[ 28  + inpos]  ) <<  8 ;
    out[ 19  + outpos] |= ( in[ 29  + inpos]  ) <<  30 ;
    out[ 20  + outpos] =  ( in[ 29  + inpos] ) >>> ( 22  -  20 );
    out[ 20  + outpos] |= ( in[ 30  + inpos]  ) <<  20 ;
    out[ 21  + outpos] =  ( in[ 30  + inpos] ) >>> ( 22  -  10 );
    out[ 21  + outpos] |= ( in[ 31  + inpos]  ) <<  10 ;
}




public static void fastpackwithoutmask23(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  23 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 23  -  14 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  14 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 23  -  5 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  5 ;
    out[ 2  + outpos] |= ( in[ 4  + inpos]  ) <<  28 ;
    out[ 3  + outpos] =  ( in[ 4  + inpos] ) >>> ( 23  -  19 );
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  19 ;
    out[ 4  + outpos] =  ( in[ 5  + inpos] ) >>> ( 23  -  10 );
    out[ 4  + outpos] |= ( in[ 6  + inpos]  ) <<  10 ;
    out[ 5  + outpos] =  ( in[ 6  + inpos] ) >>> ( 23  -  1 );
    out[ 5  + outpos] |= ( in[ 7  + inpos]  ) <<  1 ;
    out[ 5  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 6  + outpos] =  ( in[ 8  + inpos] ) >>> ( 23  -  15 );
    out[ 6  + outpos] |= ( in[ 9  + inpos]  ) <<  15 ;
    out[ 7  + outpos] =  ( in[ 9  + inpos] ) >>> ( 23  -  6 );
    out[ 7  + outpos] |= ( in[ 10  + inpos]  ) <<  6 ;
    out[ 7  + outpos] |= ( in[ 11  + inpos]  ) <<  29 ;
    out[ 8  + outpos] =  ( in[ 11  + inpos] ) >>> ( 23  -  20 );
    out[ 8  + outpos] |= ( in[ 12  + inpos]  ) <<  20 ;
    out[ 9  + outpos] =  ( in[ 12  + inpos] ) >>> ( 23  -  11 );
    out[ 9  + outpos] |= ( in[ 13  + inpos]  ) <<  11 ;
    out[ 10  + outpos] =  ( in[ 13  + inpos] ) >>> ( 23  -  2 );
    out[ 10  + outpos] |= ( in[ 14  + inpos]  ) <<  2 ;
    out[ 10  + outpos] |= ( in[ 15  + inpos]  ) <<  25 ;
    out[ 11  + outpos] =  ( in[ 15  + inpos] ) >>> ( 23  -  16 );
    out[ 11  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 12  + outpos] =  ( in[ 16  + inpos] ) >>> ( 23  -  7 );
    out[ 12  + outpos] |= ( in[ 17  + inpos]  ) <<  7 ;
    out[ 12  + outpos] |= ( in[ 18  + inpos]  ) <<  30 ;
    out[ 13  + outpos] =  ( in[ 18  + inpos] ) >>> ( 23  -  21 );
    out[ 13  + outpos] |= ( in[ 19  + inpos]  ) <<  21 ;
    out[ 14  + outpos] =  ( in[ 19  + inpos] ) >>> ( 23  -  12 );
    out[ 14  + outpos] |= ( in[ 20  + inpos]  ) <<  12 ;
    out[ 15  + outpos] =  ( in[ 20  + inpos] ) >>> ( 23  -  3 );
    out[ 15  + outpos] |= ( in[ 21  + inpos]  ) <<  3 ;
    out[ 15  + outpos] |= ( in[ 22  + inpos]  ) <<  26 ;
    out[ 16  + outpos] =  ( in[ 22  + inpos] ) >>> ( 23  -  17 );
    out[ 16  + outpos] |= ( in[ 23  + inpos]  ) <<  17 ;
    out[ 17  + outpos] =  ( in[ 23  + inpos] ) >>> ( 23  -  8 );
    out[ 17  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 17  + outpos] |= ( in[ 25  + inpos]  ) <<  31 ;
    out[ 18  + outpos] =  ( in[ 25  + inpos] ) >>> ( 23  -  22 );
    out[ 18  + outpos] |= ( in[ 26  + inpos]  ) <<  22 ;
    out[ 19  + outpos] =  ( in[ 26  + inpos] ) >>> ( 23  -  13 );
    out[ 19  + outpos] |= ( in[ 27  + inpos]  ) <<  13 ;
    out[ 20  + outpos] =  ( in[ 27  + inpos] ) >>> ( 23  -  4 );
    out[ 20  + outpos] |= ( in[ 28  + inpos]  ) <<  4 ;
    out[ 20  + outpos] |= ( in[ 29  + inpos]  ) <<  27 ;
    out[ 21  + outpos] =  ( in[ 29  + inpos] ) >>> ( 23  -  18 );
    out[ 21  + outpos] |= ( in[ 30  + inpos]  ) <<  18 ;
    out[ 22  + outpos] =  ( in[ 30  + inpos] ) >>> ( 23  -  9 );
    out[ 22  + outpos] |= ( in[ 31  + inpos]  ) <<  9 ;
}




public static void fastpackwithoutmask24(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  24 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 24  -  16 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  16 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 24  -  8 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  8 ;
    out[ 3  + outpos] = in[ 4  + inpos] ;
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 5  + inpos] ) >>> ( 24  -  16 );
    out[ 4  + outpos] |= ( in[ 6  + inpos]  ) <<  16 ;
    out[ 5  + outpos] =  ( in[ 6  + inpos] ) >>> ( 24  -  8 );
    out[ 5  + outpos] |= ( in[ 7  + inpos]  ) <<  8 ;
    out[ 6  + outpos] = in[ 8  + inpos] ;
    out[ 6  + outpos] |= ( in[ 9  + inpos]  ) <<  24 ;
    out[ 7  + outpos] =  ( in[ 9  + inpos] ) >>> ( 24  -  16 );
    out[ 7  + outpos] |= ( in[ 10  + inpos]  ) <<  16 ;
    out[ 8  + outpos] =  ( in[ 10  + inpos] ) >>> ( 24  -  8 );
    out[ 8  + outpos] |= ( in[ 11  + inpos]  ) <<  8 ;
    out[ 9  + outpos] = in[ 12  + inpos] ;
    out[ 9  + outpos] |= ( in[ 13  + inpos]  ) <<  24 ;
    out[ 10  + outpos] =  ( in[ 13  + inpos] ) >>> ( 24  -  16 );
    out[ 10  + outpos] |= ( in[ 14  + inpos]  ) <<  16 ;
    out[ 11  + outpos] =  ( in[ 14  + inpos] ) >>> ( 24  -  8 );
    out[ 11  + outpos] |= ( in[ 15  + inpos]  ) <<  8 ;
    out[ 12  + outpos] = in[ 16  + inpos] ;
    out[ 12  + outpos] |= ( in[ 17  + inpos]  ) <<  24 ;
    out[ 13  + outpos] =  ( in[ 17  + inpos] ) >>> ( 24  -  16 );
    out[ 13  + outpos] |= ( in[ 18  + inpos]  ) <<  16 ;
    out[ 14  + outpos] =  ( in[ 18  + inpos] ) >>> ( 24  -  8 );
    out[ 14  + outpos] |= ( in[ 19  + inpos]  ) <<  8 ;
    out[ 15  + outpos] = in[ 20  + inpos] ;
    out[ 15  + outpos] |= ( in[ 21  + inpos]  ) <<  24 ;
    out[ 16  + outpos] =  ( in[ 21  + inpos] ) >>> ( 24  -  16 );
    out[ 16  + outpos] |= ( in[ 22  + inpos]  ) <<  16 ;
    out[ 17  + outpos] =  ( in[ 22  + inpos] ) >>> ( 24  -  8 );
    out[ 17  + outpos] |= ( in[ 23  + inpos]  ) <<  8 ;
    out[ 18  + outpos] = in[ 24  + inpos] ;
    out[ 18  + outpos] |= ( in[ 25  + inpos]  ) <<  24 ;
    out[ 19  + outpos] =  ( in[ 25  + inpos] ) >>> ( 24  -  16 );
    out[ 19  + outpos] |= ( in[ 26  + inpos]  ) <<  16 ;
    out[ 20  + outpos] =  ( in[ 26  + inpos] ) >>> ( 24  -  8 );
    out[ 20  + outpos] |= ( in[ 27  + inpos]  ) <<  8 ;
    out[ 21  + outpos] = in[ 28  + inpos] ;
    out[ 21  + outpos] |= ( in[ 29  + inpos]  ) <<  24 ;
    out[ 22  + outpos] =  ( in[ 29  + inpos] ) >>> ( 24  -  16 );
    out[ 22  + outpos] |= ( in[ 30  + inpos]  ) <<  16 ;
    out[ 23  + outpos] =  ( in[ 30  + inpos] ) >>> ( 24  -  8 );
    out[ 23  + outpos] |= ( in[ 31  + inpos]  ) <<  8 ;
}




public static void fastpackwithoutmask25(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  25 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 25  -  18 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  18 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 25  -  11 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  11 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 25  -  4 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  4 ;
    out[ 3  + outpos] |= ( in[ 5  + inpos]  ) <<  29 ;
    out[ 4  + outpos] =  ( in[ 5  + inpos] ) >>> ( 25  -  22 );
    out[ 4  + outpos] |= ( in[ 6  + inpos]  ) <<  22 ;
    out[ 5  + outpos] =  ( in[ 6  + inpos] ) >>> ( 25  -  15 );
    out[ 5  + outpos] |= ( in[ 7  + inpos]  ) <<  15 ;
    out[ 6  + outpos] =  ( in[ 7  + inpos] ) >>> ( 25  -  8 );
    out[ 6  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 7  + outpos] =  ( in[ 8  + inpos] ) >>> ( 25  -  1 );
    out[ 7  + outpos] |= ( in[ 9  + inpos]  ) <<  1 ;
    out[ 7  + outpos] |= ( in[ 10  + inpos]  ) <<  26 ;
    out[ 8  + outpos] =  ( in[ 10  + inpos] ) >>> ( 25  -  19 );
    out[ 8  + outpos] |= ( in[ 11  + inpos]  ) <<  19 ;
    out[ 9  + outpos] =  ( in[ 11  + inpos] ) >>> ( 25  -  12 );
    out[ 9  + outpos] |= ( in[ 12  + inpos]  ) <<  12 ;
    out[ 10  + outpos] =  ( in[ 12  + inpos] ) >>> ( 25  -  5 );
    out[ 10  + outpos] |= ( in[ 13  + inpos]  ) <<  5 ;
    out[ 10  + outpos] |= ( in[ 14  + inpos]  ) <<  30 ;
    out[ 11  + outpos] =  ( in[ 14  + inpos] ) >>> ( 25  -  23 );
    out[ 11  + outpos] |= ( in[ 15  + inpos]  ) <<  23 ;
    out[ 12  + outpos] =  ( in[ 15  + inpos] ) >>> ( 25  -  16 );
    out[ 12  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 13  + outpos] =  ( in[ 16  + inpos] ) >>> ( 25  -  9 );
    out[ 13  + outpos] |= ( in[ 17  + inpos]  ) <<  9 ;
    out[ 14  + outpos] =  ( in[ 17  + inpos] ) >>> ( 25  -  2 );
    out[ 14  + outpos] |= ( in[ 18  + inpos]  ) <<  2 ;
    out[ 14  + outpos] |= ( in[ 19  + inpos]  ) <<  27 ;
    out[ 15  + outpos] =  ( in[ 19  + inpos] ) >>> ( 25  -  20 );
    out[ 15  + outpos] |= ( in[ 20  + inpos]  ) <<  20 ;
    out[ 16  + outpos] =  ( in[ 20  + inpos] ) >>> ( 25  -  13 );
    out[ 16  + outpos] |= ( in[ 21  + inpos]  ) <<  13 ;
    out[ 17  + outpos] =  ( in[ 21  + inpos] ) >>> ( 25  -  6 );
    out[ 17  + outpos] |= ( in[ 22  + inpos]  ) <<  6 ;
    out[ 17  + outpos] |= ( in[ 23  + inpos]  ) <<  31 ;
    out[ 18  + outpos] =  ( in[ 23  + inpos] ) >>> ( 25  -  24 );
    out[ 18  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 19  + outpos] =  ( in[ 24  + inpos] ) >>> ( 25  -  17 );
    out[ 19  + outpos] |= ( in[ 25  + inpos]  ) <<  17 ;
    out[ 20  + outpos] =  ( in[ 25  + inpos] ) >>> ( 25  -  10 );
    out[ 20  + outpos] |= ( in[ 26  + inpos]  ) <<  10 ;
    out[ 21  + outpos] =  ( in[ 26  + inpos] ) >>> ( 25  -  3 );
    out[ 21  + outpos] |= ( in[ 27  + inpos]  ) <<  3 ;
    out[ 21  + outpos] |= ( in[ 28  + inpos]  ) <<  28 ;
    out[ 22  + outpos] =  ( in[ 28  + inpos] ) >>> ( 25  -  21 );
    out[ 22  + outpos] |= ( in[ 29  + inpos]  ) <<  21 ;
    out[ 23  + outpos] =  ( in[ 29  + inpos] ) >>> ( 25  -  14 );
    out[ 23  + outpos] |= ( in[ 30  + inpos]  ) <<  14 ;
    out[ 24  + outpos] =  ( in[ 30  + inpos] ) >>> ( 25  -  7 );
    out[ 24  + outpos] |= ( in[ 31  + inpos]  ) <<  7 ;
}




public static void fastpackwithoutmask26(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  26 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 26  -  20 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  20 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 26  -  14 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  14 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 26  -  8 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  8 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 26  -  2 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  2 ;
    out[ 4  + outpos] |= ( in[ 6  + inpos]  ) <<  28 ;
    out[ 5  + outpos] =  ( in[ 6  + inpos] ) >>> ( 26  -  22 );
    out[ 5  + outpos] |= ( in[ 7  + inpos]  ) <<  22 ;
    out[ 6  + outpos] =  ( in[ 7  + inpos] ) >>> ( 26  -  16 );
    out[ 6  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 7  + outpos] =  ( in[ 8  + inpos] ) >>> ( 26  -  10 );
    out[ 7  + outpos] |= ( in[ 9  + inpos]  ) <<  10 ;
    out[ 8  + outpos] =  ( in[ 9  + inpos] ) >>> ( 26  -  4 );
    out[ 8  + outpos] |= ( in[ 10  + inpos]  ) <<  4 ;
    out[ 8  + outpos] |= ( in[ 11  + inpos]  ) <<  30 ;
    out[ 9  + outpos] =  ( in[ 11  + inpos] ) >>> ( 26  -  24 );
    out[ 9  + outpos] |= ( in[ 12  + inpos]  ) <<  24 ;
    out[ 10  + outpos] =  ( in[ 12  + inpos] ) >>> ( 26  -  18 );
    out[ 10  + outpos] |= ( in[ 13  + inpos]  ) <<  18 ;
    out[ 11  + outpos] =  ( in[ 13  + inpos] ) >>> ( 26  -  12 );
    out[ 11  + outpos] |= ( in[ 14  + inpos]  ) <<  12 ;
    out[ 12  + outpos] =  ( in[ 14  + inpos] ) >>> ( 26  -  6 );
    out[ 12  + outpos] |= ( in[ 15  + inpos]  ) <<  6 ;
    out[ 13  + outpos] = in[ 16  + inpos] ;
    out[ 13  + outpos] |= ( in[ 17  + inpos]  ) <<  26 ;
    out[ 14  + outpos] =  ( in[ 17  + inpos] ) >>> ( 26  -  20 );
    out[ 14  + outpos] |= ( in[ 18  + inpos]  ) <<  20 ;
    out[ 15  + outpos] =  ( in[ 18  + inpos] ) >>> ( 26  -  14 );
    out[ 15  + outpos] |= ( in[ 19  + inpos]  ) <<  14 ;
    out[ 16  + outpos] =  ( in[ 19  + inpos] ) >>> ( 26  -  8 );
    out[ 16  + outpos] |= ( in[ 20  + inpos]  ) <<  8 ;
    out[ 17  + outpos] =  ( in[ 20  + inpos] ) >>> ( 26  -  2 );
    out[ 17  + outpos] |= ( in[ 21  + inpos]  ) <<  2 ;
    out[ 17  + outpos] |= ( in[ 22  + inpos]  ) <<  28 ;
    out[ 18  + outpos] =  ( in[ 22  + inpos] ) >>> ( 26  -  22 );
    out[ 18  + outpos] |= ( in[ 23  + inpos]  ) <<  22 ;
    out[ 19  + outpos] =  ( in[ 23  + inpos] ) >>> ( 26  -  16 );
    out[ 19  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 20  + outpos] =  ( in[ 24  + inpos] ) >>> ( 26  -  10 );
    out[ 20  + outpos] |= ( in[ 25  + inpos]  ) <<  10 ;
    out[ 21  + outpos] =  ( in[ 25  + inpos] ) >>> ( 26  -  4 );
    out[ 21  + outpos] |= ( in[ 26  + inpos]  ) <<  4 ;
    out[ 21  + outpos] |= ( in[ 27  + inpos]  ) <<  30 ;
    out[ 22  + outpos] =  ( in[ 27  + inpos] ) >>> ( 26  -  24 );
    out[ 22  + outpos] |= ( in[ 28  + inpos]  ) <<  24 ;
    out[ 23  + outpos] =  ( in[ 28  + inpos] ) >>> ( 26  -  18 );
    out[ 23  + outpos] |= ( in[ 29  + inpos]  ) <<  18 ;
    out[ 24  + outpos] =  ( in[ 29  + inpos] ) >>> ( 26  -  12 );
    out[ 24  + outpos] |= ( in[ 30  + inpos]  ) <<  12 ;
    out[ 25  + outpos] =  ( in[ 30  + inpos] ) >>> ( 26  -  6 );
    out[ 25  + outpos] |= ( in[ 31  + inpos]  ) <<  6 ;
}




public static void fastpackwithoutmask27(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  27 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 27  -  22 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  22 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 27  -  17 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  17 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 27  -  12 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  12 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 27  -  7 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  7 ;
    out[ 5  + outpos] =  ( in[ 5  + inpos] ) >>> ( 27  -  2 );
    out[ 5  + outpos] |= ( in[ 6  + inpos]  ) <<  2 ;
    out[ 5  + outpos] |= ( in[ 7  + inpos]  ) <<  29 ;
    out[ 6  + outpos] =  ( in[ 7  + inpos] ) >>> ( 27  -  24 );
    out[ 6  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 7  + outpos] =  ( in[ 8  + inpos] ) >>> ( 27  -  19 );
    out[ 7  + outpos] |= ( in[ 9  + inpos]  ) <<  19 ;
    out[ 8  + outpos] =  ( in[ 9  + inpos] ) >>> ( 27  -  14 );
    out[ 8  + outpos] |= ( in[ 10  + inpos]  ) <<  14 ;
    out[ 9  + outpos] =  ( in[ 10  + inpos] ) >>> ( 27  -  9 );
    out[ 9  + outpos] |= ( in[ 11  + inpos]  ) <<  9 ;
    out[ 10  + outpos] =  ( in[ 11  + inpos] ) >>> ( 27  -  4 );
    out[ 10  + outpos] |= ( in[ 12  + inpos]  ) <<  4 ;
    out[ 10  + outpos] |= ( in[ 13  + inpos]  ) <<  31 ;
    out[ 11  + outpos] =  ( in[ 13  + inpos] ) >>> ( 27  -  26 );
    out[ 11  + outpos] |= ( in[ 14  + inpos]  ) <<  26 ;
    out[ 12  + outpos] =  ( in[ 14  + inpos] ) >>> ( 27  -  21 );
    out[ 12  + outpos] |= ( in[ 15  + inpos]  ) <<  21 ;
    out[ 13  + outpos] =  ( in[ 15  + inpos] ) >>> ( 27  -  16 );
    out[ 13  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 14  + outpos] =  ( in[ 16  + inpos] ) >>> ( 27  -  11 );
    out[ 14  + outpos] |= ( in[ 17  + inpos]  ) <<  11 ;
    out[ 15  + outpos] =  ( in[ 17  + inpos] ) >>> ( 27  -  6 );
    out[ 15  + outpos] |= ( in[ 18  + inpos]  ) <<  6 ;
    out[ 16  + outpos] =  ( in[ 18  + inpos] ) >>> ( 27  -  1 );
    out[ 16  + outpos] |= ( in[ 19  + inpos]  ) <<  1 ;
    out[ 16  + outpos] |= ( in[ 20  + inpos]  ) <<  28 ;
    out[ 17  + outpos] =  ( in[ 20  + inpos] ) >>> ( 27  -  23 );
    out[ 17  + outpos] |= ( in[ 21  + inpos]  ) <<  23 ;
    out[ 18  + outpos] =  ( in[ 21  + inpos] ) >>> ( 27  -  18 );
    out[ 18  + outpos] |= ( in[ 22  + inpos]  ) <<  18 ;
    out[ 19  + outpos] =  ( in[ 22  + inpos] ) >>> ( 27  -  13 );
    out[ 19  + outpos] |= ( in[ 23  + inpos]  ) <<  13 ;
    out[ 20  + outpos] =  ( in[ 23  + inpos] ) >>> ( 27  -  8 );
    out[ 20  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 21  + outpos] =  ( in[ 24  + inpos] ) >>> ( 27  -  3 );
    out[ 21  + outpos] |= ( in[ 25  + inpos]  ) <<  3 ;
    out[ 21  + outpos] |= ( in[ 26  + inpos]  ) <<  30 ;
    out[ 22  + outpos] =  ( in[ 26  + inpos] ) >>> ( 27  -  25 );
    out[ 22  + outpos] |= ( in[ 27  + inpos]  ) <<  25 ;
    out[ 23  + outpos] =  ( in[ 27  + inpos] ) >>> ( 27  -  20 );
    out[ 23  + outpos] |= ( in[ 28  + inpos]  ) <<  20 ;
    out[ 24  + outpos] =  ( in[ 28  + inpos] ) >>> ( 27  -  15 );
    out[ 24  + outpos] |= ( in[ 29  + inpos]  ) <<  15 ;
    out[ 25  + outpos] =  ( in[ 29  + inpos] ) >>> ( 27  -  10 );
    out[ 25  + outpos] |= ( in[ 30  + inpos]  ) <<  10 ;
    out[ 26  + outpos] =  ( in[ 30  + inpos] ) >>> ( 27  -  5 );
    out[ 26  + outpos] |= ( in[ 31  + inpos]  ) <<  5 ;
}




public static void fastpackwithoutmask28(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  28 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 28  -  24 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  24 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 28  -  20 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  20 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 28  -  16 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  16 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 28  -  12 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  12 ;
    out[ 5  + outpos] =  ( in[ 5  + inpos] ) >>> ( 28  -  8 );
    out[ 5  + outpos] |= ( in[ 6  + inpos]  ) <<  8 ;
    out[ 6  + outpos] =  ( in[ 6  + inpos] ) >>> ( 28  -  4 );
    out[ 6  + outpos] |= ( in[ 7  + inpos]  ) <<  4 ;
    out[ 7  + outpos] = in[ 8  + inpos] ;
    out[ 7  + outpos] |= ( in[ 9  + inpos]  ) <<  28 ;
    out[ 8  + outpos] =  ( in[ 9  + inpos] ) >>> ( 28  -  24 );
    out[ 8  + outpos] |= ( in[ 10  + inpos]  ) <<  24 ;
    out[ 9  + outpos] =  ( in[ 10  + inpos] ) >>> ( 28  -  20 );
    out[ 9  + outpos] |= ( in[ 11  + inpos]  ) <<  20 ;
    out[ 10  + outpos] =  ( in[ 11  + inpos] ) >>> ( 28  -  16 );
    out[ 10  + outpos] |= ( in[ 12  + inpos]  ) <<  16 ;
    out[ 11  + outpos] =  ( in[ 12  + inpos] ) >>> ( 28  -  12 );
    out[ 11  + outpos] |= ( in[ 13  + inpos]  ) <<  12 ;
    out[ 12  + outpos] =  ( in[ 13  + inpos] ) >>> ( 28  -  8 );
    out[ 12  + outpos] |= ( in[ 14  + inpos]  ) <<  8 ;
    out[ 13  + outpos] =  ( in[ 14  + inpos] ) >>> ( 28  -  4 );
    out[ 13  + outpos] |= ( in[ 15  + inpos]  ) <<  4 ;
    out[ 14  + outpos] = in[ 16  + inpos] ;
    out[ 14  + outpos] |= ( in[ 17  + inpos]  ) <<  28 ;
    out[ 15  + outpos] =  ( in[ 17  + inpos] ) >>> ( 28  -  24 );
    out[ 15  + outpos] |= ( in[ 18  + inpos]  ) <<  24 ;
    out[ 16  + outpos] =  ( in[ 18  + inpos] ) >>> ( 28  -  20 );
    out[ 16  + outpos] |= ( in[ 19  + inpos]  ) <<  20 ;
    out[ 17  + outpos] =  ( in[ 19  + inpos] ) >>> ( 28  -  16 );
    out[ 17  + outpos] |= ( in[ 20  + inpos]  ) <<  16 ;
    out[ 18  + outpos] =  ( in[ 20  + inpos] ) >>> ( 28  -  12 );
    out[ 18  + outpos] |= ( in[ 21  + inpos]  ) <<  12 ;
    out[ 19  + outpos] =  ( in[ 21  + inpos] ) >>> ( 28  -  8 );
    out[ 19  + outpos] |= ( in[ 22  + inpos]  ) <<  8 ;
    out[ 20  + outpos] =  ( in[ 22  + inpos] ) >>> ( 28  -  4 );
    out[ 20  + outpos] |= ( in[ 23  + inpos]  ) <<  4 ;
    out[ 21  + outpos] = in[ 24  + inpos] ;
    out[ 21  + outpos] |= ( in[ 25  + inpos]  ) <<  28 ;
    out[ 22  + outpos] =  ( in[ 25  + inpos] ) >>> ( 28  -  24 );
    out[ 22  + outpos] |= ( in[ 26  + inpos]  ) <<  24 ;
    out[ 23  + outpos] =  ( in[ 26  + inpos] ) >>> ( 28  -  20 );
    out[ 23  + outpos] |= ( in[ 27  + inpos]  ) <<  20 ;
    out[ 24  + outpos] =  ( in[ 27  + inpos] ) >>> ( 28  -  16 );
    out[ 24  + outpos] |= ( in[ 28  + inpos]  ) <<  16 ;
    out[ 25  + outpos] =  ( in[ 28  + inpos] ) >>> ( 28  -  12 );
    out[ 25  + outpos] |= ( in[ 29  + inpos]  ) <<  12 ;
    out[ 26  + outpos] =  ( in[ 29  + inpos] ) >>> ( 28  -  8 );
    out[ 26  + outpos] |= ( in[ 30  + inpos]  ) <<  8 ;
    out[ 27  + outpos] =  ( in[ 30  + inpos] ) >>> ( 28  -  4 );
    out[ 27  + outpos] |= ( in[ 31  + inpos]  ) <<  4 ;
}




public static void fastpackwithoutmask29(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  29 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 29  -  26 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  26 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 29  -  23 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  23 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 29  -  20 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  20 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 29  -  17 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  17 ;
    out[ 5  + outpos] =  ( in[ 5  + inpos] ) >>> ( 29  -  14 );
    out[ 5  + outpos] |= ( in[ 6  + inpos]  ) <<  14 ;
    out[ 6  + outpos] =  ( in[ 6  + inpos] ) >>> ( 29  -  11 );
    out[ 6  + outpos] |= ( in[ 7  + inpos]  ) <<  11 ;
    out[ 7  + outpos] =  ( in[ 7  + inpos] ) >>> ( 29  -  8 );
    out[ 7  + outpos] |= ( in[ 8  + inpos]  ) <<  8 ;
    out[ 8  + outpos] =  ( in[ 8  + inpos] ) >>> ( 29  -  5 );
    out[ 8  + outpos] |= ( in[ 9  + inpos]  ) <<  5 ;
    out[ 9  + outpos] =  ( in[ 9  + inpos] ) >>> ( 29  -  2 );
    out[ 9  + outpos] |= ( in[ 10  + inpos]  ) <<  2 ;
    out[ 9  + outpos] |= ( in[ 11  + inpos]  ) <<  31 ;
    out[ 10  + outpos] =  ( in[ 11  + inpos] ) >>> ( 29  -  28 );
    out[ 10  + outpos] |= ( in[ 12  + inpos]  ) <<  28 ;
    out[ 11  + outpos] =  ( in[ 12  + inpos] ) >>> ( 29  -  25 );
    out[ 11  + outpos] |= ( in[ 13  + inpos]  ) <<  25 ;
    out[ 12  + outpos] =  ( in[ 13  + inpos] ) >>> ( 29  -  22 );
    out[ 12  + outpos] |= ( in[ 14  + inpos]  ) <<  22 ;
    out[ 13  + outpos] =  ( in[ 14  + inpos] ) >>> ( 29  -  19 );
    out[ 13  + outpos] |= ( in[ 15  + inpos]  ) <<  19 ;
    out[ 14  + outpos] =  ( in[ 15  + inpos] ) >>> ( 29  -  16 );
    out[ 14  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 15  + outpos] =  ( in[ 16  + inpos] ) >>> ( 29  -  13 );
    out[ 15  + outpos] |= ( in[ 17  + inpos]  ) <<  13 ;
    out[ 16  + outpos] =  ( in[ 17  + inpos] ) >>> ( 29  -  10 );
    out[ 16  + outpos] |= ( in[ 18  + inpos]  ) <<  10 ;
    out[ 17  + outpos] =  ( in[ 18  + inpos] ) >>> ( 29  -  7 );
    out[ 17  + outpos] |= ( in[ 19  + inpos]  ) <<  7 ;
    out[ 18  + outpos] =  ( in[ 19  + inpos] ) >>> ( 29  -  4 );
    out[ 18  + outpos] |= ( in[ 20  + inpos]  ) <<  4 ;
    out[ 19  + outpos] =  ( in[ 20  + inpos] ) >>> ( 29  -  1 );
    out[ 19  + outpos] |= ( in[ 21  + inpos]  ) <<  1 ;
    out[ 19  + outpos] |= ( in[ 22  + inpos]  ) <<  30 ;
    out[ 20  + outpos] =  ( in[ 22  + inpos] ) >>> ( 29  -  27 );
    out[ 20  + outpos] |= ( in[ 23  + inpos]  ) <<  27 ;
    out[ 21  + outpos] =  ( in[ 23  + inpos] ) >>> ( 29  -  24 );
    out[ 21  + outpos] |= ( in[ 24  + inpos]  ) <<  24 ;
    out[ 22  + outpos] =  ( in[ 24  + inpos] ) >>> ( 29  -  21 );
    out[ 22  + outpos] |= ( in[ 25  + inpos]  ) <<  21 ;
    out[ 23  + outpos] =  ( in[ 25  + inpos] ) >>> ( 29  -  18 );
    out[ 23  + outpos] |= ( in[ 26  + inpos]  ) <<  18 ;
    out[ 24  + outpos] =  ( in[ 26  + inpos] ) >>> ( 29  -  15 );
    out[ 24  + outpos] |= ( in[ 27  + inpos]  ) <<  15 ;
    out[ 25  + outpos] =  ( in[ 27  + inpos] ) >>> ( 29  -  12 );
    out[ 25  + outpos] |= ( in[ 28  + inpos]  ) <<  12 ;
    out[ 26  + outpos] =  ( in[ 28  + inpos] ) >>> ( 29  -  9 );
    out[ 26  + outpos] |= ( in[ 29  + inpos]  ) <<  9 ;
    out[ 27  + outpos] =  ( in[ 29  + inpos] ) >>> ( 29  -  6 );
    out[ 27  + outpos] |= ( in[ 30  + inpos]  ) <<  6 ;
    out[ 28  + outpos] =  ( in[ 30  + inpos] ) >>> ( 29  -  3 );
    out[ 28  + outpos] |= ( in[ 31  + inpos]  ) <<  3 ;
}




public static void fastpackwithoutmask30(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  30 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 30  -  28 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  28 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 30  -  26 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  26 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 30  -  24 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  24 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 30  -  22 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  22 ;
    out[ 5  + outpos] =  ( in[ 5  + inpos] ) >>> ( 30  -  20 );
    out[ 5  + outpos] |= ( in[ 6  + inpos]  ) <<  20 ;
    out[ 6  + outpos] =  ( in[ 6  + inpos] ) >>> ( 30  -  18 );
    out[ 6  + outpos] |= ( in[ 7  + inpos]  ) <<  18 ;
    out[ 7  + outpos] =  ( in[ 7  + inpos] ) >>> ( 30  -  16 );
    out[ 7  + outpos] |= ( in[ 8  + inpos]  ) <<  16 ;
    out[ 8  + outpos] =  ( in[ 8  + inpos] ) >>> ( 30  -  14 );
    out[ 8  + outpos] |= ( in[ 9  + inpos]  ) <<  14 ;
    out[ 9  + outpos] =  ( in[ 9  + inpos] ) >>> ( 30  -  12 );
    out[ 9  + outpos] |= ( in[ 10  + inpos]  ) <<  12 ;
    out[ 10  + outpos] =  ( in[ 10  + inpos] ) >>> ( 30  -  10 );
    out[ 10  + outpos] |= ( in[ 11  + inpos]  ) <<  10 ;
    out[ 11  + outpos] =  ( in[ 11  + inpos] ) >>> ( 30  -  8 );
    out[ 11  + outpos] |= ( in[ 12  + inpos]  ) <<  8 ;
    out[ 12  + outpos] =  ( in[ 12  + inpos] ) >>> ( 30  -  6 );
    out[ 12  + outpos] |= ( in[ 13  + inpos]  ) <<  6 ;
    out[ 13  + outpos] =  ( in[ 13  + inpos] ) >>> ( 30  -  4 );
    out[ 13  + outpos] |= ( in[ 14  + inpos]  ) <<  4 ;
    out[ 14  + outpos] =  ( in[ 14  + inpos] ) >>> ( 30  -  2 );
    out[ 14  + outpos] |= ( in[ 15  + inpos]  ) <<  2 ;
    out[ 15  + outpos] = in[ 16  + inpos] ;
    out[ 15  + outpos] |= ( in[ 17  + inpos]  ) <<  30 ;
    out[ 16  + outpos] =  ( in[ 17  + inpos] ) >>> ( 30  -  28 );
    out[ 16  + outpos] |= ( in[ 18  + inpos]  ) <<  28 ;
    out[ 17  + outpos] =  ( in[ 18  + inpos] ) >>> ( 30  -  26 );
    out[ 17  + outpos] |= ( in[ 19  + inpos]  ) <<  26 ;
    out[ 18  + outpos] =  ( in[ 19  + inpos] ) >>> ( 30  -  24 );
    out[ 18  + outpos] |= ( in[ 20  + inpos]  ) <<  24 ;
    out[ 19  + outpos] =  ( in[ 20  + inpos] ) >>> ( 30  -  22 );
    out[ 19  + outpos] |= ( in[ 21  + inpos]  ) <<  22 ;
    out[ 20  + outpos] =  ( in[ 21  + inpos] ) >>> ( 30  -  20 );
    out[ 20  + outpos] |= ( in[ 22  + inpos]  ) <<  20 ;
    out[ 21  + outpos] =  ( in[ 22  + inpos] ) >>> ( 30  -  18 );
    out[ 21  + outpos] |= ( in[ 23  + inpos]  ) <<  18 ;
    out[ 22  + outpos] =  ( in[ 23  + inpos] ) >>> ( 30  -  16 );
    out[ 22  + outpos] |= ( in[ 24  + inpos]  ) <<  16 ;
    out[ 23  + outpos] =  ( in[ 24  + inpos] ) >>> ( 30  -  14 );
    out[ 23  + outpos] |= ( in[ 25  + inpos]  ) <<  14 ;
    out[ 24  + outpos] =  ( in[ 25  + inpos] ) >>> ( 30  -  12 );
    out[ 24  + outpos] |= ( in[ 26  + inpos]  ) <<  12 ;
    out[ 25  + outpos] =  ( in[ 26  + inpos] ) >>> ( 30  -  10 );
    out[ 25  + outpos] |= ( in[ 27  + inpos]  ) <<  10 ;
    out[ 26  + outpos] =  ( in[ 27  + inpos] ) >>> ( 30  -  8 );
    out[ 26  + outpos] |= ( in[ 28  + inpos]  ) <<  8 ;
    out[ 27  + outpos] =  ( in[ 28  + inpos] ) >>> ( 30  -  6 );
    out[ 27  + outpos] |= ( in[ 29  + inpos]  ) <<  6 ;
    out[ 28  + outpos] =  ( in[ 29  + inpos] ) >>> ( 30  -  4 );
    out[ 28  + outpos] |= ( in[ 30  + inpos]  ) <<  4 ;
    out[ 29  + outpos] =  ( in[ 30  + inpos] ) >>> ( 30  -  2 );
    out[ 29  + outpos] |= ( in[ 31  + inpos]  ) <<  2 ;
}




public static void fastpackwithoutmask31(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = in[ 0  + inpos] ;
    out[ 0  + outpos] |= ( in[ 1  + inpos]  ) <<  31 ;
    out[ 1  + outpos] =  ( in[ 1  + inpos] ) >>> ( 31  -  30 );
    out[ 1  + outpos] |= ( in[ 2  + inpos]  ) <<  30 ;
    out[ 2  + outpos] =  ( in[ 2  + inpos] ) >>> ( 31  -  29 );
    out[ 2  + outpos] |= ( in[ 3  + inpos]  ) <<  29 ;
    out[ 3  + outpos] =  ( in[ 3  + inpos] ) >>> ( 31  -  28 );
    out[ 3  + outpos] |= ( in[ 4  + inpos]  ) <<  28 ;
    out[ 4  + outpos] =  ( in[ 4  + inpos] ) >>> ( 31  -  27 );
    out[ 4  + outpos] |= ( in[ 5  + inpos]  ) <<  27 ;
    out[ 5  + outpos] =  ( in[ 5  + inpos] ) >>> ( 31  -  26 );
    out[ 5  + outpos] |= ( in[ 6  + inpos]  ) <<  26 ;
    out[ 6  + outpos] =  ( in[ 6  + inpos] ) >>> ( 31  -  25 );
    out[ 6  + outpos] |= ( in[ 7  + inpos]  ) <<  25 ;
    out[ 7  + outpos] =  ( in[ 7  + inpos] ) >>> ( 31  -  24 );
    out[ 7  + outpos] |= ( in[ 8  + inpos]  ) <<  24 ;
    out[ 8  + outpos] =  ( in[ 8  + inpos] ) >>> ( 31  -  23 );
    out[ 8  + outpos] |= ( in[ 9  + inpos]  ) <<  23 ;
    out[ 9  + outpos] =  ( in[ 9  + inpos] ) >>> ( 31  -  22 );
    out[ 9  + outpos] |= ( in[ 10  + inpos]  ) <<  22 ;
    out[ 10  + outpos] =  ( in[ 10  + inpos] ) >>> ( 31  -  21 );
    out[ 10  + outpos] |= ( in[ 11  + inpos]  ) <<  21 ;
    out[ 11  + outpos] =  ( in[ 11  + inpos] ) >>> ( 31  -  20 );
    out[ 11  + outpos] |= ( in[ 12  + inpos]  ) <<  20 ;
    out[ 12  + outpos] =  ( in[ 12  + inpos] ) >>> ( 31  -  19 );
    out[ 12  + outpos] |= ( in[ 13  + inpos]  ) <<  19 ;
    out[ 13  + outpos] =  ( in[ 13  + inpos] ) >>> ( 31  -  18 );
    out[ 13  + outpos] |= ( in[ 14  + inpos]  ) <<  18 ;
    out[ 14  + outpos] =  ( in[ 14  + inpos] ) >>> ( 31  -  17 );
    out[ 14  + outpos] |= ( in[ 15  + inpos]  ) <<  17 ;
    out[ 15  + outpos] =  ( in[ 15  + inpos] ) >>> ( 31  -  16 );
    out[ 15  + outpos] |= ( in[ 16  + inpos]  ) <<  16 ;
    out[ 16  + outpos] =  ( in[ 16  + inpos] ) >>> ( 31  -  15 );
    out[ 16  + outpos] |= ( in[ 17  + inpos]  ) <<  15 ;
    out[ 17  + outpos] =  ( in[ 17  + inpos] ) >>> ( 31  -  14 );
    out[ 17  + outpos] |= ( in[ 18  + inpos]  ) <<  14 ;
    out[ 18  + outpos] =  ( in[ 18  + inpos] ) >>> ( 31  -  13 );
    out[ 18  + outpos] |= ( in[ 19  + inpos]  ) <<  13 ;
    out[ 19  + outpos] =  ( in[ 19  + inpos] ) >>> ( 31  -  12 );
    out[ 19  + outpos] |= ( in[ 20  + inpos]  ) <<  12 ;
    out[ 20  + outpos] =  ( in[ 20  + inpos] ) >>> ( 31  -  11 );
    out[ 20  + outpos] |= ( in[ 21  + inpos]  ) <<  11 ;
    out[ 21  + outpos] =  ( in[ 21  + inpos] ) >>> ( 31  -  10 );
    out[ 21  + outpos] |= ( in[ 22  + inpos]  ) <<  10 ;
    out[ 22  + outpos] =  ( in[ 22  + inpos] ) >>> ( 31  -  9 );
    out[ 22  + outpos] |= ( in[ 23  + inpos]  ) <<  9 ;
    out[ 23  + outpos] =  ( in[ 23  + inpos] ) >>> ( 31  -  8 );
    out[ 23  + outpos] |= ( in[ 24  + inpos]  ) <<  8 ;
    out[ 24  + outpos] =  ( in[ 24  + inpos] ) >>> ( 31  -  7 );
    out[ 24  + outpos] |= ( in[ 25  + inpos]  ) <<  7 ;
    out[ 25  + outpos] =  ( in[ 25  + inpos] ) >>> ( 31  -  6 );
    out[ 25  + outpos] |= ( in[ 26  + inpos]  ) <<  6 ;
    out[ 26  + outpos] =  ( in[ 26  + inpos] ) >>> ( 31  -  5 );
    out[ 26  + outpos] |= ( in[ 27  + inpos]  ) <<  5 ;
    out[ 27  + outpos] =  ( in[ 27  + inpos] ) >>> ( 31  -  4 );
    out[ 27  + outpos] |= ( in[ 28  + inpos]  ) <<  4 ;
    out[ 28  + outpos] =  ( in[ 28  + inpos] ) >>> ( 31  -  3 );
    out[ 28  + outpos] |= ( in[ 29  + inpos]  ) <<  3 ;
    out[ 29  + outpos] =  ( in[ 29  + inpos] ) >>> ( 31  -  2 );
    out[ 29  + outpos] |= ( in[ 30  + inpos]  ) <<  2 ;
    out[ 30  + outpos] =  ( in[ 30  + inpos] ) >>> ( 31  -  1 );
    out[ 30  + outpos] |= ( in[ 31  + inpos]  ) <<  1 ;
}




public static void fastpack1(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 1 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 1  ) <<  1 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 1  ) <<  2 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 1  ) <<  3 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 1  ) <<  4 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 1  ) <<  5 ;
    out[ 0  + outpos ] |= ( in[ 6 + inpos]   & 1  ) <<  6 ;
    out[ 0  + outpos ] |= ( in[ 7 + inpos]   & 1  ) <<  7 ;
    out[ 0  + outpos ] |= ( in[ 8 + inpos]   & 1  ) <<  8 ;
    out[ 0  + outpos ] |= ( in[ 9 + inpos]   & 1  ) <<  9 ;
    out[ 0  + outpos ] |= ( in[ 10 + inpos]   & 1  ) <<  10 ;
    out[ 0  + outpos ] |= ( in[ 11 + inpos]   & 1  ) <<  11 ;
    out[ 0  + outpos ] |= ( in[ 12 + inpos]   & 1  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 13 + inpos]   & 1  ) <<  13 ;
    out[ 0  + outpos ] |= ( in[ 14 + inpos]   & 1  ) <<  14 ;
    out[ 0  + outpos ] |= ( in[ 15 + inpos]   & 1  ) <<  15 ;
    out[ 0  + outpos ] |= ( in[ 16 + inpos]   & 1  ) <<  16 ;
    out[ 0  + outpos ] |= ( in[ 17 + inpos]   & 1  ) <<  17 ;
    out[ 0  + outpos ] |= ( in[ 18 + inpos]   & 1  ) <<  18 ;
    out[ 0  + outpos ] |= ( in[ 19 + inpos]   & 1  ) <<  19 ;
    out[ 0  + outpos ] |= ( in[ 20 + inpos]   & 1  ) <<  20 ;
    out[ 0  + outpos ] |= ( in[ 21 + inpos]   & 1  ) <<  21 ;
    out[ 0  + outpos ] |= ( in[ 22 + inpos]   & 1  ) <<  22 ;
    out[ 0  + outpos ] |= ( in[ 23 + inpos]   & 1  ) <<  23 ;
    out[ 0  + outpos ] |= ( in[ 24 + inpos]   & 1  ) <<  24 ;
    out[ 0  + outpos ] |= ( in[ 25 + inpos]   & 1  ) <<  25 ;
    out[ 0  + outpos ] |= ( in[ 26 + inpos]   & 1  ) <<  26 ;
    out[ 0  + outpos ] |= ( in[ 27 + inpos]   & 1  ) <<  27 ;
    out[ 0  + outpos ] |= ( in[ 28 + inpos]   & 1  ) <<  28 ;
    out[ 0  + outpos ] |= ( in[ 29 + inpos]   & 1  ) <<  29 ;
    out[ 0  + outpos ] |= ( in[ 30 + inpos]   & 1  ) <<  30 ;
    out[ 0  + outpos ] |= ( in[ 31 + inpos]   & 1  ) <<  31 ;
}




public static void fastpack2(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 3 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 3  ) <<  2 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 3  ) <<  4 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 3  ) <<  6 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 3  ) <<  8 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 3  ) <<  10 ;
    out[ 0  + outpos ] |= ( in[ 6 + inpos]   & 3  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 7 + inpos]   & 3  ) <<  14 ;
    out[ 0  + outpos ] |= ( in[ 8 + inpos]   & 3  ) <<  16 ;
    out[ 0  + outpos ] |= ( in[ 9 + inpos]   & 3  ) <<  18 ;
    out[ 0  + outpos ] |= ( in[ 10 + inpos]   & 3  ) <<  20 ;
    out[ 0  + outpos ] |= ( in[ 11 + inpos]   & 3  ) <<  22 ;
    out[ 0  + outpos ] |= ( in[ 12 + inpos]   & 3  ) <<  24 ;
    out[ 0  + outpos ] |= ( in[ 13 + inpos]   & 3  ) <<  26 ;
    out[ 0  + outpos ] |= ( in[ 14 + inpos]   & 3  ) <<  28 ;
    out[ 0  + outpos ] |= ( in[ 15 + inpos]   & 3  ) <<  30 ;
    out[ 1  + outpos ] = in[ 16 + inpos]   & 3 ;
    out[ 1  + outpos ] |= ( in[ 17 + inpos]   & 3  ) <<  2 ;
    out[ 1  + outpos ] |= ( in[ 18 + inpos]   & 3  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 19 + inpos]   & 3  ) <<  6 ;
    out[ 1  + outpos ] |= ( in[ 20 + inpos]   & 3  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 21 + inpos]   & 3  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 22 + inpos]   & 3  ) <<  12 ;
    out[ 1  + outpos ] |= ( in[ 23 + inpos]   & 3  ) <<  14 ;
    out[ 1  + outpos ] |= ( in[ 24 + inpos]   & 3  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 25 + inpos]   & 3  ) <<  18 ;
    out[ 1  + outpos ] |= ( in[ 26 + inpos]   & 3  ) <<  20 ;
    out[ 1  + outpos ] |= ( in[ 27 + inpos]   & 3  ) <<  22 ;
    out[ 1  + outpos ] |= ( in[ 28 + inpos]   & 3  ) <<  24 ;
    out[ 1  + outpos ] |= ( in[ 29 + inpos]   & 3  ) <<  26 ;
    out[ 1  + outpos ] |= ( in[ 30 + inpos]   & 3  ) <<  28 ;
    out[ 1  + outpos ] |= ( in[ 31 + inpos]   & 3  ) <<  30 ;
}




public static void fastpack3(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 7 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 7  ) <<  3 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 7  ) <<  6 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 7  ) <<  9 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 7  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 7  ) <<  15 ;
    out[ 0  + outpos ] |= ( in[ 6 + inpos]   & 7  ) <<  18 ;
    out[ 0  + outpos ] |= ( in[ 7 + inpos]   & 7  ) <<  21 ;
    out[ 0  + outpos ] |= ( in[ 8 + inpos]   & 7  ) <<  24 ;
    out[ 0  + outpos ] |= ( in[ 9 + inpos]   & 7  ) <<  27 ;
    out[ 0  + outpos ] |= ( in[ 10 + inpos]   & 7  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 10 + inpos]   & 7 ) >>> ( 3  -  1 );
    out[ 1  + outpos ] |= ( in[ 11 + inpos]   & 7  ) <<  1 ;
    out[ 1  + outpos ] |= ( in[ 12 + inpos]   & 7  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 13 + inpos]   & 7  ) <<  7 ;
    out[ 1  + outpos ] |= ( in[ 14 + inpos]   & 7  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 15 + inpos]   & 7  ) <<  13 ;
    out[ 1  + outpos ] |= ( in[ 16 + inpos]   & 7  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 17 + inpos]   & 7  ) <<  19 ;
    out[ 1  + outpos ] |= ( in[ 18 + inpos]   & 7  ) <<  22 ;
    out[ 1  + outpos ] |= ( in[ 19 + inpos]   & 7  ) <<  25 ;
    out[ 1  + outpos ] |= ( in[ 20 + inpos]   & 7  ) <<  28 ;
    out[ 1  + outpos ] |= ( in[ 21 + inpos]   & 7  ) <<  31 ;
    out[ 2  + outpos ] =  ( in[ 21 + inpos]   & 7 ) >>> ( 3  -  2 );
    out[ 2  + outpos ] |= ( in[ 22 + inpos]   & 7  ) <<  2 ;
    out[ 2  + outpos ] |= ( in[ 23 + inpos]   & 7  ) <<  5 ;
    out[ 2  + outpos ] |= ( in[ 24 + inpos]   & 7  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 25 + inpos]   & 7  ) <<  11 ;
    out[ 2  + outpos ] |= ( in[ 26 + inpos]   & 7  ) <<  14 ;
    out[ 2  + outpos ] |= ( in[ 27 + inpos]   & 7  ) <<  17 ;
    out[ 2  + outpos ] |= ( in[ 28 + inpos]   & 7  ) <<  20 ;
    out[ 2  + outpos ] |= ( in[ 29 + inpos]   & 7  ) <<  23 ;
    out[ 2  + outpos ] |= ( in[ 30 + inpos]   & 7  ) <<  26 ;
    out[ 2  + outpos ] |= ( in[ 31 + inpos]   & 7  ) <<  29 ;
}




public static void fastpack4(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 15 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 15  ) <<  4 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 15  ) <<  8 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 15  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 15  ) <<  16 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 15  ) <<  20 ;
    out[ 0  + outpos ] |= ( in[ 6 + inpos]   & 15  ) <<  24 ;
    out[ 0  + outpos ] |= ( in[ 7 + inpos]   & 15  ) <<  28 ;
    out[ 1  + outpos ] = in[ 8 + inpos]   & 15 ;
    out[ 1  + outpos ] |= ( in[ 9 + inpos]   & 15  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 10 + inpos]   & 15  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 11 + inpos]   & 15  ) <<  12 ;
    out[ 1  + outpos ] |= ( in[ 12 + inpos]   & 15  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 13 + inpos]   & 15  ) <<  20 ;
    out[ 1  + outpos ] |= ( in[ 14 + inpos]   & 15  ) <<  24 ;
    out[ 1  + outpos ] |= ( in[ 15 + inpos]   & 15  ) <<  28 ;
    out[ 2  + outpos ] = in[ 16 + inpos]   & 15 ;
    out[ 2  + outpos ] |= ( in[ 17 + inpos]   & 15  ) <<  4 ;
    out[ 2  + outpos ] |= ( in[ 18 + inpos]   & 15  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 19 + inpos]   & 15  ) <<  12 ;
    out[ 2  + outpos ] |= ( in[ 20 + inpos]   & 15  ) <<  16 ;
    out[ 2  + outpos ] |= ( in[ 21 + inpos]   & 15  ) <<  20 ;
    out[ 2  + outpos ] |= ( in[ 22 + inpos]   & 15  ) <<  24 ;
    out[ 2  + outpos ] |= ( in[ 23 + inpos]   & 15  ) <<  28 ;
    out[ 3  + outpos ] = in[ 24 + inpos]   & 15 ;
    out[ 3  + outpos ] |= ( in[ 25 + inpos]   & 15  ) <<  4 ;
    out[ 3  + outpos ] |= ( in[ 26 + inpos]   & 15  ) <<  8 ;
    out[ 3  + outpos ] |= ( in[ 27 + inpos]   & 15  ) <<  12 ;
    out[ 3  + outpos ] |= ( in[ 28 + inpos]   & 15  ) <<  16 ;
    out[ 3  + outpos ] |= ( in[ 29 + inpos]   & 15  ) <<  20 ;
    out[ 3  + outpos ] |= ( in[ 30 + inpos]   & 15  ) <<  24 ;
    out[ 3  + outpos ] |= ( in[ 31 + inpos]   & 15  ) <<  28 ;
}




public static void fastpack5(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 31 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 31  ) <<  5 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 31  ) <<  10 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 31  ) <<  15 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 31  ) <<  20 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 31  ) <<  25 ;
    out[ 0  + outpos ] |= ( in[ 6 + inpos]   & 31  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 6 + inpos]   & 31 ) >>> ( 5  -  3 );
    out[ 1  + outpos ] |= ( in[ 7 + inpos]   & 31  ) <<  3 ;
    out[ 1  + outpos ] |= ( in[ 8 + inpos]   & 31  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 9 + inpos]   & 31  ) <<  13 ;
    out[ 1  + outpos ] |= ( in[ 10 + inpos]   & 31  ) <<  18 ;
    out[ 1  + outpos ] |= ( in[ 11 + inpos]   & 31  ) <<  23 ;
    out[ 1  + outpos ] |= ( in[ 12 + inpos]   & 31  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 12 + inpos]   & 31 ) >>> ( 5  -  1 );
    out[ 2  + outpos ] |= ( in[ 13 + inpos]   & 31  ) <<  1 ;
    out[ 2  + outpos ] |= ( in[ 14 + inpos]   & 31  ) <<  6 ;
    out[ 2  + outpos ] |= ( in[ 15 + inpos]   & 31  ) <<  11 ;
    out[ 2  + outpos ] |= ( in[ 16 + inpos]   & 31  ) <<  16 ;
    out[ 2  + outpos ] |= ( in[ 17 + inpos]   & 31  ) <<  21 ;
    out[ 2  + outpos ] |= ( in[ 18 + inpos]   & 31  ) <<  26 ;
    out[ 2  + outpos ] |= ( in[ 19 + inpos]   & 31  ) <<  31 ;
    out[ 3  + outpos ] =  ( in[ 19 + inpos]   & 31 ) >>> ( 5  -  4 );
    out[ 3  + outpos ] |= ( in[ 20 + inpos]   & 31  ) <<  4 ;
    out[ 3  + outpos ] |= ( in[ 21 + inpos]   & 31  ) <<  9 ;
    out[ 3  + outpos ] |= ( in[ 22 + inpos]   & 31  ) <<  14 ;
    out[ 3  + outpos ] |= ( in[ 23 + inpos]   & 31  ) <<  19 ;
    out[ 3  + outpos ] |= ( in[ 24 + inpos]   & 31  ) <<  24 ;
    out[ 3  + outpos ] |= ( in[ 25 + inpos]   & 31  ) <<  29 ;
    out[ 4  + outpos ] =  ( in[ 25 + inpos]   & 31 ) >>> ( 5  -  2 );
    out[ 4  + outpos ] |= ( in[ 26 + inpos]   & 31  ) <<  2 ;
    out[ 4  + outpos ] |= ( in[ 27 + inpos]   & 31  ) <<  7 ;
    out[ 4  + outpos ] |= ( in[ 28 + inpos]   & 31  ) <<  12 ;
    out[ 4  + outpos ] |= ( in[ 29 + inpos]   & 31  ) <<  17 ;
    out[ 4  + outpos ] |= ( in[ 30 + inpos]   & 31  ) <<  22 ;
    out[ 4  + outpos ] |= ( in[ 31 + inpos]   & 31  ) <<  27 ;
}




public static void fastpack6(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 63 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 63  ) <<  6 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 63  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 63  ) <<  18 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 63  ) <<  24 ;
    out[ 0  + outpos ] |= ( in[ 5 + inpos]   & 63  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 5 + inpos]   & 63 ) >>> ( 6  -  4 );
    out[ 1  + outpos ] |= ( in[ 6 + inpos]   & 63  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 7 + inpos]   & 63  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 8 + inpos]   & 63  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 9 + inpos]   & 63  ) <<  22 ;
    out[ 1  + outpos ] |= ( in[ 10 + inpos]   & 63  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 10 + inpos]   & 63 ) >>> ( 6  -  2 );
    out[ 2  + outpos ] |= ( in[ 11 + inpos]   & 63  ) <<  2 ;
    out[ 2  + outpos ] |= ( in[ 12 + inpos]   & 63  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 13 + inpos]   & 63  ) <<  14 ;
    out[ 2  + outpos ] |= ( in[ 14 + inpos]   & 63  ) <<  20 ;
    out[ 2  + outpos ] |= ( in[ 15 + inpos]   & 63  ) <<  26 ;
    out[ 3  + outpos ] = in[ 16 + inpos]   & 63 ;
    out[ 3  + outpos ] |= ( in[ 17 + inpos]   & 63  ) <<  6 ;
    out[ 3  + outpos ] |= ( in[ 18 + inpos]   & 63  ) <<  12 ;
    out[ 3  + outpos ] |= ( in[ 19 + inpos]   & 63  ) <<  18 ;
    out[ 3  + outpos ] |= ( in[ 20 + inpos]   & 63  ) <<  24 ;
    out[ 3  + outpos ] |= ( in[ 21 + inpos]   & 63  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 21 + inpos]   & 63 ) >>> ( 6  -  4 );
    out[ 4  + outpos ] |= ( in[ 22 + inpos]   & 63  ) <<  4 ;
    out[ 4  + outpos ] |= ( in[ 23 + inpos]   & 63  ) <<  10 ;
    out[ 4  + outpos ] |= ( in[ 24 + inpos]   & 63  ) <<  16 ;
    out[ 4  + outpos ] |= ( in[ 25 + inpos]   & 63  ) <<  22 ;
    out[ 4  + outpos ] |= ( in[ 26 + inpos]   & 63  ) <<  28 ;
    out[ 5  + outpos ] =  ( in[ 26 + inpos]   & 63 ) >>> ( 6  -  2 );
    out[ 5  + outpos ] |= ( in[ 27 + inpos]   & 63  ) <<  2 ;
    out[ 5  + outpos ] |= ( in[ 28 + inpos]   & 63  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 29 + inpos]   & 63  ) <<  14 ;
    out[ 5  + outpos ] |= ( in[ 30 + inpos]   & 63  ) <<  20 ;
    out[ 5  + outpos ] |= ( in[ 31 + inpos]   & 63  ) <<  26 ;
}




public static void fastpack7(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 127 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 127  ) <<  7 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 127  ) <<  14 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 127  ) <<  21 ;
    out[ 0  + outpos ] |= ( in[ 4 + inpos]   & 127  ) <<  28 ;
    out[ 1  + outpos ] =  ( in[ 4 + inpos]   & 127 ) >>> ( 7  -  3 );
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 127  ) <<  3 ;
    out[ 1  + outpos ] |= ( in[ 6 + inpos]   & 127  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 7 + inpos]   & 127  ) <<  17 ;
    out[ 1  + outpos ] |= ( in[ 8 + inpos]   & 127  ) <<  24 ;
    out[ 1  + outpos ] |= ( in[ 9 + inpos]   & 127  ) <<  31 ;
    out[ 2  + outpos ] =  ( in[ 9 + inpos]   & 127 ) >>> ( 7  -  6 );
    out[ 2  + outpos ] |= ( in[ 10 + inpos]   & 127  ) <<  6 ;
    out[ 2  + outpos ] |= ( in[ 11 + inpos]   & 127  ) <<  13 ;
    out[ 2  + outpos ] |= ( in[ 12 + inpos]   & 127  ) <<  20 ;
    out[ 2  + outpos ] |= ( in[ 13 + inpos]   & 127  ) <<  27 ;
    out[ 3  + outpos ] =  ( in[ 13 + inpos]   & 127 ) >>> ( 7  -  2 );
    out[ 3  + outpos ] |= ( in[ 14 + inpos]   & 127  ) <<  2 ;
    out[ 3  + outpos ] |= ( in[ 15 + inpos]   & 127  ) <<  9 ;
    out[ 3  + outpos ] |= ( in[ 16 + inpos]   & 127  ) <<  16 ;
    out[ 3  + outpos ] |= ( in[ 17 + inpos]   & 127  ) <<  23 ;
    out[ 3  + outpos ] |= ( in[ 18 + inpos]   & 127  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 18 + inpos]   & 127 ) >>> ( 7  -  5 );
    out[ 4  + outpos ] |= ( in[ 19 + inpos]   & 127  ) <<  5 ;
    out[ 4  + outpos ] |= ( in[ 20 + inpos]   & 127  ) <<  12 ;
    out[ 4  + outpos ] |= ( in[ 21 + inpos]   & 127  ) <<  19 ;
    out[ 4  + outpos ] |= ( in[ 22 + inpos]   & 127  ) <<  26 ;
    out[ 5  + outpos ] =  ( in[ 22 + inpos]   & 127 ) >>> ( 7  -  1 );
    out[ 5  + outpos ] |= ( in[ 23 + inpos]   & 127  ) <<  1 ;
    out[ 5  + outpos ] |= ( in[ 24 + inpos]   & 127  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 25 + inpos]   & 127  ) <<  15 ;
    out[ 5  + outpos ] |= ( in[ 26 + inpos]   & 127  ) <<  22 ;
    out[ 5  + outpos ] |= ( in[ 27 + inpos]   & 127  ) <<  29 ;
    out[ 6  + outpos ] =  ( in[ 27 + inpos]   & 127 ) >>> ( 7  -  4 );
    out[ 6  + outpos ] |= ( in[ 28 + inpos]   & 127  ) <<  4 ;
    out[ 6  + outpos ] |= ( in[ 29 + inpos]   & 127  ) <<  11 ;
    out[ 6  + outpos ] |= ( in[ 30 + inpos]   & 127  ) <<  18 ;
    out[ 6  + outpos ] |= ( in[ 31 + inpos]   & 127  ) <<  25 ;
}




public static void fastpack8(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 255 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 255  ) <<  8 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 255  ) <<  16 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 255  ) <<  24 ;
    out[ 1  + outpos ] = in[ 4 + inpos]   & 255 ;
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 255  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 6 + inpos]   & 255  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 7 + inpos]   & 255  ) <<  24 ;
    out[ 2  + outpos ] = in[ 8 + inpos]   & 255 ;
    out[ 2  + outpos ] |= ( in[ 9 + inpos]   & 255  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 10 + inpos]   & 255  ) <<  16 ;
    out[ 2  + outpos ] |= ( in[ 11 + inpos]   & 255  ) <<  24 ;
    out[ 3  + outpos ] = in[ 12 + inpos]   & 255 ;
    out[ 3  + outpos ] |= ( in[ 13 + inpos]   & 255  ) <<  8 ;
    out[ 3  + outpos ] |= ( in[ 14 + inpos]   & 255  ) <<  16 ;
    out[ 3  + outpos ] |= ( in[ 15 + inpos]   & 255  ) <<  24 ;
    out[ 4  + outpos ] = in[ 16 + inpos]   & 255 ;
    out[ 4  + outpos ] |= ( in[ 17 + inpos]   & 255  ) <<  8 ;
    out[ 4  + outpos ] |= ( in[ 18 + inpos]   & 255  ) <<  16 ;
    out[ 4  + outpos ] |= ( in[ 19 + inpos]   & 255  ) <<  24 ;
    out[ 5  + outpos ] = in[ 20 + inpos]   & 255 ;
    out[ 5  + outpos ] |= ( in[ 21 + inpos]   & 255  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 22 + inpos]   & 255  ) <<  16 ;
    out[ 5  + outpos ] |= ( in[ 23 + inpos]   & 255  ) <<  24 ;
    out[ 6  + outpos ] = in[ 24 + inpos]   & 255 ;
    out[ 6  + outpos ] |= ( in[ 25 + inpos]   & 255  ) <<  8 ;
    out[ 6  + outpos ] |= ( in[ 26 + inpos]   & 255  ) <<  16 ;
    out[ 6  + outpos ] |= ( in[ 27 + inpos]   & 255  ) <<  24 ;
    out[ 7  + outpos ] = in[ 28 + inpos]   & 255 ;
    out[ 7  + outpos ] |= ( in[ 29 + inpos]   & 255  ) <<  8 ;
    out[ 7  + outpos ] |= ( in[ 30 + inpos]   & 255  ) <<  16 ;
    out[ 7  + outpos ] |= ( in[ 31 + inpos]   & 255  ) <<  24 ;
}




public static void fastpack9(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 511 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 511  ) <<  9 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 511  ) <<  18 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 511  ) <<  27 ;
    out[ 1  + outpos ] =  ( in[ 3 + inpos]   & 511 ) >>> ( 9  -  4 );
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 511  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 511  ) <<  13 ;
    out[ 1  + outpos ] |= ( in[ 6 + inpos]   & 511  ) <<  22 ;
    out[ 1  + outpos ] |= ( in[ 7 + inpos]   & 511  ) <<  31 ;
    out[ 2  + outpos ] =  ( in[ 7 + inpos]   & 511 ) >>> ( 9  -  8 );
    out[ 2  + outpos ] |= ( in[ 8 + inpos]   & 511  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 9 + inpos]   & 511  ) <<  17 ;
    out[ 2  + outpos ] |= ( in[ 10 + inpos]   & 511  ) <<  26 ;
    out[ 3  + outpos ] =  ( in[ 10 + inpos]   & 511 ) >>> ( 9  -  3 );
    out[ 3  + outpos ] |= ( in[ 11 + inpos]   & 511  ) <<  3 ;
    out[ 3  + outpos ] |= ( in[ 12 + inpos]   & 511  ) <<  12 ;
    out[ 3  + outpos ] |= ( in[ 13 + inpos]   & 511  ) <<  21 ;
    out[ 3  + outpos ] |= ( in[ 14 + inpos]   & 511  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 14 + inpos]   & 511 ) >>> ( 9  -  7 );
    out[ 4  + outpos ] |= ( in[ 15 + inpos]   & 511  ) <<  7 ;
    out[ 4  + outpos ] |= ( in[ 16 + inpos]   & 511  ) <<  16 ;
    out[ 4  + outpos ] |= ( in[ 17 + inpos]   & 511  ) <<  25 ;
    out[ 5  + outpos ] =  ( in[ 17 + inpos]   & 511 ) >>> ( 9  -  2 );
    out[ 5  + outpos ] |= ( in[ 18 + inpos]   & 511  ) <<  2 ;
    out[ 5  + outpos ] |= ( in[ 19 + inpos]   & 511  ) <<  11 ;
    out[ 5  + outpos ] |= ( in[ 20 + inpos]   & 511  ) <<  20 ;
    out[ 5  + outpos ] |= ( in[ 21 + inpos]   & 511  ) <<  29 ;
    out[ 6  + outpos ] =  ( in[ 21 + inpos]   & 511 ) >>> ( 9  -  6 );
    out[ 6  + outpos ] |= ( in[ 22 + inpos]   & 511  ) <<  6 ;
    out[ 6  + outpos ] |= ( in[ 23 + inpos]   & 511  ) <<  15 ;
    out[ 6  + outpos ] |= ( in[ 24 + inpos]   & 511  ) <<  24 ;
    out[ 7  + outpos ] =  ( in[ 24 + inpos]   & 511 ) >>> ( 9  -  1 );
    out[ 7  + outpos ] |= ( in[ 25 + inpos]   & 511  ) <<  1 ;
    out[ 7  + outpos ] |= ( in[ 26 + inpos]   & 511  ) <<  10 ;
    out[ 7  + outpos ] |= ( in[ 27 + inpos]   & 511  ) <<  19 ;
    out[ 7  + outpos ] |= ( in[ 28 + inpos]   & 511  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 28 + inpos]   & 511 ) >>> ( 9  -  5 );
    out[ 8  + outpos ] |= ( in[ 29 + inpos]   & 511  ) <<  5 ;
    out[ 8  + outpos ] |= ( in[ 30 + inpos]   & 511  ) <<  14 ;
    out[ 8  + outpos ] |= ( in[ 31 + inpos]   & 511  ) <<  23 ;
}




public static void fastpack10(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 1023 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 1023  ) <<  10 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 1023  ) <<  20 ;
    out[ 0  + outpos ] |= ( in[ 3 + inpos]   & 1023  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 3 + inpos]   & 1023 ) >>> ( 10  -  8 );
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 1023  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 1023  ) <<  18 ;
    out[ 1  + outpos ] |= ( in[ 6 + inpos]   & 1023  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 6 + inpos]   & 1023 ) >>> ( 10  -  6 );
    out[ 2  + outpos ] |= ( in[ 7 + inpos]   & 1023  ) <<  6 ;
    out[ 2  + outpos ] |= ( in[ 8 + inpos]   & 1023  ) <<  16 ;
    out[ 2  + outpos ] |= ( in[ 9 + inpos]   & 1023  ) <<  26 ;
    out[ 3  + outpos ] =  ( in[ 9 + inpos]   & 1023 ) >>> ( 10  -  4 );
    out[ 3  + outpos ] |= ( in[ 10 + inpos]   & 1023  ) <<  4 ;
    out[ 3  + outpos ] |= ( in[ 11 + inpos]   & 1023  ) <<  14 ;
    out[ 3  + outpos ] |= ( in[ 12 + inpos]   & 1023  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 12 + inpos]   & 1023 ) >>> ( 10  -  2 );
    out[ 4  + outpos ] |= ( in[ 13 + inpos]   & 1023  ) <<  2 ;
    out[ 4  + outpos ] |= ( in[ 14 + inpos]   & 1023  ) <<  12 ;
    out[ 4  + outpos ] |= ( in[ 15 + inpos]   & 1023  ) <<  22 ;
    out[ 5  + outpos ] = in[ 16 + inpos]   & 1023 ;
    out[ 5  + outpos ] |= ( in[ 17 + inpos]   & 1023  ) <<  10 ;
    out[ 5  + outpos ] |= ( in[ 18 + inpos]   & 1023  ) <<  20 ;
    out[ 5  + outpos ] |= ( in[ 19 + inpos]   & 1023  ) <<  30 ;
    out[ 6  + outpos ] =  ( in[ 19 + inpos]   & 1023 ) >>> ( 10  -  8 );
    out[ 6  + outpos ] |= ( in[ 20 + inpos]   & 1023  ) <<  8 ;
    out[ 6  + outpos ] |= ( in[ 21 + inpos]   & 1023  ) <<  18 ;
    out[ 6  + outpos ] |= ( in[ 22 + inpos]   & 1023  ) <<  28 ;
    out[ 7  + outpos ] =  ( in[ 22 + inpos]   & 1023 ) >>> ( 10  -  6 );
    out[ 7  + outpos ] |= ( in[ 23 + inpos]   & 1023  ) <<  6 ;
    out[ 7  + outpos ] |= ( in[ 24 + inpos]   & 1023  ) <<  16 ;
    out[ 7  + outpos ] |= ( in[ 25 + inpos]   & 1023  ) <<  26 ;
    out[ 8  + outpos ] =  ( in[ 25 + inpos]   & 1023 ) >>> ( 10  -  4 );
    out[ 8  + outpos ] |= ( in[ 26 + inpos]   & 1023  ) <<  4 ;
    out[ 8  + outpos ] |= ( in[ 27 + inpos]   & 1023  ) <<  14 ;
    out[ 8  + outpos ] |= ( in[ 28 + inpos]   & 1023  ) <<  24 ;
    out[ 9  + outpos ] =  ( in[ 28 + inpos]   & 1023 ) >>> ( 10  -  2 );
    out[ 9  + outpos ] |= ( in[ 29 + inpos]   & 1023  ) <<  2 ;
    out[ 9  + outpos ] |= ( in[ 30 + inpos]   & 1023  ) <<  12 ;
    out[ 9  + outpos ] |= ( in[ 31 + inpos]   & 1023  ) <<  22 ;
}




public static void fastpack11(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 2047 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 2047  ) <<  11 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 2047  ) <<  22 ;
    out[ 1  + outpos ] =  ( in[ 2 + inpos]   & 2047 ) >>> ( 11  -  1 );
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 2047  ) <<  1 ;
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 2047  ) <<  12 ;
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 2047  ) <<  23 ;
    out[ 2  + outpos ] =  ( in[ 5 + inpos]   & 2047 ) >>> ( 11  -  2 );
    out[ 2  + outpos ] |= ( in[ 6 + inpos]   & 2047  ) <<  2 ;
    out[ 2  + outpos ] |= ( in[ 7 + inpos]   & 2047  ) <<  13 ;
    out[ 2  + outpos ] |= ( in[ 8 + inpos]   & 2047  ) <<  24 ;
    out[ 3  + outpos ] =  ( in[ 8 + inpos]   & 2047 ) >>> ( 11  -  3 );
    out[ 3  + outpos ] |= ( in[ 9 + inpos]   & 2047  ) <<  3 ;
    out[ 3  + outpos ] |= ( in[ 10 + inpos]   & 2047  ) <<  14 ;
    out[ 3  + outpos ] |= ( in[ 11 + inpos]   & 2047  ) <<  25 ;
    out[ 4  + outpos ] =  ( in[ 11 + inpos]   & 2047 ) >>> ( 11  -  4 );
    out[ 4  + outpos ] |= ( in[ 12 + inpos]   & 2047  ) <<  4 ;
    out[ 4  + outpos ] |= ( in[ 13 + inpos]   & 2047  ) <<  15 ;
    out[ 4  + outpos ] |= ( in[ 14 + inpos]   & 2047  ) <<  26 ;
    out[ 5  + outpos ] =  ( in[ 14 + inpos]   & 2047 ) >>> ( 11  -  5 );
    out[ 5  + outpos ] |= ( in[ 15 + inpos]   & 2047  ) <<  5 ;
    out[ 5  + outpos ] |= ( in[ 16 + inpos]   & 2047  ) <<  16 ;
    out[ 5  + outpos ] |= ( in[ 17 + inpos]   & 2047  ) <<  27 ;
    out[ 6  + outpos ] =  ( in[ 17 + inpos]   & 2047 ) >>> ( 11  -  6 );
    out[ 6  + outpos ] |= ( in[ 18 + inpos]   & 2047  ) <<  6 ;
    out[ 6  + outpos ] |= ( in[ 19 + inpos]   & 2047  ) <<  17 ;
    out[ 6  + outpos ] |= ( in[ 20 + inpos]   & 2047  ) <<  28 ;
    out[ 7  + outpos ] =  ( in[ 20 + inpos]   & 2047 ) >>> ( 11  -  7 );
    out[ 7  + outpos ] |= ( in[ 21 + inpos]   & 2047  ) <<  7 ;
    out[ 7  + outpos ] |= ( in[ 22 + inpos]   & 2047  ) <<  18 ;
    out[ 7  + outpos ] |= ( in[ 23 + inpos]   & 2047  ) <<  29 ;
    out[ 8  + outpos ] =  ( in[ 23 + inpos]   & 2047 ) >>> ( 11  -  8 );
    out[ 8  + outpos ] |= ( in[ 24 + inpos]   & 2047  ) <<  8 ;
    out[ 8  + outpos ] |= ( in[ 25 + inpos]   & 2047  ) <<  19 ;
    out[ 8  + outpos ] |= ( in[ 26 + inpos]   & 2047  ) <<  30 ;
    out[ 9  + outpos ] =  ( in[ 26 + inpos]   & 2047 ) >>> ( 11  -  9 );
    out[ 9  + outpos ] |= ( in[ 27 + inpos]   & 2047  ) <<  9 ;
    out[ 9  + outpos ] |= ( in[ 28 + inpos]   & 2047  ) <<  20 ;
    out[ 9  + outpos ] |= ( in[ 29 + inpos]   & 2047  ) <<  31 ;
    out[ 10  + outpos ] =  ( in[ 29 + inpos]   & 2047 ) >>> ( 11  -  10 );
    out[ 10  + outpos ] |= ( in[ 30 + inpos]   & 2047  ) <<  10 ;
    out[ 10  + outpos ] |= ( in[ 31 + inpos]   & 2047  ) <<  21 ;
}




public static void fastpack12(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 4095 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 4095  ) <<  12 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 4095  ) <<  24 ;
    out[ 1  + outpos ] =  ( in[ 2 + inpos]   & 4095 ) >>> ( 12  -  4 );
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 4095  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 4095  ) <<  16 ;
    out[ 1  + outpos ] |= ( in[ 5 + inpos]   & 4095  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 5 + inpos]   & 4095 ) >>> ( 12  -  8 );
    out[ 2  + outpos ] |= ( in[ 6 + inpos]   & 4095  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 7 + inpos]   & 4095  ) <<  20 ;
    out[ 3  + outpos ] = in[ 8 + inpos]   & 4095 ;
    out[ 3  + outpos ] |= ( in[ 9 + inpos]   & 4095  ) <<  12 ;
    out[ 3  + outpos ] |= ( in[ 10 + inpos]   & 4095  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 10 + inpos]   & 4095 ) >>> ( 12  -  4 );
    out[ 4  + outpos ] |= ( in[ 11 + inpos]   & 4095  ) <<  4 ;
    out[ 4  + outpos ] |= ( in[ 12 + inpos]   & 4095  ) <<  16 ;
    out[ 4  + outpos ] |= ( in[ 13 + inpos]   & 4095  ) <<  28 ;
    out[ 5  + outpos ] =  ( in[ 13 + inpos]   & 4095 ) >>> ( 12  -  8 );
    out[ 5  + outpos ] |= ( in[ 14 + inpos]   & 4095  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 15 + inpos]   & 4095  ) <<  20 ;
    out[ 6  + outpos ] = in[ 16 + inpos]   & 4095 ;
    out[ 6  + outpos ] |= ( in[ 17 + inpos]   & 4095  ) <<  12 ;
    out[ 6  + outpos ] |= ( in[ 18 + inpos]   & 4095  ) <<  24 ;
    out[ 7  + outpos ] =  ( in[ 18 + inpos]   & 4095 ) >>> ( 12  -  4 );
    out[ 7  + outpos ] |= ( in[ 19 + inpos]   & 4095  ) <<  4 ;
    out[ 7  + outpos ] |= ( in[ 20 + inpos]   & 4095  ) <<  16 ;
    out[ 7  + outpos ] |= ( in[ 21 + inpos]   & 4095  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 21 + inpos]   & 4095 ) >>> ( 12  -  8 );
    out[ 8  + outpos ] |= ( in[ 22 + inpos]   & 4095  ) <<  8 ;
    out[ 8  + outpos ] |= ( in[ 23 + inpos]   & 4095  ) <<  20 ;
    out[ 9  + outpos ] = in[ 24 + inpos]   & 4095 ;
    out[ 9  + outpos ] |= ( in[ 25 + inpos]   & 4095  ) <<  12 ;
    out[ 9  + outpos ] |= ( in[ 26 + inpos]   & 4095  ) <<  24 ;
    out[ 10  + outpos ] =  ( in[ 26 + inpos]   & 4095 ) >>> ( 12  -  4 );
    out[ 10  + outpos ] |= ( in[ 27 + inpos]   & 4095  ) <<  4 ;
    out[ 10  + outpos ] |= ( in[ 28 + inpos]   & 4095  ) <<  16 ;
    out[ 10  + outpos ] |= ( in[ 29 + inpos]   & 4095  ) <<  28 ;
    out[ 11  + outpos ] =  ( in[ 29 + inpos]   & 4095 ) >>> ( 12  -  8 );
    out[ 11  + outpos ] |= ( in[ 30 + inpos]   & 4095  ) <<  8 ;
    out[ 11  + outpos ] |= ( in[ 31 + inpos]   & 4095  ) <<  20 ;
}




public static void fastpack13(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 8191 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 8191  ) <<  13 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 8191  ) <<  26 ;
    out[ 1  + outpos ] =  ( in[ 2 + inpos]   & 8191 ) >>> ( 13  -  7 );
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 8191  ) <<  7 ;
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 8191  ) <<  20 ;
    out[ 2  + outpos ] =  ( in[ 4 + inpos]   & 8191 ) >>> ( 13  -  1 );
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 8191  ) <<  1 ;
    out[ 2  + outpos ] |= ( in[ 6 + inpos]   & 8191  ) <<  14 ;
    out[ 2  + outpos ] |= ( in[ 7 + inpos]   & 8191  ) <<  27 ;
    out[ 3  + outpos ] =  ( in[ 7 + inpos]   & 8191 ) >>> ( 13  -  8 );
    out[ 3  + outpos ] |= ( in[ 8 + inpos]   & 8191  ) <<  8 ;
    out[ 3  + outpos ] |= ( in[ 9 + inpos]   & 8191  ) <<  21 ;
    out[ 4  + outpos ] =  ( in[ 9 + inpos]   & 8191 ) >>> ( 13  -  2 );
    out[ 4  + outpos ] |= ( in[ 10 + inpos]   & 8191  ) <<  2 ;
    out[ 4  + outpos ] |= ( in[ 11 + inpos]   & 8191  ) <<  15 ;
    out[ 4  + outpos ] |= ( in[ 12 + inpos]   & 8191  ) <<  28 ;
    out[ 5  + outpos ] =  ( in[ 12 + inpos]   & 8191 ) >>> ( 13  -  9 );
    out[ 5  + outpos ] |= ( in[ 13 + inpos]   & 8191  ) <<  9 ;
    out[ 5  + outpos ] |= ( in[ 14 + inpos]   & 8191  ) <<  22 ;
    out[ 6  + outpos ] =  ( in[ 14 + inpos]   & 8191 ) >>> ( 13  -  3 );
    out[ 6  + outpos ] |= ( in[ 15 + inpos]   & 8191  ) <<  3 ;
    out[ 6  + outpos ] |= ( in[ 16 + inpos]   & 8191  ) <<  16 ;
    out[ 6  + outpos ] |= ( in[ 17 + inpos]   & 8191  ) <<  29 ;
    out[ 7  + outpos ] =  ( in[ 17 + inpos]   & 8191 ) >>> ( 13  -  10 );
    out[ 7  + outpos ] |= ( in[ 18 + inpos]   & 8191  ) <<  10 ;
    out[ 7  + outpos ] |= ( in[ 19 + inpos]   & 8191  ) <<  23 ;
    out[ 8  + outpos ] =  ( in[ 19 + inpos]   & 8191 ) >>> ( 13  -  4 );
    out[ 8  + outpos ] |= ( in[ 20 + inpos]   & 8191  ) <<  4 ;
    out[ 8  + outpos ] |= ( in[ 21 + inpos]   & 8191  ) <<  17 ;
    out[ 8  + outpos ] |= ( in[ 22 + inpos]   & 8191  ) <<  30 ;
    out[ 9  + outpos ] =  ( in[ 22 + inpos]   & 8191 ) >>> ( 13  -  11 );
    out[ 9  + outpos ] |= ( in[ 23 + inpos]   & 8191  ) <<  11 ;
    out[ 9  + outpos ] |= ( in[ 24 + inpos]   & 8191  ) <<  24 ;
    out[ 10  + outpos ] =  ( in[ 24 + inpos]   & 8191 ) >>> ( 13  -  5 );
    out[ 10  + outpos ] |= ( in[ 25 + inpos]   & 8191  ) <<  5 ;
    out[ 10  + outpos ] |= ( in[ 26 + inpos]   & 8191  ) <<  18 ;
    out[ 10  + outpos ] |= ( in[ 27 + inpos]   & 8191  ) <<  31 ;
    out[ 11  + outpos ] =  ( in[ 27 + inpos]   & 8191 ) >>> ( 13  -  12 );
    out[ 11  + outpos ] |= ( in[ 28 + inpos]   & 8191  ) <<  12 ;
    out[ 11  + outpos ] |= ( in[ 29 + inpos]   & 8191  ) <<  25 ;
    out[ 12  + outpos ] =  ( in[ 29 + inpos]   & 8191 ) >>> ( 13  -  6 );
    out[ 12  + outpos ] |= ( in[ 30 + inpos]   & 8191  ) <<  6 ;
    out[ 12  + outpos ] |= ( in[ 31 + inpos]   & 8191  ) <<  19 ;
}




public static void fastpack14(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 16383 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 16383  ) <<  14 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 16383  ) <<  28 ;
    out[ 1  + outpos ] =  ( in[ 2 + inpos]   & 16383 ) >>> ( 14  -  10 );
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 16383  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 16383  ) <<  24 ;
    out[ 2  + outpos ] =  ( in[ 4 + inpos]   & 16383 ) >>> ( 14  -  6 );
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 16383  ) <<  6 ;
    out[ 2  + outpos ] |= ( in[ 6 + inpos]   & 16383  ) <<  20 ;
    out[ 3  + outpos ] =  ( in[ 6 + inpos]   & 16383 ) >>> ( 14  -  2 );
    out[ 3  + outpos ] |= ( in[ 7 + inpos]   & 16383  ) <<  2 ;
    out[ 3  + outpos ] |= ( in[ 8 + inpos]   & 16383  ) <<  16 ;
    out[ 3  + outpos ] |= ( in[ 9 + inpos]   & 16383  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 9 + inpos]   & 16383 ) >>> ( 14  -  12 );
    out[ 4  + outpos ] |= ( in[ 10 + inpos]   & 16383  ) <<  12 ;
    out[ 4  + outpos ] |= ( in[ 11 + inpos]   & 16383  ) <<  26 ;
    out[ 5  + outpos ] =  ( in[ 11 + inpos]   & 16383 ) >>> ( 14  -  8 );
    out[ 5  + outpos ] |= ( in[ 12 + inpos]   & 16383  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 13 + inpos]   & 16383  ) <<  22 ;
    out[ 6  + outpos ] =  ( in[ 13 + inpos]   & 16383 ) >>> ( 14  -  4 );
    out[ 6  + outpos ] |= ( in[ 14 + inpos]   & 16383  ) <<  4 ;
    out[ 6  + outpos ] |= ( in[ 15 + inpos]   & 16383  ) <<  18 ;
    out[ 7  + outpos ] = in[ 16 + inpos]   & 16383 ;
    out[ 7  + outpos ] |= ( in[ 17 + inpos]   & 16383  ) <<  14 ;
    out[ 7  + outpos ] |= ( in[ 18 + inpos]   & 16383  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 18 + inpos]   & 16383 ) >>> ( 14  -  10 );
    out[ 8  + outpos ] |= ( in[ 19 + inpos]   & 16383  ) <<  10 ;
    out[ 8  + outpos ] |= ( in[ 20 + inpos]   & 16383  ) <<  24 ;
    out[ 9  + outpos ] =  ( in[ 20 + inpos]   & 16383 ) >>> ( 14  -  6 );
    out[ 9  + outpos ] |= ( in[ 21 + inpos]   & 16383  ) <<  6 ;
    out[ 9  + outpos ] |= ( in[ 22 + inpos]   & 16383  ) <<  20 ;
    out[ 10  + outpos ] =  ( in[ 22 + inpos]   & 16383 ) >>> ( 14  -  2 );
    out[ 10  + outpos ] |= ( in[ 23 + inpos]   & 16383  ) <<  2 ;
    out[ 10  + outpos ] |= ( in[ 24 + inpos]   & 16383  ) <<  16 ;
    out[ 10  + outpos ] |= ( in[ 25 + inpos]   & 16383  ) <<  30 ;
    out[ 11  + outpos ] =  ( in[ 25 + inpos]   & 16383 ) >>> ( 14  -  12 );
    out[ 11  + outpos ] |= ( in[ 26 + inpos]   & 16383  ) <<  12 ;
    out[ 11  + outpos ] |= ( in[ 27 + inpos]   & 16383  ) <<  26 ;
    out[ 12  + outpos ] =  ( in[ 27 + inpos]   & 16383 ) >>> ( 14  -  8 );
    out[ 12  + outpos ] |= ( in[ 28 + inpos]   & 16383  ) <<  8 ;
    out[ 12  + outpos ] |= ( in[ 29 + inpos]   & 16383  ) <<  22 ;
    out[ 13  + outpos ] =  ( in[ 29 + inpos]   & 16383 ) >>> ( 14  -  4 );
    out[ 13  + outpos ] |= ( in[ 30 + inpos]   & 16383  ) <<  4 ;
    out[ 13  + outpos ] |= ( in[ 31 + inpos]   & 16383  ) <<  18 ;
}




public static void fastpack15(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 32767 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 32767  ) <<  15 ;
    out[ 0  + outpos ] |= ( in[ 2 + inpos]   & 32767  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 2 + inpos]   & 32767 ) >>> ( 15  -  13 );
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 32767  ) <<  13 ;
    out[ 1  + outpos ] |= ( in[ 4 + inpos]   & 32767  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 4 + inpos]   & 32767 ) >>> ( 15  -  11 );
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 32767  ) <<  11 ;
    out[ 2  + outpos ] |= ( in[ 6 + inpos]   & 32767  ) <<  26 ;
    out[ 3  + outpos ] =  ( in[ 6 + inpos]   & 32767 ) >>> ( 15  -  9 );
    out[ 3  + outpos ] |= ( in[ 7 + inpos]   & 32767  ) <<  9 ;
    out[ 3  + outpos ] |= ( in[ 8 + inpos]   & 32767  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 8 + inpos]   & 32767 ) >>> ( 15  -  7 );
    out[ 4  + outpos ] |= ( in[ 9 + inpos]   & 32767  ) <<  7 ;
    out[ 4  + outpos ] |= ( in[ 10 + inpos]   & 32767  ) <<  22 ;
    out[ 5  + outpos ] =  ( in[ 10 + inpos]   & 32767 ) >>> ( 15  -  5 );
    out[ 5  + outpos ] |= ( in[ 11 + inpos]   & 32767  ) <<  5 ;
    out[ 5  + outpos ] |= ( in[ 12 + inpos]   & 32767  ) <<  20 ;
    out[ 6  + outpos ] =  ( in[ 12 + inpos]   & 32767 ) >>> ( 15  -  3 );
    out[ 6  + outpos ] |= ( in[ 13 + inpos]   & 32767  ) <<  3 ;
    out[ 6  + outpos ] |= ( in[ 14 + inpos]   & 32767  ) <<  18 ;
    out[ 7  + outpos ] =  ( in[ 14 + inpos]   & 32767 ) >>> ( 15  -  1 );
    out[ 7  + outpos ] |= ( in[ 15 + inpos]   & 32767  ) <<  1 ;
    out[ 7  + outpos ] |= ( in[ 16 + inpos]   & 32767  ) <<  16 ;
    out[ 7  + outpos ] |= ( in[ 17 + inpos]   & 32767  ) <<  31 ;
    out[ 8  + outpos ] =  ( in[ 17 + inpos]   & 32767 ) >>> ( 15  -  14 );
    out[ 8  + outpos ] |= ( in[ 18 + inpos]   & 32767  ) <<  14 ;
    out[ 8  + outpos ] |= ( in[ 19 + inpos]   & 32767  ) <<  29 ;
    out[ 9  + outpos ] =  ( in[ 19 + inpos]   & 32767 ) >>> ( 15  -  12 );
    out[ 9  + outpos ] |= ( in[ 20 + inpos]   & 32767  ) <<  12 ;
    out[ 9  + outpos ] |= ( in[ 21 + inpos]   & 32767  ) <<  27 ;
    out[ 10  + outpos ] =  ( in[ 21 + inpos]   & 32767 ) >>> ( 15  -  10 );
    out[ 10  + outpos ] |= ( in[ 22 + inpos]   & 32767  ) <<  10 ;
    out[ 10  + outpos ] |= ( in[ 23 + inpos]   & 32767  ) <<  25 ;
    out[ 11  + outpos ] =  ( in[ 23 + inpos]   & 32767 ) >>> ( 15  -  8 );
    out[ 11  + outpos ] |= ( in[ 24 + inpos]   & 32767  ) <<  8 ;
    out[ 11  + outpos ] |= ( in[ 25 + inpos]   & 32767  ) <<  23 ;
    out[ 12  + outpos ] =  ( in[ 25 + inpos]   & 32767 ) >>> ( 15  -  6 );
    out[ 12  + outpos ] |= ( in[ 26 + inpos]   & 32767  ) <<  6 ;
    out[ 12  + outpos ] |= ( in[ 27 + inpos]   & 32767  ) <<  21 ;
    out[ 13  + outpos ] =  ( in[ 27 + inpos]   & 32767 ) >>> ( 15  -  4 );
    out[ 13  + outpos ] |= ( in[ 28 + inpos]   & 32767  ) <<  4 ;
    out[ 13  + outpos ] |= ( in[ 29 + inpos]   & 32767  ) <<  19 ;
    out[ 14  + outpos ] =  ( in[ 29 + inpos]   & 32767 ) >>> ( 15  -  2 );
    out[ 14  + outpos ] |= ( in[ 30 + inpos]   & 32767  ) <<  2 ;
    out[ 14  + outpos ] |= ( in[ 31 + inpos]   & 32767  ) <<  17 ;
}




public static void fastpack16(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 65535 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 65535  ) <<  16 ;
    out[ 1  + outpos ] = in[ 2 + inpos]   & 65535 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 65535  ) <<  16 ;
    out[ 2  + outpos ] = in[ 4 + inpos]   & 65535 ;
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 65535  ) <<  16 ;
    out[ 3  + outpos ] = in[ 6 + inpos]   & 65535 ;
    out[ 3  + outpos ] |= ( in[ 7 + inpos]   & 65535  ) <<  16 ;
    out[ 4  + outpos ] = in[ 8 + inpos]   & 65535 ;
    out[ 4  + outpos ] |= ( in[ 9 + inpos]   & 65535  ) <<  16 ;
    out[ 5  + outpos ] = in[ 10 + inpos]   & 65535 ;
    out[ 5  + outpos ] |= ( in[ 11 + inpos]   & 65535  ) <<  16 ;
    out[ 6  + outpos ] = in[ 12 + inpos]   & 65535 ;
    out[ 6  + outpos ] |= ( in[ 13 + inpos]   & 65535  ) <<  16 ;
    out[ 7  + outpos ] = in[ 14 + inpos]   & 65535 ;
    out[ 7  + outpos ] |= ( in[ 15 + inpos]   & 65535  ) <<  16 ;
    out[ 8  + outpos ] = in[ 16 + inpos]   & 65535 ;
    out[ 8  + outpos ] |= ( in[ 17 + inpos]   & 65535  ) <<  16 ;
    out[ 9  + outpos ] = in[ 18 + inpos]   & 65535 ;
    out[ 9  + outpos ] |= ( in[ 19 + inpos]   & 65535  ) <<  16 ;
    out[ 10  + outpos ] = in[ 20 + inpos]   & 65535 ;
    out[ 10  + outpos ] |= ( in[ 21 + inpos]   & 65535  ) <<  16 ;
    out[ 11  + outpos ] = in[ 22 + inpos]   & 65535 ;
    out[ 11  + outpos ] |= ( in[ 23 + inpos]   & 65535  ) <<  16 ;
    out[ 12  + outpos ] = in[ 24 + inpos]   & 65535 ;
    out[ 12  + outpos ] |= ( in[ 25 + inpos]   & 65535  ) <<  16 ;
    out[ 13  + outpos ] = in[ 26 + inpos]   & 65535 ;
    out[ 13  + outpos ] |= ( in[ 27 + inpos]   & 65535  ) <<  16 ;
    out[ 14  + outpos ] = in[ 28 + inpos]   & 65535 ;
    out[ 14  + outpos ] |= ( in[ 29 + inpos]   & 65535  ) <<  16 ;
    out[ 15  + outpos ] = in[ 30 + inpos]   & 65535 ;
    out[ 15  + outpos ] |= ( in[ 31 + inpos]   & 65535  ) <<  16 ;
}




public static void fastpack17(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 131071 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 131071  ) <<  17 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 131071 ) >>> ( 17  -  2 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 131071  ) <<  2 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 131071  ) <<  19 ;
    out[ 2  + outpos ] =  ( in[ 3 + inpos]   & 131071 ) >>> ( 17  -  4 );
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 131071  ) <<  4 ;
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 131071  ) <<  21 ;
    out[ 3  + outpos ] =  ( in[ 5 + inpos]   & 131071 ) >>> ( 17  -  6 );
    out[ 3  + outpos ] |= ( in[ 6 + inpos]   & 131071  ) <<  6 ;
    out[ 3  + outpos ] |= ( in[ 7 + inpos]   & 131071  ) <<  23 ;
    out[ 4  + outpos ] =  ( in[ 7 + inpos]   & 131071 ) >>> ( 17  -  8 );
    out[ 4  + outpos ] |= ( in[ 8 + inpos]   & 131071  ) <<  8 ;
    out[ 4  + outpos ] |= ( in[ 9 + inpos]   & 131071  ) <<  25 ;
    out[ 5  + outpos ] =  ( in[ 9 + inpos]   & 131071 ) >>> ( 17  -  10 );
    out[ 5  + outpos ] |= ( in[ 10 + inpos]   & 131071  ) <<  10 ;
    out[ 5  + outpos ] |= ( in[ 11 + inpos]   & 131071  ) <<  27 ;
    out[ 6  + outpos ] =  ( in[ 11 + inpos]   & 131071 ) >>> ( 17  -  12 );
    out[ 6  + outpos ] |= ( in[ 12 + inpos]   & 131071  ) <<  12 ;
    out[ 6  + outpos ] |= ( in[ 13 + inpos]   & 131071  ) <<  29 ;
    out[ 7  + outpos ] =  ( in[ 13 + inpos]   & 131071 ) >>> ( 17  -  14 );
    out[ 7  + outpos ] |= ( in[ 14 + inpos]   & 131071  ) <<  14 ;
    out[ 7  + outpos ] |= ( in[ 15 + inpos]   & 131071  ) <<  31 ;
    out[ 8  + outpos ] =  ( in[ 15 + inpos]   & 131071 ) >>> ( 17  -  16 );
    out[ 8  + outpos ] |= ( in[ 16 + inpos]   & 131071  ) <<  16 ;
    out[ 9  + outpos ] =  ( in[ 16 + inpos]   & 131071 ) >>> ( 17  -  1 );
    out[ 9  + outpos ] |= ( in[ 17 + inpos]   & 131071  ) <<  1 ;
    out[ 9  + outpos ] |= ( in[ 18 + inpos]   & 131071  ) <<  18 ;
    out[ 10  + outpos ] =  ( in[ 18 + inpos]   & 131071 ) >>> ( 17  -  3 );
    out[ 10  + outpos ] |= ( in[ 19 + inpos]   & 131071  ) <<  3 ;
    out[ 10  + outpos ] |= ( in[ 20 + inpos]   & 131071  ) <<  20 ;
    out[ 11  + outpos ] =  ( in[ 20 + inpos]   & 131071 ) >>> ( 17  -  5 );
    out[ 11  + outpos ] |= ( in[ 21 + inpos]   & 131071  ) <<  5 ;
    out[ 11  + outpos ] |= ( in[ 22 + inpos]   & 131071  ) <<  22 ;
    out[ 12  + outpos ] =  ( in[ 22 + inpos]   & 131071 ) >>> ( 17  -  7 );
    out[ 12  + outpos ] |= ( in[ 23 + inpos]   & 131071  ) <<  7 ;
    out[ 12  + outpos ] |= ( in[ 24 + inpos]   & 131071  ) <<  24 ;
    out[ 13  + outpos ] =  ( in[ 24 + inpos]   & 131071 ) >>> ( 17  -  9 );
    out[ 13  + outpos ] |= ( in[ 25 + inpos]   & 131071  ) <<  9 ;
    out[ 13  + outpos ] |= ( in[ 26 + inpos]   & 131071  ) <<  26 ;
    out[ 14  + outpos ] =  ( in[ 26 + inpos]   & 131071 ) >>> ( 17  -  11 );
    out[ 14  + outpos ] |= ( in[ 27 + inpos]   & 131071  ) <<  11 ;
    out[ 14  + outpos ] |= ( in[ 28 + inpos]   & 131071  ) <<  28 ;
    out[ 15  + outpos ] =  ( in[ 28 + inpos]   & 131071 ) >>> ( 17  -  13 );
    out[ 15  + outpos ] |= ( in[ 29 + inpos]   & 131071  ) <<  13 ;
    out[ 15  + outpos ] |= ( in[ 30 + inpos]   & 131071  ) <<  30 ;
    out[ 16  + outpos ] =  ( in[ 30 + inpos]   & 131071 ) >>> ( 17  -  15 );
    out[ 16  + outpos ] |= ( in[ 31 + inpos]   & 131071  ) <<  15 ;
}




public static void fastpack18(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 262143 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 262143  ) <<  18 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 262143 ) >>> ( 18  -  4 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 262143  ) <<  4 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 262143  ) <<  22 ;
    out[ 2  + outpos ] =  ( in[ 3 + inpos]   & 262143 ) >>> ( 18  -  8 );
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 262143  ) <<  8 ;
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 262143  ) <<  26 ;
    out[ 3  + outpos ] =  ( in[ 5 + inpos]   & 262143 ) >>> ( 18  -  12 );
    out[ 3  + outpos ] |= ( in[ 6 + inpos]   & 262143  ) <<  12 ;
    out[ 3  + outpos ] |= ( in[ 7 + inpos]   & 262143  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 7 + inpos]   & 262143 ) >>> ( 18  -  16 );
    out[ 4  + outpos ] |= ( in[ 8 + inpos]   & 262143  ) <<  16 ;
    out[ 5  + outpos ] =  ( in[ 8 + inpos]   & 262143 ) >>> ( 18  -  2 );
    out[ 5  + outpos ] |= ( in[ 9 + inpos]   & 262143  ) <<  2 ;
    out[ 5  + outpos ] |= ( in[ 10 + inpos]   & 262143  ) <<  20 ;
    out[ 6  + outpos ] =  ( in[ 10 + inpos]   & 262143 ) >>> ( 18  -  6 );
    out[ 6  + outpos ] |= ( in[ 11 + inpos]   & 262143  ) <<  6 ;
    out[ 6  + outpos ] |= ( in[ 12 + inpos]   & 262143  ) <<  24 ;
    out[ 7  + outpos ] =  ( in[ 12 + inpos]   & 262143 ) >>> ( 18  -  10 );
    out[ 7  + outpos ] |= ( in[ 13 + inpos]   & 262143  ) <<  10 ;
    out[ 7  + outpos ] |= ( in[ 14 + inpos]   & 262143  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 14 + inpos]   & 262143 ) >>> ( 18  -  14 );
    out[ 8  + outpos ] |= ( in[ 15 + inpos]   & 262143  ) <<  14 ;
    out[ 9  + outpos ] = in[ 16 + inpos]   & 262143 ;
    out[ 9  + outpos ] |= ( in[ 17 + inpos]   & 262143  ) <<  18 ;
    out[ 10  + outpos ] =  ( in[ 17 + inpos]   & 262143 ) >>> ( 18  -  4 );
    out[ 10  + outpos ] |= ( in[ 18 + inpos]   & 262143  ) <<  4 ;
    out[ 10  + outpos ] |= ( in[ 19 + inpos]   & 262143  ) <<  22 ;
    out[ 11  + outpos ] =  ( in[ 19 + inpos]   & 262143 ) >>> ( 18  -  8 );
    out[ 11  + outpos ] |= ( in[ 20 + inpos]   & 262143  ) <<  8 ;
    out[ 11  + outpos ] |= ( in[ 21 + inpos]   & 262143  ) <<  26 ;
    out[ 12  + outpos ] =  ( in[ 21 + inpos]   & 262143 ) >>> ( 18  -  12 );
    out[ 12  + outpos ] |= ( in[ 22 + inpos]   & 262143  ) <<  12 ;
    out[ 12  + outpos ] |= ( in[ 23 + inpos]   & 262143  ) <<  30 ;
    out[ 13  + outpos ] =  ( in[ 23 + inpos]   & 262143 ) >>> ( 18  -  16 );
    out[ 13  + outpos ] |= ( in[ 24 + inpos]   & 262143  ) <<  16 ;
    out[ 14  + outpos ] =  ( in[ 24 + inpos]   & 262143 ) >>> ( 18  -  2 );
    out[ 14  + outpos ] |= ( in[ 25 + inpos]   & 262143  ) <<  2 ;
    out[ 14  + outpos ] |= ( in[ 26 + inpos]   & 262143  ) <<  20 ;
    out[ 15  + outpos ] =  ( in[ 26 + inpos]   & 262143 ) >>> ( 18  -  6 );
    out[ 15  + outpos ] |= ( in[ 27 + inpos]   & 262143  ) <<  6 ;
    out[ 15  + outpos ] |= ( in[ 28 + inpos]   & 262143  ) <<  24 ;
    out[ 16  + outpos ] =  ( in[ 28 + inpos]   & 262143 ) >>> ( 18  -  10 );
    out[ 16  + outpos ] |= ( in[ 29 + inpos]   & 262143  ) <<  10 ;
    out[ 16  + outpos ] |= ( in[ 30 + inpos]   & 262143  ) <<  28 ;
    out[ 17  + outpos ] =  ( in[ 30 + inpos]   & 262143 ) >>> ( 18  -  14 );
    out[ 17  + outpos ] |= ( in[ 31 + inpos]   & 262143  ) <<  14 ;
}




public static void fastpack19(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 524287 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 524287  ) <<  19 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 524287 ) >>> ( 19  -  6 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 524287  ) <<  6 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 524287  ) <<  25 ;
    out[ 2  + outpos ] =  ( in[ 3 + inpos]   & 524287 ) >>> ( 19  -  12 );
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 524287  ) <<  12 ;
    out[ 2  + outpos ] |= ( in[ 5 + inpos]   & 524287  ) <<  31 ;
    out[ 3  + outpos ] =  ( in[ 5 + inpos]   & 524287 ) >>> ( 19  -  18 );
    out[ 3  + outpos ] |= ( in[ 6 + inpos]   & 524287  ) <<  18 ;
    out[ 4  + outpos ] =  ( in[ 6 + inpos]   & 524287 ) >>> ( 19  -  5 );
    out[ 4  + outpos ] |= ( in[ 7 + inpos]   & 524287  ) <<  5 ;
    out[ 4  + outpos ] |= ( in[ 8 + inpos]   & 524287  ) <<  24 ;
    out[ 5  + outpos ] =  ( in[ 8 + inpos]   & 524287 ) >>> ( 19  -  11 );
    out[ 5  + outpos ] |= ( in[ 9 + inpos]   & 524287  ) <<  11 ;
    out[ 5  + outpos ] |= ( in[ 10 + inpos]   & 524287  ) <<  30 ;
    out[ 6  + outpos ] =  ( in[ 10 + inpos]   & 524287 ) >>> ( 19  -  17 );
    out[ 6  + outpos ] |= ( in[ 11 + inpos]   & 524287  ) <<  17 ;
    out[ 7  + outpos ] =  ( in[ 11 + inpos]   & 524287 ) >>> ( 19  -  4 );
    out[ 7  + outpos ] |= ( in[ 12 + inpos]   & 524287  ) <<  4 ;
    out[ 7  + outpos ] |= ( in[ 13 + inpos]   & 524287  ) <<  23 ;
    out[ 8  + outpos ] =  ( in[ 13 + inpos]   & 524287 ) >>> ( 19  -  10 );
    out[ 8  + outpos ] |= ( in[ 14 + inpos]   & 524287  ) <<  10 ;
    out[ 8  + outpos ] |= ( in[ 15 + inpos]   & 524287  ) <<  29 ;
    out[ 9  + outpos ] =  ( in[ 15 + inpos]   & 524287 ) >>> ( 19  -  16 );
    out[ 9  + outpos ] |= ( in[ 16 + inpos]   & 524287  ) <<  16 ;
    out[ 10  + outpos ] =  ( in[ 16 + inpos]   & 524287 ) >>> ( 19  -  3 );
    out[ 10  + outpos ] |= ( in[ 17 + inpos]   & 524287  ) <<  3 ;
    out[ 10  + outpos ] |= ( in[ 18 + inpos]   & 524287  ) <<  22 ;
    out[ 11  + outpos ] =  ( in[ 18 + inpos]   & 524287 ) >>> ( 19  -  9 );
    out[ 11  + outpos ] |= ( in[ 19 + inpos]   & 524287  ) <<  9 ;
    out[ 11  + outpos ] |= ( in[ 20 + inpos]   & 524287  ) <<  28 ;
    out[ 12  + outpos ] =  ( in[ 20 + inpos]   & 524287 ) >>> ( 19  -  15 );
    out[ 12  + outpos ] |= ( in[ 21 + inpos]   & 524287  ) <<  15 ;
    out[ 13  + outpos ] =  ( in[ 21 + inpos]   & 524287 ) >>> ( 19  -  2 );
    out[ 13  + outpos ] |= ( in[ 22 + inpos]   & 524287  ) <<  2 ;
    out[ 13  + outpos ] |= ( in[ 23 + inpos]   & 524287  ) <<  21 ;
    out[ 14  + outpos ] =  ( in[ 23 + inpos]   & 524287 ) >>> ( 19  -  8 );
    out[ 14  + outpos ] |= ( in[ 24 + inpos]   & 524287  ) <<  8 ;
    out[ 14  + outpos ] |= ( in[ 25 + inpos]   & 524287  ) <<  27 ;
    out[ 15  + outpos ] =  ( in[ 25 + inpos]   & 524287 ) >>> ( 19  -  14 );
    out[ 15  + outpos ] |= ( in[ 26 + inpos]   & 524287  ) <<  14 ;
    out[ 16  + outpos ] =  ( in[ 26 + inpos]   & 524287 ) >>> ( 19  -  1 );
    out[ 16  + outpos ] |= ( in[ 27 + inpos]   & 524287  ) <<  1 ;
    out[ 16  + outpos ] |= ( in[ 28 + inpos]   & 524287  ) <<  20 ;
    out[ 17  + outpos ] =  ( in[ 28 + inpos]   & 524287 ) >>> ( 19  -  7 );
    out[ 17  + outpos ] |= ( in[ 29 + inpos]   & 524287  ) <<  7 ;
    out[ 17  + outpos ] |= ( in[ 30 + inpos]   & 524287  ) <<  26 ;
    out[ 18  + outpos ] =  ( in[ 30 + inpos]   & 524287 ) >>> ( 19  -  13 );
    out[ 18  + outpos ] |= ( in[ 31 + inpos]   & 524287  ) <<  13 ;
}




public static void fastpack20(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 1048575 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 1048575  ) <<  20 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 1048575 ) >>> ( 20  -  8 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 1048575  ) <<  8 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 1048575  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 3 + inpos]   & 1048575 ) >>> ( 20  -  16 );
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 1048575  ) <<  16 ;
    out[ 3  + outpos ] =  ( in[ 4 + inpos]   & 1048575 ) >>> ( 20  -  4 );
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 1048575  ) <<  4 ;
    out[ 3  + outpos ] |= ( in[ 6 + inpos]   & 1048575  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 6 + inpos]   & 1048575 ) >>> ( 20  -  12 );
    out[ 4  + outpos ] |= ( in[ 7 + inpos]   & 1048575  ) <<  12 ;
    out[ 5  + outpos ] = in[ 8 + inpos]   & 1048575 ;
    out[ 5  + outpos ] |= ( in[ 9 + inpos]   & 1048575  ) <<  20 ;
    out[ 6  + outpos ] =  ( in[ 9 + inpos]   & 1048575 ) >>> ( 20  -  8 );
    out[ 6  + outpos ] |= ( in[ 10 + inpos]   & 1048575  ) <<  8 ;
    out[ 6  + outpos ] |= ( in[ 11 + inpos]   & 1048575  ) <<  28 ;
    out[ 7  + outpos ] =  ( in[ 11 + inpos]   & 1048575 ) >>> ( 20  -  16 );
    out[ 7  + outpos ] |= ( in[ 12 + inpos]   & 1048575  ) <<  16 ;
    out[ 8  + outpos ] =  ( in[ 12 + inpos]   & 1048575 ) >>> ( 20  -  4 );
    out[ 8  + outpos ] |= ( in[ 13 + inpos]   & 1048575  ) <<  4 ;
    out[ 8  + outpos ] |= ( in[ 14 + inpos]   & 1048575  ) <<  24 ;
    out[ 9  + outpos ] =  ( in[ 14 + inpos]   & 1048575 ) >>> ( 20  -  12 );
    out[ 9  + outpos ] |= ( in[ 15 + inpos]   & 1048575  ) <<  12 ;
    out[ 10  + outpos ] = in[ 16 + inpos]   & 1048575 ;
    out[ 10  + outpos ] |= ( in[ 17 + inpos]   & 1048575  ) <<  20 ;
    out[ 11  + outpos ] =  ( in[ 17 + inpos]   & 1048575 ) >>> ( 20  -  8 );
    out[ 11  + outpos ] |= ( in[ 18 + inpos]   & 1048575  ) <<  8 ;
    out[ 11  + outpos ] |= ( in[ 19 + inpos]   & 1048575  ) <<  28 ;
    out[ 12  + outpos ] =  ( in[ 19 + inpos]   & 1048575 ) >>> ( 20  -  16 );
    out[ 12  + outpos ] |= ( in[ 20 + inpos]   & 1048575  ) <<  16 ;
    out[ 13  + outpos ] =  ( in[ 20 + inpos]   & 1048575 ) >>> ( 20  -  4 );
    out[ 13  + outpos ] |= ( in[ 21 + inpos]   & 1048575  ) <<  4 ;
    out[ 13  + outpos ] |= ( in[ 22 + inpos]   & 1048575  ) <<  24 ;
    out[ 14  + outpos ] =  ( in[ 22 + inpos]   & 1048575 ) >>> ( 20  -  12 );
    out[ 14  + outpos ] |= ( in[ 23 + inpos]   & 1048575  ) <<  12 ;
    out[ 15  + outpos ] = in[ 24 + inpos]   & 1048575 ;
    out[ 15  + outpos ] |= ( in[ 25 + inpos]   & 1048575  ) <<  20 ;
    out[ 16  + outpos ] =  ( in[ 25 + inpos]   & 1048575 ) >>> ( 20  -  8 );
    out[ 16  + outpos ] |= ( in[ 26 + inpos]   & 1048575  ) <<  8 ;
    out[ 16  + outpos ] |= ( in[ 27 + inpos]   & 1048575  ) <<  28 ;
    out[ 17  + outpos ] =  ( in[ 27 + inpos]   & 1048575 ) >>> ( 20  -  16 );
    out[ 17  + outpos ] |= ( in[ 28 + inpos]   & 1048575  ) <<  16 ;
    out[ 18  + outpos ] =  ( in[ 28 + inpos]   & 1048575 ) >>> ( 20  -  4 );
    out[ 18  + outpos ] |= ( in[ 29 + inpos]   & 1048575  ) <<  4 ;
    out[ 18  + outpos ] |= ( in[ 30 + inpos]   & 1048575  ) <<  24 ;
    out[ 19  + outpos ] =  ( in[ 30 + inpos]   & 1048575 ) >>> ( 20  -  12 );
    out[ 19  + outpos ] |= ( in[ 31 + inpos]   & 1048575  ) <<  12 ;
}




public static void fastpack21(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 2097151 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 2097151  ) <<  21 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 2097151 ) >>> ( 21  -  10 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 2097151  ) <<  10 ;
    out[ 1  + outpos ] |= ( in[ 3 + inpos]   & 2097151  ) <<  31 ;
    out[ 2  + outpos ] =  ( in[ 3 + inpos]   & 2097151 ) >>> ( 21  -  20 );
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 2097151  ) <<  20 ;
    out[ 3  + outpos ] =  ( in[ 4 + inpos]   & 2097151 ) >>> ( 21  -  9 );
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 2097151  ) <<  9 ;
    out[ 3  + outpos ] |= ( in[ 6 + inpos]   & 2097151  ) <<  30 ;
    out[ 4  + outpos ] =  ( in[ 6 + inpos]   & 2097151 ) >>> ( 21  -  19 );
    out[ 4  + outpos ] |= ( in[ 7 + inpos]   & 2097151  ) <<  19 ;
    out[ 5  + outpos ] =  ( in[ 7 + inpos]   & 2097151 ) >>> ( 21  -  8 );
    out[ 5  + outpos ] |= ( in[ 8 + inpos]   & 2097151  ) <<  8 ;
    out[ 5  + outpos ] |= ( in[ 9 + inpos]   & 2097151  ) <<  29 ;
    out[ 6  + outpos ] =  ( in[ 9 + inpos]   & 2097151 ) >>> ( 21  -  18 );
    out[ 6  + outpos ] |= ( in[ 10 + inpos]   & 2097151  ) <<  18 ;
    out[ 7  + outpos ] =  ( in[ 10 + inpos]   & 2097151 ) >>> ( 21  -  7 );
    out[ 7  + outpos ] |= ( in[ 11 + inpos]   & 2097151  ) <<  7 ;
    out[ 7  + outpos ] |= ( in[ 12 + inpos]   & 2097151  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 12 + inpos]   & 2097151 ) >>> ( 21  -  17 );
    out[ 8  + outpos ] |= ( in[ 13 + inpos]   & 2097151  ) <<  17 ;
    out[ 9  + outpos ] =  ( in[ 13 + inpos]   & 2097151 ) >>> ( 21  -  6 );
    out[ 9  + outpos ] |= ( in[ 14 + inpos]   & 2097151  ) <<  6 ;
    out[ 9  + outpos ] |= ( in[ 15 + inpos]   & 2097151  ) <<  27 ;
    out[ 10  + outpos ] =  ( in[ 15 + inpos]   & 2097151 ) >>> ( 21  -  16 );
    out[ 10  + outpos ] |= ( in[ 16 + inpos]   & 2097151  ) <<  16 ;
    out[ 11  + outpos ] =  ( in[ 16 + inpos]   & 2097151 ) >>> ( 21  -  5 );
    out[ 11  + outpos ] |= ( in[ 17 + inpos]   & 2097151  ) <<  5 ;
    out[ 11  + outpos ] |= ( in[ 18 + inpos]   & 2097151  ) <<  26 ;
    out[ 12  + outpos ] =  ( in[ 18 + inpos]   & 2097151 ) >>> ( 21  -  15 );
    out[ 12  + outpos ] |= ( in[ 19 + inpos]   & 2097151  ) <<  15 ;
    out[ 13  + outpos ] =  ( in[ 19 + inpos]   & 2097151 ) >>> ( 21  -  4 );
    out[ 13  + outpos ] |= ( in[ 20 + inpos]   & 2097151  ) <<  4 ;
    out[ 13  + outpos ] |= ( in[ 21 + inpos]   & 2097151  ) <<  25 ;
    out[ 14  + outpos ] =  ( in[ 21 + inpos]   & 2097151 ) >>> ( 21  -  14 );
    out[ 14  + outpos ] |= ( in[ 22 + inpos]   & 2097151  ) <<  14 ;
    out[ 15  + outpos ] =  ( in[ 22 + inpos]   & 2097151 ) >>> ( 21  -  3 );
    out[ 15  + outpos ] |= ( in[ 23 + inpos]   & 2097151  ) <<  3 ;
    out[ 15  + outpos ] |= ( in[ 24 + inpos]   & 2097151  ) <<  24 ;
    out[ 16  + outpos ] =  ( in[ 24 + inpos]   & 2097151 ) >>> ( 21  -  13 );
    out[ 16  + outpos ] |= ( in[ 25 + inpos]   & 2097151  ) <<  13 ;
    out[ 17  + outpos ] =  ( in[ 25 + inpos]   & 2097151 ) >>> ( 21  -  2 );
    out[ 17  + outpos ] |= ( in[ 26 + inpos]   & 2097151  ) <<  2 ;
    out[ 17  + outpos ] |= ( in[ 27 + inpos]   & 2097151  ) <<  23 ;
    out[ 18  + outpos ] =  ( in[ 27 + inpos]   & 2097151 ) >>> ( 21  -  12 );
    out[ 18  + outpos ] |= ( in[ 28 + inpos]   & 2097151  ) <<  12 ;
    out[ 19  + outpos ] =  ( in[ 28 + inpos]   & 2097151 ) >>> ( 21  -  1 );
    out[ 19  + outpos ] |= ( in[ 29 + inpos]   & 2097151  ) <<  1 ;
    out[ 19  + outpos ] |= ( in[ 30 + inpos]   & 2097151  ) <<  22 ;
    out[ 20  + outpos ] =  ( in[ 30 + inpos]   & 2097151 ) >>> ( 21  -  11 );
    out[ 20  + outpos ] |= ( in[ 31 + inpos]   & 2097151  ) <<  11 ;
}




public static void fastpack22(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 4194303 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 4194303  ) <<  22 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 4194303 ) >>> ( 22  -  12 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 4194303  ) <<  12 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 4194303 ) >>> ( 22  -  2 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 4194303  ) <<  2 ;
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 4194303  ) <<  24 ;
    out[ 3  + outpos ] =  ( in[ 4 + inpos]   & 4194303 ) >>> ( 22  -  14 );
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 4194303  ) <<  14 ;
    out[ 4  + outpos ] =  ( in[ 5 + inpos]   & 4194303 ) >>> ( 22  -  4 );
    out[ 4  + outpos ] |= ( in[ 6 + inpos]   & 4194303  ) <<  4 ;
    out[ 4  + outpos ] |= ( in[ 7 + inpos]   & 4194303  ) <<  26 ;
    out[ 5  + outpos ] =  ( in[ 7 + inpos]   & 4194303 ) >>> ( 22  -  16 );
    out[ 5  + outpos ] |= ( in[ 8 + inpos]   & 4194303  ) <<  16 ;
    out[ 6  + outpos ] =  ( in[ 8 + inpos]   & 4194303 ) >>> ( 22  -  6 );
    out[ 6  + outpos ] |= ( in[ 9 + inpos]   & 4194303  ) <<  6 ;
    out[ 6  + outpos ] |= ( in[ 10 + inpos]   & 4194303  ) <<  28 ;
    out[ 7  + outpos ] =  ( in[ 10 + inpos]   & 4194303 ) >>> ( 22  -  18 );
    out[ 7  + outpos ] |= ( in[ 11 + inpos]   & 4194303  ) <<  18 ;
    out[ 8  + outpos ] =  ( in[ 11 + inpos]   & 4194303 ) >>> ( 22  -  8 );
    out[ 8  + outpos ] |= ( in[ 12 + inpos]   & 4194303  ) <<  8 ;
    out[ 8  + outpos ] |= ( in[ 13 + inpos]   & 4194303  ) <<  30 ;
    out[ 9  + outpos ] =  ( in[ 13 + inpos]   & 4194303 ) >>> ( 22  -  20 );
    out[ 9  + outpos ] |= ( in[ 14 + inpos]   & 4194303  ) <<  20 ;
    out[ 10  + outpos ] =  ( in[ 14 + inpos]   & 4194303 ) >>> ( 22  -  10 );
    out[ 10  + outpos ] |= ( in[ 15 + inpos]   & 4194303  ) <<  10 ;
    out[ 11  + outpos ] = in[ 16 + inpos]   & 4194303 ;
    out[ 11  + outpos ] |= ( in[ 17 + inpos]   & 4194303  ) <<  22 ;
    out[ 12  + outpos ] =  ( in[ 17 + inpos]   & 4194303 ) >>> ( 22  -  12 );
    out[ 12  + outpos ] |= ( in[ 18 + inpos]   & 4194303  ) <<  12 ;
    out[ 13  + outpos ] =  ( in[ 18 + inpos]   & 4194303 ) >>> ( 22  -  2 );
    out[ 13  + outpos ] |= ( in[ 19 + inpos]   & 4194303  ) <<  2 ;
    out[ 13  + outpos ] |= ( in[ 20 + inpos]   & 4194303  ) <<  24 ;
    out[ 14  + outpos ] =  ( in[ 20 + inpos]   & 4194303 ) >>> ( 22  -  14 );
    out[ 14  + outpos ] |= ( in[ 21 + inpos]   & 4194303  ) <<  14 ;
    out[ 15  + outpos ] =  ( in[ 21 + inpos]   & 4194303 ) >>> ( 22  -  4 );
    out[ 15  + outpos ] |= ( in[ 22 + inpos]   & 4194303  ) <<  4 ;
    out[ 15  + outpos ] |= ( in[ 23 + inpos]   & 4194303  ) <<  26 ;
    out[ 16  + outpos ] =  ( in[ 23 + inpos]   & 4194303 ) >>> ( 22  -  16 );
    out[ 16  + outpos ] |= ( in[ 24 + inpos]   & 4194303  ) <<  16 ;
    out[ 17  + outpos ] =  ( in[ 24 + inpos]   & 4194303 ) >>> ( 22  -  6 );
    out[ 17  + outpos ] |= ( in[ 25 + inpos]   & 4194303  ) <<  6 ;
    out[ 17  + outpos ] |= ( in[ 26 + inpos]   & 4194303  ) <<  28 ;
    out[ 18  + outpos ] =  ( in[ 26 + inpos]   & 4194303 ) >>> ( 22  -  18 );
    out[ 18  + outpos ] |= ( in[ 27 + inpos]   & 4194303  ) <<  18 ;
    out[ 19  + outpos ] =  ( in[ 27 + inpos]   & 4194303 ) >>> ( 22  -  8 );
    out[ 19  + outpos ] |= ( in[ 28 + inpos]   & 4194303  ) <<  8 ;
    out[ 19  + outpos ] |= ( in[ 29 + inpos]   & 4194303  ) <<  30 ;
    out[ 20  + outpos ] =  ( in[ 29 + inpos]   & 4194303 ) >>> ( 22  -  20 );
    out[ 20  + outpos ] |= ( in[ 30 + inpos]   & 4194303  ) <<  20 ;
    out[ 21  + outpos ] =  ( in[ 30 + inpos]   & 4194303 ) >>> ( 22  -  10 );
    out[ 21  + outpos ] |= ( in[ 31 + inpos]   & 4194303  ) <<  10 ;
}




public static void fastpack23(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 8388607 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 8388607  ) <<  23 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 8388607 ) >>> ( 23  -  14 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 8388607  ) <<  14 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 8388607 ) >>> ( 23  -  5 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 8388607  ) <<  5 ;
    out[ 2  + outpos ] |= ( in[ 4 + inpos]   & 8388607  ) <<  28 ;
    out[ 3  + outpos ] =  ( in[ 4 + inpos]   & 8388607 ) >>> ( 23  -  19 );
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 8388607  ) <<  19 ;
    out[ 4  + outpos ] =  ( in[ 5 + inpos]   & 8388607 ) >>> ( 23  -  10 );
    out[ 4  + outpos ] |= ( in[ 6 + inpos]   & 8388607  ) <<  10 ;
    out[ 5  + outpos ] =  ( in[ 6 + inpos]   & 8388607 ) >>> ( 23  -  1 );
    out[ 5  + outpos ] |= ( in[ 7 + inpos]   & 8388607  ) <<  1 ;
    out[ 5  + outpos ] |= ( in[ 8 + inpos]   & 8388607  ) <<  24 ;
    out[ 6  + outpos ] =  ( in[ 8 + inpos]   & 8388607 ) >>> ( 23  -  15 );
    out[ 6  + outpos ] |= ( in[ 9 + inpos]   & 8388607  ) <<  15 ;
    out[ 7  + outpos ] =  ( in[ 9 + inpos]   & 8388607 ) >>> ( 23  -  6 );
    out[ 7  + outpos ] |= ( in[ 10 + inpos]   & 8388607  ) <<  6 ;
    out[ 7  + outpos ] |= ( in[ 11 + inpos]   & 8388607  ) <<  29 ;
    out[ 8  + outpos ] =  ( in[ 11 + inpos]   & 8388607 ) >>> ( 23  -  20 );
    out[ 8  + outpos ] |= ( in[ 12 + inpos]   & 8388607  ) <<  20 ;
    out[ 9  + outpos ] =  ( in[ 12 + inpos]   & 8388607 ) >>> ( 23  -  11 );
    out[ 9  + outpos ] |= ( in[ 13 + inpos]   & 8388607  ) <<  11 ;
    out[ 10  + outpos ] =  ( in[ 13 + inpos]   & 8388607 ) >>> ( 23  -  2 );
    out[ 10  + outpos ] |= ( in[ 14 + inpos]   & 8388607  ) <<  2 ;
    out[ 10  + outpos ] |= ( in[ 15 + inpos]   & 8388607  ) <<  25 ;
    out[ 11  + outpos ] =  ( in[ 15 + inpos]   & 8388607 ) >>> ( 23  -  16 );
    out[ 11  + outpos ] |= ( in[ 16 + inpos]   & 8388607  ) <<  16 ;
    out[ 12  + outpos ] =  ( in[ 16 + inpos]   & 8388607 ) >>> ( 23  -  7 );
    out[ 12  + outpos ] |= ( in[ 17 + inpos]   & 8388607  ) <<  7 ;
    out[ 12  + outpos ] |= ( in[ 18 + inpos]   & 8388607  ) <<  30 ;
    out[ 13  + outpos ] =  ( in[ 18 + inpos]   & 8388607 ) >>> ( 23  -  21 );
    out[ 13  + outpos ] |= ( in[ 19 + inpos]   & 8388607  ) <<  21 ;
    out[ 14  + outpos ] =  ( in[ 19 + inpos]   & 8388607 ) >>> ( 23  -  12 );
    out[ 14  + outpos ] |= ( in[ 20 + inpos]   & 8388607  ) <<  12 ;
    out[ 15  + outpos ] =  ( in[ 20 + inpos]   & 8388607 ) >>> ( 23  -  3 );
    out[ 15  + outpos ] |= ( in[ 21 + inpos]   & 8388607  ) <<  3 ;
    out[ 15  + outpos ] |= ( in[ 22 + inpos]   & 8388607  ) <<  26 ;
    out[ 16  + outpos ] =  ( in[ 22 + inpos]   & 8388607 ) >>> ( 23  -  17 );
    out[ 16  + outpos ] |= ( in[ 23 + inpos]   & 8388607  ) <<  17 ;
    out[ 17  + outpos ] =  ( in[ 23 + inpos]   & 8388607 ) >>> ( 23  -  8 );
    out[ 17  + outpos ] |= ( in[ 24 + inpos]   & 8388607  ) <<  8 ;
    out[ 17  + outpos ] |= ( in[ 25 + inpos]   & 8388607  ) <<  31 ;
    out[ 18  + outpos ] =  ( in[ 25 + inpos]   & 8388607 ) >>> ( 23  -  22 );
    out[ 18  + outpos ] |= ( in[ 26 + inpos]   & 8388607  ) <<  22 ;
    out[ 19  + outpos ] =  ( in[ 26 + inpos]   & 8388607 ) >>> ( 23  -  13 );
    out[ 19  + outpos ] |= ( in[ 27 + inpos]   & 8388607  ) <<  13 ;
    out[ 20  + outpos ] =  ( in[ 27 + inpos]   & 8388607 ) >>> ( 23  -  4 );
    out[ 20  + outpos ] |= ( in[ 28 + inpos]   & 8388607  ) <<  4 ;
    out[ 20  + outpos ] |= ( in[ 29 + inpos]   & 8388607  ) <<  27 ;
    out[ 21  + outpos ] =  ( in[ 29 + inpos]   & 8388607 ) >>> ( 23  -  18 );
    out[ 21  + outpos ] |= ( in[ 30 + inpos]   & 8388607  ) <<  18 ;
    out[ 22  + outpos ] =  ( in[ 30 + inpos]   & 8388607 ) >>> ( 23  -  9 );
    out[ 22  + outpos ] |= ( in[ 31 + inpos]   & 8388607  ) <<  9 ;
}




public static void fastpack24(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 16777215 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 16777215  ) <<  24 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 16777215  ) <<  16 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 16777215  ) <<  8 ;
    out[ 3  + outpos ] = in[ 4 + inpos]   & 16777215 ;
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 16777215  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 5 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 4  + outpos ] |= ( in[ 6 + inpos]   & 16777215  ) <<  16 ;
    out[ 5  + outpos ] =  ( in[ 6 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 5  + outpos ] |= ( in[ 7 + inpos]   & 16777215  ) <<  8 ;
    out[ 6  + outpos ] = in[ 8 + inpos]   & 16777215 ;
    out[ 6  + outpos ] |= ( in[ 9 + inpos]   & 16777215  ) <<  24 ;
    out[ 7  + outpos ] =  ( in[ 9 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 7  + outpos ] |= ( in[ 10 + inpos]   & 16777215  ) <<  16 ;
    out[ 8  + outpos ] =  ( in[ 10 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 8  + outpos ] |= ( in[ 11 + inpos]   & 16777215  ) <<  8 ;
    out[ 9  + outpos ] = in[ 12 + inpos]   & 16777215 ;
    out[ 9  + outpos ] |= ( in[ 13 + inpos]   & 16777215  ) <<  24 ;
    out[ 10  + outpos ] =  ( in[ 13 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 10  + outpos ] |= ( in[ 14 + inpos]   & 16777215  ) <<  16 ;
    out[ 11  + outpos ] =  ( in[ 14 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 11  + outpos ] |= ( in[ 15 + inpos]   & 16777215  ) <<  8 ;
    out[ 12  + outpos ] = in[ 16 + inpos]   & 16777215 ;
    out[ 12  + outpos ] |= ( in[ 17 + inpos]   & 16777215  ) <<  24 ;
    out[ 13  + outpos ] =  ( in[ 17 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 13  + outpos ] |= ( in[ 18 + inpos]   & 16777215  ) <<  16 ;
    out[ 14  + outpos ] =  ( in[ 18 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 14  + outpos ] |= ( in[ 19 + inpos]   & 16777215  ) <<  8 ;
    out[ 15  + outpos ] = in[ 20 + inpos]   & 16777215 ;
    out[ 15  + outpos ] |= ( in[ 21 + inpos]   & 16777215  ) <<  24 ;
    out[ 16  + outpos ] =  ( in[ 21 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 16  + outpos ] |= ( in[ 22 + inpos]   & 16777215  ) <<  16 ;
    out[ 17  + outpos ] =  ( in[ 22 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 17  + outpos ] |= ( in[ 23 + inpos]   & 16777215  ) <<  8 ;
    out[ 18  + outpos ] = in[ 24 + inpos]   & 16777215 ;
    out[ 18  + outpos ] |= ( in[ 25 + inpos]   & 16777215  ) <<  24 ;
    out[ 19  + outpos ] =  ( in[ 25 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 19  + outpos ] |= ( in[ 26 + inpos]   & 16777215  ) <<  16 ;
    out[ 20  + outpos ] =  ( in[ 26 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 20  + outpos ] |= ( in[ 27 + inpos]   & 16777215  ) <<  8 ;
    out[ 21  + outpos ] = in[ 28 + inpos]   & 16777215 ;
    out[ 21  + outpos ] |= ( in[ 29 + inpos]   & 16777215  ) <<  24 ;
    out[ 22  + outpos ] =  ( in[ 29 + inpos]   & 16777215 ) >>> ( 24  -  16 );
    out[ 22  + outpos ] |= ( in[ 30 + inpos]   & 16777215  ) <<  16 ;
    out[ 23  + outpos ] =  ( in[ 30 + inpos]   & 16777215 ) >>> ( 24  -  8 );
    out[ 23  + outpos ] |= ( in[ 31 + inpos]   & 16777215  ) <<  8 ;
}




public static void fastpack25(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 33554431 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 33554431  ) <<  25 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 33554431 ) >>> ( 25  -  18 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 33554431  ) <<  18 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 33554431 ) >>> ( 25  -  11 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 33554431  ) <<  11 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 33554431 ) >>> ( 25  -  4 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 33554431  ) <<  4 ;
    out[ 3  + outpos ] |= ( in[ 5 + inpos]   & 33554431  ) <<  29 ;
    out[ 4  + outpos ] =  ( in[ 5 + inpos]   & 33554431 ) >>> ( 25  -  22 );
    out[ 4  + outpos ] |= ( in[ 6 + inpos]   & 33554431  ) <<  22 ;
    out[ 5  + outpos ] =  ( in[ 6 + inpos]   & 33554431 ) >>> ( 25  -  15 );
    out[ 5  + outpos ] |= ( in[ 7 + inpos]   & 33554431  ) <<  15 ;
    out[ 6  + outpos ] =  ( in[ 7 + inpos]   & 33554431 ) >>> ( 25  -  8 );
    out[ 6  + outpos ] |= ( in[ 8 + inpos]   & 33554431  ) <<  8 ;
    out[ 7  + outpos ] =  ( in[ 8 + inpos]   & 33554431 ) >>> ( 25  -  1 );
    out[ 7  + outpos ] |= ( in[ 9 + inpos]   & 33554431  ) <<  1 ;
    out[ 7  + outpos ] |= ( in[ 10 + inpos]   & 33554431  ) <<  26 ;
    out[ 8  + outpos ] =  ( in[ 10 + inpos]   & 33554431 ) >>> ( 25  -  19 );
    out[ 8  + outpos ] |= ( in[ 11 + inpos]   & 33554431  ) <<  19 ;
    out[ 9  + outpos ] =  ( in[ 11 + inpos]   & 33554431 ) >>> ( 25  -  12 );
    out[ 9  + outpos ] |= ( in[ 12 + inpos]   & 33554431  ) <<  12 ;
    out[ 10  + outpos ] =  ( in[ 12 + inpos]   & 33554431 ) >>> ( 25  -  5 );
    out[ 10  + outpos ] |= ( in[ 13 + inpos]   & 33554431  ) <<  5 ;
    out[ 10  + outpos ] |= ( in[ 14 + inpos]   & 33554431  ) <<  30 ;
    out[ 11  + outpos ] =  ( in[ 14 + inpos]   & 33554431 ) >>> ( 25  -  23 );
    out[ 11  + outpos ] |= ( in[ 15 + inpos]   & 33554431  ) <<  23 ;
    out[ 12  + outpos ] =  ( in[ 15 + inpos]   & 33554431 ) >>> ( 25  -  16 );
    out[ 12  + outpos ] |= ( in[ 16 + inpos]   & 33554431  ) <<  16 ;
    out[ 13  + outpos ] =  ( in[ 16 + inpos]   & 33554431 ) >>> ( 25  -  9 );
    out[ 13  + outpos ] |= ( in[ 17 + inpos]   & 33554431  ) <<  9 ;
    out[ 14  + outpos ] =  ( in[ 17 + inpos]   & 33554431 ) >>> ( 25  -  2 );
    out[ 14  + outpos ] |= ( in[ 18 + inpos]   & 33554431  ) <<  2 ;
    out[ 14  + outpos ] |= ( in[ 19 + inpos]   & 33554431  ) <<  27 ;
    out[ 15  + outpos ] =  ( in[ 19 + inpos]   & 33554431 ) >>> ( 25  -  20 );
    out[ 15  + outpos ] |= ( in[ 20 + inpos]   & 33554431  ) <<  20 ;
    out[ 16  + outpos ] =  ( in[ 20 + inpos]   & 33554431 ) >>> ( 25  -  13 );
    out[ 16  + outpos ] |= ( in[ 21 + inpos]   & 33554431  ) <<  13 ;
    out[ 17  + outpos ] =  ( in[ 21 + inpos]   & 33554431 ) >>> ( 25  -  6 );
    out[ 17  + outpos ] |= ( in[ 22 + inpos]   & 33554431  ) <<  6 ;
    out[ 17  + outpos ] |= ( in[ 23 + inpos]   & 33554431  ) <<  31 ;
    out[ 18  + outpos ] =  ( in[ 23 + inpos]   & 33554431 ) >>> ( 25  -  24 );
    out[ 18  + outpos ] |= ( in[ 24 + inpos]   & 33554431  ) <<  24 ;
    out[ 19  + outpos ] =  ( in[ 24 + inpos]   & 33554431 ) >>> ( 25  -  17 );
    out[ 19  + outpos ] |= ( in[ 25 + inpos]   & 33554431  ) <<  17 ;
    out[ 20  + outpos ] =  ( in[ 25 + inpos]   & 33554431 ) >>> ( 25  -  10 );
    out[ 20  + outpos ] |= ( in[ 26 + inpos]   & 33554431  ) <<  10 ;
    out[ 21  + outpos ] =  ( in[ 26 + inpos]   & 33554431 ) >>> ( 25  -  3 );
    out[ 21  + outpos ] |= ( in[ 27 + inpos]   & 33554431  ) <<  3 ;
    out[ 21  + outpos ] |= ( in[ 28 + inpos]   & 33554431  ) <<  28 ;
    out[ 22  + outpos ] =  ( in[ 28 + inpos]   & 33554431 ) >>> ( 25  -  21 );
    out[ 22  + outpos ] |= ( in[ 29 + inpos]   & 33554431  ) <<  21 ;
    out[ 23  + outpos ] =  ( in[ 29 + inpos]   & 33554431 ) >>> ( 25  -  14 );
    out[ 23  + outpos ] |= ( in[ 30 + inpos]   & 33554431  ) <<  14 ;
    out[ 24  + outpos ] =  ( in[ 30 + inpos]   & 33554431 ) >>> ( 25  -  7 );
    out[ 24  + outpos ] |= ( in[ 31 + inpos]   & 33554431  ) <<  7 ;
}




public static void fastpack26(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 67108863 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 67108863  ) <<  26 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 67108863 ) >>> ( 26  -  20 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 67108863  ) <<  20 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 67108863 ) >>> ( 26  -  14 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 67108863  ) <<  14 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 67108863 ) >>> ( 26  -  8 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 67108863  ) <<  8 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 67108863 ) >>> ( 26  -  2 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 67108863  ) <<  2 ;
    out[ 4  + outpos ] |= ( in[ 6 + inpos]   & 67108863  ) <<  28 ;
    out[ 5  + outpos ] =  ( in[ 6 + inpos]   & 67108863 ) >>> ( 26  -  22 );
    out[ 5  + outpos ] |= ( in[ 7 + inpos]   & 67108863  ) <<  22 ;
    out[ 6  + outpos ] =  ( in[ 7 + inpos]   & 67108863 ) >>> ( 26  -  16 );
    out[ 6  + outpos ] |= ( in[ 8 + inpos]   & 67108863  ) <<  16 ;
    out[ 7  + outpos ] =  ( in[ 8 + inpos]   & 67108863 ) >>> ( 26  -  10 );
    out[ 7  + outpos ] |= ( in[ 9 + inpos]   & 67108863  ) <<  10 ;
    out[ 8  + outpos ] =  ( in[ 9 + inpos]   & 67108863 ) >>> ( 26  -  4 );
    out[ 8  + outpos ] |= ( in[ 10 + inpos]   & 67108863  ) <<  4 ;
    out[ 8  + outpos ] |= ( in[ 11 + inpos]   & 67108863  ) <<  30 ;
    out[ 9  + outpos ] =  ( in[ 11 + inpos]   & 67108863 ) >>> ( 26  -  24 );
    out[ 9  + outpos ] |= ( in[ 12 + inpos]   & 67108863  ) <<  24 ;
    out[ 10  + outpos ] =  ( in[ 12 + inpos]   & 67108863 ) >>> ( 26  -  18 );
    out[ 10  + outpos ] |= ( in[ 13 + inpos]   & 67108863  ) <<  18 ;
    out[ 11  + outpos ] =  ( in[ 13 + inpos]   & 67108863 ) >>> ( 26  -  12 );
    out[ 11  + outpos ] |= ( in[ 14 + inpos]   & 67108863  ) <<  12 ;
    out[ 12  + outpos ] =  ( in[ 14 + inpos]   & 67108863 ) >>> ( 26  -  6 );
    out[ 12  + outpos ] |= ( in[ 15 + inpos]   & 67108863  ) <<  6 ;
    out[ 13  + outpos ] = in[ 16 + inpos]   & 67108863 ;
    out[ 13  + outpos ] |= ( in[ 17 + inpos]   & 67108863  ) <<  26 ;
    out[ 14  + outpos ] =  ( in[ 17 + inpos]   & 67108863 ) >>> ( 26  -  20 );
    out[ 14  + outpos ] |= ( in[ 18 + inpos]   & 67108863  ) <<  20 ;
    out[ 15  + outpos ] =  ( in[ 18 + inpos]   & 67108863 ) >>> ( 26  -  14 );
    out[ 15  + outpos ] |= ( in[ 19 + inpos]   & 67108863  ) <<  14 ;
    out[ 16  + outpos ] =  ( in[ 19 + inpos]   & 67108863 ) >>> ( 26  -  8 );
    out[ 16  + outpos ] |= ( in[ 20 + inpos]   & 67108863  ) <<  8 ;
    out[ 17  + outpos ] =  ( in[ 20 + inpos]   & 67108863 ) >>> ( 26  -  2 );
    out[ 17  + outpos ] |= ( in[ 21 + inpos]   & 67108863  ) <<  2 ;
    out[ 17  + outpos ] |= ( in[ 22 + inpos]   & 67108863  ) <<  28 ;
    out[ 18  + outpos ] =  ( in[ 22 + inpos]   & 67108863 ) >>> ( 26  -  22 );
    out[ 18  + outpos ] |= ( in[ 23 + inpos]   & 67108863  ) <<  22 ;
    out[ 19  + outpos ] =  ( in[ 23 + inpos]   & 67108863 ) >>> ( 26  -  16 );
    out[ 19  + outpos ] |= ( in[ 24 + inpos]   & 67108863  ) <<  16 ;
    out[ 20  + outpos ] =  ( in[ 24 + inpos]   & 67108863 ) >>> ( 26  -  10 );
    out[ 20  + outpos ] |= ( in[ 25 + inpos]   & 67108863  ) <<  10 ;
    out[ 21  + outpos ] =  ( in[ 25 + inpos]   & 67108863 ) >>> ( 26  -  4 );
    out[ 21  + outpos ] |= ( in[ 26 + inpos]   & 67108863  ) <<  4 ;
    out[ 21  + outpos ] |= ( in[ 27 + inpos]   & 67108863  ) <<  30 ;
    out[ 22  + outpos ] =  ( in[ 27 + inpos]   & 67108863 ) >>> ( 26  -  24 );
    out[ 22  + outpos ] |= ( in[ 28 + inpos]   & 67108863  ) <<  24 ;
    out[ 23  + outpos ] =  ( in[ 28 + inpos]   & 67108863 ) >>> ( 26  -  18 );
    out[ 23  + outpos ] |= ( in[ 29 + inpos]   & 67108863  ) <<  18 ;
    out[ 24  + outpos ] =  ( in[ 29 + inpos]   & 67108863 ) >>> ( 26  -  12 );
    out[ 24  + outpos ] |= ( in[ 30 + inpos]   & 67108863  ) <<  12 ;
    out[ 25  + outpos ] =  ( in[ 30 + inpos]   & 67108863 ) >>> ( 26  -  6 );
    out[ 25  + outpos ] |= ( in[ 31 + inpos]   & 67108863  ) <<  6 ;
}




public static void fastpack27(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 134217727 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 134217727  ) <<  27 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 134217727 ) >>> ( 27  -  22 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 134217727  ) <<  22 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 134217727 ) >>> ( 27  -  17 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 134217727  ) <<  17 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 134217727 ) >>> ( 27  -  12 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 134217727  ) <<  12 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 134217727 ) >>> ( 27  -  7 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 134217727  ) <<  7 ;
    out[ 5  + outpos ] =  ( in[ 5 + inpos]   & 134217727 ) >>> ( 27  -  2 );
    out[ 5  + outpos ] |= ( in[ 6 + inpos]   & 134217727  ) <<  2 ;
    out[ 5  + outpos ] |= ( in[ 7 + inpos]   & 134217727  ) <<  29 ;
    out[ 6  + outpos ] =  ( in[ 7 + inpos]   & 134217727 ) >>> ( 27  -  24 );
    out[ 6  + outpos ] |= ( in[ 8 + inpos]   & 134217727  ) <<  24 ;
    out[ 7  + outpos ] =  ( in[ 8 + inpos]   & 134217727 ) >>> ( 27  -  19 );
    out[ 7  + outpos ] |= ( in[ 9 + inpos]   & 134217727  ) <<  19 ;
    out[ 8  + outpos ] =  ( in[ 9 + inpos]   & 134217727 ) >>> ( 27  -  14 );
    out[ 8  + outpos ] |= ( in[ 10 + inpos]   & 134217727  ) <<  14 ;
    out[ 9  + outpos ] =  ( in[ 10 + inpos]   & 134217727 ) >>> ( 27  -  9 );
    out[ 9  + outpos ] |= ( in[ 11 + inpos]   & 134217727  ) <<  9 ;
    out[ 10  + outpos ] =  ( in[ 11 + inpos]   & 134217727 ) >>> ( 27  -  4 );
    out[ 10  + outpos ] |= ( in[ 12 + inpos]   & 134217727  ) <<  4 ;
    out[ 10  + outpos ] |= ( in[ 13 + inpos]   & 134217727  ) <<  31 ;
    out[ 11  + outpos ] =  ( in[ 13 + inpos]   & 134217727 ) >>> ( 27  -  26 );
    out[ 11  + outpos ] |= ( in[ 14 + inpos]   & 134217727  ) <<  26 ;
    out[ 12  + outpos ] =  ( in[ 14 + inpos]   & 134217727 ) >>> ( 27  -  21 );
    out[ 12  + outpos ] |= ( in[ 15 + inpos]   & 134217727  ) <<  21 ;
    out[ 13  + outpos ] =  ( in[ 15 + inpos]   & 134217727 ) >>> ( 27  -  16 );
    out[ 13  + outpos ] |= ( in[ 16 + inpos]   & 134217727  ) <<  16 ;
    out[ 14  + outpos ] =  ( in[ 16 + inpos]   & 134217727 ) >>> ( 27  -  11 );
    out[ 14  + outpos ] |= ( in[ 17 + inpos]   & 134217727  ) <<  11 ;
    out[ 15  + outpos ] =  ( in[ 17 + inpos]   & 134217727 ) >>> ( 27  -  6 );
    out[ 15  + outpos ] |= ( in[ 18 + inpos]   & 134217727  ) <<  6 ;
    out[ 16  + outpos ] =  ( in[ 18 + inpos]   & 134217727 ) >>> ( 27  -  1 );
    out[ 16  + outpos ] |= ( in[ 19 + inpos]   & 134217727  ) <<  1 ;
    out[ 16  + outpos ] |= ( in[ 20 + inpos]   & 134217727  ) <<  28 ;
    out[ 17  + outpos ] =  ( in[ 20 + inpos]   & 134217727 ) >>> ( 27  -  23 );
    out[ 17  + outpos ] |= ( in[ 21 + inpos]   & 134217727  ) <<  23 ;
    out[ 18  + outpos ] =  ( in[ 21 + inpos]   & 134217727 ) >>> ( 27  -  18 );
    out[ 18  + outpos ] |= ( in[ 22 + inpos]   & 134217727  ) <<  18 ;
    out[ 19  + outpos ] =  ( in[ 22 + inpos]   & 134217727 ) >>> ( 27  -  13 );
    out[ 19  + outpos ] |= ( in[ 23 + inpos]   & 134217727  ) <<  13 ;
    out[ 20  + outpos ] =  ( in[ 23 + inpos]   & 134217727 ) >>> ( 27  -  8 );
    out[ 20  + outpos ] |= ( in[ 24 + inpos]   & 134217727  ) <<  8 ;
    out[ 21  + outpos ] =  ( in[ 24 + inpos]   & 134217727 ) >>> ( 27  -  3 );
    out[ 21  + outpos ] |= ( in[ 25 + inpos]   & 134217727  ) <<  3 ;
    out[ 21  + outpos ] |= ( in[ 26 + inpos]   & 134217727  ) <<  30 ;
    out[ 22  + outpos ] =  ( in[ 26 + inpos]   & 134217727 ) >>> ( 27  -  25 );
    out[ 22  + outpos ] |= ( in[ 27 + inpos]   & 134217727  ) <<  25 ;
    out[ 23  + outpos ] =  ( in[ 27 + inpos]   & 134217727 ) >>> ( 27  -  20 );
    out[ 23  + outpos ] |= ( in[ 28 + inpos]   & 134217727  ) <<  20 ;
    out[ 24  + outpos ] =  ( in[ 28 + inpos]   & 134217727 ) >>> ( 27  -  15 );
    out[ 24  + outpos ] |= ( in[ 29 + inpos]   & 134217727  ) <<  15 ;
    out[ 25  + outpos ] =  ( in[ 29 + inpos]   & 134217727 ) >>> ( 27  -  10 );
    out[ 25  + outpos ] |= ( in[ 30 + inpos]   & 134217727  ) <<  10 ;
    out[ 26  + outpos ] =  ( in[ 30 + inpos]   & 134217727 ) >>> ( 27  -  5 );
    out[ 26  + outpos ] |= ( in[ 31 + inpos]   & 134217727  ) <<  5 ;
}




public static void fastpack28(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 268435455 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 268435455  ) <<  28 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 268435455 ) >>> ( 28  -  24 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 268435455  ) <<  24 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 268435455 ) >>> ( 28  -  20 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 268435455  ) <<  20 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 268435455 ) >>> ( 28  -  16 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 268435455  ) <<  16 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 268435455 ) >>> ( 28  -  12 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 268435455  ) <<  12 ;
    out[ 5  + outpos ] =  ( in[ 5 + inpos]   & 268435455 ) >>> ( 28  -  8 );
    out[ 5  + outpos ] |= ( in[ 6 + inpos]   & 268435455  ) <<  8 ;
    out[ 6  + outpos ] =  ( in[ 6 + inpos]   & 268435455 ) >>> ( 28  -  4 );
    out[ 6  + outpos ] |= ( in[ 7 + inpos]   & 268435455  ) <<  4 ;
    out[ 7  + outpos ] = in[ 8 + inpos]   & 268435455 ;
    out[ 7  + outpos ] |= ( in[ 9 + inpos]   & 268435455  ) <<  28 ;
    out[ 8  + outpos ] =  ( in[ 9 + inpos]   & 268435455 ) >>> ( 28  -  24 );
    out[ 8  + outpos ] |= ( in[ 10 + inpos]   & 268435455  ) <<  24 ;
    out[ 9  + outpos ] =  ( in[ 10 + inpos]   & 268435455 ) >>> ( 28  -  20 );
    out[ 9  + outpos ] |= ( in[ 11 + inpos]   & 268435455  ) <<  20 ;
    out[ 10  + outpos ] =  ( in[ 11 + inpos]   & 268435455 ) >>> ( 28  -  16 );
    out[ 10  + outpos ] |= ( in[ 12 + inpos]   & 268435455  ) <<  16 ;
    out[ 11  + outpos ] =  ( in[ 12 + inpos]   & 268435455 ) >>> ( 28  -  12 );
    out[ 11  + outpos ] |= ( in[ 13 + inpos]   & 268435455  ) <<  12 ;
    out[ 12  + outpos ] =  ( in[ 13 + inpos]   & 268435455 ) >>> ( 28  -  8 );
    out[ 12  + outpos ] |= ( in[ 14 + inpos]   & 268435455  ) <<  8 ;
    out[ 13  + outpos ] =  ( in[ 14 + inpos]   & 268435455 ) >>> ( 28  -  4 );
    out[ 13  + outpos ] |= ( in[ 15 + inpos]   & 268435455  ) <<  4 ;
    out[ 14  + outpos ] = in[ 16 + inpos]   & 268435455 ;
    out[ 14  + outpos ] |= ( in[ 17 + inpos]   & 268435455  ) <<  28 ;
    out[ 15  + outpos ] =  ( in[ 17 + inpos]   & 268435455 ) >>> ( 28  -  24 );
    out[ 15  + outpos ] |= ( in[ 18 + inpos]   & 268435455  ) <<  24 ;
    out[ 16  + outpos ] =  ( in[ 18 + inpos]   & 268435455 ) >>> ( 28  -  20 );
    out[ 16  + outpos ] |= ( in[ 19 + inpos]   & 268435455  ) <<  20 ;
    out[ 17  + outpos ] =  ( in[ 19 + inpos]   & 268435455 ) >>> ( 28  -  16 );
    out[ 17  + outpos ] |= ( in[ 20 + inpos]   & 268435455  ) <<  16 ;
    out[ 18  + outpos ] =  ( in[ 20 + inpos]   & 268435455 ) >>> ( 28  -  12 );
    out[ 18  + outpos ] |= ( in[ 21 + inpos]   & 268435455  ) <<  12 ;
    out[ 19  + outpos ] =  ( in[ 21 + inpos]   & 268435455 ) >>> ( 28  -  8 );
    out[ 19  + outpos ] |= ( in[ 22 + inpos]   & 268435455  ) <<  8 ;
    out[ 20  + outpos ] =  ( in[ 22 + inpos]   & 268435455 ) >>> ( 28  -  4 );
    out[ 20  + outpos ] |= ( in[ 23 + inpos]   & 268435455  ) <<  4 ;
    out[ 21  + outpos ] = in[ 24 + inpos]   & 268435455 ;
    out[ 21  + outpos ] |= ( in[ 25 + inpos]   & 268435455  ) <<  28 ;
    out[ 22  + outpos ] =  ( in[ 25 + inpos]   & 268435455 ) >>> ( 28  -  24 );
    out[ 22  + outpos ] |= ( in[ 26 + inpos]   & 268435455  ) <<  24 ;
    out[ 23  + outpos ] =  ( in[ 26 + inpos]   & 268435455 ) >>> ( 28  -  20 );
    out[ 23  + outpos ] |= ( in[ 27 + inpos]   & 268435455  ) <<  20 ;
    out[ 24  + outpos ] =  ( in[ 27 + inpos]   & 268435455 ) >>> ( 28  -  16 );
    out[ 24  + outpos ] |= ( in[ 28 + inpos]   & 268435455  ) <<  16 ;
    out[ 25  + outpos ] =  ( in[ 28 + inpos]   & 268435455 ) >>> ( 28  -  12 );
    out[ 25  + outpos ] |= ( in[ 29 + inpos]   & 268435455  ) <<  12 ;
    out[ 26  + outpos ] =  ( in[ 29 + inpos]   & 268435455 ) >>> ( 28  -  8 );
    out[ 26  + outpos ] |= ( in[ 30 + inpos]   & 268435455  ) <<  8 ;
    out[ 27  + outpos ] =  ( in[ 30 + inpos]   & 268435455 ) >>> ( 28  -  4 );
    out[ 27  + outpos ] |= ( in[ 31 + inpos]   & 268435455  ) <<  4 ;
}




public static void fastpack29(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 536870911 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 536870911  ) <<  29 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 536870911 ) >>> ( 29  -  26 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 536870911  ) <<  26 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 536870911 ) >>> ( 29  -  23 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 536870911  ) <<  23 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 536870911 ) >>> ( 29  -  20 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 536870911  ) <<  20 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 536870911 ) >>> ( 29  -  17 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 536870911  ) <<  17 ;
    out[ 5  + outpos ] =  ( in[ 5 + inpos]   & 536870911 ) >>> ( 29  -  14 );
    out[ 5  + outpos ] |= ( in[ 6 + inpos]   & 536870911  ) <<  14 ;
    out[ 6  + outpos ] =  ( in[ 6 + inpos]   & 536870911 ) >>> ( 29  -  11 );
    out[ 6  + outpos ] |= ( in[ 7 + inpos]   & 536870911  ) <<  11 ;
    out[ 7  + outpos ] =  ( in[ 7 + inpos]   & 536870911 ) >>> ( 29  -  8 );
    out[ 7  + outpos ] |= ( in[ 8 + inpos]   & 536870911  ) <<  8 ;
    out[ 8  + outpos ] =  ( in[ 8 + inpos]   & 536870911 ) >>> ( 29  -  5 );
    out[ 8  + outpos ] |= ( in[ 9 + inpos]   & 536870911  ) <<  5 ;
    out[ 9  + outpos ] =  ( in[ 9 + inpos]   & 536870911 ) >>> ( 29  -  2 );
    out[ 9  + outpos ] |= ( in[ 10 + inpos]   & 536870911  ) <<  2 ;
    out[ 9  + outpos ] |= ( in[ 11 + inpos]   & 536870911  ) <<  31 ;
    out[ 10  + outpos ] =  ( in[ 11 + inpos]   & 536870911 ) >>> ( 29  -  28 );
    out[ 10  + outpos ] |= ( in[ 12 + inpos]   & 536870911  ) <<  28 ;
    out[ 11  + outpos ] =  ( in[ 12 + inpos]   & 536870911 ) >>> ( 29  -  25 );
    out[ 11  + outpos ] |= ( in[ 13 + inpos]   & 536870911  ) <<  25 ;
    out[ 12  + outpos ] =  ( in[ 13 + inpos]   & 536870911 ) >>> ( 29  -  22 );
    out[ 12  + outpos ] |= ( in[ 14 + inpos]   & 536870911  ) <<  22 ;
    out[ 13  + outpos ] =  ( in[ 14 + inpos]   & 536870911 ) >>> ( 29  -  19 );
    out[ 13  + outpos ] |= ( in[ 15 + inpos]   & 536870911  ) <<  19 ;
    out[ 14  + outpos ] =  ( in[ 15 + inpos]   & 536870911 ) >>> ( 29  -  16 );
    out[ 14  + outpos ] |= ( in[ 16 + inpos]   & 536870911  ) <<  16 ;
    out[ 15  + outpos ] =  ( in[ 16 + inpos]   & 536870911 ) >>> ( 29  -  13 );
    out[ 15  + outpos ] |= ( in[ 17 + inpos]   & 536870911  ) <<  13 ;
    out[ 16  + outpos ] =  ( in[ 17 + inpos]   & 536870911 ) >>> ( 29  -  10 );
    out[ 16  + outpos ] |= ( in[ 18 + inpos]   & 536870911  ) <<  10 ;
    out[ 17  + outpos ] =  ( in[ 18 + inpos]   & 536870911 ) >>> ( 29  -  7 );
    out[ 17  + outpos ] |= ( in[ 19 + inpos]   & 536870911  ) <<  7 ;
    out[ 18  + outpos ] =  ( in[ 19 + inpos]   & 536870911 ) >>> ( 29  -  4 );
    out[ 18  + outpos ] |= ( in[ 20 + inpos]   & 536870911  ) <<  4 ;
    out[ 19  + outpos ] =  ( in[ 20 + inpos]   & 536870911 ) >>> ( 29  -  1 );
    out[ 19  + outpos ] |= ( in[ 21 + inpos]   & 536870911  ) <<  1 ;
    out[ 19  + outpos ] |= ( in[ 22 + inpos]   & 536870911  ) <<  30 ;
    out[ 20  + outpos ] =  ( in[ 22 + inpos]   & 536870911 ) >>> ( 29  -  27 );
    out[ 20  + outpos ] |= ( in[ 23 + inpos]   & 536870911  ) <<  27 ;
    out[ 21  + outpos ] =  ( in[ 23 + inpos]   & 536870911 ) >>> ( 29  -  24 );
    out[ 21  + outpos ] |= ( in[ 24 + inpos]   & 536870911  ) <<  24 ;
    out[ 22  + outpos ] =  ( in[ 24 + inpos]   & 536870911 ) >>> ( 29  -  21 );
    out[ 22  + outpos ] |= ( in[ 25 + inpos]   & 536870911  ) <<  21 ;
    out[ 23  + outpos ] =  ( in[ 25 + inpos]   & 536870911 ) >>> ( 29  -  18 );
    out[ 23  + outpos ] |= ( in[ 26 + inpos]   & 536870911  ) <<  18 ;
    out[ 24  + outpos ] =  ( in[ 26 + inpos]   & 536870911 ) >>> ( 29  -  15 );
    out[ 24  + outpos ] |= ( in[ 27 + inpos]   & 536870911  ) <<  15 ;
    out[ 25  + outpos ] =  ( in[ 27 + inpos]   & 536870911 ) >>> ( 29  -  12 );
    out[ 25  + outpos ] |= ( in[ 28 + inpos]   & 536870911  ) <<  12 ;
    out[ 26  + outpos ] =  ( in[ 28 + inpos]   & 536870911 ) >>> ( 29  -  9 );
    out[ 26  + outpos ] |= ( in[ 29 + inpos]   & 536870911  ) <<  9 ;
    out[ 27  + outpos ] =  ( in[ 29 + inpos]   & 536870911 ) >>> ( 29  -  6 );
    out[ 27  + outpos ] |= ( in[ 30 + inpos]   & 536870911  ) <<  6 ;
    out[ 28  + outpos ] =  ( in[ 30 + inpos]   & 536870911 ) >>> ( 29  -  3 );
    out[ 28  + outpos ] |= ( in[ 31 + inpos]   & 536870911  ) <<  3 ;
}




public static void fastpack30(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 1073741823 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 1073741823  ) <<  30 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 1073741823 ) >>> ( 30  -  28 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 1073741823  ) <<  28 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 1073741823 ) >>> ( 30  -  26 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 1073741823  ) <<  26 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 1073741823 ) >>> ( 30  -  24 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 1073741823  ) <<  24 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 1073741823 ) >>> ( 30  -  22 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 1073741823  ) <<  22 ;
    out[ 5  + outpos ] =  ( in[ 5 + inpos]   & 1073741823 ) >>> ( 30  -  20 );
    out[ 5  + outpos ] |= ( in[ 6 + inpos]   & 1073741823  ) <<  20 ;
    out[ 6  + outpos ] =  ( in[ 6 + inpos]   & 1073741823 ) >>> ( 30  -  18 );
    out[ 6  + outpos ] |= ( in[ 7 + inpos]   & 1073741823  ) <<  18 ;
    out[ 7  + outpos ] =  ( in[ 7 + inpos]   & 1073741823 ) >>> ( 30  -  16 );
    out[ 7  + outpos ] |= ( in[ 8 + inpos]   & 1073741823  ) <<  16 ;
    out[ 8  + outpos ] =  ( in[ 8 + inpos]   & 1073741823 ) >>> ( 30  -  14 );
    out[ 8  + outpos ] |= ( in[ 9 + inpos]   & 1073741823  ) <<  14 ;
    out[ 9  + outpos ] =  ( in[ 9 + inpos]   & 1073741823 ) >>> ( 30  -  12 );
    out[ 9  + outpos ] |= ( in[ 10 + inpos]   & 1073741823  ) <<  12 ;
    out[ 10  + outpos ] =  ( in[ 10 + inpos]   & 1073741823 ) >>> ( 30  -  10 );
    out[ 10  + outpos ] |= ( in[ 11 + inpos]   & 1073741823  ) <<  10 ;
    out[ 11  + outpos ] =  ( in[ 11 + inpos]   & 1073741823 ) >>> ( 30  -  8 );
    out[ 11  + outpos ] |= ( in[ 12 + inpos]   & 1073741823  ) <<  8 ;
    out[ 12  + outpos ] =  ( in[ 12 + inpos]   & 1073741823 ) >>> ( 30  -  6 );
    out[ 12  + outpos ] |= ( in[ 13 + inpos]   & 1073741823  ) <<  6 ;
    out[ 13  + outpos ] =  ( in[ 13 + inpos]   & 1073741823 ) >>> ( 30  -  4 );
    out[ 13  + outpos ] |= ( in[ 14 + inpos]   & 1073741823  ) <<  4 ;
    out[ 14  + outpos ] =  ( in[ 14 + inpos]   & 1073741823 ) >>> ( 30  -  2 );
    out[ 14  + outpos ] |= ( in[ 15 + inpos]   & 1073741823  ) <<  2 ;
    out[ 15  + outpos ] = in[ 16 + inpos]   & 1073741823 ;
    out[ 15  + outpos ] |= ( in[ 17 + inpos]   & 1073741823  ) <<  30 ;
    out[ 16  + outpos ] =  ( in[ 17 + inpos]   & 1073741823 ) >>> ( 30  -  28 );
    out[ 16  + outpos ] |= ( in[ 18 + inpos]   & 1073741823  ) <<  28 ;
    out[ 17  + outpos ] =  ( in[ 18 + inpos]   & 1073741823 ) >>> ( 30  -  26 );
    out[ 17  + outpos ] |= ( in[ 19 + inpos]   & 1073741823  ) <<  26 ;
    out[ 18  + outpos ] =  ( in[ 19 + inpos]   & 1073741823 ) >>> ( 30  -  24 );
    out[ 18  + outpos ] |= ( in[ 20 + inpos]   & 1073741823  ) <<  24 ;
    out[ 19  + outpos ] =  ( in[ 20 + inpos]   & 1073741823 ) >>> ( 30  -  22 );
    out[ 19  + outpos ] |= ( in[ 21 + inpos]   & 1073741823  ) <<  22 ;
    out[ 20  + outpos ] =  ( in[ 21 + inpos]   & 1073741823 ) >>> ( 30  -  20 );
    out[ 20  + outpos ] |= ( in[ 22 + inpos]   & 1073741823  ) <<  20 ;
    out[ 21  + outpos ] =  ( in[ 22 + inpos]   & 1073741823 ) >>> ( 30  -  18 );
    out[ 21  + outpos ] |= ( in[ 23 + inpos]   & 1073741823  ) <<  18 ;
    out[ 22  + outpos ] =  ( in[ 23 + inpos]   & 1073741823 ) >>> ( 30  -  16 );
    out[ 22  + outpos ] |= ( in[ 24 + inpos]   & 1073741823  ) <<  16 ;
    out[ 23  + outpos ] =  ( in[ 24 + inpos]   & 1073741823 ) >>> ( 30  -  14 );
    out[ 23  + outpos ] |= ( in[ 25 + inpos]   & 1073741823  ) <<  14 ;
    out[ 24  + outpos ] =  ( in[ 25 + inpos]   & 1073741823 ) >>> ( 30  -  12 );
    out[ 24  + outpos ] |= ( in[ 26 + inpos]   & 1073741823  ) <<  12 ;
    out[ 25  + outpos ] =  ( in[ 26 + inpos]   & 1073741823 ) >>> ( 30  -  10 );
    out[ 25  + outpos ] |= ( in[ 27 + inpos]   & 1073741823  ) <<  10 ;
    out[ 26  + outpos ] =  ( in[ 27 + inpos]   & 1073741823 ) >>> ( 30  -  8 );
    out[ 26  + outpos ] |= ( in[ 28 + inpos]   & 1073741823  ) <<  8 ;
    out[ 27  + outpos ] =  ( in[ 28 + inpos]   & 1073741823 ) >>> ( 30  -  6 );
    out[ 27  + outpos ] |= ( in[ 29 + inpos]   & 1073741823  ) <<  6 ;
    out[ 28  + outpos ] =  ( in[ 29 + inpos]   & 1073741823 ) >>> ( 30  -  4 );
    out[ 28  + outpos ] |= ( in[ 30 + inpos]   & 1073741823  ) <<  4 ;
    out[ 29  + outpos ] =  ( in[ 30 + inpos]   & 1073741823 ) >>> ( 30  -  2 );
    out[ 29  + outpos ] |= ( in[ 31 + inpos]   & 1073741823  ) <<  2 ;
}




public static void fastpack31(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos ] = in[ 0 + inpos]   & 2147483647 ;
    out[ 0  + outpos ] |= ( in[ 1 + inpos]   & 2147483647  ) <<  31 ;
    out[ 1  + outpos ] =  ( in[ 1 + inpos]   & 2147483647 ) >>> ( 31  -  30 );
    out[ 1  + outpos ] |= ( in[ 2 + inpos]   & 2147483647  ) <<  30 ;
    out[ 2  + outpos ] =  ( in[ 2 + inpos]   & 2147483647 ) >>> ( 31  -  29 );
    out[ 2  + outpos ] |= ( in[ 3 + inpos]   & 2147483647  ) <<  29 ;
    out[ 3  + outpos ] =  ( in[ 3 + inpos]   & 2147483647 ) >>> ( 31  -  28 );
    out[ 3  + outpos ] |= ( in[ 4 + inpos]   & 2147483647  ) <<  28 ;
    out[ 4  + outpos ] =  ( in[ 4 + inpos]   & 2147483647 ) >>> ( 31  -  27 );
    out[ 4  + outpos ] |= ( in[ 5 + inpos]   & 2147483647  ) <<  27 ;
    out[ 5  + outpos ] =  ( in[ 5 + inpos]   & 2147483647 ) >>> ( 31  -  26 );
    out[ 5  + outpos ] |= ( in[ 6 + inpos]   & 2147483647  ) <<  26 ;
    out[ 6  + outpos ] =  ( in[ 6 + inpos]   & 2147483647 ) >>> ( 31  -  25 );
    out[ 6  + outpos ] |= ( in[ 7 + inpos]   & 2147483647  ) <<  25 ;
    out[ 7  + outpos ] =  ( in[ 7 + inpos]   & 2147483647 ) >>> ( 31  -  24 );
    out[ 7  + outpos ] |= ( in[ 8 + inpos]   & 2147483647  ) <<  24 ;
    out[ 8  + outpos ] =  ( in[ 8 + inpos]   & 2147483647 ) >>> ( 31  -  23 );
    out[ 8  + outpos ] |= ( in[ 9 + inpos]   & 2147483647  ) <<  23 ;
    out[ 9  + outpos ] =  ( in[ 9 + inpos]   & 2147483647 ) >>> ( 31  -  22 );
    out[ 9  + outpos ] |= ( in[ 10 + inpos]   & 2147483647  ) <<  22 ;
    out[ 10  + outpos ] =  ( in[ 10 + inpos]   & 2147483647 ) >>> ( 31  -  21 );
    out[ 10  + outpos ] |= ( in[ 11 + inpos]   & 2147483647  ) <<  21 ;
    out[ 11  + outpos ] =  ( in[ 11 + inpos]   & 2147483647 ) >>> ( 31  -  20 );
    out[ 11  + outpos ] |= ( in[ 12 + inpos]   & 2147483647  ) <<  20 ;
    out[ 12  + outpos ] =  ( in[ 12 + inpos]   & 2147483647 ) >>> ( 31  -  19 );
    out[ 12  + outpos ] |= ( in[ 13 + inpos]   & 2147483647  ) <<  19 ;
    out[ 13  + outpos ] =  ( in[ 13 + inpos]   & 2147483647 ) >>> ( 31  -  18 );
    out[ 13  + outpos ] |= ( in[ 14 + inpos]   & 2147483647  ) <<  18 ;
    out[ 14  + outpos ] =  ( in[ 14 + inpos]   & 2147483647 ) >>> ( 31  -  17 );
    out[ 14  + outpos ] |= ( in[ 15 + inpos]   & 2147483647  ) <<  17 ;
    out[ 15  + outpos ] =  ( in[ 15 + inpos]   & 2147483647 ) >>> ( 31  -  16 );
    out[ 15  + outpos ] |= ( in[ 16 + inpos]   & 2147483647  ) <<  16 ;
    out[ 16  + outpos ] =  ( in[ 16 + inpos]   & 2147483647 ) >>> ( 31  -  15 );
    out[ 16  + outpos ] |= ( in[ 17 + inpos]   & 2147483647  ) <<  15 ;
    out[ 17  + outpos ] =  ( in[ 17 + inpos]   & 2147483647 ) >>> ( 31  -  14 );
    out[ 17  + outpos ] |= ( in[ 18 + inpos]   & 2147483647  ) <<  14 ;
    out[ 18  + outpos ] =  ( in[ 18 + inpos]   & 2147483647 ) >>> ( 31  -  13 );
    out[ 18  + outpos ] |= ( in[ 19 + inpos]   & 2147483647  ) <<  13 ;
    out[ 19  + outpos ] =  ( in[ 19 + inpos]   & 2147483647 ) >>> ( 31  -  12 );
    out[ 19  + outpos ] |= ( in[ 20 + inpos]   & 2147483647  ) <<  12 ;
    out[ 20  + outpos ] =  ( in[ 20 + inpos]   & 2147483647 ) >>> ( 31  -  11 );
    out[ 20  + outpos ] |= ( in[ 21 + inpos]   & 2147483647  ) <<  11 ;
    out[ 21  + outpos ] =  ( in[ 21 + inpos]   & 2147483647 ) >>> ( 31  -  10 );
    out[ 21  + outpos ] |= ( in[ 22 + inpos]   & 2147483647  ) <<  10 ;
    out[ 22  + outpos ] =  ( in[ 22 + inpos]   & 2147483647 ) >>> ( 31  -  9 );
    out[ 22  + outpos ] |= ( in[ 23 + inpos]   & 2147483647  ) <<  9 ;
    out[ 23  + outpos ] =  ( in[ 23 + inpos]   & 2147483647 ) >>> ( 31  -  8 );
    out[ 23  + outpos ] |= ( in[ 24 + inpos]   & 2147483647  ) <<  8 ;
    out[ 24  + outpos ] =  ( in[ 24 + inpos]   & 2147483647 ) >>> ( 31  -  7 );
    out[ 24  + outpos ] |= ( in[ 25 + inpos]   & 2147483647  ) <<  7 ;
    out[ 25  + outpos ] =  ( in[ 25 + inpos]   & 2147483647 ) >>> ( 31  -  6 );
    out[ 25  + outpos ] |= ( in[ 26 + inpos]   & 2147483647  ) <<  6 ;
    out[ 26  + outpos ] =  ( in[ 26 + inpos]   & 2147483647 ) >>> ( 31  -  5 );
    out[ 26  + outpos ] |= ( in[ 27 + inpos]   & 2147483647  ) <<  5 ;
    out[ 27  + outpos ] =  ( in[ 27 + inpos]   & 2147483647 ) >>> ( 31  -  4 );
    out[ 27  + outpos ] |= ( in[ 28 + inpos]   & 2147483647  ) <<  4 ;
    out[ 28  + outpos ] =  ( in[ 28 + inpos]   & 2147483647 ) >>> ( 31  -  3 );
    out[ 28  + outpos ] |= ( in[ 29 + inpos]   & 2147483647  ) <<  3 ;
    out[ 29  + outpos ] =  ( in[ 29 + inpos]   & 2147483647 ) >>> ( 31  -  2 );
    out[ 29  + outpos ] |= ( in[ 30 + inpos]   & 2147483647  ) <<  2 ;
    out[ 30  + outpos ] =  ( in[ 30 + inpos]   & 2147483647 ) >>> ( 31  -  1 );
    out[ 30  + outpos ] |= ( in[ 31 + inpos]   & 2147483647  ) <<  1 ;
}




public static void fastunpack1(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 1 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  1  )   & 1 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  2  )   & 1 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  3  )   & 1 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  4  )   & 1 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  5  )   & 1 ;
    out[ 6  + outpos] = ( in[ 0 + inpos] >>>  6  )   & 1 ;
    out[ 7  + outpos] = ( in[ 0 + inpos] >>>  7  )   & 1 ;
    out[ 8  + outpos] = ( in[ 0 + inpos] >>>  8  )   & 1 ;
    out[ 9  + outpos] = ( in[ 0 + inpos] >>>  9  )   & 1 ;
    out[ 10  + outpos] = ( in[ 0 + inpos] >>>  10  )   & 1 ;
    out[ 11  + outpos] = ( in[ 0 + inpos] >>>  11  )   & 1 ;
    out[ 12  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 1 ;
    out[ 13  + outpos] = ( in[ 0 + inpos] >>>  13  )   & 1 ;
    out[ 14  + outpos] = ( in[ 0 + inpos] >>>  14  )   & 1 ;
    out[ 15  + outpos] = ( in[ 0 + inpos] >>>  15  )   & 1 ;
    out[ 16  + outpos] = ( in[ 0 + inpos] >>>  16  )   & 1 ;
    out[ 17  + outpos] = ( in[ 0 + inpos] >>>  17  )   & 1 ;
    out[ 18  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 1 ;
    out[ 19  + outpos] = ( in[ 0 + inpos] >>>  19  )   & 1 ;
    out[ 20  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 1 ;
    out[ 21  + outpos] = ( in[ 0 + inpos] >>>  21  )   & 1 ;
    out[ 22  + outpos] = ( in[ 0 + inpos] >>>  22  )   & 1 ;
    out[ 23  + outpos] = ( in[ 0 + inpos] >>>  23  )   & 1 ;
    out[ 24  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 1 ;
    out[ 25  + outpos] = ( in[ 0 + inpos] >>>  25  )   & 1 ;
    out[ 26  + outpos] = ( in[ 0 + inpos] >>>  26  )   & 1 ;
    out[ 27  + outpos] = ( in[ 0 + inpos] >>>  27  )   & 1 ;
    out[ 28  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 1 ;
    out[ 29  + outpos] = ( in[ 0 + inpos] >>>  29  )   & 1 ;
    out[ 30  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 1 ;
    out[ 31  + outpos] = ( in[ 0 + inpos] >>>  31  )   & 1 ;
}




public static void fastunpack2(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 3 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  2  )   & 3 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  4  )   & 3 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  6  )   & 3 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  8  )   & 3 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  10  )   & 3 ;
    out[ 6  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 3 ;
    out[ 7  + outpos] = ( in[ 0 + inpos] >>>  14  )   & 3 ;
    out[ 8  + outpos] = ( in[ 0 + inpos] >>>  16  )   & 3 ;
    out[ 9  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 3 ;
    out[ 10  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 3 ;
    out[ 11  + outpos] = ( in[ 0 + inpos] >>>  22  )   & 3 ;
    out[ 12  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 3 ;
    out[ 13  + outpos] = ( in[ 0 + inpos] >>>  26  )   & 3 ;
    out[ 14  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 3 ;
    out[ 15  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 3 ;
    out[ 16  + outpos] = ( in[ 1 + inpos] >>>  0  )   & 3 ;
    out[ 17  + outpos] = ( in[ 1 + inpos] >>>  2  )   & 3 ;
    out[ 18  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 3 ;
    out[ 19  + outpos] = ( in[ 1 + inpos] >>>  6  )   & 3 ;
    out[ 20  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 3 ;
    out[ 21  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 3 ;
    out[ 22  + outpos] = ( in[ 1 + inpos] >>>  12  )   & 3 ;
    out[ 23  + outpos] = ( in[ 1 + inpos] >>>  14  )   & 3 ;
    out[ 24  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 3 ;
    out[ 25  + outpos] = ( in[ 1 + inpos] >>>  18  )   & 3 ;
    out[ 26  + outpos] = ( in[ 1 + inpos] >>>  20  )   & 3 ;
    out[ 27  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 3 ;
    out[ 28  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 3 ;
    out[ 29  + outpos] = ( in[ 1 + inpos] >>>  26  )   & 3 ;
    out[ 30  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 3 ;
    out[ 31  + outpos] = ( in[ 1 + inpos] >>>  30  )   & 3 ;
}




public static void fastunpack3(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 7 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  3  )   & 7 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  6  )   & 7 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  9  )   & 7 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 7 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  15  )   & 7 ;
    out[ 6  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 7 ;
    out[ 7  + outpos] = ( in[ 0 + inpos] >>>  21  )   & 7 ;
    out[ 8  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 7 ;
    out[ 9  + outpos] = ( in[ 0 + inpos] >>>  27  )   & 7 ;
    out[ 10  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 7 ;
    out[ 10  + outpos] |= (in[ 1 + inpos]   & 1 )<<( 3 - 1 );
    out[ 11  + outpos] = ( in[ 1 + inpos] >>>  1  )   & 7 ;
    out[ 12  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 7 ;
    out[ 13  + outpos] = ( in[ 1 + inpos] >>>  7  )   & 7 ;
    out[ 14  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 7 ;
    out[ 15  + outpos] = ( in[ 1 + inpos] >>>  13  )   & 7 ;
    out[ 16  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 7 ;
    out[ 17  + outpos] = ( in[ 1 + inpos] >>>  19  )   & 7 ;
    out[ 18  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 7 ;
    out[ 19  + outpos] = ( in[ 1 + inpos] >>>  25  )   & 7 ;
    out[ 20  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 7 ;
    out[ 21  + outpos] = ( in[ 1 + inpos] >>>  31  )   & 7 ;
    out[ 21  + outpos] |= (in[ 2 + inpos]   & 3 )<<( 3 - 2 );
    out[ 22  + outpos] = ( in[ 2 + inpos] >>>  2  )   & 7 ;
    out[ 23  + outpos] = ( in[ 2 + inpos] >>>  5  )   & 7 ;
    out[ 24  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 7 ;
    out[ 25  + outpos] = ( in[ 2 + inpos] >>>  11  )   & 7 ;
    out[ 26  + outpos] = ( in[ 2 + inpos] >>>  14  )   & 7 ;
    out[ 27  + outpos] = ( in[ 2 + inpos] >>>  17  )   & 7 ;
    out[ 28  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 7 ;
    out[ 29  + outpos] = ( in[ 2 + inpos] >>>  23  )   & 7 ;
    out[ 30  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 7 ;
    out[ 31  + outpos] = ( in[ 2 + inpos] >>>  29  )   & 7 ;
}




public static void fastunpack4(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 15 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  4  )   & 15 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  8  )   & 15 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 15 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  16  )   & 15 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 15 ;
    out[ 6  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 15 ;
    out[ 7  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 15 ;
    out[ 8  + outpos] = ( in[ 1 + inpos] >>>  0  )   & 15 ;
    out[ 9  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 15 ;
    out[ 10  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 15 ;
    out[ 11  + outpos] = ( in[ 1 + inpos] >>>  12  )   & 15 ;
    out[ 12  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 15 ;
    out[ 13  + outpos] = ( in[ 1 + inpos] >>>  20  )   & 15 ;
    out[ 14  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 15 ;
    out[ 15  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 15 ;
    out[ 16  + outpos] = ( in[ 2 + inpos] >>>  0  )   & 15 ;
    out[ 17  + outpos] = ( in[ 2 + inpos] >>>  4  )   & 15 ;
    out[ 18  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 15 ;
    out[ 19  + outpos] = ( in[ 2 + inpos] >>>  12  )   & 15 ;
    out[ 20  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 15 ;
    out[ 21  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 15 ;
    out[ 22  + outpos] = ( in[ 2 + inpos] >>>  24  )   & 15 ;
    out[ 23  + outpos] = ( in[ 2 + inpos] >>>  28  )   & 15 ;
    out[ 24  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 15 ;
    out[ 25  + outpos] = ( in[ 3 + inpos] >>>  4  )   & 15 ;
    out[ 26  + outpos] = ( in[ 3 + inpos] >>>  8  )   & 15 ;
    out[ 27  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 15 ;
    out[ 28  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 15 ;
    out[ 29  + outpos] = ( in[ 3 + inpos] >>>  20  )   & 15 ;
    out[ 30  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 15 ;
    out[ 31  + outpos] = ( in[ 3 + inpos] >>>  28  )   & 15 ;
}




public static void fastunpack5(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 31 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  5  )   & 31 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  10  )   & 31 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  15  )   & 31 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 31 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  25  )   & 31 ;
    out[ 6  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 31 ;
    out[ 6  + outpos] |= (in[ 1 + inpos]   & 7 )<<( 5 - 3 );
    out[ 7  + outpos] = ( in[ 1 + inpos] >>>  3  )   & 31 ;
    out[ 8  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 31 ;
    out[ 9  + outpos] = ( in[ 1 + inpos] >>>  13  )   & 31 ;
    out[ 10  + outpos] = ( in[ 1 + inpos] >>>  18  )   & 31 ;
    out[ 11  + outpos] = ( in[ 1 + inpos] >>>  23  )   & 31 ;
    out[ 12  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 31 ;
    out[ 12  + outpos] |= (in[ 2 + inpos]   & 1 )<<( 5 - 1 );
    out[ 13  + outpos] = ( in[ 2 + inpos] >>>  1  )   & 31 ;
    out[ 14  + outpos] = ( in[ 2 + inpos] >>>  6  )   & 31 ;
    out[ 15  + outpos] = ( in[ 2 + inpos] >>>  11  )   & 31 ;
    out[ 16  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 31 ;
    out[ 17  + outpos] = ( in[ 2 + inpos] >>>  21  )   & 31 ;
    out[ 18  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 31 ;
    out[ 19  + outpos] = ( in[ 2 + inpos] >>>  31  )   & 31 ;
    out[ 19  + outpos] |= (in[ 3 + inpos]   & 15 )<<( 5 - 4 );
    out[ 20  + outpos] = ( in[ 3 + inpos] >>>  4  )   & 31 ;
    out[ 21  + outpos] = ( in[ 3 + inpos] >>>  9  )   & 31 ;
    out[ 22  + outpos] = ( in[ 3 + inpos] >>>  14  )   & 31 ;
    out[ 23  + outpos] = ( in[ 3 + inpos] >>>  19  )   & 31 ;
    out[ 24  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 31 ;
    out[ 25  + outpos] = ( in[ 3 + inpos] >>>  29  )   & 31 ;
    out[ 25  + outpos] |= (in[ 4 + inpos]   & 3 )<<( 5 - 2 );
    out[ 26  + outpos] = ( in[ 4 + inpos] >>>  2  )   & 31 ;
    out[ 27  + outpos] = ( in[ 4 + inpos] >>>  7  )   & 31 ;
    out[ 28  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 31 ;
    out[ 29  + outpos] = ( in[ 4 + inpos] >>>  17  )   & 31 ;
    out[ 30  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 31 ;
    out[ 31  + outpos] = ( in[ 4 + inpos] >>>  27  )   & 31 ;
}




public static void fastunpack6(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 63 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  6  )   & 63 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 63 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 63 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 63 ;
    out[ 5  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 63 ;
    out[ 5  + outpos] |= (in[ 1 + inpos]   & 15 )<<( 6 - 4 );
    out[ 6  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 63 ;
    out[ 7  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 63 ;
    out[ 8  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 63 ;
    out[ 9  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 63 ;
    out[ 10  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 63 ;
    out[ 10  + outpos] |= (in[ 2 + inpos]   & 3 )<<( 6 - 2 );
    out[ 11  + outpos] = ( in[ 2 + inpos] >>>  2  )   & 63 ;
    out[ 12  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 63 ;
    out[ 13  + outpos] = ( in[ 2 + inpos] >>>  14  )   & 63 ;
    out[ 14  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 63 ;
    out[ 15  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 63 ;
    out[ 16  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 63 ;
    out[ 17  + outpos] = ( in[ 3 + inpos] >>>  6  )   & 63 ;
    out[ 18  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 63 ;
    out[ 19  + outpos] = ( in[ 3 + inpos] >>>  18  )   & 63 ;
    out[ 20  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 63 ;
    out[ 21  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 63 ;
    out[ 21  + outpos] |= (in[ 4 + inpos]   & 15 )<<( 6 - 4 );
    out[ 22  + outpos] = ( in[ 4 + inpos] >>>  4  )   & 63 ;
    out[ 23  + outpos] = ( in[ 4 + inpos] >>>  10  )   & 63 ;
    out[ 24  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 63 ;
    out[ 25  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 63 ;
    out[ 26  + outpos] = ( in[ 4 + inpos] >>>  28  )   & 63 ;
    out[ 26  + outpos] |= (in[ 5 + inpos]   & 3 )<<( 6 - 2 );
    out[ 27  + outpos] = ( in[ 5 + inpos] >>>  2  )   & 63 ;
    out[ 28  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 63 ;
    out[ 29  + outpos] = ( in[ 5 + inpos] >>>  14  )   & 63 ;
    out[ 30  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 63 ;
    out[ 31  + outpos] = ( in[ 5 + inpos] >>>  26  )   & 63 ;
}




public static void fastunpack7(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 127 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  7  )   & 127 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  14  )   & 127 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  21  )   & 127 ;
    out[ 4  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 127 ;
    out[ 4  + outpos] |= (in[ 1 + inpos]   & 7 )<<( 7 - 3 );
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  3  )   & 127 ;
    out[ 6  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 127 ;
    out[ 7  + outpos] = ( in[ 1 + inpos] >>>  17  )   & 127 ;
    out[ 8  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 127 ;
    out[ 9  + outpos] = ( in[ 1 + inpos] >>>  31  )   & 127 ;
    out[ 9  + outpos] |= (in[ 2 + inpos]   & 63 )<<( 7 - 6 );
    out[ 10  + outpos] = ( in[ 2 + inpos] >>>  6  )   & 127 ;
    out[ 11  + outpos] = ( in[ 2 + inpos] >>>  13  )   & 127 ;
    out[ 12  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 127 ;
    out[ 13  + outpos] = ( in[ 2 + inpos] >>>  27  )   & 127 ;
    out[ 13  + outpos] |= (in[ 3 + inpos]   & 3 )<<( 7 - 2 );
    out[ 14  + outpos] = ( in[ 3 + inpos] >>>  2  )   & 127 ;
    out[ 15  + outpos] = ( in[ 3 + inpos] >>>  9  )   & 127 ;
    out[ 16  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 127 ;
    out[ 17  + outpos] = ( in[ 3 + inpos] >>>  23  )   & 127 ;
    out[ 18  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 127 ;
    out[ 18  + outpos] |= (in[ 4 + inpos]   & 31 )<<( 7 - 5 );
    out[ 19  + outpos] = ( in[ 4 + inpos] >>>  5  )   & 127 ;
    out[ 20  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 127 ;
    out[ 21  + outpos] = ( in[ 4 + inpos] >>>  19  )   & 127 ;
    out[ 22  + outpos] = ( in[ 4 + inpos] >>>  26  )   & 127 ;
    out[ 22  + outpos] |= (in[ 5 + inpos]   & 1 )<<( 7 - 1 );
    out[ 23  + outpos] = ( in[ 5 + inpos] >>>  1  )   & 127 ;
    out[ 24  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 127 ;
    out[ 25  + outpos] = ( in[ 5 + inpos] >>>  15  )   & 127 ;
    out[ 26  + outpos] = ( in[ 5 + inpos] >>>  22  )   & 127 ;
    out[ 27  + outpos] = ( in[ 5 + inpos] >>>  29  )   & 127 ;
    out[ 27  + outpos] |= (in[ 6 + inpos]   & 15 )<<( 7 - 4 );
    out[ 28  + outpos] = ( in[ 6 + inpos] >>>  4  )   & 127 ;
    out[ 29  + outpos] = ( in[ 6 + inpos] >>>  11  )   & 127 ;
    out[ 30  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 127 ;
    out[ 31  + outpos] = ( in[ 6 + inpos] >>>  25  )   & 127 ;
}




public static void fastunpack8(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 255 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  8  )   & 255 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  16  )   & 255 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 255 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  0  )   & 255 ;
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 255 ;
    out[ 6  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 255 ;
    out[ 7  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 255 ;
    out[ 8  + outpos] = ( in[ 2 + inpos] >>>  0  )   & 255 ;
    out[ 9  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 255 ;
    out[ 10  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 255 ;
    out[ 11  + outpos] = ( in[ 2 + inpos] >>>  24  )   & 255 ;
    out[ 12  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 255 ;
    out[ 13  + outpos] = ( in[ 3 + inpos] >>>  8  )   & 255 ;
    out[ 14  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 255 ;
    out[ 15  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 255 ;
    out[ 16  + outpos] = ( in[ 4 + inpos] >>>  0  )   & 255 ;
    out[ 17  + outpos] = ( in[ 4 + inpos] >>>  8  )   & 255 ;
    out[ 18  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 255 ;
    out[ 19  + outpos] = ( in[ 4 + inpos] >>>  24  )   & 255 ;
    out[ 20  + outpos] = ( in[ 5 + inpos] >>>  0  )   & 255 ;
    out[ 21  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 255 ;
    out[ 22  + outpos] = ( in[ 5 + inpos] >>>  16  )   & 255 ;
    out[ 23  + outpos] = ( in[ 5 + inpos] >>>  24  )   & 255 ;
    out[ 24  + outpos] = ( in[ 6 + inpos] >>>  0  )   & 255 ;
    out[ 25  + outpos] = ( in[ 6 + inpos] >>>  8  )   & 255 ;
    out[ 26  + outpos] = ( in[ 6 + inpos] >>>  16  )   & 255 ;
    out[ 27  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 255 ;
    out[ 28  + outpos] = ( in[ 7 + inpos] >>>  0  )   & 255 ;
    out[ 29  + outpos] = ( in[ 7 + inpos] >>>  8  )   & 255 ;
    out[ 30  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 255 ;
    out[ 31  + outpos] = ( in[ 7 + inpos] >>>  24  )   & 255 ;
}




public static void fastunpack9(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 511 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  9  )   & 511 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 511 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  27  )   & 511 ;
    out[ 3  + outpos] |= (in[ 1 + inpos]   & 15 )<<( 9 - 4 );
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 511 ;
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  13  )   & 511 ;
    out[ 6  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 511 ;
    out[ 7  + outpos] = ( in[ 1 + inpos] >>>  31  )   & 511 ;
    out[ 7  + outpos] |= (in[ 2 + inpos]   & 255 )<<( 9 - 8 );
    out[ 8  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 511 ;
    out[ 9  + outpos] = ( in[ 2 + inpos] >>>  17  )   & 511 ;
    out[ 10  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 511 ;
    out[ 10  + outpos] |= (in[ 3 + inpos]   & 7 )<<( 9 - 3 );
    out[ 11  + outpos] = ( in[ 3 + inpos] >>>  3  )   & 511 ;
    out[ 12  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 511 ;
    out[ 13  + outpos] = ( in[ 3 + inpos] >>>  21  )   & 511 ;
    out[ 14  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 511 ;
    out[ 14  + outpos] |= (in[ 4 + inpos]   & 127 )<<( 9 - 7 );
    out[ 15  + outpos] = ( in[ 4 + inpos] >>>  7  )   & 511 ;
    out[ 16  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 511 ;
    out[ 17  + outpos] = ( in[ 4 + inpos] >>>  25  )   & 511 ;
    out[ 17  + outpos] |= (in[ 5 + inpos]   & 3 )<<( 9 - 2 );
    out[ 18  + outpos] = ( in[ 5 + inpos] >>>  2  )   & 511 ;
    out[ 19  + outpos] = ( in[ 5 + inpos] >>>  11  )   & 511 ;
    out[ 20  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 511 ;
    out[ 21  + outpos] = ( in[ 5 + inpos] >>>  29  )   & 511 ;
    out[ 21  + outpos] |= (in[ 6 + inpos]   & 63 )<<( 9 - 6 );
    out[ 22  + outpos] = ( in[ 6 + inpos] >>>  6  )   & 511 ;
    out[ 23  + outpos] = ( in[ 6 + inpos] >>>  15  )   & 511 ;
    out[ 24  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 511 ;
    out[ 24  + outpos] |= (in[ 7 + inpos]   & 1 )<<( 9 - 1 );
    out[ 25  + outpos] = ( in[ 7 + inpos] >>>  1  )   & 511 ;
    out[ 26  + outpos] = ( in[ 7 + inpos] >>>  10  )   & 511 ;
    out[ 27  + outpos] = ( in[ 7 + inpos] >>>  19  )   & 511 ;
    out[ 28  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 511 ;
    out[ 28  + outpos] |= (in[ 8 + inpos]   & 31 )<<( 9 - 5 );
    out[ 29  + outpos] = ( in[ 8 + inpos] >>>  5  )   & 511 ;
    out[ 30  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 511 ;
    out[ 31  + outpos] = ( in[ 8 + inpos] >>>  23  )   & 511 ;
}




public static void fastunpack10(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 1023 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  10  )   & 1023 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 1023 ;
    out[ 3  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 1023 ;
    out[ 3  + outpos] |= (in[ 1 + inpos]   & 255 )<<( 10 - 8 );
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 1023 ;
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  18  )   & 1023 ;
    out[ 6  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 1023 ;
    out[ 6  + outpos] |= (in[ 2 + inpos]   & 63 )<<( 10 - 6 );
    out[ 7  + outpos] = ( in[ 2 + inpos] >>>  6  )   & 1023 ;
    out[ 8  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 1023 ;
    out[ 9  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 1023 ;
    out[ 9  + outpos] |= (in[ 3 + inpos]   & 15 )<<( 10 - 4 );
    out[ 10  + outpos] = ( in[ 3 + inpos] >>>  4  )   & 1023 ;
    out[ 11  + outpos] = ( in[ 3 + inpos] >>>  14  )   & 1023 ;
    out[ 12  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 1023 ;
    out[ 12  + outpos] |= (in[ 4 + inpos]   & 3 )<<( 10 - 2 );
    out[ 13  + outpos] = ( in[ 4 + inpos] >>>  2  )   & 1023 ;
    out[ 14  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 1023 ;
    out[ 15  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 1023 ;
    out[ 16  + outpos] = ( in[ 5 + inpos] >>>  0  )   & 1023 ;
    out[ 17  + outpos] = ( in[ 5 + inpos] >>>  10  )   & 1023 ;
    out[ 18  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 1023 ;
    out[ 19  + outpos] = ( in[ 5 + inpos] >>>  30  )   & 1023 ;
    out[ 19  + outpos] |= (in[ 6 + inpos]   & 255 )<<( 10 - 8 );
    out[ 20  + outpos] = ( in[ 6 + inpos] >>>  8  )   & 1023 ;
    out[ 21  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 1023 ;
    out[ 22  + outpos] = ( in[ 6 + inpos] >>>  28  )   & 1023 ;
    out[ 22  + outpos] |= (in[ 7 + inpos]   & 63 )<<( 10 - 6 );
    out[ 23  + outpos] = ( in[ 7 + inpos] >>>  6  )   & 1023 ;
    out[ 24  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 1023 ;
    out[ 25  + outpos] = ( in[ 7 + inpos] >>>  26  )   & 1023 ;
    out[ 25  + outpos] |= (in[ 8 + inpos]   & 15 )<<( 10 - 4 );
    out[ 26  + outpos] = ( in[ 8 + inpos] >>>  4  )   & 1023 ;
    out[ 27  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 1023 ;
    out[ 28  + outpos] = ( in[ 8 + inpos] >>>  24  )   & 1023 ;
    out[ 28  + outpos] |= (in[ 9 + inpos]   & 3 )<<( 10 - 2 );
    out[ 29  + outpos] = ( in[ 9 + inpos] >>>  2  )   & 1023 ;
    out[ 30  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 1023 ;
    out[ 31  + outpos] = ( in[ 9 + inpos] >>>  22  )   & 1023 ;
}




public static void fastunpack11(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 2047 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  11  )   & 2047 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  22  )   & 2047 ;
    out[ 2  + outpos] |= (in[ 1 + inpos]   & 1 )<<( 11 - 1 );
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  1  )   & 2047 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  12  )   & 2047 ;
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  23  )   & 2047 ;
    out[ 5  + outpos] |= (in[ 2 + inpos]   & 3 )<<( 11 - 2 );
    out[ 6  + outpos] = ( in[ 2 + inpos] >>>  2  )   & 2047 ;
    out[ 7  + outpos] = ( in[ 2 + inpos] >>>  13  )   & 2047 ;
    out[ 8  + outpos] = ( in[ 2 + inpos] >>>  24  )   & 2047 ;
    out[ 8  + outpos] |= (in[ 3 + inpos]   & 7 )<<( 11 - 3 );
    out[ 9  + outpos] = ( in[ 3 + inpos] >>>  3  )   & 2047 ;
    out[ 10  + outpos] = ( in[ 3 + inpos] >>>  14  )   & 2047 ;
    out[ 11  + outpos] = ( in[ 3 + inpos] >>>  25  )   & 2047 ;
    out[ 11  + outpos] |= (in[ 4 + inpos]   & 15 )<<( 11 - 4 );
    out[ 12  + outpos] = ( in[ 4 + inpos] >>>  4  )   & 2047 ;
    out[ 13  + outpos] = ( in[ 4 + inpos] >>>  15  )   & 2047 ;
    out[ 14  + outpos] = ( in[ 4 + inpos] >>>  26  )   & 2047 ;
    out[ 14  + outpos] |= (in[ 5 + inpos]   & 31 )<<( 11 - 5 );
    out[ 15  + outpos] = ( in[ 5 + inpos] >>>  5  )   & 2047 ;
    out[ 16  + outpos] = ( in[ 5 + inpos] >>>  16  )   & 2047 ;
    out[ 17  + outpos] = ( in[ 5 + inpos] >>>  27  )   & 2047 ;
    out[ 17  + outpos] |= (in[ 6 + inpos]   & 63 )<<( 11 - 6 );
    out[ 18  + outpos] = ( in[ 6 + inpos] >>>  6  )   & 2047 ;
    out[ 19  + outpos] = ( in[ 6 + inpos] >>>  17  )   & 2047 ;
    out[ 20  + outpos] = ( in[ 6 + inpos] >>>  28  )   & 2047 ;
    out[ 20  + outpos] |= (in[ 7 + inpos]   & 127 )<<( 11 - 7 );
    out[ 21  + outpos] = ( in[ 7 + inpos] >>>  7  )   & 2047 ;
    out[ 22  + outpos] = ( in[ 7 + inpos] >>>  18  )   & 2047 ;
    out[ 23  + outpos] = ( in[ 7 + inpos] >>>  29  )   & 2047 ;
    out[ 23  + outpos] |= (in[ 8 + inpos]   & 255 )<<( 11 - 8 );
    out[ 24  + outpos] = ( in[ 8 + inpos] >>>  8  )   & 2047 ;
    out[ 25  + outpos] = ( in[ 8 + inpos] >>>  19  )   & 2047 ;
    out[ 26  + outpos] = ( in[ 8 + inpos] >>>  30  )   & 2047 ;
    out[ 26  + outpos] |= (in[ 9 + inpos]   & 511 )<<( 11 - 9 );
    out[ 27  + outpos] = ( in[ 9 + inpos] >>>  9  )   & 2047 ;
    out[ 28  + outpos] = ( in[ 9 + inpos] >>>  20  )   & 2047 ;
    out[ 29  + outpos] = ( in[ 9 + inpos] >>>  31  )   & 2047 ;
    out[ 29  + outpos] |= (in[ 10 + inpos]   & 1023 )<<( 11 - 10 );
    out[ 30  + outpos] = ( in[ 10 + inpos] >>>  10  )   & 2047 ;
    out[ 31  + outpos] = ( in[ 10 + inpos] >>>  21  )   & 2047 ;
}




public static void fastunpack12(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 4095 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  12  )   & 4095 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 4095 ;
    out[ 2  + outpos] |= (in[ 1 + inpos]   & 15 )<<( 12 - 4 );
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 4095 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 4095 ;
    out[ 5  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 4095 ;
    out[ 5  + outpos] |= (in[ 2 + inpos]   & 255 )<<( 12 - 8 );
    out[ 6  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 4095 ;
    out[ 7  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 4095 ;
    out[ 8  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 4095 ;
    out[ 9  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 4095 ;
    out[ 10  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 4095 ;
    out[ 10  + outpos] |= (in[ 4 + inpos]   & 15 )<<( 12 - 4 );
    out[ 11  + outpos] = ( in[ 4 + inpos] >>>  4  )   & 4095 ;
    out[ 12  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 4095 ;
    out[ 13  + outpos] = ( in[ 4 + inpos] >>>  28  )   & 4095 ;
    out[ 13  + outpos] |= (in[ 5 + inpos]   & 255 )<<( 12 - 8 );
    out[ 14  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 4095 ;
    out[ 15  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 4095 ;
    out[ 16  + outpos] = ( in[ 6 + inpos] >>>  0  )   & 4095 ;
    out[ 17  + outpos] = ( in[ 6 + inpos] >>>  12  )   & 4095 ;
    out[ 18  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 4095 ;
    out[ 18  + outpos] |= (in[ 7 + inpos]   & 15 )<<( 12 - 4 );
    out[ 19  + outpos] = ( in[ 7 + inpos] >>>  4  )   & 4095 ;
    out[ 20  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 4095 ;
    out[ 21  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 4095 ;
    out[ 21  + outpos] |= (in[ 8 + inpos]   & 255 )<<( 12 - 8 );
    out[ 22  + outpos] = ( in[ 8 + inpos] >>>  8  )   & 4095 ;
    out[ 23  + outpos] = ( in[ 8 + inpos] >>>  20  )   & 4095 ;
    out[ 24  + outpos] = ( in[ 9 + inpos] >>>  0  )   & 4095 ;
    out[ 25  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 4095 ;
    out[ 26  + outpos] = ( in[ 9 + inpos] >>>  24  )   & 4095 ;
    out[ 26  + outpos] |= (in[ 10 + inpos]   & 15 )<<( 12 - 4 );
    out[ 27  + outpos] = ( in[ 10 + inpos] >>>  4  )   & 4095 ;
    out[ 28  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 4095 ;
    out[ 29  + outpos] = ( in[ 10 + inpos] >>>  28  )   & 4095 ;
    out[ 29  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 12 - 8 );
    out[ 30  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 4095 ;
    out[ 31  + outpos] = ( in[ 11 + inpos] >>>  20  )   & 4095 ;
}




public static void fastunpack13(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 8191 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  13  )   & 8191 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  26  )   & 8191 ;
    out[ 2  + outpos] |= (in[ 1 + inpos]   & 127 )<<( 13 - 7 );
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  7  )   & 8191 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  20  )   & 8191 ;
    out[ 4  + outpos] |= (in[ 2 + inpos]   & 1 )<<( 13 - 1 );
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  1  )   & 8191 ;
    out[ 6  + outpos] = ( in[ 2 + inpos] >>>  14  )   & 8191 ;
    out[ 7  + outpos] = ( in[ 2 + inpos] >>>  27  )   & 8191 ;
    out[ 7  + outpos] |= (in[ 3 + inpos]   & 255 )<<( 13 - 8 );
    out[ 8  + outpos] = ( in[ 3 + inpos] >>>  8  )   & 8191 ;
    out[ 9  + outpos] = ( in[ 3 + inpos] >>>  21  )   & 8191 ;
    out[ 9  + outpos] |= (in[ 4 + inpos]   & 3 )<<( 13 - 2 );
    out[ 10  + outpos] = ( in[ 4 + inpos] >>>  2  )   & 8191 ;
    out[ 11  + outpos] = ( in[ 4 + inpos] >>>  15  )   & 8191 ;
    out[ 12  + outpos] = ( in[ 4 + inpos] >>>  28  )   & 8191 ;
    out[ 12  + outpos] |= (in[ 5 + inpos]   & 511 )<<( 13 - 9 );
    out[ 13  + outpos] = ( in[ 5 + inpos] >>>  9  )   & 8191 ;
    out[ 14  + outpos] = ( in[ 5 + inpos] >>>  22  )   & 8191 ;
    out[ 14  + outpos] |= (in[ 6 + inpos]   & 7 )<<( 13 - 3 );
    out[ 15  + outpos] = ( in[ 6 + inpos] >>>  3  )   & 8191 ;
    out[ 16  + outpos] = ( in[ 6 + inpos] >>>  16  )   & 8191 ;
    out[ 17  + outpos] = ( in[ 6 + inpos] >>>  29  )   & 8191 ;
    out[ 17  + outpos] |= (in[ 7 + inpos]   & 1023 )<<( 13 - 10 );
    out[ 18  + outpos] = ( in[ 7 + inpos] >>>  10  )   & 8191 ;
    out[ 19  + outpos] = ( in[ 7 + inpos] >>>  23  )   & 8191 ;
    out[ 19  + outpos] |= (in[ 8 + inpos]   & 15 )<<( 13 - 4 );
    out[ 20  + outpos] = ( in[ 8 + inpos] >>>  4  )   & 8191 ;
    out[ 21  + outpos] = ( in[ 8 + inpos] >>>  17  )   & 8191 ;
    out[ 22  + outpos] = ( in[ 8 + inpos] >>>  30  )   & 8191 ;
    out[ 22  + outpos] |= (in[ 9 + inpos]   & 2047 )<<( 13 - 11 );
    out[ 23  + outpos] = ( in[ 9 + inpos] >>>  11  )   & 8191 ;
    out[ 24  + outpos] = ( in[ 9 + inpos] >>>  24  )   & 8191 ;
    out[ 24  + outpos] |= (in[ 10 + inpos]   & 31 )<<( 13 - 5 );
    out[ 25  + outpos] = ( in[ 10 + inpos] >>>  5  )   & 8191 ;
    out[ 26  + outpos] = ( in[ 10 + inpos] >>>  18  )   & 8191 ;
    out[ 27  + outpos] = ( in[ 10 + inpos] >>>  31  )   & 8191 ;
    out[ 27  + outpos] |= (in[ 11 + inpos]   & 4095 )<<( 13 - 12 );
    out[ 28  + outpos] = ( in[ 11 + inpos] >>>  12  )   & 8191 ;
    out[ 29  + outpos] = ( in[ 11 + inpos] >>>  25  )   & 8191 ;
    out[ 29  + outpos] |= (in[ 12 + inpos]   & 63 )<<( 13 - 6 );
    out[ 30  + outpos] = ( in[ 12 + inpos] >>>  6  )   & 8191 ;
    out[ 31  + outpos] = ( in[ 12 + inpos] >>>  19  )   & 8191 ;
}




public static void fastunpack14(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 16383 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  14  )   & 16383 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 16383 ;
    out[ 2  + outpos] |= (in[ 1 + inpos]   & 1023 )<<( 14 - 10 );
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 16383 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 16383 ;
    out[ 4  + outpos] |= (in[ 2 + inpos]   & 63 )<<( 14 - 6 );
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  6  )   & 16383 ;
    out[ 6  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 16383 ;
    out[ 6  + outpos] |= (in[ 3 + inpos]   & 3 )<<( 14 - 2 );
    out[ 7  + outpos] = ( in[ 3 + inpos] >>>  2  )   & 16383 ;
    out[ 8  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 16383 ;
    out[ 9  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 16383 ;
    out[ 9  + outpos] |= (in[ 4 + inpos]   & 4095 )<<( 14 - 12 );
    out[ 10  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 16383 ;
    out[ 11  + outpos] = ( in[ 4 + inpos] >>>  26  )   & 16383 ;
    out[ 11  + outpos] |= (in[ 5 + inpos]   & 255 )<<( 14 - 8 );
    out[ 12  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 16383 ;
    out[ 13  + outpos] = ( in[ 5 + inpos] >>>  22  )   & 16383 ;
    out[ 13  + outpos] |= (in[ 6 + inpos]   & 15 )<<( 14 - 4 );
    out[ 14  + outpos] = ( in[ 6 + inpos] >>>  4  )   & 16383 ;
    out[ 15  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 16383 ;
    out[ 16  + outpos] = ( in[ 7 + inpos] >>>  0  )   & 16383 ;
    out[ 17  + outpos] = ( in[ 7 + inpos] >>>  14  )   & 16383 ;
    out[ 18  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 16383 ;
    out[ 18  + outpos] |= (in[ 8 + inpos]   & 1023 )<<( 14 - 10 );
    out[ 19  + outpos] = ( in[ 8 + inpos] >>>  10  )   & 16383 ;
    out[ 20  + outpos] = ( in[ 8 + inpos] >>>  24  )   & 16383 ;
    out[ 20  + outpos] |= (in[ 9 + inpos]   & 63 )<<( 14 - 6 );
    out[ 21  + outpos] = ( in[ 9 + inpos] >>>  6  )   & 16383 ;
    out[ 22  + outpos] = ( in[ 9 + inpos] >>>  20  )   & 16383 ;
    out[ 22  + outpos] |= (in[ 10 + inpos]   & 3 )<<( 14 - 2 );
    out[ 23  + outpos] = ( in[ 10 + inpos] >>>  2  )   & 16383 ;
    out[ 24  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 16383 ;
    out[ 25  + outpos] = ( in[ 10 + inpos] >>>  30  )   & 16383 ;
    out[ 25  + outpos] |= (in[ 11 + inpos]   & 4095 )<<( 14 - 12 );
    out[ 26  + outpos] = ( in[ 11 + inpos] >>>  12  )   & 16383 ;
    out[ 27  + outpos] = ( in[ 11 + inpos] >>>  26  )   & 16383 ;
    out[ 27  + outpos] |= (in[ 12 + inpos]   & 255 )<<( 14 - 8 );
    out[ 28  + outpos] = ( in[ 12 + inpos] >>>  8  )   & 16383 ;
    out[ 29  + outpos] = ( in[ 12 + inpos] >>>  22  )   & 16383 ;
    out[ 29  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 14 - 4 );
    out[ 30  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 16383 ;
    out[ 31  + outpos] = ( in[ 13 + inpos] >>>  18  )   & 16383 ;
}




public static void fastunpack15(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 32767 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  15  )   & 32767 ;
    out[ 2  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 32767 ;
    out[ 2  + outpos] |= (in[ 1 + inpos]   & 8191 )<<( 15 - 13 );
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  13  )   & 32767 ;
    out[ 4  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 32767 ;
    out[ 4  + outpos] |= (in[ 2 + inpos]   & 2047 )<<( 15 - 11 );
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  11  )   & 32767 ;
    out[ 6  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 32767 ;
    out[ 6  + outpos] |= (in[ 3 + inpos]   & 511 )<<( 15 - 9 );
    out[ 7  + outpos] = ( in[ 3 + inpos] >>>  9  )   & 32767 ;
    out[ 8  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 32767 ;
    out[ 8  + outpos] |= (in[ 4 + inpos]   & 127 )<<( 15 - 7 );
    out[ 9  + outpos] = ( in[ 4 + inpos] >>>  7  )   & 32767 ;
    out[ 10  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 32767 ;
    out[ 10  + outpos] |= (in[ 5 + inpos]   & 31 )<<( 15 - 5 );
    out[ 11  + outpos] = ( in[ 5 + inpos] >>>  5  )   & 32767 ;
    out[ 12  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 32767 ;
    out[ 12  + outpos] |= (in[ 6 + inpos]   & 7 )<<( 15 - 3 );
    out[ 13  + outpos] = ( in[ 6 + inpos] >>>  3  )   & 32767 ;
    out[ 14  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 32767 ;
    out[ 14  + outpos] |= (in[ 7 + inpos]   & 1 )<<( 15 - 1 );
    out[ 15  + outpos] = ( in[ 7 + inpos] >>>  1  )   & 32767 ;
    out[ 16  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 32767 ;
    out[ 17  + outpos] = ( in[ 7 + inpos] >>>  31  )   & 32767 ;
    out[ 17  + outpos] |= (in[ 8 + inpos]   & 16383 )<<( 15 - 14 );
    out[ 18  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 32767 ;
    out[ 19  + outpos] = ( in[ 8 + inpos] >>>  29  )   & 32767 ;
    out[ 19  + outpos] |= (in[ 9 + inpos]   & 4095 )<<( 15 - 12 );
    out[ 20  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 32767 ;
    out[ 21  + outpos] = ( in[ 9 + inpos] >>>  27  )   & 32767 ;
    out[ 21  + outpos] |= (in[ 10 + inpos]   & 1023 )<<( 15 - 10 );
    out[ 22  + outpos] = ( in[ 10 + inpos] >>>  10  )   & 32767 ;
    out[ 23  + outpos] = ( in[ 10 + inpos] >>>  25  )   & 32767 ;
    out[ 23  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 15 - 8 );
    out[ 24  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 32767 ;
    out[ 25  + outpos] = ( in[ 11 + inpos] >>>  23  )   & 32767 ;
    out[ 25  + outpos] |= (in[ 12 + inpos]   & 63 )<<( 15 - 6 );
    out[ 26  + outpos] = ( in[ 12 + inpos] >>>  6  )   & 32767 ;
    out[ 27  + outpos] = ( in[ 12 + inpos] >>>  21  )   & 32767 ;
    out[ 27  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 15 - 4 );
    out[ 28  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 32767 ;
    out[ 29  + outpos] = ( in[ 13 + inpos] >>>  19  )   & 32767 ;
    out[ 29  + outpos] |= (in[ 14 + inpos]   & 3 )<<( 15 - 2 );
    out[ 30  + outpos] = ( in[ 14 + inpos] >>>  2  )   & 32767 ;
    out[ 31  + outpos] = ( in[ 14 + inpos] >>>  17  )   & 32767 ;
}



public static void fastunpack16(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 65535 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  16  )   & 65535 ;
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  0  )   & 65535 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 65535 ;
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  0  )   & 65535 ;
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 65535 ;
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 65535 ;
    out[ 7  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 65535 ;
    out[ 8  + outpos] = ( in[ 4 + inpos] >>>  0  )   & 65535 ;
    out[ 9  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 65535 ;
    out[ 10  + outpos] = ( in[ 5 + inpos] >>>  0  )   & 65535 ;
    out[ 11  + outpos] = ( in[ 5 + inpos] >>>  16  )   & 65535 ;
    out[ 12  + outpos] = ( in[ 6 + inpos] >>>  0  )   & 65535 ;
    out[ 13  + outpos] = ( in[ 6 + inpos] >>>  16  )   & 65535 ;
    out[ 14  + outpos] = ( in[ 7 + inpos] >>>  0  )   & 65535 ;
    out[ 15  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 65535 ;
    out[ 16  + outpos] = ( in[ 8 + inpos] >>>  0  )   & 65535 ;
    out[ 17  + outpos] = ( in[ 8 + inpos] >>>  16  )   & 65535 ;
    out[ 18  + outpos] = ( in[ 9 + inpos] >>>  0  )   & 65535 ;
    out[ 19  + outpos] = ( in[ 9 + inpos] >>>  16  )   & 65535 ;
    out[ 20  + outpos] = ( in[ 10 + inpos] >>>  0  )   & 65535 ;
    out[ 21  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 65535 ;
    out[ 22  + outpos] = ( in[ 11 + inpos] >>>  0  )   & 65535 ;
    out[ 23  + outpos] = ( in[ 11 + inpos] >>>  16  )   & 65535 ;
    out[ 24  + outpos] = ( in[ 12 + inpos] >>>  0  )   & 65535 ;
    out[ 25  + outpos] = ( in[ 12 + inpos] >>>  16  )   & 65535 ;
    out[ 26  + outpos] = ( in[ 13 + inpos] >>>  0  )   & 65535 ;
    out[ 27  + outpos] = ( in[ 13 + inpos] >>>  16  )   & 65535 ;
    out[ 28  + outpos] = ( in[ 14 + inpos] >>>  0  )   & 65535 ;
    out[ 29  + outpos] = ( in[ 14 + inpos] >>>  16  )   & 65535 ;
    out[ 30  + outpos] = ( in[ 15 + inpos] >>>  0  )   & 65535 ;
    out[ 31  + outpos] = ( in[ 15 + inpos] >>>  16  )   & 65535 ;
}




public static void fastunpack17(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 131071 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  17  )   & 131071 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 3 )<<( 17 - 2 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  2  )   & 131071 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  19  )   & 131071 ;
    out[ 3  + outpos] |= (in[ 2 + inpos]   & 15 )<<( 17 - 4 );
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  4  )   & 131071 ;
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  21  )   & 131071 ;
    out[ 5  + outpos] |= (in[ 3 + inpos]   & 63 )<<( 17 - 6 );
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  6  )   & 131071 ;
    out[ 7  + outpos] = ( in[ 3 + inpos] >>>  23  )   & 131071 ;
    out[ 7  + outpos] |= (in[ 4 + inpos]   & 255 )<<( 17 - 8 );
    out[ 8  + outpos] = ( in[ 4 + inpos] >>>  8  )   & 131071 ;
    out[ 9  + outpos] = ( in[ 4 + inpos] >>>  25  )   & 131071 ;
    out[ 9  + outpos] |= (in[ 5 + inpos]   & 1023 )<<( 17 - 10 );
    out[ 10  + outpos] = ( in[ 5 + inpos] >>>  10  )   & 131071 ;
    out[ 11  + outpos] = ( in[ 5 + inpos] >>>  27  )   & 131071 ;
    out[ 11  + outpos] |= (in[ 6 + inpos]   & 4095 )<<( 17 - 12 );
    out[ 12  + outpos] = ( in[ 6 + inpos] >>>  12  )   & 131071 ;
    out[ 13  + outpos] = ( in[ 6 + inpos] >>>  29  )   & 131071 ;
    out[ 13  + outpos] |= (in[ 7 + inpos]   & 16383 )<<( 17 - 14 );
    out[ 14  + outpos] = ( in[ 7 + inpos] >>>  14  )   & 131071 ;
    out[ 15  + outpos] = ( in[ 7 + inpos] >>>  31  )   & 131071 ;
    out[ 15  + outpos] |= (in[ 8 + inpos]   & 65535 )<<( 17 - 16 );
    out[ 16  + outpos] = ( in[ 8 + inpos] >>>  16  )   & 131071 ;
    out[ 16  + outpos] |= (in[ 9 + inpos]   & 1 )<<( 17 - 1 );
    out[ 17  + outpos] = ( in[ 9 + inpos] >>>  1  )   & 131071 ;
    out[ 18  + outpos] = ( in[ 9 + inpos] >>>  18  )   & 131071 ;
    out[ 18  + outpos] |= (in[ 10 + inpos]   & 7 )<<( 17 - 3 );
    out[ 19  + outpos] = ( in[ 10 + inpos] >>>  3  )   & 131071 ;
    out[ 20  + outpos] = ( in[ 10 + inpos] >>>  20  )   & 131071 ;
    out[ 20  + outpos] |= (in[ 11 + inpos]   & 31 )<<( 17 - 5 );
    out[ 21  + outpos] = ( in[ 11 + inpos] >>>  5  )   & 131071 ;
    out[ 22  + outpos] = ( in[ 11 + inpos] >>>  22  )   & 131071 ;
    out[ 22  + outpos] |= (in[ 12 + inpos]   & 127 )<<( 17 - 7 );
    out[ 23  + outpos] = ( in[ 12 + inpos] >>>  7  )   & 131071 ;
    out[ 24  + outpos] = ( in[ 12 + inpos] >>>  24  )   & 131071 ;
    out[ 24  + outpos] |= (in[ 13 + inpos]   & 511 )<<( 17 - 9 );
    out[ 25  + outpos] = ( in[ 13 + inpos] >>>  9  )   & 131071 ;
    out[ 26  + outpos] = ( in[ 13 + inpos] >>>  26  )   & 131071 ;
    out[ 26  + outpos] |= (in[ 14 + inpos]   & 2047 )<<( 17 - 11 );
    out[ 27  + outpos] = ( in[ 14 + inpos] >>>  11  )   & 131071 ;
    out[ 28  + outpos] = ( in[ 14 + inpos] >>>  28  )   & 131071 ;
    out[ 28  + outpos] |= (in[ 15 + inpos]   & 8191 )<<( 17 - 13 );
    out[ 29  + outpos] = ( in[ 15 + inpos] >>>  13  )   & 131071 ;
    out[ 30  + outpos] = ( in[ 15 + inpos] >>>  30  )   & 131071 ;
    out[ 30  + outpos] |= (in[ 16 + inpos]   & 32767 )<<( 17 - 15 );
    out[ 31  + outpos] = ( in[ 16 + inpos] >>>  15  )   & 131071 ;
}




public static void fastunpack18(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 262143 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  18  )   & 262143 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 15 )<<( 18 - 4 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  4  )   & 262143 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 262143 ;
    out[ 3  + outpos] |= (in[ 2 + inpos]   & 255 )<<( 18 - 8 );
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 262143 ;
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 262143 ;
    out[ 5  + outpos] |= (in[ 3 + inpos]   & 4095 )<<( 18 - 12 );
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 262143 ;
    out[ 7  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 262143 ;
    out[ 7  + outpos] |= (in[ 4 + inpos]   & 65535 )<<( 18 - 16 );
    out[ 8  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 262143 ;
    out[ 8  + outpos] |= (in[ 5 + inpos]   & 3 )<<( 18 - 2 );
    out[ 9  + outpos] = ( in[ 5 + inpos] >>>  2  )   & 262143 ;
    out[ 10  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 262143 ;
    out[ 10  + outpos] |= (in[ 6 + inpos]   & 63 )<<( 18 - 6 );
    out[ 11  + outpos] = ( in[ 6 + inpos] >>>  6  )   & 262143 ;
    out[ 12  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 262143 ;
    out[ 12  + outpos] |= (in[ 7 + inpos]   & 1023 )<<( 18 - 10 );
    out[ 13  + outpos] = ( in[ 7 + inpos] >>>  10  )   & 262143 ;
    out[ 14  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 262143 ;
    out[ 14  + outpos] |= (in[ 8 + inpos]   & 16383 )<<( 18 - 14 );
    out[ 15  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 262143 ;
    out[ 16  + outpos] = ( in[ 9 + inpos] >>>  0  )   & 262143 ;
    out[ 17  + outpos] = ( in[ 9 + inpos] >>>  18  )   & 262143 ;
    out[ 17  + outpos] |= (in[ 10 + inpos]   & 15 )<<( 18 - 4 );
    out[ 18  + outpos] = ( in[ 10 + inpos] >>>  4  )   & 262143 ;
    out[ 19  + outpos] = ( in[ 10 + inpos] >>>  22  )   & 262143 ;
    out[ 19  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 18 - 8 );
    out[ 20  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 262143 ;
    out[ 21  + outpos] = ( in[ 11 + inpos] >>>  26  )   & 262143 ;
    out[ 21  + outpos] |= (in[ 12 + inpos]   & 4095 )<<( 18 - 12 );
    out[ 22  + outpos] = ( in[ 12 + inpos] >>>  12  )   & 262143 ;
    out[ 23  + outpos] = ( in[ 12 + inpos] >>>  30  )   & 262143 ;
    out[ 23  + outpos] |= (in[ 13 + inpos]   & 65535 )<<( 18 - 16 );
    out[ 24  + outpos] = ( in[ 13 + inpos] >>>  16  )   & 262143 ;
    out[ 24  + outpos] |= (in[ 14 + inpos]   & 3 )<<( 18 - 2 );
    out[ 25  + outpos] = ( in[ 14 + inpos] >>>  2  )   & 262143 ;
    out[ 26  + outpos] = ( in[ 14 + inpos] >>>  20  )   & 262143 ;
    out[ 26  + outpos] |= (in[ 15 + inpos]   & 63 )<<( 18 - 6 );
    out[ 27  + outpos] = ( in[ 15 + inpos] >>>  6  )   & 262143 ;
    out[ 28  + outpos] = ( in[ 15 + inpos] >>>  24  )   & 262143 ;
    out[ 28  + outpos] |= (in[ 16 + inpos]   & 1023 )<<( 18 - 10 );
    out[ 29  + outpos] = ( in[ 16 + inpos] >>>  10  )   & 262143 ;
    out[ 30  + outpos] = ( in[ 16 + inpos] >>>  28  )   & 262143 ;
    out[ 30  + outpos] |= (in[ 17 + inpos]   & 16383 )<<( 18 - 14 );
    out[ 31  + outpos] = ( in[ 17 + inpos] >>>  14  )   & 262143 ;
}




public static void fastunpack19(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 524287 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  19  )   & 524287 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 63 )<<( 19 - 6 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  6  )   & 524287 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  25  )   & 524287 ;
    out[ 3  + outpos] |= (in[ 2 + inpos]   & 4095 )<<( 19 - 12 );
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  12  )   & 524287 ;
    out[ 5  + outpos] = ( in[ 2 + inpos] >>>  31  )   & 524287 ;
    out[ 5  + outpos] |= (in[ 3 + inpos]   & 262143 )<<( 19 - 18 );
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  18  )   & 524287 ;
    out[ 6  + outpos] |= (in[ 4 + inpos]   & 31 )<<( 19 - 5 );
    out[ 7  + outpos] = ( in[ 4 + inpos] >>>  5  )   & 524287 ;
    out[ 8  + outpos] = ( in[ 4 + inpos] >>>  24  )   & 524287 ;
    out[ 8  + outpos] |= (in[ 5 + inpos]   & 2047 )<<( 19 - 11 );
    out[ 9  + outpos] = ( in[ 5 + inpos] >>>  11  )   & 524287 ;
    out[ 10  + outpos] = ( in[ 5 + inpos] >>>  30  )   & 524287 ;
    out[ 10  + outpos] |= (in[ 6 + inpos]   & 131071 )<<( 19 - 17 );
    out[ 11  + outpos] = ( in[ 6 + inpos] >>>  17  )   & 524287 ;
    out[ 11  + outpos] |= (in[ 7 + inpos]   & 15 )<<( 19 - 4 );
    out[ 12  + outpos] = ( in[ 7 + inpos] >>>  4  )   & 524287 ;
    out[ 13  + outpos] = ( in[ 7 + inpos] >>>  23  )   & 524287 ;
    out[ 13  + outpos] |= (in[ 8 + inpos]   & 1023 )<<( 19 - 10 );
    out[ 14  + outpos] = ( in[ 8 + inpos] >>>  10  )   & 524287 ;
    out[ 15  + outpos] = ( in[ 8 + inpos] >>>  29  )   & 524287 ;
    out[ 15  + outpos] |= (in[ 9 + inpos]   & 65535 )<<( 19 - 16 );
    out[ 16  + outpos] = ( in[ 9 + inpos] >>>  16  )   & 524287 ;
    out[ 16  + outpos] |= (in[ 10 + inpos]   & 7 )<<( 19 - 3 );
    out[ 17  + outpos] = ( in[ 10 + inpos] >>>  3  )   & 524287 ;
    out[ 18  + outpos] = ( in[ 10 + inpos] >>>  22  )   & 524287 ;
    out[ 18  + outpos] |= (in[ 11 + inpos]   & 511 )<<( 19 - 9 );
    out[ 19  + outpos] = ( in[ 11 + inpos] >>>  9  )   & 524287 ;
    out[ 20  + outpos] = ( in[ 11 + inpos] >>>  28  )   & 524287 ;
    out[ 20  + outpos] |= (in[ 12 + inpos]   & 32767 )<<( 19 - 15 );
    out[ 21  + outpos] = ( in[ 12 + inpos] >>>  15  )   & 524287 ;
    out[ 21  + outpos] |= (in[ 13 + inpos]   & 3 )<<( 19 - 2 );
    out[ 22  + outpos] = ( in[ 13 + inpos] >>>  2  )   & 524287 ;
    out[ 23  + outpos] = ( in[ 13 + inpos] >>>  21  )   & 524287 ;
    out[ 23  + outpos] |= (in[ 14 + inpos]   & 255 )<<( 19 - 8 );
    out[ 24  + outpos] = ( in[ 14 + inpos] >>>  8  )   & 524287 ;
    out[ 25  + outpos] = ( in[ 14 + inpos] >>>  27  )   & 524287 ;
    out[ 25  + outpos] |= (in[ 15 + inpos]   & 16383 )<<( 19 - 14 );
    out[ 26  + outpos] = ( in[ 15 + inpos] >>>  14  )   & 524287 ;
    out[ 26  + outpos] |= (in[ 16 + inpos]   & 1 )<<( 19 - 1 );
    out[ 27  + outpos] = ( in[ 16 + inpos] >>>  1  )   & 524287 ;
    out[ 28  + outpos] = ( in[ 16 + inpos] >>>  20  )   & 524287 ;
    out[ 28  + outpos] |= (in[ 17 + inpos]   & 127 )<<( 19 - 7 );
    out[ 29  + outpos] = ( in[ 17 + inpos] >>>  7  )   & 524287 ;
    out[ 30  + outpos] = ( in[ 17 + inpos] >>>  26  )   & 524287 ;
    out[ 30  + outpos] |= (in[ 18 + inpos]   & 8191 )<<( 19 - 13 );
    out[ 31  + outpos] = ( in[ 18 + inpos] >>>  13  )   & 524287 ;
}




public static void fastunpack20(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 1048575 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  20  )   & 1048575 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 255 )<<( 20 - 8 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  8  )   & 1048575 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 1048575 ;
    out[ 3  + outpos] |= (in[ 2 + inpos]   & 65535 )<<( 20 - 16 );
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  16  )   & 1048575 ;
    out[ 4  + outpos] |= (in[ 3 + inpos]   & 15 )<<( 20 - 4 );
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  4  )   & 1048575 ;
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 1048575 ;
    out[ 6  + outpos] |= (in[ 4 + inpos]   & 4095 )<<( 20 - 12 );
    out[ 7  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 1048575 ;
    out[ 8  + outpos] = ( in[ 5 + inpos] >>>  0  )   & 1048575 ;
    out[ 9  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 1048575 ;
    out[ 9  + outpos] |= (in[ 6 + inpos]   & 255 )<<( 20 - 8 );
    out[ 10  + outpos] = ( in[ 6 + inpos] >>>  8  )   & 1048575 ;
    out[ 11  + outpos] = ( in[ 6 + inpos] >>>  28  )   & 1048575 ;
    out[ 11  + outpos] |= (in[ 7 + inpos]   & 65535 )<<( 20 - 16 );
    out[ 12  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 1048575 ;
    out[ 12  + outpos] |= (in[ 8 + inpos]   & 15 )<<( 20 - 4 );
    out[ 13  + outpos] = ( in[ 8 + inpos] >>>  4  )   & 1048575 ;
    out[ 14  + outpos] = ( in[ 8 + inpos] >>>  24  )   & 1048575 ;
    out[ 14  + outpos] |= (in[ 9 + inpos]   & 4095 )<<( 20 - 12 );
    out[ 15  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 1048575 ;
    out[ 16  + outpos] = ( in[ 10 + inpos] >>>  0  )   & 1048575 ;
    out[ 17  + outpos] = ( in[ 10 + inpos] >>>  20  )   & 1048575 ;
    out[ 17  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 20 - 8 );
    out[ 18  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 1048575 ;
    out[ 19  + outpos] = ( in[ 11 + inpos] >>>  28  )   & 1048575 ;
    out[ 19  + outpos] |= (in[ 12 + inpos]   & 65535 )<<( 20 - 16 );
    out[ 20  + outpos] = ( in[ 12 + inpos] >>>  16  )   & 1048575 ;
    out[ 20  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 20 - 4 );
    out[ 21  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 1048575 ;
    out[ 22  + outpos] = ( in[ 13 + inpos] >>>  24  )   & 1048575 ;
    out[ 22  + outpos] |= (in[ 14 + inpos]   & 4095 )<<( 20 - 12 );
    out[ 23  + outpos] = ( in[ 14 + inpos] >>>  12  )   & 1048575 ;
    out[ 24  + outpos] = ( in[ 15 + inpos] >>>  0  )   & 1048575 ;
    out[ 25  + outpos] = ( in[ 15 + inpos] >>>  20  )   & 1048575 ;
    out[ 25  + outpos] |= (in[ 16 + inpos]   & 255 )<<( 20 - 8 );
    out[ 26  + outpos] = ( in[ 16 + inpos] >>>  8  )   & 1048575 ;
    out[ 27  + outpos] = ( in[ 16 + inpos] >>>  28  )   & 1048575 ;
    out[ 27  + outpos] |= (in[ 17 + inpos]   & 65535 )<<( 20 - 16 );
    out[ 28  + outpos] = ( in[ 17 + inpos] >>>  16  )   & 1048575 ;
    out[ 28  + outpos] |= (in[ 18 + inpos]   & 15 )<<( 20 - 4 );
    out[ 29  + outpos] = ( in[ 18 + inpos] >>>  4  )   & 1048575 ;
    out[ 30  + outpos] = ( in[ 18 + inpos] >>>  24  )   & 1048575 ;
    out[ 30  + outpos] |= (in[ 19 + inpos]   & 4095 )<<( 20 - 12 );
    out[ 31  + outpos] = ( in[ 19 + inpos] >>>  12  )   & 1048575 ;
}




public static void fastunpack21(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 2097151 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  21  )   & 2097151 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 1023 )<<( 21 - 10 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  10  )   & 2097151 ;
    out[ 3  + outpos] = ( in[ 1 + inpos] >>>  31  )   & 2097151 ;
    out[ 3  + outpos] |= (in[ 2 + inpos]   & 1048575 )<<( 21 - 20 );
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 2097151 ;
    out[ 4  + outpos] |= (in[ 3 + inpos]   & 511 )<<( 21 - 9 );
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  9  )   & 2097151 ;
    out[ 6  + outpos] = ( in[ 3 + inpos] >>>  30  )   & 2097151 ;
    out[ 6  + outpos] |= (in[ 4 + inpos]   & 524287 )<<( 21 - 19 );
    out[ 7  + outpos] = ( in[ 4 + inpos] >>>  19  )   & 2097151 ;
    out[ 7  + outpos] |= (in[ 5 + inpos]   & 255 )<<( 21 - 8 );
    out[ 8  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 2097151 ;
    out[ 9  + outpos] = ( in[ 5 + inpos] >>>  29  )   & 2097151 ;
    out[ 9  + outpos] |= (in[ 6 + inpos]   & 262143 )<<( 21 - 18 );
    out[ 10  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 2097151 ;
    out[ 10  + outpos] |= (in[ 7 + inpos]   & 127 )<<( 21 - 7 );
    out[ 11  + outpos] = ( in[ 7 + inpos] >>>  7  )   & 2097151 ;
    out[ 12  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 2097151 ;
    out[ 12  + outpos] |= (in[ 8 + inpos]   & 131071 )<<( 21 - 17 );
    out[ 13  + outpos] = ( in[ 8 + inpos] >>>  17  )   & 2097151 ;
    out[ 13  + outpos] |= (in[ 9 + inpos]   & 63 )<<( 21 - 6 );
    out[ 14  + outpos] = ( in[ 9 + inpos] >>>  6  )   & 2097151 ;
    out[ 15  + outpos] = ( in[ 9 + inpos] >>>  27  )   & 2097151 ;
    out[ 15  + outpos] |= (in[ 10 + inpos]   & 65535 )<<( 21 - 16 );
    out[ 16  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 2097151 ;
    out[ 16  + outpos] |= (in[ 11 + inpos]   & 31 )<<( 21 - 5 );
    out[ 17  + outpos] = ( in[ 11 + inpos] >>>  5  )   & 2097151 ;
    out[ 18  + outpos] = ( in[ 11 + inpos] >>>  26  )   & 2097151 ;
    out[ 18  + outpos] |= (in[ 12 + inpos]   & 32767 )<<( 21 - 15 );
    out[ 19  + outpos] = ( in[ 12 + inpos] >>>  15  )   & 2097151 ;
    out[ 19  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 21 - 4 );
    out[ 20  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 2097151 ;
    out[ 21  + outpos] = ( in[ 13 + inpos] >>>  25  )   & 2097151 ;
    out[ 21  + outpos] |= (in[ 14 + inpos]   & 16383 )<<( 21 - 14 );
    out[ 22  + outpos] = ( in[ 14 + inpos] >>>  14  )   & 2097151 ;
    out[ 22  + outpos] |= (in[ 15 + inpos]   & 7 )<<( 21 - 3 );
    out[ 23  + outpos] = ( in[ 15 + inpos] >>>  3  )   & 2097151 ;
    out[ 24  + outpos] = ( in[ 15 + inpos] >>>  24  )   & 2097151 ;
    out[ 24  + outpos] |= (in[ 16 + inpos]   & 8191 )<<( 21 - 13 );
    out[ 25  + outpos] = ( in[ 16 + inpos] >>>  13  )   & 2097151 ;
    out[ 25  + outpos] |= (in[ 17 + inpos]   & 3 )<<( 21 - 2 );
    out[ 26  + outpos] = ( in[ 17 + inpos] >>>  2  )   & 2097151 ;
    out[ 27  + outpos] = ( in[ 17 + inpos] >>>  23  )   & 2097151 ;
    out[ 27  + outpos] |= (in[ 18 + inpos]   & 4095 )<<( 21 - 12 );
    out[ 28  + outpos] = ( in[ 18 + inpos] >>>  12  )   & 2097151 ;
    out[ 28  + outpos] |= (in[ 19 + inpos]   & 1 )<<( 21 - 1 );
    out[ 29  + outpos] = ( in[ 19 + inpos] >>>  1  )   & 2097151 ;
    out[ 30  + outpos] = ( in[ 19 + inpos] >>>  22  )   & 2097151 ;
    out[ 30  + outpos] |= (in[ 20 + inpos]   & 2047 )<<( 21 - 11 );
    out[ 31  + outpos] = ( in[ 20 + inpos] >>>  11  )   & 2097151 ;
}




public static void fastunpack22(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 4194303 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  22  )   & 4194303 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 4095 )<<( 22 - 12 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  12  )   & 4194303 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 3 )<<( 22 - 2 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  2  )   & 4194303 ;
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  24  )   & 4194303 ;
    out[ 4  + outpos] |= (in[ 3 + inpos]   & 16383 )<<( 22 - 14 );
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  14  )   & 4194303 ;
    out[ 5  + outpos] |= (in[ 4 + inpos]   & 15 )<<( 22 - 4 );
    out[ 6  + outpos] = ( in[ 4 + inpos] >>>  4  )   & 4194303 ;
    out[ 7  + outpos] = ( in[ 4 + inpos] >>>  26  )   & 4194303 ;
    out[ 7  + outpos] |= (in[ 5 + inpos]   & 65535 )<<( 22 - 16 );
    out[ 8  + outpos] = ( in[ 5 + inpos] >>>  16  )   & 4194303 ;
    out[ 8  + outpos] |= (in[ 6 + inpos]   & 63 )<<( 22 - 6 );
    out[ 9  + outpos] = ( in[ 6 + inpos] >>>  6  )   & 4194303 ;
    out[ 10  + outpos] = ( in[ 6 + inpos] >>>  28  )   & 4194303 ;
    out[ 10  + outpos] |= (in[ 7 + inpos]   & 262143 )<<( 22 - 18 );
    out[ 11  + outpos] = ( in[ 7 + inpos] >>>  18  )   & 4194303 ;
    out[ 11  + outpos] |= (in[ 8 + inpos]   & 255 )<<( 22 - 8 );
    out[ 12  + outpos] = ( in[ 8 + inpos] >>>  8  )   & 4194303 ;
    out[ 13  + outpos] = ( in[ 8 + inpos] >>>  30  )   & 4194303 ;
    out[ 13  + outpos] |= (in[ 9 + inpos]   & 1048575 )<<( 22 - 20 );
    out[ 14  + outpos] = ( in[ 9 + inpos] >>>  20  )   & 4194303 ;
    out[ 14  + outpos] |= (in[ 10 + inpos]   & 1023 )<<( 22 - 10 );
    out[ 15  + outpos] = ( in[ 10 + inpos] >>>  10  )   & 4194303 ;
    out[ 16  + outpos] = ( in[ 11 + inpos] >>>  0  )   & 4194303 ;
    out[ 17  + outpos] = ( in[ 11 + inpos] >>>  22  )   & 4194303 ;
    out[ 17  + outpos] |= (in[ 12 + inpos]   & 4095 )<<( 22 - 12 );
    out[ 18  + outpos] = ( in[ 12 + inpos] >>>  12  )   & 4194303 ;
    out[ 18  + outpos] |= (in[ 13 + inpos]   & 3 )<<( 22 - 2 );
    out[ 19  + outpos] = ( in[ 13 + inpos] >>>  2  )   & 4194303 ;
    out[ 20  + outpos] = ( in[ 13 + inpos] >>>  24  )   & 4194303 ;
    out[ 20  + outpos] |= (in[ 14 + inpos]   & 16383 )<<( 22 - 14 );
    out[ 21  + outpos] = ( in[ 14 + inpos] >>>  14  )   & 4194303 ;
    out[ 21  + outpos] |= (in[ 15 + inpos]   & 15 )<<( 22 - 4 );
    out[ 22  + outpos] = ( in[ 15 + inpos] >>>  4  )   & 4194303 ;
    out[ 23  + outpos] = ( in[ 15 + inpos] >>>  26  )   & 4194303 ;
    out[ 23  + outpos] |= (in[ 16 + inpos]   & 65535 )<<( 22 - 16 );
    out[ 24  + outpos] = ( in[ 16 + inpos] >>>  16  )   & 4194303 ;
    out[ 24  + outpos] |= (in[ 17 + inpos]   & 63 )<<( 22 - 6 );
    out[ 25  + outpos] = ( in[ 17 + inpos] >>>  6  )   & 4194303 ;
    out[ 26  + outpos] = ( in[ 17 + inpos] >>>  28  )   & 4194303 ;
    out[ 26  + outpos] |= (in[ 18 + inpos]   & 262143 )<<( 22 - 18 );
    out[ 27  + outpos] = ( in[ 18 + inpos] >>>  18  )   & 4194303 ;
    out[ 27  + outpos] |= (in[ 19 + inpos]   & 255 )<<( 22 - 8 );
    out[ 28  + outpos] = ( in[ 19 + inpos] >>>  8  )   & 4194303 ;
    out[ 29  + outpos] = ( in[ 19 + inpos] >>>  30  )   & 4194303 ;
    out[ 29  + outpos] |= (in[ 20 + inpos]   & 1048575 )<<( 22 - 20 );
    out[ 30  + outpos] = ( in[ 20 + inpos] >>>  20  )   & 4194303 ;
    out[ 30  + outpos] |= (in[ 21 + inpos]   & 1023 )<<( 22 - 10 );
    out[ 31  + outpos] = ( in[ 21 + inpos] >>>  10  )   & 4194303 ;
}




public static void fastunpack23(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 8388607 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  23  )   & 8388607 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 16383 )<<( 23 - 14 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  14  )   & 8388607 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 31 )<<( 23 - 5 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  5  )   & 8388607 ;
    out[ 4  + outpos] = ( in[ 2 + inpos] >>>  28  )   & 8388607 ;
    out[ 4  + outpos] |= (in[ 3 + inpos]   & 524287 )<<( 23 - 19 );
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  19  )   & 8388607 ;
    out[ 5  + outpos] |= (in[ 4 + inpos]   & 1023 )<<( 23 - 10 );
    out[ 6  + outpos] = ( in[ 4 + inpos] >>>  10  )   & 8388607 ;
    out[ 6  + outpos] |= (in[ 5 + inpos]   & 1 )<<( 23 - 1 );
    out[ 7  + outpos] = ( in[ 5 + inpos] >>>  1  )   & 8388607 ;
    out[ 8  + outpos] = ( in[ 5 + inpos] >>>  24  )   & 8388607 ;
    out[ 8  + outpos] |= (in[ 6 + inpos]   & 32767 )<<( 23 - 15 );
    out[ 9  + outpos] = ( in[ 6 + inpos] >>>  15  )   & 8388607 ;
    out[ 9  + outpos] |= (in[ 7 + inpos]   & 63 )<<( 23 - 6 );
    out[ 10  + outpos] = ( in[ 7 + inpos] >>>  6  )   & 8388607 ;
    out[ 11  + outpos] = ( in[ 7 + inpos] >>>  29  )   & 8388607 ;
    out[ 11  + outpos] |= (in[ 8 + inpos]   & 1048575 )<<( 23 - 20 );
    out[ 12  + outpos] = ( in[ 8 + inpos] >>>  20  )   & 8388607 ;
    out[ 12  + outpos] |= (in[ 9 + inpos]   & 2047 )<<( 23 - 11 );
    out[ 13  + outpos] = ( in[ 9 + inpos] >>>  11  )   & 8388607 ;
    out[ 13  + outpos] |= (in[ 10 + inpos]   & 3 )<<( 23 - 2 );
    out[ 14  + outpos] = ( in[ 10 + inpos] >>>  2  )   & 8388607 ;
    out[ 15  + outpos] = ( in[ 10 + inpos] >>>  25  )   & 8388607 ;
    out[ 15  + outpos] |= (in[ 11 + inpos]   & 65535 )<<( 23 - 16 );
    out[ 16  + outpos] = ( in[ 11 + inpos] >>>  16  )   & 8388607 ;
    out[ 16  + outpos] |= (in[ 12 + inpos]   & 127 )<<( 23 - 7 );
    out[ 17  + outpos] = ( in[ 12 + inpos] >>>  7  )   & 8388607 ;
    out[ 18  + outpos] = ( in[ 12 + inpos] >>>  30  )   & 8388607 ;
    out[ 18  + outpos] |= (in[ 13 + inpos]   & 2097151 )<<( 23 - 21 );
    out[ 19  + outpos] = ( in[ 13 + inpos] >>>  21  )   & 8388607 ;
    out[ 19  + outpos] |= (in[ 14 + inpos]   & 4095 )<<( 23 - 12 );
    out[ 20  + outpos] = ( in[ 14 + inpos] >>>  12  )   & 8388607 ;
    out[ 20  + outpos] |= (in[ 15 + inpos]   & 7 )<<( 23 - 3 );
    out[ 21  + outpos] = ( in[ 15 + inpos] >>>  3  )   & 8388607 ;
    out[ 22  + outpos] = ( in[ 15 + inpos] >>>  26  )   & 8388607 ;
    out[ 22  + outpos] |= (in[ 16 + inpos]   & 131071 )<<( 23 - 17 );
    out[ 23  + outpos] = ( in[ 16 + inpos] >>>  17  )   & 8388607 ;
    out[ 23  + outpos] |= (in[ 17 + inpos]   & 255 )<<( 23 - 8 );
    out[ 24  + outpos] = ( in[ 17 + inpos] >>>  8  )   & 8388607 ;
    out[ 25  + outpos] = ( in[ 17 + inpos] >>>  31  )   & 8388607 ;
    out[ 25  + outpos] |= (in[ 18 + inpos]   & 4194303 )<<( 23 - 22 );
    out[ 26  + outpos] = ( in[ 18 + inpos] >>>  22  )   & 8388607 ;
    out[ 26  + outpos] |= (in[ 19 + inpos]   & 8191 )<<( 23 - 13 );
    out[ 27  + outpos] = ( in[ 19 + inpos] >>>  13  )   & 8388607 ;
    out[ 27  + outpos] |= (in[ 20 + inpos]   & 15 )<<( 23 - 4 );
    out[ 28  + outpos] = ( in[ 20 + inpos] >>>  4  )   & 8388607 ;
    out[ 29  + outpos] = ( in[ 20 + inpos] >>>  27  )   & 8388607 ;
    out[ 29  + outpos] |= (in[ 21 + inpos]   & 262143 )<<( 23 - 18 );
    out[ 30  + outpos] = ( in[ 21 + inpos] >>>  18  )   & 8388607 ;
    out[ 30  + outpos] |= (in[ 22 + inpos]   & 511 )<<( 23 - 9 );
    out[ 31  + outpos] = ( in[ 22 + inpos] >>>  9  )   & 8388607 ;
}




public static void fastunpack24(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 16777215 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  24  )   & 16777215 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  16  )   & 16777215 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 255 )<<( 24 - 8 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  8  )   & 16777215 ;
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  0  )   & 16777215 ;
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 16777215 ;
    out[ 5  + outpos] |= (in[ 4 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 6  + outpos] = ( in[ 4 + inpos] >>>  16  )   & 16777215 ;
    out[ 6  + outpos] |= (in[ 5 + inpos]   & 255 )<<( 24 - 8 );
    out[ 7  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 16777215 ;
    out[ 8  + outpos] = ( in[ 6 + inpos] >>>  0  )   & 16777215 ;
    out[ 9  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 16777215 ;
    out[ 9  + outpos] |= (in[ 7 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 10  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 16777215 ;
    out[ 10  + outpos] |= (in[ 8 + inpos]   & 255 )<<( 24 - 8 );
    out[ 11  + outpos] = ( in[ 8 + inpos] >>>  8  )   & 16777215 ;
    out[ 12  + outpos] = ( in[ 9 + inpos] >>>  0  )   & 16777215 ;
    out[ 13  + outpos] = ( in[ 9 + inpos] >>>  24  )   & 16777215 ;
    out[ 13  + outpos] |= (in[ 10 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 14  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 16777215 ;
    out[ 14  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 24 - 8 );
    out[ 15  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 16777215 ;
    out[ 16  + outpos] = ( in[ 12 + inpos] >>>  0  )   & 16777215 ;
    out[ 17  + outpos] = ( in[ 12 + inpos] >>>  24  )   & 16777215 ;
    out[ 17  + outpos] |= (in[ 13 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 18  + outpos] = ( in[ 13 + inpos] >>>  16  )   & 16777215 ;
    out[ 18  + outpos] |= (in[ 14 + inpos]   & 255 )<<( 24 - 8 );
    out[ 19  + outpos] = ( in[ 14 + inpos] >>>  8  )   & 16777215 ;
    out[ 20  + outpos] = ( in[ 15 + inpos] >>>  0  )   & 16777215 ;
    out[ 21  + outpos] = ( in[ 15 + inpos] >>>  24  )   & 16777215 ;
    out[ 21  + outpos] |= (in[ 16 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 22  + outpos] = ( in[ 16 + inpos] >>>  16  )   & 16777215 ;
    out[ 22  + outpos] |= (in[ 17 + inpos]   & 255 )<<( 24 - 8 );
    out[ 23  + outpos] = ( in[ 17 + inpos] >>>  8  )   & 16777215 ;
    out[ 24  + outpos] = ( in[ 18 + inpos] >>>  0  )   & 16777215 ;
    out[ 25  + outpos] = ( in[ 18 + inpos] >>>  24  )   & 16777215 ;
    out[ 25  + outpos] |= (in[ 19 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 26  + outpos] = ( in[ 19 + inpos] >>>  16  )   & 16777215 ;
    out[ 26  + outpos] |= (in[ 20 + inpos]   & 255 )<<( 24 - 8 );
    out[ 27  + outpos] = ( in[ 20 + inpos] >>>  8  )   & 16777215 ;
    out[ 28  + outpos] = ( in[ 21 + inpos] >>>  0  )   & 16777215 ;
    out[ 29  + outpos] = ( in[ 21 + inpos] >>>  24  )   & 16777215 ;
    out[ 29  + outpos] |= (in[ 22 + inpos]   & 65535 )<<( 24 - 16 );
    out[ 30  + outpos] = ( in[ 22 + inpos] >>>  16  )   & 16777215 ;
    out[ 30  + outpos] |= (in[ 23 + inpos]   & 255 )<<( 24 - 8 );
    out[ 31  + outpos] = ( in[ 23 + inpos] >>>  8  )   & 16777215 ;
}




public static void fastunpack25(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 33554431 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  25  )   & 33554431 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 262143 )<<( 25 - 18 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  18  )   & 33554431 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 2047 )<<( 25 - 11 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  11  )   & 33554431 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 15 )<<( 25 - 4 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  4  )   & 33554431 ;
    out[ 5  + outpos] = ( in[ 3 + inpos] >>>  29  )   & 33554431 ;
    out[ 5  + outpos] |= (in[ 4 + inpos]   & 4194303 )<<( 25 - 22 );
    out[ 6  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 33554431 ;
    out[ 6  + outpos] |= (in[ 5 + inpos]   & 32767 )<<( 25 - 15 );
    out[ 7  + outpos] = ( in[ 5 + inpos] >>>  15  )   & 33554431 ;
    out[ 7  + outpos] |= (in[ 6 + inpos]   & 255 )<<( 25 - 8 );
    out[ 8  + outpos] = ( in[ 6 + inpos] >>>  8  )   & 33554431 ;
    out[ 8  + outpos] |= (in[ 7 + inpos]   & 1 )<<( 25 - 1 );
    out[ 9  + outpos] = ( in[ 7 + inpos] >>>  1  )   & 33554431 ;
    out[ 10  + outpos] = ( in[ 7 + inpos] >>>  26  )   & 33554431 ;
    out[ 10  + outpos] |= (in[ 8 + inpos]   & 524287 )<<( 25 - 19 );
    out[ 11  + outpos] = ( in[ 8 + inpos] >>>  19  )   & 33554431 ;
    out[ 11  + outpos] |= (in[ 9 + inpos]   & 4095 )<<( 25 - 12 );
    out[ 12  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 33554431 ;
    out[ 12  + outpos] |= (in[ 10 + inpos]   & 31 )<<( 25 - 5 );
    out[ 13  + outpos] = ( in[ 10 + inpos] >>>  5  )   & 33554431 ;
    out[ 14  + outpos] = ( in[ 10 + inpos] >>>  30  )   & 33554431 ;
    out[ 14  + outpos] |= (in[ 11 + inpos]   & 8388607 )<<( 25 - 23 );
    out[ 15  + outpos] = ( in[ 11 + inpos] >>>  23  )   & 33554431 ;
    out[ 15  + outpos] |= (in[ 12 + inpos]   & 65535 )<<( 25 - 16 );
    out[ 16  + outpos] = ( in[ 12 + inpos] >>>  16  )   & 33554431 ;
    out[ 16  + outpos] |= (in[ 13 + inpos]   & 511 )<<( 25 - 9 );
    out[ 17  + outpos] = ( in[ 13 + inpos] >>>  9  )   & 33554431 ;
    out[ 17  + outpos] |= (in[ 14 + inpos]   & 3 )<<( 25 - 2 );
    out[ 18  + outpos] = ( in[ 14 + inpos] >>>  2  )   & 33554431 ;
    out[ 19  + outpos] = ( in[ 14 + inpos] >>>  27  )   & 33554431 ;
    out[ 19  + outpos] |= (in[ 15 + inpos]   & 1048575 )<<( 25 - 20 );
    out[ 20  + outpos] = ( in[ 15 + inpos] >>>  20  )   & 33554431 ;
    out[ 20  + outpos] |= (in[ 16 + inpos]   & 8191 )<<( 25 - 13 );
    out[ 21  + outpos] = ( in[ 16 + inpos] >>>  13  )   & 33554431 ;
    out[ 21  + outpos] |= (in[ 17 + inpos]   & 63 )<<( 25 - 6 );
    out[ 22  + outpos] = ( in[ 17 + inpos] >>>  6  )   & 33554431 ;
    out[ 23  + outpos] = ( in[ 17 + inpos] >>>  31  )   & 33554431 ;
    out[ 23  + outpos] |= (in[ 18 + inpos]   & 16777215 )<<( 25 - 24 );
    out[ 24  + outpos] = ( in[ 18 + inpos] >>>  24  )   & 33554431 ;
    out[ 24  + outpos] |= (in[ 19 + inpos]   & 131071 )<<( 25 - 17 );
    out[ 25  + outpos] = ( in[ 19 + inpos] >>>  17  )   & 33554431 ;
    out[ 25  + outpos] |= (in[ 20 + inpos]   & 1023 )<<( 25 - 10 );
    out[ 26  + outpos] = ( in[ 20 + inpos] >>>  10  )   & 33554431 ;
    out[ 26  + outpos] |= (in[ 21 + inpos]   & 7 )<<( 25 - 3 );
    out[ 27  + outpos] = ( in[ 21 + inpos] >>>  3  )   & 33554431 ;
    out[ 28  + outpos] = ( in[ 21 + inpos] >>>  28  )   & 33554431 ;
    out[ 28  + outpos] |= (in[ 22 + inpos]   & 2097151 )<<( 25 - 21 );
    out[ 29  + outpos] = ( in[ 22 + inpos] >>>  21  )   & 33554431 ;
    out[ 29  + outpos] |= (in[ 23 + inpos]   & 16383 )<<( 25 - 14 );
    out[ 30  + outpos] = ( in[ 23 + inpos] >>>  14  )   & 33554431 ;
    out[ 30  + outpos] |= (in[ 24 + inpos]   & 127 )<<( 25 - 7 );
    out[ 31  + outpos] = ( in[ 24 + inpos] >>>  7  )   & 33554431 ;
}




public static void fastunpack26(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 67108863 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  26  )   & 67108863 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 1048575 )<<( 26 - 20 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  20  )   & 67108863 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 16383 )<<( 26 - 14 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  14  )   & 67108863 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 255 )<<( 26 - 8 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  8  )   & 67108863 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 3 )<<( 26 - 2 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  2  )   & 67108863 ;
    out[ 6  + outpos] = ( in[ 4 + inpos] >>>  28  )   & 67108863 ;
    out[ 6  + outpos] |= (in[ 5 + inpos]   & 4194303 )<<( 26 - 22 );
    out[ 7  + outpos] = ( in[ 5 + inpos] >>>  22  )   & 67108863 ;
    out[ 7  + outpos] |= (in[ 6 + inpos]   & 65535 )<<( 26 - 16 );
    out[ 8  + outpos] = ( in[ 6 + inpos] >>>  16  )   & 67108863 ;
    out[ 8  + outpos] |= (in[ 7 + inpos]   & 1023 )<<( 26 - 10 );
    out[ 9  + outpos] = ( in[ 7 + inpos] >>>  10  )   & 67108863 ;
    out[ 9  + outpos] |= (in[ 8 + inpos]   & 15 )<<( 26 - 4 );
    out[ 10  + outpos] = ( in[ 8 + inpos] >>>  4  )   & 67108863 ;
    out[ 11  + outpos] = ( in[ 8 + inpos] >>>  30  )   & 67108863 ;
    out[ 11  + outpos] |= (in[ 9 + inpos]   & 16777215 )<<( 26 - 24 );
    out[ 12  + outpos] = ( in[ 9 + inpos] >>>  24  )   & 67108863 ;
    out[ 12  + outpos] |= (in[ 10 + inpos]   & 262143 )<<( 26 - 18 );
    out[ 13  + outpos] = ( in[ 10 + inpos] >>>  18  )   & 67108863 ;
    out[ 13  + outpos] |= (in[ 11 + inpos]   & 4095 )<<( 26 - 12 );
    out[ 14  + outpos] = ( in[ 11 + inpos] >>>  12  )   & 67108863 ;
    out[ 14  + outpos] |= (in[ 12 + inpos]   & 63 )<<( 26 - 6 );
    out[ 15  + outpos] = ( in[ 12 + inpos] >>>  6  )   & 67108863 ;
    out[ 16  + outpos] = ( in[ 13 + inpos] >>>  0  )   & 67108863 ;
    out[ 17  + outpos] = ( in[ 13 + inpos] >>>  26  )   & 67108863 ;
    out[ 17  + outpos] |= (in[ 14 + inpos]   & 1048575 )<<( 26 - 20 );
    out[ 18  + outpos] = ( in[ 14 + inpos] >>>  20  )   & 67108863 ;
    out[ 18  + outpos] |= (in[ 15 + inpos]   & 16383 )<<( 26 - 14 );
    out[ 19  + outpos] = ( in[ 15 + inpos] >>>  14  )   & 67108863 ;
    out[ 19  + outpos] |= (in[ 16 + inpos]   & 255 )<<( 26 - 8 );
    out[ 20  + outpos] = ( in[ 16 + inpos] >>>  8  )   & 67108863 ;
    out[ 20  + outpos] |= (in[ 17 + inpos]   & 3 )<<( 26 - 2 );
    out[ 21  + outpos] = ( in[ 17 + inpos] >>>  2  )   & 67108863 ;
    out[ 22  + outpos] = ( in[ 17 + inpos] >>>  28  )   & 67108863 ;
    out[ 22  + outpos] |= (in[ 18 + inpos]   & 4194303 )<<( 26 - 22 );
    out[ 23  + outpos] = ( in[ 18 + inpos] >>>  22  )   & 67108863 ;
    out[ 23  + outpos] |= (in[ 19 + inpos]   & 65535 )<<( 26 - 16 );
    out[ 24  + outpos] = ( in[ 19 + inpos] >>>  16  )   & 67108863 ;
    out[ 24  + outpos] |= (in[ 20 + inpos]   & 1023 )<<( 26 - 10 );
    out[ 25  + outpos] = ( in[ 20 + inpos] >>>  10  )   & 67108863 ;
    out[ 25  + outpos] |= (in[ 21 + inpos]   & 15 )<<( 26 - 4 );
    out[ 26  + outpos] = ( in[ 21 + inpos] >>>  4  )   & 67108863 ;
    out[ 27  + outpos] = ( in[ 21 + inpos] >>>  30  )   & 67108863 ;
    out[ 27  + outpos] |= (in[ 22 + inpos]   & 16777215 )<<( 26 - 24 );
    out[ 28  + outpos] = ( in[ 22 + inpos] >>>  24  )   & 67108863 ;
    out[ 28  + outpos] |= (in[ 23 + inpos]   & 262143 )<<( 26 - 18 );
    out[ 29  + outpos] = ( in[ 23 + inpos] >>>  18  )   & 67108863 ;
    out[ 29  + outpos] |= (in[ 24 + inpos]   & 4095 )<<( 26 - 12 );
    out[ 30  + outpos] = ( in[ 24 + inpos] >>>  12  )   & 67108863 ;
    out[ 30  + outpos] |= (in[ 25 + inpos]   & 63 )<<( 26 - 6 );
    out[ 31  + outpos] = ( in[ 25 + inpos] >>>  6  )   & 67108863 ;
}




public static void fastunpack27(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 134217727 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  27  )   & 134217727 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 4194303 )<<( 27 - 22 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  22  )   & 134217727 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 131071 )<<( 27 - 17 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  17  )   & 134217727 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 4095 )<<( 27 - 12 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  12  )   & 134217727 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 127 )<<( 27 - 7 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  7  )   & 134217727 ;
    out[ 5  + outpos] |= (in[ 5 + inpos]   & 3 )<<( 27 - 2 );
    out[ 6  + outpos] = ( in[ 5 + inpos] >>>  2  )   & 134217727 ;
    out[ 7  + outpos] = ( in[ 5 + inpos] >>>  29  )   & 134217727 ;
    out[ 7  + outpos] |= (in[ 6 + inpos]   & 16777215 )<<( 27 - 24 );
    out[ 8  + outpos] = ( in[ 6 + inpos] >>>  24  )   & 134217727 ;
    out[ 8  + outpos] |= (in[ 7 + inpos]   & 524287 )<<( 27 - 19 );
    out[ 9  + outpos] = ( in[ 7 + inpos] >>>  19  )   & 134217727 ;
    out[ 9  + outpos] |= (in[ 8 + inpos]   & 16383 )<<( 27 - 14 );
    out[ 10  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 134217727 ;
    out[ 10  + outpos] |= (in[ 9 + inpos]   & 511 )<<( 27 - 9 );
    out[ 11  + outpos] = ( in[ 9 + inpos] >>>  9  )   & 134217727 ;
    out[ 11  + outpos] |= (in[ 10 + inpos]   & 15 )<<( 27 - 4 );
    out[ 12  + outpos] = ( in[ 10 + inpos] >>>  4  )   & 134217727 ;
    out[ 13  + outpos] = ( in[ 10 + inpos] >>>  31  )   & 134217727 ;
    out[ 13  + outpos] |= (in[ 11 + inpos]   & 67108863 )<<( 27 - 26 );
    out[ 14  + outpos] = ( in[ 11 + inpos] >>>  26  )   & 134217727 ;
    out[ 14  + outpos] |= (in[ 12 + inpos]   & 2097151 )<<( 27 - 21 );
    out[ 15  + outpos] = ( in[ 12 + inpos] >>>  21  )   & 134217727 ;
    out[ 15  + outpos] |= (in[ 13 + inpos]   & 65535 )<<( 27 - 16 );
    out[ 16  + outpos] = ( in[ 13 + inpos] >>>  16  )   & 134217727 ;
    out[ 16  + outpos] |= (in[ 14 + inpos]   & 2047 )<<( 27 - 11 );
    out[ 17  + outpos] = ( in[ 14 + inpos] >>>  11  )   & 134217727 ;
    out[ 17  + outpos] |= (in[ 15 + inpos]   & 63 )<<( 27 - 6 );
    out[ 18  + outpos] = ( in[ 15 + inpos] >>>  6  )   & 134217727 ;
    out[ 18  + outpos] |= (in[ 16 + inpos]   & 1 )<<( 27 - 1 );
    out[ 19  + outpos] = ( in[ 16 + inpos] >>>  1  )   & 134217727 ;
    out[ 20  + outpos] = ( in[ 16 + inpos] >>>  28  )   & 134217727 ;
    out[ 20  + outpos] |= (in[ 17 + inpos]   & 8388607 )<<( 27 - 23 );
    out[ 21  + outpos] = ( in[ 17 + inpos] >>>  23  )   & 134217727 ;
    out[ 21  + outpos] |= (in[ 18 + inpos]   & 262143 )<<( 27 - 18 );
    out[ 22  + outpos] = ( in[ 18 + inpos] >>>  18  )   & 134217727 ;
    out[ 22  + outpos] |= (in[ 19 + inpos]   & 8191 )<<( 27 - 13 );
    out[ 23  + outpos] = ( in[ 19 + inpos] >>>  13  )   & 134217727 ;
    out[ 23  + outpos] |= (in[ 20 + inpos]   & 255 )<<( 27 - 8 );
    out[ 24  + outpos] = ( in[ 20 + inpos] >>>  8  )   & 134217727 ;
    out[ 24  + outpos] |= (in[ 21 + inpos]   & 7 )<<( 27 - 3 );
    out[ 25  + outpos] = ( in[ 21 + inpos] >>>  3  )   & 134217727 ;
    out[ 26  + outpos] = ( in[ 21 + inpos] >>>  30  )   & 134217727 ;
    out[ 26  + outpos] |= (in[ 22 + inpos]   & 33554431 )<<( 27 - 25 );
    out[ 27  + outpos] = ( in[ 22 + inpos] >>>  25  )   & 134217727 ;
    out[ 27  + outpos] |= (in[ 23 + inpos]   & 1048575 )<<( 27 - 20 );
    out[ 28  + outpos] = ( in[ 23 + inpos] >>>  20  )   & 134217727 ;
    out[ 28  + outpos] |= (in[ 24 + inpos]   & 32767 )<<( 27 - 15 );
    out[ 29  + outpos] = ( in[ 24 + inpos] >>>  15  )   & 134217727 ;
    out[ 29  + outpos] |= (in[ 25 + inpos]   & 1023 )<<( 27 - 10 );
    out[ 30  + outpos] = ( in[ 25 + inpos] >>>  10  )   & 134217727 ;
    out[ 30  + outpos] |= (in[ 26 + inpos]   & 31 )<<( 27 - 5 );
    out[ 31  + outpos] = ( in[ 26 + inpos] >>>  5  )   & 134217727 ;
}




public static void fastunpack28(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 268435455 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  28  )   & 268435455 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 16777215 )<<( 28 - 24 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  24  )   & 268435455 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 1048575 )<<( 28 - 20 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  20  )   & 268435455 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 65535 )<<( 28 - 16 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  16  )   & 268435455 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 4095 )<<( 28 - 12 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  12  )   & 268435455 ;
    out[ 5  + outpos] |= (in[ 5 + inpos]   & 255 )<<( 28 - 8 );
    out[ 6  + outpos] = ( in[ 5 + inpos] >>>  8  )   & 268435455 ;
    out[ 6  + outpos] |= (in[ 6 + inpos]   & 15 )<<( 28 - 4 );
    out[ 7  + outpos] = ( in[ 6 + inpos] >>>  4  )   & 268435455 ;
    out[ 8  + outpos] = ( in[ 7 + inpos] >>>  0  )   & 268435455 ;
    out[ 9  + outpos] = ( in[ 7 + inpos] >>>  28  )   & 268435455 ;
    out[ 9  + outpos] |= (in[ 8 + inpos]   & 16777215 )<<( 28 - 24 );
    out[ 10  + outpos] = ( in[ 8 + inpos] >>>  24  )   & 268435455 ;
    out[ 10  + outpos] |= (in[ 9 + inpos]   & 1048575 )<<( 28 - 20 );
    out[ 11  + outpos] = ( in[ 9 + inpos] >>>  20  )   & 268435455 ;
    out[ 11  + outpos] |= (in[ 10 + inpos]   & 65535 )<<( 28 - 16 );
    out[ 12  + outpos] = ( in[ 10 + inpos] >>>  16  )   & 268435455 ;
    out[ 12  + outpos] |= (in[ 11 + inpos]   & 4095 )<<( 28 - 12 );
    out[ 13  + outpos] = ( in[ 11 + inpos] >>>  12  )   & 268435455 ;
    out[ 13  + outpos] |= (in[ 12 + inpos]   & 255 )<<( 28 - 8 );
    out[ 14  + outpos] = ( in[ 12 + inpos] >>>  8  )   & 268435455 ;
    out[ 14  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 28 - 4 );
    out[ 15  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 268435455 ;
    out[ 16  + outpos] = ( in[ 14 + inpos] >>>  0  )   & 268435455 ;
    out[ 17  + outpos] = ( in[ 14 + inpos] >>>  28  )   & 268435455 ;
    out[ 17  + outpos] |= (in[ 15 + inpos]   & 16777215 )<<( 28 - 24 );
    out[ 18  + outpos] = ( in[ 15 + inpos] >>>  24  )   & 268435455 ;
    out[ 18  + outpos] |= (in[ 16 + inpos]   & 1048575 )<<( 28 - 20 );
    out[ 19  + outpos] = ( in[ 16 + inpos] >>>  20  )   & 268435455 ;
    out[ 19  + outpos] |= (in[ 17 + inpos]   & 65535 )<<( 28 - 16 );
    out[ 20  + outpos] = ( in[ 17 + inpos] >>>  16  )   & 268435455 ;
    out[ 20  + outpos] |= (in[ 18 + inpos]   & 4095 )<<( 28 - 12 );
    out[ 21  + outpos] = ( in[ 18 + inpos] >>>  12  )   & 268435455 ;
    out[ 21  + outpos] |= (in[ 19 + inpos]   & 255 )<<( 28 - 8 );
    out[ 22  + outpos] = ( in[ 19 + inpos] >>>  8  )   & 268435455 ;
    out[ 22  + outpos] |= (in[ 20 + inpos]   & 15 )<<( 28 - 4 );
    out[ 23  + outpos] = ( in[ 20 + inpos] >>>  4  )   & 268435455 ;
    out[ 24  + outpos] = ( in[ 21 + inpos] >>>  0  )   & 268435455 ;
    out[ 25  + outpos] = ( in[ 21 + inpos] >>>  28  )   & 268435455 ;
    out[ 25  + outpos] |= (in[ 22 + inpos]   & 16777215 )<<( 28 - 24 );
    out[ 26  + outpos] = ( in[ 22 + inpos] >>>  24  )   & 268435455 ;
    out[ 26  + outpos] |= (in[ 23 + inpos]   & 1048575 )<<( 28 - 20 );
    out[ 27  + outpos] = ( in[ 23 + inpos] >>>  20  )   & 268435455 ;
    out[ 27  + outpos] |= (in[ 24 + inpos]   & 65535 )<<( 28 - 16 );
    out[ 28  + outpos] = ( in[ 24 + inpos] >>>  16  )   & 268435455 ;
    out[ 28  + outpos] |= (in[ 25 + inpos]   & 4095 )<<( 28 - 12 );
    out[ 29  + outpos] = ( in[ 25 + inpos] >>>  12  )   & 268435455 ;
    out[ 29  + outpos] |= (in[ 26 + inpos]   & 255 )<<( 28 - 8 );
    out[ 30  + outpos] = ( in[ 26 + inpos] >>>  8  )   & 268435455 ;
    out[ 30  + outpos] |= (in[ 27 + inpos]   & 15 )<<( 28 - 4 );
    out[ 31  + outpos] = ( in[ 27 + inpos] >>>  4  )   & 268435455 ;
}




public static void fastunpack29(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 536870911 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  29  )   & 536870911 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 67108863 )<<( 29 - 26 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  26  )   & 536870911 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 8388607 )<<( 29 - 23 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  23  )   & 536870911 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 1048575 )<<( 29 - 20 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  20  )   & 536870911 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 131071 )<<( 29 - 17 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  17  )   & 536870911 ;
    out[ 5  + outpos] |= (in[ 5 + inpos]   & 16383 )<<( 29 - 14 );
    out[ 6  + outpos] = ( in[ 5 + inpos] >>>  14  )   & 536870911 ;
    out[ 6  + outpos] |= (in[ 6 + inpos]   & 2047 )<<( 29 - 11 );
    out[ 7  + outpos] = ( in[ 6 + inpos] >>>  11  )   & 536870911 ;
    out[ 7  + outpos] |= (in[ 7 + inpos]   & 255 )<<( 29 - 8 );
    out[ 8  + outpos] = ( in[ 7 + inpos] >>>  8  )   & 536870911 ;
    out[ 8  + outpos] |= (in[ 8 + inpos]   & 31 )<<( 29 - 5 );
    out[ 9  + outpos] = ( in[ 8 + inpos] >>>  5  )   & 536870911 ;
    out[ 9  + outpos] |= (in[ 9 + inpos]   & 3 )<<( 29 - 2 );
    out[ 10  + outpos] = ( in[ 9 + inpos] >>>  2  )   & 536870911 ;
    out[ 11  + outpos] = ( in[ 9 + inpos] >>>  31  )   & 536870911 ;
    out[ 11  + outpos] |= (in[ 10 + inpos]   & 268435455 )<<( 29 - 28 );
    out[ 12  + outpos] = ( in[ 10 + inpos] >>>  28  )   & 536870911 ;
    out[ 12  + outpos] |= (in[ 11 + inpos]   & 33554431 )<<( 29 - 25 );
    out[ 13  + outpos] = ( in[ 11 + inpos] >>>  25  )   & 536870911 ;
    out[ 13  + outpos] |= (in[ 12 + inpos]   & 4194303 )<<( 29 - 22 );
    out[ 14  + outpos] = ( in[ 12 + inpos] >>>  22  )   & 536870911 ;
    out[ 14  + outpos] |= (in[ 13 + inpos]   & 524287 )<<( 29 - 19 );
    out[ 15  + outpos] = ( in[ 13 + inpos] >>>  19  )   & 536870911 ;
    out[ 15  + outpos] |= (in[ 14 + inpos]   & 65535 )<<( 29 - 16 );
    out[ 16  + outpos] = ( in[ 14 + inpos] >>>  16  )   & 536870911 ;
    out[ 16  + outpos] |= (in[ 15 + inpos]   & 8191 )<<( 29 - 13 );
    out[ 17  + outpos] = ( in[ 15 + inpos] >>>  13  )   & 536870911 ;
    out[ 17  + outpos] |= (in[ 16 + inpos]   & 1023 )<<( 29 - 10 );
    out[ 18  + outpos] = ( in[ 16 + inpos] >>>  10  )   & 536870911 ;
    out[ 18  + outpos] |= (in[ 17 + inpos]   & 127 )<<( 29 - 7 );
    out[ 19  + outpos] = ( in[ 17 + inpos] >>>  7  )   & 536870911 ;
    out[ 19  + outpos] |= (in[ 18 + inpos]   & 15 )<<( 29 - 4 );
    out[ 20  + outpos] = ( in[ 18 + inpos] >>>  4  )   & 536870911 ;
    out[ 20  + outpos] |= (in[ 19 + inpos]   & 1 )<<( 29 - 1 );
    out[ 21  + outpos] = ( in[ 19 + inpos] >>>  1  )   & 536870911 ;
    out[ 22  + outpos] = ( in[ 19 + inpos] >>>  30  )   & 536870911 ;
    out[ 22  + outpos] |= (in[ 20 + inpos]   & 134217727 )<<( 29 - 27 );
    out[ 23  + outpos] = ( in[ 20 + inpos] >>>  27  )   & 536870911 ;
    out[ 23  + outpos] |= (in[ 21 + inpos]   & 16777215 )<<( 29 - 24 );
    out[ 24  + outpos] = ( in[ 21 + inpos] >>>  24  )   & 536870911 ;
    out[ 24  + outpos] |= (in[ 22 + inpos]   & 2097151 )<<( 29 - 21 );
    out[ 25  + outpos] = ( in[ 22 + inpos] >>>  21  )   & 536870911 ;
    out[ 25  + outpos] |= (in[ 23 + inpos]   & 262143 )<<( 29 - 18 );
    out[ 26  + outpos] = ( in[ 23 + inpos] >>>  18  )   & 536870911 ;
    out[ 26  + outpos] |= (in[ 24 + inpos]   & 32767 )<<( 29 - 15 );
    out[ 27  + outpos] = ( in[ 24 + inpos] >>>  15  )   & 536870911 ;
    out[ 27  + outpos] |= (in[ 25 + inpos]   & 4095 )<<( 29 - 12 );
    out[ 28  + outpos] = ( in[ 25 + inpos] >>>  12  )   & 536870911 ;
    out[ 28  + outpos] |= (in[ 26 + inpos]   & 511 )<<( 29 - 9 );
    out[ 29  + outpos] = ( in[ 26 + inpos] >>>  9  )   & 536870911 ;
    out[ 29  + outpos] |= (in[ 27 + inpos]   & 63 )<<( 29 - 6 );
    out[ 30  + outpos] = ( in[ 27 + inpos] >>>  6  )   & 536870911 ;
    out[ 30  + outpos] |= (in[ 28 + inpos]   & 7 )<<( 29 - 3 );
    out[ 31  + outpos] = ( in[ 28 + inpos] >>>  3  )   & 536870911 ;
}




public static void fastunpack30(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 1073741823 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  30  )   & 1073741823 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 268435455 )<<( 30 - 28 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  28  )   & 1073741823 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 67108863 )<<( 30 - 26 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  26  )   & 1073741823 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 16777215 )<<( 30 - 24 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  24  )   & 1073741823 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 4194303 )<<( 30 - 22 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  22  )   & 1073741823 ;
    out[ 5  + outpos] |= (in[ 5 + inpos]   & 1048575 )<<( 30 - 20 );
    out[ 6  + outpos] = ( in[ 5 + inpos] >>>  20  )   & 1073741823 ;
    out[ 6  + outpos] |= (in[ 6 + inpos]   & 262143 )<<( 30 - 18 );
    out[ 7  + outpos] = ( in[ 6 + inpos] >>>  18  )   & 1073741823 ;
    out[ 7  + outpos] |= (in[ 7 + inpos]   & 65535 )<<( 30 - 16 );
    out[ 8  + outpos] = ( in[ 7 + inpos] >>>  16  )   & 1073741823 ;
    out[ 8  + outpos] |= (in[ 8 + inpos]   & 16383 )<<( 30 - 14 );
    out[ 9  + outpos] = ( in[ 8 + inpos] >>>  14  )   & 1073741823 ;
    out[ 9  + outpos] |= (in[ 9 + inpos]   & 4095 )<<( 30 - 12 );
    out[ 10  + outpos] = ( in[ 9 + inpos] >>>  12  )   & 1073741823 ;
    out[ 10  + outpos] |= (in[ 10 + inpos]   & 1023 )<<( 30 - 10 );
    out[ 11  + outpos] = ( in[ 10 + inpos] >>>  10  )   & 1073741823 ;
    out[ 11  + outpos] |= (in[ 11 + inpos]   & 255 )<<( 30 - 8 );
    out[ 12  + outpos] = ( in[ 11 + inpos] >>>  8  )   & 1073741823 ;
    out[ 12  + outpos] |= (in[ 12 + inpos]   & 63 )<<( 30 - 6 );
    out[ 13  + outpos] = ( in[ 12 + inpos] >>>  6  )   & 1073741823 ;
    out[ 13  + outpos] |= (in[ 13 + inpos]   & 15 )<<( 30 - 4 );
    out[ 14  + outpos] = ( in[ 13 + inpos] >>>  4  )   & 1073741823 ;
    out[ 14  + outpos] |= (in[ 14 + inpos]   & 3 )<<( 30 - 2 );
    out[ 15  + outpos] = ( in[ 14 + inpos] >>>  2  )   & 1073741823 ;
    out[ 16  + outpos] = ( in[ 15 + inpos] >>>  0  )   & 1073741823 ;
    out[ 17  + outpos] = ( in[ 15 + inpos] >>>  30  )   & 1073741823 ;
    out[ 17  + outpos] |= (in[ 16 + inpos]   & 268435455 )<<( 30 - 28 );
    out[ 18  + outpos] = ( in[ 16 + inpos] >>>  28  )   & 1073741823 ;
    out[ 18  + outpos] |= (in[ 17 + inpos]   & 67108863 )<<( 30 - 26 );
    out[ 19  + outpos] = ( in[ 17 + inpos] >>>  26  )   & 1073741823 ;
    out[ 19  + outpos] |= (in[ 18 + inpos]   & 16777215 )<<( 30 - 24 );
    out[ 20  + outpos] = ( in[ 18 + inpos] >>>  24  )   & 1073741823 ;
    out[ 20  + outpos] |= (in[ 19 + inpos]   & 4194303 )<<( 30 - 22 );
    out[ 21  + outpos] = ( in[ 19 + inpos] >>>  22  )   & 1073741823 ;
    out[ 21  + outpos] |= (in[ 20 + inpos]   & 1048575 )<<( 30 - 20 );
    out[ 22  + outpos] = ( in[ 20 + inpos] >>>  20  )   & 1073741823 ;
    out[ 22  + outpos] |= (in[ 21 + inpos]   & 262143 )<<( 30 - 18 );
    out[ 23  + outpos] = ( in[ 21 + inpos] >>>  18  )   & 1073741823 ;
    out[ 23  + outpos] |= (in[ 22 + inpos]   & 65535 )<<( 30 - 16 );
    out[ 24  + outpos] = ( in[ 22 + inpos] >>>  16  )   & 1073741823 ;
    out[ 24  + outpos] |= (in[ 23 + inpos]   & 16383 )<<( 30 - 14 );
    out[ 25  + outpos] = ( in[ 23 + inpos] >>>  14  )   & 1073741823 ;
    out[ 25  + outpos] |= (in[ 24 + inpos]   & 4095 )<<( 30 - 12 );
    out[ 26  + outpos] = ( in[ 24 + inpos] >>>  12  )   & 1073741823 ;
    out[ 26  + outpos] |= (in[ 25 + inpos]   & 1023 )<<( 30 - 10 );
    out[ 27  + outpos] = ( in[ 25 + inpos] >>>  10  )   & 1073741823 ;
    out[ 27  + outpos] |= (in[ 26 + inpos]   & 255 )<<( 30 - 8 );
    out[ 28  + outpos] = ( in[ 26 + inpos] >>>  8  )   & 1073741823 ;
    out[ 28  + outpos] |= (in[ 27 + inpos]   & 63 )<<( 30 - 6 );
    out[ 29  + outpos] = ( in[ 27 + inpos] >>>  6  )   & 1073741823 ;
    out[ 29  + outpos] |= (in[ 28 + inpos]   & 15 )<<( 30 - 4 );
    out[ 30  + outpos] = ( in[ 28 + inpos] >>>  4  )   & 1073741823 ;
    out[ 30  + outpos] |= (in[ 29 + inpos]   & 3 )<<( 30 - 2 );
    out[ 31  + outpos] = ( in[ 29 + inpos] >>>  2  )   & 1073741823 ;
}




public static void fastunpack31(final int [] in, int inpos,  final int [] out, int outpos) {
    out[ 0  + outpos] = ( in[ 0 + inpos] >>>  0  )   & 2147483647 ;
    out[ 1  + outpos] = ( in[ 0 + inpos] >>>  31  )   & 2147483647 ;
    out[ 1  + outpos] |= (in[ 1 + inpos]   & 1073741823 )<<( 31 - 30 );
    out[ 2  + outpos] = ( in[ 1 + inpos] >>>  30  )   & 2147483647 ;
    out[ 2  + outpos] |= (in[ 2 + inpos]   & 536870911 )<<( 31 - 29 );
    out[ 3  + outpos] = ( in[ 2 + inpos] >>>  29  )   & 2147483647 ;
    out[ 3  + outpos] |= (in[ 3 + inpos]   & 268435455 )<<( 31 - 28 );
    out[ 4  + outpos] = ( in[ 3 + inpos] >>>  28  )   & 2147483647 ;
    out[ 4  + outpos] |= (in[ 4 + inpos]   & 134217727 )<<( 31 - 27 );
    out[ 5  + outpos] = ( in[ 4 + inpos] >>>  27  )   & 2147483647 ;
    out[ 5  + outpos] |= (in[ 5 + inpos]   & 67108863 )<<( 31 - 26 );
    out[ 6  + outpos] = ( in[ 5 + inpos] >>>  26  )   & 2147483647 ;
    out[ 6  + outpos] |= (in[ 6 + inpos]   & 33554431 )<<( 31 - 25 );
    out[ 7  + outpos] = ( in[ 6 + inpos] >>>  25  )   & 2147483647 ;
    out[ 7  + outpos] |= (in[ 7 + inpos]   & 16777215 )<<( 31 - 24 );
    out[ 8  + outpos] = ( in[ 7 + inpos] >>>  24  )   & 2147483647 ;
    out[ 8  + outpos] |= (in[ 8 + inpos]   & 8388607 )<<( 31 - 23 );
    out[ 9  + outpos] = ( in[ 8 + inpos] >>>  23  )   & 2147483647 ;
    out[ 9  + outpos] |= (in[ 9 + inpos]   & 4194303 )<<( 31 - 22 );
    out[ 10  + outpos] = ( in[ 9 + inpos] >>>  22  )   & 2147483647 ;
    out[ 10  + outpos] |= (in[ 10 + inpos]   & 2097151 )<<( 31 - 21 );
    out[ 11  + outpos] = ( in[ 10 + inpos] >>>  21  )   & 2147483647 ;
    out[ 11  + outpos] |= (in[ 11 + inpos]   & 1048575 )<<( 31 - 20 );
    out[ 12  + outpos] = ( in[ 11 + inpos] >>>  20  )   & 2147483647 ;
    out[ 12  + outpos] |= (in[ 12 + inpos]   & 524287 )<<( 31 - 19 );
    out[ 13  + outpos] = ( in[ 12 + inpos] >>>  19  )   & 2147483647 ;
    out[ 13  + outpos] |= (in[ 13 + inpos]   & 262143 )<<( 31 - 18 );
    out[ 14  + outpos] = ( in[ 13 + inpos] >>>  18  )   & 2147483647 ;
    out[ 14  + outpos] |= (in[ 14 + inpos]   & 131071 )<<( 31 - 17 );
    out[ 15  + outpos] = ( in[ 14 + inpos] >>>  17  )   & 2147483647 ;
    out[ 15  + outpos] |= (in[ 15 + inpos]   & 65535 )<<( 31 - 16 );
    out[ 16  + outpos] = ( in[ 15 + inpos] >>>  16  )   & 2147483647 ;
    out[ 16  + outpos] |= (in[ 16 + inpos]   & 32767 )<<( 31 - 15 );
    out[ 17  + outpos] = ( in[ 16 + inpos] >>>  15  )   & 2147483647 ;
    out[ 17  + outpos] |= (in[ 17 + inpos]   & 16383 )<<( 31 - 14 );
    out[ 18  + outpos] = ( in[ 17 + inpos] >>>  14  )   & 2147483647 ;
    out[ 18  + outpos] |= (in[ 18 + inpos]   & 8191 )<<( 31 - 13 );
    out[ 19  + outpos] = ( in[ 18 + inpos] >>>  13  )   & 2147483647 ;
    out[ 19  + outpos] |= (in[ 19 + inpos]   & 4095 )<<( 31 - 12 );
    out[ 20  + outpos] = ( in[ 19 + inpos] >>>  12  )   & 2147483647 ;
    out[ 20  + outpos] |= (in[ 20 + inpos]   & 2047 )<<( 31 - 11 );
    out[ 21  + outpos] = ( in[ 20 + inpos] >>>  11  )   & 2147483647 ;
    out[ 21  + outpos] |= (in[ 21 + inpos]   & 1023 )<<( 31 - 10 );
    out[ 22  + outpos] = ( in[ 21 + inpos] >>>  10  )   & 2147483647 ;
    out[ 22  + outpos] |= (in[ 22 + inpos]   & 511 )<<( 31 - 9 );
    out[ 23  + outpos] = ( in[ 22 + inpos] >>>  9  )   & 2147483647 ;
    out[ 23  + outpos] |= (in[ 23 + inpos]   & 255 )<<( 31 - 8 );
    out[ 24  + outpos] = ( in[ 23 + inpos] >>>  8  )   & 2147483647 ;
    out[ 24  + outpos] |= (in[ 24 + inpos]   & 127 )<<( 31 - 7 );
    out[ 25  + outpos] = ( in[ 24 + inpos] >>>  7  )   & 2147483647 ;
    out[ 25  + outpos] |= (in[ 25 + inpos]   & 63 )<<( 31 - 6 );
    out[ 26  + outpos] = ( in[ 25 + inpos] >>>  6  )   & 2147483647 ;
    out[ 26  + outpos] |= (in[ 26 + inpos]   & 31 )<<( 31 - 5 );
    out[ 27  + outpos] = ( in[ 26 + inpos] >>>  5  )   & 2147483647 ;
    out[ 27  + outpos] |= (in[ 27 + inpos]   & 15 )<<( 31 - 4 );
    out[ 28  + outpos] = ( in[ 27 + inpos] >>>  4  )   & 2147483647 ;
    out[ 28  + outpos] |= (in[ 28 + inpos]   & 7 )<<( 31 - 3 );
    out[ 29  + outpos] = ( in[ 28 + inpos] >>>  3  )   & 2147483647 ;
    out[ 29  + outpos] |= (in[ 29 + inpos]   & 3 )<<( 31 - 2 );
    out[ 30  + outpos] = ( in[ 29 + inpos] >>>  2  )   & 2147483647 ;
    out[ 30  + outpos] |= (in[ 30 + inpos]   & 1 )<<( 31 - 1 );
    out[ 31  + outpos] = ( in[ 30 + inpos] >>>  1  )   & 2147483647 ;
}




public static void fastunpack32(final int [] in, int inpos,  final int [] out, int outpos) {
	System.arraycopy(in, inpos, out, outpos, 32); 
}


public static void fastpack32(final int [] in, int inpos,  final int [] out, int outpos) {
	System.arraycopy(in, inpos, out, outpos, 32); 
}


public static void fastpackwithoutmask32(final int [] in, int inpos,  final int [] out, int outpos) {
	System.arraycopy(in, inpos, out, outpos, 32); 
}


public static void fastunpack0(final int [] in, int inpos,  final int [] out, int outpos) {
	Arrays.fill(out,outpos,outpos+32,0);
}


public static void fastpack0(final int [] in, int inpos,  final int [] out, int outpos) {
	// nothing 
}


public static void fastpackwithoutmask0(final int [] in, int inpos,  final int [] out, int outpos) {
	// nothing
}



public static void fastunpack(final int [] in, int inpos,  final int [] out, int outpos, final int bit) {
	switch(bit) {
			case 0:
				fastunpack0(in,inpos,out,outpos);
				break;
			case 1:
				fastunpack1(in,inpos,out,outpos);
				break;
			case 2:
				fastunpack2(in,inpos,out,outpos);
				break;
			case 3:
				fastunpack3(in,inpos,out,outpos);
				break;
			case 4:
				fastunpack4(in,inpos,out,outpos);
				break;
			case 5:
				fastunpack5(in,inpos,out,outpos);
				break;
			case 6:
				fastunpack6(in,inpos,out,outpos);
				break;
			case 7:
				fastunpack7(in,inpos,out,outpos);
				break;
			case 8:
				fastunpack8(in,inpos,out,outpos);
				break;
			case 9:
				fastunpack9(in,inpos,out,outpos);
				break;
			case 10:
				fastunpack10(in,inpos,out,outpos);
				break;
			case 11:
				fastunpack11(in,inpos,out,outpos);
				break;
			case 12:
				fastunpack12(in,inpos,out,outpos);
				break;
			case 13:
				fastunpack13(in,inpos,out,outpos);
				break;
			case 14:
				fastunpack14(in,inpos,out,outpos);
				break;
			case 15:
				fastunpack15(in,inpos,out,outpos);
				break;
			case 16:
				fastunpack16(in,inpos,out,outpos);
				break;
			case 17:
				fastunpack17(in,inpos,out,outpos);
				break;
			case 18:
				fastunpack18(in,inpos,out,outpos);
				break;
			case 19:
				fastunpack19(in,inpos,out,outpos);
				break;
			case 20:
				fastunpack20(in,inpos,out,outpos);
				break;
			case 21:
				fastunpack21(in,inpos,out,outpos);
				break;
			case 22:
				fastunpack22(in,inpos,out,outpos);
				break;
			case 23:
				fastunpack23(in,inpos,out,outpos);
				break;
			case 24:
				fastunpack24(in,inpos,out,outpos);
				break;
			case 25:
				fastunpack25(in,inpos,out,outpos);
				break;
			case 26:
				fastunpack26(in,inpos,out,outpos);
				break;
			case 27:
				fastunpack27(in,inpos,out,outpos);
				break;
			case 28:
				fastunpack28(in,inpos,out,outpos);
				break;
			case 29:
				fastunpack29(in,inpos,out,outpos);
				break;
			case 30:
				fastunpack30(in,inpos,out,outpos);
				break;
			case 31:
				fastunpack31(in,inpos,out,outpos);
				break;
			case 32:
				fastunpack32(in,inpos,out,outpos);
				break;
			default: 
				throw new IllegalArgumentException("Unsupported bit width.");		
	}
}


public static void fastpack(final int [] in, int inpos,  final int [] out, int outpos, final int bit) {
	switch(bit) {
			case 0:
				fastpack0(in,inpos,out,outpos);
				break;
			case 1:
				fastpack1(in,inpos,out,outpos);
				break;
			case 2:
				fastpack2(in,inpos,out,outpos);
				break;
			case 3:
				fastpack3(in,inpos,out,outpos);
				break;
			case 4:
				fastpack4(in,inpos,out,outpos);
				break;
			case 5:
				fastpack5(in,inpos,out,outpos);
				break;
			case 6:
				fastpack6(in,inpos,out,outpos);
				break;
			case 7:
				fastpack7(in,inpos,out,outpos);
				break;
			case 8:
				fastpack8(in,inpos,out,outpos);
				break;
			case 9:
				fastpack9(in,inpos,out,outpos);
				break;
			case 10:
				fastpack10(in,inpos,out,outpos);
				break;
			case 11:
				fastpack11(in,inpos,out,outpos);
				break;
			case 12:
				fastpack12(in,inpos,out,outpos);
				break;
			case 13:
				fastpack13(in,inpos,out,outpos);
				break;
			case 14:
				fastpack14(in,inpos,out,outpos);
				break;
			case 15:
				fastpack15(in,inpos,out,outpos);
				break;
			case 16:
				fastpack16(in,inpos,out,outpos);
				break;
			case 17:
				fastpack17(in,inpos,out,outpos);
				break;
			case 18:
				fastpack18(in,inpos,out,outpos);
				break;
			case 19:
				fastpack19(in,inpos,out,outpos);
				break;
			case 20:
				fastpack20(in,inpos,out,outpos);
				break;
			case 21:
				fastpack21(in,inpos,out,outpos);
				break;
			case 22:
				fastpack22(in,inpos,out,outpos);
				break;
			case 23:
				fastpack23(in,inpos,out,outpos);
				break;
			case 24:
				fastpack24(in,inpos,out,outpos);
				break;
			case 25:
				fastpack25(in,inpos,out,outpos);
				break;
			case 26:
				fastpack26(in,inpos,out,outpos);
				break;
			case 27:
				fastpack27(in,inpos,out,outpos);
				break;
			case 28:
				fastpack28(in,inpos,out,outpos);
				break;
			case 29:
				fastpack29(in,inpos,out,outpos);
				break;
			case 30:
				fastpack30(in,inpos,out,outpos);
				break;
			case 31:
				fastpack31(in,inpos,out,outpos);
				break;
			case 32:
				fastpack32(in,inpos,out,outpos);
				break;
			default: 
				throw new IllegalArgumentException("Unsupported bit width.");		
	}
}


public static void fastpackwithoutmask(final int [] in, int inpos,  final int [] out, int outpos, final int bit) {
	switch(bit) {
			case 0:
				fastpackwithoutmask0(in,inpos,out,outpos);
				break;
			case 1:
				fastpackwithoutmask1(in,inpos,out,outpos);
				break;
			case 2:
				fastpackwithoutmask2(in,inpos,out,outpos);
				break;
			case 3:
				fastpackwithoutmask3(in,inpos,out,outpos);
				break;
			case 4:
				fastpackwithoutmask4(in,inpos,out,outpos);
				break;
			case 5:
				fastpackwithoutmask5(in,inpos,out,outpos);
				break;
			case 6:
				fastpackwithoutmask6(in,inpos,out,outpos);
				break;
			case 7:
				fastpackwithoutmask7(in,inpos,out,outpos);
				break;
			case 8:
				fastpackwithoutmask8(in,inpos,out,outpos);
				break;
			case 9:
				fastpackwithoutmask9(in,inpos,out,outpos);
				break;
			case 10:
				fastpackwithoutmask10(in,inpos,out,outpos);
				break;
			case 11:
				fastpackwithoutmask11(in,inpos,out,outpos);
				break;
			case 12:
				fastpackwithoutmask12(in,inpos,out,outpos);
				break;
			case 13:
				fastpackwithoutmask13(in,inpos,out,outpos);
				break;
			case 14:
				fastpackwithoutmask14(in,inpos,out,outpos);
				break;
			case 15:
				fastpackwithoutmask15(in,inpos,out,outpos);
				break;
			case 16:
				fastpackwithoutmask16(in,inpos,out,outpos);
				break;
			case 17:
				fastpackwithoutmask17(in,inpos,out,outpos);
				break;
			case 18:
				fastpackwithoutmask18(in,inpos,out,outpos);
				break;
			case 19:
				fastpackwithoutmask19(in,inpos,out,outpos);
				break;
			case 20:
				fastpackwithoutmask20(in,inpos,out,outpos);
				break;
			case 21:
				fastpackwithoutmask21(in,inpos,out,outpos);
				break;
			case 22:
				fastpackwithoutmask22(in,inpos,out,outpos);
				break;
			case 23:
				fastpackwithoutmask23(in,inpos,out,outpos);
				break;
			case 24:
				fastpackwithoutmask24(in,inpos,out,outpos);
				break;
			case 25:
				fastpackwithoutmask25(in,inpos,out,outpos);
				break;
			case 26:
				fastpackwithoutmask26(in,inpos,out,outpos);
				break;
			case 27:
				fastpackwithoutmask27(in,inpos,out,outpos);
				break;
			case 28:
				fastpackwithoutmask28(in,inpos,out,outpos);
				break;
			case 29:
				fastpackwithoutmask29(in,inpos,out,outpos);
				break;
			case 30:
				fastpackwithoutmask30(in,inpos,out,outpos);
				break;
			case 31:
				fastpackwithoutmask31(in,inpos,out,outpos);
				break;
			case 32:
				fastpackwithoutmask32(in,inpos,out,outpos);
				break;
			default: 
				 throw new IllegalArgumentException("Unsupported bit width.");		
	}
}

}
