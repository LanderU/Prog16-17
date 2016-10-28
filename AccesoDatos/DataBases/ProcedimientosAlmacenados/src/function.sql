DELIMITER //
CREATE FUNCTION findDepartamentoName(num int) RETURNS VARCHAR(15)
BEGIN
DECLARE nom VARCHAR(15);
DECLARE cont int;

SET cont = (SELECT count(*) from departamentos where dept_no = num);

if (cont = 0)then
	SET nom = 'INEXISTENTE';
else
	SET nom = 'EXISTENTE';
END IF;

return nom;

END;
//
