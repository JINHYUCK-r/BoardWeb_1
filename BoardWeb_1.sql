create table t_user (
    i_user  int auto_increment primary key,
    user_id varchar(30) not null,
    user_pw varchar(100) not null,
    nm varchar(20) not null,
    email varchar(40),
    profile_img varchar(50),
    r_dt timestamp default now(),
    m_dt timestamp default now()
    );
    
drop table t_user;

insert into t_user(user_id,user_pw,nm) value("dfad","dafd","dafds");
select * from t_user;

select * from t_user;

ALTER TABLE t_user MODIFY COLUMN user_id varchar(30) UNIQUE;

insert into t_user (user_id,user_pw,nm) value("qwer1","11111","dd");
select * from t_user where user_id = "qwe1";