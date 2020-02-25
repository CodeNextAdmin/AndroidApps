package com.example.textviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txtView);

        String txt = "lobortis arcu, quis mattis diam sodales euismod. Quisque et tincidunt ante. Etiam auctor leo eu orci elementum, vel consectetur ligula rutrum. Nullam vel velit metus. Vivamus consequat iaculis viverra. Sed arcu nulla, pellentesque ac libero sed, porta cursus nisi. Duis gravida nulla diam, eget consectetur nunc cursus sed. Nam a lacus eget odio pretium luctus. Ut ultricies leo nec tellus varius, quis egestas dui placerat. Duis sed augue nibh. Proin sed sollicitudin lorem, at rutrum dolor.\n" +
                "\n" +
                "In sit amet pellentesque magna, a accumsan leo. Suspendisse non sollicitudin orci. Duis at metus ac nibh sollicitudin bibendum. Cras quis tellus blandit, molestie est et, pharetra nibh. Nunc faucibus placerat aliquam. In pellentesque risus posuere nisi egestas mollis id ac ligula. Vestibulum convallis purus enim, vitae vehicula ex lacinia a. Curabitur sapien dui, tristique nec dolor tempus, egestas fringilla lectus. In nisi eros, efficitur eget diam viverra, semper convallis odio. Maecenas ut odio eget elit tempor elementum eu ac enim. Praesent id purus vel felis ultrices egestas. Sed semper est eget lobortis dignissim. Aenean consequat in purus at gravida. Phasellus a imperdiet tortor, ac congue nisi. Integer ac odio est. Cras bibendum elementum lobortis.\n" +
                "\n" +
                "Donec gravida feugiat mi. Donec ut pharetra purus. Vestibulum ut turpis feugiat, facilisis elit non, convallis ante. Suspendisse suscipit sapien vel ornare congue. Phasellus vitae tellus eu lorem vehicula facilisis mollis tristique urna. Proin eget ligula ac ipsum tristique imperdiet non pellentesque justo. Praesent risus nulla, lobortis et sapien at, iaculis bibendum est. Curabitur eu posuere dui. Vivamus consequat eleifend luctus.\n" +
                "\n" +
                "Vestibulum in sem ac metus vehicula pulvinar. Integer faucibus lorem in porta condimentum. Nunc egestas ante vitae nulla sagittis bibendum. Donec ut hendrerit nibh. Cras egestas sem eget ligula consequat, eu congue eros posuere. Proin eu mauris nibh. Praesent posuere ut ex nec ullamcorper. Aenean ut viverra urna. Aenean feugiat felis ut dolor pretium egestas. Integer rhoncus elementum urna, nec lacinia nibh bibendum nec. Nunc nec fringilla augue, at placerat quam. Vivamus dictum non nulla in ultrices.\n" +
                "\n" +
                "Proin commodo lacus ante, eget dignissim dolor elementum et. Vivamus at metus placerat, maximus leo ac, facilisis turpis. Etiam sit amet orci sed massa gravida pulvinar. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Curabitur ut nisi sodales, tincidunt ligula ac, facilisis orci. Nullam at egestas nisl. Donec ultricies, risus porta vulputate viverra, nulla eros lacinia quam, sit amet fringilla orci ligula eu purus. Duis lacinia varius velit eget pharetra. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc luctus nibh massa. Nulla sagittis diam gravida pretium commodo. In dictum tempus dapibus. Mauris nec facilisis nibh, eu auctor nulla.\n" +
                "\n" +
                "Nunc rutrum tincidunt fermentum. Vivamus viverra et ante malesuada ultricies. Duis pharetra tortor eu velit gravida, non placerat magna hendrerit. Proin consequat nulla at tincidunt pulvinar. Fusce in ipsum sed orci tempor pharetra. In hac habitasse platea dictumst. Morbi interdum, odio vitae viverra tincidunt, sem sem hendrerit nisl, ac dignissim lectus risus vel lorem.\n" +
                "\n" +
                "Nam eu turpis sem. Suspendisse potenti. Nunc volutpat neque massa, vel lacinia sapien elementum eu. Donec eget cursus mi. Pellentesque bibendum iaculis turpis in vulputate. Suspendisse potenti. Quisque aliquam tincidunt tincidunt. Cras egestas turpis ut sapien mollis ornare. Donec eu semper odio, condimentum cursus lacus. Praesent sagittis vel felis ut fringilla. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Morbi hendrerit posuere elit ac molestie.\n" +
                "\n" +
                "Nunc porta libero sit amet pulvinar dignissim. Vestibulum ac velit a ante consectetur eleifend. Aliquam congue, augue ac commodo dignissim, dui tellus ultricies ligula, non pretium nunc metus eget ex. Maecenas congue in lectus eget malesuada. Maecenas quam velit, facilisis in urna non, interdum euismod lacus. Mauris et urna lectus. Suspendisse ultrices quam quam, at tempus enim iaculis consequat. Donec vitae justo urna. Quisque eu erat semper, tincidunt turpis et, faucibus purus. Nulla non erat nisi. Aenean nec commodo lorem, commodo viverra tellus. Quisque neque nisi, convallis eget est sed, porta porta orci. Integer sagittis metus in massa sagittis, quis facilisis libero fermentum. Aenean erat tortor, lacinia vel blandit eu, convallis eget velit. Curabitur nec sollicitudin erat. Phasellus facilisis justo ut enim dignissim consequat.";

        txtView.setText(txt);

        txtView.setMovementMethod(new ScrollingMovementMethod());
    }
}
