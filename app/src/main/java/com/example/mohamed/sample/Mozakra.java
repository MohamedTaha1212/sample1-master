package com.example.mohamed.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Mozakra extends AppCompatActivity {
    String ur;//virable to store links of materials

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner faculty = (Spinner) findViewById(R.id.faculty);
        final Spinner department = (Spinner) findViewById(R.id.department);
        final Spinner year = (Spinner) findViewById(R.id.year);
        final Spinner semester = (Spinner) findViewById(R.id.semester);
        final Spinner material = (Spinner) findViewById(R.id.material);
        final Button goButton = (Button) findViewById(R.id.Go);



        /*faculties*/
        ArrayAdapter facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty,
                android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(facultyAdapter);

        faculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                year.setVisibility(View.GONE);
                semester.setVisibility(View.GONE);
                material.setVisibility(View.GONE);
                if (faculty.getSelectedItem().toString().equals("Choose your Faculty....")) {
                    Toast.makeText(Mozakra.this, "Choose your faculty..", Toast.LENGTH_SHORT).show();
                    department.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);

                    /*Science*/
                } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.departmentSC, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*departments*/
        department.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        semester.setVisibility(View.GONE);
                        material.setVisibility(View.GONE);
                        /*Science*/
                        if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                            if (department.getSelectedItem().toString().equals("حقوق انسان مشترك")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.material_حقوق_انسان, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Industrial Chemistry")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialIC, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Biochemistry")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBC, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Geology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPG, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Physics")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPH, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Mathematics")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMA, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Microbiology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Biotechnology")) {
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(yearAdapter);
                            }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*material*/
        material.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()

                {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {

                        if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                           if (material.getSelectedItem().toString().equals("نووية واشعاعية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=ar&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGTUExanB2eXhCLTA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("فزياء رياضية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGd2hsZXM0aHNsWVk&hl=en&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ذرية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGemJ2Q2NFQmpTdlk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ضوء فيزيائى د.آمنة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1Rw_mT9tt0CUWer9GZnrJ_oB2Bb3n5tz7&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("حرارة وخواص د/بهجت")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1v8hjyJPjkIm5KYXaHR7XO8An_UTbOJbM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("جوامد 1")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguSHM0UDRCQ2xBeDQ&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("وراثة حيوية وجزيئية د.سامية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguU3U5NWtQbm03b0U&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ميكروبايولوجى الغذاء وامراض النبات د.صالحة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguOW43STdyMnRqa0U&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("فطريات ووراثة ميكروبات د.عبدالحميد")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguYTFmOTlOWjlaQVE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("طحالب د.الهام")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguNldCQTNXMGNfYTQ&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ترشيح نبات وشكل ظاهرى د.الشحات")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguZmU2OS1GeXBTd00&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ترشيح متقدم د.الشحات")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguTXYzM1VsSS1qelU&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("بكتريا عامة د.صالحة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRgubUpnSnd0UTllWk0&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("امتحانات ميكروبايولوجى")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1OgbZxN1Qt7Os9zgk8vx3s4TiEAR57ygV&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحاسب د/وائل فواز")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRgucXo5ZHc5T3N0d00&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("معادلات تفاضلية عادية د.هبة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFRE5oWHpteTlnRm8&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("توبولوجى د.محمد رمضان")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRguRW93UldCdlU4QXM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("تحليل مركب د.محمد صالح")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFZlZ2OERSRVBKVDA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("تحليل رياضة 2 د/هبة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFTW1pdWhqd0txQlk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("امتحانات قسم رياضة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFaVhMYjFFMDlEeTA&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("احصاء حيوى د/محمد الشحات")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRgub29taGdWZ2EwbDQ&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("امتحانات كيمياء صناعية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1XV6UYQd5iMj1-TEoPvajfRqePdyKHOtq&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("نارية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFUEQtNUZXOWJqdzQ&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحاسب د/وائل")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SIV2FfekF5RnFpVEk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحيوان د/رانيا+د/هويدا")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SIVVVqbjVISURyLTg&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("حرارة وخواص1 د/بهجت")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SIeVN5VnJ4cEZBVkE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("جيولوجيا عامة د/اسماعيل سيد")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SITzV1N3had3hFdUE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("اسس كيمياء فيزيائية د/شيماء خلف")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SIZzFfOWFlUkpYa3M&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Structural Geology د.فارس")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B31vLTnOP-SIUzIyNVgzMzdiV2M&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Remote sensing د.فارس")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFSFJDeV9kbjB6d0k&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("فرقة تالتة ترم اول")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1-fT5hGzujVdWjo4SqV6-Suw2aI6dXdrv&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("عينات صخور ومعادن")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0Bx1TXZ-UjRgucmJ5bWFIXzBRRFU&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("خرائط جيولوجية")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFVF9qMktEU1dMRmM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("امتحان marine")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFZzU3R1otbHUwOGc&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Survey")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFT21IZFFNdDAza3c&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Sedimentology د.حسن")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFM193WHVJTlFuYlk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Microfossils د.حسن")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFSjVySGdCbGhuemM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Metamorphic")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFUWUtbzJtR1ZSOE0&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Introduction of Structural Geology د.حسن")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFRGRlYzVzUmhIMlE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Hydrogeology")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1te4KR6RLNiSaGqCmWA-c-3HsPTM2ZTtC&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Hydrogeochemistry")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1te4KR6RLNiSaGqCmWA-c-3HsPTM2ZTtC%3Fpli%3D1&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Geophysics د.سعادة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFYkNvX29BamlPOVk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Geophysics Methods")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFSEV2cEFWVy1veGM&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Electrics د.سعادة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFQ0NDWFBuWlJseVE&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Archeological Dating methods 2")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFUGRRWUloN0lfMkk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("Absolute Dating")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0ByJz1l2rodbFX294dFF5cG1kUnc&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("حقوق انسان")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1cXTaXur72mmMK9KMI4K1VUK40ShyvOjW&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("ملخص كيمياء حيوى د.وليد")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F182w5-kX6cLynxvoIVS89T6b6CUwALHan&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("امتحانات كيمياء حيوى")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F1FtkFhC06SKaYNeLiIhZK8NLknD5-Ga6E&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("وراثة خلوية د.احمد عيسى")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGZEhlc3FkQW1fREU&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("كيمياء حيوى (كربوهيدرات) د.وليد سراج")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGazhPVXpRWVFFYm8&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }else if (material.getSelectedItem().toString().equals("علم الدم د.عايدة")){
                               goButton.setVisibility(View.VISIBLE);
                               ur = "https://accounts.google.com/signin/v2/sl/pwd?hl=en&passive=true&continue=https%3A%2F%2Fdrive.google.com%2Fdrive%2Ffolders%2F0B9fM-j_4HhpGV3ZUTE1IX05iekk&service=writely&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
                           }
                           }
                        }
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        goButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mozakra.this, webView_Pdf.class);
                intent.putExtra("url", ur);
                startActivity(intent);

            }
        });
    }

}
