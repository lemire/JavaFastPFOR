import integercompression.*;
import java.util.*;

public class example {
	public static void main(String[] args) {
		int[] data = new int[1024];
		// data should be sorted for best
		//results
		for(int k = 0; k < data.length; ++k)
		  data[k] = k;
		// next we compose a CODEC. Most of the processing
		// will be done with binary packing, and leftovers will
		// be processed using variable byte
		IntegratedIntegerCODEC codec =  new 
		   IntegratedComposition(
		            new IntegratedBinaryPacking(),
					new IntegratedVariableByte());
		// output vector should be large enough...
		int [] compressed = new int[1024];
		// we compress
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		codec.compress(data,inputoffset,data.length,compressed,outputoffset);
		// got it! 
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println("compressed from "+data.length*4+" bytes to "+outputoffset.intValue()*4+" bytes");
		// we can repack the data:
		compressed = Arrays.copyOf(compressed,outputoffset.intValue());
		// now uncompressing
		int[] recovered = new int[1024];
		IntWrapper recoffset = new IntWrapper(0);
		codec.uncompress(compressed,new IntWrapper(0),compressed.length,recovered,recoffset);
		if(Arrays.equals(data,recovered)) 
		  System.out.println("data is recovered without loss");
		
	}
}