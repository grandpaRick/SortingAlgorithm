import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort(new int[] {22,17,19,12,15,11,7,6,9,10,5});
        System.out.println(Arrays.toString(hs.heapSort()));
    }
}


class HeapSort {
    private int lastPosition = -1;
    private int size;
    private int[] arr;

    public HeapSort(int[] arr){
        this. size = arr.length;
        this.arr = arr;
    }

    public int[] heapSort(){
        System.out.println("default: " + Arrays.toString(this.arr));
        for (int i =0; i< this.size; ++i){
            add(this.arr[i]);
        }
        System.out.println("postAdd: " + Arrays.toString(this.arr));
        for (int i = 0; i < this.size; ++i){
            remove();
        }

        return this.arr;
    }
    private void add(int value){
        this.arr[++lastPosition] = value;
        trickleUp(lastPosition);

    }

    private boolean parentViolation(int index) {
        if ( this.arr[index] > arr[parent(index)]){ //confirms if child node is larger than parent node.
            return true;
        }
        return false;
    }

    private void remove(){
        swap(0,lastPosition--); //place root node(highest integer) to last unsorted array position.
        trickleDown(0); //trickle down to return heap to a stable state.

    }

    private void trickleUp(int index){
        if(index == 0){ //if at the root position, return.
            return;
        }
        if(parentViolation(index)){ //Check if child node violates max heap rule.
            swap(parent(index), index); //swap child node with parent node.
            trickleUp(parent(index)); //recursively check child/parent node, ensure max heap rule.
        }
        return;
    }

    private void trickleDown(int parentIndex){

        if((leftChild(parentIndex) <lastPosition) && (rightChild(parentIndex) <= lastPosition)){
            if(this.arr[leftChild(parentIndex)] >= this.arr[rightChild(parentIndex)]){ // allow swaps between parent and the higher ..
                swap(leftChild(parentIndex),parentIndex); //swap between larger element and root element
                trickleDown(leftChild(parentIndex));
            } else {
                swap(rightChild(parentIndex),parentIndex); //swap between larger element and root element
                trickleDown(rightChild(parentIndex));
            }
        }

        if((leftChild(parentIndex) <= lastPosition) && //takes care of the edge case when the left child
                (this.arr[parentIndex] < this.arr[leftChild(parentIndex)])){ //is the last position
            swap(leftChild(parentIndex),parentIndex);
            trickleDown(leftChild(parentIndex));
        }

        return;
    }

    private void swap(int pos1, int pos2){ //perform swap operation on passed index.
        int temp = this.arr[pos1];
        this.arr[pos1] = this.arr[pos2];
        this.arr[pos2] = temp;
    }

    private int leftChild(int parentIndex){ //return the left child index to the index argument
        return (2*parentIndex)+1;
    }

    private int rightChild(int parentIndex){ //return the right child index to the index argument
        return (2*parentIndex)+2;
    }

    private  int parent(int childIndex){ //return the parent index to the index argument
        return (childIndex-1)/2;
    }
}



