# Variabili per riutilizzare facilmente i percorsi
MODULE_PATH = javafx-sdk-22.0.2/lib
MODULES = javafx.controls,javafx.web

# Target per compilare il codice Java
compile:
	javac --module-path $(MODULE_PATH) --add-modules $(MODULES) prova/Applicazione.java

# Target per eseguire il programma Java
run: compile
	java --module-path $(MODULE_PATH) --add-modules $(MODULES) prova.Applicazione

# Target per pulire i file .class generati durante la compilazione
clean:
	rm -f prova/*.class
