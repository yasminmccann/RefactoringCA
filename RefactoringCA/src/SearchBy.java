import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public abstract class SearchBy extends JDialog implements ActionListener {
	
	EmployeeDetails parent;
	JButton search, cancel;
	JTextField searchField;
	
	//template method, final so subclasses can't override
		public final void searchBy(){
			SearchByIdDialog();
			SearchBySurnameDialog();
			searchPane();
			actionPerformed(null);
			//System.out.println("House is built.");
		}
		
		   //Template methods 
		   protected abstract void SearchByIdDialog();  
		   protected abstract void SearchBySurnameDialog(); 
		   
		   
		   protected Container searchPane() {
				JPanel searchPanel = new JPanel(new GridLayout(3, 1));
				JPanel textPanel = new JPanel();
				JPanel buttonPanel = new JPanel();
				JLabel searchLabel;

				searchPanel.add(new JLabel("Search by ID"));

				textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
				textPanel.add(searchLabel = new JLabel("Enter ID:"));
				searchLabel.setFont(this.parent.font1);
				textPanel.add(searchField = new JTextField(20));
				searchField.setFont(this.parent.font1);
				searchField.setDocument(new JTextFieldLimit(20));
				
				buttonPanel.add(search = new JButton("Search"));
				search.addActionListener(this);
				search.requestFocus();
				
				buttonPanel.add(cancel = new JButton("Cancel"));
				cancel.addActionListener(this);

				searchPanel.add(textPanel);
				searchPanel.add(buttonPanel);

				return searchPanel;
			}// end searchPane
		   
		   
		   public void actionPerformed(ActionEvent e) {
			// if option search, search for Employee
				if(e.getSource() == search){
					this.parent.searchBySurnameField.setText(searchField.getText());
					// search Employee by surname
					this.parent.searchEmployeeBySurname();
					dispose();// dispose dialog
				}// end if
				// else dispose dialog
				else if(e.getSource() == cancel)
					dispose();// dispose dialog
			}// end actionPerformed
		
	
		   

}
