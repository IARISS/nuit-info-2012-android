package fr.uha.ensisa.iariss.model;

public class Data 
{
	//Type of Data
	private String data;
	
	public Data()
	{
		this.setData(new String());
	}
	
	public Data(String data)
	{
		this.setData(data);
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		this.data = data;
	}
	
	
}
