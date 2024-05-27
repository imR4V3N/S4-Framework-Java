# **SPRINT FRAMEWORK - ETU002476**

## Sprint 0

**Objectif:** Créer un servlet qui réceptionnera toutes les requêtes clients et qui les traitera

Coté Framework:

* Creation d'un servlet FrontController dont la methode processRequest affichera l'url dans lequel on se trouve

## Sprint 1

### **Modification dans mon framework :**

1. Creation d'une classe annotation du nom de Controller
2. Annoter mes controleurs avec Controller
3. Mettre mes controleurs dans le meme package

### **Modification dans FrontController :**

(Prendre le nom du package où se trouvent mes controleurs)

1. Tester si j'ai déjà scanner mes controleurs

* Si oui, afficher la liste des noms de mes controleurs
* Sinon scanner, puis afficher la liste des noms de mes controleurs

## Sprint 2

### **Objectif :**

 Récupérer la classe et la méthode associées à une URL donnée

### **Étapes :**

Creation d'une annotation GET pour annoter les méthodes dans les contrôleurs

Creation d'une classe Mapping qui aura pour attributs :

*  String className
*  String methodName

Dans FrontController :

- Enlever l'attribut boolean
- Créer un HashMap (String url, Mapping)
- init :

  - Faire les scans pour avoir les contrôleurs

  * Pour chaque contrôleur, prendre toutes les méthodes et voir s'il y a l'annotation GET
  * S'il y en a, créer un nouveau Mapping : (controller.name, method.name)
  * HashMap.associer(annotation.value, Mapping)
- ProcessRequest :

  - Prendre le Mapping associé au chemin URL de la requête
  - Si on trouve le Mapping associé, afficher le chemin URL et le Mapping
  - Sinon, afficher qu'il n'y a pas de méthode associée à ce chemin
