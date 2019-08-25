package profit.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.bcel.internal.generic.LSTORE;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

import profit.interfaces.Client_interface;
import profit.interfaces.CloudAdmin_Interface;
import profit.interfaces.Register_Interface;
import profit.interfaces.history_interface;


public class DataBase
{
	
	private Connection con;

	private Random random;

	public DataBase(Connection con) 
	{
		this.con=con;
		random=new Random();
				
	}

	public boolean storeRegister(Register_Interface inter)
	{
		check_table("register");
		check_table("history");
		
		
		String userName=inter.getUserName();
		String password=inter.getPassword();
		String your_name=inter.getYour_Name();
		String dob=inter.getDob();
		String productName=inter.getProduct_Name();
		String cost=inter.getCost();
		String priority=inter.getPriority();
		byte[] img=inter.getImg();
		
		try {
			PreparedStatement pre=con.prepareStatement("insert into register (username,password,yourname,dob,productname,cost,priority,img) values(?,?,?,?,?,?,?,?)");
			pre.setString(1,userName);
			pre.setString(2, password);
			pre.setString(3, your_name);
			pre.setString(4, dob);
			pre.setString(5, productName);
			pre.setString(6, cost);
			pre.setString(7, priority);
			pre.setBytes(8, img);
			if(pre.executeUpdate()>0)
			{
				System.out.println("Data Stored Successfully");
				return true;
			}
			else
			{
				System.out.println("Data stored failed");
				return false;
			}
			
			
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
			return false;
		}
		
		
	
		
	
		
	}

	private boolean check_table(String string)
	{
	try {
		Statement statement=con.createStatement();
		if(string.equals("register"))
		{
	if(statement.executeUpdate("CREATE TABLE IF NOT EXISTS `market`.`"+string+"`  ( `id` int(10) unsigned NOT NULL AUTO_INCREMENT,`username` varchar(45) NOT NULL,`password` varchar(45) NOT NULL,`yourname` varchar(45) NOT NULL,`dob` varchar(45) NOT NULL,`productname` varchar(45) NOT NULL,`cost` varchar(45) NOT NULL,`priority` varchar(45) NOT NULL,`img` longblob NOT NULL,`opassword` varchar(45) ,`rank` varchar(45) ,PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1")>0)
	{
		System.out.println("Table Created Successfully");
		return true;
	}
	else
	{
		System.out.println("Table Creation failed");
	}
		}
else
       {
	statement.executeUpdate("CREATE TABLE IF NOT EXISTS `market`.`history` (`id` int(10) unsigned NOT NULL AUTO_INCREMENT,`pid` varchar(45) NOT NULL,`eid` varchar(45) NOT NULL,`date` varchar(45) NOT NULL,`time` varchar(45) NOT NULL,`rank` varchar(45) NOT NULL,`card` varchar(45) NOT NULL,`ip` varchar(45) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB DEFAULT CHARSET=latin1");
			
		}
		
	} 
	catch (SQLException e) {
	
		e.printStackTrace();
	}
		return false;
	}

