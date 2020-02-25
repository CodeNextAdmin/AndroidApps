package com.example.scrollviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button likeBtn;
    private ImageButton sendMsgBtn;
    private EditText inputTxt;
    private TextView outputTxt;
    private TextView likesTxt;
    private ImageView imgView;

    int likes = 0;
    int postcount = 0;

    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<Post> postsArray = new ArrayList<>();

    private Post currentPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeBtn = findViewById(R.id.likeBtn);
        sendMsgBtn = findViewById(R.id.setMessageBtn);
        inputTxt = findViewById(R.id.editText);
        outputTxt =findViewById(R.id.messageTxtView);
        likesTxt = findViewById(R.id.likesTxtView);
        imgView = findViewById(R.id.imageView);

        messages.clear();
        outputTxt.setTextSize(30);

        createPosts();

        currentPost = postsArray.get(0);

        inputTxt.setText("message...");





    }

    public void setMessages(View v){


        if(inputTxt.getText().length() > 1 ) {

            String newMessage = inputTxt.getText().toString() + "\n";

            messages.add(newMessage);

            currentPost.getMessagesArray().add(newMessage);

            displayMessages();

            inputTxt.setText("");

        }



    }

    public void addLike(View v){



        int currentLikes = currentPost.getLikes();

        currentPost.setLikes(currentLikes+1);

        likesTxt.setText("Likes: " + currentPost.getLikes());

    }

    public void displayMessages(){

        outputTxt.setText("");

        if (currentPost.getMessagesArray().size() > 0) {

            for (int i = 0; i < currentPost.getMessagesArray().size(); i++) {

                outputTxt.append(messages.get(i));
            }

        }
    }

    public void createPosts(){

        ArrayList<String> arr = new ArrayList<>() ;

        Post first = new Post(0, "Paco", arr ,(R.drawable.android_paco) );
        Post second = new Post(0, "Sam", arr ,(R.drawable.andorid1) );
        Post third = new Post(0, "Bella", arr ,(R.drawable.androiod2) );
        Post fourth = new Post(0, "Steph", arr ,(R.drawable.android3));

        postsArray.add(first);
        postsArray.add(second);
        postsArray.add(third);
        postsArray.add(fourth);


    }

    public void changePost(View v){
        Log.d("changePost", "Changing Post!");

        if(postcount >= postsArray.size()){

            postcount = 0;

        }else

        postcount ++;
        currentPost = postsArray.get(postcount);

        //update the image

        int currImg = currentPost.getImgName();
        imgView.setImageResource(currImg);




    }

}
