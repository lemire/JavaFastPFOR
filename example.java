import integercompression.*;
import java.util.*;

public class example {
	public static void main(String[] args) {
		basicExample();
		advancedExample();
	}
	
	public static void basicExample() {
		int[] data = new int[1024*40];
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
		int[] data = new int[M*N];
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
		IntegratedIntegerCODEC lastcodec =  new 
		   IntegratedComposition(
		            new IntegratedBinaryPacking(),
					new IntegratedVariableByte());
		// output vector should be large enough...
		int [] compressed = new int[M*N];
		// we compress
		IntWrapper inputoffset = new IntWrapper(0);
		IntWrapper outputoffset = new IntWrapper(0);
		for(int k = 0; k < N-1; ++k) 
			regularcodec.compress(data,inputoffset,M,compressed,outputoffset);
 		lastcodec.compress(data,inputoffset,M,compressed,outputoffset);
		// got it! 
		// inputoffset should be at data.length but outputoffset tells
		// us where we are...
		System.out.println("compressed from "+data.length*4+" bytes to "+outputoffset.intValue()*4+" bytes");
		// we can repack the data:
		compressed = Arrays.copyOf(compressed,outputoffset.intValue());
		// now uncompressing
		int[] recovered = new int[M];
		IntWrapper compoff = new IntWrapper(0);
		IntWrapper recoffset;
		for(int k = 0; k < N-1; ++k) {
			recoffset = new IntWrapper(0);
			regularcodec.uncompress(compressed,compoff,compressed.length,recovered,recoffset);
			if(recoffset.intValue() != M) throw new RuntimeException("bug"); // could use assert
			for(int i = 0; i < M; ++i) {
				if(data[k*M+i] != recovered[i]) throw new RuntimeException("bug"); // could use assert
			}
		}
		recoffset = new IntWrapper(0);
		lastcodec.uncompress(compressed,compoff,compressed.length-compoff.get(),recovered,recoffset);
		if(recoffset.intValue() != M) throw new RuntimeException("bug"); // could use assert
		for(int i = 0; i < M; ++i) {
			if(data[(N-1)*M+i] != recovered[i]) throw new RuntimeException("bug"); // could use assert
		}
		System.out.println("data is recovered without loss");
		System.out.println();

	}
}