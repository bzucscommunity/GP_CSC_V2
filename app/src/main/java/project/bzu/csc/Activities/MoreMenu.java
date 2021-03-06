package project.bzu.csc.Activities;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

import project.bzu.csc.R;


public class MoreMenu extends AppCompatActivity implements View.OnClickListener {

//    ChipGroup group;
//    Chip topic, question;

    Button btnDatePicker, btnTimePicker;
    Button go;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_menu_layout);
        BottomNavigationView BttomnavigationView =findViewById(R.id.bottomNavigationView);
        BttomnavigationView.setSelectedItemId(R.id.homeIcon);
        BttomnavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeIcon:
                        startActivity(new Intent(getApplicationContext(), Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.question:
                        startActivity(new Intent(getApplicationContext(), Question.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.topic:
                        startActivity(new Intent(getApplicationContext(), Topic.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), Search.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.menu:
                        startActivity(new Intent(getApplicationContext(), Favorits.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        Intent intent = getIntent();
        name = intent.getStringExtra("subjectName");

        btnDatePicker=(Button)findViewById(R.id.btn_date);
        go=(Button)findViewById(R.id.btn);

        txtDate=(EditText)findViewById(R.id.in_date);


        btnDatePicker.setOnClickListener(this);
        go.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();


        } else if (v == go) {
            Intent intent = new Intent(getApplicationContext(), SearchCardView.class);
            intent.putExtra("subjectNameFromSearch",name);
            intent.putExtra("date",txtDate.getText().toString().trim());
            intent.putExtra("filter",true);
            startActivity(intent);

        }

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.more_menu_layout);
        //PopupWindow display method
//        group = findViewById(R.id.group1);
//        topic = findViewById(R.id.topicch1);
//        question = findViewById(R.id.Questionch2);

//        CompoundButton.OnCheckedChangeListener filterChipListener = new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Log.i("mirannn", buttonView.getId() + "");
//            }
//        };
//        topic.setOnCheckedChangeListener(filterChipListener);
//        question.setOnCheckedChangeListener(filterChipListener);

//                topic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // check whether the chips is filtered by user or
//                // not and give the suitable Toast message
//                if (topic.isChecked()) {
//                    startActivity(new Intent(getApplicationContext(), CreatePostFromHome.class));
//                } else {
//                    Toast.makeText(MoreMenu.this, "JAVA deselected", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        question.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // check whether the chips is filtered by user or
//                // not and give the suitable Toast message
//                if (question.isChecked()) {
//                    Toast.makeText(MoreMenu.this, "Python selected", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MoreMenu.this, "Python deselected", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


  //  }
//    public void showPopupWindow ( final View view){
//
//
//        //Create a View object yourself through inflater
//        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
//        View popupView = inflater.inflate(R.layout.more_menu_layout, null);
//
//        //Specify the length and width through constants
//        int width = 700;
//        int height = 500;
//
//        //Make Inactive Items Outside Of PopupWindow
//        boolean focusable = true;
//
//        //Create a window with our parameters
//        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//        //Set the location of the window on the screen
//        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
//
//        //Initialize the elements of our window, install the handler
//
//
//        //Handler for clicking on the inactive zone of the window
//
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                //Close the window when clicked
//                popupWindow.dismiss();
//                return true;
//            }
//        });
//    }


}