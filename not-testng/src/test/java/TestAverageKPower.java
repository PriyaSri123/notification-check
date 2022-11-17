import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import notifications.averageKPower;

public class TestAverageKPower{

	averageKPower a1;
	TestAverageKPower t1;
	
	@BeforeTest
	public void before_test()
	{
		 a1 = new averageKPower();
		
	}
	
	@Test
	public void test_averageK_Os()
	{
		//ORA RANGE VALUES
		double average_k_min_ora_range = 30;
		double average_k_max_ora_range = 60;
		
		//USER PREF SET VALUES
		double average_k_min_set = 20;  //Make sure valid ora range value is entered. Else UI throw an error.
		double average_k_max_set = 99;  //Make sure valid ora range value is entered. Else UI throw an error.
		
		//COMPUTED VALUE IN UI
		double Actual_res_os = a1.average_k_power_calculate_od( 44, 95);
		System.out.println("Actual_res_os:" +Actual_res_os);
	
	
		//NOTIFICATION CHECK
		boolean Exp_con = (Actual_res_os >= average_k_min_ora_range) && (Actual_res_os <= average_k_max_ora_range) ;
		
		if(Exp_con)
		{
			boolean Exp_con1 = (Actual_res_os >= average_k_min_set) && (Actual_res_os <= average_k_max_set) ;
			if(Exp_con1)
			{
				Reporter.log("Average K Power Notification should not be seen");
			}
			else
			{
				Reporter.log("Average K Power Notification should  be seen");
			}
			
		}
		else
		{
			Reporter.log("Enter valid K1 and K2 value while adding measurements in UI");
		}
		
	}
	@Test
	public void test_averageK_Od()
	{
		//ORA RANGE VALUES
		double average_k_min_ora_range = 30;
		double average_k_max_ora_range = 60;
		
		//USER_PREF_SET_VALUES
		double average_k_min_set = 45; //Make sure valid ora range value is entered. Else UI throw an error.
		double average_k_max_set = 47;  //Make sure valid ora range value is entered. Else UI throw an error.
		
		//COMPUTED VALUE IN UI
		double Actual_res_od = a1.average_k_power_calculate_od( 45, 46);
		System.out.println("Actual_res_od: "+Actual_res_od);
		
		//NOTIFICATION CHECK
		boolean Exp_con = (Actual_res_od >= average_k_min_ora_range) && (Actual_res_od <= average_k_max_ora_range) ;
		if(Exp_con)
		{
			boolean Exp_con1 = (Actual_res_od >= average_k_min_set) && (Actual_res_od <= average_k_max_set) ;
			if(Exp_con1)
			{
				Reporter.log("Average K Power Notification should not be seen");
			}
			else
			{
				Reporter.log("Average K Power Notification should  be seen");
			}
			
		}
		else
		{
			Reporter.log("Enter valid K1 and K2 value while adding measurements in UI");
		}

	}
	
	@Test
	public void test_averageK_Od_os_diff()
	{
		//ORA RANGE VALUES
		double average_k_diff_min_ora_range = 0; //In  Diopters
		double average_k_diff_max_ora_range = 99; //In  Diopters
				
		//USER_PREF_SET_VALUES
		double average_k_diff_value_set = 0.5; //In User Pref
		
		//COMPUTED VALUE IN UI
		double od_os_diff_act = a1.averageK_diff_OD_OS(45.0,46.1);
		
		//NOTIFICATION CHECK
				boolean Exp_con = (od_os_diff_act >= average_k_diff_min_ora_range) && (od_os_diff_act <= average_k_diff_max_ora_range) ;
				if(Exp_con)
				{
					boolean Exp_con1 = (od_os_diff_act <= average_k_diff_value_set) ;
					if(Exp_con1)
					{
						System.out.println("od_os_diff_act: " +od_os_diff_act);
						Reporter.log("Average K Diff  Notification should not be seen");
					}
					else
					{
						System.out.println("od_os_diff_act: " +od_os_diff_act);
						Reporter.log("Average K Diff  Notification should  be seen");
					}
					
				}
				else
				{
					Reporter.log("Enter valid K1 and K2 value while adding measurements in UI");
				}
				
	}
	
	
	
	@AfterTest
	 public void after_test()
	 {
		Reporter.log("Average K Power test scenario is executed");
	 }
}
