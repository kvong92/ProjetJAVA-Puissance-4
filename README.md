# Projet JAVA - Puissance 4

# I- Sujet

Réaliser le jeu du puissance 4 en JAVA et en CONSOLE.
Le principe du puissance 4 est simple : chaque joueur fait tomber à tour de rôle un pion dans une colonne d'une grille (les pions s'empilant les uns par dessus les autres) afin de créer un alignement (vertical, horizontal ou diagonal) de 4 pions de sa couleur.
Tous vos éléments doivent être déclarer sous forme de Class.

## Le jeu

Le jeu est un plateau composé de 6 lignes et 7 colonnes.
Chaque joueur, lors de son tour, doit mettre un de ses pions dans une colonne (et le pion tombe). Pour cela, chaque joueur saisi le numéro de colonne dans laquelle il veut faire tomber le pion.
Il n'est pas possible de mettre plus de 6 pions dans la même colonne.
Votre jeu devra ressembler à ça:

   1   2   3   4   5   6   7
 |   |   |   |   |   |   |   |
 |---+---+---+---+---+---+---|
 |   |   |   |   |   |   |   |
 |---+---+---+---+---+---+---|
 |   |   |   | = |   | @ |   |
 |---+---+---+---+---+---+---|
 |   |   | @ | @ | = | @ |   |
 |---+---+---+---+---+---+---|
 |   |   | = | = | @ | = |   |
 |---+---+---+---+---+---+---|
 |   | @ | = | @ | = | @ | = |
 \===========================/
Joueur Bob, choisisser votre colonne?

## La partie

Une partie permet de jouer au jeu. Celle-ci comporte 2 joueurs. Elle se base sur un jeu.
Lorsqu'un des 2 joueurs a aligné 4 pions, celui-ci est donné vainqueur.
Une partie est donc composé de 2 joueurs, d'un jeu, et d'une méthode pour détecter le vainqueur.
Une partie pouvent être sans vainqueur, une méthode permettant de détecter ce cas de figure doit être présente.

## Le joueur

Un joueur est défini par son nom et une forme ("@" et "=") et une couleur (voir paragraphe suivant).

## En couleur

A la place des "@" et "=", vous pouvez implémenter des couleurs, chanque joueur choisira donc sa couleur en début de chaque partie.
Lorsque le vainqueur est désigné, vous devez mettre une couleur différente de celle des joueurs sur les 4 pions alignés.

## TOP score

Dans chaque partie, vous devez calculer le nombre de coups pour arriver à la victoire d'un joueur.
Vous devrez enregistrer le nom du joueur dans le TOP10 si il a effectué moins de coups que les 10 premiers du TOP10.
Le TOP10 devra être enregistrer dans un fichier afin de conserver les scores des TOP10.

## Menu
Avant chaque partie, un menu s'affichera avec plusieurs choix possible comme:
- Jouer tout seul (voir paragraphe suivant)
- Jouer à 2 
- Afficher le TOP 10
- Quitter

## IA

Afin de pouvoir jouer tout seul, vous devrez coder une "IA" joueur.
L’IA sera codée par une fonction, dont le but est de renvoyer la colonne choisie par l’IA.
Cette fonction prend en paramètres le jeu actuel et le niveau de difficulté demandé.

### IA niveau 1

Cette première IA sera simple, et grace à une fonction Random sélectionnera une colonne du plateau au hasard dans laquelle il est possible de mettre un pion.

### IA niveau 2

Cette IA sera plus avançée, comme la première elle sélectionnera aléatoirement une colonne disponible sur plateau. MAIS elle devra détecter une possibilité de victoire du joueur humain (3 pions alignés) et dans ce cas sélectionnera la colonne permettant d'avorter la victoire du joueur humain.

### IA niveau 3

Cette IA sera encore plus avançée, comme la deuxième elle sélectionnera aléatoirement une colonne disponible sur plateau et devra faire avorter la victoire possible du joueur humain. MAIS elle devra détecter une possibilité de victoire du joueur humain (3 pions alignés) et dans ce cas ne sélectionnera pas la ou les colonnes permettant la victoire du joueur humain au prochain tour.

### IA niveau 4

La c'est le top, non seulement elle reprend les éléments des niveau 2 et 3 mais en plus elle ne choisira pas une colonne aléatoirement. Elle cherchera la colonne qui permet d'aligner les pions.
