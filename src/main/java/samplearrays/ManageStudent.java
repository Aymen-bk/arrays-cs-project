package samplearrays;


import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for(Student student:students){
            if (student.getAge()>oldest.getAge()) { oldest=student; }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int c=0;
        for(Student student:students){
            if (student.getAge()>=18) { c++;}
        }
        return c;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double av=0;
        int c = 0;
        for(Student student:students){
            av+=student.getGrade();
            c++;
        }
        return av/c;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student student:students){
            if (student.getName().equalsIgnoreCase(name)) {return student;}
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, 0, students.length,
                Comparator.comparingInt(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students)
    {
        for(Student student:students){
            if (student.getGrade()>=15) { System.out.println(student.getName()); }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student:students){
            if (student.getId()==id)
            {
                student.setGrade(newGrade);
                return true; //found him
            }
        }
        return false; //doesn't exist
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(int i=0 ; i<students.length  ; i++){
            for(int j = i+1 ; j<students.length  ; j++){
                if(students[i].getName().equals(students[j].getName())){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updArr= Arrays.copyOf(students, students.length + 1);
        updArr[updArr.length-1]=newStudent;
        return updArr;
    }

    // 1) Create an Array of Students + demos for all tasks

    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "best", 20, 15),
                new Student(2, "ayoub", 10, 0),
                new Student(3, "simo", 20, 17),
                new Student(4, "aymen", 19, 10),
                new Student(5, "hassan", 0, 0)  //default age and grade
        };
        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest: " + findOldest(arr));


        // 3) Count adults
        System.out.println("Adults count: " + countAdults(arr));


        // 4) Average grade
        System.out.println("overall avg : " + averageGrade(arr));


        // 5) Find by name
        System.out.println("finding aymen : " + findStudentByName(arr,"aymen").toString());


        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        System.out.println("\nUpdated id=4? " + updateGrade(arr,2,20));
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("Are there any duplicates: "+hasDuplicateNames(arr));

        // 10) Append new student
        Student newstudent = new Student(10,"last");
        Student[] updated=appendStudent(arr,newstudent);



        // 11) representing school using 2D
        Student[][] school={{new Student(1,"aymen",20,100),
                new Student(2,"boubrik",20,10),
                new Student(3,"bob",19,20)},
                {new Student(4,"eric",20,80),
                        new Student(5,"adnane",20,60),
                        new Student(6,"simo",20,67)}};
        for (int s=0; s < school.length ; s++){
            System.out.println("Class "+ (s+1)+" : ");
            for(int j=0;j<school[s].length;j++){
                System.out.println(school[s][j].toString());

            }
        }
        for (int s=0 ; s<school.length  ; s++){
            Student best=school[s][0];
            System.out.println("the best : "+ (s+1)+" : ");
            for(int j=0;j<school[s].length;j++){
                if(school[s][j].getGrade()>best.getGrade()){
                    best=school[s][j];
                }

            }
            System.out.println(best.toString());

        }
    }
}
