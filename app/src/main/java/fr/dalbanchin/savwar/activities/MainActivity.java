package fr.dalbanchin.savwar.activities;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.sql.Date;
import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fr.dalbanchin.savwar.Alea;
import fr.dalbanchin.savwar.R;
import fr.dalbanchin.savwar.model.Savoir;
import fr.dalbanchin.savwar.storage.SavoirDatabaseStorage;
import fr.dalbanchin.savwar.storage.SavoirStorage;
import fr.dalbanchin.savwar.storage.utility.BaseDeDonnee;
import android.media.MediaPlayer;


public class MainActivity extends AppCompatActivity {

    private static int REQUEST_IMAGE_CAPTURE = 1;

    private Button savoir;

    private Button theme;

    private Button favoris;

    private Button journuit;

    SavoirDatabaseStorage marvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.savoir = (Button) findViewById(R.id.button_savoir);


        savoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on récupère la date actuelle
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = new Date(System.currentTimeMillis());
                String date_current = formatter.format(date);

                /*String info = " voici les informations que vous aimeriez connaitre ";
                String theme = " Astronaute ";
                String lien = "https://icom.univ-lyon2.fr/formation/master-1-informatique#admission";
                Integer favoring = 0;
                String date_sav = date_current;
                Savoir savoir = new Savoir(info,theme,lien,favoring,date_sav);*/

/*                try {
                    savoir_import = (Savoir) marvin.findDate();
                    marvin.update(date_current,savoir_import);
                }catch (SQLException e){
                    e.printStackTrace();
                    savoir_import = savoir;

                    //ArrayList<Savoir> listsavoir = (ArrayList<Savoir>) marvin.findAll();
                    //for(int i = 0; i < listsavoir.size(); i++) {
                     //   marvin.update(i, listsavoir.get(i)); // changer la façon de faire avec les id d'array list car c'est faux
                    //}
                }*/



                //marvin.update(date_current,savoir_import);

                //((ImageView) findViewById(R.id.image_savoir)).setImageDrawable(savoir_import.getTheme()+".png");

