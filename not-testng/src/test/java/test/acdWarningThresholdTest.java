package test;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import notifications.acdWarningThreshold;

public class acdWarningThresholdTest {

	acdWarningThreshold ac;

	@BeforeTest
	public void before_test() {
		ac = new acdWarningThreshold();

	}

	@Test
	public void acd_value_od_test() {
		// ORA RANGE VALUES
		double acd_min_ora_range = 0.7;
		double acd_max_ora_range = 8;

		// USER PREF SET VALUE
		double Exp_acd_value_set = 5; //Make sure valid ora range value is entered. Else UI throw an error.

		// ACD VALUE IN UI
		double Actual_acd_value_od = ac.acd_value_od(4);

		// NOTIFICATION CHECK
		boolean Exp_con = ((Actual_acd_value_od >= acd_min_ora_range) && (Actual_acd_value_od <= acd_max_ora_range));
		if (Exp_con) {
			boolean Exp_con1 = (Actual_acd_value_od < Exp_acd_value_set);
			if (Exp_con1) {
				Reporter.log("ACD Notification should  be seen");
			} else {
				Reporter.log("ACD Notification should not be seen");
			}

		} else {
			Reporter.log("Enter  ACD valid value while adding measurements in UI");
		}

	}

	@Test
	public void acd_value_os_test() {
		// ORA RANGE VALUES
		double acd_min_ora_range = 0.7;
		double acd_max_ora_range = 8;

		// USER PREF SET VALUE
		double Exp_acd_value_set = 3; //Make sure valid ora range value is entered. Else UI throw an error.

		// ACD VALUE IN UI
		double Actual_acd_value_os = ac.acd_value_od(7); 

		// NOTIFICATION CHECK
		boolean Exp_con = ((Actual_acd_value_os >= acd_min_ora_range) && (Actual_acd_value_os <= acd_max_ora_range));
		if (Exp_con) {
			boolean Exp_con1 = (Actual_acd_value_os < Exp_acd_value_set);
			if (Exp_con1) {
				Reporter.log("ACD Notification should  be seen");
			} else {
				Reporter.log("ACD Notification should not be seen");
			}

		} else {
			Reporter.log("Enter valid ACD value while adding measurements in UI");
		}
	}

	@AfterTest
	public void after_test() {
		Reporter.log("ACD Threshold test scenario is executed");
	}

}
