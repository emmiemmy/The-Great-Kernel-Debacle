package memory;

/**
 * Class illustrates a free block with size and a pinter to the next free block
 * @author emmashakespeare
 *
 */
public class Block {
	private int size;
	private int next;
	

	
	public Block(int size, int next){
		this.size = size;
		this.next = next;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}

}
