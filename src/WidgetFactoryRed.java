import javax.swing.*;

public class WidgetFactoryRed implements WidgetFactory {
    @Override
    public JButton getButton(String text) {
        return new ButtonRed(text);
    }
}
