import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WidgetFactory f = new WidgetFactoryRed();

        Map<String, WidgetFactory> map = new HashMap<String, WidgetFactory>();
        map.put("red", new WidgetFactoryRed());
        map.put("blue", new WidgetFactoryBlue());

        JComboBox themeSelector = new JComboBox();

        for(Map.Entry<String, WidgetFactory> e : map.entrySet()){
            themeSelector.addItem(e.getKey());
        }

        themeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(window.getContentPane().getComponentCount() != 1)
                    window.getContentPane().remove(1);
                String selected = themeSelector.getSelectedItem().toString();
                WidgetFactory f = map.get(selected);
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
