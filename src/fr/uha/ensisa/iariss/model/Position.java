package fr.uha.ensisa.iariss.model;

public class Position 
{
	private double posX, posy, posZ;

	public Position() 
	{
		this.posX = 0;
		this.posy = 0;
		this.posZ = 0;
	}
	
	public Position(double posX, double posy, double posZ) 
	{
		this.posX = posX;
		this.posy = posy;
		this.posZ = posZ;
	}

	public double getPosX() 
	{
		return posX;
	}

	public void setPosX(double posX) 
	{
		this.posX = posX;
	}

	public double getPosy() 
	{
		return posy;
	}

	public void setPosy(double posy) 
	{
		this.posy = posy;
	}

	public double getPosZ() 
	{
		return posZ;
	}

	public void setPosZ(double posZ) 
	{
		this.posZ = posZ;
	}
	
}
