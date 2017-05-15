package memory;

import java.util.LinkedList;


/**
 * This memory model allocates memory cells based on the best-fit method.
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class BestFit extends Memory {
	
	LinkedList<Block> freeBlock;
	
	/**
	 * Initializes an instance of a best fit-based memory.
	 * 
	 * @param size The number of cells.
	 */
	public BestFit(int size) {
		super(size);
		freeBlock = new LinkedList<Block>();
		
		// TODO Implement this!
	}

	/**
	 * Allocates a number of memory cells. 	  
	 * 
	 * @param size the number of cells to allocate.
	 * @return The address of the first cell.
	 */
	@Override
	public Pointer alloc(int size) {
		// TODO Implement this!
		int snugFit = Integer.MAX_VALUE;
		int bestFitPos = 0;
		snugFit = snugFit-size;
		for(int i = 0; i < cells.length; i++){
			if(cells[i] == 0){
				int capacity = 1;
				boolean available = true;
				for(int j = i; j < size+i; j++){
					
					if(cells[j] != 0){
						//Not big enough
						while(cells[j] != 0){
							j++;
						}
						i = j;
						available = false;
						break;
					}
					capacity++;
					
				}
				
				if(available){
					if(capacity-size <= snugFit){
						bestFitPos = i;
					}
				}
			}
			
		}
		
		return new Pointer(bestFitPos, this);
		
	}
	
	/**
	 * Releases a number of data cells
	 * 
	 * @param p The pointer to release.
	 */
	@Override
	public void release(Pointer p) {
		freeBlock.remove(p);
		// TODO Implement this!
	}
	
	/**
	 * Prints a simple model of the memory. Example:
	 * 
	 * |    0 -  110 | Allocated
	 * |  111 -  150 | Free
	 * |  151 -  999 | Allocated
	 * | 1000 - 1024 | Free
	 */
	@Override
	public void printLayout() {
		System.out.println(this.toString());
		// TODO Implement this!
	}
}