CLS

@ECHO OFF
ECHO Running database setup for protExpress...............

SET hostname=%1
SET port=%2
SET dbname=%3
SET dbusername=%4
SET sqlfilename=%5
SET outfilename=%6

ECHO Database Server Name is: %hostname%
ECHO Port Number is: %port%
ECHO Database Name is: %dbname%
ECHO Datbase User Name is: %dbusername%
ECHO SQL Script File Name is: %sqlfilename%
ECHO Output File Name is: %outfilename%

ECHO Executing the command:
ECHO               "psql -h %hostname% -p %port% %dbname% %dbusername% < %sqlfilename% > %outfilename%"

psql -h %hostname% -p %port% %dbname% %dbusername% < %sqlfilename% > %outfilename%

ECHO The database creation script has been executed. Please check the output file '%outfilename%' for any errors.

@ECHO ON
