package com.test.utility;
import java.util.ArrayList;

public class TestUtil {
static Xls_Reader reader;

public static ArrayList<Object[]> getDataFromExcel() {
	
ArrayList<Object[]> myData = new ArrayList<Object[]>();

try 
{
reader= new Xls_Reader("C:\\ExcelData\\DataProvider.xlsx");
} catch (Exception e) {
e.printStackTrace();
}

int rowCount = reader.getRowCount("RegTestData");
for(int rowNum=2; rowNum<=rowCount; rowNum++) {

String firstName = reader.getCellData("RegTestData", "FirstName", rowNum);
String lastName = reader.getCellData("RegTestData", "LastName", rowNum);
String userName = reader.getCellData("RegTestData", "UserName", rowNum);
String password = reader.getCellData("RegTestData", "Password", rowNum);
String confirm = reader.getCellData("RegTestData", "Confirm", rowNum);

Object obj[] = {firstName,lastName, userName, password,confirm };
myData.add(obj);
	
}
return myData;
	
}
}
