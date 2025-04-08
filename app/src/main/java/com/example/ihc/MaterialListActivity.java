package com.example.ihc;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MaterialListActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_list);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        String[] materials = {
                "Papel y cartón",
                "Vidrio",
                "Plástico",
                "Metal",
                "Electrónicos",
                "Pilas y baterías",
                "Textiles",
                "Orgánicos"
        };

        ListView listView = findViewById(R.id.materialListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                materials
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMaterial = materials[position];
            showRecyclingInfo(selectedMaterial);
        });
    }

    private void showRecyclingInfo(String material) {
        String url = getRecyclingUrl(material);
        webView.loadUrl(url);
        webView.setVisibility(View.VISIBLE);
        findViewById(R.id.materialListView).setVisibility(View.GONE);
    }

    private String getRecyclingUrl(String material) {
        switch (material) {
            case "Papel y cartón":
                return "https://es.wikipedia.org/wiki/Reciclaje_de_papel";
            case "Vidrio":
                return "https://es.wikipedia.org/wiki/Reciclaje_de_vidrio";
            case "Plástico":
                return "https://es.wikipedia.org/wiki/Reciclaje_de_pl%C3%A1stico";
            // Agrega más casos según sea necesario
            default:
                return "https://es.wikipedia.org/wiki/Reciclaje";
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.getVisibility() == View.VISIBLE) {
            webView.setVisibility(View.GONE);
            findViewById(R.id.materialListView).setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}