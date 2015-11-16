package com.example.administrator.customlist;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//comment added by ----

public class MainActivity extends AppCompatActivity {

    String titleSend;
    String descSend;

    String[] str={"Hockey","Football","Cricket","Badminton","Tennis","Chess","Basketball","Air Hockey","Ice Skating","Table Tennis"};
    ListView lv;
    int[] images={R.drawable.hockey,R.drawable.football,R.drawable.cricket,R.drawable.badminton
    ,R.drawable.tennis,R.drawable.chess,R.drawable.basketball,R.drawable.airhockey,R.drawable.iceskating,R.drawable.tabletennis};

    String[] descriptions={
      "Hockey is a family of sports in which two teams play against each other by trying to maneuver a ball or a puck into the opponent's goal using a hockey stick. In many areas, one sport (typically field hockey or ice hockey[1]) is generally referred to simply as hockey.",
            "Football refers to a number of sports that involve, to varying degrees, kicking a ball with the foot to score a goal. Unqualified, the word football is understood to refer to whichever form of football is the most popular in the regional context in which the word appears: association football (known as soccer in some countries) in the United Kingdom; gridiron football (specifically American football or Canadian football) in the United States and Canada; Australian rules football or rugby league in different areas of Australia; Gaelic football in Ireland; and rugby football (specifically rugby union) in New Zealand.[1][2] These different variations of football are known as football codes."
            ,"Cricket is a bat-and-ball game played between two teams of 11 players each on a field at the centre of which is a rectangular 22-yard-long pitch. The game is played by 120 million players in many countries, making it the world's second most popular sport.[1][2][3] Each team takes its turn to bat, attempting to score runs, while the other team fields. Each turn is known as an innings (used for both singular and plural).",
            "Badminton is a recreational sport played by either two opposing players (singles) or two opposing pairs (doubles), that take positions on opposite halves of a rectangular court divided by a net. Players score points by striking a shuttlecock with their racquet so that it passes over the net and lands in their opponents' half of the court.",
            "Tennis is a racquet sport that can be played individually against a single opponent (singles) or between two teams of two players each (doubles). Each player uses a racquet that is strung with cord to strike a hollow rubber ball covered with felt over or around a net and into the opponent's court.",
            "Chess is a two-player sport[1][2] played on a chessboard, a checkered gameboard with 64 squares arranged in an eight-by-eight grid. Chess is played by millions of people worldwide in homes, urban parks, clubs, online, correspondence, and in tournaments. In recent years, chess has become part of some school curricula.",
            "Basketball is a sport played by two teams of five players on a rectangular court. The objective is to shoot a ball through a hoop 18 inches (46 cm) in diameter and 10 feet (3.048 m) high mounted to a backboard at each end. Basketball is one of the world's most popular and widely viewed sports.[1] ",
            "Air hockey is a game for two competing players trying to score points in the opposing player's goal using a table having a special low-friction playing surface.",
            "Ice skating is moving on ice by using ice skates. It can be done for a variety of reasons, including exercise, leisure, traveling, and various sports. Ice skating occurs both on specially prepared ice surfaces (arenas, tracks, parks), both indoors and outdoors, as well as on naturally occurring bodies of frozen water, such as ponds, lakes and rivers.",
            "Table tennis, also known as ping pong, is a sport in which two or four players hit a lightweight ball back and forth across a table using a small, round bat. The game takes place on a hard table divided by a net."

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayOptions( android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);



        lv=(ListView)findViewById(R.id.listView);

       // Creating object of AdapterCustom class we made
        AdapterCustom adapter = new AdapterCustom(this,str,descriptions,images);


        lv.setAdapter(adapter);

        lv.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        titleSend=str[i];
                        descSend=descriptions[i];


                        Intent intent = new Intent(MainActivity.this,DescriptionClass.class);
                        intent.putExtra("title",titleSend);
                        intent.putExtra("desc",descSend);
                        startActivity(intent);


                        //Toast.makeText(getApplicationContext(),""+titleSend,Toast.LENGTH_SHORT).show();




                    }
                }


        );



    }


}
class AdapterCustom extends ArrayAdapter<String>{

    String[] descriptionArray;
    String[] titleArray;
    int[] imageArray;

    public AdapterCustom(Context context, String[] titles,String[] descriptions ,int[] image) {
        super(context, R.layout.single_row_view,titles);
        this.descriptionArray=descriptions;
        this.titleArray=titles;
        this.imageArray=image;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row_view,parent,false);
        TextView titles = (TextView)row.findViewById(R.id.defaultTiltle);
        TextView description =(TextView)row.findViewById(R.id.defaultDescription);
        ImageView img=(ImageView)row.findViewById(R.id.defaultImage);
        img.setImageResource(imageArray[position]);

        titles.setText(titleArray[position]);
        description.setText(descriptionArray[position]);



        return row;
    }

}


