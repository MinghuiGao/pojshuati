package cn.gaom.utils.stack;

/**
 * @author root
 */
public interface IStack<T> {
	/** **/
	boolean isEmpty();

	/**
	 * 
	 */
	void clear();

	/**
	 * @return
	 */
	int length();

	/**
	 * @param data
	 * @return the total size of the stack.
	 */
	int push(T data);

	/**
	 * @return
	 */
	T pop();
}
