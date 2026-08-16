package com.jiva.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private LinearLayout chatLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(Color.rgb(5, 12, 20));

        TextView header = new TextView(this);
        header.setText("JIVA AI");
        header.setTextColor(Color.WHITE);
        header.setTextSize(28);
        header.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        header.setGravity(Gravity.CENTER);
        header.setPadding(0, 40, 0, 20);
        root.addView(header);

        TextView status = new TextView(this);
        status.setText("● JIVA Android Core");
        status.setTextColor(Color.rgb(60, 200, 255));
        status.setTextSize(15);
        status.setGravity(Gravity.CENTER);
        root.addView(status);

        ScrollView scrollView = new ScrollView(this);

        chatLayout = new LinearLayout(this);
        chatLayout.setOrientation(LinearLayout.VERTICAL);
        chatLayout.setPadding(25, 30, 25, 20);

        addMessage("JIVA", "Hello! Main JIVA hoon. Aap mujhse baat kar sakte hain.");

        scrollView.addView(chatLayout);

        LinearLayout.LayoutParams scrollParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
        root.addView(scrollView, scrollParams);

        LinearLayout controls = new LinearLayout(this);
        controls.setOrientation(LinearLayout.HORIZONTAL);
        controls.setGravity(Gravity.CENTER);
        controls.setPadding(15, 10, 15, 25);

        Button voice = new Button(this);
        voice.setText("🎙 Voice");

        Button chat = new Button(this);
        chat.setText("💬 Chat");

        Button tools = new Button(this);
        tools.setText("⚙ Tools");

        controls.addView(voice);
        controls.addView(chat);
        controls.addView(tools);

        root.addView(controls);

        voice.setOnClickListener(v ->
                Toast.makeText(this, "Voice feature next step mein add hoga",
                        Toast.LENGTH_SHORT).show());

        chat.setOnClickListener(v ->
                Toast.makeText(this, "Chat feature next step mein connect hoga",
                        Toast.LENGTH_SHORT).show());

        tools.setOnClickListener(v ->
                Toast.makeText(this, "JIVA Tools", Toast.LENGTH_SHORT).show());

        setContentView(root);
    }

    private void addMessage(String sender, String message) {
        TextView text = new TextView(this);
        text.setText(sender + ": " + message);
        text.setTextColor(Color.WHITE);
        text.setTextSize(17);
        text.setPadding(15, 15, 15, 15);
        chatLayout.addView(text);
    }
}
