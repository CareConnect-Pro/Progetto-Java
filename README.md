**CareConnect Pro**

**Descrizione del Progetto**

CareConnect Pro è una piattaforma progettata per supportare la gestione del core clinico, all’interno delle Residenze Sanitarie Assistenziali (RSA).
Il sistema nasce dall’esigenza di superare le criticità legate all’utilizzo di supporti cartacei, migliorando la tracciabilità delle informazioni cliniche e riducendo il rischio di errori nella gestione quotidiana dei pazienti.
Il progetto non ha l’obiettivo di coprire l’intero dominio gestionale di una RSA, ma di fornire una base solida e coerente per la digitalizzazione dei processi clinici fondamentali, migliorando la continuità assistenziale, la sicurezza del paziente e garantendo un efficiente scambio di informazioni tra i membri del personale sanitario.

**Funzionalità Principali**

La versione attuale del sistema si concentra sulle operazioni cliniche essenziali:
Gestione Anagrafica: amministrazione centralizzata delle utenze, con possibilità di disabilitare profili mantenendo lo storico dei dati.
Sicurezza: autenticazione e controllo degli accessi con permessi differenziati in base al ruolo. L’accesso è consentito solo ad utenti abilitati. I profili disabilitati restano archiviati per garantire tracciabilità.
Cartella Clinica Digitale: creazione automatica della cartella clinica all’inserimento di un nuovo paziente.
Monitoraggi: registrazione puntuale dei parametri clinici e di osservazioni cliniche.
Generazione di Alert: generazione automatica di alert in presenza di valori critici rilevati nei monitoraggi.
Gestione e Risoluzione degli Alert: consultazione, valutazione e risoluzione degli alert con aggiornamento automatico della cartella clinica.

**Attori del Sistema**

CareConnect Pro è utilizzato dal personale della struttura sanitaria, secondo i seguenti ruoli:
Amministratore: gestisce le utenze, registrando nuovi utenti o disabilitando quelli esistenti, garantendo la tracciabilità dei dati.
Infermiere: registra i monitoraggi clinici e aggiorna le informazioni sullo stato di salute del paziente.
Medico: consulta gli alert generati dai monitoraggi, valuta le condizioni cliniche del paziente e aggiorna la cartella clinica tramite la prescrizione di terapie o la risoluzione degli alert.

**Architettura del Sistema**

L’applicazione è sviluppata in Java seguendo un’architettura a livelli, che separa la logica applicativa, la gestione dei dati e l’interazione con l’utente.
I primi due livelli sono strutturati secondo l’architettura MVC e il livello di persistenza è implementato utilizzando il pattern DAO.

**Tecnologie e Dipendenze**

Il progetto è stato sviluppato utilizzando le seguenti tecnologie:
Linguaggio: Java SE 21 (LTS)
Database: MySQL Workbench 8.0 CE
Modellazione: UML (Casi d’uso, diagrammi di classe e sequenza)
Librerie esterne: mysql-connector-j-8.x.x.jar (driver per la connessione al database MySQL

**Guida all’Installazione**

_Prerequisiti_

Java JDK 21 o superiore installato
MySQL Server (versione 8.0 o successiva)
Un IDE (consigliato Eclipse)
Configurazione del Database
Apri MySQL Workbench
Esegui lo script SQL contenuto nella cartella /db_script per creare lo schema e le tabelle necessarie.
Configurazione del Progetto
Clona la reporitory: https://github.com/CareConnect-Pro/Progetto-Java.git
Importa il progetto in Eclipse come “Java Project”
Gestione ClassPath: assicurati di aggiungere il file mysql-connector-j.jar alle librerie del progetto (Build Path > Configure Build Path > Libraries > Add External JARs).
Configura le credenziali di accesso al DB, facendo riferimento al file properties/db.properties
Avvio
Esegui la classe principale main situata nel package: src/it/unipv/posw/careconnectpro/view

**Testing**

Il corretto funzionamento del sistema è garantito dai test unitari sviluppati con JUnit.
I test si sono concentrati su:
Verifica delle funzionalità core;
Validazione dei flussi critici
Gestione di utilizzi errati delle funzionalità del sistema

**Struttura del repository**

La struttura del repository è organizzata per facilitare la consultazione del codice e della documentazione:
/src        → Codice sorgente organizzato in package
/docs       → Documentazione di progetto e diagrammi UML 
/db_script        → Script per la creazione e la popolazione del DB
/test      →  Suite di test JUnit

**Licenza**

Questo progetto è distribuito sotto Licenza MIT.

**Autori**

Progetto sviluppato a scopo didattico, nell’ambito del corso di Programmazione ad Oggetti e Ingegneria del Software da: Darlis Morillo Mendoza e Agnese Pinto.











