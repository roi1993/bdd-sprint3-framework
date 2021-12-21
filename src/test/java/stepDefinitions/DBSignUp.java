package stepDefinitions;

import utilities.DBUtility;

import java.util.List;

public class DBSignUp {
    public static void main(String[] args) {
        DBUtility.createConnection();
        List<String> db=DBUtility.getColumnNames("select * from tbl_user;");
        System.out.println(db);
    }
}
