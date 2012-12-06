package fr.uha.ensisa.iariss.model;

public class Data 
{
	//Type of Data
	private int id;
	private String name, description, img;
	private Position pos;
	
	public Data()
	{
		this.id = 0;
		this.name = new String();
		this.description = new String();
		this.img = new String();
		this.pos = new Position();
	}
	
	public Data(int id, String name, String description, String img,
			Position pos) 
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.img = img;
		this.pos = pos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
}
