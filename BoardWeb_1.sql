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

select * from t_board;


drop table t_board;

create table t_board(
	i_board int auto_increment primary key,
    title varchar(100) not null,
    ctnt varchar(2000) not null,
    hits int default 0,
    i_user int not null,
    r_dt timestamp default now(),
    m_dt timestamp default now(),
    foreign key(i_user) references t_user(i_user) on delete cascade
); 
select * from t_board;

insert into t_board(title, ctnt,i_user) values("1","1",3);
select * from t_board;
insert into t_board(title, ctnt,i_user) values("2","2",3);
insert into t_board(title, ctnt,i_user) values("3","3",3);

select ceil(count(*)/5) from t_board;

select A.i_board, A.title, A.ctnt, A.hits, A.i_user,B.nm, A.r_dt, A.m_dt
				from t_board A
			inner join t_user B
				on A.i_user = B.i_user
				 order by i_board desc
				 limit 0,5;