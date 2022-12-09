
public class FTE extends EmployeeInfo {
	
	
	private double salary;
	
	
	public FTE(int empNumber, String firstName, String lastName, String workLoc, double deductRate, double salary, String gender) {
		super(empNumber, firstName, lastName, workLoc, deductRate, gender);
		this.setSalary(salary);
	}
	
        public double getSalary() {
        return salary;
        }
        
        public void setSalary(double salary) {
        this.salary = salary;
        }
        
        @Override
	public double calcNetAnnualIncome() {
		return ((1.0 - getDeductRate()) * salary);
	}

}
