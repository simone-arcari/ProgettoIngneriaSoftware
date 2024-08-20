// Bottoni principali dashboard
const btnRegistrazione = document.getElementById('btn-registrazione');
const btnRinnovo = document.getElementById('btn-rinnovo');
const btnDisiscrizione = document.getElementById('btn-disiscrizione');
const btnCalcoloRetta = document.getElementById('btn-calcolo-retta');
const btnStampaListe = document.getElementById('btn-stampa-liste');


// Botttoni annula
const btnAnnullaRegistrazione = document.getElementById('btn-annulla-registrazione');
const btnAnnullaRinnovo = document.getElementById('btn-annulla-rinnovo');
const btnAnnullaDisiscrizione = document.getElementById('btn-annulla-disiscrizione');
const btnAnnullaCalcoloRetta = document.getElementById('btn-annulla-calcolo-retta');
const btnAnnullaStampaListe = document.getElementById('btn-annulla-stampa-liste');
const btnAnnullaAcquisto = document.getElementById('btn-annulla-acquisto');


// Schermate
const dashboard = document.getElementById('dashboard');
const registrazione = document.getElementById('registrazione');
const rinnovo = document.getElementById('rinnovo');
const disiscrizione = document.getElementById('disiscrizione');
const calcoloRetta = document.getElementById('calcolo-retta');
const stampaListe = document.getElementById('stampa-liste');
const visualizzaLista = document.getElementById('visualizza-lista');
const confermaRegistrazione = document.getElementById('conferma-registrazione');
const erroreRegistrazione = document.getElementById('errore-registrazione');
const selezionaAttivita = document.getElementById('selezione-attivita');
const confermaAcquisto = document.getElementById('conferma-acquisto');
const erroreRinnovo = document.getElementById('errore-rinnovo');
const confermaDisiscrizione = document.getElementById('conferma-disiscrizione');
const erroreDisiscrizione = document.getElementById('errore-disiscrizione');
const warningMatricola = document.getElementById('warning-matricola');


// Bottone conferma stampa lista
const btnConfermaStampaListe = document.getElementById('btn-conferma-stampa-liste');

// Form
const formRegistrazione = document.getElementById('form-registrazione');
const formRinnovo = document.getElementById('form-rinnovo');
const formDisiscrizione = document.getElementById('form-disiscrizione');
const formCalcolaRetta = document.getElementById('form-calcolo-retta');


// Bottoni Fine
const btnFineConfermaRegistrazione = document.getElementById('btn-fine-conferma-registrazione');
const btnFineErroreRegistrazione = document.getElementById('btn-fine-errore-registrazione');
const btnFineConfermaAcquisto = document.getElementById('btn-fine-conferma-acquisto');
const btnFineErroreRinnovo = document.getElementById('btn-fine-errore-rinnovo');
const btnFineConfermaDisiscrizione = document.getElementById('btn-fine-conferma-disiscrizione');
const btnFineErroreDisiscrizione = document.getElementById('btn-fine-errore-disiscrizione');
const btnFineWarningMatricola = document.getElementById('btn-fine-warning-matricola');

// Bottoni "Torna Indietro"
const btnTornaIndietro = document.getElementById('btn-torna-indietro');

// Bottoni Seleziona Attività Sportive
const btnSelezionaAttivitaRegistrazione = document.getElementById('btn-seleziona-attivita-conferma-registrazione');

// Bottone Acquista
const btnAcquista = document.getElementById('btn-acquista');

// Bottone Prova Rinnovo
const btnProvaRinnovo = document.getElementById('btn-prova-rinnovo');



// Gestione del click su "Registrazione Nuovi Clienti"
btnRegistrazione.addEventListener('click', () => {
    dashboard.style.display = 'none';
    registrazione.style.display = 'block';

    window.javaBridge.prova();
});

// Gestione del click su "Rinnovo Abbonamenti"
btnRinnovo.addEventListener('click', () => {
    dashboard.style.display = 'none';
    rinnovo.style.display = 'block';
});

// Gestione del click su "Disiscrizione Attività Sportive"
btnDisiscrizione.addEventListener('click', () => {
    dashboard.style.display = 'none';
    disiscrizione.style.display = 'block';
});

// Gestione del click su "Calcolo Retta Mensile"
btnCalcoloRetta.addEventListener('click', () => {
    dashboard.style.display = 'none';
    calcoloRetta.style.display = 'block';
});

// Gestione del click su "Stampa Liste"
btnStampaListe.addEventListener('click', () => {
    dashboard.style.display = 'none';
    stampaListe.style.display = 'block';
});



