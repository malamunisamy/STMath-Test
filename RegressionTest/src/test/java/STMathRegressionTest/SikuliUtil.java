package STMathRegressionTest;

import org.sikuli.script.App;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.sikuli.basics.*;



public class SikuliUtil 
{
	public static enum Action { click,type,Find,FindAll,exists,doubleclick,rightclick};
	//public Screen s= null;
	
	
	//initialize Sikuli
	public void InitializeSikuli()
	{
		System.out.println("inside initializeSikuli");
	/*	WinUtil winUtil = new WinUtil();
		winUtil.openApp("C:\\Program Fies (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com");
		*/
		App.open("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com" );
	}
	public void FocusSikuliApp()
	{
		App.focus("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com");
	}
	public void teardownSikuli()
	{
		System.out.println("inside teardownSikuli");
		/*WinUtil winUtil = new WinUtil();
		winUtil.closeApp("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com");
		*/
		App.close("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://web.stmath.com");
		
		
	}
	
	public void ExecuteAction( Match ResPath, Action action , String toType, Screen s) 
			
	{
	
		if(s!=null)
		{
			try
			{
				if(action== Action.click)
				{
					Thread.sleep(3000);
					s.click(ResPath);		
					
					
				}
				else if( action == Action.doubleclick)
				{
					Thread.sleep(3000);
					s.doubleClick(ResPath);
				}
				else if ( action== Action.rightclick)
				{
					Thread.sleep(3000);
					s.rightClick(ResPath);
				}
				else if ( action== Action.type)
				{
					Thread.sleep(3000);
					s.type(toType);					
				}
				
			}
			catch( Exception ex)
			
			{
				System.out.println(ex);
			}
		}
		else
		{
			return;
		}
		
	}
	public Match ExecuteSearchAction( String ResPath, Action searchAction, double matchScore, Screen s)
	{
		Match sMatch= null;
	    Settings.MinSimilarity=matchScore;
	    
		
		if(s!=null)
		{
			try
			{
			    Thread.sleep(5000);
				if(searchAction== Action.exists)
				{
					Thread.sleep(2000);
					sMatch= s.exists(ResPath,matchScore);
					
				}
				else if( searchAction == Action.Find)
				{
					//Settings.MinSimilarity=0.2;
					Thread.sleep(2000);
					sMatch= s.find(ResPath);
				
				}
				//not implemented
				else if ( searchAction== Action.FindAll)
				{
					Thread.sleep(2000);
					sMatch= null;
				}
				else
				{
					sMatch=null;
				}
				return sMatch;
			}
			catch( Exception ex)
			{
				System.out.println(ex);
				return sMatch;
			}
		}
		else
		{
			return null;
		}
	}
	

}
