package sg.edu.np.madpractical_s10186258;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    User u;
    private TextView numValue;
    private TextView desText;
    private final static String TAG="Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dump all code here
        Log.v(TAG, "Main activity created!");
        //retrive info
        Intent receivingEnd = getIntent();
        int value = receivingEnd.getIntExtra("id",0);
        u = ListActivity.userList.get(value);
        //String ranNum = receivingEnd.getStringExtra("Name");
        numValue=findViewById(R.id.ranNum);
        numValue.setText(u.name);//display name text

        //String description = receivingEnd.getStringExtra("Des");
        desText=findViewById(R.id.editText);
        desText.setText(u.description);//display description text
        setFollowBtn();

        //ArrayList<User> userList=receivingEnd.getA
        /*final String[] followed = {receivingEnd.getStringExtra("followed")};
        Log.v(TAG, "followed?:"+ followed[0]);
        final Button followBtn =findViewById(R.id.followBtn);
        if (followed[0] =="true"){

            followBtn.setText("Unfollow");
            followBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //inner class
                    Toast.makeText(getApplicationContext(),"unfollowed",Toast.LENGTH_SHORT).show();
                    followBtn.setText("Follow");
                    followed[0] ="false";

                }



            });
        }
        else{

            followBtn.setText("Follow");
            followBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //inner class
                    Toast.makeText(getApplicationContext(),"followed",Toast.LENGTH_SHORT).show();
                    followBtn.setText("unfollow");
                    followed[0]="true";

                }



            });
*/

        }

    private void setFollowBtn() {
        Button b = findViewById(R.id.followBtn);
        if(u.followed) {
            b.setText("Unfollow");
        }
        else {
            b.setText("Follow");
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.followed = !u.followed;//make follow to unfollowed
                if(u.followed)
                    Toast.makeText(getApplicationContext(),"followed",Toast.LENGTH_SHORT).show();//toast message
                else
                    Toast.makeText(getApplicationContext(),"unfollowed",Toast.LENGTH_SHORT).show();
                setFollowBtn();
            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Debug", "start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Debug", "stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Debug", "destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Debug", "pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Debug", "resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Debug", "restart");
    }


        /*followBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //inner class

                if (followed=="true"){
                    Log.v(TAG, "Button pressed.");
                    followBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"unfollowed",Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.v(TAG, "Button pressed.");
                    followBtn.setText("Follow");
                    Toast.makeText(getApplicationContext(),"followed",Toast.LENGTH_SHORT).show();
                }

            }



        });
*/

       /* Button button =findViewById(R.id.messageBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inner class
                Log.v(TAG, "Button pressed.");
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

            }
        });*/


        /*final boolean[] followed = {false};
        final Button followBtn =findViewById(R.id.followBtn);
        followBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //inner class
                Log.v(TAG, "Button pressed.");
                if(!followed[0]) {
                    followBtn.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"followed",Toast.LENGTH_SHORT).show();
                    followed[0] =true;
                }
                else{
                    followBtn.setText("follow");
                    Toast.makeText(getApplicationContext(),"unfollowed",Toast.LENGTH_SHORT).show();
                    followed[0] =false;
                }

            }
        });*/

    }
