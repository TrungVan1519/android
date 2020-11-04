package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControls();
        setEvents();
    }

    EditText txtMessage, txtPhoneNumber;
    final int PERMISSION_REQUEST_CODE = 1;

    private void setControls() {
        txtPhoneNumber = this.findViewById(R.id.txtPhoneNumber);
        txtMessage = this.findViewById(R.id.txtMessage);

    }

    private void setEvents() {
        this.findViewById(R.id.btnSendMessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy mặc định SmsManager
                final SmsManager sms = SmsManager.getDefault();
                // Cach 1:
                Intent msgSent = new Intent("ACTION_MSG_SENT");
                // Cach 2:
//                Intent msgSent = new Intent(Intent.ACTION_SEND);

                //Khai báo pendingintent để kiểm tra kết quả
                final PendingIntent pendingMsgSent =
                        PendingIntent.getBroadcast(MainActivity.this, 0, msgSent, 0);
                // Tu dong nhan ket qua tra ve khi gui tin nhan di
                registerReceiver(new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        int result = getResultCode();
                        String msg = "Send OK";
                        if (result != Activity.RESULT_OK) {
                            msg = "Send failed";
                        }
                        Toast.makeText(MainActivity.this, msg,
                                Toast.LENGTH_LONG).show();
                    }
                }, new IntentFilter("ACTION_MSG_SENT"));
                // Gui xac nhan quyen truy cap tin nhan tu nguoi dung voi cac API > 23
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS)
                            == PackageManager.PERMISSION_DENIED) {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);
                    }
                }
                //Gọi hàm gửi tin nhắn đi
                sms.sendTextMessage(txtPhoneNumber.getText().toString(), null, txtMessage.getText() + "",
                        pendingMsgSent, null);
            }
        });

        this.findViewById(R.id.btnRollNumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + txtPhoneNumber.getText().toString());
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(uri);
                startActivity(i);
            }
        });

        this.findViewById(R.id.btnCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:" + txtPhoneNumber.getText().toString());
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(uri);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
                        return;
                    }
                }
                startActivity(i);
            }
        });
    }
}
