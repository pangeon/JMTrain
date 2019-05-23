SELECT default_character_set_name FROM information_schema.SCHEMATA 
WHERE schema_name = "jmtraindb";

SELECT CCSA.character_set_name FROM information_schema.`TABLES` T,
       information_schema.`COLLATION_CHARACTER_SET_APPLICABILITY` CCSA
WHERE CCSA.collation_name = T.table_collation
  AND T.table_schema = "jmtraindb"
  AND T.table_name = "profiles";

SELECT character_set_name FROM information_schema.`COLUMNS` 
WHERE table_schema = "jmtraindb"
  AND table_name = "profiles"
  AND column_name = "password";

SELECT SCHEMA_NAME 'jmtraindb', default_character_set_name 'charset', 
DEFAULT_COLLATION_NAME 'collation' FROM information_schema.SCHEMATA;