// Gestione del click su "Annulla"
btnAnnullaRegistrazione.addEventListener('click', () => {
    registrazione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Annulla"
btnAnnullaRinnovo.addEventListener('click', () => {
    rinnovo.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Annulla"
btnAnnullaDisiscrizione.addEventListener('click', () => {
    disiscrizione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Annulla"
btnAnnullaCalcoloRetta.addEventListener('click', () => {
    calcoloRetta.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Annulla"
btnAnnullaStampaListe.addEventListener('click', () => {
    stampaListe.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Annulla"
btnAnnullaAcquisto.addEventListener('click', () => {
    selezionaAttivita.style.display = 'none';
    dashboard.style.display = 'block';
});



// Gestione del click su "Torna Indietro"
btnTornaIndietro.addEventListener('click', () => {
    visualizzaLista.style.display = 'none';
    stampaListe.style.display = 'block';
});

// Gestione del click su "Seleziona Attività Sportive"
btnSelezionaAttivitaRegistrazione.addEventListener('click', () => {
    confermaRegistrazione.style.display = 'none';
    selezionaAttivita.style.display = 'block';
});

// Gestione del click su "Acquista"
btnAcquista.addEventListener('click', () => {
    selezionaAttivita.style.display = 'none';
    confermaAcquisto.style.display = 'block';
});

// Gestione del click su "Prova Rinnovo"
btnProvaRinnovo.addEventListener('click', () => {
    erroreRegistrazione.style.display = 'none';
    rinnovo.style.display = 'block';
});





// Gestione del click su "Conferma" nella finestra Stampa Liste
btnConfermaStampaListe.addEventListener('click', () => {
    var titoloLista = document.getElementById('titolo-lista');
    var listaIscritti = document.getElementById('lista-iscritti');

    // Nascondiamo la finestra corrente
    stampaListe.style.display = 'none';

    // Mostriamo la finestra della lista
    visualizzaLista.style.display = 'block';

    // Determiniamo la lista scelta e aggiorniamo il titolo e gli elementi della lista
    let listaSelezionata;
    if (document.getElementById('lista1').checked)
    {
        listaSelezionata = "Lista Iscritti Nuoto";
    } 
    else if (document.getElementById('lista2').checked)
    {
        listaSelezionata = "Lista Iscritti Atletica Leggera";
    } 
    else if (document.getElementById('lista3').checked)
    {
        listaSelezionata = "Lista Iscritti BodyBuilding";
    }
    else
    {
        listaSelezionata = "Lista Generale Iscritti";
    }

    // Aggiorniamo il titolo della finestra
    titoloLista.textContent = listaSelezionata;

    // Aggiungiamo dinamicamente gli elementi alla lista (esempio statico)
    listaIscritti.innerHTML = ''; // Puliamo la lista
    const iscritti = ["Mario Rossi", "Luca Bianchi", "Giulia Verdi"]; // Questo sarà dinamico in seguito
    for (let i = 0; i < 30; i++) {
        
        iscritti.forEach((iscritto, index) => {
            const li = document.createElement('li');
            li.textContent = iscritto;
            li.id = `iscritto-${index}`;
            listaIscritti.appendChild(li);
        });
    }
});

// Gestione del click su "Conferma" nella finestra di registrazione
formRegistrazione.addEventListener('submit', (event) => {
    event.preventDefault(); // Previene l'invio del modulo

    registrazione.style.display = 'none';
    confermaRegistrazione.style.display = 'block';
    //erroreRegistrazione.style.display = 'block';
    //btnProvaRinnovo.style.display = 'none';
});

// Gestione del click su "Conferma" nella Rinnovo Abbonamenti
formRinnovo.addEventListener('submit', (event) => {
    event.preventDefault(); // Previene l'invio del modulo

    // Nasconde la finestra di registrazione e mostra la finestra di conferma
    rinnovo.style.display = 'none';
    //selezionaAttivita.style.display = 'block';
    erroreRinnovo.style.display = 'block';
});

// Gestione del click su "Conferma" nella Disiscrizione Attività Sportive
formDisiscrizione.addEventListener('submit', (event) => {
    event.preventDefault(); // Previene l'invio del modulo

    disiscrizione.style.display = 'none';
    confermaDisiscrizione.style.display = 'block';
    //erroreDisiscrizione.style.display = 'block';
});

formCalcolaRetta.addEventListener('submit', (event) => {
    event.preventDefault(); // Previene l'invio del modulo

    calcoloRetta.style.display = 'none';
    warningMatricola.style.display = 'block';
});


// Gestione del click su "Fine" nella finestra di conferma registrazione
btnFineConfermaRegistrazione.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    confermaRegistrazione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di errore registrazione
btnFineErroreRegistrazione.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    erroreRegistrazione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di conferma acquisto
btnFineConfermaAcquisto.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    confermaAcquisto.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di errore rinnovo
btnFineErroreRinnovo.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    erroreRinnovo.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di conferma disiscrizione
btnFineConfermaDisiscrizione.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    confermaDisiscrizione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di errore rinnovo
btnFineErroreDisiscrizione.addEventListener('click', () => {
    // Nasconde la finestra di conferma e mostra la dashboard
    erroreDisiscrizione.style.display = 'none';
    dashboard.style.display = 'block';
});

// Gestione del click su "Fine" nella finestra di warning matricola
btnFineWarningMatricola.addEventListener('click', () => {
    warningMatricola.style.display = 'none';
    calcoloRetta.style.display = 'block';
});