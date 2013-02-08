import integercompression.*;
import java.util.*;

public class example {
	public static void main(String[] args) {
		basicExample();
		advancedExample();
	}
	
	public static void basicExample() {
		int[] data = new int[1024*40-111];// the -111 is just to show support for arbitrary lengths
		System.out.println("Compressing "+data.length+" integers in one go");
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
		int [] compressed = new int[data.length];

		/**
		*
		* compressing
		*
		*/
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		codec.compress(data,inputoffset,data.length,compressed,outputoffset);
		// got it! 
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println("compressed from "+data.length*4+" bytes to "+outputoffset.intValue()*4+" bytes");
		// we can repack the data: (optional)
		compressed = Arrays.copyOf(compressed,outputoffset.intValue());

		/**
		*
		* now uncompressing
		*
		*/
		int[] recovered = new int[data.length];
		IntWrapper recoffset = new IntWrapper(0);
		codec.uncompress(compressed,new IntWrapper(0),compressed.length,recovered,recoffset);
		if(Arrays.equals(data,recovered)) 
		  System.out.println("data is recovered without loss");
		else
		  throw new RuntimeException("bug"); // could use assert
		System.out.println();
	}

	/**
	* This is like the basic example, but we 
	* show how to process larger arrays in chunks.
	*/
	public static void advancedExample() {
		int N = 4; // number of chunks
		int M = 10*1024; // size of each chunk
		System.out.println("Compressing "+M*N+" integers using "+N+" chunks of "+M+" integers");
		System.out.println("(This is often better for applications as you keep the data close to the CPU cache.)");
		int[] data = new int[M*N-111];
		// data should be sorted for best
		//results
		for(int k = 0; k < data.length; ++k)
		  data[k] = k;
		// next we compose a CODEC. Most of the processing
		// will be done with binary packing, and leftovers will
		// be processed using variable byte, using variable byte
		// only for the last chunk!
		IntegratedIntegerCODEC regularcodec =  new 
		           IntegratedBinaryPacking();
		IntegratedVariableByte ivb = new IntegratedVariableByte();
		IntegratedIntegerCODEC lastcodec =  new 
		   IntegratedComposition(regularcodec,ivb);
		// output vector should be large enough...
		int [] compressed = new int[M*N];
		
		
		/**
		*
		* compressing
		*
		*/
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		for(int k = 0; k < N-1; ++k) 
			regularcodec.compress(data,inputoffset,M,compressed,outputoffset);
 		lastcodec.compress(data,inputoffset,data.length-(N-1)*M,compressed,outputoffset);
		// got it! 
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println("compressed from "+data.length*4+" bytes to "+outputoffset.intValue()*4+" bytes");
		// we can repack the data:
		compressed = Arrays.copyOf(compressed,outputoffset.intValue());
		
		
		/**
		*
		* now uncompressing
		*
		* We are *not* assuming that the original array length is known, however
		* we assume that the chunk size (M) is known.
		* 
		*/
		int[] recovered = new int[M];
		IntWrapper compoff = new IntWrapper(0);
		IntWrapper recoffset;
		int currentpos = 0;
		boolean done = false;
		while(compoff.get()<compressed.length) {
			recoffset = new IntWrapper(0);
			regularcodec.uncompress(compressed,compoff,compressed.length - compoff.get(),recovered,recoffset);
			if(recoffset.get() < M) {// last chunk detected
				ivb.uncompress(compressed,compoff,compressed.length - compoff.get(),recovered,recoffset);
				done = true;// last
			}
			for(int i = 0; i < recoffset.get(); ++i) {
				if(data[currentpos+i] != recovered[i]) throw new RuntimeException("bug"); // could use assert
			}
			currentpos += recoffset.get();
		}
		System.out.println("data is recovered without loss");
		System.out.println();

	}
}