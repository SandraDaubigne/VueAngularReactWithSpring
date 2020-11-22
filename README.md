# Dokumentation Projekt jämföra ramverk

##### Dokumentationen består av följande delar: 
* [Syfte](#syfte)
* [Förklaringar förkortningar](#förklaringar-förkortningar)
* [Programmets funktion](#programmets-funktion)
* [Miljöspecifikation](#miljöspecifikation)
* [Jämförelse ramverk](#jämförelse-ramverk)
* [Setup av arbetsmiljö](#setup-för-arbetsmiljö)

## Syfte
Jag har under min LIA period på Sopra Steria under hösten 2020 som en del av min utbildning javautvecklare på 
Teknikhögskolan i Göteborg fått följande uppdrag: 

* Jämföra de tre största frontendramverken Vue, React och Angular med varandra. 

Syfte med detta projekt är att jämföra de 3 största frontend ramverkets fördelar och nackdelar i användarupplevelse från ett backend perspektiv.

Fokuset i detta projektet har varit att utvärdera hur enkelt vs svårt det har varit att sätta upp ett frontend till en befintlig backendkod. 

Bedömningen har skett av egna användarupplevelser gällande huruvida dessa delar har varit enkla eller svåra.
De har bedömts utifrån egna upplevelser av mig som systemutvecklare(java) med viss webb utvecklarbakgrund och baserats på följande delar: 

* Setup - Att installera /starta upp ramverket
* Språk - Att använda ramverkets implicita språk
* Typsäkert - Att skriva typsäkert i ramverket

##### Förklaringar förkortningar:
* **NPM** - Node Package Manager, tar in ramverket lokalt på datorn genom att ange vissa kommandon i terminalen. 
* **CDN** - Content Delivery Network, en url som tas in i script-tagg i .html filen och förser projektet med ramverket från annan server än din egen. 
* **JSX** - JavaScript XML, ett tillägg i JavaScript för att kunna skriva html liknande taggar direkt inne i JavaScript.
* **XSS** - Cross Site Scripting, potentiella säkerthetshål i hmtl där script skickas in i html taggar från browsern. 


## Programmets funktion: 
* Backendkoden består av en blogg som ska leverera en lista av bloggar med namn och beskrivning till klienten. 
* De tre olika frontenramverken skickar http request till backend och mottar respons från APIet och förser klienten med listan. 

#### Klass-specifikationer
* **Topic** är POJO klass som fungerar som Entity mot Hibernate.
* **TopicService** är Model klassen som hanterar all Business Logic.
* **TopicRepository** tar in CrudRepository från Hibernate och ger min färdiga metoder till Entiteter, att använda i TopicService-klassen. 
* **TopicController** är controller klassen som blir dispatcherservlet åt Tomcat och som håller mina Mapper handlers som hanterar inkommande Request och responser från frontendramverket. 

## Miljöspecifikation

### Backend-miljön
Jag har använt mig av 
IDE - IntelliJ IDEA 
Med Maven för att få pom.xml fil
pom.xml filen tillåter mig att hämta hem dependencies direkt från [Maven repository](https://mvnrepository.com/). 

### Frontend-miljön
* Till Vue och React har jag använt mig av Spring Ramverket med Thymeleaf och index.html fil där jag har skrivit all html och JavaScript och tagit in ramverken med [CDN](#förklaringar-förkortningar).
* Till Angular har jag använt mig av Visual Studio Code och tagit in ramverket som [NPM](#förklaringar-förkortningar). 

## Jämförelse ramverk
### Bedömning Vue
* **Setup** Vue kan installeras genom både [CDN](#förklaringar-förkortningar) och [NPM](#förklaringar-förkortningar), vilket gjorde det enkelt att starta utan lokal installation.
Jag använde mig av [CDN](#förklaringar-förkortningar) vilket innebar att jag kunde använda mig direkt av Springramverket och fortsätta på det befintliga backendprojektet med min frontend. Det enda tillägget som behövdes var [thymeleaf](#thymeleaf) i pom.xl filen. 
* **Språk** Vue var enkelt att användas då det bestod av Vanilla JavaScript.
* **Typsäkert** Vue använder implicit ett Javascript Bibliotek som inte är typsäkert, men Vue kan användas även med TypeScript som är Typsäkert, dock blir detta svårare än det implicita språket då det kräver mera installationer. 

### Bedömning React
* **Setup** Vue kan installeras genom både [CDN](#förklaringar-förkortningar) och [NPM](#förklaringar-förkortningar), vilket gjorde det enkelt att starta utan lokal installation. 
Jag använde mig av [CDN](#förklaringar-förkortningar) vilket innebar att jag kunde använda mig direkt av Springramverket och fortsätta på det befintliga backendprojektet med min frontend. Det enda tillägget som behövdes var [thymeleaf](#thymeleaf) i pom.xl filen. 
* **Språk** React använder endast JavaScript ES6 och behövde därför använda Babel för att kompileras, detta gjorde det lite svårare. De använder dessutom ofta ett tillägg till JavaScript, [JSX](#förklaringar-förkortningar). Detta förhindrar dock [XXS](#förklaringar-förkortningar). 
* **Typsäkert** React använder implicit ett Javascript Bibliotek som inte är typsäkert, men React kan användas även med TypeScript som är Typsäkert, dock blir detta svårare än det implicita då det kräver mera installationer.

### Bedömning Angular
* **Setup** Det var det svåraste ramverket att sätta upp då det bara går att använda lokalt med [NPM](#förklaringar-förkortningar), vilket innebar att jag inte längre kunde använda mig av min Springapplikations backend längre, utan jag fick dela upp frontend och backend i två olika projekt. 
* **Språk** Angular använder TypeScript det var för en backendutvecklare enklare att förstå än vanlig JavaScript.
* **Typsäkert** Angular använder implicit TypeScript, en extension JavaScript. TypeScript är ett typsäkert språk så det var lätt att göra koden typsäker. 

## Setup för arbetsmiljö

### Backend: 

#### Skapa ett nytt projekt i IntelliJ med med Spring Initializer:
* Välj Web
* Välj Spring web (För tomcat webserver)
* Välj SQL
* Välj Spring Data JPA (För hibernate)

#### Lägg till följande dependencies i pom.xml filen: 

* MySQL connector
```
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
```

* Lägg till följande databaskoppling i application.properties (under resourses)
* Databasens namn är topic, byt mot din egna databas namn. 
```
spring.datasource.url=jdbc:mysql://localhost:3306/topic?useSSL=false&serverTimezone=UTC

spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

### Frontend

#### Lägg till följande dependencies i pom.xml filen: 

##### Thymeleaf:
Med följande tillägg i pom.xml - filen
* Thymeleaf ( för rendering av view såsom index.html filen) 
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```

#### Installera Vue - CDN
Lägg dessa i index.html filen som du skapar under resourses i Spring projektet. 
```
<script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
```

#### Installera Vue - NPM
* Först behöver du ha laddat ner Node.js till din dator.
* Skapa en mapp på skrivbordet och öppna den i Visual Studio Code
* Öppna en ny terminal och kör följande kommandon: 
* (app är namnet på projektet och kan bytas ut till det som passar dig.)
```
npm install -g @vue/cli
vue create app
cd app
npm run serve
```

#### Installera React - CDN
Lägg dessa i index.html filen som du skapar under resourses i Spring projektet. 
```
<script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>
```
#### Installera React - NPM
* Först behöver du ha laddat ner Node.js till din dator.
* Skapa en mapp på skrivbordet och öppna den i Visual Studio Code
* Öppna en ny terminal och kör följande kommandon: 
* (my-app är namnet på projektet och kan bytas ut till det som passar dig.)
```
npx create-react-app my-app
cd my-app
npm start
```
#### Installera Angular - NPM
**Angular kan bara användas med NPM**

* Först behöver du ha laddat ner Node.js till din dator.
* Skapa en mapp på skrivbordet och öppna den i Visual Studio Code
* Öppna en ny terminal och kör följande kommandon: 
* (my-app är namnet på projektet och kan bytas ut till det som passar dig.)

```
npm install -g @angular/cli
ng new app
cd app
ng serve

```

//Tack för din läsning, Sandra








