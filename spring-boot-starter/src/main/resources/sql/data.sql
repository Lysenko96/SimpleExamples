INSERT INTO public.chat
(id, "name")
VALUES(1, 'chat');

INSERT INTO public.company
(id, "name")
VALUES(1, 'Google');

INSERT INTO public.company_locales
(company_id, description, lang)
VALUES(1, 'desc', 'en');
INSERT INTO public.company_locales
(company_id, description, lang)
VALUES(1, 'desc2', 'ru');

INSERT INTO public.payment
(amount, id, receiver_id)
VALUES(1000, 1, 1);

INSERT INTO public.users
(company_id, birth_date, id, firstname, lastname, "role", username)
VALUES(1, '2000-02-02 00:00:00.000', 1, 'firstname', 'lastname', 'ADMIN', 'johndoe');
INSERT INTO public.users
(company_id, birth_date, id, firstname, lastname, "role", username)
VALUES(1, '1978-01-01 00:00:00.000', 2, 'apple', 'pie', 'USER', 'applesecond');

INSERT INTO public.users_chat
(chat_id, id, user_id)
VALUES(1, 1, 1);