/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import org.junit.Ignore;

/**
 * Edge-cases having caused issue specifically with LongBinaryPacking.
 * 
 * @author Benoit Lacelle
 */
@Ignore("Parent class tests are not valid as LongBinaryPacking process by chunks of 64 longs")
public class TestLongBinaryPacking extends ATestLongCODEC {
	final LongBinaryPacking codec = new LongBinaryPacking();

	@Override
	public LongCODEC getCodec() {
		return codec;
	}

}
