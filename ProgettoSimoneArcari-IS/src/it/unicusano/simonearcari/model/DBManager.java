package it.unicusano.simonearcari.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.unicusano.simonearcari.SystemLog;

public class DBManager {
	
	private static DBManager instance;
	private Connection connection;
	private static String url = "jdbc:sqlite:dataBaseFile.db"; // Percorso del database
    
    // Costruttore
    private DBManager() {
    	SystemLog.println("DBManager : entered DBManager()");
    	
        try {
            // Registrazione del driver
            Class.forName("org.sqlite.JDBC");
            
            // Creazione della connessione
            connection = DriverManager.getConnection(url);
            
            // Creazione delle tabelle se non esistono
            createTables();
            
        } 
        catch (ClassNotFoundException e) {
            SystemLog.println("Driver not found: " + e.getMessage());
        } 
        catch (SQLException e) {
            SystemLog.println("Database connection error: " + e.getMessage());
        }
    }
    
    public static DBManager getInstance() {
    	SystemLog.println("DBManager : entered getInstance()");
    	
    	if (instance == null) {
    		instance = new DBManager();
    	}
    	return instance;
    }
    
    private void createTables() {
    	SystemLog.println("DBManager : entered createTables()");
    	
    	// Tabella Clienti
    	String query = "CREATE TABLE IF NOT EXISTS Clienti ("
    			+ "matricola INTEGER PRIMARY KEY, "
    			+ "nome TEXT, "
    			+ "cognome TEXT)";
    	
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.execute();
        } 
        catch (SQLException e) {
            SystemLog.println("Error creating the table Clienti: " + e.getMessage());
        }
        
        // Tabella AttivitaSportive
        query = "CREATE TABLE IF NOT EXISTS AttivitaSportive ("
        		+ "id INTEGER PRIMARY KEY, "
        		+ "nome TEXT,"
        		+ "prezzo DOUBLE)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.execute();
        }
        catch (SQLException e) {
            SystemLog.println("Error creating the table AttivitaSportive: " + e.getMessage());
        }
        
        // Tabella Abbonamenti
        query = "CREATE TABLE IF NOT EXISTS Abbonamenti ("
        		+ "matricola INTEGER, "
        		+ "attivita_id INTEGER, "
        		+ "PRIMARY KEY (matricola, attivita_id), "
        		+ "FOREIGN KEY (matricola) REFERENCES Clienti(matricola), "
        		+ "FOREIGN KEY (attivita_id) REFERENCES AttivitaSportive(id))";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.execute();
        } 
        catch (SQLException e) {
            SystemLog.println("Error creating Subscriptions table: " + e.getMessage());
        }
        
        
        
        // Verifica e inserimento righe in AttivitaSportive
        String selectQuery = "SELECT COUNT(*) FROM AttivitaSportive WHERE id IN (1, 2, 3)";
        try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
             ResultSet rs = selectStmt.executeQuery()) {
            if (rs.next() && rs.getInt(1) < 3) {
                // Inserisci le righe mancanti
                String insertQuery = "INSERT OR IGNORE INTO AttivitaSportive (id, nome, prezzo) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                    insertStmt.setInt(1, 1);
                    insertStmt.setString(2, "Nuoto");
                    insertStmt.setDouble(3, 29.99);
                    insertStmt.executeUpdate();

                    insertStmt.setInt(1, 2);
                    insertStmt.setString(2, "Atletica");
                    insertStmt.setDouble(3, 49.99);
                    insertStmt.executeUpdate();

                    insertStmt.setInt(1, 3);
                    insertStmt.setString(2, "Bodybuilding");
                    insertStmt.setDouble(3, 69.99);
                    insertStmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            SystemLog.println("Error verifying or inserting rows in AttivitaSportive: " + e.getMessage());
        }
        
    }

    // Metodo per inserire un utente
    public boolean insertCustomer(Integer matricola, String nome, String cognome) {
    	SystemLog.println("DBManager : entered insertCustomer()");
    	
        String query = "INSERT INTO Clienti (matricola, nome, cognome) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, matricola);
            stmt.setString(2, nome);
            stmt.setString(3, cognome);
            stmt.executeUpdate();
            SystemLog.println("OK entering customer: ");
            return true;
        }
        catch (SQLException e) {
            SystemLog.println("Error entering customer: " + e.getMessage());
            return false;
        }
    }

    // Metodo per inserire una nuova attività
    public boolean insertActivity(Integer idAttivita, String nomeAttivita, Double prezzo) {
    	SystemLog.println("DBManager : entered insertActivity()");
        
    	String query = "INSERT INTO AttivitaSportive (id, nome, prezzo) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	stmt.setInt(1, idAttivita);
            stmt.setString(2, nomeAttivita);
            stmt.setDouble(3, prezzo);
            stmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            SystemLog.println("Error while inserting activity: " + e.getMessage());
            return false;
        }
    }

    // Metodo per abbonare un utente ad un'attività
