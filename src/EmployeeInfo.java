
public class EmployeeInfo {
	
	
	private int empNumber;
	private String firstName;
	private String lastName;
	private String workLoc; // encoded work location
	private double deductRate;  // overall deduction rate for income
        private String gender;
	
	
	public EmployeeInfo(int empNumber, String firstName, String lastName, String workLoc, double deductRate, String gender) {
		this.setEmpNumber(empNumber);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setWorkLoc(workLoc);
                this.setGender(gender);
		this.deductRate = deductRate;
	}
	
	
	public double calcNetAnnualIncome() {
		return (0.0);
	}


	public int getEmpNumber() {
		return empNumber;
	}


	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

        public String getWorkLoc() {
		return workLoc;
	}


	public void setWorkLoc(String workLoc) {
		this.workLoc = workLoc;
	}

        public double getDeductRate() {
		return deductRate;
	}


	public void setDeductRate(double deductRate) {
		if (deductRate <= 1){
                    this.deductRate = deductRate;
                } else {
                    this.deductRate = 1;
                }
                
	}
        
        public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
        
        
}