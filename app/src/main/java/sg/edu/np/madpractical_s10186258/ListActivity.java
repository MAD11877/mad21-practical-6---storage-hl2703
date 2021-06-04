package sg.edu.np.madpractical_s10186258;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private final static String TAG ="List activity"; //starting line
    static ArrayList<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //populate user list
        userList = new ArrayList<>();
        for(int i=0; i<20; i++)
        {
            //create new random user and add to user list
            User u = new User();
            u.name = "Name" + new Random().nextInt();
            u.description = "Description " + new Random().nextInt();
            u.followed = new Random().nextInt()%2 == 0;
            userList.add(u);
        }





        //createUser(userList);

        //create recycler view
        RecyclerView recyclerViewCustom = findViewById(R.id.recyclerView);

        Adapter cAdapter = new Adapter(userList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        recyclerViewCustom.setLayoutManager(cLayoutManager);
        recyclerViewCustom.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCustom.setAdapter(cAdapter);


        //intent passing code
        //Intent intent = new Intent(ListActivity.this, MainActivity.class);
       // intent.putExtra("userList", userList); //send info to new activity in a map

    }




    private void createUser(ArrayList<User> userList) {
        for (int i=0;i<21;i++) {
            User u = new User();
            u.name = "Name" + new Random().nextInt();
            u.description = "Description " + new Random().nextInt();
            u.followed = new Random().nextInt()%2 == 0;
            userList.add(u);

        }

    }

    //Upon clicking the View button, a random integer will be generated. The MainActivity
// (created in previous practical) will be launched, and the random integer is sent over.
    private int generateInt() {
        Random ran = new Random();
        int ranVal = ran.nextInt(1000);//assign var as it will return
        return ranVal;
    }

   private boolean generateBool() {

            Random rd = new Random(); // creating Random object
            boolean ranBool= rd.nextBoolean(); // a random boolean
            return ranBool;

        }
    }


