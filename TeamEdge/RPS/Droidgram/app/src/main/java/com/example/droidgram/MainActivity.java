package com.example.droidgram;

import androidx.appcompat.app.AppCompatActivity;

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


    private ImageButton likeBtn;
    private Button sendMsgBtn;
    private EditText inputTxt;
    private TextView outputTxt;
    private TextView likesTxt;
    private TextView postName;
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


        likeBtn = findViewById(R.id.likesBtn);
        sendMsgBtn = findViewById(R.id.setMessageBtn);
        inputTxt = findViewById(R.id.editText);
        outputTxt =findViewById(R.id.messageTxtView);
        postName = findViewById(R.id.postName);
        likesTxt = findViewById(R.id.likesTxtView);
        imgView = findViewById(R.id.imageView);

        messages.clear();
        outputTxt.setTextSize(30);

        createPosts();


        currentPost = postsArray.get(0);



    }


    public void setMessages(View v){


        if(inputTxt.getText().length() > 1 ) {

            String newMessage = inputTxt.getText().toString() + "\n";

            messages.add(newMessage);

            currentPost.getMessagesArray().add(newMessage);
            //currentPost.setMessagesArray(messages);



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
                Log.d("displayMssg", messages.get(i));
            }

        } else Log.d("displayMssg", "message array is empty");

        //clear the messages


    }

    public void createPosts(){

        ArrayList<String> arr = new ArrayList<>() ;

        Post first = new Post(0, "Paco", arr ,(R.drawable.android) );
        Post second = new Post(0, "Sam", arr ,(R.drawable.android2) );
        Post third = new Post(0, "Bella", arr ,(R.drawable.android3) );
        Post fourth = new Post(0, "Steph", arr ,(R.drawable.android4));



        postsArray.add(first);
        postsArray.add(second);
        postsArray.add(third);
        postsArray.add(fourth);

    }

    public void changePost(View v){
        Log.d("changePost", "Changing Post!");

        //push back the current post into the posts array by its index to "save" it.

        //postsArray.set(postcount, currentPost);

         Log.d("msgs" , ""+ messages);
         messages.clear();

        if(postcount == postsArray.size()){

            postcount = 0;
        }

        currentPost = postsArray.get(postcount);

        //update the image

        int currImg = currentPost.getImgName();

        Log.d("changePost", "current" + postcount);

        //updates the image
        imgView.setImageResource(currImg);


        //update the username/postname
        postName.setText(currentPost.getPostName());



        //update the Textview to reflect number of likes
        likesTxt.setText("Likes: " + currentPost.getLikes());

        Log.d("messages", "curentPost likes: " + currentPost.getLikes());



        //updates the text view with current post array of messages
        displayMessages();

        //update likes

        postcount++;


        Log.d("post array " ," size:  " + postsArray.size());


    }
}
