package databasemysql;

import CentralSystem.CentralSystem;
import Entity.Contact;
import Entity.User;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author Johnny
 */
public class MainFrame extends javax.swing.JFrame {

    private CentralSystem cs = new CentralSystem();
    private List<User> konverzace = new ArrayList<User>();

    public MainFrame() {
        initComponents();
        updateMainFrame();
        cs.logIn("admin", "adminadmin");
        updateMainFrame();
        updateContactList();
    }

    public void updateMainFrame() {
        if (cs.isLoged()) {
            jLabelStatus.setText("Status: přihlášen");
            jLabelLoggedIn.setText("Přihlášen: " + cs.getUser().getNick());
        } else {
            jLabelStatus.setText("Status: odhlášen");
            jLabelLoggedIn.setText("Nepřihlášen");
        }
    }

    public void updateContactList() {
        /*String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
         public int getSize() { return strings.length; }
         public Object getElementAt(int i) { return strings[i]; }*/
        //List<Contact> contacts = cs.getContactList();
        jListContactList.setModel(new javax.swing.AbstractListModel() {
            // String[] strings = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
            List<Contact> contacts = cs.getContactList();

            public int getSize() {
                return contacts.size();
            }

            public Contact getElementAt(int i) {
                return contacts.get(i);
            }
        });
        jListContactList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (jListContactList.getModel().getSize() > 0) {
                    if (evt.getClickCount() == 2) {
                        int index = jListContactList.locationToIndex(evt.getPoint());
                        System.out.println("Otevřít komunikaci s: " + jListContactList.getModel().getElementAt(index).toString());
                        Panel p = new Panel();
                        p.setLayout(new GridLayout(3, 1));
                        p.add(new JLabel("This is tab " + jListContactList.getModel().getElementAt(index).toString()));
                        p.add(new JLabel("This is tab2 " + jListContactList.getModel().getElementAt(index).toString()));
                        jTabbedPaneMessages.addTab(jListContactList.getModel().getElementAt(index).toString(), p);
                        /* List<Message> zpravy = cs.getMessages(((Contact) jListContactList.getModel().getElementAt(index)).getContact());
                         for (Message message : zpravy) {
                         System.out.println(message.getWhen().toLocaleString() + "-" + message.getText());
                         }*/
                    }
                }
            }
        });
        jScrollPane1.setViewportView(jListContactList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelLoggedIn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelContactList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListContactList = new javax.swing.JList();
        jPanelMessages = new javax.swing.JPanel();
        jTabbedPaneMessages = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(218, 235, 252));

        jLabelStatus.setText("Status: Off");

        jLabelLoggedIn.setText("Přihlášen: nikdo");
        jLabelLoggedIn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addComponent(jLabelLoggedIn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatus)
                    .addComponent(jLabelLoggedIn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelContactList.setBackground(new java.awt.Color(213, 233, 254));

        jListContactList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListContactList);

        javax.swing.GroupLayout jPanelContactListLayout = new javax.swing.GroupLayout(jPanelContactList);
        jPanelContactList.setLayout(jPanelContactListLayout);
        jPanelContactListLayout.setHorizontalGroup(
            jPanelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelContactListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelContactListLayout.setVerticalGroup(
            jPanelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );

        jPanelMessages.setBackground(new java.awt.Color(233, 233, 255));

        javax.swing.GroupLayout jPanelMessagesLayout = new javax.swing.GroupLayout(jPanelMessages);
        jPanelMessages.setLayout(jPanelMessagesLayout);
        jPanelMessagesLayout.setHorizontalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMessagesLayout.setVerticalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMessages)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanelContactList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 689, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLoggedIn;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JList jListContactList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelContactList;
    private javax.swing.JPanel jPanelMessages;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPaneMessages;
    // End of variables declaration//GEN-END:variables
}
