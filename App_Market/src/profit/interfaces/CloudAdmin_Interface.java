package profit.interfaces;

public class CloudAdmin_Interface 
{
	
	private String id,yourName,productName,cost,dob,priority;

	public void setID(String id) 
	{
		this.id=id;
		
	}

	public void setYourName(String your_Name)
	{
		this.yourName=your_Name;
		
	}

	public void setDob(String dob)
	{
		this.dob=dob;
		
	}

	public void setPriority(String priority) 
	{
		this.priority=priority;
		
	}

	public void setCost(String cost) {
	this.cost=cost;
		
	}
	
	
	public String getId()
	{
		return this.id;
	}
	public String getYourName()
	{
		return this.yourName;
	}
	public String getDob()
	{
		return this.dob;
	}
	public String getPriority()
	{
		return this.priority;
	}
	public String getCost()
	{
		return this.cost;
	}
	public String getProductName()
	{
		return this.productName;
	}

	public void setProductName(String product_name) 
	{
	this.productName=product_name;
		
	}

}
