package com.example.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        ImageView logo = findViewById(R.id.logosplash);


        Animation starAnim = AnimationUtils.loadAnimation(this, R.anim.star_transition);

        starAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Ir al Login cuando termine la animación
                Intent intent = new Intent(Principal.this, Login.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        logo.startAnimation(starAnim);

        // Fondo con Glide
        ImageView mSea = findViewById(R.id.backView);
        Glide.with(this)
                .load(R.drawable.merry)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .into(mSea);
    }
}