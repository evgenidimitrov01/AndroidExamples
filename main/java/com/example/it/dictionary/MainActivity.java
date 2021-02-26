package com.example.it.dictionary;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    // A list of words and definitions to show in our app.
    // In a later lecture, we will read the words from a file instead.
    private static final String[] WORDS = {
            "мигар", "фърфалак", "тинтири-минтири", "мушморок", "мракобесие",
    };

    private static final String[] MEANINGS = {
            "За изразяване на учудване и съмнение; нима.",
            "1. Пумпал.\n2. Прен. Подвижно малко дете. ",
            "Измислици или глупави приказки.",
            "1. Скрит, потаен, дребен човек.\n2. Привидно скромен пробивен човек, който се завира навсякъде.",
            "Дейност и възгледи срещу просветата."
    };


    // a dictionary of {key -> value} pairs for lookup
    private Map<String, String> dictionary;

    private Context myActivity;

    /*
     * This method runs when the app is first loading up.
     * It sets up the dictionary of words and definitions.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myActivity = this;

        // convert the array into a map
        dictionary = new HashMap<>();

        for (int i = 0; i < WORDS.length; i++)
            dictionary.put(WORDS[i], MEANINGS[i]);

        // put the dictionary words into an Adapter so they can be seen in ListView
        ListView list = findViewById(R.id.listViewWords);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(
                myActivity,                                        // activity
                android.R.layout.simple_list_item_1,         // layout,
                new ArrayList<String>(dictionary.keySet())   // array
        );
        list.setAdapter(adapter);
        */
        list.setAdapter(new MyAdapter(myActivity, WORDS));

        // this is the code that should run when the user taps items in the list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // look up definition of word and display as a Toast
                String word = parent.getItemAtPosition(position).toString();
                String definition = dictionary.get(word);
                Toast.makeText(myActivity, definition,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}


