package profit.interfaces;

public class Client_interface 
{
	
	private String id;
	private String priority;
	private String img;
	private String name;
	private String rank;
	
	public void setId(String id)
	{
		this.id=id;
	}
	public void setPriority(String priority)
	{
		this.priority=priority;
	}
	public void setImg(String img) 
	{
		this.img=img;
		
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getID()
	{
		return this.id;
	}
	public String getPriority()
	{
		return this.priority;
	}
	public String getImg()
	{
		return this.img;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getRank()
	{
		return this.rank;
	}
	public void setRank(String rank) 
	{
		if(rank==null)
		{
		this.rank=0+"";
		}
		else
		{
		this.rank=rank;
		}
		
	}

}
