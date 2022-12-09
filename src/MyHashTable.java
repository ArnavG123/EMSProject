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
		int i = theEmployee.getEmpNumber() % buckets.length;
		buckets[i].add(theEmployee);
		return;
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
        
        public String saveToFile(){
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd HH,mm,SS");
            String directory = System.getProperty("user.dir");
            String fileName = "SaveEMS"+dateTimeFormat.format(now)+".txt";
            
            File myFile = new File(directory, fileName);
            try {
                myFile.createNewFile();
                FileWriter fileWriter = new FileWriter(fileName);
                for (ArrayList<EmployeeInfo> bucket : buckets) {
                    for (int j = 0; j < bucket.size(); j++) {
                        if (bucket.get(j) instanceof FTE targetFTE) {
                            String fileContent = "FTE " + targetFTE.getEmpNumber() + " " + targetFTE.getFirstName() + " " + 
                                    targetFTE.getLastName() + " " + targetFTE.getWorkLoc() + " " + targetFTE.getDeductRate()
                                    + " " + targetFTE.getSalary() + " " + targetFTE.getGender();
                            fileWriter.write(fileContent);
                        } else if (bucket.get(j) instanceof PTE targetPTE){
                            String fileContent = "PTE " + targetPTE.getEmpNumber() + " " + targetPTE.getFirstName() + " " + 
                                    targetPTE.getLastName() + " " + targetPTE.getWorkLoc() + " " + targetPTE.getDeductRate()
                                    + " " + targetPTE.getHourlyWage() + " " + targetPTE.getHoursPerWeek() + " " + targetPTE.getWeeksPerYear() + targetPTE.getGender();
                            fileWriter.write(fileContent);
                        }
                    }
                }
                
                fileWriter.close();
                return "File created: " + myFile.getName();
            } catch (IOException e) {
                e.printStackTrace();
                return "An error occurred.";
                               
            }
        }
}
