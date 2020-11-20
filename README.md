# Dokumentation Projekt jämföra ramverk

Dokumentationen består av följande delar: 
* Jämnförelse Ramverk
* Programmets funktion
* Miljöspecifikation
* Setup av arbetsmiljö

## Jämnförelse Ramverk:
Jag har under min LIA period på Sopra Steria under hösten 2020 som en del av min utbildning javautvecklare på 
Teknikhögskolan i Göteborg fått följande uppdrag: 

#### Jämföra de 3 största JavaScript ramverken Vue, React och Angular med varandra. 

Syfte med detta projekt är att jämföra de 3 största frontend ramverkets fördelar och nackdelar i användarupplevelse från ett backend perspektiv, för eventuella framtida projekt. 

Fokuset i detta projektet har varit att utvärdera hur enkelt det har varit att sätta upp ett frontend till sin befintliga backendkod. 

Bedömningen har skett av egna användarupplevelser gällande huruvida dessa delar har varit enkla eller svåra.
De har bedömts utifrån egna upplevelser av mig som systemutvecklare(java) med viss webb utvecklarbakgrund och baserats på följande delar: 

* Setup 
* Att använda det språk ramverket efterfrågar
* Att skriva Typsäkert
* Att få tag på dokumentation kring ramverket

## Programmets funktion: 
Backendkoden består av en blogg som ska leverera en lista av bloggar med namn och beskrivning till klienten. Listan sparas i MySql databas och hämtas genom Rest API. Det är detta frontend avser att göra i detta fall med hjälp av 3 av de största ramverken. 

#### Klass-specifikationer
* **Topic** är min POJO klass som fungerar som Entity mot Hibernate.
* **TopicService** är Model klassen som hanterar all Business Logic.
* **TopicRepository** tar in CrudRepository från Hibernate och ger min färdiga metoder till Entiteter, att använda i TopicService-klassen. 
* **TopicController** är controller klassen som blir dispatcherservlet åt Tomcat och som håller mina Mapper handlers som hanterar inkommande Request och responser från http protokollet. 


### Bedömning Vue
* **Setup** Vue kan användas utan att importera NPM lokalt genom script i html filen. Detta gjorde det enkelt att använda. 
* **Språk** Vue var enkelt att användas då det bestod av Vanilla JS
* **Typsäkert** React använder ett Javascript Bibliotek som inte är typsäkert. 
* **Dokumentation** Det var lätt att hitta information om Vue

### Bedömning React
* **Setup** React kan användas utan att importera NPM lokalt genom script i html filen. Detta gjorde det enkelt att använda. 
* **Språk** React använder endast ES6 och behövde därför använda babel för att kompileras, detta gjorde det lite svårare. De använder dessutom ofta ett JSX tillägg för att kunna skriva html liknande taggar inne i JavaScripten. Detta var svårt att få till men bra för att de förhindrade XSS i koden och gjorde koden säkrare. 
* **Typsäkert** React använder ett Javascript Bibliotek som inte är typsäkert. 
* **Dokumentation** Det var svårare att få tag i dokumentation kring React.

### Bedömning Angular
* **Setup** Det var det svåraste att sätta upp då det bara går att använda lokalt. 
* **Språk** Angular använder TypeScript det var för en backendutvecklare enklare att förstå än vanlig 
* **Typsäkert** TypeScript är typsäkert
* **Dokumentation** Det var lättare att få dokumentation av TypeScript ä om Angular ramverket, men de använder TS så mycket i koden så det var ändå lätt att följa med. 

## Miljöspecifikation

#### Backend-miljön
Jag har använt mig av 
IntelliJ IDEA For Spring applikation JavaEE

Med följande tillägg i Spring Initializer Maven projekt
* Spring MVC (För TomCat web server samt Dispatcherservlet) 
* Spring Data JDBC (För SQL DB Connection)
* Spring Data JPA (för Hibernate)

Med följande tillägg i pom.xml - filen
* Thymeleaf ( för rendering av view såsom index.html filen) 
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```
#### Frontend-miljön
* Till Vue och React har jag använt mig av Spring Ramverket med Thymeleaf och index.html fil där jag har skrivit all html och JavaScript och tagit in ramverken med CDN 
* Till Angular har jag använt mig av Visual Studio Code och tagit in ramverket som NPM.


## Setup för arbetsmiljö

#### Setup IntelliJ
Skapa ett nytt projekt
Välj Spring Initializr
Välj lämplig Artifact
Välj Dependencies: 
```
Web -> spring Web
SQL -> Spring Data JDBC  samt Spring Data JPA
```
Välj lämpligt projektnamn

Jag lägger till maven dependency thymeleaf för att kunna rendera view
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

#### Installera Vue - CDN
Lägg dessa i index.html filen som du skapar under resourses i Spring projektet. 
```
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
```
#### Installera React
Lägg dessa i index.html filen som du skapar under resourses i Spring projektet. 
```
<script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>
```

#### Installera Angular
För att kunna använda NPM behöver du först installera node.js på din enhet. Med den installationen kommer NPM med, det är ett verktyg för att kunna hantera Node.Packages. 

Angular kan inte använda CDN vilket gjorde att jag fattade beslutet att göra två applikationer. En för Frontend och en för Backend. 

Jag har gjort en mapp innan inne i Angular Mappen, som heter Frontend. 
Öppna Frontend mappen i VS terminalen och ange följande kommandon:

```
npm install -g @angular/cli
ng new app
cd app
ng serve

```
Öppna localhost:4200 och där är nu din frontend app. 








