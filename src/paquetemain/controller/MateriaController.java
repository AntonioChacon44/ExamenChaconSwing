package paquetemain.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import paquetemain.model.Materia;
import paquetemain.model.Nivel;


public class MateriaController {
	
	private static Connection conn = null;
	
	public static List<Materia> cargarMateriaC(int id) {
		List<Materia> lm = new ArrayList<Materia>();
		try {
			conn = paquetemain.controller.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from nivelesymaterias.materia where idNivel = " + id);
			ResultSet rs = ps.executeQuery();
			Materia m = null;
			while (rs.next()) {
				m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				Nivel n = new Nivel(); 
				n.setId(rs.getInt(3));
				m.setIdNivel(n);
				m.setCodigo(rs.getString(4));
				m.setUrlClassroom(rs.getString(5));
				m.setAdmiteMatricula(rs.getBoolean("admiteMatricula"));
				m.setFechaInicio(rs.getDate("fechaInicio"));
				lm.add(m);
			}
			rs.close();
			ps.close();
			conn.close();
			return lm;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}