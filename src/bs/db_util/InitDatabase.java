package bs.db_util;

import java.sql.SQLException;
import java.util.Date;

public class InitDatabase {

	static String sql_drop_db = "drop database IF EXISTS db_framework;";
	static String sql_create_db = "create database db_framework;";
	static String sql_use_db = "use db_framework;";

	static String sql_create_tb_customer = "create table db_framework.tb_customer(cusid int(20) not null auto_increment primary key,"
			+ "name varchar(20),type varchar(20),street varchar(30), city varchar(30), state varchar(30), "
			+"zip varchar(30), email varchar(30), bdate datetime, numOfEmployees INTEGER, createddate datetime DEFAULT CURRENT_TIMESTAMP);";
	
	
	

	static String sql_create_tb_course = "create table db_framework.tb_account(courseid int(20) not null auto_increment primary key,"
			+ "coursename char(30),professorid char(20),professorname char(30),prerequisiteCourseId int(20) null,createdtime datetime DEFAULT CURRENT_TIMESTAMP);";
	
	
	
	static String sql_create_tb_section = "create table db_framework.tb_section(sectionid int(20) not null auto_increment primary key,"
			+ "userid int(20),courseid int(20),createdtime datetime DEFAULT CURRENT_TIMESTAMP);";
	
	static String sql_create_tb_material = "create table db_framework.tb_material(materialid int(20) not null auto_increment primary key,"
			+ " courseid int(20), materialname char(60),filetype char(30),fileurl char(30),uploadedtime datetime DEFAULT CURRENT_TIMESTAMP);";

	static String sql_create_tb_feedback = "create table db_framework.tb_feedback(feedbackid int(20) not null auto_increment primary key,"
			+ "userid int(20),usertype int(6),username char(20),content char(255),  courseid int(20), replyfeedbackid int(20) null, createdtime datetime DEFAULT CURRENT_TIMESTAMP);";

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/db_framework";
	final static String dbname = "root";
	final static String dbpwd = "";
	
	private static volatile InitDatabase initdatabase = null;
	private InitDatabase(){};
	
	public static InitDatabase getInitDatabase(){
        if(initdatabase == null){
            synchronized (InitDatabase.class){
                if(initdatabase == null){
                	initdatabase = new InitDatabase();
                }
            }
        }
        return initdatabase;
    }
	public static InitDatabase getInitDatabaseJama(){
        if(initdatabase == null){
            synchronized (InitDatabase.class){
                if(initdatabase == null){
                	initdatabase = new InitDatabase();
                }
            }
        }
        return initdatabase;
    }
	
