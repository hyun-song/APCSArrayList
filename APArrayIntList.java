public class APArrayIntList implements APIntList
{
    public int[] answer;
    public int count;
    //constructor: initializes count(number of items in the array) and first answer array when called by another method
    public APArrayIntList(){
        answer = new int[5];
        int count = 0;
    }
    //returns the size of the array
    public int size(){
        return count;
    }
    //adds one item that is passed as a parameter to the end of the list
    public void add(int item){
        //if number of items on the array reaches multiple of 5, resize() method is called to increase size of the array
        if (count % 5 == 0 && count > 0){
            resize();
        }
        //adds item to the end of the array
        answer[size()] = item;
        //size of the array increases by one
        count++;
    }
    //adds one item that is passed as a parameter to the index that user passes in a parameter, and all values after that index shifts to the right
    public void add(int index, int item){
        //if index that user wants to put new item in is not within the array size(negative or greater than the size), passes ArrayIndexOutOfBoundsException
        if (index < 0 || index > size()){
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
        }
        //if number of items on the array reaches multiple of 5, resize() method is called to increase size of the array
        if (count % 5 == 0 && count > 0){
            resize();
        }
        //for all the items in indexes greater than or at the index, it shifts to the right.
        for (int i = size() - 1; i >= index; i--){
            answer[i+1] = answer[i];
        }
        //adds item to the index
        answer[index] = item;
        //size of the array increases by one
        count++;
    }
    //set one item that is passed as a parameter to the index that is passed as a parameter without increasing the size of the array (just changing one of the values)
    public void set(int index, int item){
        //if index that user wants to put new item in is not within the array size(negative or greater than or equal to size), passes ArrayIndexOutOfBoundsException
        if (index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
        }
        //changes value at index to item
        answer[index] = item;
    }
    //returns value at the index
    public int get(int index){
        //if index that user wants to put new item in is not within the array size(negative or greater than or equal to size), passes ArrayIndexOutOfBoundsException
        if (index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException("Array Index Out of Bounds");
        }
        return answer[index];
    }
    //increases size of array by 5 when all spaces are filled
    public void resize(){
        //initialize temporary array to store all values that were originally stored in answer array
        int[] temp = new int[size()];
        //store all values that were originally stored in answer array to temp array
        for (int i = 0; i < size(); i++){
            temp[i] = answer[i];
        }
        //make new array (with same name) with different size(increased by 5)
        answer = new int[size() + 5];
        //store values from temp array to new and bigger answer array
        for (int i = 0; i < size(); i++){
            answer[i] = temp[i];
        }
    }
}
