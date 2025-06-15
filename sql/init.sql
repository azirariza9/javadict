-- Drop tables if they exist
DROP TABLE IF EXISTS kata CASCADE;
DROP TABLE IF EXISTS entri CASCADE;
DROP TABLE IF EXISTS makna CASCADE;
DROP TABLE IF EXISTS kelas_makna CASCADE;
DROP TABLE IF EXISTS submakna CASCADE;
DROP TABLE IF EXISTS contoh CASCADE;
DROP TABLE IF EXISTS etimologi CASCADE;
DROP TABLE IF EXISTS kelas_etimologi CASCADE;
DROP TABLE IF EXISTS makna_etimologi CASCADE;
DROP TABLE IF EXISTS varian CASCADE;
DROP TABLE IF EXISTS bentuk_tak_baku CASCADE;
DROP TABLE IF EXISTS kata_turunan CASCADE;
DROP TABLE IF EXISTS gabungan_kataCASCADE;
DROP TABLE IF EXISTS idiom CASCADE;

-- Create tables
CREATE TABLE kata (
    id_kata VARCHAR(255) PRIMARY KEY,
    pranala VARCHAR(255) NOT NULL
);

create TABLE entri (
    id_entri SERIAL PRIMARY KEY,
    id_kata VARCHAR(255) REFERENCES kata(id_kata),
    nama VARCHAR(255) NOT NULL,
    nomor INT DEFAULT 0,
    pelafalan VARCHAR(255) DEFAULT ''
);


create TABLE makna (
    id_makna SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    info TEXT
);

create TABLE kelas_makna (
    id_kelas_makna SERIAL PRIMARY KEY,
    id_makna INT REFERENCES makna(id_makna),
    kode VARCHAR(255) DEFAULT '',
    nama VARCHAR(255) DEFAULT '',
    deskripsi VARCHAR(255) DEFAULT ''
);

create TABLE submakna (
    id_submakna SERIAL PRIMARY KEY,
    id_makna INT REFERENCES makna(id_makna),
    teks VARCHAR(255)
);

create TABLE contoh (
    id_contoh SERIAL PRIMARY KEY,
    id_makna INT REFERENCES makna(id_makna),
    teks VARCHAR(255)
);


create TABLE etimologi (
    id_etimologi SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    bahasa VARCHAR(255),
    asal_kata VARCHAR(255),
    pelafalan VARCHAR(255)
);

create TABLE kelas_etimologi (
    id_kelas_etimologi SERIAL PRIMARY KEY,
    id_etimologi INT REFERENCES etimologi(id_etimologi),
    kelas VARCHAR(255)
);

create TABLE makna_etimologi (
    id_makna_etimologi SERIAL PRIMARY KEY,
    id_etimologi INT REFERENCES etimologi(id_etimologi),
    makna VARCHAR(255)
);

create TABLE varian (
    id_varian SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    varian VARCHAR(255)
);

create TABLE bentuk_tak_baku (
    id_bentuk_tak_baku SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    kata VARCHAR(255)
);

create TABLE kata_turunan (
    id_kata_turunan SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    kata VARCHAR(255)
);

create TABLE gabungan_kata (
    id_gabungan_kata SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    kata VARCHAR(255)
);

create TABLE peribahasa (
    peribahasa SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    teks VARCHAR(255)
);

create TABLE idiom (
    idiom SERIAL PRIMARY KEY,
    id_entri INT REFERENCES entri(id_entri),
    teks VARCHAR(255)
);