	public List<Client_interface> getClientDatas() 
	{
		try {
			Statement stetement=con.createStatement();
			ResultSet resultSet=stetement.executeQuery("SELECT id,productname,priority,img,rank FROM market.register");
			
			List<Client_interface> list=new ArrayList<Client_interface>();
			
			if(resultSet!=null)
			{
			
				resultSet.beforeFirst();
				while(resultSet.next())
				{
					Client_interface client=new Client_interface();
					String id=resultSet.getString(1);
					String name=resultSet.getString(2);
					String priority=resultSet.getString(3);
					String rank=resultSet.getString(5);
					byte[] img=resultSet.getBytes(4);
					
					String encode_imge=getEncode_Image(img);
					
					client.setId(id);
					client.setImg(encode_imge);
					client.setName(name);
					client.setPriority(priority);
					client.setRank(rank);
					
					list.add(client);
				}
				System.out.println("get Client Data list Size::"+list.size());
				return list;
			}
			else
			{
				System.out.println("Result ser Null");
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return null;
	}

	private String getEncode_Image(byte[] img) 
	{
		String image_encode=org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(img);
		System.out.print("Image encoded is::::"+image_encode);
		
		return image_encode;
		
		
	}

	public boolean getProduct_Info(Register_Interface re_interface,String id)
	{
	    try 
	    {
			PreparedStatement statement=con.prepareStatement("select yourname,productname,cost,priority,img from register where id=?");
			
			statement.setString(1,id);
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				String your_name=result.getString(1);
				String product_name=result.getString(2);
				String cost=result.getString(3);
				String priority=result.getString(4);
				byte[] img=result.getBytes(5);
				
				String img_encode=getEncode_Image(img);
				
				re_interface.setYourName(your_name);
				re_interface.setProductName(product_name);
				re_interface.setCost(cost);
				re_interface.setPriority(priority);
				re_interface.setImg(img_encode);
				
				return true;
				
			}
		} 
	    catch (SQLException e) 
	    {
						e.printStackTrace();
						return false;
		}
		return false;
	}

	public List<CloudAdmin_Interface> cloudadmin() 
	{
		try {
			System.out.println("database start---cloudadmin method called");
			PreparedStatement statement=con.prepareStatement("select id,yourname,dob,productname,priority,cost from register");
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			List<CloudAdmin_Interface> list=new ArrayList<CloudAdmin_Interface>();
			while(result.next())
			{
				CloudAdmin_Interface client=new CloudAdmin_Interface();
				String id=result.getString(1);
				String your_Name=result.getString(2);
				String dob=result.getString(3);
				String product_name=result.getString(4);
				String priority=result.getString(5);
				String cost=result.getString(6);
				client.setID(id);client.setYourName(your_Name);client.setDob(dob);client.setProductName(product_name);client.setPriority(priority);client.setCost(cost);
				list.add(client);			
			}
			System.out.println("database cloudadmin methos retur");
			
			return list;
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
	
	
	public boolean update_data(String id,Register_Interface inter)
	{
		System.out.println("update database called");
		
		try {
			PreparedStatement statemetn=con.prepareStatement("update register SET yourname=?, dob=?, productname=?, cost=?, priority=?, img=? where id=?");
			
			statemetn.setString(1,inter.getYour_Name());
			statemetn.setString(2,inter.getDob());
			statemetn.setString(3, inter.getProduct_Name());
			statemetn.setString(4, inter.getCost());
			statemetn.setString(5, inter.getPriority());
			statemetn.setBytes(6, inter.getImg());
			statemetn.setString(7, id);
			if(statemetn.executeUpdate()>0)
			{
				System.out.println("table uypdated successfully:: "+id);
				return true;
			}
			else
			{
				System.out.println("table updation failed");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public void insert_history(String id, String email, String card, String rank, String date, String time, String ip) 
	{
	try {
		PreparedStatement statement=con.prepareStatement("insert into history (pid,eid,date,time,rank,card,ip) values(?,?,?,?,?,?,?)");
		statement.setString(1, id);
		statement.setString(2, email);
		statement.setString(3, date);
		statement.setString(4, time);
		statement.setString(5, rank);
		statement.setString(6, card);
		statement.setString(7, ip);
		if(statement.executeUpdate()>0)
		{
		System.out.println("one row inserted successfully in history table");
		}
		else 
		{
			System.out.println("insert failed in history table");
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	

	public String update_onetime_password(String id)
	{
    String onetime=getRandomno();
    System.out.println("one time password::"+onetime);
    PreparedStatement statement;
	try {
		statement = con.prepareStatement("update register set opassword=? where id=? ");
		statement.setString(1, onetime);
		statement.setString(2, id);
		if(statement.executeUpdate()>0)
		{
		System.out.println("one time password updated successfully");	
		return onetime;
		}
		else
		{
			System.out.println("onetime password updated failed");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
	}

	private String getRandomno()
	{
		return random.nextInt()+"";
		
	}

	public boolean check_mail(String id, String email) 
	{
		try {
			PreparedStatement statement=con.prepareStatement("select * from history where pid=? && eid=?");
			statement.setString(1, id);
			statement.setString(2,email);
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				return false;
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean check_one_time(String id, String password) 
	{
		try {
			PreparedStatement statement=con.prepareStatement("select opassword from register where id=? && opassword=?");
			statement.setString(1, id);
			statement.setString(2, password);
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				update_onetime_password(id);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean check_ssmart_card(String id, String card) 
	{
		try {
			PreparedStatement statement=con.prepareStatement("select * from history where pid=? && card=?");
			statement.setString(1, id);
			statement.setString(2,card);
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				return false;
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;	}
	
	
	public void update_rank_register(String id,String rank)
	{
   
    System.out.println("Register::");
    PreparedStatement statement;
    float ranks=0;
	try {
		statement=con.prepareStatement("select rank from register where id=?");
		statement.setString(1, id);
		ResultSet result=statement.executeQuery();
		result.beforeFirst();
		while(result.next())
		{
			String value=result.getString(1);
			if(value!=null)
			ranks=Float.parseFloat(value);
			ranks=ranks+Float.parseFloat(rank);
		}
		
		statement = con.prepareStatement("update register set rank=? where id=? ");
		statement.setString(1, ranks+"");
		statement.setString(2, id);
		if(statement.executeUpdate()>0)
		{
		System.out.println("one time password updated successfully");	
		}
		else
		{
			System.out.println("onetime password updated failed");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	public void history(Hashtable<String, List<history_interface>> hash) 
	{
		 try {
			PreparedStatement statement=con.prepareStatement("select id from register");
			ResultSet result=statement.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				String id=result.getString(1);
			       PreparedStatement stat=con.prepareStatement("select * from market.history where pid=?");
			       stat.setString(1, id);
			       ResultSet result1=stat.executeQuery();
			        result1.beforeFirst();
			        List<history_interface> his=new ArrayList<>();
			        while(result1.next())
			        {
			        	history_interface inter=new history_interface();
			        	inter.setId(result1.getString(1));
			        	inter.setPid(result1.getString(2));
			        	inter.setEid(result1.getString(3));
			        	inter.setDate(result1.getString(4));
			        	inter.setIdTime(result1.getString(5));
			        	inter.setRank(result1.getString(6));
			        	inter.setCard(result1.getString(7));
			        	inter.setIp(result1.getString(8));
			        	
			        	his.add(inter);
			        }
			        hash.put(id, his);
			        
			       
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean login(String username, String password) 
	{
		try {
			PreparedStatement state=con.prepareStatement("select * from register where username=? && password=?");
			state.setString(1,username);
			state.setString(2, password);
			ResultSet result=state.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean check_aadhaar(String card) 
	{
		try {
			PreparedStatement state=con.prepareStatement("select * from aadhaar.main where key1=?");
			state.setString(1,card);
			
			ResultSet result=state.executeQuery();
			result.beforeFirst();
			while(result.next())
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	

	
	
	
}
