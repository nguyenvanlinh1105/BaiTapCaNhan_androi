package com.example.test;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test.databinding.ActivityMain2Binding;
// Nguyễn Văn Linh - 22115053122225
public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        ReplaceFragment(new frag_home());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                ReplaceFragment(new frag_home());
            } else if (item.getItemId() == R.id.settings) {
                ReplaceFragment(new frag_setting());
            } else if (item.getItemId() == R.id.user) {
                ReplaceFragment(new frag_user());

            }
            return true;
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ReplaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainLayout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}