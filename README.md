# Dokumentation Projekt jämföra ramverk

##### Dokumentationen består av följande delar: 
* [Ramverk](#jämnförelse-Ramverk)
* [Programmets funktion](#programmets-funktion)
* [Miljöspecifikation](#miljöspecifikation)
* [Setup av arbetsmiljö](#setup-för-arbetsmiljö)

##### Förklaringar förkortningar:
* **NPM** - Node Package Maneger, tar in ramverket lokalt på datorn genom att ange vissa kommandon i terminalen. 
* **CDN** - Content Delivery Network, en url som tas in i scriptfil i .html filen och förser projektet med ramverket från annan server än din egen. 
* **JSX** - JavaScript XML Ett tillägg i JavaScript för att kunna skriva html liknande taggar direkt inne i JavaScript
* **XSS** - Cross Site Scripting, ett säkerthetshål i hmtl där script skickas in i html taggar. 

## Jämnförelse Ramverk:
Jag har under min LIA period på Sopra Steria under hösten 2020 som en del av min utbildning javautvecklare på 
Teknikhögskolan i Göteborg fått följande uppdrag: 

#### Jämföra de 3 största JavaScript ramverken Vue, React och Angular med varandra. 

Syfte med detta projekt är att jämföra de 3 största frontend ramverkets fördelar och nackdelar i användarupplevelse från ett backend perspektiv.

Fokuset i detta projektet har varit att utvärdera hur enkelt det har varit att sätta upp ett frontend till sin befintliga backendkod. 

Bedömningen har skett av egna användarupplevelser gällande huruvida dessa delar har varit enkla eller svåra.
De har bedömts utifrån egna upplevelser av mig som systemutvecklare(java) med viss webb utvecklarbakgrund och baserats på följande delar: 

* Setup - Att installera /starta upp ramverket
* Språk - Att använda ramverkets implicita språk
* Typsäkert - Att skriva typsäkert i ramverket

## Programmets funktion: 
* Backendkoden består av en blogg som ska leverera en lista av bloggar med namn och beskrivning till klienten. 
* De tre olika frontenramverken skickar http request till backend och mottar respons från APIet.

#### Klass-specifikationer
* **Topic** är min POJO klass som fungerar som Entity mot Hibernate.
* **TopicService** är Model klassen som hanterar all Business Logic.
* **TopicRepository** tar in CrudRepository från Hibernate och ger min färdiga metoder till Entiteter, att använda i TopicService-klassen. 
* **TopicController** är controller klassen som blir dispatcherservlet åt Tomcat och som håller mina Mapper handlers som hanterar inkommande Request och responser från http protokollet. 

### Bedömning Vue
* **Setup** Vue kan användas genom både [CDN](#förklaringar-förkortningar) och [NPM](#npm) vilket gjorde det enkelt att starta utan lokal installation.
* **Språk** Vue var enkelt att användas då det bestod av Vanilla JavaScript.
* **Typsäkert** React använder ett Javascript Bibliotek som inte är typsäkert. 

### Bedömning React
* **Setup** Vue kan användas genom både [CDN](#cdn) och [NPM](#npm) vilket gjorde det enkelt att starta utan lokal installation.
* **Språk** React använder endast JavaScript ES6 och behövde därför använda Babel för att kompileras, detta gjorde det lite svårare. De använder dessutom ofta ett tillägg till JavaScript, JSX. Detta förhindrar dock XXS. 
* **Typsäkert** React använder ett Javascript Bibliotek som inte är typsäkert. 

### Bedömning Angular
* **Setup** Det var det svåraste att sätta upp då det bara går att använda lokalt. 
* **Språk** Angular använder TypeScript det var för en backendutvecklare enklare att förstå än vanlig 
* **Typsäkert** TypeScript är typsäkert

## Miljöspecifikation

### Backend
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
### Frontend-miljön
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








