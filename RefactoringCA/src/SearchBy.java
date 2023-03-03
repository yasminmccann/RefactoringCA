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
			searchPane();
			actionPerformed(null);
			//System.out.println("House is built.");
		}
		
		//Template methods 
		   //protected abstract void SearchByIdDialog();  
		   //protected abstract void SearchBySurnameDialog(); 
		   protected abstract Container searchPane();   
		   
		   public void actionPerformed(ActionEvent e) {
			// if option search, search for Employee
				if(e.getSource() == search){
					this.parent.searchBySurnameField.setText(searchField.getText());
					// search Employee by surname
					this.parent.searchEmployeeBySurname();
					this.parent.searchByIdField.setText(searchField.getText());
					// search Employee by surname
					this.parent.searchEmployeeById();
					dispose();// dispose dialog
				}// end if
				// else dispose dialog
				else if(e.getSource() == cancel)
					dispose();// dispose dialog
			}// end actionPerformed
		   
}
