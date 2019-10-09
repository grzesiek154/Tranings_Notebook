create table app_users (birth_date date, height double precision not null, nickname varchar(255), weight double precision not null, user_id bigint not null, primary key (user_id)) engine=MyISAM
create table base_app_accounts (user_id bigint not null, email varchar(255), join_date date, name varchar(255), password varchar(255), role varchar(255), surname varchar(255), primary key (user_id)) engine=MyISAM
create table comments (comment_id bigint not null auto_increment, content varchar(255), create_date date, user_id bigint, post_id bigint, primary key (comment_id)) engine=MyISAM
create table exercises (exercise_id bigint not null, description varchar(255), name varchar(255), reps integer not null, time double precision not null, user_id bigint, primary key (exercise_id)) engine=MyISAM
create table exercises_categories (category_id bigint not null, description varchar(255), primary key (category_id)) engine=MyISAM
create table exercises_category (exercise_id bigint not null, category_id bigint not null, primary key (exercise_id, category_id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table notebook_trainings (notebook_id bigint not null, training_id bigint not null, primary key (notebook_id, training_id)) engine=MyISAM
create table notebooks (notebook_id bigint not null, name varchar(255), note varchar(255), user_id bigint not null, primary key (notebook_id)) engine=MyISAM
create table posts (post_id bigint not null auto_increment, content varchar(255), create_date date, title varchar(255), user_id bigint, primary key (post_id)) engine=MyISAM
create table trainers (specialization varchar(255), user_id bigint not null, primary key (user_id)) engine=MyISAM
create table training_category (training_id bigint not null, category_id bigint not null, primary key (training_id, category_id)) engine=MyISAM
create table training_exercises (training_id bigint not null, exercise_id bigint not null, primary key (training_id, exercise_id)) engine=MyISAM
create table trainings (training_id bigint not null, description varchar(255), name varchar(255), user_id bigint, primary key (training_id)) engine=MyISAM
create table trainings_categories (category_id bigint not null, description varchar(255), primary key (category_id)) engine=MyISAM
alter table app_users add constraint FKfmyaw57nnb9cr8uhved4x4fvd foreign key (user_id) references base_app_accounts (user_id)
alter table comments add constraint FKsonvwyu5d359o09tlu4hgldw foreign key (user_id) references base_app_accounts (user_id)
alter table comments add constraint FKh4c7lvsc298whoyd4w9ta25cr foreign key (post_id) references posts (post_id)
alter table exercises add constraint FKp3ogyaq5tim007xuup0igs5oj foreign key (user_id) references trainers (user_id)
alter table exercises_category add constraint FK5iktgpywpoyhsafm1hkqw0cdh foreign key (category_id) references exercises_categories (category_id)
alter table exercises_category add constraint FKqnquukmbaseuqkh0h4rukii7a foreign key (exercise_id) references exercises (exercise_id)
alter table notebook_trainings add constraint FK33ucaw60xw9dxxkh25v3bgtuh foreign key (training_id) references trainings (training_id)
alter table notebook_trainings add constraint FKk289m85jtuhr2i17qe2vl3wa9 foreign key (notebook_id) references notebooks (notebook_id)
alter table notebooks add constraint FK1150poofvke7y0pbuatowufvl foreign key (user_id) references app_users (user_id)
alter table posts add constraint FKfce3jxyct3ywv5qboqbjj9jaj foreign key (user_id) references trainers (user_id)
alter table trainers add constraint FK9e73r1rp3h02yypgcmpe2snxn foreign key (user_id) references base_app_accounts (user_id)
alter table training_category add constraint FKeij7jocdyg5yktw9v4jn2ayxh foreign key (category_id) references trainings_categories (category_id)
alter table training_category add constraint FK90ba6ipqocqyam2s3y0bbhkj4 foreign key (training_id) references trainings (training_id)
alter table training_exercises add constraint FKhm95na1ecc5p71wavk7hh7gqe foreign key (exercise_id) references exercises (exercise_id)
alter table training_exercises add constraint FK8191xq8pcgs2c7ed0m1uv0jjl foreign key (training_id) references trainings (training_id)
alter table trainings add constraint FKo7afeodpd1jvso4e963dcpqn3 foreign key (user_id) references trainers (user_id)
