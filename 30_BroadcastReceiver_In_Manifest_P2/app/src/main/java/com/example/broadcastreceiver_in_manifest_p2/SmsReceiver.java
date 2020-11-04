package com.example.broadcastreceiver_in_manifest_p2;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsReceiver extends BroadcastReceiver {

    private static final String SMS_EXTRA = "pdus";
    private static final String SMS_URI = "content://sms/inbox";
    private static final String BODY = "body";
    private static final String ADDRESS = "address";
    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        getListSms(context);
        getNewestSmsDetails(context, intent);

        abc(context);
    }

    private void abc(Context context) {
        // public static final String INBOX = "content://sms/inbox";
        // public static final String SENT = "content://sms/sent";
        // public static final String DRAFT = "content://sms/draft";
        Cursor cursor = context.getContentResolver()
                .query(Uri.parse("content://sms/inbox"), null, null, null, null);

        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                for(int idx=0;idx<cursor.getColumnCount();idx++)
                {
                    msgData += " " + cursor.getColumnName(idx) + ":" + cursor.getString(idx);
                }
                // use msgData
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
        }
        cursor.close();
    }

    private void getListSms(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            final String myPackageName = context.getPackageName();
            if (!Telephony.Sms.getDefaultSmsPackage(context).equals(myPackageName)) {

                Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
                intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, myPackageName);
                startActivityForResult(intent, 1);
            }else {
                List<Sms> lst = getAllSms();
            }
        }else {
            List<Sms> lst = getAllSms();
        }
    }

    public List<Sms> getAllSms(Context context) {
        List<Sms> lstSms = new ArrayList<Sms>();
        Sms objSms = new Sms();
        Uri message = Uri.parse("content://sms/");
        ContentResolver cr = context.getContentResolver();

        Cursor c = cr.query(message, null, null, null, null);
//        context.startManagingCursor(c);
        int totalSMS = c.getCount();

        if (c.moveToFirst()) {
            for (int i = 0; i < totalSMS; i++) {

                objSms = new Sms();
                objSms.setId(c.getString(c.getColumnIndexOrThrow("_id")));
                objSms.setAddress(c.getString(c
                        .getColumnIndexOrThrow("address")));
                objSms.setMsg(c.getString(c.getColumnIndexOrThrow("body")));
                objSms.setReadState(c.getString(c.getColumnIndex("read")));
                objSms.setTime(c.getString(c.getColumnIndexOrThrow("date")));
                if (c.getString(c.getColumnIndexOrThrow("type")).contains("1")) {
                    objSms.setFolderName("inbox");
                } else {
                    objSms.setFolderName("sent");
                }

                lstSms.add(objSms);
                c.moveToNext();
            }
        }
        // else {
        // throw new RuntimeException("You have no SMS");
        // }
        c.close();

        return lstSms;
    }

    private void getNewestSmsDetails(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                Object[] smsExtra = (Object[]) extras.get(SMS_EXTRA);
                for (int i = 0; i < smsExtra.length; i++) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) smsExtra[i]);
                    String phoneNumber = smsMessage.getDisplayOriginatingAddress();
                    String body = smsMessage.getMessageBody();
                    String address = smsMessage.getOriginatingAddress();
                    long time = smsMessage.getTimestampMillis();
                    String timeFormat = new SimpleDateFormat("HH:mm:ss:SSS")
                            .format(new Date(time));

                    String message = "Phone Number: " + phoneNumber
                            + "\nMessage: " + body
                            + "\nAddress: " + address
                            + "\nTime: " + timeFormat;
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
