package fr.dalbanchin.savwar.storage;

import android.content.Context;
import android.content.SharedPreferences;
import fr.dalbanchin.savwar.model.Savoir;

public final class SavoirStorage {

    private static SavoirDatabaseStorage marvin;

    private static final String PREF_NAME = "settings";
    private static final String PREF_BDD = "bdd";
    public static final int PREF_BDD_INT = 0;
    private static final int PREF_BDD_DEFAULT = PREF_BDD_INT;

    private static final String PREF_ID = "id";
    public static final int PREF_ID_INT = -1;
    private static final int PREF_ID_DEFAULT = PREF_ID_INT;

    private static final String PREF_THEME = "theme";
    public static final int PREF_THEME_INT = 0;
    private static final int PREF_THEME_DEFAULT = PREF_THEME_INT;

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }
    public static int getsettingsBDD(Context context) {
        return getPreferences(context).getInt(PREF_BDD, PREF_BDD_DEFAULT);
    }

    public static void setsettingsBDD(Context context, int pref_savoir) {
        getPreferences(context).edit().putInt(PREF_BDD, 1).apply();
    }


    public static void setsettingsSAVOIRID(Context context, int id) {
        getPreferences(context).edit().putInt(PREF_ID, id).apply();
    }

    public static int getsettingsSAVOIRID(Context context) {
        return getPreferences(context).getInt(PREF_ID, PREF_ID_DEFAULT);
    }

    public static void setsettingsSAVOIRTHEME(Context context, int id) {
        getPreferences(context).edit().putInt(PREF_THEME, id).apply();
    }

    public static int getsettingsSAVOIRTHEME(Context context) {
        return getPreferences(context).getInt(PREF_THEME, PREF_THEME_DEFAULT);
    }

    public static void ajouterBdd(Context context){

        marvin = marvin.get(context);
        Savoir savoir = new Savoir("Filet-o-Sish","Dans les années 60 Mc Donald’s a créé le Filet-o-Fish pour les catholiques, car les catholiques pratiquant ne mangeant pas de viande le vendredi son chiffre d'affaires n'était pas aussi bon que les autres jours. De nos jours 90% des personnes achetant le Filet-o-Fish sont musulmans.", "Cuisine", "https://fr.wikipedia.org/wiki/Filet-O-Fish", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le petit beurre","Né en 1886, le petit beurre a une forme tout sauf anodine. Ses quatre coins symbolisent les 4 saisons, tandis que les 52 « dents » du biscuit représentent elles les semaines de l’année.Et les concepteurs du biscuit ont même poussé le souci du détail jusqu’à inclure 24 points au centre pour représenter les heures de la journée.", "Cuisine", "https://fr.wikipedia.org/wiki/Petit_Beurre", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Aliment volé","L’aliment le plus volé dans le monde est le fromage, selon une étude réalisée en 2011 en Grande-Bretagne 4% du fromage dans le monde est volé !", "Cuisine", "https://www.lesaviezvous.net/loisirs/cuisine/laliment-le-plus-vole-dans-le-monde-est-le-fromage.html#:~:text=L%E2%80%99aliment%20le%20plus%20vol%C3%A9%20dans%20le%20monde%20est,est%20l%E2%80%99aliment%20le%20plus%20vol%C3%A9%20dans%20le%20monde", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le miel","Le miel à une durée de vie illimitée ! Le miel contient des agents bactériostatiques on peut donc le laisser 100ans dans un placard il sera le meme.", "Cuisine", "https://www.cuisineaz.com/diaporamas/choses-insolites-aliments-2130/interne/recette/4.aspx", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Coca_Cola","Les chiffres sont tout simplement incroyables : chaque seconde dans le monde, ce sont plus de 4000 litres de Coca-Cola qui sont bus !", "Cuisine", "https://www.cuisineaz.com/diaporamas/choses-insolites-aliments-2130/interne/recette/3.aspx", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Surface terreste","la surface terrestre est lisse à ±0,1% en comparerà sa taille, ce qui correspond à une perfection que n’atteignent même pas les boules de billard.", "Espace", "http://claudelafleur.qc.ca/Terre-parfaite.html", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Météorites","Il y a plus de 100 tonnes de météorites qui se désintègre en rentrant dans l'atmosphère chaque jour.", "Espace", "https://www.lesechos.fr/2017/04/debris-spatiaux-la-menace-invisible-158138#:~:text=Chaque%20jour%2C%20c'est%20l,%C3%A0%20100%20tonnes%20par%20jour", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le retour d'Appolo 11","Michael Collins, Neil Armstrong et Buzz Aldrin se trouvent dans un bus de quarantaine en direction du centre spatial de Houston, où ils passeront deux jours et demi. Chaque astronaute devait se tenir à cette obligation jusqu'au retour de la mission Apollo 14. Après cette expédition, les scientifiques étaient convaincus que la Lune ne contenait aucune maladie mortelle.", "Espace", "https://lafilledanslalune.fr/quarantaine-astronautes-apollo/", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le zéro absolu ","-273,15°C , ce chiffre est la température de l'espace, ou encore le zéro absolu, iL n'existe pas plus froid de nos jours, cette température a été prise dans l'espace le plus loin possible de toutes sources de chaleur.", "Espace", "https://www.guichetdusavoir.org/viewtopic.php?t=37950", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le téléscope Hubble","Le télescope Hubble flotte au-dessus de nos têtes depuis les années 1990 à 570 km de la Terre, malgrès des début difficile il n'a pas fonctionner pendant 3 ans mais maintenant il prend des photos tous simplement fantastiques et d'une qualité remarquable.", "Espace", "https://www.science-et-vie.com/ciel-et-espace/les-photos-les-plus-spectaculaires-prises-par-le-telescope-hubble-59165", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("De la pluie de diamand ?","Il pleut des tonnes de diamants chaque année sur saturne En 2013, lors d’une conférence de la Société américaine d’astronomie, le docteur Kevin Baines, de l’Université du Wisconsin à Madison et de l’Agence spatiale américaine (la NASA), a fait part d’une découverte étonnante :il pleut des diamants sur Saturne et Jupiter.", "Espace", "https://www.bfmtv.com/sciences/science-de-possibles-pluies-de-diamants-sur-saturne-et-jupiter_AN-201310150102.html", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("La vitesse du guépard","Sur terre, aucun animal aujourd'hui ne peut détrôner le guépard. Ce mammifère de la famille des félidés développe en effet des performances physiques exceptionnelles. Selon les études, cet animal a une vitesse moyenne de 93 km/h qu’il peut atteindre en à peine trois secondes.", "Animaux", "https://lemagdesanimaux.ouest-france.fr/dossier-13-animaux-rapides-monde-terre-mer-air.html#:~:text=Sur%20terre%2C%20les%20animaux%20les,en%20%C3%A0%20peine%20trois%20secondes", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("La vitesse aérienne","Dans les airs l'oiseau : martinet noir ne se pose presque jamais sur terre sauf pour couver. Dans les airs, sa vitesse atteint facilement les 200 km/h.Si l’on ne prend en compte que les descentes en piqué, on peut dire que le faucon pèlerin surpasse tout le règne animal. Sa vitesse maximale enregistrée est de 389 km/h. Mais en moyenne, elle est de 180 km/h.", "Animaux", "https://lemagdesanimaux.ouest-france.fr/dossier-13-animaux-rapides-monde-terre-mer-air.html#:~:text=Sur%20terre%2C%20les%20animaux%20les,en%20%C3%A0%20peine%20trois%20secondes", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le Bernard L'ermite","INFORMATION BRUT SUR LE BERNARD L'ERMITE : (clique sur 'En savoir plus')", "Animaux", "https://www.brut.media/fr/entertainment/comment-le-bernard-l-ermite-change-de-coquille-b4677265-3de0-4a6f-933d-ce935f78031b", 1, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le Lézard à Corne","INFORMATION BRUT SUR LE LEZARD A CORNE : (clique sur 'En savoir plus'')", "Animaux", "https://www.brut.media/fr/entertainment/comment-les-lezards-a-cornes-se-defendent-e20cac5f-bea7-48ea-82a3-1c5da31685c9", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Le biomimétisme","INFORMATION YOUTUBE SUR LE BIOMIMETISME : (clique sur 'En savoir plus')", "Animaux", "https://www.youtube.com/watch?v=Z3aC7ngSh3w", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Les noix de cocos meurtrières","Les noix de cocos tuent plus de personne que les requins : les noix de cocos sont lourdes et peuvent tomber sur des personnes se trouvant en dessous, il y a plus de personnes décedés de noix de cocos que de requins.", "Nature", "https://www.europe1.fr/international/Meduses-et-noix-de-coco-tuent-plus-que-les-requins-406210#:~:text=M%C3%AAme%20les%20noix%20de%20coco%20sont%20plus%20dangereuses&text=Ces%20attaques%20ne%20se%20r%C3%A9v%C3%A8lent,de%20coco%20sont%20plus%20dangereuses.", 1, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("La plus grande fleur","La Rafflesia la fleur simple la plus grande du monde végétal elle peut atteindre un mètre de diamètre et peser jusqu'à 10 kg", "Nature", "https://fr.wikipedia.org/wiki/Rafflesia", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("La plante millénaire","La plante Welwitschia mirabilis vit entre 1 000 et 2000 ans et survivre à plus de 5 ans sans eau.", "Nature", "https://fr.wikipedia.org/wiki/Welwitschia_mirabilis", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Paris et les 'STOP'","Malgré sa taille gigantesque, la ville de Paris n’avais qu'un seul panneau stop jusqu'en 2016 ! Aujourd'hui il n'en a plus !", "Geographie", "https://saviezvous.fr/divers/combien-de-panneaux-stop-a-paris/", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("les langues officiel","La 3ème langue officiel de la nouvelle-Zélande est la langue des signe, précedé de l'anglais et du Maori.", "Geographie", "https://fr.wikipedia.org/wiki/Langue_des_signes_n%C3%A9o-z%C3%A9landaise#:~:text=%C2%AB%20ChCh%20%C2%BB).-,Statut%20de%20langue%20officielle,de%20facto)%20et%20le%20maori.", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Un petit nom de commune","En France il existe énormement de communes.. Mais connaissez vous le nom de la plus petite commune de France ? Elle s'écrit 'Y' prononcé 'i'.", "Geographie", "https://fr.wikipedia.org/wiki/Y_(Somme)", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Une micronation : Sealand","Il existe une micronation non reconnu du nom de Sealand installée sur l'ancienne plate-forme militaire Fort Roughs", "Geographie", "https://fr.wikipedia.org/wiki/Principaut%C3%A9_de_Sealand", 0, "vide");
        marvin.insert(savoir);

        savoir = new Savoir("Doyenne de l'humanité","Kane Tanaka, née le 2 janvier 1903, est une supercentenaire japonaise, doyenne de l'humanité depuis le 22 juillet 2018. Elle à en 2020, 117 ans !","Humain","https://fr.wikipedia.org/wiki/Kane_Tanaka",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Une grande personne","Sultan Kösen homme le plus grand sur terre vivant avec une taille de 2m51","Humain","https://fr.wikipedia.org/wiki/Liste_des_hommes_les_plus_grands_du_monde",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Décès/Naissance","Il existe un site qui afffiche en temps réel le nombre de décès et de naissance ! (clique sur 'En savoir plus' !).","Humain","https://www.planetoscope.com/natalite/5-croissance-de-la-population-mondiale-naissances---deces-.html",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("L'empreinte de la langue"," INFO BRUT : Tout comme nos empreintes digitales sont uniques, l’empreinte de notre langue est, elle aussi, unique.","Humain","https://dailygeekshow.com/langue-empreinte-unique/",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Une haute chute-libre","La détentrice du record du monde de la plus haute chute libre vivantesans parachute à laquelle un être humain ait survécu (10 160 mètres, Vesna Vulović)","Humain","https://fr.wikipedia.org/wiki/Vesna_Vulovi%C4%87",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Les soldats chinois","les soldats chinois ont des aiguilles sous leurs coups pour garder la tête haute, droite.","Humain","https://www.google.com/url?sa=i&url=https%3A%2F%2Fchine.in%2Fforum%2Fcomment-les-soldats-tiennent-tete-haute_642.html&psig=AOvVaw3XFuqELBZkpFZ-bDcYyzNT&ust=1602335022304000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCPjQg67Jp-wCFQAAAAAdAAAAABAD",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Boire et respirer","Il est impossible pour un adulte de respirer et boire en même temps , mais pas pour un bébé !","Humain","https://mobile.secouchermoinsbete.fr/44918-un-bebe-peut-boire-et-respirer-en-meme-temps",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Arbre de 3500ans brulé","Une femme a été arrêtée pour avoir brûlé un arbre vieux de 3.500 ans (le 5ème arbres le plus vieux du monde) en voulant se droguer en haut de celui-ci (Cyprès).","Humain","https://www.20minutes.fr/planete/889531-20120301-etats-unis-femme-arretee-avoir-brule-arbre-vieux-3500-ans",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Devenir handicapé","Le trouble identitaire de l'intégrité corporelle est un trouble psychologique provoquant chez un individu en bonne santé la volonté de devenir handicapé. Lié à la xénomélie (sentiment que ses membres ne sont pas les siens),ce trouble a conduit certains à s'amputer exprès ou à se rendre aveugle.","Humain","https://fr.wikipedia.org/wiki/Trouble_identitaire_de_l%27int%C3%A9grit%C3%A9_corporelle",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Coca(ine)?","Saviez-vous que le Coca-Cola avait de la cocaine dans leurs ingrédients ? Si vous voulez savoir pourquoi il l'on retiré cliquez su 'En savoir plus'.","Histoire","https://www.atlantico.fr/atlantico-light/697975/l-incroyable-histoire-du-retrait-de-la-cocaine-du-coca-et-ce-n-est-pas-pour-des-raisons-de-sante-",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Loi absurde","Il existe une loi absurde en Angleterre : il est légal de tuer un écossais dans la ville de York s'il porte un arc et des flèches!","Histoire","https://www.savoir-inutile.com/optvw4",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("L'histoire d'Hitler","En janvier 1894, alors que Hitler était âgé de 4 ans, il a été sauvé de la noyade par un futur prêtre. L'histoire aurait pu être tout autre s'il avait perdu la vie.","Histoire","https://www.lesoir.be/art/m/hitler-sauve-des-eaux_t-20120109-01R7XA.html#:~:text=Des%20historiens%20allemands%20ont%20d%C3%A9couvert,par%20un%20gar%C3%A7onnet%20%C3%A9galement%20%C3%A2g%C3%A9",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Napoléon et ses lapins","Napoléon organise une chasse organiser en lachant des centaines de lapinsmais au lieu de fuir ils attaquent Napoléon et ses hommes et est obligé de battre en retraite contre une horde de lapins !","Histoire","https://fr.quora.com/Quels-sont-les-faits-les-plus-fascinants-sur-lHistoire-du-monde#:~:text=Napol%C3%A9on%2C%20l'un%20des%20hommes,guerre%20entre%20les%20deux%20pays.",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Une longue guerre","La guerre la plus longue s'est déroulée de 1651 à 1986, elle voyait s'affronter les Pays-Bas et les Iles Scilly.Autre anecdote, elle n'a fait aucune victime. nommé 'guerre de 335 ans'","Histoire","https://fr.wikipedia.org/wiki/Guerre_de_Trois_cent_trente-cinq_Ans",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Une courte guerre","Le Bombardement de Zanzibar la guerre la plus courte de l'histoire a durait 38 minutes opposa l'Angleterre et le Zanzibar en 1896, Environ 500 Zanzibarites furent tués ou blessés lors du bombardement !","Histoire","https://fr.wikipedia.org/wiki/Bombardement_de_Zanzibar",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("soldat : 9 VS 700","Durant la seconde guerre mondiale En 1940, 9 soldats français ont combattu 5000 soldats italiens durant une semaine et réussissant à en tuer et blaisser plus de 700.","Histoire","https://www.lesaviezvous.net/histoire/en-1940-9-soldats-francais-ont-combattu-5000-soldats-italiens-durant-une-semaine.html",0,"vide");
        marvin.insert(savoir);

        savoir = new Savoir("Prix Nobel math","Les mathématiques ne sont pas récompensées par un prix Nobel. Leur absence est source de discussion,car Alfred Nobel ne s'en est jamais expliqué.","Histoire","https://fr.wikipedia.org/wiki/Prix_Nobel_de_math%C3%A9matiques#:~:text=Il%20n'existe%20pas%20de,d%C3%A9cern%C3%A9e%20annuellement%20%C3%A0%20des%20math%C3%A9maticiens.",0,"vide");
        marvin.insert(savoir);

    }
}