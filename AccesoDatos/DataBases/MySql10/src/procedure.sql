DELIMITER //
CREATE PROCEDURE AuditarEmpleados(numDepart int, OUT salMedio float, OUT numEmples float)
BEGIN
DECLARE cont int;
DECLARE cont1 int;

SET cont = (SELECT count(*) from departamentos where dept_no = numDepart);
SET cont1 = (select count(*)
		from departamentos
        where NOT EXISTS
					(Select *
					from empleados
					where departamentos.dept_no = empleados.dept_no));

if cont = 0 then
	SET salMedio = -1;
    SET numEmples = 0;
elseif cont1 > 0 then
	SET salMedio = 0;
	SET numEmples = 0;
else
	SELECT count(*) ,avg(salario) into numEmples, salMedio
	from empleados
	where dept_no = numDepart; 
END IF;

END;
//