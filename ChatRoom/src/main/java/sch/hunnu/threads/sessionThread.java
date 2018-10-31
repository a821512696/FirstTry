package sch.hunnu.threads;

import javax.servlet.http.HttpSession; 


public class sessionThread implements Runnable{
	
	private HttpSession session ;
	
	public sessionThread(HttpSession s){
		this.session =s;						//锁定一个session
	}
	
	@Override
	public void run() {
		 
			Long oldTime ;
			String sid = session.getId();
			while(true){
			
				try {
					Thread.sleep(60000);		//休息一分钟
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try{
				oldTime =	(Long)session.getAttribute("sLife");
				}catch(Exception ex){
					ex.printStackTrace();
					break;
				}
				if(System.currentTimeMillis()-oldTime>2*60000){		//2分钟后超时
				break;	
				}	
				//System.out.println(session.getId()+" "+System.currentTimeMillis()+" - "+oldTime+" = "+(System.currentTimeMillis()-oldTime));
				
			}
			//System.out.println("session true 凉了");
			session.invalidate();			//关闭session 代表着用户超时 然后下线
	}
	
}
