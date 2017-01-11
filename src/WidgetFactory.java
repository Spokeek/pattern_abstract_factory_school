import javax.swing.*;

public interface WidgetFactory {
    public JButton getButton(String text);

    public String getName();
}
