package test;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import notifications.axialLengthRange;

public class axialLengthRangeTest{
	
	
	axialLengthRange al;

	@BeforeTest
	public void before_test() {
		al = new axialLengthRange();

	}

	@Test
	public void test_axialLength_Od_os_diff()
	{
		//ORA RANGE VALUES
		double al_min_ora_range = 0; //In  Diopters
		double al_max_ora_range = 40; //In  Diopters
				
		//USER_PREF_SET_VALUES
		double average_al_diff_value_set = 0.5; //In User Pref
		
		//COMPUTED VALUE IN UI
		double od_os_al_diff_act = al.axialLength_OD_OS(22.0, 23.8);
		
		//NOTIFICATION CHECK
				boolean Exp_con = (od_os_al_diff_act >= al_min_ora_range) && (od_os_al_diff_act <= al_max_ora_range) ;
				if(Exp_con)
				{
					boolean Exp_con1 = (od_os_al_diff_act <= average_al_diff_value_set) ;
					if(Exp_con1)
					{
						System.out.println("od_os_al_diff_act: " +od_os_al_diff_act);
						Reporter.log("Axial Length Diff  Notification should not be seen");
					}
					else
					{
						System.out.println("od_os_al_diff_act: " +od_os_al_diff_act);
						Reporter.log("Axial Length Diff  Notification should  be seen");
					}
					
				}
				else
				{
					Reporter.log("Enter valid AL value while adding measurements in UI");
				}
				
	}
	

	@AfterTest
	public void after_test() {
		Reporter.log("Axial Length test scenario is executed");
	}


}
