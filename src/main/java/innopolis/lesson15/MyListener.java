package innopolis.lesson15;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println(event.getSource().toString());
        System.out.println("RowSetChanged");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println(event.getSource().toString());
        System.out.println("RowChanged");
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println(event.getSource().toString());
        System.out.println("Курсор сдвинут");
    }
}
