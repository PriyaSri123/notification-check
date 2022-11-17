package notifications;

public class averageKPower {
	
	
	
	averageKPower a1;
	 public double average_k_power_calculate_od(double k1, double k2)
	{
		 double km1 = (k1 + k2)*0.5;
	    return km1;

		
	}
	 public double average_k_power_calculate_os(double k1, double k2)
	{
		 double km2 = (k1 + k2)*0.5;
	    return km2;
		
	}
	 public double averageK_diff_OD_OS(double km1,double km2)
	{
		if(km1<=km2)
			return km2-km1;
		else
			return km1-km2;
       
	}
}
