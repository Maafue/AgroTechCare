ALTER TABLE parts
    ADD CONSTRAINT chk_parts_price CHECK ( price >= 0 );
ALTER TABLE jobs
    ADD CONSTRAINT chk_jobs_norm_hours CHECK ( norm_hours >= 0 ),
    ADD CONSTRAINT chk_jobs_price CHECK ( price >= 0 )
