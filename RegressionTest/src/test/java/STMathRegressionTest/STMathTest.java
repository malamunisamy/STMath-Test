package STMathRegressionTest;

import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.sikuli.basics.*;
import org.sikuli.script.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class STMathTest  {

  private static String BaseResPath="C:\\work\\TestAutomationResources";
   	
  private static App firefox;
  public Screen s= null;
  public SikuliUtil sikUtil = new SikuliUtil();
  

  @BeforeClass
  public void beforeClass() {
	  s= new Screen();
	 sikUtil.InitializeSikuli();
  }

  @AfterClass
  public void afterClass() {
	  sikUtil.teardownSikuli();
  }

  @BeforeTest
  public void beforeTest() {
	  sikUtil.FocusSikuliApp();
  }

  @AfterTest
  public void afterTest() {
	  //Get PID of chrome(firefox) 
	  //close the process using PID
	  sikUtil.teardownSikuli();
  }

  @BeforeSuite
  public void beforeSuite() {
	
	     
  }

  @AfterSuite
  public void afterSuite() {

	  
	  
  }

  /* this test is to verify that teacher login works via direct login to TeacherConsole from web.stmath.com
   * 
   */
  @Test
  public void VerifyTeacherLogin() 
  {
	  	  
	try
	{
	 // sikUtil.FocusSikuliApp();
	  System.out.println("VerifyTeacherLogin");
	  TeacherConsoleMgmt teacherConsoleMgmt = new TeacherConsoleMgmt();
	  boolean result = teacherConsoleMgmt.LogintoTeacherConsole(s, sikUtil);
	  Assert.assertTrue(result, "Passed Teacherlogin");
	  //app close is not working properly. need to close the apps.
	}
	catch(Exception ex)
	{
		Assert.assertEquals(1, 2);
	}
	finally
	{
	  
	}
  }
  
 /*https://mindresearch.testrail.com/index.php?/cases/view/24
  * test to verify that teacher can add a class
  */
  @Test
  public void TestAddClassUtility() 
  {
	  System.out.println("Test addclss utility");
	  //Initialize the Sikuli Util that executes certain action in the default screen
	
	  try

	  {
		  //sikUtil.FocusSikuliApp();
		  TeacherConsoleMgmt teacherConsoleMgmt = new TeacherConsoleMgmt();
		  boolean result = teacherConsoleMgmt.LogintoTeacherConsole(s,  sikUtil);
		  Assert.assertTrue(result, "Passed Teacherlogin");
		  
		  Match match=null;
          String addClassRes= BaseResPath+"\\Teacherconsole\\Addclass.png";
          System.out.println(addClassRes);
		  //TODO: remove the hardcoded values for user name , password and match score
          match= sikUtil.ExecuteSearchAction(addClassRes, SikuliUtil.Action.Find,0.2,s);
          if(match !=null)
          {

           	sikUtil.ExecuteAction(match,SikuliUtil.Action.click,null,s);
          }
          else{
        	 	Assert.assertEquals(1,2);
          }
          String AddClassFormRes= BaseResPath+"\\Teacherconsole\\Addclassform.png";
          match= sikUtil.ExecuteSearchAction(AddClassFormRes, SikuliUtil.Action.Find,0.2, s);
          if(match !=null)
          {
           	Assert.assertEquals(1,1);
          }
          else
          {
            	
           	Assert.assertEquals(1,2);
          
          }
            
            	 	  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex);
		  Assert.assertEquals(1, 2);
	  }
	  finally
	  {
		 
	  }
	
  }
  
  /*
   * 
   */
  @Test
  public void TestEditInst() 
  {
	  System.out.println("Test Edit Institution utility");
	  //Initialize the Sikuli Util that executes certain action in the default screen
	  //SikuliUtil sikUtil = new SikuliUtil();
	  //firefox= App.open("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com" );
	  try

	  {
		 // sikUtil.FocusSikuliApp();
		  TeacherConsoleMgmt teacherConsoleMgmt = new TeacherConsoleMgmt();
		  boolean result = teacherConsoleMgmt.LogintoTeacherConsole(s,  sikUtil);
		  Assert.assertTrue(result, "Passed Teacherlogin");
		  
		  Match match=null;
          String UtilRes= BaseResPath+"\\Teacherconsole\\Utilities.png";
          System.out.println(UtilRes);
		  //TODO: remove the hardcoded values for user name , password and match score
          match= sikUtil.ExecuteSearchAction(UtilRes, SikuliUtil.Action.Find,0.2,s);
          if(match !=null)
          {

           	sikUtil.ExecuteAction(match,SikuliUtil.Action.click,null,s);
          }
          else{
        	 	Assert.assertEquals(1,2);
          }
          String EditInstRes= BaseResPath+"\\Teacherconsole\\EditInst\\EditInst.png";
          match= sikUtil.ExecuteSearchAction(EditInstRes, SikuliUtil.Action.Find,0.2, s);
          if(match !=null)
          {
        	  sikUtil.ExecuteAction(match,SikuliUtil.Action.click,null,s);
        	  String ContinueRes= BaseResPath+"\\Teacherconsole\\Utilities.png";
              System.out.println(ContinueRes);
    		  //TODO: remove the hardcoded values for user name , password and match score
              match= sikUtil.ExecuteSearchAction(ContinueRes, SikuliUtil.Action.Find,0.2,s);
              sikUtil.ExecuteAction(match, SikuliUtil.Action.click,null,s);
              match= sikUtil.ExecuteSearchAction(ContinueRes, SikuliUtil.Action.Find,0.2,s);
              sikUtil.ExecuteAction(match, SikuliUtil.Action.click,null,s);
              String duplicateschoolRes= BaseResPath+"\\Teacherconsole\\editinst\\duplicateschool.png";
              System.out.println(ContinueRes);
    		  //TODO: remove the hardcoded values for user name , password and match score
              match= sikUtil.ExecuteSearchAction(duplicateschoolRes, SikuliUtil.Action.Find,0.2,s);
              if(match !=null)
              {
               	Assert.assertEquals(1,1);
              }
              else
              {
                	
               	Assert.assertEquals(1,2);
              
              }
          }
          else
          {
            	
           	Assert.assertEquals(1,2);
          
          }
            
            	 	  
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex);
		  Assert.assertEquals(1, 2);
	  }
	  finally
	  {
		  
		  		  
	  }
  }
  
  /* Login to teacher console using super user account.
   * Upon sucessful login click the drop down to switch dash board view to switch to district view
   * continue
   */
  @Test
  public void TestSwitchView() 
  {
	System.out.println("test switch view");
	try
	{
	 
	 // sikUtil.FocusSikuliApp();
	  TeacherConsoleMgmt teacherConsoleMgmt = new TeacherConsoleMgmt();
	  boolean result = teacherConsoleMgmt.LogintoTeacherConsole(s,  sikUtil);
	  if(result)
	  {
		  Match match=null;
          String dropdownRes= BaseResPath+"\\Teacherconsole\\dropdown.png";
          System.out.println(dropdownRes);
		  //TODO: remove the hardcoded values for user name , password and match score
          match = sikUtil.ExecuteSearchAction(dropdownRes, SikuliUtil.Action.click,0.2,s);
          if ( match!=null)
          {
        	sikUtil.ExecuteAction(match, SikuliUtil.Action.click, null, s);
          }
          else{
        	 	Assert.assertEquals(1,2);
          }
          String switchDashRes= BaseResPath+"\\Teacherconsole\\switchDashboard.png";
          System.out.println(switchDashRes);
          match = sikUtil.ExecuteSearchAction(switchDashRes, SikuliUtil.Action.click,0.2,s);
          if ( match!=null)
          {
        	sikUtil.ExecuteAction(match, SikuliUtil.Action.click, null, s);
          }
          else{
        	 	Assert.assertEquals(1,2);
          }
          String DistrictviewRes= BaseResPath+"\\Teacherconsole\\DistrictView.png";
          System.out.println(DistrictviewRes);
          match = sikUtil.ExecuteSearchAction(DistrictviewRes, SikuliUtil.Action.click,0.2,s);
          if ( match!=null)
          {
        	  String continueRes= BaseResPath+"\\Teacherconsole\\continue.png";
              System.out.println(continueRes);
              match = sikUtil.ExecuteSearchAction(continueRes, SikuliUtil.Action.click,0.2,s);
              sikUtil.ExecuteAction(match, SikuliUtil.Action.click, null, s);
          }
          else{
        	 	Assert.assertEquals(1,2);
          }
          
	  }
	  else
	  {
		  System.out.println("TestSwitchView failed");
		  Assert.assertTrue(result, "can't login to teacherconsole");
	  }
	  //app close is not working properly. need to close the apps.
	}
	catch(Exception ex)
	{
		Assert.assertEquals(1, 2);	
		
	}
	finally
	{
	  
	}
  }

  
 /* @Test
  public void VerifyGradePlacement ()
  {
	  try
	  {
		  Thread.sleep(5000);
		  String teacherloginRes= BaseResPath+"\\Teacherlogin.png";
		  System.out.println(teacherloginRes);
		  Match match = s.find(teacherloginRes);
		  if(match!=null)
		  {
			s.click(match.getCenter());
				
		  }
		  else
		  {
			return;
		  }
			
			
		  Thread.sleep(1000);
		  s.type(null,"minmmunisamy1");
          s.type(Key.TAB);
          s.type(null,"batman");
          s.type(Key.ENTER);
          Thread.sleep(2000);
          String testDriveRes= BaseResPath+"\\TestDrive.png";
          System.out.println(testDriveRes);
          Match testDrMatch= s.find(testDriveRes);
          TeacherConsoleMgmt teacher = new TeacherConsoleMgmt();
          if(testDrMatch!=null)
          {
          	s.click(testDrMatch.getCenter());
          	teacher.NavigateToGrade(BaseResPath, TeacherConsoleMgmt.Grade.SI, "CA", "2013");
          	Assert.assertEquals(1, 1);
          }
         
	  }
	  catch(Exception ex)
	  {
		  System.out.println(ex);
		  Assert.assertEquals(1, 2);
	  }
	
  }*/

}
