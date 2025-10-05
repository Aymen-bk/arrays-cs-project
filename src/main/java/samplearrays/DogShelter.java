public class DogShelter  {
    public static int[] dogCounts = {5,10,12,7};

    public static void displayDogs(){
        for (int i=0;i<dogCounts.length;i++){
            System.out.println("Breed " +i +" has "+dogCounts[i]+" dogs");
        }
    }

    public static void addBreed(int breed, int count){
        if (breed >= 0 && breed < dogCounts.length) {dogCounts[breed] += count;}
        else {System.out.println("Invalid breed : " + breed);}
    }

    public static void deleteBreed(int breed){
        if (breed >= 0 && breed < dogCounts.length) {dogCounts[breed] = 0;}
        else {System.out.println("Invalid breed : " + breed);}
    }

    public static void main(String[] args) {

        // Adding counts for three types of dogs
        dogCounts[0] = 15;
        dogCounts[1] = 30;
        dogCounts[2] = 20;

        // Display initial dog counts
        System.out.println("Initial Dog Counts:");
        displayDogs();

        // Increase count for second breed of dog
        addBreed(1, 5);

        // Remove the third breed (set to 0, since arrays can't shrink)
        deleteBreed(2);

        // Display updated dog counts
        System.out.println("\nUpdated Dog Counts:");
        displayDogs();
    }
}
