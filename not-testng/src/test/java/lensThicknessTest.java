import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import notifications.lensThickness;

public class lensThicknessTest {

	lensThickness l;

	@BeforeTest
	public void before_test() {
		l = new lensThickness();

	}

	@Test
	public void lt_value_os_test() {
		// ORA RANGE VALUES
		double lt_min_ora_range = 0.7;
		double lt_max_ora_range = 8;

		// USER PREF SET VALUE
		double Exp_lt_min_value_set = 3; // Make sure valid ora range value is entered. Else UI throw an error
		double Exp_lt_max_value_set = 4;// Make sure valid ora range value is entered. Else UI throw an error.

		// ACD VALUE IN UI
		double Actual_lt_value_os = l.lt_value_os(3.99);

		// NOTIFICATION CHECK
		boolean Exp_con = ((Actual_lt_value_os >= lt_min_ora_range) && (Actual_lt_value_os <= lt_max_ora_range));
		if (Exp_con) {
			boolean Exp_con1 = ((Actual_lt_value_os >= Exp_lt_min_value_set) && (Actual_lt_value_os <= Exp_lt_max_value_set));
			if (Exp_con1) {
				Reporter.log("LT Notification should not be seen");
			} else {
				Reporter.log("LT Notification should  be seen");
			}

		} else {
			Reporter.log("Enter valid LT value while adding measurements in UI");
		}
	}

	@Test
	public void lt_value_od_test() {
		// ORA RANGE VALUES
				double lt_min_ora_range = 0.7;
				double lt_max_ora_range = 8;

				// USER PREF SET VALUE
				double Exp_lt_min_value_set = 3; // Make sure valid ora range value is entered. Else UI throw an error
				double Exp_lt_max_value_set = 4;// Make sure valid ora range value is entered. Else UI throw an error.

				// ACD VALUE IN UI
				double Actual_lt_value_od = l.lt_value_os(7);

				// NOTIFICATION CHECK
				boolean Exp_con = ((Actual_lt_value_od >= lt_min_ora_range) && (Actual_lt_value_od <= lt_max_ora_range));
				if (Exp_con) {
					boolean Exp_con1 = ((Actual_lt_value_od >= Exp_lt_min_value_set) && (Actual_lt_value_od <= Exp_lt_max_value_set));
					if (Exp_con1) {
						Reporter.log("LT Notification should not be seen");
					} else {
						Reporter.log("LT Notification should  be seen");
					}

				} else {
					Reporter.log("Enter valid LT value while adding measurements in UI");
				}

	}

	@AfterTest
	public void after_test() {
		Reporter.log("Lens Thickness test scenario is executed");
	}

}
