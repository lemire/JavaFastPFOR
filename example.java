import integercompression.*;
import java.util.*;

public class example {
	public static void main(String[] args) {
		basicExample();
		advancedExample();
	}
	
	public static void basicExample() {
		int[] data = new int[2342351];
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
		System.out.println("compressed from "+data.length*4/1024+"KB to "+outputoffset.intValue()*4/1024+"KB");
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
	*
	* Some of this code was written by Pavel Klinov. 
	*/
	public static void advancedExample() {
		int TotalSize = 2342351; // some arbitrary number
		int ChunkSize = 16384; // size of each chunk, choose a multiple of 128
		System.out.println("Compressing "+TotalSize+" integers using chunks of "+ChunkSize+" integers ("+ChunkSize*4/1024+"KB)");
		System.out.println("(It is often better for applications to work in chunks fitting in CPU cache.)");
		int[] data = new int[TotalSize];
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
		int [] compressed = new int[TotalSize];
		
		
		/**
		*
		* compressing
		*
		*/
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		for(int k = 0; k < TotalSize / ChunkSize; ++k) 
			regularcodec.compress(data,inputoffset,ChunkSize,compressed,outputoffset);
 		lastcodec.compress(data, inputoffset, TotalSize % ChunkSize, compressed, outputoffset);
		// got it! 
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println("compressed from "+data.length*4/1024+"KB to "+outputoffset.intValue()*4/1024+"KB");
		// we can repack the data:
		compressed = Arrays.copyOf(compressed,outputoffset.intValue());
		
		
		/**
		*
		* now uncompressing
		*
		* We are *not* assuming that the original array length is known, however
		* we assume that the chunk size (ChunkSize) is known.
		* 
		*/
		int[] recovered = new int[ChunkSize];
		IntWrapper compoff = new IntWrapper(0);
		IntWrapper recoffset;
		int currentpos = 0;

		while(compoff.get()<compressed.length) {
			recoffset = new IntWrapper(0);
			regularcodec.uncompress(compressed,compoff,compressed.length - compoff.get(),recovered,recoffset);
			
			if(recoffset.get() < ChunkSize) {// last chunk detected
				ivb.uncompress(compressed,compoff,compressed.length - compoff.get(),recovered,recoffset);
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