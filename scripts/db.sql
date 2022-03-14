CREATE TABLE adres (
	adres_id SERIAL,
	il VARCHAR(50) NOT NULL,
	ilce VARCHAR(50) NOT NULL,
	mahalle VARCHAR(50),
	sokak VARCHAR(50),
	no INT,
	PRIMARY KEY(adres_id)
);

CREATE TABLE ortak (
	ortak_id SERIAL,
	adres_id INT,
	fiyat INT NOT NULL,
	boyut INT NOT NULL,
	aciklama VARCHAR(500),
	PRIMARY KEY (ortak_id),
	CONSTRAINT fk_adres
		FOREIGN KEY (adres_id)
			REFERENCES adres(adres_id)
			ON DELETE CASCADE	
);

CREATE TABLE kullanici (
	kullanici_adi VARCHAR(50) NOT NULL,
	isim VARCHAR(50) NOT NULL,
	soyisim VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	sifre VARCHAR(50) NOT NULL,
	tel_no VARCHAR(50) NOT NULL,
	PRIMARY KEY (kullanici_adi)
);

CREATE TABLE tarla (
	tarla_id SERIAL,
	ortak_id INT,
	kullanici_adi VARCHAR,
	tapu_durumu VARCHAR(50) NOT NULL,
	PRIMARY KEY (tarla_id),
	CONSTRAINT fk_ortak
		FOREIGN KEY (ortak_id)
			REFERENCES ortak(ortak_id)
			ON DELETE CASCADE,
	CONSTRAINT fk_kullanici
		FOREIGN KEY (kullanici_adi)
			REFERENCES kullanici(kullanici_adi)
			ON DELETE CASCADE
);

CREATE TABLE bahce (
	bahce_id SERIAL,
	ortak_id INT,
	kullanici_adi VARCHAR,
	tapu_durumu VARCHAR(50) NOT NULL,
	imar_durumu VARCHAR(50) NOT NULL,
	PRIMARY KEY (bahce_id),
	CONSTRAINT fk_ortak
		FOREIGN KEY (ortak_id)
			REFERENCES ortak(ortak_id)
			ON DELETE CASCADE,
	CONSTRAINT fk_kullanici
		FOREIGN KEY (kullanici_adi)
			REFERENCES kullanici(kullanici_adi)
			ON DELETE CASCADE
);

CREATE TABLE villa (
	villa_id SERIAL,
	ortak_id INT,
	kullanici_adi VARCHAR,
	kat_sayisi INT NOT NULL,
	oda_sayisi VARCHAR(5) NOT NULL,
	havuz VARCHAR(10) NOT NULL,
	PRIMARY KEY (villa_id),
	CONSTRAINT fk_ortak
		FOREIGN KEY (ortak_id)
			REFERENCES ortak(ortak_id)
			ON DELETE CASCADE,
	CONSTRAINT fk_kullanici
		FOREIGN KEY (kullanici_adi)
			REFERENCES kullanici(kullanici_adi)
			ON DELETE CASCADE
);

CREATE TABLE daire (
	daire_id SERIAL,
	ortak_id INT,
	kullanici_adi VARCHAR,
	oda_sayisi VARCHAR(5) NOT NULL,
	bina_yasi INT NOT NULL,
	isitma_tipi VARCHAR(20) NOT NULL,
	PRIMARY KEY (daire_id),
	CONSTRAINT fk_ortak
		FOREIGN KEY (ortak_id)
			REFERENCES ortak(ortak_id)
			ON DELETE CASCADE,
	CONSTRAINT fk_kullanici
		FOREIGN KEY (kullanici_adi)
			REFERENCES kullanici(kullanici_adi)
			ON DELETE CASCADE
);









































