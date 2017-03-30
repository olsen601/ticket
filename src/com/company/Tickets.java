package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by olsen on 3/29/17.
 */
public class Tickets extends JFrame {
    private JTextField Ticket;
    private JButton SubmitNewTicket;
    private JButton deleteTicketButton;
    private JTextField DeleteField;
    private JButton displayAllTicketsButton;
    private JButton quitButton;
    private JPanel rootPanel;
    private JComboBox Priority;
    private JTextField ReporterNameTextField;
    private JLabel Date;
    private JLabel ReporterName;
    private JSpinner dateSpinner;
    private JList<Ticket> ticketsJList;

    DefaultListModel<Ticket> ticketsListModel;

protected Tickets() {

    super("Ticket List");
    setContentPane(rootPanel);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    ticketsListModel = new DefaultListModel<>();
    ticketsJList.setModel(ticketsListModel);

    dateSpinner.setModel(new SpinnerDateModel());
    int prior[] = {1,2,3,4,5,6,7,8,9,10};
    for(int i = 0; i < prior.length;i++){
        Priority.addItem(prior[i]);
    }

    /*Priority.addItem(1);
    Priority.addItem(2);
    Priority.addItem(3);
    Priority.addItem(4);
    Priority.addItem(5);*/

    SubmitNewTicket.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String TicketName = Ticket.getText();
            int P = Priority.getItemCount();
            String Reporter = ReporterNameTextField.getText();
            java.util.Date D = (Date)dateSpinner.getModel().getValue();


            Ticket newTicket = new Ticket(TicketName,P,Reporter,D);
            ticketsListModel.addElement(newTicket);
        }
    });

    deleteTicketButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String DeleteID = DeleteField.getText();
            int Delete = Integer.parseInt(DeleteID);

        }
    });

}
}
