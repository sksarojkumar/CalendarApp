package Calendar.App;


import java.text.SimpleDateFormat;
import java.util.Calendar;

class ThreadClass implements Runnable{

	public void run() {
		
		 while(true) {
			 Calendar cal = Calendar.getInstance();
		     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		     String time = sdf.format(cal.getTime());
			
		     if(time.equals("00:00:05")) {
		    	 SendMail sm = new SendMail();
				 sm.sendMail();
		     }
		     else {
		    	 System.out.println("not time");
		    	 String[] tt = time.split(":");
		    	 int hour = (Integer.parseInt(tt[0]) == 0)? 23 : Integer.parseInt(tt[0]);
		    	 int min = (Integer.parseInt(tt[1]) == 0)? 59 : Integer.parseInt(tt[1]) ;
		    	 int sec = (Integer.parseInt(tt[2]) == 0)? 60 : Integer.parseInt(tt[2]);
		    	 
		    	 sec = 60 - sec;
		    	 min = 59 - min;
		    	 hour = 23 - hour;
		    	 sec = sec+ (min*60) +(hour*60*60);
		    	 try {
//		    		 System.out.println("sleep for:"+sec+" time");
					Thread.sleep(1000*sec);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		     }
		 }
	}

}

public class StartPoint {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadClass tc = new ThreadClass();
		Thread t = new Thread(tc);
		t.start();
		
		new MainGui();
	}
}