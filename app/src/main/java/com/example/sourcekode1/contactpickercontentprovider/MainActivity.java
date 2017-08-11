package com.example.sourcekode1.contactpickercontentprovider;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view)
    {
        Intent i=new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(i,1);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri data1 = data.getData();

        Cursor cursor=getContentResolver().query(data1,null,null,null,null);
        cursor.moveToFirst();
        int nameIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int numberIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        String name=cursor.getString(nameIndex);
        String number=cursor.getString(numberIndex);
        Toast.makeText(MainActivity.this, name+" "+number, Toast.LENGTH_SHORT).show();
    }
}
