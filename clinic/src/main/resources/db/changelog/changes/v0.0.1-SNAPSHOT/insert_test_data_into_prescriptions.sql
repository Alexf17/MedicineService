--liquibase formatted sql

--changeset liquibase:9

INSERT INTO prescriptions (prescription_id,medicine_id, doctor_id,user_id,exp_date,created_at,is_active )
VALUES
    (UNHEX('ac5c9927676f47142357f52cbb9b4a95'), UNHEX('ac5c8867676f4737931f052cbb9b4a84'),UNHEX('d1fd8b7990aa4f4aae0c8ae2069443e3'), UNHEX('ac5c9927676f47379357f52cbb9b4a95'),'2024-11-25 17:00:00','2023-11-25 17:00:00' ,true),
    (UNHEX('ac5c8867676f47541357f52cbb9b4a95'), UNHEX('b585b9c08b7f493fb3c39018d3f8773d'),UNHEX('d1fd8b7990aa4f4aae0c8ae2069443e3'), UNHEX('ac5c9927676f47379357f52cbb9b4a95'), '2024-11-25 17:00:00','2023-11-25 17:00:00', true)
