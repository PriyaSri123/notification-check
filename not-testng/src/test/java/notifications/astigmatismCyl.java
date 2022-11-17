package notifications;

public class astigmatismCyl {

	public double astigmatismCyl_od(double k1, double k2)
	{
		if(k1 >= k2)
			return (k1-k2); 
		else
			return (k2-k1);
		
	}
	public double astigmatismCyl_os(double k1, double k2)
	{
		if(k1 >= k2)
			return (k1-k2); 
		else
			return (k2-k1);
	}
		
	
}
