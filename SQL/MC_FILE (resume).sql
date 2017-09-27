-- resume insert
INSERT INTO mc_file (file_id, table_div, table_id, seq, file_path, file_size, org_file_name, save_file_name, file_ext, reg_id, reg_dt)
     VALUES (SEQ_MC_FILE.NEXTVAL, 0, 0, 0, ?, ?, ?, ?, ?, ?, SYSDATE)
     
-- resume delete
DELETE mc_file WHERE reg_id=? AND table_div=0

--resume search
SELECT file_id, table_div, table_id, seq, file_path, file_size, org_file_name, save_file_name, file_ext, reg_id, reg_dt
  FROM mc_file
 WHERE reg_id = ? AND table_div = 0
 ORDER BY reg_dt DESC;
