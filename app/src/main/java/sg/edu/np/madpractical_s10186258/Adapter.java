package sg.edu.np.madpractical_s10186258;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    //default 4 parts

    ArrayList<User> data;


    //public Adapter(ArrayList<User> userList) {data=userList;
    //}
    public Adapter(ArrayList<User> input){
        data = input;
    }
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){

        //View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent, false);
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recyclerview2,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recyclerview,
                    parent,
                    false
            );
        }


        return new ViewHolder(item);
    }
    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(data.get(position).name.substring(data.get(position).name.length()-1));
    }
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position){
        final User u = data.get(position);
        holder.txt.setText(u.name);
        holder.txt2.setText(u.description);






       /* final User info = data.get(position);
        holder.image.setImageResource(R.mipmap.ic_launcher_round);
        holder.txt.setText(info.getName());
        holder.txt2.setText(info.getDescription());*/
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v) {
                    Log.d("Debug", "Image clicked");

                    new AlertDialog.Builder(holder.image.getContext())
                            .setTitle("Profile")
                            .setMessage(u.name)
                            .setPositiveButton("View", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent viewProfile = new Intent(holder.image.getContext(), MainActivity.class);
                                    viewProfile.putExtra("id", position);
                                    holder.image.getContext().startActivity(viewProfile);
                                }
                            })
                            .setNegativeButton("Close", null)
                            .show();


              /*  AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(info.getName());
                builder.setTitle("Profile");
                builder.setCancelable(false);//will not disappear when user click outside
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("Name", info.getName()); //send info to new activity in a map
                        intent.putExtra("Des", info.getDescription()); //send info to new activity in a map
                        intent.putExtra("ulist", data); //send info to new activity in a map

                        context.startActivity(intent);

                    }
                });
                builder.setNegativeButton("Close", null);
                AlertDialog alert= builder.create();
                alert.show();
*/
            }
        });


    }
    @Override

    public int getItemCount() {
        return data.size();
    }





}