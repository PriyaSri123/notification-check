package notifications;

public class wtwDifference {

	 public double wtw_diff_calc(double wtwod, double wtwos)
		{
			if(wtwod<=wtwos)
				return wtwos-wtwod;
			else
				return wtwod-wtwos;		
		}
}
