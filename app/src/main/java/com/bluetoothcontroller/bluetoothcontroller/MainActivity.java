package com.bluetoothcontroller.bluetoothcontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button ButtonLeft;
    Button ButtonRight;
    Button ButtonForward;
    Button ButtonBack; //backwards
    // bluetooth connection
    BluetoothAdapter btAdapter;
    private static final int REQUEST_ENABLE_BT = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonLeft = (Button) this.findViewById(R.id.ButtonLeft);
        ButtonRight = (Button) this.findViewById(R.id.ButtonRight);
        ButtonForward = (Button) this.findViewById(R.id.ButtonForward);
        ButtonBack = (Button) this.findViewById(R.id.ButtonBack);

        // bluetooth connection
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        if (btAdapter == null) {
            // device does not support bluetooth

        }
        else {
            // if disabled, enable
            if (!btAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);

            }

            else {
                // get paired devices
                Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    // there exists paired devices
                    for (BluetoothDevice device : pairedDevices) {
                        String dName = device.getName();
                        String MAC = device.getAddress();

                    }

                }
                // discover new devices
                btAdapter.startDiscovery();

                // create the UUID
                UUID uuid = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");

            }

        }



        // Button for setting motor power positive
        ButtonForward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // set power forward
                while (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    // move
                }

                return false;
            }
        });
        // Button for setting the motor power negatively
        ButtonBack.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                while (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    // move
                }

                return false;

            }
        });

        // Button for turning left
        ButtonLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                while (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    // move
                }


                return false;
            }
        });

        // button for turning right
        ButtonRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                while (event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
                    // move
                }
                return false;
            }
        });



    }



}