	public static boolean exists_db(String dabasename) {
		int ret;
		try{
			System.out.println("database exists_check");
			String sql_exists_db = "SELECT COUNT(*)\n" + 
				"		FROM information_schema.schemata\n" + 
				"		WHERE schema_name = '"+dabasename+"';";
			ret  = DbUtil.executUpdate(sql_exists_db, null);
			if (ret == 0) {
				
				System.out.println("create db error!");	
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public void drop_db() {
		if(exists_db(dbname)) {
			int ret  = DbUtil.executUpdate(sql_drop_db, null);
			if (ret !=0) {
				System.out.println("create db error!");
			}
			System.out.println("database already exists!");	
			return ;
		}
	}
	
	public void create_db() throws SQLException {
		if(exists_db(dbname)) {
			System.out.println("database already exists!");	
			return;
		}

			try
			{
				int ret  = 0 ;
				DbUtil.createDatabase();
//				ret  = DbUtil.executUpdate(sql_drop_db, null);
//				ret  = DbUtil.executUpdate(sql_create_db, null);
				ret  = DbUtil.executUpdate(sql_use_db, null);

				ret  = DbUtil.executUpdate(sql_create_tb_customer, null);
				ret  = DbUtil.executUpdate(sql_create_tb_course, null);
				ret  = DbUtil.executUpdate(sql_create_tb_section, null);
				ret  = DbUtil.executUpdate(sql_create_tb_material, null);
				ret  = DbUtil.executUpdate(sql_create_tb_feedback, null);
				InitDatabase.getInitDatabase().addTestData();
				System.out.println("create database well");
				if (ret !=0) {
					System.out.println("create db error!");
				}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	
	public void addTestData(){

		int ret  = 0 ;
		
		/*tb_user : inserting sample data for the test*/
		
		String sql_insert_tb_user_1 = "INSERT INTO tb_user (userid, username, usertype, emailaddress)\n" + 
				"  SELECT 88888888,'jama', 100000, 'jbatbayar@mum.edu';";
		ret  = DbUtil.executUpdate(sql_insert_tb_user_1, null);
		
		String sql_insert_tb_user_2 = "INSERT INTO tb_user (userid, username, usertype, emailaddress)\n" + 
				"		  SELECT 88888889, 'xiubao', 100000, 'xhui@mum.edu';";
		
		ret  = DbUtil.executUpdate(sql_insert_tb_user_2, null);
		
		String sql_insert_tb_user_3 = "INSERT INTO tb_user (userid, username, usertype, emailaddress)\n" + 
				"		  SELECT 88888890, 'shafqat', 200000, 'shshaqfat@mum.edu';";
	
		ret  = DbUtil.executUpdate(sql_insert_tb_user_3, null);
		
		/*tb_course : inserting sample data tb_course for the test*/
		String sql_insert_tb_course1 = "INSERT INTO tb_course (courseid, coursename, professorid, professorname)\n" + 
				"  SELECT 66666666,'EL101', 88888890, 'shafqat';";
		ret  = DbUtil.executUpdate(sql_insert_tb_course1, null);
		
		String sql_insert_tb_course_2 = "INSERT INTO tb_course (courseid, coursename, professorid, professorname)\n" + 
				"  SELECT 66666667,'EL102', 88888890, 'shafqat';";
		ret  = DbUtil.executUpdate(sql_insert_tb_course_2, null);
		
		String sql_insert_tb_course_3 = "INSERT INTO tb_course (courseid, coursename, professorid, professorname)\n" + 
				"  SELECT 66666668,'EL103', 88888890, 'shafqat';";
		ret  = DbUtil.executUpdate(sql_insert_tb_course_3, null);
		
		String sql_insert_tb_course_4 = "INSERT INTO tb_course (courseid, coursename, professorid, professorname)\n" + 
				"  SELECT 66666669,'TOEFL_PREP', 88888890, 'shafqat';";

		ret  = DbUtil.executUpdate(sql_insert_tb_course_4, null);
		

		/*tb_section : inserting sample data for the test*/
		String sql_insert_tb_section_1 = "INSERT INTO tb_section (userid, courseid)\n" + 
				"  SELECT 88888888, 66666666;";
		
		ret  = DbUtil.executUpdate(sql_insert_tb_section_1, null);
		
		String sql_insert_tb_section_2 = "INSERT INTO tb_section (userid, courseid)\n" + 
				"  SELECT 88888888, 66666667;";
		
		ret  = DbUtil.executUpdate(sql_insert_tb_section_2, null);
		
		String sql_insert_tb_section_3 = "INSERT INTO tb_section (userid, courseid)\n" + 
				"  SELECT 88888889, 66666667;";
		ret  = DbUtil.executUpdate(sql_insert_tb_section_3, null);
		
		
		/*tb_material : inserting sample data for the test*/
		String sql_insert_tb_material_1 = "INSERT INTO tb_material (materialname, filetype, fileurl, courseid)\n" + 
				"  SELECT 'test_material1', 'txt', 'https://fb.com', 66666666;";
		ret  = DbUtil.executUpdate(sql_insert_tb_material_1, null);
		
		String sql_insert_tb_material_2 = "INSERT INTO tb_material (materialname, filetype, fileurl, courseid)\n" + 
				"  SELECT 'test_material2', 'txt', 'https://fb.com', 66666666;";
		ret  = DbUtil.executUpdate(sql_insert_tb_material_2, null);
		
		String sql_insert_tb_material_3 = "INSERT INTO tb_material (materialname, filetype, fileurl, courseid)\n" + 
				"  SELECT 'test_material3', 'txt', 'https://fb.com', 66666666;";
		ret  = DbUtil.executUpdate(sql_insert_tb_material_3, null);
		
		String sql_insert_tb_material_4 = "INSERT INTO tb_material (materialname, filetype, fileurl, courseid)\n" + 
				"  SELECT 'test_material4', 'txt', 'https://fb.com', 66666667;";
		ret  = DbUtil.executUpdate(sql_insert_tb_material_4, null);
		
		String sql_insert_tb_material_5 = "INSERT INTO tb_material (materialname, filetype, fileurl, courseid)\n" + 
				"  SELECT 'test_material5', 'txt', 'https://fb.com', 66666667;";
		ret  = DbUtil.executUpdate(sql_insert_tb_material_5, null);
		
		/*tb_feedback : inserting sample data for the test*/
		String sql_insert_feedback_1 = "INSERT INTO tb_feedback (feedbackid, userid, usertype, username, content, courseid)\n" + 
				"		  SELECT 22222222, 88888888, 100000, 'jama', 'this is test comment on EL101', 66666666;";
		ret  = DbUtil.executUpdate(sql_insert_feedback_1, null);
		
		String sql_insert_feedback_2 = "INSERT INTO tb_feedback (feedbackid, userid, usertype, username, content, courseid, replyfeedbackid)\n" + 
				"		  SELECT 22222223, 88888890, 200000, 'shafqat', 'this is test reply comment on jama s comment', 66666666, 22222222;";
		ret  = DbUtil.executUpdate(sql_insert_feedback_2, null);
				
	}
}
