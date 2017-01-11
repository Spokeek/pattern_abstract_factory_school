import javax.swing.*;

public class WidgetFactoryBlue implements WidgetFactory {

    @Override
    public JButton getButton(String text) {
        return new ButtonBlue(text);
    }

    @Override
    public String getName() {
        return "Blue";
    }
}
