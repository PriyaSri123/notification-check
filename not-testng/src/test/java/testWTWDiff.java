import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import notifications.wtwDifference;

public class testWTWDiff {
	
	wtwDifference w1;
	
	@BeforeTest
	public void beforetest()
	{
		w1 = new wtwDifference();
	}
	

	@Test
	public void test_wtw_Od_os_diff()
	{
		//ORA RANGE VALUES
		double wtw_diff_min_ora_range = 0; //In  Diopters
		double wtw_diff_max_ora_range = 16; //In  Diopters
				
		//USER_PREF_SET_VALUES
		double wtw_diff_value_set = 0.5;  //In User Pref
		
		//COMPUTED VALUE IN UI
		double od_os_wtw_diff_act = w1.wtw_diff_calc(10, 12);
		
		//NOTIFICATION CHECK
				boolean Exp_con = (od_os_wtw_diff_act >= wtw_diff_min_ora_range) && (od_os_wtw_diff_act <= wtw_diff_max_ora_range) ;
				if(Exp_con)
				{
					boolean Exp_con1 = (od_os_wtw_diff_act <= wtw_diff_value_set) ;
					if(Exp_con1)
					{
						System.out.println("od_os_wtw_diff_act: " +od_os_wtw_diff_act);
						Reporter.log("WTW Diff Notification should not be seen");
					}
					else
					{
						System.out.println("od_os_wtw_diff_act: " +od_os_wtw_diff_act);
						Reporter.log("WTW Diff Notification should be seen");
					}
					
				}
				else
				{
					Reporter.log("Enter valid WTW value while adding measurements in UI");
				}
				
	}
	

}
