create table if not exists app_user
(
    user_id   bigint auto_increment
        primary key,
    email     varchar(255) null,
    join_date date         null,
    name      varchar(255) null,
    password  varchar(255) null,
    surname   varchar(255) null
)
    engine = MyISAM;

create table if not exists calendar
(
    calendar_id bigint auto_increment
        primary key,
    month       varchar(255) null,
    year        int          null
)
    engine = MyISAM;

create table if not exists calendar_trainings
(
    calendar_id bigint not null,
    training_id bigint not null,
    primary key (calendar_id, training_id)
)
    engine = MyISAM;

create index FKcvmhmrgnyktv6p574bgv3s8rn
    on calendar_trainings (training_id);

create table if not exists comments
(
    comment_id  bigint auto_increment
        primary key,
    content     varchar(255) null,
    create_date date         null,
    user_id     bigint       null,
    post_id     bigint       null
)
    engine = MyISAM;

create index FKh4c7lvsc298whoyd4w9ta25cr
    on comments (post_id);

create index FKru7skheek9n3eyb2w65eayo4
    on comments (user_id);

create table if not exists exercises
(
    exercise_id bigint       not null
        primary key,
    description varchar(255) null,
    name        varchar(255) null,
    reps        int          null,
    duration    double       null
)
    engine = MyISAM;

create table if not exists hibernate_sequence
(
    next_val bigint null
)
    engine = MyISAM;

create table if not exists notebook_trainings
(
    notebook_id bigint not null,
    training_id bigint not null,
    primary key (notebook_id, training_id)
)
    engine = MyISAM;

create index FK33ucaw60xw9dxxkh25v3bgtuh
    on notebook_trainings (training_id);

create table if not exists notebooks
(
    notebook_id bigint auto_increment
        primary key,
    name        varchar(255) null,
    user_id     bigint       null,
    note        varchar(255) null
)
    engine = MyISAM;

create index FKk6uj99viqdk60bek2j0mfome8
    on notebooks (user_id);

create table if not exists posts
(
    post_id     bigint auto_increment
        primary key,
    content     varchar(255) null,
    create_date date         null,
    title       varchar(255) null,
    user_id     bigint       null
)
    engine = MyISAM;

create index FKfce3jxyct3ywv5qboqbjj9jaj
    on posts (user_id);

create table if not exists trainers
(
    specialization varchar(255) null,
    user_id        bigint       not null
        primary key
)
    engine = MyISAM;

create table if not exists training_exercises
(
    training_id bigint not null,
    exercise_id bigint not null,
    primary key (training_id, exercise_id)
)
    engine = MyISAM;

create index FKhm95na1ecc5p71wavk7hh7gqe
    on training_exercises (exercise_id);

create table if not exists trainings
(
    training_id bigint       not null
        primary key,
    description varchar(255) null,
    name        varchar(255) null
)
    engine = MyISAM;

create table if not exists user_role
(
    role_id      bigint       not null
        primary key,
    role         varchar(255) null,
    user_user_id bigint       null
)
    engine = MyISAM;

create index FK3norgtfbfpaxx6ye1hfnungjy
    on user_role (user_user_id);

create table if not exists users
(
    birth_date date   null,
    height     double null,
    weight     double null,
    user_id    bigint not null
        primary key
)
    engine = MyISAM;

create table if not exists users_calendars
(
    user_id     bigint not null,
    calendar_id bigint not null,
    primary key (user_id, calendar_id)
)
    engine = MyISAM;

create index FKf74qhkf2iuyxvpaqmjmxy43ja
    on users_calendars (calendar_id);


