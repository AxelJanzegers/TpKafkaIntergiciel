# TP Intergiciel - API COVID
Projet réalisé par CAGNON Lilian, JANZEGERS Axel et QUIQUE Arthur

M2 TNSI FI 2020/2021

Ce projet nécessite :
  - que Zookeeper qu'un serveur Kafka soient ouverts
  - une base de données PosteGreSQL, ainsi qu'une database nommée "tp_kafka" (modifiable dans le fichier application.properties)
  - que le mot de passe de PosteGreSQL soit changé dans le fichier application.properties

Liste des commandes :
  - get_global_values : Retourne les valeurs globales clés du fichier json
  - get_country_values + [nom pays] : Retourne les valeurs du pays demandé
  - get_confirmed_avg : Retourne la moyenne des cas confirmés par rapport au nombre de pays
  - get_deaths_avg : Retourne la moyenne des décès par rapport au nombre de pays
  - get_countries_deaths_percent : Retourne le pourcentage de décès par rapport aux cas confirmés
