import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<WidgetFactory> list = new ArrayList<>();
        list.add(new WidgetFactoryRed());
        list.add(new WidgetFactoryBlue());
        WidgetComboBoxModel m = new WidgetComboBoxModel(list);
        JComboBox themeSelector = new JComboBox(m);
        themeSelector.setRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                return new JLabel(((WidgetFactory) value).getName());
            }
        });


        themeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (window.getContentPane().getComponentCount() != 1)
                    window.getContentPane().remove(1);
                WidgetFactory f = m.getSelectedItem();
                if (f != null) {
                    window.getContentPane().add(f.getButton("my awesome styled button"), BorderLayout.SOUTH);
                    window.validate();
                    window.repaint();
                }
            }
        });

        window.getContentPane().add(themeSelector, BorderLayout.NORTH);
        themeSelector.setSelectedIndex(0);
        window.setVisible(true);
    }
}
