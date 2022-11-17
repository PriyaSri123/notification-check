import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import notifications.astigmatismCyl;

public class testAstigmatismCyl {
	astigmatismCyl cyl;

	@BeforeTest
	public void before_test() {
		cyl = new astigmatismCyl();

	}

	@Test
	public void cyl_value_os_test() {

		// ORA RANGE VALUES
		double cyl_min_ora_range = 0;
		double cyl_max_ora_range = 20;

		// USER PREF SET VALUE
		double Exp_cyl_set_value_set = 1; // Make sure valid ora range value is entered. Else UI throw an error

		// ACD VALUE IN UI
		double Actual_cyl_value_os = cyl.astigmatismCyl_os(20, 99);
		System.out.println(Actual_cyl_value_os);

		// NOTIFICATION CHECK
		boolean Exp_con = ((Actual_cyl_value_os >= cyl_min_ora_range) && (Actual_cyl_value_os <= cyl_max_ora_range));
		if (Exp_con) {
			boolean Exp_con1 = (Actual_cyl_value_os > (Exp_cyl_set_value_set));
			if (Exp_con1) {
				Reporter.log("Cyl Notification should  be seen");
			} else {
				Reporter.log("Cyl Notification should  not be seen");
			}

		} else {
			Reporter.log("Enter valid k1 and k2 values while adding measurements in UI so that cyl value gets computed properly");
		}
	}

	@Test
	public void cyl_value_od_test() {
		// ORA RANGE VALUES
		double cyl_min_ora_range = 0;
		double cyl_max_ora_range = 20;

		// USER PREF SET VALUE
		double Exp_cyl_set_value_set = 0.5; // Make sure valid ora range value is entered. Else UI throw an error

		// ACD VALUE IN UI
		double Actual_cyl_value_od = cyl.astigmatismCyl_os(44, 43);

		// NOTIFICATION CHECK
		boolean Exp_con = ((Actual_cyl_value_od >= cyl_min_ora_range) && (Actual_cyl_value_od <= cyl_max_ora_range));
		if (Exp_con) {
			boolean Exp_con1 = (Actual_cyl_value_od > (Exp_cyl_set_value_set));
			if (Exp_con1) {
				Reporter.log("Cyl Notification should  be seen");
			} else {
				Reporter.log("Cyl Notification should  not be seen");
			}

		} else {
			Reporter.log("Enter valid k1 and k2 values while adding measurements in UI so that cyl value gets computed properly");
		}
	}

	@AfterTest
	public void after_test() {
		Reporter.log("Astigmatism cyl test scenario is executed");
	}

}
