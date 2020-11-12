

class Main {
    public static void main(String[] args) {

    }

}

class Heap {
    private int lastPosition = 0;
    private int size = 10;
    private int[] arr = new int[size];


    public void add(int value){
        arr[lastPosition++] = value;
        trickleUp(lastPosition);

    }

    public boolean isParentViolation(int parentIndex) throws ArrayIndexOutOfBoundsException {
        if (arr[getLeftChildIndex(parentIndex)] > arr[parentIndex] ||
                arr[getRightChildIndex(parentIndex)] > arr[parentIndex]){
            return true;
        }
        return false;
    }

    public void remove(){
        swap(0,lastPosition--);
        trickleDown(0);

    }

    public void trickleUp(int index){
        if(index == 0){ //if at the root position, return.
            return;
        }
        if(isParentViolation(getParentIndex(index))){ //Check if child node violates max heap rule.
            swap(getParentIndex(index), index); //swap child node with parent node.
            trickleUp(getParentIndex(index));
        }
        return;
    }

    public void trickleDown(int parentIndex){
        int largerChildIndex;
        if(arr[getLeftChildIndex(parentIndex)] >= arr[getRightChildIndex(parentIndex)]){
            largerChildIndex = getLeftChildIndex(parentIndex);
        } else {
            largerChildIndex = getRightChildIndex(parentIndex);
        }

        swap(largerChildIndex,parentIndex);
        if()
        trickleDown(largerChildIndex);
        return;
    }

    public void swap(int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public int getLeftChildIndex(int parentIndex){
        return (2*parentIndex)+1;
    }

    public int getRightChildIndex(int parentIndex){
        return (2*parentIndex)+2;
    }

    public  int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }
}



