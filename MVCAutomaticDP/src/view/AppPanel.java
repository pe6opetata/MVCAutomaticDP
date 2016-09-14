package view;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import controller.Controller;

@SuppressWarnings("serial")
public class AppPanel extends JPanel {

	private JLabel lblFileName;
	private JLabel lblColWidth;

	private JTextField txtFileName;

	private JButton btnOk;
	private JButton btnBrowse;
	private JButton btnExit;

	private JFileChooser fileChooser;

	private JTextField txtColWidth;

	private GroupLayout baseLayout;

	private Controller baseController;

	public AppPanel(Controller baseController) {
		this.baseController = baseController;

		lblFileName = new JLabel("File name:");
		lblColWidth = new JLabel("Col width");
		
		txtFileName = new JTextField();

		btnOk = new JButton("Submit");
		btnBrowse = new JButton("Browse...");
		btnExit = new JButton("Exit");

		fileChooser = new JFileChooser();

		txtColWidth = new JTextField("4", 10);		

		baseLayout = new GroupLayout(this);
		
		
		setupLayout();
		setupPanel();
		setupListeners();
	}

	private void setupLayout() {

		baseLayout = new GroupLayout(this);
		baseLayout.setHorizontalGroup(baseLayout.createParallelGroup(Alignment.LEADING).addGroup(baseLayout
				.createSequentialGroup()
				.addGroup(baseLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(baseLayout.createSequentialGroup().addGap(16).addComponent(lblFileName)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtFileName,
										GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, baseLayout.createSequentialGroup().addContainerGap()
								.addGroup(baseLayout.createParallelGroup(Alignment.LEADING).addComponent(btnOk)
										.addComponent(btnBrowse))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblColWidth).addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(baseLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtColWidth, 0, 0, Short.MAX_VALUE).addComponent(btnExit,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addContainerGap(115, Short.MAX_VALUE)));
		baseLayout.setVerticalGroup(baseLayout.createParallelGroup(Alignment.LEADING).addGroup(baseLayout
				.createSequentialGroup().addGap(19)
				.addGroup(baseLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFileName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(baseLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnBrowse)
						.addComponent(txtColWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColWidth))
				.addGap(31)
				.addGroup(baseLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnOk).addComponent(btnExit))
				.addGap(135)));

	}

	private void setupPanel() {
		this.setLayout(baseLayout);
		this.add(lblFileName);
		this.add(lblColWidth);
		this.add(txtFileName);
		this.add(btnOk);
		this.add(btnBrowse);
		this.add(btnExit);
		this.add(fileChooser);
		this.add(txtColWidth);
	}

	private void setupListeners() {

		txtFileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				String fileName = txtFileName.getText();
				int columnWidth = baseController.getBaseQuestionnaire().getColumnWidth();
				if (checkInteger(txtColWidth.getText())) {
					columnWidth = Integer.parseInt(txtColWidth.getText());
				}
				txtFileName.setText("");
				try {
					baseController.makeQuestionnaire(fileName, columnWidth);
					baseController.exportFiles();
					JOptionPane.showMessageDialog(btnOk, baseController.getBaseQuestionnaire().getLog(),
							"There were no problems in the process!", JOptionPane.INFORMATION_MESSAGE);
				} catch (Throwable t) {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					pw.println(t.getMessage());
					t.printStackTrace(pw);
					JOptionPane.showMessageDialog(btnOk, sw.toString(), "An error occurred!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (txtFileName.getText().equals("")) {
					txtFileName.requestFocus();
				} else {
					String fileName = txtFileName.getText();
					int columnWidth = baseController.getBaseQuestionnaire().getColumnWidth();
					if (checkInteger(txtColWidth.getText())) {
						columnWidth = Integer.parseInt(txtColWidth.getText());
					}
					try {
						baseController.makeQuestionnaire(fileName, columnWidth);
						baseController.exportFiles();
						// create a JTextArea
						JTextArea textArea = new JTextArea(20, 100);
						textArea.setText(baseController.getBaseQuestionnaire().getLog());
						textArea.setEditable(false);

						// wrap a scrollpane around it
						JScrollPane scrollPane = new JScrollPane(textArea);
						JOptionPane.showMessageDialog(btnOk, scrollPane,
								"There were no problems in the process!",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Throwable t) {
						StringWriter sw = new StringWriter();
						PrintWriter pw = new PrintWriter(sw);
						pw.println(t.getMessage());
						t.printStackTrace(pw);
						JOptionPane.showMessageDialog(btnOk, sw.toString(),
								"An error occurred!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.setCurrentDirectory(new File("."));
				int returnValue = fileChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String fileName = fileChooser.getSelectedFile().toString();
					txtFileName.setText(fileName);
					txtFileName.requestFocus();
				}

			}
		});

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		fileChooser.changeToParentDirectory();

	}

	private boolean checkInteger(String input) {
		boolean isInteger = false;

		try {
			Integer.parseInt(input);
			isInteger = true;

		} catch (NumberFormatException exeption) {
			JOptionPane.showMessageDialog(this, "Please type an integer in the field");
		}

		return isInteger;
	}

}
