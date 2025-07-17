ALTER TABLE nama_table
    ADD COLUMN column_baru TEXT;
    DROP COLUMN nama_column;  
    RENAME COLUMN nama TO nama_baru;
    MODIFY nama_column2 tipedata(2) FIRST/AFTER nama_column1;  
    CHANGE _namaField_ _namaFieldBaru_ tipedata FIRST/AFTER;

<(======================= TAMBAHAN =======================)>

ALTER TABLE nama_table RENAME TO nama_baru;                    -- mengubah nama table