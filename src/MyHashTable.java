import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class MyHashTable {
	
	// ATTRIBUTES

	// buckets is an array of ArrayList.  Each item in an ArrayList is an StudentInfo
	// object holding a reference value pointing to a student.

	public ArrayList<EmployeeInfo>[] buckets;

	
	// CONSTRUCTOR

	@SuppressWarnings("unchecked")
	public MyHashTable(int howManyBuckets) {
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

		// Instantiate buckets as an array of size howManyBuckets, to have an ArrayList reference as each element of the array.
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();  // Instantiate the ArrayList for bucket i.
		}
	}


	// METHODS

	public int calcBucket(int employeeNumber) {
		return(employeeNumber % buckets.length);  // student number modulo number of buckets
	}


	public void addToTable(EmployeeInfo theEmployee) {
            if (this.getFromTable(theEmployee.getEmpNumber()) == null){
                int i = theEmployee.getEmpNumber() % buckets.length;
                buckets[i].add(theEmployee);
                
            } else {
                System.out.println("Duplicate Emp Num");   
            }
            // Add the student referenced by theStudent to the hash table.
	}


	public EmployeeInfo removeFromTable(int employeeNum) {
		
		int i = employeeNum % buckets.length;
		
		EmployeeInfo removedStudent = getFromTable(employeeNum);
		
		buckets[i].remove(removedStudent);
		
		return removedStudent;
		// Remove that student from the hash table and return the reference value for that student.
		// Return null if that student isn't in the table.
	}

	
	public EmployeeInfo getFromTable(int employeeNum) {

		int i = employeeNum % buckets.length;
		
		for (int y = 0; y < buckets[i].size(); y++) {
			EmployeeInfo currentStudent = buckets[i].get(y);
			if (currentStudent.getEmpNumber() == employeeNum) {
				return currentStudent;
			}
		}
		return null;
	}


	public void displayTable() {
		// Walk through the buckets and display the items in each bucket's ArrayList.	
            System.out.println("\n\nHERE ARE THE CONTENTS OF THE TABLE:");
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i].isEmpty()) {
                    System.out.println("Bucket " + i + " is empty!");
                } else {
                    System.out.println("Bucket " + i + " contains the following:");
                    for (int j = 0; j < buckets[i].size(); j++) {
                            // Bucket i, item j in that bucket's ArrayList
                        System.out.println("    " + buckets[i].get(j).getEmpNumber() + " "
                            + buckets[i].get(j).getFirstName() + " " + buckets[i].get(j).getLastName()
                            + " at position " + j);
                    }
                }
            }
		
	}
        
        
}
