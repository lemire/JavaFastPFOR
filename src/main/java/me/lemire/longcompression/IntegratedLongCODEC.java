package me.lemire.longcompression;

/**
 * This is just like LongCODEC, except that it indicates that delta coding is
 * "integrated", so that you don't need a separate step for delta coding.
 * 
 * @author Benoit Lacelle
 */
public interface IntegratedLongCODEC extends LongCODEC {

}
