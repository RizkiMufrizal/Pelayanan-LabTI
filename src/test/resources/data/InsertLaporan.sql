/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 29, 2016
 * @Time 10:22:47 PM
 * @Encoding UTF-8
 * @Project Pelayanan-LabTI
 * @Package Expression package is undefined on line 8, column 15 in Templates/Other/SQLTemplate.sql.
 *
 */

/* pass : mufrizal */
INSERT INTO tb_user(username, password, enable)
VALUES('rizki mufrizal', '$2a$06$qEq4P7YGXy0TDu8./ayZ.uinq8Xj6B1JnqYoYlCMwvFdZCAqMXhNy', true);

INSERT INTO tb_user_role(id_user_role, role, username)
VALUES('1', 'ROLE_USER', 'rizki mufrizal');

/* pass : admin */
INSERT INTO tb_user(username, password, enable)
VALUES('admin', '$2a$06$z6.piH0Vj2XrqdoX.9Ibou/CuQ9.hYqViKesghQT53Zy1K9/eii0S', false);

INSERT INTO tb_user_role(id_user_role, role, username)
VALUES('2', 'ROLE_ADMIN', 'admin');

INSERT INTO tb_praktikum(id_praktikum, batas_jumlah_tidak_masuk, jumlah_pertemuan, nama_praktikum)
VALUES('1', 2, 7, 'Rekayasa Perangkat Lunak 2');

INSERT INTO tb_praktikum(id_praktikum, batas_jumlah_tidak_masuk, jumlah_pertemuan, nama_praktikum)
VALUES('2', 1, 4, 'Pemrograman Jaringan');

INSERT INTO tb_praktikum(id_praktikum, batas_jumlah_tidak_masuk, jumlah_pertemuan, nama_praktikum)
VALUES('3', 1, 4, 'Sistem Multimedia');

INSERT INTO tb_praktikum(id_praktikum, batas_jumlah_tidak_masuk, jumlah_pertemuan, nama_praktikum)
VALUES('4', 2, 7, 'Interaksi Manusia Dan Komputer');

INSERT INTO tb_praktikum(id_praktikum, batas_jumlah_tidak_masuk, jumlah_pertemuan, nama_praktikum)
VALUES('5', 2, 7, 'Sistem Basis Data 2');

INSERT INTO tb_laporan(id_laporan, npm, nama, kelas, tanggal_lapor, pertemuan, keterangan, id_praktikum, username)
VALUES('01', '58412085', 'rizki mufrizal', '4IA04', '2016-06-06', 1, 'izin', '1', 'admin');

INSERT INTO tb_laporan(id_laporan, npm, nama, kelas, tanggal_lapor, pertemuan, keterangan, id_praktikum, username)
VALUES('02', '58412081', 'rm', '3IA04', '2016-05-05', 5, 'izin', '4', 'rizki mufrizal');

INSERT INTO tb_laporan(id_laporan, npm, nama, kelas, tanggal_lapor, pertemuan, keterangan, id_praktikum, username)
VALUES('03', '58412085', 'rizki mufrizal', '4IA04', '2016-06-06', 2, 'izin', '1', 'admin');