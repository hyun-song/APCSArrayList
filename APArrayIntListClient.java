public class APArrayIntListClient
{
    public static void main(String[] args){
        //makes APArrayIntList object called array
        APArrayIntList array = new APArrayIntList();
        Scanner console = new Scanner(System.in);
        int cont = 0;
        //keep prompting user to enter temperature until they type quit.
        while (cont == 0){
            System.out.print("Enter a temperature (or \"quit\" to stop): ");
            String temp = console.nextLine();
            if (temp .equals( "quit")){
                //cont changes so that they are not prompted to enter temperatures anymore
                cont = 1;
                //calls method to analyze results, passing array object as parameter
                results(array);
            }
            else{
                //if user doesn't enter quit, adds the temperature that user types in to array
                array.add(Integer.parseInt(temp));
            }
        }    
    }
    //method that analyzes results after user types in quit
    //accepts APArrayIntList as parameter to get information about the array of temperatures that user typed in.
    public static void results(APArrayIntList array){
        int sum = 0;
        int over = 0;
        //goes through each index of the array to get result and add to sum to evaluate sum of all temperatures
        for (int i = 0; i < array.size(); i++){
            sum += array.get(i);
        }
        //calculates average by dividng sum of all temperatures by number of temperatures added to the array
        double average = sum*1.0 / array.size();
        //goes through each index of array to see if each value is greater than average to calculate how many values are above average.
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) > average){
                over++;
            }
        }
        //prints results (average and how many values are above average
        System.out.println("The average temperature was " + average);
        System.out.println(over+" temperatures were above average."); 
    }
}
