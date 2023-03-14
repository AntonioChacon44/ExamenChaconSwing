package paquetemain.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paquetemain.model.Centroeducativo;

public class CentroeducativoController {
	private static Connection conn = null;
	
	public static Centroeducativo guardar(Centroeducativo cen) {
		try {

			if (cen.getId() != 0) {
				update(cen);
				return null;
			} else {
				return guardarNuevo(cen);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 
	 */
	private static Centroeducativo guardarNuevo(Centroeducativo cen) {
		try {
			conn = paquetemain.controller.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn
					.prepareStatement("insert into nivelesymaterias.centroeducativo set id = ?, descripcion = ? ");

			ps.setInt(1, cen.getId());

			ps.setString(2, cen.getDescripcion());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return cen;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private static void update(Centroeducativo cen) throws NumberFormatException, SQLException {
		conn = paquetemain.controller.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn
				.prepareStatement("update nivelesymaterias.centroeducativo set descripcion = ? where id =" + cen.getId());

		ps.setString(1, cen.getDescripcion());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}
	
	/**
	 * 
	 * @return
	 */
	public static Centroeducativo cargarPrimerRegistro() {

		try {
			conn = paquetemain.controller.ConnectionManagerV1.getConexion();
			Centroeducativo cen = null;
			PreparedStatement ps = conn.prepareStatement("select * from nivelesymaterias.centroeducativo order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				cen = new Centroeducativo();
				cen.setId(rs.getInt(1));
				cen.setDescripcion(rs.getString(2));
			}
			rs.close();
			ps.close();
			conn.close();
			return cen;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param curs
	 * @return
	 */
	public static Centroeducativo cargarSiguienteRegistro(Centroeducativo cen) {
		try {
			conn = paquetemain.controller.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from nivelesymaterias.centroeducativo where id > " + cen.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			Centroeducativo c = new Centroeducativo();
			if (rs.next()) {

				c.setId(rs.getInt(1));
				c.setDescripcion(rs.getString(2));

				rs.close();
				ps.close();
				conn.close();
				return c;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 
	 * @return
	 */
	public static List<Centroeducativo> findAll() {
		List<Centroeducativo> lc = new ArrayList<Centroeducativo>();
		Centroeducativo c = cargarPrimerRegistro();
		do {
			lc.add(c);
			c = cargarSiguienteRegistro(c);
		} while (c != null);
		return lc;
	}
	
}
