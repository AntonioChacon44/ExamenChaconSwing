package paquetemain.model;

public class Nivel {
	
	private int id;
	private String descripcion;
	private Centroeducativo idCentro;
	
	/**
	 * 
	 */
	public Nivel() {
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param descripcion
	 * @param idCentro
	 */
	public Nivel(int id, String descripcion, Centroeducativo idCentro) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idCentro = idCentro;
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

	public Centroeducativo getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(Centroeducativo idCentro) {
		this.idCentro = idCentro;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Nivel [id=" + id + ", descripcion=" + descripcion + ", idCentro=" + idCentro + "]";
	}
	
	
	
	
	
}
