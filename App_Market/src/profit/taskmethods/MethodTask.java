package profit.taskmethods;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.RIFFInvalidDataException;
import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;

import profit.controller.Controller;
import profit.database.DataBase;
import profit.interfaces.Client_interface;
import profit.interfaces.CloudAdmin_Interface;
import profit.interfaces.Register_Interface;
import profit.interfaces.history_interface;

public class MethodTask
{
	
	DataBase dataBase;
	public MethodTask(DataBase dataBase) 
	{
		this.dataBase=dataBase;
	}

	public void sesller(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("seller method called");
		try {
			response.sendRedirect("register.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void register(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("Register method called");
		Register_Interface inter=new Register_Interface(request);
		dataBase.storeRegister(inter);
		
	}

	public void Client(HttpServletRequest req, HttpServletResponse resp) 
	{
		System.out.println("Client Method Called");
		
		List<Client_interface> reg_interface=dataBase.getClientDatas();
		
		try {
			if(reg_interface!=null)
			{
			System.out.println("Client List Not Null");
			req.setAttribute("interface", reg_interface);
			req.getRequestDispatcher("client.jsp").forward(req, resp);
		}
			else
			{
				System.out.println("List Null Exception");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void client_action(HttpServletRequest req, HttpServletResponse resp) throws InterruptedException
	{
		String id=(String)req.getParameter("id");
		String priority="0";
		Register_Interface re_interface=new Register_Interface();
		
		switch (priority) 
		{
		case "0":
		{
			access_prioritywise(0,re_interface,id,req,resp);
			break;
		}
		case "1":
		{
			access_prioritywise(0,re_interface,id,req,resp);
			break;
		}
		case "2":
		{
			access_prioritywise(0,re_interface,id,req,resp);
			break;
		}
		case "3":
		{
			access_prioritywise(0,re_interface,id,req,resp);
			break;
		}
		case "4":
		{
			access_prioritywise(0,re_interface,id,req,resp);
			break;
		}
				
		

		default:
			access_prioritywise(0,re_interface,id,req,resp);
			System.out.println("default called");
			break;
		}
		
	}

	private void access_prioritywise(int i, Register_Interface re_interface, String id, HttpServletRequest req, HttpServletResponse resp) 
	{
		try {
			Thread.sleep(i);
		
		if(dataBase.getProduct_Info(re_interface,id))
		{
			re_interface.setId(id);
			System.out.println("get Product _info ::true::");
			System.out.println("id in client_action "+id);
			req.setAttribute("interface", re_interface);
			req.getRequestDispatcher("product_info.jsp").forward(req, resp);
			System.out.println("product info dispatched sent to successfully");
		}
		else
		{
			System.out.println("product retrieving Error");
		}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void cloudadmin(HttpServletRequest req, HttpServletResponse resp) 
	{
		System.out.println("Cloud Admin task method called");
		List<CloudAdmin_Interface> list=dataBase.cloudadmin();
		if(list!=null)
		{
			System.out.println("cloudadmin list not null");
			req.setAttribute("interface", list);
			try {
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
			
			e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println(" task method list null");
		}
		
	}

	public void edit(HttpServletRequest req, HttpServletResponse resp) 
	{
		System.out.println("edite method callled");
		String id=req.getParameter("id");
		req.setAttribute("id",id);
		try {
			req.getRequestDispatcher("cloud_edit.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	public void edit_done(HttpServletRequest req, HttpServletResponse resp) 
	{
		Register_Interface reg=new Register_Interface(req);
		
	    String id=req.getParameter("id");
	    System.out.println("id of the edit::"+id);
		
		if(dataBase.update_data(id,reg))
		{
			Client(req, resp);
		}
		else
		{
			try {
				System.out.println("edite_done error page called");
				resp.sendRedirect("error.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public void buy(HttpServletRequest req, HttpServletResponse resp) 
	{
		String  id=req.getParameter("id");
		
		
		req.setAttribute("id",id);
		try {
			req.getRequestDispatcher("buy.jsp").forward(req, resp);
			System.out.println("Request dispatched successfully");
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void buy_done(HttpServletRequest req, HttpServletResponse resp) 
	{
		System.out.println("Buy Done Called ");
		
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		System.out.println("buy_done::id::"+id);
		
		if(dataBase.check_mail(id,email))
		{
		
		
		String pass=dataBase.update_onetime_password(id);
		if(pass!=null)
		send_mail(email,id,pass);
		
		try {
			req.setAttribute("data", "One Time Password Sent To Your Mail");
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		else
		{
			
			req.setAttribute("data","This Id IS Already processed");
		 try {
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
	}

	private boolean send_mail(String to, String id,String pass) 
	{
		System.out.println("Main send called");
		
			
			 final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			 	     Properties props = System.getProperties();
			     props.setProperty("mail.smtp.host", "smtp.gmail.com");
			     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			     props.setProperty("mail.smtp.socketFactory.fallback", "false");
			     props.setProperty("mail.smtp.port", "465");
			     props.setProperty("mail.smtp.socketFactory.port", "465");
			     props.put("mail.smtp.auth", "true");
			     props.put("mail.debug", "true");
			     props.put("mail.store.protocol", "pop3");
			     props.put("mail.transport.protocol", "smtp");
			     final String username = "check.ur.otp.now@gmail.com";//
			     final String password = "otpgmail";
			     try{
			     Session session = Session.getDefaultInstance(props, 
			                          new Authenticator(){
			                             protected PasswordAuthentication getPasswordAuthentication() {
			                                return new PasswordAuthentication(username, password);
			                             }});

			   // -- Create a new message --
			     Message msg = new MimeMessage(session);

			  // -- Set the FROM and TO fields --
			     msg.setFrom(new InternetAddress("check.ur.otp.now@gmail.com"));
			     msg.setRecipients(Message.RecipientType.TO, 
			                      InternetAddress.parse(to,false));
			     msg.setSubject("Hello");
			     
			     msg.setText(" One Time Password Is:"+pass+"\nClick Below link for Rate application:\n\t http://"+Controller.ip+":8080/App_Market/gmail_click?id="+id+"&link="+to);
			     msg.setSentDate(new Date());
			     Transport.send(msg);
			     System.out.println("Mail sent.");
			     return true;
			  }
			     catch (MessagingException e)
			     { System.out.println("Error d'envoi, cause: " + e);
			     return false;
			     }
			
			
		
		
	}

	public void check_one_time(HttpServletRequest req, HttpServletResponse resp) 
	{
		System.out.println("one time password page called");
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try
		{
		if(dataBase.check_one_time(id,password))
		{
		   req.setAttribute("id", id);
		   req.setAttribute("email", email);
		   req.getRequestDispatcher("smart_card.jsp").forward(req, resp);
		}
		else
		{
			req.setAttribute("data", "invalid password");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void check_smart_card(HttpServletRequest req,
			HttpServletResponse resp) 
	{
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String card=req.getParameter("card");
		
		if(dataBase.check_aadhaar(card))
		{
		try
		{
		if(dataBase.check_ssmart_card(id,card))
		{
			req.setAttribute("id",id);
			req.setAttribute("email",email);
			req.setAttribute("card",card);
			req.getRequestDispatcher("radio.jsp").forward(req, resp);
			
		}
		else
		{
			req.setAttribute("data", "You can rate for an app only once");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		else 
		{
			req.setAttribute("data", " Invalid AADHAAR no");
			try {
				req.getRequestDispatcher("error.jsp").forward(req, resp);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Invalid Aadhaar Card Number");
		}
		
	}

	public void rank(HttpServletRequest req, HttpServletResponse resp, String ip) 
	{
	String id=req.getParameter("id");
	String email=req.getParameter("email");
	String card=req.getParameter("card");
	String rating=req.getParameter("account");
	String review=req.getParameter("name");
   float rank=rankAggregation(rating,review);
   
   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
   Calendar cal = Calendar.getInstance();
   String date=dateFormat.format(cal.getTime());
   
   DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
   Calendar cal1 = Calendar.getInstance();
   String time=dateFormat1.format(cal1.getTime());
	
       dataBase.insert_history(id,email,card,""+rank,date,time,ip);
       dataBase.update_rank_register(id,rank+"");
       
		try {
			req.setAttribute("data", "Application Rated Successfully");
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private float rankAggregation(String rating, String review) 
	{
		review=review.toLowerCase();
		float rat=Integer.parseInt(rating);
		if(review.contains("good")||review.contains("excellent")||review.contains("very good"))
		{
			
			return rat+1;
		}
		else if(review.contains("best")||review.contains("ok")||review.contains("better")||review.contains("nice"))
		{
			return rat+0.50f;
		}
		else  if(review.contains("worst")||review.contains("very worst")||review.contains("not nice")||review.contains("use less"))
		{
			return rat+0;
		}
		return 0;
	}

	public void history(HttpServletRequest req, HttpServletResponse resp)
	{
		Hashtable<String,List<history_interface>> hash=new Hashtable<>();
		dataBase.history(hash);
		System.out.println("hash size::"+hash.size());
		try {
			req.setAttribute("data", hash);
			req.getRequestDispatcher("history.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void login(HttpServletRequest req, HttpServletResponse resp)
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		try
		{
		if(dataBase.login(username,password))
		{
			history(req, resp);
		}
		else
		{
			req.setAttribute("data","Invalid Username and Password");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		}
		catch(Exception s)
		{
			s.printStackTrace();
		}
		
	}
	
	

}
