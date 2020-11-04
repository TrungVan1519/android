package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    Button btn1, btn2, btn3;
    int idChosenControl = -1;

    private void setControls() {
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn3 = this.findViewById(R.id.btn3);

        // Phai dang ky ContextMenu cho cac Controls thi cac Controls moi su dung ContextMenu duoc
        this.registerForContextMenu(btn1);
        this.registerForContextMenu(btn2);
        this.registerForContextMenu(btn3);
    }

    private void setEvents() {
        View.OnLongClickListener event = new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (v.getId() == btn1.getId()
                        || v.getId() == btn2.getId()
                        || v.getId() == btn3.getId()){
                    idChosenControl = v.getId();
                }
                return false;
            }
        };
        btn1.setOnLongClickListener(event);
        btn2.setOnLongClickListener(event);
        btn3.setOnLongClickListener(event);
    }

    // Ham nay dung de merge 2 Layout Layout_Activity voi Layout_ContextMenu voi nhau
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.template_context_menu, menu);
    }

    // Ham tao su kien cho ContextMenu khi chon 1 Item trong Layout_ContextMenu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuBold){
            Button btn = this.findViewById(idChosenControl);
            btn.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (item.getItemId() == R.id.menuItalic){
            Button btn = this.findViewById(idChosenControl);
            btn.setTypeface(btn.getTypeface(), Typeface.ITALIC);
        }
        return super.onContextItemSelected(item);
    }
}
