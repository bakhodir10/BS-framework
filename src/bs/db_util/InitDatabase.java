package bs.db_util;

import java.sql.SQLException;
import java.util.Date;

public class InitDatabase {

	static String sql_drop_db;
	static String sql_create_db;
	static String sql_use_db;
	static String db_name;
	static String sql_create_tb_customer;
	static String sql_create_tb_account;
	static String sql_create_tb_histories;

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL;
	static String dbname = "root";
	static String dbpwd = "";

	public static void intiliazieFrameWorkDB() {

		db_name = "db_framework";
		setDefQueries();

	}

	public static void intiliazieBankDB() {

		db_name = "db_bank";
		setDefQueries();

	}
	
	public static void intiliazieCreditCardDB() {

		db_name = "db_bank";
		setDefQueries();

	}

	private static void setDefQueries() {
		sql_drop_db = "drop database IF EXISTS " + db_name + ";";
		sql_create_db = "create database " + db_name + ";";
		sql_use_db = "use " + db_name + ";";
		DB_URL = "jdbc:mysql://localhost:3306/" + db_name;

		sql_create_tb_customer = "create table " + db_name
				+ ".tb_customer(cusid int(20) not null auto_increment primary key, "
				+ "name varchar(20),type varchar(20),street varchar(30), city varchar(30), state varchar(30), "
				+ "zip varchar(30), email varchar(30), bdate datetime, numOfEmployees INTEGER, createddate datetime DEFAULT CURRENT_TIMESTAMP);";

		sql_create_tb_account = "create table " + db_name
				+ ".tb_account(accid int(20) not null auto_increment primary key, "
				+ "accnumber char(30),balance float, cusid int(20), createdtime datetime DEFAULT CURRENT_TIMESTAMP);";

		sql_create_tb_histories = "create table " + db_name
				+ ".tb_history(historyid int(20) not null auto_increment primary key,"
				+ "accid int(20),amount float, type char(20), createdtime datetime DEFAULT CURRENT_TIMESTAMP);";

	}

	private static volatile InitDatabase initdatabase = null;

	private InitDatabase() {
	};

	public static InitDatabase getInitDatabase() {
		if (initdatabase == null) {
			synchronized (InitDatabase.class) {
				if (initdatabase == null) {
					initdatabase = new InitDatabase();
				}
			}
		}
		return initdatabase;
	}

	public static InitDatabase getInitDatabaseJama() {
		if (initdatabase == null) {
			synchronized (InitDatabase.class) {
				if (initdatabase == null) {
					initdatabase = new InitDatabase();
				}
			}
		}
		return initdatabase;
	}

	public static boolean exists_db(String dabasename) {
		int ret;
		try {
			System.out.println("database exists_check");
			String sql_exists_db = "SELECT COUNT(*)		FROM information_schema.schemata "
					+ "		WHERE schema_name = '" + dabasename + "';";
			ret = DbUtil.executUpdate(sql_exists_db, null);
			if (ret == 0) {

				System.out.println("create db error!");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void drop_db() {
		if (exists_db(dbname)) {
			int ret = DbUtil.executUpdate(sql_drop_db, null);
			if (ret != 0) {
				System.out.println("create db error!");
			}
			System.out.println("database already exists!");
			return;
		}
	}

	public void create_db() throws SQLException {
		if (exists_db(dbname)) {
			System.out.println("database already exists!");
			return;
		}

		try {
			int ret = 0;
			DbUtil.createDatabase();
			ret = DbUtil.executUpdate(sql_use_db, null);

			ret = DbUtil.executUpdate(sql_create_tb_customer, null);
			ret = DbUtil.executUpdate(sql_create_tb_account, null);
			ret = DbUtil.executUpdate(sql_create_tb_histories, null);

			InitDatabase.getInitDatabase().addTestData();
			System.out.println("create database well");
			if (ret != 0) {
				System.out.println("create db error!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTestData() {

		int ret = 0;

		/* tb_customer : inserting sample data for the test */

		String sql_insert_tb_user_1 = "INSERT INTO tb_customer (cusid, name, type, street, city, state, zip, email, bdate, numOfEmployees ) "
				+ "  SELECT 66666666, 'jama','P', '1000 North', 'Fairfield', 'Iowa', '52557', 'jbatbayar@mum.edu', GETDATE ( ), 0;";
		ret = DbUtil.executUpdate(sql_insert_tb_user_1, null);
		
		String sql_insert_tb_user_2 = "INSERT INTO tb_customer (cusid, name, type, street, city, state, zip, email, bdate, numOfEmployees ) "
				+ "  SELECT 66666667, 'facebook','C', '1000 North', 'Fairfield', 'Iowa', '52557', 'iam@facebook.com', GETDATE ( ), 1000;";
		ret = DbUtil.executUpdate(sql_insert_tb_user_2, null);

		
		/* tb_account : inserting sample data for the test */
		String sql_insert_tb_account_1 = "INSERT INTO tb_account (accid, accnumber, balance, cusid) "
				+ "  SELECT 88888888, 88888888, 10.0, 66666666;";
		ret = DbUtil.executUpdate(sql_insert_tb_account_1, null);
		String sql_insert_tb_account_2 = "INSERT INTO tb_account (accid, accnumber, balance, cusid) "
				+ "  SELECT 88888888, 88888889, 100.0, 66666667;";
		ret = DbUtil.executUpdate(sql_insert_tb_account_2, null);
		
		
		/* tb_account : inserting sample data for the test */
		String sql_insert_tb_history_1 = "INSERT INTO tb_history (accid, amount, type) "
				+ "  SELECT 88888888, 10.0, 'Type';";		
		ret = DbUtil.executUpdate(sql_insert_tb_history_1, null);
		String sql_insert_tb_history_2 = "INSERT INTO tb_history (accid, amount, type) "
				+ "  SELECT 88888889, 100.0, 'Type';";		
		ret = DbUtil.executUpdate(sql_insert_tb_history_2, null);

	}
}
