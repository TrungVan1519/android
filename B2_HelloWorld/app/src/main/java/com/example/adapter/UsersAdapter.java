package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloworld.ListView_CustomArrayAdapterActivity;
import com.example.helloworld.R;
import com.example.model.User;

import java.util.ArrayList;
import java.util.List;


//    private Context context;
//    private int resource;
//    private List<DanhBa> objects;
//    public DanhBaAdapter(@NonNull Context context, int resource, @NonNull List<DanhBa> objects) {
//        super(context, resource, objects);
//        this.context = context;
//        this.resource = resource;
//        this.objects = objects;
//    }
public class UsersAdapter extends ArrayAdapter<User> {

    int resource;
    Context context;
    public UsersAdapter(Context context, int resource, ArrayList<User> users) {
        super(context, resource, users);
        context = context;
        resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_with_custom_arrayadapter, null);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(user.name);
        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }

//    @NonNull
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        /*// LayoutInflater la 1 class dung de build cac File trong Folder layout thanh code Java
//        // O day ta lay ra man hinh Activity ra
//        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
//
//        // Ket hop giua man hinh Activity ta vua lay ra va File *.xml cho tung item trong ListView
//        View rowForItemInListView = layoutInflater.inflate(this.resource, null);
//*/
//        if(convertView == null){
//            convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.list_view_with_custom_arrayadapter,  parent, false);
//        }
//
//        // Do khi nay man hinh Activity da bi ket hop voi 1 File *.xml cho item cua ListView roi
//        //      nen khi lay ra cac Controls trong man hinh Activity cu ta phai su dung man hinh moi
//        TextView txtName = convertView.findViewById(R.id.txtName);
//        TextView txtPhoneNumber = convertView.findViewById(R.id.txtPhoneNumber);
//
//        // Truyen du lieu tu du lieu goc cho tung item trong ListView
//        DanhBa db = getItem(position); // Chu y: position o day la tham so cua getView()
//        txtName.setText(db.getName());
//        txtPhoneNumber.setText(db.getPhoneNumber());
//
//        // Tra ve View moi la su ket hop cua 2 File *.xml la man hinh Activity va File *.xml cho item
//        return convertView;
//    }
}
