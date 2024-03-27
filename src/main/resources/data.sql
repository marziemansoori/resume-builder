insert into users(id, user_name, password, active, roles)
values (1, 'foo', 'foo', 'true', 'user'),
       (2, 'bar', 'bar', 'true', 'user');


insert into user_profile(id, user_name, theme, summary)
values (1, 'foo', 1, 'user name foo'),
       (2, 'bar', 2, 'user name bar');