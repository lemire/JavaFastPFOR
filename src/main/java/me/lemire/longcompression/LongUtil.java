package me.lemire.longcompression;

/**
 * These are unofficial helpers related to long compression
 * 
 * @author Benoit Lacelle
 *
 */
@Deprecated
public class LongUtil {

	protected static String longToBinaryWithLeading(long l) {
		return String.format("%64s", Long.toBinaryString(l)).replace(' ', '0');
	}
}
