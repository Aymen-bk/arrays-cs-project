package samplearrays;

public class CourseNumbersArray {
    public static boolean containsCourse(int[] courses, int courseNumber) {
        for (int course : courses) {
            if (course == courseNumber) {
                return true; //means we found it
            }
        }
        return false;
    }

    public static void printArray(int[] array) {
        System.out.print("[");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static int[] addCourse(int[] courses, int newCourse) {
        int[] newArray = new int[courses.length + 1];
        for (int i=0; i<courses.length; i++) {
            newArray[i] = courses[i];  //putting all the elements of the old array into the new one
        }
        newArray[newArray.length - 1] = newCourse;
        return newArray;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};

        //2
        int newCourse = 2170;
        int[] updatedCourses = addCourse(registeredCourses, newCourse);

        //3
        System.out.print("Registered courses: ");
        printArray(registeredCourses);
        System.out.print("Updated courses: ");
        printArray(updatedCourses);

        //4 tests
        int c = 2140;
        boolean b = containsCourse(updatedCourses, c);
        System.out.println("Contains course " + c + "? : " +b);

        c = 3000;
        b = containsCourse(updatedCourses, c);
        System.out.println("Contains course " + c + "? : " +b);
    }
}
