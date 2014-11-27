package cn.gaom.utils.stack;

/**
 * a stack implements using array.
 * @author root
 *
 * @param <T>
 */
public class ArrayStack<T> implements IStack<T>{
	
	private static final int defaultLen = 16;
	private Object[] mObjs = new Object[defaultLen];
	/** the real elements' count of the stack  **/
	private int size = 0;
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		for(Object obj : mObjs){
			obj = null;
		}
		size = 0;
	}

	@Override
	public int length() {
		return size;
	}

	@Override
	public int push(T data) {
		if(size >= mObjs.length){
			resize();
		}
		mObjs[size++] = data;
		return size;
	}
	
	private void resize(){
		Object[] temp = new Object[mObjs.length*3/2 +1];
		for(int i =0;i<mObjs.length;i++){
			temp[i] = mObjs[i];
			mObjs[i] = null;
		}
		mObjs = temp;
	}

	@Override
	public T pop() {
		if(size == 0){
			return null;
		}
		return (T) mObjs[--size];
	}

	@Override  
    public String toString() {  
        StringBuilder sb = new StringBuilder();  
        sb.append("MyArrayStack: [");  
        for (int i = 0; i < size; i++) {  
            sb.append(mObjs[i].toString());  
            if (i != size - 1) {  
                sb.append(", ");  
            }  
        }  
        sb.append("]");  
        return sb.toString();  
    }
	
}
