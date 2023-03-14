package paquetemain.model;

public class Centroeducativo {
	private int id;
	private String descripcion;
	
	/**
	 * 
	 */
	public Centroeducativo() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param descripcion
	 */
	public Centroeducativo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Centroeducativo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
