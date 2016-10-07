package me.lemire.integercompression;

/**
 * This exception might be thrown if the input is poorly compressible.
 *
 */
public class UncompressibleInputException extends RuntimeException {

	/**
	 * Create new exception
	 * @param string explanation for the exception
	 */
	public UncompressibleInputException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -798583799846489873L;

}
