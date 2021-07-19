package reader;

public class Building {
	private String city, street, house, floor;
	private Integer count;
	
	public Building(String city, String street, String house, String floor) {
		this.city = city;
		this.street = street;
		this.house = house;
		this.floor = floor;
		this.count = 1;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
   @Override
   public int hashCode()
   {
      return city.hashCode() + street.hashCode() + house.hashCode() + floor.hashCode();
   }

   @Override
   public boolean equals(Object obj)
   {
      if (obj == null)
	      {
	         return false;
	      }
      if (this == obj)
	      {
	         return true;
	      }
      if (this.getClass() != obj.getClass())
	      {
	         return false;
	      }
      final Building other = (Building) obj;
      if (this.city == null ? other.city != null : !this.city.equals(other.city))
	      {
	         return false;
	      }
      if (this.street == null ? other.street != null : !this.street.equals(other.street))
	      {
	         return false;
	      }
      if (this.house == null ? other.house != null : !this.house.equals(other.house))
	      {
	         return false;
	      }
      if (this.floor == null ? other.floor != null : !this.floor.equals(other.floor))
	      {
	         return false;
	      }

      return true;
   }
	
}