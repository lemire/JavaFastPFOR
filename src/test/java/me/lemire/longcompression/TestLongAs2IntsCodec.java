/**
 * This code is released under the
 * Apache License Version 2.0 http://www.apache.org/licenses/.
 *
 * (c) Daniel Lemire, http://lemire.me/en/
 */

package me.lemire.longcompression;

import org.junit.Assert;
import org.junit.Test;

/**
 * Edge-cases having caused issue specifically with LongVariableByte.
 * 
 * @author Benoit Lacelle
 */
public class TestLongAs2IntsCodec extends ATestLongCODEC {
	final LongAs2IntsCodec codec = new LongAs2IntsCodec();

	@Override
	public LongCODEC getCodec() {
		return codec;
	}

	@Test
	public void testCodec_intermediateHighPowerOfTwo() {
		Assert.assertEquals(3, LongTestUtils.compress((LongCODEC) codec, new long[] { 1L << 42 }).length);
	}

}
