package profit.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import profit.database.DataBase;
import profit.taskmethods.MethodTask;

public class Controller extends HttpServlet
{
	
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/market";
	   
	   private MethodTask task;
	   private DataBase dataBase;
	   public static String ip;
	   public static String buy_id;
	
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		
		 try {
				InetAddress address = InetAddress.getLocalHost();
				ip=address.getHostAddress();
				System.out.println("ip address:"+ip);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try 
		{
			ServletContext context=config.getServletContext();
			if(context!=null)
			{
			Class.forName(JDBC_DRIVER);
			Connection con=DriverManager.getConnection(DB_URL,"root", "sabi");
			if(con!=null)
			{
			System.out.println("Jdbc Connection established Successfully");
			context.setAttribute("database_connection", con);
			task=new MethodTask(new DataBase(con));
				
			}
			else
			{
				System.out.println("Jdbc Connection established failed");
			}
			}
			else
			{
				System.out.println("Servlet Context Is null");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
				
				System.out.println("get method called ");
				String uri=req.getRequestURI();
				System.out.println("uri::"+uri);
				
				
				
				
				if(uri.equals("/App_Market/seller.jsp"))
				{
					
					//resp.sendRedirect("register.jsp");
					task.sesller(req, resp);
				}
				else if(uri.equals("/App_Market/user.jsp"))
				{
					//resp.sendRedirect("http://localhost:8080/profit/");
					task.Client(req,resp);
					
				}
				
				else if(uri.equals("/App_Market/buy"))
				{
					task.buy(req,resp);
				}
				
				else if(uri.equals("/App_Market/buy_done"))
				{
					task.buy_done(req,resp);
				}
				
				else if(uri.equalsIgnoreCase("/App_Market/client_action.jsp"))
				{
					try {
						task.client_action(req,resp);
					} 
					catch (InterruptedException e) 
					{
						System.out.println("Thread Interrept Exception:");
						e.printStackTrace();
					}
				}
				else if(uri.equalsIgnoreCase("/App_Market/cloudadmin.jsp"))
				{
					String username=req.getParameter("username");
					String password=req.getParameter("password");
					if(username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("123"))
					{
					System.out.println("cloudadmin request called");
					task.cloudadmin(req,resp);
					}
					else
					{

	                       System.out.println("invalid Username and password");
	                        req.setAttribute("data", "invalid Username and password");
	                        resp.sendRedirect("success.jsp");
					}
				}
				else if(uri.equalsIgnoreCase("/App_Market/edit.jsp"))
				{
					task.edit(req,resp);
				}
				
				else if(uri.equals("/App_Market/gmail_click"))
				{
					String id=req.getParameter("id");
					String email=req.getParameter("link");
					System.out.println("gmaillink called");
					System.out.println("id::"+id);
					System.out.println("email::"+email);
					req.setAttribute("id", id);
					req.setAttribute("email",email);
					
					req.getRequestDispatcher("onetime.jsp").forward(req, resp);
					
					
				}
				
				else if(uri.equalsIgnoreCase("/App_Market/one_time_validate"))
				{
					task.check_one_time(req,resp);
				}
				
				else if(uri.equalsIgnoreCase("/App_Market/smart_card"))
				{
					task.check_smart_card(req,resp);
				}
				

				else if(uri.equalsIgnoreCase("/App_Market/history_1.jsp"))
				{
					task.history(req,resp);
				}
				
				else if(uri.equalsIgnoreCase("/App_Market/purchase_confirmation"))
				{
					String status=req.getParameter("status");
					if(status.equals("yes"))
					{
						req.getRequestDispatcher("buy_id_verification.jsp").forward(req, resp);
					}
					else
					{
						req.getRequestDispatcher("index.jsp").forward(req, resp);

					}
					
				}
				
				else if(uri.equalsIgnoreCase("/App_Market/buy_id_done"))
				{
					String status=req.getParameter("buy_id");
					if(status.equals(buy_id))
					   {
						task.buy(req,resp);					
						}
					else
					{
						req.setAttribute("data", "please make the purchase before  rate the App");
						req.getRequestDispatcher("success.jsp").forward(req, resp);

					}
					
				}
				
				
	
	         }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		
	             System.out.println("post method called");
	             
	             String uri=req.getRequestURI();
	             if(uri.equals("/App_Market/register_done.jsp"))
	             {
	            	 task.register(req, resp);
						task.Client(req,resp);

	            	 
	            	// req.getRequestDispatcher("user.jsp").forward(req, resp);
	             }
	             
	             else if(uri.equalsIgnoreCase("/App_Market/edit_done.jsp"))
	             {
	            	 task.edit_done(req,resp);
	            	          }
	             
	             else if(uri.equalsIgnoreCase("/App_Market/rank"))
	             {
	            	 task.rank(req,resp,ip);
	             }
	             else if(uri.equalsIgnoreCase("/App_Market/login"))
	             {
	            	 task.login(req,resp);
	             }
	             
	             
	             
		
		
	         }

}
