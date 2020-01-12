package com.example.motivationlist;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;


import com.example.motivationlist.test.MainActivity2;



import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;



public class MainActivity extends AppCompatActivity {

    private static final String SERVER = "http://10.0.2.2:3000/";

    private TextView tvServerResponse;

    EditText e_name, e_email, e_username, e_phnumber;
    Button bt_save, viewdata, viewdatall;
    public static final String DATABASE_NAME = "StudentDatabases.db";
    SQLiteDatabase mDatabase;

    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;

    private OutputStream outputStream;
    private InputStream inStream;

    DataOutputStream os;

    TextView mStatusBlueTv, mPairedTv;
    ImageView mBlueIv;
   /* Button mOnBtn, mOffBtn, mDiscoverBtn, mPairedBtn;

    BluetoothAdapter mBlueAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpGetRequest request = new HttpGetRequest();
                request.execute();
            }
        };

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvServerResponse = findViewById(R.id.textView_request);
        Button contactServerButton = findViewById(R.id.button_request);
        contactServerButton.setOnClickListener(onButtonClickListener);
        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        createEmployeeTable();
        BluetoothSPP bt = new BluetoothSPP(this);
        if (!bt.isBluetoothAvailable()) {
            System.out.println("notavailable");
        } else {
            bt.startService(BluetoothState.DEVICE_ANDROID);
        }



        //FindById (Button and Edittxt)
        e_name = (EditText) findViewById(R.id.e_name);
        e_email = (EditText) findViewById(R.id.e_email);
        e_username = (EditText) findViewById(R.id.e_username);
        e_phnumber = (EditText) findViewById(R.id.e_phnumber);

        bt_save = (Button) findViewById(R.id.btn_save);
        viewdatall = (Button) findViewById(R.id.viewdataLL);
        viewdatall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
                startActivity(intent);
            }
        });



        if(!bt.isBluetoothAvailable()) {
            System.out.println("No Bluetooth available");
        }

        bt.startService(BluetoothState.DEVICE_ANDROID);


        viewdata = (Button) findViewById(R.id.viewdata);
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        //Onclick Btn
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the Enter data
                String name = e_name.getText().toString().trim();
                String email = e_email.getText().toString().trim();
                String username = e_username.getText().toString();
                String phone = e_phnumber.getText().toString();


                if (name.isEmpty() || email.isEmpty() || username.isEmpty() || phone.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Complete to save", Toast.LENGTH_SHORT).show();

                } else {

                    String insertSQL = "INSERT INTO Student \n" +
                            "(Name, Email, UserName, PhoneNo)\n" +
                            "VALUES \n" +
                            "(?, ?, ?, ?);";

                    //using the same method execsql for inserting values
                    //this time it has two parameters
                    //first is the sql string and second is the parameters that is to be binded with the query
                    mDatabase.execSQL(insertSQL, new String[]{name, email, username, phone});

                    Toast.makeText(MainActivity.this, "Great! Data saved", Toast.LENGTH_SHORT).show();
                }


            }
        });


       /* mStatusBlueTv = findViewById(R.id.statusBluetoothTv);
        mPairedTv     = findViewById(R.id.pairedTv);
        mBlueIv       = findViewById(R.id.bluetoothIv);
        mOnBtn        = findViewById(R.id.onBtn);
        mOffBtn       = findViewById(R.id.offBtn);
        mDiscoverBtn  = findViewById(R.id.discoverableBtn);
        mPairedBtn    = findViewById(R.id.pairedBtn);

        //adapter
        mBlueAdapter = BluetoothAdapter.getDefaultAdapter();

        //check if bluetooth is available or not
        if (mBlueAdapter == null){
            mStatusBlueTv.setText("Bluetooth is not available");
        }
        else {
            mStatusBlueTv.setText("Bluetooth is available");
        }

        //set image according to bluetooth status(on/off)
        if (mBlueAdapter.isEnabled()){
            mBlueIv.setImageResource(R.drawable.blueetooth_logo);
        }
        else {
            mBlueIv.setImageResource(R.drawable.blueetooth_logo_black);
        }

        //on btn click
        mOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBlueAdapter.isEnabled()){
                    showToast("Turning On Bluetooth");
                    //intent to on bluetooth
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                }
                else {
                    showToast("Bluetooth is already on");
                }
            }
        });
        //discover bluetooth btn click
        mDiscoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBlueAdapter.isDiscovering()){
                    showToast("Making Your Device Discoverable");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(intent, REQUEST_DISCOVER_BT);
                }
            }
        });
        //off btn click
        mOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBlueAdapter.isEnabled()){
                    mBlueAdapter.disable();
                    showToast("Turning Bluetooth Off");
                    mBlueIv.setImageResource(R.drawable.blueetooth_logo_black);
                }
                else {
                    showToast("Bluetooth is already off");
                }
            }
        });
        //get paired devices btn click
        mPairedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBlueAdapter.isEnabled()){
                    mPairedTv.setText("Paired Devices");
                    Set<BluetoothDevice> devices = mBlueAdapter.getBondedDevices();
                    for (BluetoothDevice device: devices){
                        mPairedTv.append("\nDevice: " + device.getName()+ ", " + device);
                    }
                }
                else {
                    //bluetooth is off so can't get paired devices
                    showToast("Turn on bluetooth to get paired devices");
                }
            }
        });

        registerReceiver(discoveryResult, new IntentFilter(BluetoothDevice.ACTION_FOUND));

        mBlueAdapter.enable();
        if (!mBlueAdapter.isDiscovering()) {
            mBlueAdapter.startDiscovery();
        }*/

    }

    public class HttpGetRequest extends AsyncTask<Void, Void, String> {

        static final String REQUEST_METHOD = "GET";
        static final int READ_TIMEOUT = 15000;
        static final int CONNECTION_TIMEOUT = 15000;

        @Override
        protected String doInBackground(Void... params){
            String result;
            String inputLine;

            try {
                // connect to the server
                URL myUrl = new URL(SERVER);
                HttpURLConnection connection =(HttpURLConnection) myUrl.openConnection();
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);
                connection.connect();

                // get the string from the input stream
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                reader.close();
                streamReader.close();
                result = stringBuilder.toString();

            } catch(IOException e) {
                e.printStackTrace();
                result = "error";
            }

            return result;
        }

        protected void onPostExecute(String result){
            super.onPostExecute(result);
            tvServerResponse.setText(result);
        }
    }





    /*BroadcastReceiver discoveryResult = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String remoteDeviceName = intent.getStringExtra(BluetoothDevice.EXTRA_NAME);
            BluetoothDevice remoteDevice;

            remoteDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

            Toast.makeText(getApplicationContext(), "Discovered: " + remoteDeviceName + " address " + remoteDevice.getAddress(), Toast.LENGTH_SHORT).show();

            try{
                BluetoothDevice device = mBlueAdapter.getRemoteDevice(remoteDevice.getAddress());

                Method m = device.getClass().getMethod("createRfcommSocket", new Class[] {int.class});

                BluetoothSocket clientSocket =  (BluetoothSocket) m.invoke(device, 1);

                clientSocket.connect();

                os = new DataOutputStream(clientSocket.getOutputStream());

                new clientSock().start();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("BLUETOOTH", e.getMessage());
            }


        }
    };*/


   /* public class clientSock extends Thread {
        public void run () {
            try {
                os.writeBytes("anything you want"); // anything you want
                os.flush();
            } catch (Exception e1) {
                e1.printStackTrace();
                return;
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_ENABLE_BT:
                if (resultCode == RESULT_OK){
                    //bluetooth is on
                    mBlueIv.setImageResource(R.drawable.blueetooth_logo);
                    showToast("Bluetooth is on");
                }
                else {
                    //user denied to turn bluetooth on
                    showToast("Can't turn bluetooth on");
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);*/
   // }

  /*  //toast message function
    private void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }*/


    private void createEmployeeTable() {
        mDatabase.execSQL("CREATE TABLE IF NOT EXISTS Student " +
                "(\n" +
                "    id INTEGER NOT NULL CONSTRAINT employees_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    Name varchar(200) NOT NULL,\n" +
                "    Email varchar(200) NOT NULL,\n" +
                "    UserName varchar(200) NOT NULL,\n" +
                "    PhoneNo Varchar(200) NOT NULL\n" +
                ");"

        );
    }




}