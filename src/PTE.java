
public class PTE extends EmployeeInfo {
	
	
	public double hourlyWage;
	public double hoursPerWeek;
	public double weeksPerYear;
	
	
	public PTE(int empNumber, String firstName, String lastName, String workLoc, double deductRate, double hourlyWage, double hoursPerWeek, double weeksPerYear, String gender) {
            super(empNumber, firstName, lastName, workLoc, deductRate, gender);
            this.setHourlyWage(hourlyWage);
            this.setHoursPerWeek(hoursPerWeek);
            this.setWeeksPerYear(weeksPerYear);
	}
	
	public double getHourlyWage() {
            return hourlyWage;
	}


	public void setHourlyWage(double hourlyWage) {
            if (hourlyWage < 0){
                this.hourlyWage = 0;
            } else {
                this.hourlyWage = hourlyWage;
            }
            
	}
        
        public double getHoursPerWeek() {
            return hoursPerWeek;
	}


	public void setHoursPerWeek(double hoursPerWeek) {
            if (hoursPerWeek < 0){
                this.hoursPerWeek = 0;
            } else {
                this.hoursPerWeek = hoursPerWeek;
            }
	}
        
        public double getWeeksPerYear() {
            return weeksPerYear;
        }


	public void setWeeksPerYear(double weeksPerYear) {
            if (weeksPerYear < 0){
                this.weeksPerYear = 0;
            } else {
                this.weeksPerYear = weeksPerYear;
            }
            
	}
        
        @Override
	public double calcNetAnnualIncome() {
		return ((1.0 - getDeductRate()) * hourlyWage * hoursPerWeek * weeksPerYear);
	}


}
