package example.myapplication.movelife;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Thomas on 15-5-2014.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "Example1", "example2", "example3", "example4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String cheese = classes[position];
        super.onListItemClick(l, v, position, id);
        try {
            Class ourClass = Class.forName("example.myapplication.movelife." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);

            startActivity(ourIntent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
