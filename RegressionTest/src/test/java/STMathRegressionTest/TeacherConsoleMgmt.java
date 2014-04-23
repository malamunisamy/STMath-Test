package STMathRegressionTest;

import org.sikuli.script.*;
import org.sikuli.script.Screen;
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
import org.sikuli.api.*;


public class TeacherConsoleMgmt 
{
	private static String BaseResPath="C:\\work\\TestAutomationResources";
	public static enum Grade { SI,Fluency,Prek, TranK, K ,Grade1,Grade2,Grade3,Grade4,Grade5,Grade6};

	public void NavigateToGrade( String BaseResPath, Grade grade, String Region, String Year)
	{
		try
		{
			Screen s = new Screen();
			String _resPath= GenerateImagePath( grade, BaseResPath);
			s.click(_resPath);
		}
		catch( Exception ex)
		{
			
		}
		
	}
	public String GenerateImagePath(Grade grade, String BaseResPath)
	{
		
		String ResPath= null;
		if ( grade == Grade.SI)
		{
			ResPath= BaseResPath+"\\Grade\\SI.png";
		}
		else if ( grade== Grade.Fluency)
		{
			ResPath= BaseResPath+"\\Grade\\Fluency.png";
		}
		else if ( grade== Grade.Prek)
		{
			ResPath = BaseResPath+"\\Grade\\Prek.png";
		}
		else if ( grade== Grade.K)
		{
			ResPath= BaseResPath+"\\Grade\\k.png";
		}
		else if ( grade== Grade.Grade1)
		{
			ResPath= BaseResPath+"\\Grade\\Grade1.png";
		}
		else if ( grade== Grade.Grade2)
		{
			ResPath= BaseResPath+"\\Grade\\Grade2.png";
		}
		else if ( grade== Grade.Grade3)
		{
			ResPath= BaseResPath+"\\Grade\\Grade3.png";
		}
		else if ( grade== Grade.Grade4)
		{
			ResPath= BaseResPath+"\\Grade\\Grade4.png";
		}
		else if ( grade== Grade.Grade5)
		{
			ResPath= BaseResPath+"\\Grade\\Grade5.png";
		}
		else if ( grade== Grade.Grade6)
		{
			ResPath= BaseResPath+"\\Grade\\Grade6.png";
		}
		else
		{
			ResPath= BaseResPath+"\\Grade\\Grade6.png";
		}
			
		return BaseResPath;		
	}
	public boolean LogintoTeacherConsole(Screen s, SikuliUtil sikUtil)
	{
		  try
		  {
			  	System.out.println("i am inside loginteacherconsole");
				//initialize match object
				Match match=null;
				String teacherloginRes= BaseResPath+"\\Teacherlogin.png";
				//System.out.println(teacherloginRes);
				//find the teacherlogin link in the screen and click
				match= s.wait(teacherloginRes);
				//match= sikUtil.ExecuteSearchAction(teacherloginRes, SikuliUtil.Action.Find,0.3, s);
				
				
				if(match!=null)
				{
					sikUtil.ExecuteAction(match,SikuliUtil.Action.click,null,s);

					String JijiconsoleRes= BaseResPath+"\\TeacherConsole\\Jijiconsole.png";
					//System.out.println(JijiconsoleRes);
					//find the teacherlogin link in the screen and click
					match= sikUtil.ExecuteSearchAction(JijiconsoleRes, SikuliUtil.Action.Find,0.3, s);
					if(match!=null)
					{
						Thread.sleep(1000);
						// user name and password for teacher login will need to come from the configuration. 
						//TODO: remove the hardcoded values for user name , password and match score
						//sikUtil.ExecuteAction(null, SikuliUtil.Action.type, Key.TAB,s);
						sikUtil.ExecuteAction(null, SikuliUtil.Action.type, "minmmunisamy1",s);
						sikUtil.ExecuteAction(null, SikuliUtil.Action.type, Key.TAB,s);
						sikUtil.ExecuteAction(null, SikuliUtil.Action.type, "batman",s);
						sikUtil.ExecuteAction(null, SikuliUtil.Action.type, Key.ENTER,s);
						Thread.sleep(2000);
			            String testDriveRes= BaseResPath+"\\Teacherconsole\\TestDrive.png";
			           // System.out.println(testDriveRes);
						//TODO: remove the hardcoded values for user name , password and match score
			            match= sikUtil.ExecuteSearchAction(testDriveRes, SikuliUtil.Action.Find,0.2,s);
			            if(match !=null)
			            {
			            	System.out.println("found the match");
			            	 System.out.println("exiting teacher console");
			            	return true;
			            }
			            else
			            {
			            	 System.out.println("exiting teacher console");
			            	return false;
			            }
		            
					}
					else{
						return false;
						
					}
				}
				else
				{
					System.out.println("no match of teacher login");
					return false;
				}
				
		  }
		  catch(Exception ex)
		  {
			  System.out.println(ex);
			  return false;
		  }

	}

}
