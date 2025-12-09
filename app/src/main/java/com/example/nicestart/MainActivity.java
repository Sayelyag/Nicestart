package com.example.nicestart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private WebView miVisorWeb;
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        // WebView carga una imagen de una web random
        miVisorWeb = findViewById(R.id.vistaweb);
        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                "img { width:100%; height:100%; object-fit:cover; }" +
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";

        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }

    public void openPerfil(MenuItem item){
        Intent intent=new Intent(MainActivity.this, perfil.class);
        startActivity(intent);
    }
    //  MENÚ
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item1) {
            Toast.makeText(this, "Item copied", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.item2) {
            Toast.makeText(this, "Downloading item...", Toast.LENGTH_SHORT).show();

        }
        return true;
    }


    //  MENÚ SUPERIOR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item5) {
            showAlertDialogButtonClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // DIÁLOGO 3 BOTONES
    public void showAlertDialogButtonClicked() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("Opciones:")
                .setMessage("¿A dónde quieres ir?")
                .setIcon(R.drawable.outline_cyclone_24)
                .setCancelable(true)

                .setPositiveButton("Scrolling", (dialog, which) ->
                        Toast.makeText(MainActivity.this, "Scrolling", Toast.LENGTH_SHORT).show()
                )

                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())

                .setNeutralButton("Sign Out", (dialog, which) -> {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                });

        builder.create().show();
    }


    // REFRESH
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener =
            () -> {
                Toast.makeText(MainActivity.this, "Reiniciado", Toast.LENGTH_SHORT).show();
                miVisorWeb.reload();
                swipeLayout.setRefreshing(false);
            };
}