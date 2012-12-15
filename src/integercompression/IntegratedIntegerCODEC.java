package integercompression;


/**
 * 
 * This is just like IntegerCODEC, except that it indicates
 * that delta coding is "integrated", so that you don't
 * need a separate step for delta coding.
 * 
 * @author Daniel Lemire
 *
 */
public interface IntegratedIntegerCODEC extends IntegerCODEC {

}
