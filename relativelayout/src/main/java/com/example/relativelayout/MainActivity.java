package com.example.relativelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private TextView titleTextView;
    private ImageView profileImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView studentInfoTextView;
    private TextView scheduleTextView;
    private TextView courseInfoTextView;
    private Button continueButton;
    private Button logoutButton;
    private Button showInfoButton;
    private Button showScheduleButton;
    private Button showCourseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        initializeViews();

        // Set up click listeners
        setupClickListeners();

        // Set initial student data
        setStudentData();
    }

    private void initializeViews() {
        titleTextView = findViewById(R.id.title);
        profileImageView = findViewById(R.id.profile_image);
        nameTextView = findViewById(R.id.name);
        emailTextView = findViewById(R.id.email);
        studentInfoTextView = findViewById(R.id.student_info);
        scheduleTextView = findViewById(R.id.schedule_info);
        courseInfoTextView = findViewById(R.id.course_info);
        logoutButton = findViewById(R.id.logout_button);
        showInfoButton = findViewById(R.id.show_info_button);
        showScheduleButton = findViewById(R.id.show_schedule_button);
        showCourseButton = findViewById(R.id.show_course_button);
    }

    private void setupClickListeners() {
        // Show Student Info button
        showInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayStudentInfo();
                Toast.makeText(MainActivity.this, "Informasi mahasiswa ditampilkan!", Toast.LENGTH_SHORT).show();
            }
        });

        // Show Schedule button
        showScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displaySchedule();
                Toast.makeText(MainActivity.this, "Jadwal kuliah ditampilkan!", Toast.LENGTH_SHORT).show();
            }
        });

        // Show Course Info button
        showCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCourseInfo();
                Toast.makeText(MainActivity.this, "Informasi mata kuliah ditampilkan!", Toast.LENGTH_SHORT).show();
            }
        });

        // Continue button click listener
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Continue button clicked!", Toast.LENGTH_SHORT).show();
                // Add your continue logic here
            }
        });

        if (logoutButton != null) {
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Keluar aplikasi...", Toast.LENGTH_SHORT).show();

                    // Tutup semua activity dan keluar dari aplikasi
                    finishAffinity();
                    System.exit(0);
                }
            });
        }

        // Profile image click listener
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Profile image clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Set initial student data
    private void setStudentData() {
        titleTextView.setText("Portal Mahasiswa");
        nameTextView.setText("Khairul Bashari");
        emailTextView.setText("E41241081@student.polije.ac.id");
    }

    // Display student information
    private void displayStudentInfo() {
        String studentInfo = "=== INFORMASI MAHASISWA ===\n\n" +
                "Nama: Khairul Bashari\n" +
                "NIM: E41241081\n" +
                "Program Studi: Teknik Informatika\n" +
                "Jurusan: Teknologi Informasi\n" +
                "Angkatan: 2024\n" +
                "Status: Aktif";

        studentInfoTextView.setText(studentInfo);
        studentInfoTextView.setVisibility(View.VISIBLE);

        // Hide other info when showing this
        scheduleTextView.setVisibility(View.GONE);
        courseInfoTextView.setVisibility(View.GONE);
    }

    // Display schedule information
    private void displaySchedule() {
        String schedule = "=== JADWAL KULIAH ===\n\n" +
                "SENIN:\n" +
                "07:00-09:00 | Struktur Data | Ruang Kelas 6.3 JTI\n" +
                "09:00-11:00 | Konsep Jaringan Komputer | Ruang Kelas 4.3 JTI\n" +
                "11:00-13:00 | Matematika Diskrit | Ruang Kelas 4.3 JTI\n" +
                "15:00-17:00 | Interpersonal Skill | Ruang Kelas 4.1 JTI\n\n" +

                "SELASA:\n" +
                "07:00-09:00 | Workshop Mobile Applications | Kelas TI 3.10\n" +
                "09:00-11:00 | Workshop Mobile Applications | Kelas TI 3.10\n" +
                "13:00-15:00 | Workshop Kualitas Perangkat Lunak | Lab Rekayasa Sistem Informasi\n" +
                "15:00-17:00 | Workshop Kualitas Perangkat Lunak | Lab Rekayasa Sistem Informasi\n\n" +

                "RABU:\n" +
                "13:00-15:00 | Workshop Sistem Informasi Berbasis Web | Kelas TI 3.1\n" +
                "15:00-17:00 | Workshop Sistem Informasi Berbasis Web | Kelas TI 3.1\n\n" +

                "KAMIS:\n" +
                "07:00-09:00 | Workshop Mobile Applications | Ruang Kelas 4.1 JTI\n" +
                "09:00-11:00 | Workshop Mobile Applications | Ruang Kelas 4.1 JTI\n" +
                "13:00-15:00 | Workshop Kualitas Perangkat Lunak | Workshop Rekayasa Sistem Informasi\n" +
                "15:00-17:00 | Workshop Kualitas Perangkat Lunak | Workshop Rekayasa Sistem Informasi\n\n" +

                "JUMAT:\n" +
                "13:00-15:00 | Workshop Sistem Informasi Berbasis Web | Kelas TI 3.1\n" +
                "15:00-17:00 | Workshop Sistem Informasi Berbasis Web | Kelas TI 3.1";


        scheduleTextView.setText(schedule);
        scheduleTextView.setVisibility(View.VISIBLE);

        // Hide other info when showing this
        studentInfoTextView.setVisibility(View.GONE);
        courseInfoTextView.setVisibility(View.GONE);
    }

    // Display course information
    private void displayCourseInfo() {
        String courseInfo = "=== INFORMASI MATA KULIAH ===\n\n" +
                "1. WORKSHOP MOBILE APPLICATIONS\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Kode: TIF130707 | SKS: 4 | Semester: 3\n" +

                "Materi:\n" +
                "• Mobile Development \n" +
                "• Java dan Grovy\n" +
                "• API Integration\n" +
                "• Testing & Deployment\n\n" +

                "2. WORKSHOP SISTEM INFORMASI BERBASIS WEB\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
                "Kode: TIF130706 | SKS: 4 | Semester: 3\n" +

                "Materi:\n" +
                "• HTML, CSS, JavaScript\n" +
                "• PHP\n" +
                "• Database MySQL & PostgreSQL\n" +
                "• Version Control Git & GitHub\n"
                ;

        courseInfoTextView.setText(courseInfo);
        courseInfoTextView.setVisibility(View.VISIBLE);

        // Hide other info when showing this
        studentInfoTextView.setVisibility(View.GONE);
        scheduleTextView.setVisibility(View.GONE);
    }

    // Utility methods
    public void setStudentData(String name, String email) {
        nameTextView.setText(name);
        emailTextView.setText(email);
    }

    public void setProfileImage(int drawableResourceId) {
        profileImageView.setImageResource(drawableResourceId);
    }

    public void setTitleText(String newTitle) {
        titleTextView.setText(newTitle);
    }

    public void setContinueButtonEnabled(boolean enabled) {
        continueButton.setEnabled(enabled);
        continueButton.setAlpha(enabled ? 1.0f : 0.5f);
    }
}