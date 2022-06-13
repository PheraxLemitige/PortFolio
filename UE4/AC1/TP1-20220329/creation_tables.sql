DROP TABLE IF EXISTS Etudiants CASCADE;
DROP TABLE IF EXISTS Enseignants CASCADE;
DROP TABLE IF EXISTS Matieres CASCADE;
DROP TABLE IF EXISTS Modules CASCADE;
DROP TABLE IF EXISTS Epreuves CASCADE;
DROP TABLE IF EXISTS Avoir_note CASCADE;
DROP TABLE IF EXISTS Faire_cours CASCADE;
CREATE TABLE Etudiants (numetu INT NOT NULL, nometu VARCHAR, prenometu VARCHAR, adretu VARCHAR, viletu VARCHAR, cpetu INT, teletu VARCHAR, datentetu DATE, annetu INT, remetu VARCHAR, sexetu VARCHAR, datenaietu DATE, PRIMARY KEY (numetu) );
CREATE TABLE Enseignants (numens INT NOT NULL, nomens VARCHAR, preens VARCHAR, foncens VARCHAR, adrens VARCHAR, vilens VARCHAR, cpens INT, telens VARCHAR, datenaiens DATE, datembens DATE, PRIMARY KEY (numens) );
CREATE TABLE Matieres (nummat INT NOT NULL, nommat VARCHAR, nummod INT NOT NULL, coefmat INT, PRIMARY KEY (nummat) );
CREATE TABLE Modules (nummod INT NOT NULL, nommod VARCHAR, coefmod INT, PRIMARY KEY (nummod) );
CREATE TABLE Epreuves (numepr INT NOT NULL, libepr VARCHAR, ensepr INT NOT NULL, matepr INT NOT NULL, datepr DATE, coefepr INT, annepr INT, PRIMARY KEY (numepr) );
CREATE TABLE Avoir_note (numetu INT NOT NULL, numepr INT NOT NULL, note REAL, PRIMARY KEY (numetu,  numepr) );
CREATE TABLE Faire_cours (numens INT NOT NULL, nummat INT NOT NULL, annee INT, PRIMARY KEY (numens,  nummat, annee) );
ALTER TABLE Matieres ADD CONSTRAINT FK_Matieres_nummod FOREIGN KEY (nummod) REFERENCES Modules (nummod);
ALTER TABLE Epreuves ADD CONSTRAINT FK_Epreuves_numens FOREIGN KEY (ensepr) REFERENCES Enseignants (numens);
ALTER TABLE Epreuves ADD CONSTRAINT FK_Epreuves_nummat FOREIGN KEY (matepr) REFERENCES Matieres (nummat);
ALTER TABLE Avoir_note ADD CONSTRAINT FK_Avoir_note_numetu FOREIGN KEY (numetu) REFERENCES Etudiants (numetu);
ALTER TABLE Avoir_note ADD CONSTRAINT FK_Avoir_note_numepr FOREIGN KEY (numepr) REFERENCES Epreuves (numepr);
ALTER TABLE Faire_cours ADD CONSTRAINT FK_Faire_cours_numens FOREIGN KEY (numens) REFERENCES Enseignants (numens);
ALTER TABLE Faire_cours ADD CONSTRAINT FK_Faire_cours_nummat FOREIGN KEY (nummat) REFERENCES Matieres (nummat);


