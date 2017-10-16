INSERT INTO authority(id, name) VALUES (1 ,'ROLE_USER');
INSERT INTO authority(id, name) VALUES (2 ,'ROLE_ADMIN');

INSERT INTO UserAccount(id, enabled, lastPasswordResetDate, password, username)
VALUES (1, true, TIMESTAMP '2017-10-16 15:36:38', '$2a$10$4kVsoucDkPAP3l6sawt8eOr23q.Bivqg/uQx5c/S0e3YlorzRb0VC', 'admin');

INSERT INTO user_authority(user_id, authority_id) VALUES (1, 2);
