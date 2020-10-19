# DM GRAPH


## Nettoyage:
Avec ant:
```
    ant clean
```


## Compilation:
Avec ant:
```
    ant compile
```


## Execution:
Avec java:
```
    java -cp build App nomFichierTSP méthode
```

Avec le jar:
```
    ant dist
    java -jar ./dist/graph-0.1.jar nomFichierTSP méthode
```


    nomFichierTSP : l'un des fichiers tsp dans le dossier JeuxTests
    méthode:  kruskal/h2/2approx/2opt

