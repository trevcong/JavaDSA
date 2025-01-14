package testFX2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Toolkit;


public class TimerTask1 {
	

	
	public static ArrayList<String> llist = new ArrayList<String>();
	//Toolkit toolkit;
	
	//Iterator<String> it = llist.iterator();
	
	
	//String g;
	
	
	

	public void add(String add) {
		llist.add(add);
	}
	
	public void remove() {
		//it.remove();
	}
	
	
//	b.setOnAction(event -> {
//		del = (int) sp.getValue();
//		//schedule the timer
//		tm.schedule(new subtimer(), del*1000);
//		});
	
	public ArrayList<String> getLList() {
		return llist;
	}
	
	/**
	public static void main(String args[]) {
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				while(!llist.isEmpty()) {
					for(int i = 0; i < llist.size(); i++) {
						System.out.println(llist);
					}
					
					
					}
						
			}
			
		};
		timer.scheduleAtFixedRate(task, 0, 3000);
while(!ts.getLList().isEmpty()) {
							for(int i = 0; i < ts.getLList().size(); i++) {
								timer.schedule(new TimerTask() {
						            @Override
						             public void run() {
						            	 ts.displayTimerMessage(ts.getLList())
						             }
						         }, (3000));
								
								
		
		}
		**/
	}
	
	
	
	
	


