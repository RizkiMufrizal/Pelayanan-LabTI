--
-- Copyright (C) 2016 Rizki Mufrizal (https://rizkimufrizal.github.io/) (mufrizalrizki@gmail.com)
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--         http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Jun 29, 2016
 * @Time 9:39:15 PM
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