//    public boolean insertSubscription(int matricola, int attivitaId) {
//    	SystemLog.println("DBManager : entered insertSubscription()");
//    	
//        String query = "INSERT INTO Abbonamenti (matricola, attivita_id) VALUES (?, ?)";
//        
//        try (PreparedStatement stmt = connection.prepareStatement(query)) {
//            stmt.setInt(1, matricola);
//            stmt.setInt(2, attivitaId);
//            stmt.executeUpdate();
//            return true;
//        } 
//        catch (SQLException e) {
//            SystemLog.println("Error entering subscription: " + e.getMessage());
//            return false;
//        }
//    }

    // Metodo per ottenere i clienti
    public List<DBCustomer> getAllCustomers() {
    	SystemLog.println("DBManager : entered getAllCustomers()");
    	
    	List<DBCustomer> customers = new ArrayList<>();
        String query = "SELECT * FROM Clienti";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
        	
            while (rs.next()) {
                Integer matricola = rs.getInt("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                
                customers.add(new DBCustomer(matricola, nome, cognome));
                
                //SystemLog.println("Matricola: " + matricola + ", Nome: " + nome + ", Cognome: " + cognome);
            }
        } 
        catch (SQLException e) {
            SystemLog.println("Error getting costumers: " + e.getMessage());
            return null;
        }
        
        return customers;
    }
    
    // Metodo per ottenere tutte le attività sportive
    public List<DBActivity> getAllActivity() {
    	SystemLog.println("DBManager : entered getAllActivity()");
    	
    	List<DBActivity> activityList = new ArrayList<>();
        String query = "SELECT * FROM AttivitaSportive";
        
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
        	
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double prezzo = rs.getDouble("prezzo");
                
                activityList.add(new DBActivity(id, nome, prezzo));
                
                //SystemLog.println("Id: " + id + ", Nome: " + nome + ", Prezzo: " + prezzo);
            }
        } 
        catch (SQLException e) {
            SystemLog.println("Error getting activity: " + e.getMessage());
            return null;
        }
        
        return activityList;
    }

    // Metodo per ottenere tutte le attività di un utente
    public List<String> getSubscriptionByCustomer(Integer matricola) {
    	SystemLog.println("DBManager : entered getAllActivity()");
        
        List<String> activityList = new ArrayList<>();
        String query = "SELECT A.nome FROM Abbonamenti AS AB " +
                           "JOIN AttivitaSportive AS A ON AB.attivita_id = A.id " +
                           "WHERE AB.matricola = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, matricola);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String nomeAttivita = rs.getString("nome");
                    activityList.add(nomeAttivita);
                }
            }
        } 
        catch (SQLException e) {
            SystemLog.println("Error getting Activity for customer: " + e.getMessage());
            return null;
        }
        
        return activityList;
    }
    
    // Metodo per ottenere tutte le attività di un utente sottoforma di id attività
    public List<Integer> getSubscriptionIdByCustomer(Integer matricola) {
    	SystemLog.println("DBManager : entered getSubscriptionIdByCustomer()");
        
        List<Integer> activityList = new ArrayList<>();
        String query = "SELECT A.id FROM Abbonamenti AS AB " +
                           "JOIN AttivitaSportive AS A ON AB.attivita_id = A.id " +
                           "WHERE AB.matricola = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, matricola);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Integer idAttivita = rs.getInt("id");
                    activityList.add(idAttivita);
                }
            }
        } 
        catch (SQLException e) {
            SystemLog.println("Error getting Activity ID for customer: " + e.getMessage());
            return null;
        }
        
        return activityList;
    }

    // Metodo per ottenere tutti i clienti iscritti a una certa attività
    public List<DBCustomer> getCustomersByActivity(int attivitaId) {
    	SystemLog.println("DBManager : entered getCustomersByActivity()");
    	
        List<DBCustomer> customers = new ArrayList<>();
        
        String query = "SELECT U.matricola, U.nome, U.cognome FROM Abbonamenti AS AB " +
                           "JOIN Clienti AS U ON AB.matricola = U.matricola " +
                           "WHERE AB.attivita_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, attivitaId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Integer matricola = rs.getInt("matricola");
                    String nome = rs.getString("nome");
                    String cognome = rs.getString("cognome");
                    customers.add(new DBCustomer(matricola, nome, cognome));
                }
            }
        } catch (SQLException e) {
            SystemLog.println("Error getting costumers for the activity: " + e.getMessage());
            return null;
        }
        
        return customers;
    }

    // Metodo per ottenere tutti i clienti iscritti con un abbonamento
    public List<DBCustomer> getAllCustomersWithSubscription() {
    	SystemLog.println("DBManager : entered getAllCustomersWithSubscription()");
    	
        List<DBCustomer> customers = new ArrayList<>();
        
        String selectSQL = "SELECT DISTINCT U.matricola, U.nome, U.cognome FROM Clienti AS U " +
                           "JOIN Abbonamenti AS AB ON U.matricola = AB.matricola";
        
        try (PreparedStatement stmt = connection.prepareStatement(selectSQL);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Integer matricola = rs.getInt("matricola");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");
                customers.add(new DBCustomer(matricola, nome, cognome));
            }
        } catch (SQLException e) {
            SystemLog.println("Error getting subscription costumers: " + e.getMessage());
            return null;
        }
        
        return customers;
    }

    public void close() {
    	SystemLog.println("DBManager : entered close()");
    	
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                SystemLog.println("Database connection closed.");
            }
        } catch (SQLException e) {
            SystemLog.println("Error closing connection: " + e.getMessage());
        }
    }

	public boolean doesMatricolaExist(Integer matricola) {
		SystemLog.println("DBManager : entered doesMatricolaExist()");
		
		String checkQuery = "SELECT COUNT(*) FROM Clienti WHERE matricola = ?";
		    
		try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
			checkStmt.setInt(1, matricola);
			ResultSet rs = checkStmt.executeQuery();
			
			if (rs.next() && rs.getInt(1) > 0) {
				return true; // La matricola esiste
			}
		} catch (SQLException e) {
			SystemLog.println("Error checking serial number: " + e.getMessage());
		}
		
		return false; // La matricola non esiste o si è verificato un errore
	}


	public void insertSubscription(Integer matricola, Integer attivitaId) {
		SystemLog.println("DBManager : entered insertSubscription()");
		
		String selectQuery = "SELECT COUNT(*) FROM Abbonamenti WHERE matricola = ? AND attivita_id = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setInt(1, matricola);
	        selectStmt.setInt(2, attivitaId);
	        
	        try (ResultSet rs = selectStmt.executeQuery()) {
	            if (rs.next() && rs.getInt(1) == 0) {
	            	
	                // Inserisci solo se non esiste
	                String insertQuery = "INSERT INTO Abbonamenti (matricola, attivita_id) VALUES (?, ?)";
	                try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
	                    insertStmt.setInt(1, matricola);
	                    insertStmt.setInt(2, attivitaId);
	                    insertStmt.executeUpdate();	             
	                }
	            }
	        }
	    } catch (SQLException e) {
	        SystemLog.println("Error during the insertion process: " + e.getMessage());
	    }
	}

	public void deleteSubscription(Integer matricola, Integer attivitaId) {
	    SystemLog.println("DBManager : entered deleteSubscription()");

	    String selectQuery = "SELECT COUNT(*) FROM Abbonamenti WHERE matricola = ? AND attivita_id = ?";
	    try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
	        selectStmt.setInt(1, matricola);
	        selectStmt.setInt(2, attivitaId);
	        
	        try (ResultSet rs = selectStmt.executeQuery()) {
	            if (rs.next() && rs.getInt(1) > 0) {
	                // Procedi con l'eliminazione solo se esiste
	                String deleteQuery = "DELETE FROM Abbonamenti WHERE matricola = ? AND attivita_id = ?";
	                try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
	                    deleteStmt.setInt(1, matricola);
	                    deleteStmt.setInt(2, attivitaId);
	                    int rowsAffected = deleteStmt.executeUpdate();
	                    
	                    if (rowsAffected > 0) {
	                        SystemLog.println("Abbonamento eliminato con successo.");
	                    } else {
	                        SystemLog.println("Nessun abbonamento trovato per eliminare.");
	                    }
	                }
	            } else {
	                SystemLog.println("Nessun abbonamento trovato con matricola " + matricola + " e attivita_id " + attivitaId + ".");
	            }
	        }
	    } catch (SQLException e) {
	        SystemLog.println("Error during the deletion process: " + e.getMessage());
	    }
	}
}

