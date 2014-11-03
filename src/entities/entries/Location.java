package entities.entries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Relatable;
import entities.entries.history.Action;


/**
 * Entity implementation class for Entity: Location
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Location.findAll", query = "select l from Location l") })
public class Location extends Entry {

	private static final long serialVersionUID = -5026404539659981489L;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;
	private String area;
	private Coordinate coordinate;
	private String occupancy;
	private String elevation;
	private String premiseType;



	public Location() {
		super();
		this.type = "Location";
		this.coordinate = new Coordinate();
	}



	public Location(String area, Coordinate coordinate, String occupancy, String elevation, String premiseType) {
		super();
		this.type = "Location";
		this.area = area;
		this.coordinate = coordinate;
		this.occupancy = occupancy;
		this.elevation = elevation;
		this.premiseType = premiseType;
	}



	public List<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}



	public void addAddress(Address address) {
		if (this.addresses == null)
			this.addresses = new ArrayList<Address>();

		this.addresses.add(address);
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public Coordinate getCoordinate() {
		return coordinate;
	}



	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}



	public void setCoordinate(long x, long y, long z) {
		if (this.coordinate == null)
			this.coordinate = new Coordinate();

		this.coordinate.x = x;
		this.coordinate.y = y;
		this.coordinate.z = z;
	}



	public String getOccupancy() {
		return occupancy;
	}



	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}



	public String getElevation() {
		return elevation;
	}



	public void setElevation(String elevation) {
		this.elevation = elevation;
	}



	public String getPremiseType() {
		return premiseType;
	}



	public void setPremiseType(String premiseType) {
		this.premiseType = premiseType;
	}



	@Override
	public void logChanges(Object old) {
		Location oldL = (Location) old;

		if (!this.area.equals(oldL.area))
			this.getHistory().addAction(new Action("area", this.area, oldL.area));

		if (!this.coordinate.isEqual(oldL.coordinate))
			this.getHistory().addAction(
					new Action("coordinate", this.coordinate.toString(), oldL.coordinate.toString()));

		if (!this.occupancy.equals(oldL.occupancy))
			this.getHistory().addAction(new Action("occupancy", this.occupancy, oldL.occupancy));

		if (!this.elevation.equals(oldL.elevation))
			this.getHistory().addAction(new Action("elevation", this.elevation, oldL.elevation));

		if (!this.premiseType.equals(oldL.premiseType))
			this.getHistory().addAction(new Action("streetName", this.premiseType, oldL.premiseType));
	}



	@Override
	public String toString() {
		return this.area + " " + this.premiseType;
	}

	/**
	 * 
	 * @author hamadalmarri Coordinate class
	 */
	public static class Coordinate implements Serializable {
		private static final long serialVersionUID = -6151369868814513863L;
		public long x, y, z;



		public Coordinate() {

		}



		public Coordinate(long x, long y, long z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}



		public long getX() {
			return x;
		}



		public void setX(long x) {
			this.x = x;
		}



		public long getY() {
			return y;
		}



		public void setY(long y) {
			this.y = y;
		}



		public long getZ() {
			return z;
		}



		public void setZ(long z) {
			this.z = z;
		}



		public boolean isEqual(Coordinate another) {
			return (this.x == another.x && this.y == another.y && this.z == another.z);
		}



		@Override
		public String toString() {
			return "x=" + this.x + " y=" + this.y + " z=" + this.z;
		}
	}

}
