package Calendar.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;


public class ViewData extends JFrame{
	private static final long serialVersionUID = 1L;

	ViewData(){
		
		try{
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int x = (d.width / 10);
			int y = (d.height / 8) - this.getHeight();
			setLocation(x, y);
			setTitle("Event Handaler");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			Object[][] data = DatabaseEvents.getAllEventList();  
			
			
			
			Vector<String> cols = new Vector<String>();
			cols.add("EventId");
			cols.add("Name");
			cols.add("EventName");
			cols.add("EventDate");
			cols.add("E-Mail");
			cols.add("Message");
			
			JTable table = new JTable(data,cols.toArray());
			table.setBorder(BorderFactory.createLineBorder(Color.green,2));
			table.setFont(new Font("Arial",Font.PLAIN, 20));
			table.setRowHeight(30);
			table.setGridColor(Color.red);
			JTableHeader head = table.getTableHeader();
			
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add("North", head);
			c.add("Center", table);
			setSize(1200,500);
			setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
