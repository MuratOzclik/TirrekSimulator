package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class urunOrnek extends AppCompatActivity {

    // region Nesne ve Değişken Tanımlamaları

    public int olasilik, clickAdet, kekoLevel;
    public boolean cakiVar;
    public Double HP, Susuzluk, Aclik, Para;
    TextView donerText, cakiText, suText, paraText, hpText, susuzlukText, durumText, aclikText, kekoLevelText, kekoAdText, tutorialText;
    Button yuruButon, oturusButon, suButon, donerButon, cakiButon, kekoAdButon;
    ImageView suImage, donerImage, cakiImage;
    EditText kekoAdBox;
    Random rnd = new Random();

    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urun_ornek);

        // region Nesne Eşleşmeleri

        paraText = findViewById(R.id.paraText);
        hpText = findViewById(R.id.hpText);
        susuzlukText = findViewById(R.id.susuzlukText);
        durumText = findViewById(R.id.durumText);
        aclikText = findViewById(R.id.aclikText);
        kekoLevelText = findViewById(R.id.kekoLevelText);
        kekoAdText = findViewById(R.id.kekoAdText);
        tutorialText = findViewById(R.id.tutorialText);
        donerText = findViewById(R.id.donerText);
        cakiText = findViewById(R.id.cakiText);
        suText = findViewById(R.id.suText);
        kekoAdBox = findViewById(R.id.kekoAdBox);

        suImage = findViewById(R.id.suImage);
        donerImage = findViewById(R.id.donerImage);
        cakiImage = findViewById(R.id.cakiImage);

        yuruButon = findViewById(R.id.yuruButon);
        oturusButon = findViewById(R.id.oturusButon);
        suButon = findViewById(R.id.suButon);
        donerButon = findViewById(R.id.donerButon);
        cakiButon = findViewById(R.id.cakiButon);
        kekoAdButon = findViewById(R.id.kekoAdButon);

        //endregion

        // region Başlangıç Değişken Atamaları

        Para = 0.0;
        HP = 100.0;
        Susuzluk = 0.0;
        Aclik = 0.0;
        kekoLevel = 0;
        clickAdet = 0;

        // endregion

        // region Buton Olayları

        cakiButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Para >= 50)
                {
                    cakiVar = true;
                    Para = Para - 50;
                    paraText.setText("Para: " + Para + " TL");
                    cakiButon.setEnabled(false);
                    Toast.makeText(urunOrnek.this, "Çakı satın alındı!", Toast.LENGTH_SHORT).show();
                }

                else if (Para < 50)
                {
                    Toast.makeText(urunOrnek.this, "Yeterli paran yok.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        oturusButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                olasilik = rnd.nextInt(2);

                if (HP < 100)
                {
                    HP++;
                    hpText.setText("HP: " + HP);
                }

                if(olasilik == 0)
                {
                    durumText.setText("Oturdun. Karnın acıktı ve susadın.");
                    Susuzluk = Susuzluk + 0.3;
                    Aclik = Aclik + 0.2;
                    aclikText.setText("Açlık: " + String.valueOf(Aclik));
                    susuzlukText.setText("Susuzluk: " + String.valueOf(Susuzluk));
                }

                else if (olasilik == 1)
                {
                    durumText.setText("Şanslı tırrek! Yerde 10 kuruş buldun!");
                    Para = Para + 0.10;
                    paraText.setText("Para: " + Para + " TL");
                }

                if (Aclik >= 100 || Susuzluk >= 100)
                {
                    cakiVar = false;
                    cakiButon.setEnabled(true);
                    hpText.setText("HP: 0");
                    susuzlukText.setText("Susuzluk: 100");
                    aclikText.setText("Açlık: 100");
                    Toast.makeText(urunOrnek.this, "Öldün Tırrek! Oyun bitti!", Toast.LENGTH_LONG).show();
                    durumText.setText("...");
                    kekoAdText.setText("Keko Adın: ");
                    kekoAdBox.setVisibility(View.VISIBLE);
                    kekoAdButon.setVisibility(View.VISIBLE);
                    yuruButon.setVisibility(View.GONE);
                    oturusButon.setVisibility(View.GONE);
                    suButon.setVisibility(View.GONE);
                    donerButon.setVisibility(View.GONE);
                    cakiButon.setVisibility(View.GONE);
                    kekoLevelText.setVisibility(View.GONE);
                    paraText.setVisibility(View.GONE);
                    hpText.setVisibility(View.GONE);
                    susuzlukText.setVisibility(View.GONE);
                    aclikText.setVisibility(View.GONE);
                    tutorialText.setVisibility(View.GONE);
                    durumText.setVisibility(View.GONE);
                    suImage.setVisibility(View.GONE);
                    donerImage.setVisibility(View.GONE);
                    cakiImage.setVisibility(View.GONE);
                    suText.setVisibility(View.GONE);
                    cakiText.setVisibility(View.GONE);
                    donerText.setVisibility(View.GONE);
                    kekoAdBox.setText("");
                }

                clickAdet++;

                switch (clickAdet)
                {
                    case 100:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 200:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 300:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 400:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 500:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 600:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 700:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 800:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 900:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 1000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 5000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        break;
                    case 10000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        yuruButon.setEnabled(false);
                        oturusButon.setEnabled(false);
                        suButon.setEnabled(false);
                        donerButon.setEnabled(false);
                        cakiButon.setEnabled(false);
                        hpText.setText("HP: 0");
                        susuzlukText.setText("Susuzluk: 100");
                        aclikText.setText("Açlık: 100");
                        Toast.makeText(urunOrnek.this, "Oyunu kazandın! Keko puanın: " + clickAdet, Toast.LENGTH_LONG).show();
                        kekoAdButon.setVisibility(View.VISIBLE);                        durumText.setText("...");
                        break;

                }

            }
        });

        yuruButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                olasilik = rnd.nextInt(2);

                if (olasilik == 0)
                {
                    Susuzluk = Susuzluk + 0.3;
                    Aclik = Aclik + 0.1;
                    aclikText.setText("Açlık: " + String.valueOf(Aclik));
                    susuzlukText.setText("Susuzluk: " + String.valueOf(Susuzluk));
                    durumText.setText("Birini 25 kuruş vermesi için zorladın. İyi iş Tırrek!");
                    Para = Para + 0.25;
                    paraText.setText("Para: " + String.valueOf(Para) + " TL");
                }

                else if (olasilik == 1 && !cakiVar)
                {
                    Susuzluk = Susuzluk + 2;
                    Aclik = Aclik + 1;
                    durumText.setText("Bir kavgaya karıştın! Canın azaldı. Ama 1 lira dızlayabildin!");
                    HP = HP - 2;
                    hpText.setText("HP: " + String.valueOf(HP));
                    Para = Para + 1;
                    paraText.setText("Para: " + String.valueOf(Para) + " TL");
                }

                else if (olasilik == 1 && cakiVar)
                {
                    int dizPara = rnd.nextInt(11);
                    Susuzluk = Susuzluk + 2;
                    Aclik = Aclik + 1;
                    durumText.setText("Bir kavgaya karıştın! Canın azaldı. " + dizPara + " TL kazandın!");
                    HP = HP - 5;
                    hpText.setText("HP: " + String.valueOf(HP));
                    Para = Para + dizPara;
                    paraText.setText("Para: " + String.valueOf(Para) + " TL");
                }

                if (HP <= 0)
                {
                    cakiVar = false;
                    cakiButon.setEnabled(true);
                    hpText.setText("HP: 0");
                    Toast.makeText(urunOrnek.this, "Öldün Tırrek! Oyun bitti!", Toast.LENGTH_LONG).show();
                    kekoAdText.setText("Keko Adın: ");
                    kekoAdBox.setVisibility(View.VISIBLE);
                    kekoAdButon.setVisibility(View.VISIBLE);
                    yuruButon.setVisibility(View.GONE);
                    oturusButon.setVisibility(View.GONE);
                    suButon.setVisibility(View.GONE);
                    donerButon.setVisibility(View.GONE);
                    cakiButon.setVisibility(View.GONE);
                    kekoLevelText.setVisibility(View.GONE);
                    paraText.setVisibility(View.GONE);
                    hpText.setVisibility(View.GONE);
                    susuzlukText.setVisibility(View.GONE);
                    aclikText.setVisibility(View.GONE);
                    tutorialText.setVisibility(View.GONE);
                    durumText.setVisibility(View.GONE);
                    suImage.setVisibility(View.GONE);
                    donerImage.setVisibility(View.GONE);
                    cakiImage.setVisibility(View.GONE);
                    suText.setVisibility(View.GONE);
                    cakiText.setVisibility(View.GONE);
                    donerText.setVisibility(View.GONE);
                    durumText.setText("...");
                    kekoAdBox.setText("");
                }

                if (Aclik >= 100 || Susuzluk >= 100)
                {
                    cakiVar = false;
                    cakiButon.setEnabled(true);
                    hpText.setText("HP: 0");
                    susuzlukText.setText("Susuzluk: 100");
                    aclikText.setText("Açlık: 100");
                    Toast.makeText(urunOrnek.this, "Öldün Tırrek! Oyun bitti!", Toast.LENGTH_LONG).show();
                    kekoAdText.setText("Keko Adın: ");
                    kekoAdBox.setVisibility(View.VISIBLE);
                    kekoAdButon.setVisibility(View.VISIBLE);
                    yuruButon.setVisibility(View.GONE);
                    oturusButon.setVisibility(View.GONE);
                    suButon.setVisibility(View.GONE);
                    donerButon.setVisibility(View.GONE);
                    cakiButon.setVisibility(View.GONE);
                    kekoLevelText.setVisibility(View.GONE);
                    paraText.setVisibility(View.GONE);
                    hpText.setVisibility(View.GONE);
                    susuzlukText.setVisibility(View.GONE);
                    aclikText.setVisibility(View.GONE);
                    tutorialText.setVisibility(View.GONE);
                    durumText.setVisibility(View.GONE);
                    suImage.setVisibility(View.GONE);
                    donerImage.setVisibility(View.GONE);
                    cakiImage.setVisibility(View.GONE);
                    suText.setVisibility(View.GONE);
                    cakiText.setVisibility(View.GONE);
                    donerText.setVisibility(View.GONE);
                    durumText.setText("...");
                    kekoAdBox.setText("");
                }

                clickAdet++;

                switch (clickAdet)
                {
                    case 100:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 200:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 300:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 400:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 500:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 600:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 700:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 800:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 900:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 1000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 5000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        Toast.makeText(urunOrnek.this, "Seviye atladın", Toast.LENGTH_SHORT).show();
                        break;
                    case 10000:
                        kekoLevel++;
                        kekoLevelText.setText("KL: " + kekoLevel);
                        yuruButon.setEnabled(false);
                        oturusButon.setEnabled(false);
                        suButon.setEnabled(false);
                        donerButon.setEnabled(false);
                        cakiButon.setEnabled(false);
                        hpText.setText("HP: 0");
                        susuzlukText.setText("Susuzluk: 100");
                        aclikText.setText("Açlık: 100");
                        Toast.makeText(urunOrnek.this, "Oyunu kazandın! Keko puanın: " + clickAdet, Toast.LENGTH_LONG).show();
                        kekoAdButon.setVisibility(View.VISIBLE);
                        durumText.setText("...");
                        break;
                }
            }
        });

        suButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Susuzluk > 0 && Para > 2.50)
                {
                    Toast.makeText(urunOrnek.this, "Susuzluğunu giderdin!", Toast.LENGTH_SHORT).show();
                    Susuzluk = Susuzluk - 10;
                    HP = HP + 20;
                    hpText.setText("HP: " + String.valueOf(HP));
                    susuzlukText.setText("Susuzluk: " + Susuzluk);
                    Para = Para - 2.50;

                    if (HP >= 100 || Susuzluk < 0)
                    {
                        HP = 100.0;
                        Susuzluk = 0.0;
                        Toast.makeText(urunOrnek.this, "Şuan su içmene gerek yok.", Toast.LENGTH_SHORT).show();
                        hpText.setText("HP: " + String.valueOf(HP));
                        susuzlukText.setText("Susuzluk: " + Susuzluk);
                    }
                }

                else if (Para < 2.50)
                {
                    Toast.makeText(urunOrnek.this, "Yeterli paran yok.", Toast.LENGTH_SHORT).show();
                }

                susuzlukText.setText("Susuzluk: " + String.valueOf(Susuzluk));
                paraText.setText("Para: " + Para + " TL");


            }
        });

        donerButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Para >= 8)
                {
                    if (Aclik > 0)
                    {
                        Toast.makeText(urunOrnek.this, "Karnını doyurdun!", Toast.LENGTH_SHORT).show();
                        Aclik = 0.0;
                        HP = HP + 5;// 5 arttirsin canı
                        Susuzluk = Susuzluk + 2;// susuzluğu 2 arttırsın
                        susuzlukText.setText("Susuzluk: " + String.valueOf(Susuzluk));
                        hpText.setText("HP: " + String.valueOf(HP));
                        aclikText.setText("Açlık: " + String.valueOf(Aclik));
                        Para = Para - 2.50;
                        paraText.setText("Para: " + Para + " TL");

                        if (Susuzluk < 0 || HP >= 100)
                        {
                            HP = 100.0;
                            Susuzluk = 0.0;
                            Toast.makeText(urunOrnek.this, "Şuan döner yemene gerek yok.", Toast.LENGTH_SHORT).show();
                            hpText.setText("HP: " + String.valueOf(HP));
                            susuzlukText.setText("Susuzluk: " + Susuzluk);
                        }

                    }
                }

                else if (Para < 8)
                {
                    Toast.makeText(urunOrnek.this, "Yeterli paran yok.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        kekoAdButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kekoAdText.setText("Keko Adın: " + kekoAdBox.getText().toString());
                kekoAdBox.setVisibility(View.GONE);
                kekoAdButon.setVisibility(View.GONE);
                yuruButon.setVisibility(View.VISIBLE);
                oturusButon.setVisibility(View.VISIBLE);
                suButon.setVisibility(View.VISIBLE);
                donerButon.setVisibility(View.VISIBLE);
                cakiButon.setVisibility(View.VISIBLE);
                kekoLevelText.setVisibility(View.VISIBLE);
                paraText.setVisibility(View.VISIBLE);
                hpText.setVisibility(View.VISIBLE);
                susuzlukText.setVisibility(View.VISIBLE);
                aclikText.setVisibility(View.VISIBLE);
                tutorialText.setVisibility(View.VISIBLE);
                durumText.setVisibility(View.VISIBLE);
                suImage.setVisibility(View.VISIBLE);
                donerImage.setVisibility(View.VISIBLE);
                cakiImage.setVisibility(View.VISIBLE);
                suText.setVisibility(View.VISIBLE);
                cakiText.setVisibility(View.VISIBLE);
                donerText.setVisibility(View.VISIBLE);

                Para = 0.0;
                HP = 100.0;
                Susuzluk = 0.0;
                Aclik = 0.0;
                kekoLevel = 0;
                paraText.setText("Para: " + String.valueOf(Para) + " TL");
                hpText.setText("HP: " + String.valueOf(HP));
                susuzlukText.setText("Susuzluk: " + String.valueOf(Susuzluk));
                aclikText.setText("Açlık: " + String.valueOf(Aclik));
                kekoLevelText.setText("KL: " + kekoLevel);
                durumText.setText("...");
            }
        });

        // endregion
    }
}

// Murat Özçelik ©