                Intent savoirIntent = new Intent(getApplicationContext(), SavoirDuJour.class);
                startActivity(savoirIntent);
            }
        });
        this.theme = (Button) findViewById(R.id.button_theme);

        theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent themeIntent = new Intent(getApplicationContext(), ThemeActivity.class);
                startActivity(themeIntent);
            }
        });
        this.favoris = (Button) findViewById(R.id.button_favoris);

        favoris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favorisIntent = new Intent(getApplicationContext(), FavorisActivity.class);
                startActivity(favorisIntent);
            }
        });
        this.journuit = (Button) findViewById(R.id.button_ajouter);

        journuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marvin = marvin.get(getBaseContext());

                Savoir savoir = new Savoir("Dans les années 60 Mc Donald’s a créé le Filet-o-Fish pour les catholiques, car les catholiques pratiquant ne mangeant pas de viande le vendredi son chiffre d'affaires n'était pas aussi bon que les autres jours. De nos jours 90% des personnes achetant le Filet-o-Fish sont musulmans.","Cuisine","https://fr.wikipedia.org/wiki/Filet-O-Fish",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Né en 1886, le petit beurre a une forme tout sauf anodine. Ses quatre coins symbolisent les 4 saisons, tandis que les 52 « dents » du biscuit représentent elles les semaines de l’année.Et les concepteurs du biscuit ont même poussé le souci du détail jusqu’à inclure 24 points au centre pour représenter les heures de la journée.","Cuisine","https://fr.wikipedia.org/wiki/Petit_Beurre",0,"vide");
                marvin.insert(savoir);

                savoir = new Savoir("L’aliment le plus volé dans le monde est le fromage, selon une étude réalisée en 2011 en Grande-Bretagne 4% du fromage dans le monde est volé !","Cuisine","https://www.lesaviezvous.net/loisirs/cuisine/laliment-le-plus-vole-dans-le-monde-est-le-fromage.html#:~:text=L%E2%80%99aliment%20le%20plus%20vol%C3%A9%20dans%20le%20monde%20est,est%20l%E2%80%99aliment%20le%20plus%20vol%C3%A9%20dans%20le%20monde",0,"vide");
                marvin.insert(savoir);

                savoir = new Savoir("Le miel à une durée de vie illimitée ! Le miel contient des agents bactériostatiques on peut donc le laisser 100ans dans un placard il sera le meme.","Cuisine","https://www.cuisineaz.com/diaporamas/choses-insolites-aliments-2130/interne/recette/4.aspx",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Les chiffres sont tout simplement incroyables : chaque seconde dans le monde, ce sont plus de 4000 litres de Coca-Cola qui sont bus !","Cuisine","https://www.cuisineaz.com/diaporamas/choses-insolites-aliments-2130/interne/recette/3.aspx",0,"vide");
                marvin.insert(savoir);

                savoir = new Savoir("la surface terrestre est lisse à ±0,1% en comparerà sa taille, ce qui correspond à une perfection que n’atteignent même pas les boules de billard.","Espace","http://claudelafleur.qc.ca/Terre-parfaite.html",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Il y a plus de 100 tonnes de météorites qui se désintègre en rentrant dans l'atmosphère chaque jour.","Espace","https://www.lesechos.fr/2017/04/debris-spatiaux-la-menace-invisible-158138#:~:text=Chaque%20jour%2C%20c'est%20l,%C3%A0%20100%20tonnes%20par%20jour",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Michael Collins, Neil Armstrong et Buzz Aldrin se trouvent dans un bus de quarantaine en direction du centre spatial de Houston, où ils passeront deux jours et demi. Chaque astronaute devait se tenir à cette obligation jusqu'au retour de la mission Apollo 14. Après cette expédition, les scientifiques étaient convaincus que la Lune ne contenait aucune maladie mortelle.","Espace","https://lafilledanslalune.fr/quarantaine-astronautes-apollo/",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("-273,15°C , ce chiffre est la température de l'espace, ou encore le zéro absolu, iL n'existe pas plus froid de nos jours, cette température a été prise dans l'espace le plus loin possible de toutes sources de chaleur.","Espace","https://www.guichetdusavoir.org/viewtopic.php?t=37950",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Le télescope Hubble flotte au-dessus de nos têtes depuis les années 1990 à 570 km de la Terre, malgrès des début difficile il n'a pas fonctionner pendant 3 ans mais maintenant il prend des photos tous simplement fantastiques et d'une qualité remarquable.","Espace","https://www.science-et-vie.com/ciel-et-espace/les-photos-les-plus-spectaculaires-prises-par-le-telescope-hubble-59165",0,"vide");
                marvin.insert(savoir);

                savoir = new Savoir("Il pleut des tonnes de diamants chaque année sur saturne En 2013, lors d’une conférence de la Société américaine d’astronomie, le docteur Kevin Baines, de l’Université du Wisconsin à Madison et de l’Agence spatiale américaine (la NASA), a fait part d’une découverte étonnante :il pleut des diamants sur Saturne et Jupiter.","Espace","https://www.bfmtv.com/sciences/science-de-possibles-pluies-de-diamants-sur-saturne-et-jupiter_AN-201310150102.html",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Sur terre, aucun animal aujourd'hui ne peut détrôner le guépard. Ce mammifère de la famille des félidés développe en effet des performances physiques exceptionnelles. Selon les études, cet animal a une vitesse moyenne de 93 km/h qu’il peut atteindre en à peine trois secondes.","Animaux","https://lemagdesanimaux.ouest-france.fr/dossier-13-animaux-rapides-monde-terre-mer-air.html#:~:text=Sur%20terre%2C%20les%20animaux%20les,en%20%C3%A0%20peine%20trois%20secondes",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Dans les airs l'oiseau : martinet noir ne se pose presque jamais sur terre sauf pour couver. Dans les airs, sa vitesse atteint facilement les 200 km/h.Si l’on ne prend en compte que les descentes en piqué, on peut dire que le faucon pèlerin surpasse tout le règne animal. Sa vitesse maximale enregistrée est de 389 km/h. Mais en moyenne, elle est de 180 km/h.","Animaux","https://lemagdesanimaux.ouest-france.fr/dossier-13-animaux-rapides-monde-terre-mer-air.html#:~:text=Sur%20terre%2C%20les%20animaux%20les,en%20%C3%A0%20peine%20trois%20secondes",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("INFORMATION BRUT SUR LE BERNARD L'ERMITE : (clique sur 'En savoir plus')","Animaux","https://www.brut.media/fr/entertainment/comment-le-bernard-l-ermite-change-de-coquille-b4677265-3de0-4a6f-933d-ce935f78031b",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("INFORMATION BRUT SUR LE LEZARD A CORNE : (clique sur 'En savoir plus'')","Animaux","https://www.brut.media/fr/entertainment/comment-les-lezards-a-cornes-se-defendent-e20cac5f-bea7-48ea-82a3-1c5da31685c9",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("INFORMATION YOUTUBE SUR LE BIOMIMETISME : (clique sur 'En savoir plus')","Animaux","https://www.youtube.com/watch?v=Z3aC7ngSh3w",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Les noix de cocos tuent plus de personne que les requins : les noix de cocos sont lourdes et peuvent tomber sur des personnes se trouvant en dessous, il y a plus de personnes décedés de noix de cocos que de requins.","Nature","https://www.europe1.fr/international/Meduses-et-noix-de-coco-tuent-plus-que-les-requins-406210#:~:text=M%C3%AAme%20les%20noix%20de%20coco%20sont%20plus%20dangereuses&text=Ces%20attaques%20ne%20se%20r%C3%A9v%C3%A8lent,de%20coco%20sont%20plus%20dangereuses.",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("La Rafflesia la fleur simple la plus grande du monde végétal elle peut atteindre un mètre de diamètre et peser jusqu'à 10 kg","Nature","https://fr.wikipedia.org/wiki/Rafflesia",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("La plante Welwitschia mirabilis vit entre 1 000 et 2000 ans et survivre à plus de 5 ans sans eau.","Nature","https://fr.wikipedia.org/wiki/Welwitschia_mirabilis",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Malgré sa taille gigantesque, la ville de Paris n’avais qu'un seul panneau stop jusqu'en 2016 ! Aujourd'hui il n'en a plus !","Geographie","https://saviezvous.fr/divers/combien-de-panneaux-stop-a-paris/",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("La 3ème langue officiel de la nouvelle-Zélande est la langue des signe, précedé de l'anglais et du Maori.","Geographie","https://fr.wikipedia.org/wiki/Langue_des_signes_n%C3%A9o-z%C3%A9landaise#:~:text=%C2%AB%20ChCh%20%C2%BB).-,Statut%20de%20langue%20officielle,de%20facto)%20et%20le%20maori.",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("En France il existe énormement de communes.. Mais connaissez vous le nom de la plus petite commune de France ? Elle s'écrit 'Y' prononcé 'i'.","Geographie","https://fr.wikipedia.org/wiki/Y_(Somme)",0,null);
                marvin.insert(savoir);

                savoir = new Savoir("Il existe une micronation non reconnu du nom de Sealand installée sur l'ancienne plate-forme militaire Fort Roughs","Geographie","https://fr.wikipedia.org/wiki/Principaut%C3%A9_de_Sealand",0,null);
                marvin.insert(savoir);

                Intent refreshIntent = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(refreshIntent);

            }
        });
    }
    @SuppressLint("NewApi")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            if (data != null) {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    ImageView image = findViewById(R.id.logo);
                    image.setImageBitmap((Bitmap) bundle.get("data"));
                    image.setImageTintList(new ColorStateList(new int[0][0], new int[0])); // Enlève le tint
                }
            }
        }
    }
}