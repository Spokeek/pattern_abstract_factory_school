import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class WidgetComboBoxModel implements ComboBoxModel {
    private ArrayList<WidgetFactory> list;
    private WidgetFactory selectedFactory = null;

    public WidgetComboBoxModel() {
        this.list = new ArrayList<>();
    }

    public WidgetComboBoxModel(ArrayList<WidgetFactory> list) {
        this.list = list;
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public WidgetFactory getSelectedItem() {
        return this.selectedFactory;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selectedFactory = (WidgetFactory) anItem;
    }
}
