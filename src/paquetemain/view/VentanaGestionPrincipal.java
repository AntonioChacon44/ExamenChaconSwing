package paquetemain.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import paquetemain.controller.CentroeducativoController;
import paquetemain.controller.MateriaController;
import paquetemain.controller.NivelController;
import paquetemain.model.Centroeducativo;
import paquetemain.model.Materia;
import paquetemain.model.Nivel;
import paquetemain.utils.CacheImagenes;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class VentanaGestionPrincipal extends JPanel {
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private JComboBox<Centroeducativo> jcbCentroE;
	private JComboBox<Nivel> jcbNivel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JCheckBox chckbxNewCheckBox;
	private JTextField textField_2;
	private JButton btnNewButton_2;
	private String TITULO_APLICACION = "Titulo de la app";
	private JLabel lblNewLabel_3;
	private JComboBox<Materia> jcbMateria;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_3;
	private JLabel lblNewLabel_8;
	private JTextField textField_4;
	private JLabel lblNewLabel_9;

	/**
	 * Create the frame.
	 */
	public VentanaGestionPrincipal() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestión de Materias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		lblNewLabel_1 = new JLabel("Centro:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbCentroE = new JComboBox<Centroeducativo>();
		GridBagConstraints gbc_jcbcurso = new GridBagConstraints();
		gbc_jcbcurso.insets = new Insets(0, 0, 5, 5);
		gbc_jcbcurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbcurso.gridx = 1;
		gbc_jcbcurso.gridy = 1;
		add(jcbCentroE, gbc_jcbcurso);

		btnNewButton = new JButton("Cargar Niveles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarNiveles();
 
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);

		lblNewLabel = new JLabel("Nivel:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		jcbNivel = new JComboBox<Nivel>();
		GridBagConstraints gbc_jcbmateria = new GridBagConstraints();
		gbc_jcbmateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbmateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbmateria.gridx = 1;
		gbc_jcbmateria.gridy = 2;
		add(jcbNivel, gbc_jcbmateria);

		btnNewButton_1 = new JButton("CargarMaterias");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMateria();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		add(jcbMateria, gbc_jcbMateria);
		
		btnNewButton_5 = new JButton("Ver materia");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaACampos();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 3;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		lblNewLabel_4 = new JLabel("Datos de la materia");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 5;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 6;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Código:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 7;
		add(textField_3, gbc_textField_3);
		
		lblNewLabel_8 = new JLabel("URL Classroom:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 8;
		add(textField_4, gbc_textField_4);
		
		lblNewLabel_9 = new JLabel("Fecha Inicio:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 9;
		add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 9;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		chckbxNewCheckBox = new JCheckBox("Admite Matricula");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 10;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		btnNewButton_2 = new JButton("Guardar");
		btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		String posiblesRespuestas[] = { "Sí", "No", "tal vez", "awuayin" };
		// En esta opción se utiliza un showOptionDialog en el que personalizo el icono
		// mostrado
		int opcionElegida = JOptionPane.showInternalOptionDialog(null, "joption mamadisimo", TITULO_APLICACION,
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, CacheImagenes.getCacheImagenes().getIcono("confirm.png"),
							posiblesRespuestas, posiblesRespuestas[3]);

				if (opcionElegida == 0) {
							System.exit(0);
				}
			}
		});
	GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
	gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
	gbc_btnNewButton_2.gridx = 1;
	gbc_btnNewButton_2.gridy = 11;
	add(btnNewButton_2, gbc_btnNewButton_2);

	llenarJcb();

	}

	private void llenarJcb() {
		List<Centroeducativo> lc = CentroeducativoController.findAll();
		for (Centroeducativo cen : lc) {
			jcbCentroE.addItem(cen);
		}
	}

	private void cargarNiveles() {
		Centroeducativo c = (Centroeducativo) jcbCentroE.getSelectedItem();
		List<Nivel> ln = NivelController.cargarNivelesC(c.getId());

		try {
			jcbNivel.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Nivel nivel : ln) {
			jcbNivel.addItem(nivel);
		}

	}
	
	private void cargarMateria() {
		Nivel n = (Nivel) jcbNivel.getSelectedItem();
		List<Materia> lm = MateriaController.cargarMateriaC(n.getId());

		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Materia materia : lm) {
			jcbMateria.addItem(materia);
		}

	}

	private void listaACampos() {
		Materia m = (Materia) jcbMateria.getSelectedItem();
		textField_1.setText(m.getNombre());
		textField_1.setText("" + m.getIdNivel());
		textField_3.setText(m.getCodigo());
		textField_4.setText(m.getUrlClassroom());
		textField_2.setText(new SimpleDateFormat("dd/MM/yyyy").format(m.getFechaInicio()));
		chckbxNewCheckBox.setSelected(m.isAdmiteMatricula());
	}

}
