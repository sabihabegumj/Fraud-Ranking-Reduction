package profit.interfaces;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class Register_Interface 
{
	private String your_Name,dob,productName,cost,priority,userName,password,img_string , id,kk;
	byte[] img;
	

	public String getKk() {
		return kk;
	}

	public void setKk(String kk) {
		this.kk = kk;
	}

	public Register_Interface(HttpServletRequest request)
	{
		if(ServletFileUpload.isMultipartContent(request))
		{
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		try {
			List list=upload.parseRequest(request);
			Iterator iterate=list.iterator();
			
			while (iterate.hasNext()) 
			{
				FileItem item=(FileItem)iterate.next();
				if(item.isFormField())
				{
					String key=item.getFieldName();
					String value=item.getString();
					switch (key) 
					{
					case "name":
					{
						this.your_Name=value;
						break;
					}
					case "dob":
					{
						this.dob=value;
						break;
					}
					case "product":
					{
						this.productName=value;
						break;
					}
					case "cost":
					{
						this.cost=value;
						break;
					}
					case "priority":
					{
						this.priority=value;
						break;
					}
					case "mail":
					{
						this.userName=value;
						System.out.println("user name::"+userName);
						break;
					}
					case "password":
					{
						this.password=value;
						break;
					}

					default:
						System.out.println("none of the request name matched:");
						break;
					}
					
				}
				else
				{
					
					img=item.get();
					System.out.println("file Item in byte length::"+img.length);
					
				}
				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
	
	public Register_Interface() 
	{
		System.out.println("Register_interface object created called");
	}

	public String getUserName() {
		
		return userName;
	}

	public String getYour_Name() {
		
		return your_Name;
	}

	public String getPassword() {
		
		return password;
	}

	public String getDob() {
	
		return dob;
	}

	public String getProduct_Name() {
		
		return productName;
	}

	public String getCost() {
		
		return cost;
	}
	public String getId() {
		return this.id;
			
		}

	public String getPriority() {
	
		return priority;
	}

	public byte[] getImg() {
	
		return img;
	}
	
	public String getImg_String()
	{
		return this.img_string;
	}

	public void setYourName(String your_name2) 
	{
		this.your_Name=your_name2;
		
	}

	public void setProductName(String product_name) 
	{
		this.productName=product_name;
		
	}

	public void setCost(String cost2) {
	this.cost=cost2;
		
	}
	
	public void setId(String id2) {
		this.id=id2;
			
		}

	public void setImg(String img2) 
	{
		this.img_string=img2;
		
	}

	public void setPriority(String priority2) {
		this.priority=priority2;
		
	}

}
