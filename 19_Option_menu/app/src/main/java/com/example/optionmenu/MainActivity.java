package com.example.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Ham nay dung de merge 2 Layout Layout_Activity voi Layout_OptionMenu voi nhau
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.template_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Ham tao su kien cho OptionMenu khi chon 1 Item trong Layout_OptionMenu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuBlue){
            Toast.makeText(this, "Ban chon item mau xanh",
                    Toast.LENGTH_LONG).show();
        }
        if (item.getItemId() == R.id.menuRed){
            Toast.makeText(this, "Ban chon item mau do",
                    Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
