package paquetemain.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paquetemain.model.Centroeducativo;
import paquetemain.model.Nivel;

public class NivelController {
	
	private static Connection conn = null;
	
	public static List<Nivel> cargarNivelesC(int id) {
		List<Nivel> ln = new ArrayList<Nivel>();
		try {
			conn = paquetemain.controller.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from nivelesymaterias.nivel where idCentro = " + id);
			ResultSet rs = ps.executeQuery();
			Nivel n = null;
			while (rs.next()) {
				n = new Nivel();
				n.setId(rs.getInt(1));
				n.setDescripcion(rs.getString(2));
				Centroeducativo c = new Centroeducativo(); 
				c.setId(rs.getInt(3));
				n.setIdCentro(c);
				ln.add(n);
			}
			rs.close();
			ps.close();
			conn.close();
			return ln;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Nivel guardar(Nivel mat) {
		try {

			if (mat.getId() != 0) {
				update(mat);
				return null;
			} else {
				return guardarNuevo(mat);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		

	}

	/**
	 * 
	 */
	private static Nivel guardarNuevo(Nivel mat) {
		try {

			conn = paquetemain.controller.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"insert into nivelesymaterias.nivel set id = ?, descripcion = ?, idCentro = ?");

			ps.setInt(1, mat.getId());
			ps.setString(2, mat.getDescripcion());
			ps.setInt(3, mat.getIdCentro().getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mat;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void update(Nivel mat) throws NumberFormatException, SQLException {
		conn = paquetemain.controller.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update nivelesymaterias.nivel set nombre = ?, idCentro = ? where id =" + mat.getId());

		ps.setString(1, mat.getDescripcion());
		ps.setInt(2, mat.getIdCentro().getId());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}
	
	
}
