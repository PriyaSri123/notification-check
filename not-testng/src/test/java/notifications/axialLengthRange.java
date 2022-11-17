package notifications;

public class axialLengthRange {
	
	public double axialLength_od_check(double al)
	{
		return al;
	}
	public double axialLength_os_check(double al)
	{
		return al;
	}
	 public double axialLength_OD_OS(double al_od,double al_os)
		{
			if(al_od<=al_os)
				return al_os-al_od; 
			else
				return al_od-al_os; 
	       
		}

}
