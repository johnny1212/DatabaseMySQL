package databasemysql;

import Entity.Message;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Johnny
 */
public class MessageTableModel extends AbstractTableModel {

    private List<Message> messages;

    public MessageTableModel(List<Message> messages) {
        this.messages = new ArrayList<Message>(messages);
    }

    @Override
    public int getRowCount() {
        return messages.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "kdy";
                break;
            /*case 1:
             name = "Text zprávy";
             break;*/
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Message message = messages.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = message.getWhen().toLocaleString() + ": " + message.getText();
                break;
            /*case 1:
             value = message.getText();
             break;*/
        }
        return value;
    }
}
