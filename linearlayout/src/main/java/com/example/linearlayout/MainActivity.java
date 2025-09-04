package com.example.linearlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private Button tab1, tab2, tab3;
    private LinearLayout homeTab, profileTab, settingsTab;
    private TextView studentInfoText, scheduleText, workshopInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);

        // Initialize tab content areas
        homeTab = findViewById(R.id.home_tab);
        profileTab = findViewById(R.id.profile_tab);
        settingsTab = findViewById(R.id.settings_tab);

        // Initialize TextViews for displaying information
        studentInfoText = findViewById(R.id.student_info_text);
        scheduleText = findViewById(R.id.schedule_text);
        workshopInfoText = findViewById(R.id.workshop_info_text);

        // Set initial active tab
        setActiveTab(tab1, homeTab);

        // Set click listeners for tabs
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveTab(tab1, homeTab);
            }
        });

        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveTab(tab2, profileTab);
                displayWorkshopInfo(); // Otomatis tampilkan info workshop saat tab profile dibuka
            }
        });

        tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveTab(tab3, settingsTab);
                displaySchedule(); // Otomatis tampilkan jadwal saat tab mata kuliah dibuka
            }
        });
    }

    private void setActiveTab(Button activeButton, LinearLayout activeTab) {
        // Reset all buttons
        resetAllTabs();

        // Set active button style
        activeButton.setTextColor(getResources().getColor(android.R.color.white));
        activeButton.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.holo_blue_dark));

        // Hide all tabs
        homeTab.setVisibility(View.GONE);
        profileTab.setVisibility(View.GONE);
        settingsTab.setVisibility(View.GONE);

        // Show active tab
        activeTab.setVisibility(View.VISIBLE);
    }

    private void resetAllTabs() {
        // Reset all button styles
        tab1.setTextColor(getResources().getColor(android.R.color.black));
        tab2.setTextColor(getResources().getColor(android.R.color.black));
        tab3.setTextColor(getResources().getColor(android.R.color.black));

        tab1.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.white));
        tab2.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.white));
        tab3.setBackgroundTintList(ContextCompat.getColorStateList(this, android.R.color.white));
    }

    // Method untuk button di home tab - dipanggil dari XML onClick
    public void onHomeButtonClick(View view) {
        displayStudentInfo();
        Toast.makeText(this, "Button diklik!", Toast.LENGTH_SHORT).show();
    }

    // Method to display student information
    private void displayStudentInfo() {
        String studentInfo = "=== INFORMASI MAHASISWA ===\n\n" +
                "Nama: Khairul Bashari\n" +
                "NIM: E41241081\n" +
                "Program Studi: Teknik Informatika\n" +
                "Jurusan: Teknologi Informasi\n" +
                "Angkatan: 2024\n" +
                "Status: Aktif";

        studentInfoText.setText(studentInfo);
        studentInfoText.setVisibility(View.VISIBLE);
    }

    // Method to display workshop information for profile tab
    private void displayWorkshopInfo() {
        String workshopInfo = "=== INFORMASI MATA KULIAH ===\n\n" +
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
        workshopInfoText.setText(workshopInfo);
        workshopInfoText.setVisibility(View.VISIBLE);
    }

    // Method to display course schedule
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


        scheduleText.setText(schedule);
        scheduleText.setVisibility(View.VISIBLE);
    }
}