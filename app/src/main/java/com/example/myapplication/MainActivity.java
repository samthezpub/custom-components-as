package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton createButton;

    // Метод для отображения PopupMenu
    private void showPopupMenu(View view) {
        // Создаём PopupMenu
        PopupMenu popupMenu = new PopupMenu(this, view);

        // Заполняем меню из XML-файла
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.context_menu, popupMenu.getMenu());

        // Устанавливаем обработчик выбора пунктов меню
        popupMenu.setOnMenuItemClickListener(this::onMenuItemClick);

        // Показываем меню
        popupMenu.show();
    }


    // Обработка выбора пунктов меню
    private boolean onMenuItemClick(MenuItem item) {
        String title = item.getTitle().toString();
        if ("Yellow".equals(title)) {
            Toast.makeText(this, "Yellow selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if ("Gray".equals(title)) {
            Toast.makeText(this, "Gray selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if ("Cyan".equals(title)) {
            Toast.makeText(this, "Cyan selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        createButton = (FloatingActionButton) findViewById(R.id.createButton);

        createButton.setOnClickListener(this::showPopupMenu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}